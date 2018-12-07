package presentation.draw;

import data.AssetType;
import data.Data;
import java.util.HashMap;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import presentation.controllers.ViewController_Game;
import presentation.player.*;
import presentation.sound.SoundPlayer;
import presentation.tiles.*;

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
    
    private int xTiles;
    private int yTiles;
    private int tileSize;

    private int playerXLocation;
    private int playerYLocation;

    private InteractableType interactableType;
    private Direction direction;
    
    private final ViewController_Game gameViewController;
    private final Player player;
    
    public DrawController(ViewController_Game controller) {
        this.gameViewController = controller;
        this.player = new Player(gameViewController);
    }

    /**
     * Instantiates the components needed to be drawn on the canvas
     */
    public void setup() {
        
        TileController tileController = new TileController(gameViewController.getGraphicsContext());
        LocationController locationController = new LocationController();

        currentLocationName = "Personal";
        locationMap = locationController.getLocationMap();
        currentMapLocation = locationMap.get(currentLocationName);

        currentTileMap = tileController.getTileMap();
        textMapLocation = currentMapLocation.getTextMapFileLocation();

        tileSize = currentMapLocation.getTILE_SIZE();
        xTiles = currentMapLocation.getNUMBER_OF_TILES_X_AXIS();
        yTiles = currentMapLocation.getNUMBER_OF_TILES_Y_AXIS();

        playerXLocation = player.getXPos() + 5;
        playerYLocation = player.getYPos() + 5;
        
    }

    public void clearCanvas(){
        GraphicsContext gc = gameViewController.getGraphicsContext();
        int canvasWidth = 900;
        int canvasHeight = 540;
        gc.clearRect(0, 0,canvasWidth , canvasHeight);
    }
    /**
     * Draws a location on the screen, based on a text file
     */
    public void drawLocation() {
        clearCanvas();
        List<String> map = data.readData(AssetType.MAP, textMapLocation);
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
    public void drawLocation(Direction directionTo) {
        clearCanvas();
        List<String> map = data.readData(AssetType.MAP, textMapLocation);
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
    public void drawPlayer() {

        player.drawPlayer(playerXLocation * tileSize, playerYLocation * tileSize);
    }

    /**
     * Called from user input,
     * to interact with the tiles that are interact-able.
     */
    public void interact() {
        SoundPlayer sound = new SoundPlayer(this);
        interactableType = (InteractableType) currentTileMap.get(characters[playerXLocation][playerYLocation]).getInteractableType();
        switch (interactableType) {
            case NORTH:
                direction = currentMapLocation.getNorthExit().getDirectionTo();
                currentMapLocation = locationMap.get(currentMapLocation.getNorthExit().getToLocationName());
                textMapLocation = currentMapLocation.getTextMapFileLocation();
                drawLocation(direction);
                drawPlayer();
                sound.playDoorSound();
                break;
            case WEST:
                direction = currentMapLocation.getWestExit().getDirectionTo();
                currentMapLocation = locationMap.get(currentMapLocation.getWestExit().getToLocationName());
                textMapLocation = currentMapLocation.getTextMapFileLocation();
                drawLocation(direction);
                drawPlayer();
                sound.playDoorSound();
                break;
            case SOUTH:
                direction = currentMapLocation.getSouthExit().getDirectionTo();
                currentMapLocation = locationMap.get(currentMapLocation.getSouthExit().getToLocationName());
                textMapLocation = currentMapLocation.getTextMapFileLocation();
                drawLocation(direction);
                drawPlayer();
                sound.playDoorSound();
                break;
            case EAST:
                direction = currentMapLocation.getEastExit().getDirectionTo();
                currentMapLocation = locationMap.get(currentMapLocation.getEastExit().getToLocationName());
                textMapLocation = currentMapLocation.getTextMapFileLocation();
                drawLocation(direction);
                drawPlayer();
                sound.playDoorSound();
                break;
            case CONSOLE:
                sound.playInteractionSound();
                break;
        }
    }

    /**
     * Move player 1 tile upwards (negative y axis)
     */
    public void movePlayerUP() {
        if (currentTileMap.get(characters[playerXLocation][playerYLocation - 1]).getSolid() == false) {
            playerYLocation -= 1;
            drawLocation();
            drawPlayer();
        }

    }

    /**
     * Move player 1 tile to the left (negative x axis)
     */
    public void movePlayerLeft() {
        if (currentTileMap.get(characters[playerXLocation - 1][playerYLocation]).getSolid() == false) {
            playerXLocation -= 1;
            drawLocation();
            drawPlayer();
        }
    }

    /**
     * Move player 1 tile downwards (positive y axis)
     */
    public void movePlayerDown() {
        if (currentTileMap.get(characters[playerXLocation][playerYLocation + 1]).getSolid() == false) {
            playerYLocation += 1;
            drawLocation();
            drawPlayer();
        }
    }

    /**
     * Move player 1 tile to the right (positive x axis)
     */
    public void movePlayerRight() {
        if (currentTileMap.get(characters[playerXLocation + 1][playerYLocation]).getSolid() == false) {
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
    
    public String getCurrentLocationName(){
        return currentLocationName;
    }

}
