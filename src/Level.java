import java.util.LinkedList;
import java.util.List;
/**
 * Represents a Level inside the game
 *
 * It holds the map,the playerSymbol, the list of active and passive enemies inside the map.
 * the level also acts as an opponent to the playerSymbol as it is responsible for active enemies turn taking.
 * */

public class Level  {
    protected Map map;
    protected Coordinates playerSpawnPoint;
    protected Player player;

    protected List<ActiveEntity> activeEntities;
    protected List<PassiveEntity> passiveEntities;
    public Level() {

        this.map = new Map();
        this.activeEntities = new LinkedList<>();
        this.passiveEntities =new LinkedList<>();
    }

    public void setMap(Map map) {
        this.map = map;
    }
    public void setPlayer(Player player){
        ((FloorTile)map.getTile(playerSpawnPoint)).setEntity(player);
        this.player = player;
    }

    public void addActiveEntity(ActiveEntity activeEntity) {
        this.activeEntities.add(activeEntity);
    }
    public void addPassiveEntity(PassiveEntity passiveEntity) {
        this.passiveEntities.add(passiveEntity);
    }

    public void takeTurn() 
    {
        for (ActiveEntity activeEntity : this.activeEntities)
            activeEntity.getAction();
    }
    public Map getMap() {
        return map;
    }
    public Player getPlayer() {
        return player;
    }
    public Coordinates getPlayerPosition() {
        return player.getCoordinates();
    }
    public void updateEntityPosition(Coordinates oldCoordinates, Coordinates newCoordinates, Entity entity) {
        {
            /*assumes that the coordinates are valid floorSymbol coordinates */
            ((FloorTile)map.getTile(oldCoordinates)).setEntity(null);
            ((FloorTile)map.getTile(newCoordinates)).setEntity(entity);
        }
    }

    public boolean isOccupiedFloor(Coordinates querryCoordinates) {
        Tile tile = map.getTile(querryCoordinates);
        return tile instanceof FloorTile && ((FloorTile)tile).isEmpty() ;
    }

    public boolean isWall(Coordinates querryCoordinates) {
        return map.getTile(querryCoordinates) instanceof WallTile;
    }
}
