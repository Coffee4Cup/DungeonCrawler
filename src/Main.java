public class Main {

    public static void main(String[] args) throws Exception {

        Game game = new Game();

        FileLevelMaker levelMaker;
        GameGUI gameGUI;
        ActionGenerator playerController;
        if (args.length > 0 && args[0].equalsIgnoreCase("-d"))
        {

            Player player = game.getPlayer();
            EntityFactory entityFactory = new EntityFactory(new MonsterAIActionGenerator());
            playerController = new DefultPlayerController();
            gameGUI = new gameTextGUI();

            levelMaker = new FileLevelMaker(args[1], player, entityFactory);

            player.setActionGenerator(playerController);

            game.buildGame(gameGUI,levelMaker);

        } else {
            return;
        }
        game.startGame();


    }
}
