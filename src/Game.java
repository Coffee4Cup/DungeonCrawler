import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Game {

    ArrayList<Level> gameLevels;
    GameGUI gameGUI;
    LevelMaker levelMaker;
    Player player;
    Level currentLevel;
    boolean gameState;

    public Game(LevelMaker levelMaker, Controller controller, GameGUI gameGUI) {

        this.levelMaker = levelMaker;
        player = new Player(0,0);
        player.setController(controller);
        this.gameGUI = gameGUI;
        gameLevels = new ArrayList<>();

    }

    /**
     * Prepare all the game elements for starting the game
     *
     * builds the game levels from the given levelmaker*/
    public void loadGame() throws FileNotFoundException {

        Level level;
        gameState = true;
        level = levelMaker.makeLevel();/*@todo add a loop for each Level in path */
        gameLevels.add(level);
        this.currentLevel = gameLevels.get(0);
        gameGUI.setLevel(currentLevel);/*@todo add a notify pattern for the game GUI*/
        currentLevel.player.setController(player.getController());
        player = currentLevel.getPlayer();
    }

    private void startMenu() {

        gameGUI.printMenu();
        gameGUI.getMenuSelection();     /*@todo add a menu selection logic*/
        this.player.getController();
        gameGUI.printStartMessage();
        currentLevel.getPlayer().setController(this.player.getController());/*@todo these two line are not ideal change them later.*/
        this.player = currentLevel.getPlayer();
    }


    public void startGame() throws Exception {
        startMenu();

        while(gameState)
            playTurn();
    }

    private void playTurn() throws Exception {

        gameGUI.print(currentLevel);
        this.player.takeTurn(currentLevel);
            currentLevel.takeTurn();
    }
}
