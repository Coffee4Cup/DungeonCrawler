public abstract class LevelMaker {

    final protected Player player;
    final protected EntityFactory entityFactory;

    public LevelMaker(Player player, EntityFactory entityFactory) {

        this.player = player;
        this.entityFactory = entityFactory;
    }

    public abstract Level makeLevel();
}
