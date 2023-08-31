import java.util.Scanner;

public class DefultPlayerController extends ActionGenerator implements Controller{
    private static final Scanner controller = new Scanner(System.in);

     ActionType attemptedAction;
    private ActionType parsMove(char moveCharacter) {

        ActionType actionType;

        for(InputSymbol character : InputSymbol.values())
            if(moveCharacter == character.getSymbol())
                return character.getActionType();

      return ActionType.NOT_VALID_ACTION;
    }

    @Override
    public ActionType GenerateAction() {
        char actionCharSymbol = controller.next().charAt(0);
        attemptedAction = parsMove(actionCharSymbol);
        return attemptedAction;
    }
}
