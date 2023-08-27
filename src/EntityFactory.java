public class EntityFactory {
    public Monster createMonster(int xCoordinate,int yCoordinate) {
        return new Monster(xCoordinate, yCoordinate);
    }

    public Player createPlayer(int xCoordinate, int yCoordinate) {
        return new Player(xCoordinate, yCoordinate);
    }
}

