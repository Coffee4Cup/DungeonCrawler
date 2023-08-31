import java.util.Scanner;

public class gameTextGUI extends GameGUI implements textSymbol{

    @Override
    protected void printNextRow() {
        System.out.print('\n');
    }
    @Override
    protected void printTile(Tile tile) throws Exception {
        Entity entity;
        if(tile == null)
            System.out.print(spaceSymbol);
        else if (tile instanceof WallTile)
            System.out.print(wallSymbol);
        else if(tile instanceof FloorTile && ((FloorTile)tile).isEmpty())
        System.out.print(floorSymbol);
        else if(tile instanceof FloorTile && !((FloorTile)tile).isEmpty()){
            entity = (((FloorTile) tile).getEntity());
            printEntity(entity);
        }
    }


    @Override
    public void printMenu() {
        System.out.println(
                "WELCOME TO A GENERIC DUNGEON CRAWLER\n" +
                "PLEASE SELECT YOUR CLASS\n" +
                "1. Warrior\n" +
                "2. MAGE\n" +
                "3. Rouge\n"
        );
    }
    @Override
    public void printStartMessage(){/*@todo add...*/
        System.out.println("YOU CAN ONLY CHOOSE WARRIOR. YOU ARE A WARRIOR NOW\n" +
                "BEGIN!");
    }

    @Override
    public void printInvalidActionReason(InvalidActionCode invalidReason, ActiveEntity activeEntity, ActionType actionType) {
        System.out.printf("%s tried to %s, can't preform because %s\n", activeEntity,actionType, invalidReason);
    }

    @Override
    public PlayerClass getMenuSelection() {
        Scanner playerChoice = new Scanner(System.in);
        playerChoice.nextInt();
        return PlayerClass.WARRIOR;
    }

    private void printEntity(Entity entity) throws Exception {
        if(entity instanceof Player)
            System.out.print(playerSymbol);
        else if (entity instanceof Monster)
            System.out.print(monsterSymbol);
    }
}