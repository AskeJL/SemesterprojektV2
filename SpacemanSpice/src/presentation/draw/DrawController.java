package presentation.draw;

import data.AssetType;
import data.Data;
import domain.DomainReader;
import domain.DomainRequester;
import domain.GameElement;
import domain.locations.*;
import domain.locations.gameobjects.Player;
import domain.locations.gameobjects.Tile;
import java.util.HashMap;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import presentation.controllers.ViewController_Game;
import presentation.GUIManager;

/**
 * This is responsible for drawing the various game elements on 
 * the canvas of Game view, based on the current location and the 
 * players position. As well as keeping track of these.
 * <p>
 * Upon initialization ({@link #setup() }) will setup all the necessary
 * information for keeping track of the current location, maps
 * and player position.
 */
public class DrawController extends GameElement {

    private GraphicsContext gc;
    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();
    
    private HashMap<Character, Tile> currentTileMap;
    private HashMap<String, Location> locationMap;
    
    private final String startingLocationName = "Personal";
    private String currentLocationName = "Personal";
    private Location currentMapLocation;
    private String textMapLocation;
    private String textMap;
    
    private Player player;
    private int playerXLocation;
    private int playerYLocation;
    
    private final Data data = new Data();
    private char[][] symbolArray;
    private final int tileNumberXAxis = 28;
    private final int tileNumberYAxis = 16;
    private final int tileSize = 32;

    private GameObjectType actionType;
    private char exitDirection;

    @Override
    public void init() {
        
    }
    
    /**
     * Instantiates the components needed to be drawn on the canvas.
     */
    public void setup() {
        GUIManager gui = (GUIManager)gameElementGroup.getManager();
        gc = ((ViewController_Game)gui.getController(gui.getGameViewPath())).getGraphicsContext();
        
        currentTileMap = requester.requestTileMap();
        locationMap = requester.requestLocationsMap();
        currentLocationName = startingLocationName;
        currentMapLocation = locationMap.get(currentLocationName);
        textMapLocation = currentMapLocation.getTextMapLocation();

        player = requester.requestPlayer();
        playerXLocation = player.getxPosition() + 19;
        playerYLocation = player.getyPosition() + 10;

    }
    
    /**
     * Clears the canvas in preparation for the next time components will be 
     * drawn on it.
     */

    public void clearCanvas() {
        int canvasWidth = 900;
        int canvasHeight = 540;
        gc.clearRect(0, 0, canvasWidth, canvasHeight);
    }

    /**
     * Draws a location on the canvas, based on a text file of the current map.
     */
    public void drawLocation() {
        clearCanvas();
        List<String> map = data.readData(AssetType.MAP, textMapLocation);
        symbolArray = convertToCharArray(map, tileNumberXAxis, tileNumberYAxis);
        for (int x = 0; x < symbolArray.length; x++) {
            for (int y = 0; y < symbolArray[x].length; y++) {
                Image img = currentTileMap.get(symbolArray[x][y]).getTileImage();
                gc.drawImage(img, x * tileSize, y * tileSize);
            }
        }
    }

    /**
     * Uses ({@link #clearCanvas()}) to prepare the canvas and
     * draws a location on the screen, based on a text file.
     * Sets a new player position on the new drawn map depending on
     * the exit tile that the player interacted to begin with. 
     * See ({@link #interact()})
     *
     * @param exitTile
     */
    public void drawLocation(Tile exitTile) {
        clearCanvas();
        List<String> map = data.readData(AssetType.MAP, textMapLocation);
        symbolArray = convertToCharArray(map, tileNumberXAxis, tileNumberYAxis);
        requester.requestSetCurrentLocation(this.currentMapLocation);
        for (int x = 0; x < symbolArray.length; x++) {
            for (int y = 0; y < symbolArray[x].length; y++) {
                if (currentTileMap.get(symbolArray[x][y]) == exitTile) {
                    playerXLocation = x;
                    playerYLocation = y;
                }
                Image img = currentTileMap.get(symbolArray[x][y]).getTileImage();
                gc.drawImage(img, x * tileSize, y * tileSize);
            }
        }
    }

