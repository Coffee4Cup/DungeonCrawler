public class Main {

    public static void main(String[] args) throws Exception {

        Game game;
        FileLevelMaker levelMaker;
        GameGUI gameGUI;
        Controller controller;
        if (args.length > 0 && args[0].equalsIgnoreCase("-t")) {

            levelMaker = new FileLevelMaker(args[1]);
            gameGUI = new gameTextGUI();
            controller = new DefultController();
            game = new Game(levelMaker,controller, gameGUI);
        } else {
            // Handle other cases if needed
            return;
        }
        game.loadGame();
        game.startGame();


    }
}
