import java.util.ArrayList;

/**this is a map that represents a map layout using a string representation*/
public class Map {
    private final ArrayList<ArrayList<Tile>> mapTiles;

    public Map() {
        this.mapTiles = new ArrayList<ArrayList<Tile>>();
    }

    public void setTile(Tile tile, int xCoordinate, int yCoordinate){
        mapTiles.get(yCoordinate).add(xCoordinate, tile);

    }

    public void addRow() {
        mapTiles.add(new ArrayList<>());
    }
    public int mapHeight(){
        return mapTiles.size();
    }
    public int mapWidth(int yCoordinate){
        return mapTiles.get(yCoordinate).size();
    }
    public Tile getTile(int xCoordinate, int yCoordinate){
        return mapTiles.get(yCoordinate).get(xCoordinate);
    }
    public Tile getTile(Coordinates coordinates){
        return getTile(coordinates.getXCoordinate(), coordinates.getYCoordinate());
    }

    public boolean isTileEmptyFloor(Coordinates querryCoordinates) {
        Tile tile = getTile(querryCoordinates);
        return tile instanceof FloorTile && ((FloorTile) tile).isEmpty();/*@todo check if return after &&*/
    }


}

