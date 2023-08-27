abstract public class GameGUI {

    protected abstract void printNextRow();
    Level level;
    public void print(Level level) throws Exception {
    this.level = level;
    iterateMap();
}

    public void setLevel(Level level) {
        this.level = level;
    }

    protected abstract void printTile(Tile tile) throws Exception;
    Map iterateMap() throws Exception {

        Tile currentTile;
        Map map = level.getMap();

        for(int yCount = 0, rowNumber = map.mapHeight(); yCount < rowNumber ; yCount++ )
        {
            for(int xCount = 0, columNumber = map.mapWidth(yCount) ; xCount < columNumber ; xCount++)
            {
                currentTile = map.getTile(xCount, yCount);
                printTile(currentTile);
            }
            printNextRow();
        }
        return null;
    }


    public abstract void printMenu();

    public abstract PlayerClass getMenuSelection();
    public abstract void printStartMessage();
}
