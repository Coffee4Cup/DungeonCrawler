import java.util.Scanner;

public class gameTextGUI extends GameGUI implements textSymbol{

    public gameTextGUI() {
    }

    @Override
    protected void printNextRow() {
        System.out.print('\n');
    }
    @Override
    protected void printTile(Tile tile) throws Exception {
        Entity entity;
        if(tile == null)
            System.out.print(space);
        else if (tile instanceof WallTile)
            System.out.print(wall);
        else if(tile instanceof FloorTile && ((FloorTile)tile).isEmpty())
        System.out.print(floor);
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
    public void printStartMessage(){
        System.out.println("PSYCH, YOU CAN ONLY CHOOSE WARRIOR. YOU ARE A WARRIOR NOW\n" +
                "BEGIN!");
    }

    @Override
    public PlayerClass getMenuSelection() {
        Scanner playerChoice = new Scanner(System.in);
        playerChoice.nextInt();
        return PlayerClass.WARRIOR;
    }

    private void printEntity(Entity entity) throws Exception {
        if(entity instanceof Player)
            System.out.print(player);
        else if (entity instanceof Monster)
            System.out.print(monster);
    }
}