/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.locations.gameobjects;

import domain.GameUpdateable;
import domain.Manager;
import domain.locations.GameObjectType;
import domain.resources.ResourcesManager;
import java.io.File;
import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author Lupo
 */
public class TileManager extends Manager implements GameUpdateable{
    
    private final HashMap <Character, Tile> tileMap = new HashMap<>();
    
    private Tile floor;
    private final String FLOOR_FILE_PATH = "assets/pictures/floor.png";
    private final Image FLOOR_IMAGE = new Image(new File(FLOOR_FILE_PATH).toURI().toString());
    
    private Tile horizontalWall;
    private final String HORIZONTAL_WALL_FILE_PATH = "assets/pictures/horizontalWall.png";
    private final Image HORIZONTAL_WALL_IMAGE = new Image(new File(HORIZONTAL_WALL_FILE_PATH).toURI().toString());
    
    private Tile verticalWall;
    private final String VERTICAL_WALL_FILE_PATH = "assets/pictures/verticalWall.png";
    private final Image VERTICAL_WALL_IMAGE = new Image(new File(VERTICAL_WALL_FILE_PATH).toURI().toString());
    
    private Tile console;
    private final String CONSOLE_FILE_PATH = "assets/pictures/console.png";
    private final Image CONSOLE_IMAGE = new Image(new File(CONSOLE_FILE_PATH).toURI().toString());
    
    private Tile northWestCorner;
    private final String NORTHWEST_CORNER_FILE_PATH = "assets/pictures/northWestCorner.png";
    private final Image NORTHWEST_CORNER_IMAGE = new Image(new File(NORTHWEST_CORNER_FILE_PATH).toURI().toString());
    private Tile southWestCorner;
    private final String SOUTHWEST_CORNER_FILE_PATH = "assets/pictures/southWestCorner.png";
    private final Image SOUTHWEST_CORNER_IMAGE = new Image(new File(SOUTHWEST_CORNER_FILE_PATH).toURI().toString());
    private Tile southEastCorner;
    private final String SOUTHEAST_CORNER_FILE_PATH = "assets/pictures/southEastCorner.png";
    private final Image SOUTHEAST_CORNER_IMAGE = new Image(new File(SOUTHEAST_CORNER_FILE_PATH).toURI().toString());
    private Tile northEastCorner;
    private final String NORTHEAST_CORNER_FILE_PATH = "assets/pictures/northEastCorner.png";
    private final Image NORTHEAST_CORNER_IMAGE = new Image(new File(NORTHEAST_CORNER_FILE_PATH).toURI().toString());
    
    private Tile northExit;
    private final String NORTH_EXIT_FILE_PATH = "assets/pictures/northExit.png";
    private final Image NORTH_EXIT_IMAGE = new Image(new File(NORTH_EXIT_FILE_PATH).toURI().toString());
    private Tile westExit;
    private final String WEST_EXIT_FILE_PATH = "assets/pictures/westExit.png";
    private final Image WEST_EXIT_IMAGE = new Image(new File(WEST_EXIT_FILE_PATH).toURI().toString());
    private Tile southExit;
    private final String SOUTH_EXIT_FILE_PATH = "assets/pictures/southExit.png";
    private final Image SOUTH_EXIT_IMAGE = new Image(new File(SOUTH_EXIT_FILE_PATH).toURI().toString());
    private Tile eastExit;
    private final String EAST_EXIT_FILE_PATH = "assets/pictures/eastExit.png";
    private final Image EAST_EXIT_IMAGE = new Image(new File(EAST_EXIT_FILE_PATH).toURI().toString());
    
    private Tile nothing;
    private final String NOTHING_FILE_PATH = "assets/pictures/nothing.png";
    private final Image NOTHING_IMAGE = new Image(new File(NOTHING_FILE_PATH).toURI().toString());
    
    private Player player;
    
    @Override
    public void init(){
        createTiles();
        createTileMap();
        player = new Player();
        super.init();
    }
    
    @Override
    public void update(){
        super.update();
    }
    
    private void createTiles(){
        this.floor = new Tile('.', false, GameObjectType.DECORATION, null, this.FLOOR_IMAGE);
        this.horizontalWall = new Tile('-', true, GameObjectType.DECORATION, null, this.HORIZONTAL_WALL_IMAGE);
        this.verticalWall = new Tile('/', true, GameObjectType.DECORATION, null, this.VERTICAL_WALL_IMAGE);
        this.console = new Tile('+', false, GameObjectType.CONTROL, new DamageRepair(((ResourcesManager)this.fetchController(ResourcesManager.class))), this.CONSOLE_IMAGE);
        
        this.northWestCorner = new Tile('[', true, GameObjectType.DECORATION, null, this.NORTHWEST_CORNER_IMAGE);
        this.southWestCorner = new Tile('(', true, GameObjectType.DECORATION, null, this.SOUTHWEST_CORNER_IMAGE);
        this.southEastCorner = new Tile(')', true, GameObjectType.DECORATION, null, this.SOUTHEAST_CORNER_IMAGE);
        this.northEastCorner = new Tile(']', true, GameObjectType.DECORATION, null, this.NORTHEAST_CORNER_IMAGE);
        
        this.northExit = new Tile('n', false, GameObjectType.NORTH, new NorthExit(), this.NORTH_EXIT_IMAGE);
        this.westExit = new Tile('w', false, GameObjectType.WEST, new WestExit(), this.WEST_EXIT_IMAGE);
        this.southExit = new Tile('s', false, GameObjectType.SOUTH, new SouthExit(), this.SOUTH_EXIT_IMAGE);
        this.eastExit = new Tile('e', false, GameObjectType.EAST, new EastExit(), this.EAST_EXIT_IMAGE);
        
        this.nothing = new Tile('0', true, GameObjectType.NOTHING, null, this.NOTHING_IMAGE);
    }
    private void createTileMap(){
        
        getTileMap().put(this.floor.getSYMBOL(), this.floor);
        getTileMap().put(this.horizontalWall.getSYMBOL(), this.horizontalWall);
        getTileMap().put(this.verticalWall.getSYMBOL(), this.verticalWall);
        getTileMap().put(this.console.getSYMBOL(), this.console);
        
        getTileMap().put(this.northWestCorner.getSYMBOL(), this.northWestCorner);
        getTileMap().put(this.southWestCorner.getSYMBOL(), this.southWestCorner);
        getTileMap().put(this.southEastCorner.getSYMBOL(), this.southEastCorner);
        getTileMap().put(this.northEastCorner.getSYMBOL(), this.northEastCorner);
        
        getTileMap().put(this.northExit.getSYMBOL(), this.northExit);
        getTileMap().put(this.westExit.getSYMBOL(), this.westExit);
        getTileMap().put(this.southExit.getSYMBOL(), this.southExit);
        getTileMap().put(this.eastExit.getSYMBOL(), this.eastExit);
        
        getTileMap().put(this.nothing.getSYMBOL(), this.nothing);
        
    }
    
    public void clearTileMap(){
        getTileMap().clear();
    }

    /**
     * @return the tileMap
     */
    public HashMap <Character, Tile> getTileMap() {
        return tileMap;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }
}
