public class Game
{
    public ArrayList<Tile> tiles;
    public HashMap<Integer, TileSet> numValueMap;
    public HashMap<TileSet, Integer> valueNumMap; // quick, hacky way to do bi-directional map for now
  
    public Game()
    {
        tiles = new ArrayList<Tile>();
        numValueMap = Map.ofEntries(
            entry(1, TileValue.ONE),
            entry(2, TileValue.TWO),
            entry(3, TileValue.THREE),
            entry(4, TileValue.FOUR),
            entry(5, TileValue.FIVE),
            entry(6, TileValue.SIX),
            entry(7, TileValue.SEVEN),
            entry(8, TileValue.EIGHT),
            entry(9, TileValue.NINE),
        );
        valueNumMap = Map.ofEntries(
            entry(TileValue.ONE, 1),
            entry(TileValue.TWO, 2),
            entry(TileValue.THREE, 3),
            entry(TileValue.FOUR, 4),
            entry(TileValue.FIVE, 5),
            entry(TileValue.SIX, 6),
            entry(TileValue.SEVEN, 7),
            entry(TileValue.EIGHT, 8),
            entry(TileValue.NINE, 9)
        );
        
        init();
    }
  
    private void genTiles()
    {
        for (int i = 0; i < 4; i++)
        {
        
            // suits
            for (int j = 0; j < 9; j++)
            {
                tiles.add(new Tile(TileSet.TEN_THOUSAND, numValueMap.get(j+1)));
                tiles.add(new Tile(TileSet.CIRCLE, numValueMap.get(j+1)));
                tiles.add(new Tile(TileSet.STICKS, numValueMap.get(j+1)));
            }
        
            // honors
            tiles.add(new Tile(TileSet.WINDS, TileValue.EAST));
            tiles.add(new Tile(TileSet.WINDS, TileValue.SOUTH));
            tiles.add(new Tile(TileSet.WINDS, TileValue.WEST));
            tiles.add(new Tile(TileSet.WINDS, TileValue.NORTH));
            tiles.add(new Tile(TileSet.DRAGONS, TileValue.RED));
            tiles.add(new Tile(TileSet.DRAGONS, TileValue.GREEN));
            tiles.add(new Tile(TileSet.DRAGONS, TileValue.WHITE));
        
        }
        
        // bonus
        tiles.add(new Tile(TileSet.FLOWERS, TileValue.PLUM_BLOSSOM));
        tiles.add(new Tile(TileSet.FLOWERS, TileValue.ORCHID));
        tiles.add(new Tile(TileSet.FLOWERS, TileValue.CHRYSANTHEMUM));
        tiles.add(new Tile(TileSet.FLOWERS, TileValue.BAMBOO));
        tiles.add(new Tile(TileSet.SEASONS, TileValue.SPRING));
        tiles.add(new Tile(TileSet.SEASONS, TileValue.SUMMER));
        tiles.add(new Tile(TileSet.SEASONS, TileValue.AUTUMN));
        tiles.add(new Tile(TileSet.SEASONS, TileValue.WINTER));
        
        // shuffle tiles
        Collections.shuffle(tiles);
    }
  
    private void init()
    {
        genTiles();
    }
    
    private Boolean isTripleSequence(List<Tile> tiles)
    {
        // check if size is 3
        if (tiles.size() != 3) { return False; }
        
        // check it is same suit
        for (int i = 0; i < tiles.size()-1; i++)
        {
            if (tiles.get(i).getSet() != tiles.get(i+1).getSet()) { return False; }
        }
        
        // check that it is suit that is sequence-able
        TileSet thisSet = tiles.get(0).getSet();
        if (thisSet != TileSet.TEN_THOUSAND || thisSet != TileSet.CIRCLE || thisSet != TileSet.STICKS) { return False; }
        
        // verify sequence
        Collections.sort(tiles);
        for (int i = 0; i < tiles.size()-1, i++)
        {
            if (valueNumMap.get(tiles.get(i)) != valueNumMap.get(tiles.get(i+1)) - 1) { return False; }
        }
        
        return True;
    }
    
    private Boolean isThreeOfAKind(List<Tile> tiles)
    {
        // check if size is 3
        if (tiles.size() != 3) { return False; }
        
        // check if same suit and value
        for (int i = 0; i < tiles.size()-1; i++)
        {
            if (tiles.get(i).getSet() != tiles.get(i+1).getSet()) { return False; }
            if (tiles.get(i).getValue() != tiles.get(i+1).getValue()) { return False; }
        }
        
        // check that it is three-of-a-kind-able
        TileSet thisSet = tiles.get(0).getSet();
        if (thisSet != TileSet.TEN_THOUSAND || thisSet != TileSet.CIRCLE || thisSet != TileSet.STICKS || thisSet != TileSet.WINDS || thisSet != TileSet.DRAGONS) { return False; }
        
        return True;
    }
    
    private Boolean isPair(List<Tile> tiles)
    {
        // check if size is 2
        if (tiles.size() != 2) { return False; }
        
        // check if same suit and value
        if (tiles.get(0).getSet() != tiles.get(1).getSet()) { return False; }
        if (tiles.get(0).getValue() != tiles.get(1).getValue()) { return False; }
        
        // check that it is pair-able
        TileSet thisSet = tiles.get(0).getSet();
        if (thisSet != TileSet.TEN_THOUSAND || thisSet != TileSet.CIRCLE || thisSet != TileSet.STICKS || thisSet != TileSet.WINDS || thisSet != TileSet.DRAGONS) { return False; }
        
        return True;
    }
}
