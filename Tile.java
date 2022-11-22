public class Tile
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
}
