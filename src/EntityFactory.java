public class EntityFactory {
    private final MonsterAIActionGenerator EntityAI;

    public EntityFactory(MonsterAIActionGenerator EntityAI) {
        this.EntityAI = EntityAI;
    }

    public ActionGenerator setEntityAILevel(Level level) {
        EntityAI.setLevel(level);
    }

    public Monster createMonster(int xCoordinate, int yCoordinate) {
        return new Monster(xCoordinate, yCoordinate, EntityAI);
    }

}

