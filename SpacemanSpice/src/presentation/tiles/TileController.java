package presentation.tiles;

import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Tile controller class,
 * that creates various tiles and categorizes them into a map.
 * 
 */
public class TileController {
    
    private HashMap<Character, Tile> tileMap = new HashMap<>();
    
    private Tile floor;
    private Tile northWall;
    private Tile westWall;
    private Tile southWall;
    private Tile eastWall;
    
    private Tile console;
    
    private Tile northExit;
    private Tile northDoor;
    private Tile westExit;
    private Tile westDoor;
    private Tile southExit;
    private Tile southDoor;
    private Tile eastExit;
    private Tile eastDoor;
         
    private Tile nothing;
    
    /**
     * Tile controller constructor
     */
    public TileController(){
        this.floor = new Tile(TileType.FLOOR, Color.AQUA, '.',new Image(getClass().getResourceAsStream("floorTile.png")), false, InteractableType.NOTHING, null);
        
        this.northWall = new Tile(TileType.WALL, Color.BROWN, '-', new Image(getClass().getResourceAsStream("northWall.png")), true ,InteractableType.NOTHING, null);
        this.westWall = new Tile(TileType.WALL, Color.BROWN, '\\', new Image(getClass().getResourceAsStream("westWall.png")), true ,InteractableType.NOTHING, null);
        this.southWall = new Tile(TileType.WALL, Color.BROWN, '_', new Image(getClass().getResourceAsStream("southWall.png")), true ,InteractableType.NOTHING, null);
        this.eastWall = new Tile(TileType.WALL, Color.BROWN, '/', new Image(getClass().getResourceAsStream("eastWall.png")), true ,InteractableType.NOTHING, null);
        
        
        
        this.console = new Tile(TileType.CONSOLE, Color.RED, '+', null, true, InteractableType.CONSOLE, null);
        
        this.northExit = new Tile(TileType.NORTH_EXIT, Color.DARKCYAN, 'N',new Image(getClass().getResourceAsStream("northExit.png")), false, InteractableType.NORTH, Direction.NORTH);
        this.northDoor = new Tile(TileType.DOOR, Color.DARKCYAN, 'n', new Image(getClass().getResourceAsStream("northExit.png")), false, InteractableType.NORTH, Direction.NORTH);
        
        this.westExit = new Tile(TileType.WEST_EXIT, Color.GREEN, 'W', new Image(getClass().getResourceAsStream("westExit.png")), false, InteractableType.WEST, Direction.WEST);
        this.westDoor = new Tile(TileType.DOOR, Color.GREEN, 'w', new Image(getClass().getResourceAsStream("westExit.png")), false, InteractableType.WEST, Direction.WEST);
        
        this.southExit = new Tile(TileType.SOUTH_EXIT, Color.GREY, 'S',new Image(getClass().getResourceAsStream("southExit.png")), false, InteractableType.SOUTH, Direction.SOUTH);
        this.southDoor = new Tile(TileType.DOOR, Color.GREY, 's', new Image(getClass().getResourceAsStream("southExit.png")), false, InteractableType.SOUTH, Direction.SOUTH);
        
        this.eastExit = new Tile(TileType.EAST_EXIT, Color.YELLOW, 'E', new Image(getClass().getResourceAsStream("eastExit.png")), false, InteractableType.EAST, Direction.EAST);
        this.eastDoor = new Tile(TileType.DOOR, Color.YELLOW, 'e', new Image(getClass().getResourceAsStream("eastExit.png")), false, InteractableType.EAST, Direction.EAST);
        
        this.nothing = new Tile(TileType.NOTHING, Color.BLACK, '0', null, true, InteractableType.NOTHING, null);
        
        tileMap.put(floor.getSYMBOL(), floor);
        
        tileMap.put(northWall.getSYMBOL(), northWall);
        tileMap.put(westWall.getSYMBOL(), westWall);
        tileMap.put(southWall.getSYMBOL(), southWall);
        tileMap.put(eastWall.getSYMBOL(), eastWall);
        
        tileMap.put(console.getSYMBOL(), console);
        tileMap.put(northExit.getSYMBOL(), northExit);
        tileMap.put(northDoor.getSYMBOL(), northDoor);
        tileMap.put(westExit.getSYMBOL(), westExit);
        tileMap.put(westDoor.getSYMBOL(), westDoor);
        tileMap.put(southExit.getSYMBOL(), southExit);
        tileMap.put(southDoor.getSYMBOL(), southDoor);
        tileMap.put(eastExit.getSYMBOL(), eastExit);
        tileMap.put(eastDoor.getSYMBOL(), eastDoor);
        tileMap.put(nothing.getSYMBOL(), nothing);
    }

    /**
     * @return the tileMap
     */
    public HashMap<Character, Tile> getTileMap() {
        return tileMap;
    }

    /**
     * @param tileMap the tileMap to set
     */
    public void setTileMap(HashMap<Character, Tile> tileMap) {
        this.tileMap = tileMap;
    }

    /**
     * @return the floor
     */
    public Tile getFloor() {
        return floor;
    }

    /**
     * @return the wall
     */
    public Tile getWall() {
        return northWall;
    }

    /**
     * @return the console
     */
    public Tile getConsole() {
        return console;
    }

    /**
     * @return the northExit
     */
    public Tile getNorthExit() {
        return northExit;
    }

    /**
     * @return the northDoor
     */
    public Tile getNorthDoor() {
        return northDoor;
    }

    /**
     * @param northDoor the northDoor to set
     */
    public void setNorthDoor(Tile northDoor) {
        this.northDoor = northDoor;
    }

    /**
     * @return the westExit
     */
    public Tile getWestExit() {
        return westExit;
    }

    /**
     * @return the southExit
     */
    public Tile getSouthExit() {
        return southExit;
    }

    /**
     * @return the eastExit
     */
    public Tile getEastExit() {
        return eastExit;
    }

    /**
     * @return the nothing
     */
    public Tile getNothing() {
        return nothing;
    }
}
