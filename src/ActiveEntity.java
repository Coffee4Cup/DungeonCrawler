public abstract class ActiveEntity extends Entity {
    protected ActionGenerator actionGenerator;
    public ActiveEntity(Coordinates coordinates, ActionGenerator actionGenerator) {
        super(coordinates);
        this.actionGenerator = actionGenerator;
    }

    public ActiveEntity(int xCoordinate, int yCoordinate, ActionGenerator actionGenerator) {

        super(xCoordinate, yCoordinate);
        this.actionGenerator = actionGenerator;
    }

    public ActionGenerator getActionGenerator() {
        return actionGenerator;
    }

    public void setActionGenerator(ActionGenerator actionGenerator) {
        this.actionGenerator = actionGenerator;
    }

    public ActionType getAction(){
        return actionGenerator.GenerateAction();
    }


/**
 * This method is preformed after the game validates that the action is valid for this Entity
 * */
    public void preformAction(ActionType actionType, Level currentLevel) {
        if (actionType == ActionType.WALK_UP ||
        actionType == ActionType.WALK_DOWN ||
        actionType == ActionType.WALK_LEFT ||
        actionType == ActionType.WALK_RIGHT)
            updatePosition(actionType, currentLevel);
    }
}
