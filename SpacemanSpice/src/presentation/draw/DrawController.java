package presentation.draw;

import data.AssetType;
import data.Data;
import domain.DomainReader;
import domain.DomainRequester;
import domain.locations.*;
import domain.locations.gameobjects.Player;
import domain.locations.gameobjects.Tile;
import java.util.HashMap;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import presentation.controllers.ViewController_Game;
import presentation.sound.SoundPlayer;

/**
 * Draw controller class, implements DataReader interface in order to draw data
 * from data package. Instantiates player, tile/location controllers controls
 * the relationships between them based on user input.
 *
 */
public class DrawController {

    private final Data data = new Data();

    private char[][] characters;

    private String currentLocationName;
    private Location currentMapLocation;

    private HashMap<String, Location> locationMap;
    private HashMap<Character, Tile> currentTileMap;
    private String textMapLocation;

    private final int NUMBER_OF_TILES_X_AXIS = 28;
    private final int NUMBER_OF_TILES_Y_AXIS = 16;
    private final int tileSize = 32;

    private int playerXLocation;
    private int playerYLocation;

    private final ViewController_Game gameViewController;
    private final Player player;

    private GraphicsContext gc;

    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();

    private GameObjectType actionType;
    private GameObjectType exitDirection;

    public DrawController(ViewController_Game controller) {
        this.gameViewController = controller;
        this.player = requester.getPlayer();
    }

    /**
     * Instantiates the components needed to be drawn on the canvas
     */
    public void setup() {

        gc = gameViewController.getGraphicsContext();

        currentTileMap = requester.getTileMap();
        locationMap = requester.getLocationMap();

        currentLocationName = "Personal";
        currentMapLocation = locationMap.get(currentLocationName);
        textMapLocation = currentMapLocation.getTextMapLocation();

        playerXLocation = player.getxPosition() + 5;
        playerYLocation = player.getyPosition() + 5;

    }

    public void clearCanvas() {
        gc = gameViewController.getGraphicsContext();
        int canvasWidth = 900;
        int canvasHeight = 540;
        gc.clearRect(0, 0, canvasWidth, canvasHeight);
    }

    /**
     * Draws a location on the screen, based on a text file
     */
    public void drawLocation() {
        clearCanvas();
        List<String> map = data.requestData(AssetType.MAP, textMapLocation);
        characters = convertToCharArray(map, NUMBER_OF_TILES_X_AXIS, NUMBER_OF_TILES_Y_AXIS);
        for (int x = 0; x < characters.length; x++) {
            for (int y = 0; y < characters[x].length; y++) {
                Image img = currentTileMap.get(characters[x][y]).getTILE_IMAGE();
                gc.drawImage(img, x * tileSize, y * tileSize);
            }
        }
    }

    /**
     * Draws a location on the screen, based on a text file, depending on the
     * current tile the player is interacting with
     *
     * @param directionTo
     */
    public void drawLocation(char exit) {
        clearCanvas();
        List<String> map = data.requestData(AssetType.MAP, textMapLocation);
        characters = convertToCharArray(map, NUMBER_OF_TILES_X_AXIS, NUMBER_OF_TILES_Y_AXIS);
        for (int x = 0; x < characters.length; x++) {
            for (int y = 0; y < characters[x].length; y++) {
                if (currentTileMap.get(characters[x][y]).getSYMBOL() == exit) {
                    playerXLocation = x;
                    playerYLocation = y;
                }
                Image img = currentTileMap.get(characters[x][y]).getTILE_IMAGE();
                gc.drawImage(img, x * tileSize, y * tileSize);
            }
        }
    }

    /**
     * Draws the player.
     */
    public void drawPlayer() {

        gc.drawImage(player.getPlayerImage(), playerXLocation * tileSize, playerYLocation * tileSize);
    }

    /**
     * Called from user input, to interact with the tiles that are
     * interact-able.
     */
    public void interact() {
        SoundPlayer sound = new SoundPlayer(this);
        actionType = currentTileMap.get(characters[playerXLocation][playerYLocation]).getGAME_OBJECT_TYPE();
        switch (actionType) {
            case NORTH:
                exitDirection = GameObjectType.NORTH;
                char exit = 'n';
                currentMapLocation = locationMap.get(currentMapLocation.getNorthExit().getTargetLocation());
                textMapLocation = currentMapLocation.getTextMapLocation();
                drawLocation(exit);
                drawPlayer();
                sound.playDoorSound();
                break;
            case WEST:
                currentMapLocation = locationMap.get(currentMapLocation.getWestExit().getTargetLocation());
                textMapLocation = currentMapLocation.getTextMapLocation();
                drawLocation();
                drawPlayer();
                sound.playDoorSound();
                break;
            case SOUTH:
                currentMapLocation = locationMap.get(currentMapLocation.getSouthExit().getTargetLocation());
                textMapLocation = currentMapLocation.getTextMapLocation();
                drawLocation();
                drawPlayer();
                sound.playDoorSound();
                break;
            case EAST:
                currentMapLocation = locationMap.get(currentMapLocation.getEastExit().getTargetLocation());
                textMapLocation = currentMapLocation.getTextMapLocation();
                drawLocation();
                drawPlayer();
                sound.playDoorSound();
                break;
            case CONTROL:
                sound.playInteractionSound();
                break;
        }
    }

    /**
     * Move player 1 tile upwards (negative y axis)
     */
    public void movePlayerUP() {
        if (currentTileMap.get(characters[playerXLocation][playerYLocation - 1]).getSOLID() == false) {
            playerYLocation -= 1;
            drawLocation();
            drawPlayer();
        }

    }

    /**
     * Move player 1 tile to the left (negative x axis)
     */
    public void movePlayerLeft() {
        if (currentTileMap.get(characters[playerXLocation - 1][playerYLocation]).getSOLID() == false) {
            playerXLocation -= 1;
            drawLocation();
            drawPlayer();
        }
    }

    /**
     * Move player 1 tile downwards (positive y axis)
     */
    public void movePlayerDown() {
        if (currentTileMap.get(characters[playerXLocation][playerYLocation + 1]).getSOLID() == false) {
            playerYLocation += 1;
            drawLocation();
            drawPlayer();
        }
    }

    /**
     * Move player 1 tile to the right (positive x axis)
     */
    public void movePlayerRight() {
        if (currentTileMap.get(characters[playerXLocation + 1][playerYLocation]).getSOLID() == false) {
            playerXLocation += 1;
            drawLocation();
            drawPlayer();
        }
    }

    /**
     * Converts a string array to a two dimensional char array. First index
     * being the line number, and the second index being that lines char index.
     *
     * @param list of lines to be converted into char[][]
     * @param xTiles
     * @param yTiles
     * @return the char[][] array with all the characters.
     */
    public char[][] convertToCharArray(List<String> list, int xTiles, int yTiles) {

        char[][] charArray = new char[xTiles][yTiles];
        for (int i = 0; i < xTiles; i++) {
            for (int j = 0; j < yTiles; j++) {
                charArray[i][j] = list.get(j).charAt(i);
            }
        }
        return charArray;
    }

    public String getCurrentLocationName() {
        return currentLocationName;
    }

}
