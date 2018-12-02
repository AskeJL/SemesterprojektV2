package presentation.tiles;

import java.util.HashMap;
import javafx.scene.paint.Color;

/**
 * Tile controller class,
 * that creates various tiles and categorizes them into a map.
 * 
 */
public class TileController {
    
    private HashMap<Character, Tile> tileMap = new HashMap<>();
    
    private Tile floor;
    private Tile wall;
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
        this.floor = new Tile(TileType.FLOOR, Color.AQUA, '.', false, InteractableType.NOTHING);
        this.wall = new Tile(TileType.WALL, Color.BROWN, '+', true ,InteractableType.NOTHING);
        this.console = new Tile(TileType.CONSOLE, Color.RED, '-', true, InteractableType.CONSOLE);
        
        this.northExit = new Tile(TileType.NORTH_EXIT, Color.DARKCYAN, 'N', false, InteractableType.NORTH);
        this.northDoor = new Tile(TileType.DOOR, Color.DARKCYAN, 'n', false, InteractableType.NORTH);
        
        this.westExit = new Tile(TileType.WEST_EXIT, Color.GREEN, 'W', false, InteractableType.WEST);
        this.westDoor = new Tile(TileType.DOOR, Color.GREEN, 'w', false, InteractableType.WEST);
        
        this.southExit = new Tile(TileType.SOUTH_EXIT, Color.GREY, 'S', false, InteractableType.SOUTH);
        this.southDoor = new Tile(TileType.DOOR, Color.GREY, 's', false, InteractableType.SOUTH);
        
        this.eastExit = new Tile(TileType.EAST_EXIT, Color.YELLOW, 'E',false, InteractableType.EAST);
        this.eastDoor = new Tile(TileType.DOOR, Color.YELLOW, 'e',false, InteractableType.EAST);
        
        this.nothing = new Tile(TileType.NOTHING, Color.BLACK, ' ',true, InteractableType.NOTHING);
        
        tileMap.put(floor.getSYMBOL(), floor);
        tileMap.put(wall.getSYMBOL(), wall);
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
        return wall;
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
