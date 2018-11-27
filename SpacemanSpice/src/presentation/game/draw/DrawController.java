package presentation.game.draw;

import data.AssetType;
import data.read.DataReader;
import java.util.HashMap;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import presentation.game.GameViewController;
import presentation.tiles.ConsoleTile;
import presentation.tiles.EastExitTile;
import presentation.tiles.FloorTile;
import presentation.tiles.NorthExitTile;
import presentation.tiles.SouthExitTile;
import presentation.tiles.Tile;
import presentation.tiles.WallTile;
import presentation.tiles.WestExitTile;

public class DrawController implements DataReader {
    private static DrawController interfaces = new DrawController();
    private static char[][] characters;

    public static void setup() {
        final int TILE_SIZE = 32;
        FloorTile floor = new FloorTile();
        WallTile wall = new WallTile();
        ConsoleTile console = new ConsoleTile();
        NorthExitTile northExit = new NorthExitTile();
        SouthExitTile southExit = new SouthExitTile();
        WestExitTile westExit = new WestExitTile();
        EastExitTile eastExit = new EastExitTile();
        

        HashMap<Character, Tile> tileMap = new HashMap<>();
        tileMap.put(floor.getSYMBOL(), floor);
        tileMap.put(wall.getSYMBOL(), wall);
        tileMap.put(console.getSYMBOL(), console);
        tileMap.put(northExit.getSYMBOL(), northExit);
        tileMap.put(southExit.getSYMBOL(), southExit);
        tileMap.put(westExit.getSYMBOL(), westExit);
        tileMap.put(eastExit.getSYMBOL(), eastExit);

        List<String> map = interfaces.requestData(AssetType.MAP, "testMap.txt");
        characters = convertToCharArray(map);
        for (int x = 0; x < characters.length; x++) {
            for (int y = 0; y < characters[x].length; y++) {
                tileMap.get(characters[x][y]).drawTile((x * TILE_SIZE), (y * TILE_SIZE));
            }
        
        }
       }

    /**
     * Converts a string array to a two dimensional char array. First index
     * being the line number, and the second index being that lines char index.
     *
     * @param list of lines to be converted into char[][]
     * @return the char[][] array with all the characters.
     */
    public static char[][] convertToCharArray(List<String> list) {
        final int TILE_NUMBER_HEIGHT = 6;
        final int TILE_NUMBER_WIDTH = 5;
        char[][] charArray = new char[TILE_NUMBER_WIDTH][TILE_NUMBER_HEIGHT];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                charArray[i][j] = list.get(i).charAt(j);
            }
        }
        return charArray;
    }
}