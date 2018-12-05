package presentation.game.draw;

import data.AssetType;
import data.read.DataReader;
import java.util.HashMap;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import presentation.game.GameViewController;
import presentation.player.*;
import presentation.tiles.*;

/**
 * Draw controller class, implements DataReader interface in order to draw data
 * from data package. Instantiates player, tile/location controllers controls
 * the relationships between them based on user input.
 *
 */
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

    private static InteractableType interactableType;
    private static Direction direction;
    
    

    /**
     * Instantiates the components needed to be drawn on the canvas
     */
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

    public static void clearCanvas(){
        GraphicsContext gc = GameViewController.getGraphicsContext();
        int canvasWidth = 900;
        int canvasHeight = 540;
        gc.clearRect(0, 0,canvasWidth , canvasHeight);
    }
    /**
     * Draws a location on the screen, based on a text file
     */
    public static void drawLocation() {
        DrawController.clearCanvas();
        List<String> map = interfaces.requestData(AssetType.MAP, textMapLocation);
        characters = convertToCharArray(map, xTiles, yTiles);
        for (int x = 0; x < characters.length; x++) {
            for (int y = 0; y < characters[x].length; y++) {
                Image img = currentTileMap.get(characters[x][y]).getTileImage();
                currentTileMap.get(characters[x][y]).drawTile(img,(x * tileSize), (y * tileSize));
            }
        }
    }

    /**
     * Draws a location on the screen, based on a text file, depending on the
     * current tile the player is interacting with
     *
     * @param directionTo
     */
    public static void drawLocation(Direction directionTo) {
        DrawController.clearCanvas();
        List<String> map = interfaces.requestData(AssetType.MAP, textMapLocation);
        characters = convertToCharArray(map, xTiles, yTiles);
        for (int x = 0; x < characters.length; x++) {
            for (int y = 0; y < characters[x].length; y++) {
                if (currentTileMap.get(characters[x][y]).getDirection() == directionTo && currentTileMap.get(characters[x][y]).getTileType() == TileType.DOOR) {
                    playerXLocation = x;
                    playerYLocation = y;
                }
                Image img = currentTileMap.get(characters[x][y]).getTileImage();
                currentTileMap.get(characters[x][y]).drawTile(img,(x * tileSize), (y * tileSize));
            }
        }
    }
    
    /**
     * Draws the player.
     */
    public static void drawPlayer() {

        player.drawPlayer(playerXLocation * tileSize, playerYLocation * tileSize);
    }

    /**
     * Called from user input,
     * to interact with the tiles that are interact-able.
     */
    public static void interact() {
        interactableType = (InteractableType) currentTileMap.get(characters[playerXLocation][playerYLocation]).getInteractableType();
        switch (interactableType) {
            case NORTH:
                direction = currentMapLocation.getNorthExit().getDirectionTo();
                currentMapLocation = locationMap.get(currentMapLocation.getNorthExit().getToLocationName());
                textMapLocation = currentMapLocation.getTextMapFileLocation();
                DrawController.drawLocation(direction);
                DrawController.drawPlayer();
                new presentation.sound.Soundplayer().playDoorSound();
                break;
            case WEST:
                direction = currentMapLocation.getWestExit().getDirectionTo();
                currentMapLocation = locationMap.get(currentMapLocation.getWestExit().getToLocationName());
                textMapLocation = currentMapLocation.getTextMapFileLocation();
                DrawController.drawLocation(direction);
                DrawController.drawPlayer();
                new presentation.sound.Soundplayer().playDoorSound();
                break;
            case SOUTH:
                direction = currentMapLocation.getSouthExit().getDirectionTo();
                currentMapLocation = locationMap.get(currentMapLocation.getSouthExit().getToLocationName());
                textMapLocation = currentMapLocation.getTextMapFileLocation();
                DrawController.drawLocation(direction);
                DrawController.drawPlayer();
                new presentation.sound.Soundplayer().playDoorSound();
                break;
            case EAST:
                direction = currentMapLocation.getEastExit().getDirectionTo();
                currentMapLocation = locationMap.get(currentMapLocation.getEastExit().getToLocationName());
                textMapLocation = currentMapLocation.getTextMapFileLocation();
                DrawController.drawLocation(direction);
                DrawController.drawPlayer();
                new presentation.sound.Soundplayer().playDoorSound();
                break;
            case CONSOLE:
                new presentation.sound.Soundplayer().playInteractionSound();
                break;
        }
    }

    /**
     * Move player 1 tile upwards (negative y axis)
     */
    public static void movePlayerUP() {
        if (currentTileMap.get(characters[playerXLocation][playerYLocation - 1]).getSolid() == false) {
            playerYLocation -= 1;
            DrawController.drawLocation();
            DrawController.drawPlayer();
        }

    }

    /**
     * Move player 1 tile to the left (negative x axis)
     */
    public static void movePlayerLeft() {
        if (currentTileMap.get(characters[playerXLocation - 1][playerYLocation]).getSolid() == false) {
            playerXLocation -= 1;
            DrawController.drawLocation();
            DrawController.drawPlayer();
        }
    }

    /**
     * Move player 1 tile downwards (positive y axis)
     */
    public static void movePlayerDown() {
        if (currentTileMap.get(characters[playerXLocation][playerYLocation + 1]).getSolid() == false) {
            playerYLocation += 1;
            DrawController.drawLocation();
            DrawController.drawPlayer();
        }
    }

    /**
     * Move player 1 tile to the right (positive x axis)
     */
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
    
    public static String getCurrentLocationName(){
        return currentLocationName;
    }

}
