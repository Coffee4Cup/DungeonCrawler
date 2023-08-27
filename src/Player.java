public class Player extends Entity implements ActiveEntity{

    private Controller controller;
    public Player(Coordinates coordinates) {
        super(coordinates);
    }

    public Player(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
    }


    @Override
    public void takeTurn(Level level) {
        PlayerMove playerMove = null;

        boolean validMove = false;

        while (!validMove)
        {
             playerMove = controller.getMove();/*gets the move type from the controller */
             validMove = checkMoveValidity(playerMove, level.getMap());/*checks if the move is valid, responsible for printing the message if the move is not valid*/
        }
        preformMove(playerMove, level);
    }

    private void preformMove(PlayerMove playerMove, Level level) {
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

                    System.out.print("This is my special! for now... WOLOLOL");
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
                isValid = true; /*no condition for now */
            case SPECIAL_MOVE ->
                isValid = true;
        }
        return isValid;
    }


    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
