public class Tile implements Comparable<Tile>
{
    private TileSet set;
    private TileValue value;
    
    public Tile(TileSet set, TileValue value)
    {
        this.set = set;
        this.value = value;
    }
    
    public TileSet getSet() { return set; }
    public TileValue getValue() { return value; }
    
    @Override
    public int compare(Tile a, Tile b)
    {
        TileSet aSet = a.getSet();
        TileSet bSet = b.getSet();
        TileValue aValue = a.getValue();
        TileValue bValue = b.getValue();
        
        if (aSet != bSet)
        {
            return aSet.compareTo(bSet);
        }
        else
        {
            return aValue.compareTo(bValue);
        }
    }
}
