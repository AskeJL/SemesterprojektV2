package presentation.game.draw;

import data.AssetType;
import data.read.DataReader;
import java.util.HashMap;
import java.util.List;
import javafx.scene.input.KeyEvent;
import presentation.player.*;
import presentation.tiles.*;

public class DrawController implements DataReader {
    private static DrawController interfaces = new DrawController();
    private static char[][] characters;

    public static void setup() {
        final int TILE_SIZE = 32;
        final int xTiles = 28;
        final int yTiles = 16;
        
        FloorTile floor = new FloorTile();
        WallTile wall = new WallTile();
        ConsoleTile console = new ConsoleTile();
        NorthExitTile northExit = new NorthExitTile();
        SouthExitTile southExit = new SouthExitTile();
        WestExitTile westExit = new WestExitTile();
        EastExitTile eastExit = new EastExitTile();
        NothingTile nothing = new NothingTile();
        

        HashMap<Character, Tile> tileMap = new HashMap<>();
        tileMap.put(floor.getSYMBOL(), floor);
        tileMap.put(wall.getSYMBOL(), wall);
        tileMap.put(console.getSYMBOL(), console);
        tileMap.put(northExit.getSYMBOL(), northExit);
        tileMap.put(southExit.getSYMBOL(), southExit);
        tileMap.put(westExit.getSYMBOL(), westExit);
        tileMap.put(eastExit.getSYMBOL(), eastExit);
        tileMap.put(nothing.getSYMBOL(), nothing);

        List<String> map = interfaces.requestData(AssetType.MAP, "testMap.txt");
        characters = convertToCharArray(map, xTiles, yTiles);
        for (int x = 0; x < characters.length; x++) {
            for (int y = 0; y < characters[x].length; y++) {
                tileMap.get(characters[x][y]).drawTile((x * TILE_SIZE), (y * TILE_SIZE));
            }
        }
        
        Player player = new Player();
        final int startLocationXAxis = 5;
        final int startLocationYAxis = 5;
        player.drawPlayer(startLocationYAxis*TILE_SIZE, startLocationXAxis*TILE_SIZE);
       }
        
    /**
     * Converts a string array to a two dimensional char array. First index
     * being the line number, and the second index being that lines char index.
     *
     * @param list of lines to be converted into char[][]
     * @return the char[][] array with all the characters.
     */
    public static char[][] convertToCharArray(List<String> list, int xTiles, int yTiles) {
        
        char[][] charArray = new char[xTiles][yTiles];
        for (int i = 0; i < xTiles; i++) {
            for (int j = 0; j < yTiles; j++) {
                charArray[i][j] = list.get(j).charAt(i);
            }
        }
        return charArray;
    }
}