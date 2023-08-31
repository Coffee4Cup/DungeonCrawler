public class ActionChecker {

    private static InvalidActionCode invalidActionCode;

    public static InvalidActionCode getReason() {
        return invalidActionCode;
    }

    public boolean checkAction(Level currentLevel, ActiveEntity entity, ActionType actionType) {


        boolean foundMove = false;
        foundMove = checkMoveAction(currentLevel, entity, actionType);
        /*add here move checking for attacking and special moves...*/

       return foundMove;
    }

    /**
     * Checks if the action is a walking action and return true is so
     * and updates the invalidActionCode with the information of validity.
     * else just return false (the move is not a walking move)
     * */
    private boolean checkMoveAction(Level cuurentLevel, ActiveEntity entity, ActionType actionType) {

        Coordinates querryCoordinates;
        switch (actionType) {

            case WALK_UP -> {
                querryCoordinates = entity.getCoordinates().getAbove();


            }
            case WALK_DOWN -> {
                querryCoordinates = entity.getCoordinates().getBelow();


            }
            case WALK_LEFT -> {
                querryCoordinates = entity.getCoordinates().getToTheLeft();

            }
            case WALK_RIGHT -> {
                querryCoordinates = entity.getCoordinates().getToTheRight();

            }
            default -> {/*not a walking move*/
                return false;
            }
        }
        if(cuurentLevel.isOccupiedFloor(querryCoordinates))
            invalidActionCode = InvalidActionCode.ENTITY_COALITION;

        else if(cuurentLevel.isWall(querryCoordinates))
            invalidActionCode = InvalidActionCode.WALL_COALITION;

        else
            invalidActionCode = InvalidActionCode.VALID_ACTION;

        return true;
    }
}