    /**
     * Draws the player based on its current position.
     */
    public void drawPlayer() {
        gc.drawImage(player.getPlayerImage(), playerXLocation * tileSize, playerYLocation * tileSize);
    }

    /**
     * Called from ({@link presentation.controllers.ViewController_Game}), 
     * used to interact with the tile based on player position.
     * Updates ({@link #currentMapLocation}) and ({@link #textMapLocation}),
     * 
     */
    public void interact() {
        if (currentTileMap.get(symbolArray[playerXLocation][playerYLocation]).getGameObjectType() != GameObjectType.DECORATION) {
            actionType = currentTileMap.get(symbolArray[playerXLocation][playerYLocation]).getGameObjectType();
            currentTileMap.get(symbolArray[playerXLocation][playerYLocation]).getGameObject().interact();
            switch (actionType) {
                case NORTH:
                    exitDirection = currentMapLocation.getNorthExit().getTileExit();
                    currentMapLocation = locationMap.get(currentMapLocation.getNorthExit().getTargetLocation());
                    textMapLocation = currentMapLocation.getTextMapLocation();
                    this.currentLocationName = this.currentMapLocation.getName();
                    drawLocation(currentTileMap.get(exitDirection));
                    drawPlayer();
                    requester.requestDoorSound();
                    break;
                case WEST:
                    exitDirection = currentMapLocation.getWestExit().getTileExit();
                    currentMapLocation = locationMap.get(currentMapLocation.getWestExit().getTargetLocation());
                    textMapLocation = currentMapLocation.getTextMapLocation();
                    drawLocation(currentTileMap.get(exitDirection));
                    this.currentLocationName = this.currentMapLocation.getName();
                    drawPlayer();
                    requester.requestDoorSound();
                    break;
                case SOUTH:
                    exitDirection = currentMapLocation.getSouthExit().getTileExit();
                    currentMapLocation = locationMap.get(currentMapLocation.getSouthExit().getTargetLocation());
                    textMapLocation = currentMapLocation.getTextMapLocation();
                    drawLocation(currentTileMap.get(exitDirection));
                    this.currentLocationName = this.currentMapLocation.getName();
                    drawPlayer();
                    requester.requestDoorSound();
                    break;
                case EAST:
                    exitDirection = currentMapLocation.getEastExit().getTileExit();
                    currentMapLocation = locationMap.get(currentMapLocation.getEastExit().getTargetLocation());
                    textMapLocation = currentMapLocation.getTextMapLocation();
                    drawLocation(currentTileMap.get(exitDirection));
                    this.currentLocationName = this.currentMapLocation.getName();
                    drawPlayer();
                    requester.requestDoorSound();
                    break;
                case CONTROL:
                    break;
            }
        }
    }

    /**
     * Takes ({@link #playerYLocation}) and moves the player position by 1 tile upwards (negative y axis)
     */
    public void movePlayerUP() {
        if (currentTileMap.get(symbolArray[playerXLocation][playerYLocation - 1]).getSolid() == false) {
            playerYLocation -= 1;
            drawLocation();
            drawPlayer();
        }

    }

    /**
     * Takes ({@link #playerXLocation}) and moves the player position by 1 tile to the left (negative x axis)
     */
    public void movePlayerLeft() {
        if (currentTileMap.get(symbolArray[playerXLocation - 1][playerYLocation]).getSolid() == false) {
            playerXLocation -= 1;
            drawLocation();
            drawPlayer();
        }
    }

    /**
     * Takes ({@link #playerYLocation}) and moves the player position by 1 tile downwards (positive y axis)
     */
    public void movePlayerDown() {
        if (currentTileMap.get(symbolArray[playerXLocation][playerYLocation + 1]).getSolid() == false) {
            playerYLocation += 1;
            drawLocation();
            drawPlayer();
        }
    }

    /**
     *Takes ({@link #playerXLocation}) and moves the player position by 1 tile to the right (positive x axis)
     */
    public void movePlayerRight() {
        if (currentTileMap.get(symbolArray[playerXLocation + 1][playerYLocation]).getSolid() == false) {
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
