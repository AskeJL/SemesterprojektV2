package presentation.tiles;

import java.util.HashMap;
import javafx.scene.paint.Color;

public class TileController {
    
    private HashMap<Character, Tile> tileMap = new HashMap<>();
    
    private Tile floor;
    private Tile wall;
    private Tile console;
    private Tile northExit;
    private Tile westExit;
    private Tile southExit;
    private Tile eastExit;
    private Tile nothing;
    
    public TileController(){
        this.floor = new Tile(TileType.FLOOR, Color.AQUA, '.', false);
        this.wall = new Tile(TileType.WALL, Color.BROWN, '+', true);
        this.console = new Tile(TileType.CONSOLE, Color.RED, '-', true);
        this.northExit = new Tile(TileType.NORTH_EXIT, Color.DARKCYAN, 'N', true);
        this.westExit = new Tile(TileType.WEST_EXIT, Color.GREEN, 'W', true);
        this.southExit = new Tile(TileType.SOUTH_EXIT, Color.GREY, 'S', true);
        this.eastExit = new Tile(TileType.EAST_EXIT, Color.YELLOW, 'E',true);
        this.nothing = new Tile(TileType.NOTHING, Color.BLACK, ' ',true);
        
        tileMap.put(floor.getSYMBOL(), floor);
        tileMap.put(wall.getSYMBOL(), wall);
        tileMap.put(console.getSYMBOL(), console);
        tileMap.put(northExit.getSYMBOL(), northExit);
        tileMap.put(southExit.getSYMBOL(), southExit);
        tileMap.put(westExit.getSYMBOL(), westExit);
        tileMap.put(eastExit.getSYMBOL(), eastExit);
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
