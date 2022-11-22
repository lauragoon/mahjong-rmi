public class Game
{
    public ArrayList<Tile> tiles;
    public HashMap<Integer, TileSet> numValueMap;
  
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
            entry(9, TileValue.NINE)     
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
}
