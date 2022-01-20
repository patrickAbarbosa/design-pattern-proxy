package Maps;

public interface ISector {
    public int getId();
    public String getImageUrl();
    public Sector getSectorNorth();
    public Sector getSectorSouth();
    public Sector getSectorEast();
    public Sector getSectorWest();
}
