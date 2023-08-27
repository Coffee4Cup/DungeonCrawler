import java.util.ArrayList;

public class FloorTile extends Tile {


    protected Entity entity;

    public FloorTile(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
    }
    public FloorTile(int xCoordinate, int yCoordinate,Entity entity) {
        super(xCoordinate, yCoordinate);
        this.entity =  entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public boolean isEmpty() {
        return entity == null;
    }
}
