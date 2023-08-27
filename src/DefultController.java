import java.util.Scanner;

public class DefultController implements Controller{

    private static final char walkUp = 'w', walkDown = 's', walkLeft = 'a', walkRight = 'd';
    Scanner controller;

    public DefultController()
    {
        controller = new Scanner(System.in);
    }
    @Override
    public PlayerMove getMove()
    {
        char moveCharacter;
        moveCharacter = controller.next().charAt(0);
       return parsMove(moveCharacter);
    }

    private PlayerMove parsMove(char moveCharacter) {
        PlayerMove playerMove;

        if(moveCharacter == walkUp)
            playerMove = PlayerMove.WALK_UP;
        else if(moveCharacter == walkDown)
            playerMove = PlayerMove.WALK_DOWN;
        else if(moveCharacter == walkLeft)
            playerMove = PlayerMove.WALK_LEFT;
        else if(moveCharacter == walkRight)
            playerMove = PlayerMove.WALK_RIGHT;
        else
            playerMove = PlayerMove.NOT_VALID_INPUT;

        return playerMove;
    }
}
