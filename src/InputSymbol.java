/**This enum represents the characters input for a default controller class,
 *  the controller can iterate over and find a match between the character symbol and the ActionType */
public enum InputSymbol {
    WALK_UP("Walk Up", 'w', ActionType.WALK_UP),
    WALK_DOWN("Walk Down", 's', ActionType.WALK_DOWN),
    WALK_LEFT("Walk Left", 'a', ActionType.WALK_LEFT),
    WALK_RIGHT("Walk Right", 'd', ActionType.WALK_RIGHT),
    SPECIAL_ATTACK("Special Attack", 'r', ActionType.ATTACK);

    private final String name;
    private final char symbol;
    private final ActionType actionType;

    InputSymbol(String name, char symbol, ActionType actionType) {
        this.name = name;
        this.symbol = symbol;
        this.actionType = actionType;
    }

    public String toString() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public ActionType getActionType() {
        return actionType;
    }
}
