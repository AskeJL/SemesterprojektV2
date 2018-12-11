package domain.locations.gameobjects;

import domain.GameUpdateable;
import domain.Manager;
import domain.locations.GameObjectType;
import domain.resources.ResourcesManager;
import domain.systems.SystemsManager;
import java.io.File;
import java.util.HashMap;
import javafx.scene.image.Image;

/**
 * Tile manager class,
 * extends Manager,
 * implements GameUpdateable
 * 
 */
public class TileManager extends Manager implements GameUpdateable{
    
    private final HashMap <Character, Tile> tileMap = new HashMap<>();
    
    private Tile floor;
    private final String FLOOR_FILE_PATH = "assets/pictures/floor.png";
    private final Image FLOOR_IMAGE = new Image(new File(FLOOR_FILE_PATH).toURI().toString());
    
    private Tile wall;
    private final String HORIZONTAL_WALL_FILE_PATH = "assets/pictures/wall.png";
    private final Image HORIZONTAL_WALL_IMAGE = new Image(new File(HORIZONTAL_WALL_FILE_PATH).toURI().toString());
    
    private Tile laserConsole;
    private final String LASER_CONSOLE_FILE_PATH = "assets/pictures/laserConsole.png";
    private final Image LASER_CONSOLE_IMAGE = new Image(new File(LASER_CONSOLE_FILE_PATH).toURI().toString());
    private Tile netConsole;
    private final String NET_CONSOLE_FILE_PATH = "assets/pictures/netConsole.png";
    private final Image NET_CONSOLE_IMAGE = new Image(new File(NET_CONSOLE_FILE_PATH).toURI().toString());
    private Tile oxygenConsole;
    private final String OXYGEN_CONSOLE_FILE_PATH = "assets/pictures/oxygenConsole.png";
    private final Image OXYGEN_CONSOLE_IMAGE = new Image(new File(OXYGEN_CONSOLE_FILE_PATH).toURI().toString());
    private Tile scanningConsole;
    private final String SCANNING_CONSOLE_FILE_PATH = "assets/pictures/scanningConsole.png";
    private final Image SCANNING_CONSOLE_IMAGE = new Image(new File(SCANNING_CONSOLE_FILE_PATH).toURI().toString());
    private Tile controlConsole;
    private final String CONTROL_CONSOLE_FILE_PATH = "assets/pictures/controlConsole.png";
    private final Image CONTROL_CONSOLE_IMAGE = new Image(new File(CONTROL_CONSOLE_FILE_PATH).toURI().toString());
    private Tile outsideConsole;
    private final String OUTSIDE_CONSOLE_FILE_PATH = "assets/pictures/outsideConsole.png";
    private final Image OUTISDE_CONSOLE_IMAGE = new Image(new File(OUTSIDE_CONSOLE_FILE_PATH).toURI().toString());
    
    private Tile northExit;
    private final String NORTH_EXIT_FILE_PATH = "assets/pictures/exit.png";
    private final Image NORTH_EXIT_IMAGE = new Image(new File(NORTH_EXIT_FILE_PATH).toURI().toString());
    private Tile westExit;
    private final String WEST_EXIT_FILE_PATH = "assets/pictures/exit.png";
    private final Image WEST_EXIT_IMAGE = new Image(new File(WEST_EXIT_FILE_PATH).toURI().toString());
    private Tile southExit;
    private final String SOUTH_EXIT_FILE_PATH = "assets/pictures/exit.png";
    private final Image SOUTH_EXIT_IMAGE = new Image(new File(SOUTH_EXIT_FILE_PATH).toURI().toString());
    private Tile eastExit;
    private final String EAST_EXIT_FILE_PATH = "assets/pictures/exit.png";
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
        this.wall = new Tile('+', true, GameObjectType.DECORATION, null, this.HORIZONTAL_WALL_IMAGE);
        
        this.laserConsole = new Tile('!', false, GameObjectType.CONTROL, new LaserControl(((SystemsManager)this.fetchController(SystemsManager.class))), this.LASER_CONSOLE_IMAGE);
        this.netConsole = new Tile('#', false, GameObjectType.CONTROL, new NetControl(((SystemsManager)this.fetchController(SystemsManager.class))), this.NET_CONSOLE_IMAGE);
        this.oxygenConsole = new Tile(';', false, GameObjectType.CONTROL, new OxygenControl(((ResourcesManager)this.fetchController(ResourcesManager.class))), this.OXYGEN_CONSOLE_IMAGE);
        this.scanningConsole = new Tile('?', false, GameObjectType.CONTROL, new ScanningControl(((SystemsManager)this.fetchController(SystemsManager.class))), this.SCANNING_CONSOLE_IMAGE);
        this.outsideConsole = new Tile('*', false, GameObjectType.CONTROL, new DamageRepair(((ResourcesManager)this.fetchController(ResourcesManager.class))), this.OUTISDE_CONSOLE_IMAGE);
        this.controlConsole = new Tile('^', false, GameObjectType.CONTROL, new SteeringControl(((SystemsManager)this.fetchController(SystemsManager.class))), this.CONTROL_CONSOLE_IMAGE);
      
        this.northExit = new Tile('n', false, GameObjectType.NORTH, new NorthExit(), this.NORTH_EXIT_IMAGE);
        this.westExit = new Tile('w', false, GameObjectType.WEST, new WestExit(), this.WEST_EXIT_IMAGE);
        this.southExit = new Tile('s', false, GameObjectType.SOUTH, new SouthExit(), this.SOUTH_EXIT_IMAGE);
        this.eastExit = new Tile('e', false, GameObjectType.EAST, new EastExit(), this.EAST_EXIT_IMAGE);
        
        this.nothing = new Tile('0', true, GameObjectType.DECORATION, null, this.NOTHING_IMAGE);
    }
    private void createTileMap(){
        
        getTileMap().put(this.floor.getSYMBOL(), this.floor);
        getTileMap().put(this.wall.getSYMBOL(), this.wall);
        
        getTileMap().put(this.laserConsole.getSYMBOL(), this.laserConsole);
        getTileMap().put(this.netConsole.getSYMBOL(), this.netConsole);
        getTileMap().put(this.oxygenConsole.getSYMBOL(), this.oxygenConsole);
        getTileMap().put(this.scanningConsole.getSYMBOL(), this.scanningConsole);
        getTileMap().put(this.outsideConsole.getSYMBOL(), this.outsideConsole);
        getTileMap().put(this.controlConsole.getSYMBOL(), this.controlConsole);
        
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
