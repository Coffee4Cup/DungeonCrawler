/*represents an entity*/
public class Entity {

    private Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Entity(int xCoordinate, int yCoordinate) {
        this.coordinates = new Coordinates(xCoordinate, yCoordinate);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void updatePosition(Coordinates oldCoordinates, Coordinates newCoordinates, Level level) {

        this.coordinates = newCoordinates;
        level.updateEntityPosition(oldCoordinates, newCoordinates, this);
    }
    public void moveUp(Level level){

        updatePosition(coordinates, coordinates.getAbove(), level);
    }
    public void moveDown(Level level){

        updatePosition(coordinates, coordinates.getBelow(), level);
    }
    public void moveLeft(Level level){

        updatePosition(coordinates, coordinates.getToTheLeft(), level);
    }
    public void moveRight(Level level){

        updatePosition(coordinates, coordinates.getToTheRight(), level);
    }
}
