package domain.locations.gameobjects;

import domain.GameUpdateable;
import domain.Manager;
import domain.resources.ResourcesManager;
import domain.systems.SystemsManager;
import java.util.HashMap;

public class TileManager extends Manager implements GameUpdateable {

    private final HashMap<Character, Tile> tileMap = new HashMap<>();
    
    private Tile floor;
    private final String FLOOR_IMAGE_PATH = "assets/pictures/floor";
    
    private Tile horizontalWall;
    private final String HORIZONTAL_WALL_IMAGE_PATH = "assets/pictures/horizontalWall";
    private Tile verticalWall;
    private final String VERTICAL_WALL_IMAGE_PATH = "assets/pictures/verticalWall";
    
    private Tile northwestCorner;
    private final String NORTHWEST_CORNER_IMAGE_PATH = "assets/pictures/northwestCorner";
    private Tile southwestCorner;
    private final String SOUTHWEST_CORNER_IMAGE_PATH = "assets/pictures/southwestCorner";
    private Tile southeastCorner;
    private final String SOUTHEAST_CORNER_IMAGE_PATH = "assets/pictures/southeastCorner";
    private Tile northeastCorner;
    private final String NORTHEAST_CORNER_IMAGE_PATH = "assets/pictures/northeastCorner";
    
    private Tile northExit;
    private final String NORTH_EXIT_IMAGE_PATH = "assets/pictures/northExit";
    private Tile westExit;
    private final String WEST_EXIT_IMAGE_PATH = "assets/pictures/westExit";
    private Tile southExit;
    private final String SOUTH_EXIT_IMAGE_PATH = "assets/pictures/southExit";
    private Tile eastExit;
    private final String EAST_EXIT_IMAGE_PATH = "assets/pictures/eastExit";
    
    private Tile  damageRepair;
    private final String DAMAGE_REPAIR_IMAGE_PATH = "assets/pictures/eastExit";
    private Tile laserControl;
    private final String LASER_CONTROL_IMAGE_PATH = "assets/pictures/eastExit";
    private Tile netControl;
    private final String NET_CONTROL_IMAGE_PATH = "assets/pictures/eastExit";
    private Tile oxygenControl;
    private final String OXYGEN_CONTROL_IMAGE_PATH = "assets/pictures/eastExit";
    private Tile scanningControl;
    private final String SCANNING_CONTROL_IMAGE_PATH = "assets/pictures/eastExit";
    private Tile steeringControl;
    private final String STEERING_CONTROL_IMAGE_PATH = "assets/pictures/eastExit";
    
    
    private Tile nothing;
    
    @Override
    public void init() {
        
        createTiles();
        
        getTileMap().put(floor.getSYMBOL(), floor);
        
        getTileMap().put(horizontalWall.getSYMBOL(), horizontalWall);
        getTileMap().put(verticalWall.getSYMBOL(), verticalWall);
        
        getTileMap().put(northwestCorner.getSYMBOL(), northwestCorner);
        getTileMap().put(southwestCorner.getSYMBOL(), southwestCorner);
        getTileMap().put(southeastCorner.getSYMBOL(), southeastCorner);
        getTileMap().put(northeastCorner.getSYMBOL(), northeastCorner);
        
        getTileMap().put(northExit.getSYMBOL(), northExit);
        getTileMap().put(westExit.getSYMBOL(), westExit);
        getTileMap().put(southExit.getSYMBOL(), southExit);
        getTileMap().put(eastExit.getSYMBOL(), eastExit);
        
        getTileMap().put(damageRepair.getSYMBOL(), damageRepair);
        getTileMap().put(laserControl.getSYMBOL(), laserControl);
        getTileMap().put(netControl.getSYMBOL(), netControl);
        getTileMap().put(oxygenControl.getSYMBOL(), oxygenControl);
        getTileMap().put(scanningControl.getSYMBOL(), scanningControl);
        getTileMap().put(steeringControl.getSYMBOL(), steeringControl);
        
        getTileMap().put(nothing.getSYMBOL(), nothing);
        
        super.init();
    }
    
