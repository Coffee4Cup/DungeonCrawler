//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLevelMaker implements textSymbol, LevelMaker {

   EntityFactory entityFactory;
   String path;
   Level tempLevel;

   /*@todo add a way to pass a folder path and make it iterate over the files and try to all the level in the folder*/
    public FileLevelMaker(String path) {

        this.path = path;
        this.entityFactory = new EntityFactory();
    }

    public Level makeLevelFromFile(String path) throws FileNotFoundException {
        this.path = path;
        return makeLevelFromFile();
    }
    public Level makeLevelFromFile() throws FileNotFoundException {

        this.tempLevel = new Level();
        Map tempMap = tempLevel.map;
        File mapFile = new File(path);
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
            tile = new FloorTile(xCoordinate, yCoordinate, spawnPlayer(xCoordinate, yCoordinate));
        } else if (tileCharacter == 'm') {
            tile = new FloorTile(xCoordinate, yCoordinate, spawnMonster(xCoordinate, yCoordinate));
        }
        return tile;
    }

    private Entity spawnPlayer(int xCoordinate, int yCoordinate) {
        Player player = this.entityFactory.createPlayer(xCoordinate, yCoordinate);
        tempLevel.setPlayer(player);
        return player;
    }
    private Entity spawnMonster(int xCoordinate, int yCoordinate) {
        Monster monster = this.entityFactory.createMonster(xCoordinate, yCoordinate);
        tempLevel.addActiveEntity(monster);
        return monster;
    }


    @Override
    public Level makeLevel() throws FileNotFoundException {
        return makeLevelFromFile();
    }
}
