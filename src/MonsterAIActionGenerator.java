/*This actionGenerator is the Ai of the monsters in a given level,
 it uses the level object to check the player position */
public class MonsterAIActionGenerator extends ActionGenerator{

    private Level level;
    private ActiveEntity actingActiveEntity;
    @Override
    public ActionType GenerateAction() {

        level.getPlayerPosition();
    return null;
    }
    public ActionType getAction(ActiveEntity actingActiveEntity){

    }
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