    @Override
    public void update(){
        super.update();
    }
    
    private void createTiles(){
        
        this.floor = new Tile("Floor", '.', null, GameObjectType.DECORATION, false, null, this.getFLOOR_IMAGE_PATH());
        
        this.horizontalWall = new Tile("Horizontal wall", '-', null, GameObjectType.DECORATION, true, null, this.getHORIZONTAL_WALL_IMAGE_PATH());
        this.verticalWall = new Tile("Vertical wall", '/', null, GameObjectType.DECORATION, true, null, this.getVERTICAL_WALL_IMAGE_PATH());
        
        this.northwestCorner = new Tile("Northwest corner", '[', null, GameObjectType.DECORATION, true, null, this.getNORTHWEST_CORNER_IMAGE_PATH());
        this.southwestCorner = new Tile("Southwest corner", '(', null, GameObjectType.DECORATION, true, null, this.getSOUTHWEST_CORNER_IMAGE_PATH());
        this.southeastCorner = new Tile("Southeast corner", ')', null, GameObjectType.DECORATION, true, null, this.getSOUTHEAST_CORNER_IMAGE_PATH());
        this.northeastCorner = new Tile("Northeast corner", ']', null, GameObjectType.DECORATION, true, null, this.getNORTHEAST_CORNER_IMAGE_PATH());
        
        this.northExit = new Tile("North exit", 'n', null, GameObjectType.EXIT, true, null, this.getNORTH_EXIT_IMAGE_PATH());
        this.westExit = new Tile("West exit", 'w', null, GameObjectType.EXIT, true, null, this.getWEST_EXIT_IMAGE_PATH());
        this.southExit = new Tile("South exit", 's', null, GameObjectType.EXIT, true, null, this.getSOUTH_EXIT_IMAGE_PATH());
        this.eastExit = new Tile("East exit", 'e', null, GameObjectType.EXIT, true, null, this.getEAST_EXIT_IMAGE_PATH());
        
        this.damageRepair = new Tile("Damage repair", '*', "Here you can repair some of the ships damage", GameObjectType.CONTROL, false,new DamageRepair((ResourcesManager)this.fetchController(ResourcesManager.class)), this.getDAMAGE_REPAIR_IMAGE_PATH());
        this.laserControl = new Tile("Laser Control", '!', "The laser is operated from here.", GameObjectType.CONTROL, false, new LaserControl((SystemsManager)this.fetchController(SystemsManager.class)), this.getLASER_CONTROL_IMAGE_PATH());
        this.netControl = new Tile("Net Control", '#', "The net is controlled from here.", GameObjectType.CONTROL, false, new NetControl((SystemsManager)this.fetchController(SystemsManager.class)), this.getNET_CONTROL_IMAGE_PATH());
        this.oxygenControl = new Tile("Oxygen control", '¤', "This is the refilling station for oxygen", GameObjectType.CONTROL, false, new OxygenControl((ResourcesManager)this.fetchController(ResourcesManager.class)), this.getOXYGEN_CONTROL_IMAGE_PATH());  
        this.scanningControl = new Tile("Scanning control", '?', "This is the scanningstation", GameObjectType.CONTROL, false, new ScanningControl((SystemsManager)this.fetchController(SystemsManager.class)), this.getSCANNING_CONTROL_IMAGE_PATH());
        this.steeringControl = new Tile("Steering Control", '^', "The ship is flown from here.", GameObjectType.CONTROL, false, new SteeringControl((SystemsManager)this.fetchController(SystemsManager.class)), this.getSTEERING_CONTROL_IMAGE_PATH());
        
        this.nothing = new Tile(null, '0', null, null, true, null, null);
    }
    
    public void resetTileMap(){
        
        getTileMap().clear();
    }

