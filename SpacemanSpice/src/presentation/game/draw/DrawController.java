package presentation.game.draw;

import data.AssetType;
import data.read.DataReader;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import presentation.game.GameViewController;

public class DrawController implements DataReader {

    private static DrawController interfaces = new DrawController();
    private static char[][] characters;

    public static void setup() {
        GraphicsContext gc = GameViewController.getGraphicsContext();
        gc.setStroke(Color.WHITE);

        List<String> data = interfaces.requestData(AssetType.MAP, "Airlock.txt");
        characters = convertToCharArray(data);
        
        for(int x = 0; x < 1280 / 16; x++) {
            for(int y = 0; y < 720 / 16; y++) {
                gc.strokeText(Character.toString(characters[y][x]), x * 16, y * 16);
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
        char[][] charArray = new char[1000][1000];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                charArray[i][j] = list.get(i).charAt(j);
            }
        }
        return charArray;
    }
}
