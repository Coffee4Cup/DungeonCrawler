public class Monster extends Entity implements ActiveEntity {

    int AttackDistance = 1;

    public Monster(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
    }

    @Override
    public void takeTurn(Level level) {
        System.out.printf("the monster %s takes her turn\n", this.toString());
    }
    public boolean isPlayerInAttackDistance(Level level) {

        Coordinates playerCoordinates = level.getPlayerPosition();

        return  this.getCoordinates().distance(playerCoordinates) <= AttackDistance;



    }
}
