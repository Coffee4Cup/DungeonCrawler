public class Player extends ActiveEntity {

    public Player(Coordinates coordinates, ActionGenerator actionGenerator) {
        super(coordinates, actionGenerator);
    }

    private Player(int xCoordinate, int yCoordinate, ActionGenerator actionGenerator) {
        super(xCoordinate, yCoordinate, actionGenerator);
    }

    /*The player is created with null because it the game creates it and then  */
    public Player() {
        super(null, null);
    }
/*@todo (1) transefer the getting of the action to the controler that is an
    implementation of actionGenerator- done.(2) and the validity checking to a
     special class in game to check the validity of the move

    private void preformMove() {
        switch (playerMove){

            case WALK_UP ->

                moveUp(level);

            case WALK_DOWN ->

                moveDown(level);

            case WALK_LEFT ->

                moveLeft(level);

            case WALK_RIGHT ->

                moveRight(level);

            case ATTACK ->

                System.out.print("This is an attack! for now...");

            case SPECIAL_MOVE ->

                    System.out.print("This is my special move! for now...");
        }
    }

    private boolean checkMoveValidity(PlayerMove playerMove, Map map) {
        boolean isValid = false;
        Coordinates querryCoordinates;
        switch (playerMove){

            case WALK_UP ->
            {
                querryCoordinates = this.getCoordinates().getAbove();
                isValid = map.isTileEmptyFloor(querryCoordinates);

            }
            case WALK_DOWN ->
            {
                querryCoordinates = this.getCoordinates().getBelow();
                isValid = map.isTileEmptyFloor(querryCoordinates);

            }
            case WALK_LEFT ->
            {
                querryCoordinates = this.getCoordinates().getToTheLeft();
                isValid = map.isTileEmptyFloor(querryCoordinates);
            }
            case WALK_RIGHT ->
            {
                querryCoordinates = this.getCoordinates().getToTheRight();
                isValid = map.isTileEmptyFloor(querryCoordinates);
            }
            case ATTACK ->
                isValid = true; *//*no condition for now *//*
            case SPECIAL_MOVE ->
                isValid = true;
        }
        return isValid;
    }*/

}
