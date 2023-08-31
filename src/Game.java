import java.util.ArrayList;

public class Game {

    private GameGUI gameGUI;
    private Player player;
    private ArrayList<Level> gameLevels;
    private Level currentLevel;
    private boolean gameState;
    private ActionChecker actionChecker;

    public Game() {
        this.player = new Player();
        this.gameLevels = new ArrayList<>();
        this.actionChecker = new ActionChecker();
    }

    public GameGUI getGameGUI() {
        return gameGUI;
    }

    public void setGameGUI(GameGUI gameGUI) {
        this.gameGUI = gameGUI;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Level> getGameLevels() {
        return gameLevels;
    }

    public void setGameLevels(ArrayList<Level> gameLevels) {
        this.gameLevels = gameLevels;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public boolean isGameState() {
        return gameState;
    }

    public void setGameState(boolean gameState) {
        this.gameState = gameState;
    }

    /**
     * Prepare all the game elements for starting the game
     * builds the game levels from the given level-maker
     **/
    public void buildGame(GameGUI gameGUI, LevelMaker levelMaker){
        /*assumes that the Level factory has its monster factory initialized with an AI for the monsters */

        Level level;
        setGameGUI(gameGUI);
        level = levelMaker.makeLevel();/*@todo add loop for maps*/
        gameLevels.add(level);
        this.currentLevel = gameLevels.get(0);

    }

    public void startGame() throws Exception {

        player.setCoordinates(currentLevel.playerSpawnPoint);
        gameState = true;
        startMenu();
        currentLevel.setPlayer(player);
        gameGUI.print(currentLevel);

        while(gameState)
            PlayTurn();
    }
    private void startMenu() {

        gameGUI.printMenu();
        gameGUI.getMenuSelection();   //@todo is it right to make the GUI take input?
        gameGUI.printStartMessage();
    }

    private void PlayTurn() throws Exception {

        gameGUI.print(currentLevel);
        getAction(player);

        for(ActiveEntity monster : currentLevel.activeEntities)
        {
            getAction(monster);
        }
    }
    private void getAction(ActiveEntity activeEntity){

        boolean validAction = false;
        ActionType actionType;

        actionType  =  activeEntity.getAction();
        validAction = actionChecker.checkAction(currentLevel, activeEntity, actionType);

        while(!validAction) {
            gameGUI.printInvalidActionReason(actionChecker.getReason(), activeEntity, actionType);
            actionType = activeEntity.getAction();
            validAction = actionChecker.checkAction(currentLevel, activeEntity, actionType);
        }
        activeEntity.preformAction(actionType, currentLevel);
    }
}
