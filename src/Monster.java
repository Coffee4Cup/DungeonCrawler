public class Monster extends ActiveEntity  {

    int AttackDistance = 1;

    public Monster(int xCoordinate, int yCoordinate, ActionGenerator actionGenerator) {
        super(xCoordinate, yCoordinate,actionGenerator);
    }

    public ActionType getAction() {
        return actionGenerator.GenerateAction();
    }
}
