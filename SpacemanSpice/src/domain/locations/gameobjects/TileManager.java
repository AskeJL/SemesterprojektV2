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
    
    private Tile floor01;
    private final String FLOOR_01_FILE_PATH = "assets/pictures//floors/floor_01.png";
    private final Image FLOOR_01_IMAGE = new Image(new File(FLOOR_01_FILE_PATH).toURI().toString());
    private Tile floor02;
    private final String FLOOR_02_FILE_PATH = "assets/pictures/floors/floor_02.png";
    private final Image FLOOR_02_IMAGE = new Image(new File(FLOOR_02_FILE_PATH).toURI().toString());
    private Tile floor03;
    private final String FLOOR_03_FILE_PATH = "assets/pictures/floors/floor_03.png";
    private final Image FLOOR_03_IMAGE = new Image(new File(FLOOR_03_FILE_PATH).toURI().toString());
    private Tile floor04;
    private final String FLOOR_04_FILE_PATH = "assets/pictures/floors/floor_04.png";
    private final Image FLOOR_04_IMAGE = new Image(new File(FLOOR_04_FILE_PATH).toURI().toString());
    private Tile floor05;
    private final String FLOOR_05_FILE_PATH = "assets/pictures/floors/floor_05.png";
    private final Image FLOOR_05_IMAGE = new Image(new File(FLOOR_05_FILE_PATH).toURI().toString());
    private Tile floor06;
    private final String FLOOR_06_FILE_PATH = "assets/pictures/floors/floor_06.png";
    private final Image FLOOR_06_IMAGE = new Image(new File(FLOOR_06_FILE_PATH).toURI().toString());
    private Tile floor07;
    private final String FLOOR_07_FILE_PATH = "assets/pictures/floors/floor_07.png";
    private final Image FLOOR_07_IMAGE = new Image(new File(FLOOR_07_FILE_PATH).toURI().toString());
    private Tile floor08;
    private final String FLOOR_08_FILE_PATH = "assets/pictures/floors/floor_08.png";
    private final Image FLOOR_08_IMAGE = new Image(new File(FLOOR_08_FILE_PATH).toURI().toString());
    private Tile floor09;
    private final String FLOOR_09_FILE_PATH = "assets/pictures/floors/floor_09.png";
    private final Image FLOOR_09_IMAGE = new Image(new File(FLOOR_09_FILE_PATH).toURI().toString());
    private Tile floor10;
    private final String FLOOR_10_FILE_PATH = "assets/pictures/floors/floor_10.png";
    private final Image FLOOR_10_IMAGE = new Image(new File(FLOOR_10_FILE_PATH).toURI().toString());
    
    
    private Tile wall01;
    private final String WALL_01_FILE_PATH = "assets/pictures/walls/wall_01.png";
    private final Image WALL_01_IMAGE = new Image(new File(WALL_01_FILE_PATH).toURI().toString());
    private Tile wall02;
    private final String WALL_02_FILE_PATH = "assets/pictures/walls/wall_02.png";
    private final Image WALL_02_IMAGE = new Image(new File(WALL_02_FILE_PATH).toURI().toString());

    private Tile decoration01;
    private final String DECORATION_01_FILE_PATH = "assets/pictures/decorations/decoration_01.png";
    private final Image DECORATION_01_IMAGE = new Image(new File(DECORATION_01_FILE_PATH).toURI().toString());
    private Tile decoration02;
    private final String DECORATION_02_FILE_PATH = "assets/pictures/decorations/decoration_02.png";
    private final Image DECORATION_02_IMAGE = new Image(new File(DECORATION_02_FILE_PATH).toURI().toString());
    private Tile decoration03;
    private final String DECORATION_03_FILE_PATH = "assets/pictures/decorations/decoration_03.png";
    private final Image DECORATION_03_IMAGE = new Image(new File(DECORATION_03_FILE_PATH).toURI().toString());
    private Tile decoration04;
    private final String DECORATION_04_FILE_PATH = "assets/pictures/decorations/decoration_04.png";
    private final Image DECORATION_04_IMAGE = new Image(new File(DECORATION_04_FILE_PATH).toURI().toString());
    private Tile decoration05;
    private final String DECORATION_05_FILE_PATH = "assets/pictures/decorations/decoration_05.png";
    private final Image DECORATION_05_IMAGE = new Image(new File(DECORATION_05_FILE_PATH).toURI().toString());
    private Tile decoration06;
    private final String DECORATION_06_FILE_PATH = "assets/pictures/decorations/decoration_06.png";
    private final Image DECORATION_06_IMAGE = new Image(new File(DECORATION_06_FILE_PATH).toURI().toString());
    private Tile decoration07;
    private final String DECORATION_07_FILE_PATH = "assets/pictures/decorations/decoration_07.png";
    private final Image DECORATION_07_IMAGE = new Image(new File(DECORATION_07_FILE_PATH).toURI().toString());
    private Tile decoration08;
    private final String DECORATION_08_FILE_PATH = "assets/pictures/decorations/decoration_08.png";
    private final Image DECORATION_08_IMAGE = new Image(new File(DECORATION_08_FILE_PATH).toURI().toString());
    private Tile decoration09;
    private final String DECORATION_09_FILE_PATH = "assets/pictures/decorations/decoration_09.png";
    private final Image DECORATION_09_IMAGE = new Image(new File(DECORATION_09_FILE_PATH).toURI().toString());
    private Tile decoration10;
    private final String DECORATION_10_FILE_PATH = "assets/pictures/decorations/decoration_10.png";
    private final Image DECORATION_10_IMAGE = new Image(new File(DECORATION_10_FILE_PATH).toURI().toString());
    private Tile decoration11;
    private final String DECORATION_11_FILE_PATH = "assets/pictures/decorations/decoration_11.png";
    private final Image DECORATION_11_IMAGE = new Image(new File(DECORATION_11_FILE_PATH).toURI().toString());
    private Tile decoration12;
    private final String DECORATION_12_FILE_PATH = "assets/pictures/decorations/decoration_12.png";
    private final Image DECORATION_12_IMAGE = new Image(new File(DECORATION_12_FILE_PATH).toURI().toString());
    private Tile decoration13;
    private final String DECORATION_13_FILE_PATH = "assets/pictures/decorations/decoration_13.png";
    private final Image DECORATION_13_IMAGE = new Image(new File(DECORATION_13_FILE_PATH).toURI().toString());
    private Tile decoration14;
    private final String DECORATION_14_FILE_PATH = "assets/pictures/decorations/decoration_14.png";
    private final Image DECORATION_14_IMAGE = new Image(new File(DECORATION_14_FILE_PATH).toURI().toString());
    
    private Tile controllerLaser01;
    private final String CONTROLLER_LASER_01_FILE_PATH = "assets/pictures/controllers/controllerLaser.png";
    private final Image CONTROLLER_LASER_01_IMAGE = new Image(new File(CONTROLLER_LASER_01_FILE_PATH).toURI().toString());
    private Tile controllerLaser02;
    private final String CONTROLLER_LASER_02_FILE_PATH = "assets/pictures/controllers/controllerLaser.png";
    private final Image CONTROLLER_LASER_02_IMAGE = new Image(new File(CONTROLLER_LASER_02_FILE_PATH).toURI().toString());
    
    private Tile controllerNet01;
    private final String CONTROLLER_NET_01_FILE_PATH = "assets/pictures/controllers/controllerNet.png";
    private final Image CONTROLLER_NET_01_IMAGE = new Image(new File(CONTROLLER_NET_01_FILE_PATH).toURI().toString());
    private Tile controllerNet02;
    private final String CONTROLLER_NET_02_FILE_PATH = "assets/pictures/controllers/controllerNet.png";
    private final Image CONTROLLER_NET_02_IMAGE = new Image(new File(CONTROLLER_NET_02_FILE_PATH).toURI().toString());
    
    
    private final String CONTROLLER_OXYGEN_FILE_PATH = "assets/pictures/controllers/controllerOxygen.png";
    private final Image CONTROLLER_OXYGEN_IMAGE = new Image(new File(CONTROLLER_OXYGEN_FILE_PATH).toURI().toString());
    private Tile controllerOxygen01;
    private Tile controllerOxygen02;
    private Tile controllerOxygen03;
    private Tile controllerOxygen04;
    
    private Tile controllerScanning_01;
    private final String CONTROLLER_SCANNING_01_FILE_PATH = "assets/pictures/controllers/controllerScanning.png";
    private final Image CONTROLLER_SCANNING_01_IMAGE = new Image(new File(CONTROLLER_SCANNING_01_FILE_PATH).toURI().toString());
    
    private Tile controllerSteering_01;
    private final String CONTROLLER_STEERING_01_FILE_PATH = "assets/pictures/controllers/controllerSteering.png";
    private final Image CONTROLLER_STEERING_01_IMAGE = new Image(new File(CONTROLLER_STEERING_01_FILE_PATH).toURI().toString());
    
    private Tile controllerOutside_01;
    private final String CONTROLLER_OUTSIDE_01_FILE_PATH = "assets/pictures/controllers/controllerOutside.png";
    private final Image CONTROLLER_OUTSIDE_01_IMAGE = new Image(new File(CONTROLLER_OUTSIDE_01_FILE_PATH).toURI().toString());
    
    private Tile northExit;
    private final String NORTH_EXIT_FILE_PATH = "assets/pictures/controllers/controllerExit.png";
    private final Image NORTH_EXIT_IMAGE = new Image(new File(NORTH_EXIT_FILE_PATH).toURI().toString());
    private Tile westExit;
    private final String WEST_EXIT_FILE_PATH = "assets/pictures/controllers/controllerExit.png";
    private final Image WEST_EXIT_IMAGE = new Image(new File(WEST_EXIT_FILE_PATH).toURI().toString());
    private Tile southExit;
    private final String SOUTH_EXIT_FILE_PATH = "assets/pictures/controllers/controllerExit.png";
    private final Image SOUTH_EXIT_IMAGE = new Image(new File(SOUTH_EXIT_FILE_PATH).toURI().toString());
    private Tile eastExit;
    private final String EAST_EXIT_FILE_PATH = "assets/pictures/controllers/controllerExit.png";
    private final Image EAST_EXIT_IMAGE = new Image(new File(EAST_EXIT_FILE_PATH).toURI().toString());
    
    private Tile nothing;
    
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
        
        this.floor01 = new Tile('0', false, GameObjectType.DECORATION, null, this.FLOOR_01_IMAGE);
        this.floor02 = new Tile('1', false, GameObjectType.DECORATION, null, this.FLOOR_02_IMAGE);
        this.floor03 = new Tile('2', false, GameObjectType.DECORATION, null, this.FLOOR_03_IMAGE);
        this.floor04 = new Tile('3', false, GameObjectType.DECORATION, null, this.FLOOR_04_IMAGE);
        this.floor05 = new Tile('4', false, GameObjectType.DECORATION, null, this.FLOOR_05_IMAGE);
        this.floor06 = new Tile('5', false, GameObjectType.DECORATION, null, this.FLOOR_06_IMAGE);
        this.floor07 = new Tile('6', false, GameObjectType.DECORATION, null, this.FLOOR_07_IMAGE);
        this.floor08 = new Tile('7', false, GameObjectType.DECORATION, null, this.FLOOR_08_IMAGE);
        this.floor09 = new Tile('8', false, GameObjectType.DECORATION, null, this.FLOOR_09_IMAGE);
        this.floor10 = new Tile('9', false, GameObjectType.DECORATION, null, this.FLOOR_10_IMAGE);
        
        this.wall01 =  new Tile('+', true, GameObjectType.DECORATION, null, this.WALL_01_IMAGE);
        this.wall02 =  new Tile('/', true, GameObjectType.DECORATION, null, this.WALL_02_IMAGE);
        
        this.decoration01 = new Tile('a', true, GameObjectType.DECORATION, null, this.DECORATION_01_IMAGE);
        this.decoration02 = new Tile('b', true, GameObjectType.DECORATION, null, this.DECORATION_02_IMAGE);
        this.decoration03 = new Tile('c', true, GameObjectType.DECORATION, null, this.DECORATION_03_IMAGE);
        this.decoration04 = new Tile('d', true, GameObjectType.DECORATION, null, this.DECORATION_04_IMAGE);
        this.decoration05 = new Tile('e', true, GameObjectType.DECORATION, null, this.DECORATION_05_IMAGE);
        this.decoration06 = new Tile('f', true, GameObjectType.DECORATION, null, this.DECORATION_06_IMAGE);
        this.decoration07 = new Tile('g', true, GameObjectType.DECORATION, null, this.DECORATION_07_IMAGE);
        this.decoration08 = new Tile('h', true, GameObjectType.DECORATION, null, this.DECORATION_08_IMAGE);
        this.decoration09 = new Tile('i', false, GameObjectType.DECORATION, null, this.DECORATION_09_IMAGE);
        this.decoration10 = new Tile('j', true, GameObjectType.DECORATION, null, this.DECORATION_10_IMAGE);
        this.decoration11 = new Tile('k', true, GameObjectType.DECORATION, null, this.DECORATION_11_IMAGE);
        this.decoration12 = new Tile('l', true, GameObjectType.DECORATION, null, this.DECORATION_12_IMAGE);
        this.decoration13 = new Tile('m', true, GameObjectType.DECORATION, null, this.DECORATION_13_IMAGE);
        this.decoration14 = new Tile('n', false, GameObjectType.DECORATION, null, this.DECORATION_14_IMAGE);
        
        
        this.controllerLaser01 = new Tile('!', false, GameObjectType.CONTROL, new ControlLaser(((SystemsManager)this.getManager(SystemsManager.class))), this.CONTROLLER_LASER_01_IMAGE);
        this.controllerLaser02 = new Tile('|', false, GameObjectType.CONTROL, new ActivatorLaser(((SystemsManager)this.getManager(SystemsManager.class))), this.CONTROLLER_LASER_01_IMAGE);
        
        this.controllerNet01 = new Tile('#', false, GameObjectType.CONTROL, new ControlNet(((SystemsManager)this.getManager(SystemsManager.class))), this.CONTROLLER_NET_01_IMAGE);
        this.controllerNet02 = new Tile('%', false, GameObjectType.CONTROL, new ActivatorNet(((SystemsManager)this.getManager(SystemsManager.class))), this.CONTROLLER_NET_02_IMAGE);
        
        this.controllerOxygen01 = new Tile(';', false, GameObjectType.CONTROL, new ControlOxygen(((ResourcesManager)this.getManager(ResourcesManager.class))), this.CONTROLLER_OXYGEN_IMAGE);
        this.controllerOxygen02 = new Tile(',', false, GameObjectType.CONTROL, new ActivatorOxygen1(((ResourcesManager)this.getManager(ResourcesManager.class))), this.CONTROLLER_OXYGEN_IMAGE);
        this.controllerOxygen03 = new Tile('"', false, GameObjectType.CONTROL, new ActivatorOxygen2(((ResourcesManager)this.getManager(ResourcesManager.class))), this.CONTROLLER_OXYGEN_IMAGE);
        this.controllerOxygen04 = new Tile('`', false, GameObjectType.CONTROL, new ActivatorOxygen3(((ResourcesManager)this.getManager(ResourcesManager.class))), this.CONTROLLER_OXYGEN_IMAGE);
       
        this.controllerScanning_01 = new Tile('?', false, GameObjectType.CONTROL, new ControllerScanning(((SystemsManager)this.getManager(SystemsManager.class))), this.CONTROLLER_SCANNING_01_IMAGE);
        this.controllerOutside_01 = new Tile('*', false, GameObjectType.CONTROL, new ControllerOutside(((ResourcesManager)this.getManager(ResourcesManager.class))), this.CONTROLLER_OUTSIDE_01_IMAGE);
        this.controllerSteering_01 = new Tile('^', false, GameObjectType.CONTROL, new ControllerSteering(((SystemsManager)this.getManager(SystemsManager.class))), this.CONTROLLER_STEERING_01_IMAGE);
      
        this.northExit = new Tile('N', false, GameObjectType.NORTH, new ExitNorth(), this.NORTH_EXIT_IMAGE);
        this.westExit = new Tile('W', false, GameObjectType.WEST, new ExitWest(), this.WEST_EXIT_IMAGE);
        this.southExit = new Tile('S', false, GameObjectType.SOUTH, new ExitSouth(), this.SOUTH_EXIT_IMAGE);
        this.eastExit = new Tile('E', false, GameObjectType.EAST, new ExitEast(), this.EAST_EXIT_IMAGE);
        
        this.nothing = new Tile('.', true, GameObjectType.DECORATION, null, null);
    }
    private void createTileMap(){
        
        getTileMap().put(this.floor01.getSYMBOL(), this.floor01);
        getTileMap().put(this.floor02.getSYMBOL(), this.floor02);
        getTileMap().put(this.floor03.getSYMBOL(), this.floor03);
        getTileMap().put(this.floor04.getSYMBOL(), this.floor04);
        getTileMap().put(this.floor05.getSYMBOL(), this.floor05);
        getTileMap().put(this.floor06.getSYMBOL(), this.floor06);
        getTileMap().put(this.floor07.getSYMBOL(), this.floor07);
        getTileMap().put(this.floor08.getSYMBOL(), this.floor08);
        getTileMap().put(this.floor09.getSYMBOL(), this.floor09);
        getTileMap().put(this.floor10.getSYMBOL(), this.floor10);
        
        getTileMap().put(this.wall01.getSYMBOL(), this.wall01);
        getTileMap().put(this.wall02.getSYMBOL(), this.wall02);
        
        getTileMap().put(this.decoration01.getSYMBOL(), this.decoration01);
        getTileMap().put(this.decoration02.getSYMBOL(), this.decoration02);
        getTileMap().put(this.decoration03.getSYMBOL(), this.decoration03);
        getTileMap().put(this.decoration04.getSYMBOL(), this.decoration04);
        getTileMap().put(this.decoration05.getSYMBOL(), this.decoration05);
        getTileMap().put(this.decoration06.getSYMBOL(), this.decoration06);
        getTileMap().put(this.decoration07.getSYMBOL(), this.decoration07);
        getTileMap().put(this.decoration08.getSYMBOL(), this.decoration08);
        getTileMap().put(this.decoration09.getSYMBOL(), this.decoration09);
        getTileMap().put(this.decoration10.getSYMBOL(), this.decoration10);
        getTileMap().put(this.decoration11.getSYMBOL(), this.decoration11);
        getTileMap().put(this.decoration12.getSYMBOL(), this.decoration12);
        getTileMap().put(this.decoration13.getSYMBOL(), this.decoration13);
        getTileMap().put(this.decoration14.getSYMBOL(), this.decoration14);
        
        
        getTileMap().put(this.controllerLaser01.getSYMBOL(), this.controllerLaser01);
        getTileMap().put(this.controllerLaser02.getSYMBOL(), this.controllerLaser02);
        
        getTileMap().put(this.controllerNet01.getSYMBOL(), this.controllerNet01);
        getTileMap().put(this.controllerNet02.getSYMBOL(), this.controllerNet02);
        
        getTileMap().put(this.controllerOxygen01.getSYMBOL(), this.controllerOxygen01);
        getTileMap().put(this.controllerOxygen02.getSYMBOL(), this.controllerOxygen02);
        getTileMap().put(this.controllerOxygen03.getSYMBOL(), this.controllerOxygen03);
        getTileMap().put(this.controllerOxygen04.getSYMBOL(), this.controllerOxygen04);
        
        getTileMap().put(this.controllerScanning_01.getSYMBOL(), this.controllerScanning_01);
        getTileMap().put(this.controllerOutside_01.getSYMBOL(), this.controllerOutside_01);
        getTileMap().put(this.controllerSteering_01.getSYMBOL(), this.controllerSteering_01);
        
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
