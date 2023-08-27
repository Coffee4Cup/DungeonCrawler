/**Represents a tile in the map class
 *
 * The tile can hold an entity like a person or a monster
 * it can hold a state of walkable and not walkable.
 * it also holds an enum that says what type of tile it is, wall, floor etc...
 * */

abstract public class Tile {
    final protected int yCoordinate, xCoordinate;

    protected Tile(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}