    /**
     * @return the tileMap
     */
    public HashMap<Character, Tile> getTileMap() {
        return tileMap;
    }

    /**
     * @return the FLOOR_IMAGE_PATH
     */
    public String getFLOOR_IMAGE_PATH() {
        return FLOOR_IMAGE_PATH;
    }

    /**
     * @return the HORIZONTAL_WALL_IMAGE_PATH
     */
    public String getHORIZONTAL_WALL_IMAGE_PATH() {
        return HORIZONTAL_WALL_IMAGE_PATH;
    }

    /**
     * @return the VERTICAL_WALL_IMAGE_PATH
     */
    public String getVERTICAL_WALL_IMAGE_PATH() {
        return VERTICAL_WALL_IMAGE_PATH;
    }

    /**
     * @return the NORTHWEST_CORNER_IMAGE_PATH
     */
    public String getNORTHWEST_CORNER_IMAGE_PATH() {
        return NORTHWEST_CORNER_IMAGE_PATH;
    }

    /**
     * @return the SOUTHWEST_CORNER_IMAGE_PATH
     */
    public String getSOUTHWEST_CORNER_IMAGE_PATH() {
        return SOUTHWEST_CORNER_IMAGE_PATH;
    }

    /**
     * @return the SOUTHEAST_CORNER_IMAGE_PATH
     */
    public String getSOUTHEAST_CORNER_IMAGE_PATH() {
        return SOUTHEAST_CORNER_IMAGE_PATH;
    }

    /**
     * @return the NORTHEAST_CORNER_IMAGE_PATH
     */
    public String getNORTHEAST_CORNER_IMAGE_PATH() {
        return NORTHEAST_CORNER_IMAGE_PATH;
    }

    /**
     * @return the NORTH_EXIT_IMAGE_PATH
     */
    public String getNORTH_EXIT_IMAGE_PATH() {
        return NORTH_EXIT_IMAGE_PATH;
    }

    /**
     * @return the WEST_EXIT_IMAGE_PATH
     */
    public String getWEST_EXIT_IMAGE_PATH() {
        return WEST_EXIT_IMAGE_PATH;
    }

    /**
     * @return the SOUTH_EXIT_IMAGE_PATH
     */
    public String getSOUTH_EXIT_IMAGE_PATH() {
        return SOUTH_EXIT_IMAGE_PATH;
    }

    /**
     * @return the EAST_EXIT_IMAGE_PATH
     */
    public String getEAST_EXIT_IMAGE_PATH() {
        return EAST_EXIT_IMAGE_PATH;
    }

    /**
     * @return the DAMAGE_REPAIR_IMAGE_PATH
     */
    public String getDAMAGE_REPAIR_IMAGE_PATH() {
        return DAMAGE_REPAIR_IMAGE_PATH;
    }

    /**
     * @return the LASER_CONTROL_IMAGE_PATH
     */
    public String getLASER_CONTROL_IMAGE_PATH() {
        return LASER_CONTROL_IMAGE_PATH;
    }

    /**
     * @return the NET_CONTROL_IMAGE_PATH
     */
    public String getNET_CONTROL_IMAGE_PATH() {
        return NET_CONTROL_IMAGE_PATH;
    }

    /**
     * @return the OXYGEN_CONTROL_IMAGE_PATH
     */
    public String getOXYGEN_CONTROL_IMAGE_PATH() {
        return OXYGEN_CONTROL_IMAGE_PATH;
    }

    /**
     * @return the SCANNING_CONTROL_IMAGE_PATH
     */
    public String getSCANNING_CONTROL_IMAGE_PATH() {
        return SCANNING_CONTROL_IMAGE_PATH;
    }

    /**
     * @return the STEERING_CONTROL_IMAGE_PATH
     */
    public String getSTEERING_CONTROL_IMAGE_PATH() {
        return STEERING_CONTROL_IMAGE_PATH;
    }

}
