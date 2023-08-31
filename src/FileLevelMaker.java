//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*@todo add a way to pass a folder path and make it iterate over the files and try to all the level in the folder*/
public class FileLevelMaker extends LevelMaker implements textSymbol {




    public FileLevelMaker(String filePath, Player player, EntityFactory entityFactory) {
        entityFactory.
        super(player, entityFactory);
        this.filePath = filePath;
    }

    String filePath;
   Level tempLevel;

    private Level makeLevelFromFile() throws FileNotFoundException {

        this.tempLevel = new Level();
        Map tempMap = tempLevel.map;
        File mapFile = new File(filePath);
        Scanner Reader = new Scanner(mapFile);
        String line;

        for(int yCount = 0; Reader.hasNextLine(); ++yCount) {
            line = Reader.nextLine();
            tempMap.addRow();

            for(int xCount = 0, length = line.length(); xCount < length; ++xCount) {
                char tileCharacter = line.charAt(xCount);
                Tile tempTile = this.FileTileFactory(xCount, yCount, tileCharacter);
                tempMap.setTile(tempTile, xCount, yCount);

            }
        }
        Reader.close();
        return tempLevel;
    }

    private Tile FileTileFactory(int xCoordinate, int yCoordinate, char tileCharacter) {

        Tile tile = null;

        if (tileCharacter == '_') {
            tile = new FloorTile(xCoordinate, yCoordinate);
        } else if (tileCharacter == '#') {
            tile = new WallTile(xCoordinate, yCoordinate);
        } else if (tileCharacter == 'x') {
            tile = new FloorTile(xCoordinate, yCoordinate);
            setPlayerCoordinates(xCoordinate, yCoordinate);
        } else if (tileCharacter == 'm') {
            tile = new FloorTile(xCoordinate, yCoordinate, spawnMonster(xCoordinate, yCoordinate));
        }
        return tile;
    }

    private void setPlayerCoordinates(int xCoordinate, int yCoordinate) {
        tempLevel.playerSpawnPoint = new Coordinates(xCoordinate, yCoordinate);
    }
    private Entity spawnMonster(int xCoordinate, int yCoordinate) {

        Monster monster = this.entityFactory.createMonster(xCoordinate, yCoordinate);
        tempLevel.addActiveEntity(monster);
        return monster;
    }


    @Override
    public Level makeLevel(){
        try {
            return makeLevelFromFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
