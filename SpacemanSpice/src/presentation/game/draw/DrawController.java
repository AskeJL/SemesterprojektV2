package presentation.game.draw;

import data.AssetType;
import data.read.DataReader;
import java.util.HashMap;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import presentation.player.*;
import presentation.tiles.*;

public class DrawController implements DataReader {

    private static DrawController interfaces = new DrawController();
    private static char[][] characters;

    private static String currentLocationName;
    private static HashMap<String, Location> locationMap;
    private static Location currentMapLocation;
    private static HashMap<Character, Tile> currentTileMap;
    private static String textMapLocation;
    private static int xTiles;
    private static int yTiles;

    private static int tileSize;

    private static Player player = new Player();
    private static int playerXLocation;
    private static int playerYLocation;

    public static void setup() {

        TileController tileController = new TileController();
        LocationController locationController = new LocationController();

        currentLocationName = "Personal";
        locationMap = locationController.getLocationMap();
        currentMapLocation = locationMap.get(currentLocationName);

        currentTileMap = tileController.getTileMap();
        textMapLocation = currentMapLocation.getTextMapFileLocation();

        tileSize = currentMapLocation.getTILE_SIZE();
        xTiles = currentMapLocation.getNUMBER_OF_TILES_X_AXIS();
        yTiles = currentMapLocation.getNUMBER_OF_TILES_Y_AXIS();

        playerXLocation = player.getPlayerLocationXAxis() + 5;
        playerYLocation = player.getPlayerLocationYAxis() + 5;
    }

    public static void drawLocation() {

        List<String> map = interfaces.requestData(AssetType.MAP, textMapLocation);
        characters = convertToCharArray(map, xTiles, yTiles);
        for (int x = 0; x < characters.length; x++) {
            for (int y = 0; y < characters[x].length; y++) {
                currentTileMap.get(characters[x][y]).drawTile((x * tileSize), (y * tileSize));
            }
        }
    }

    public static void drawPlayer() {

        player.drawPlayer(playerXLocation * tileSize, playerYLocation * tileSize);
    }

    public static void goNorthLocation() {
        String newDirection = currentMapLocation.getNorthExitString();
        if (newDirection != null) {
            currentMapLocation = locationMap.get(newDirection);
            textMapLocation = currentMapLocation.getTextMapFileLocation();
            DrawController.drawLocation();
        }
    }

    public static void goWestLocation() {
        String newDirection = currentMapLocation.getWestExitString();
        if (newDirection != null) {
            currentMapLocation = locationMap.get(newDirection);
            textMapLocation = currentMapLocation.getTextMapFileLocation();
            DrawController.drawLocation();
        }
    }

    public static void goSouthLocation() {
        String newDirection = currentMapLocation.getSouthExitString();
        if (newDirection != null) {
            currentMapLocation = locationMap.get(newDirection);
            textMapLocation = currentMapLocation.getTextMapFileLocation();
            DrawController.drawLocation();
        }
        DrawController.drawLocation();
    }

    public static void goEastLocation() {
        String newDirection = currentMapLocation.getEastExitString();
        if (newDirection != null) {
            currentMapLocation = locationMap.get(newDirection);
            textMapLocation = currentMapLocation.getTextMapFileLocation();
            DrawController.drawLocation();
        }
        DrawController.drawLocation();
    }

    public static void movePlayerUP() {
        if (currentTileMap.get(characters[playerXLocation][playerYLocation - 1]).getSolid() == false) {
            playerYLocation -= 1;
            DrawController.drawLocation();
            DrawController.drawPlayer();
        }

    }

    public static void movePlayerLeft() {
        if (currentTileMap.get(characters[playerXLocation - 1][playerYLocation]).getSolid() == false) {
            playerXLocation -= 1;
            DrawController.drawLocation();
            DrawController.drawPlayer();
        }
    }

    public static void movePlayerDown() {
        if (currentTileMap.get(characters[playerXLocation][playerYLocation + 1]).getSolid() == false) {
            playerYLocation += 1;
            DrawController.drawLocation();
            DrawController.drawPlayer();
        }
    }

    public static void movePlayerRight() {
        if (currentTileMap.get(characters[playerXLocation + 1][playerYLocation]).getSolid() == false) {
            playerXLocation += 1;
            DrawController.drawLocation();
            DrawController.drawPlayer();
        }
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
