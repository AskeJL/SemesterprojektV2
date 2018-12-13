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
 * The TileManager manages all the tiles that are created and updated throughout
 * the game.
 *
 */
public class TileManager extends Manager implements GameUpdateable {

    private final HashMap<Character, Tile> tileMap = new HashMap<>();

    private Tile floor01,
            floor02,
            floor03,
            floor04,
            floor05,
            floor06,
            floor07,
            floor08,
            floor09,
            floor10;

    private Tile wall01;
    private Tile wall02;

    private Tile decoration01,
            decoration02,
            decoration03,
            decoration04,
            decoration05,
            decoration06,
            decoration07,
            decoration08,
            decoration09,
            decoration10,
            decoration11,
            decoration12,
            decoration13,
            decoration14;

    private Tile controllerLaser01,
            controllerLaser02,
            controllerNet01,
            controllerNet02;

    private Tile controllerOxygen01,
            controllerOxygen02,
            controllerOxygen03,
            controllerOxygen04,
            controllerScanning01,
            controllerSteering01,
            controllerOutside01;

    private Tile northExit,
            westExit,
            southExit,
            eastExit;

    private Tile nothing;

    private final Image floor01Image = new Image(new File("assets/pictures//floors/floor_01.png").toURI().toString()),
            floor02Image = new Image(new File("assets/pictures/floors/floor_02.png").toURI().toString()),
            floor03Image = new Image(new File("assets/pictures/floors/floor_03.png").toURI().toString()),
            floor04Image = new Image(new File("assets/pictures/floors/floor_04.png").toURI().toString()),
            floor05Image = new Image(new File("assets/pictures/floors/floor_05.png").toURI().toString()),
            floor06Image = new Image(new File("assets/pictures/floors/floor_06.png").toURI().toString()),
            floor07Image = new Image(new File("assets/pictures/floors/floor_07.png").toURI().toString()),
            floor08Image = new Image(new File("assets/pictures/floors/floor_08.png").toURI().toString()),
            floor09Image = new Image(new File("assets/pictures/floors/floor_09.png").toURI().toString()),
            floor10Image = new Image(new File("assets/pictures/floors/floor_10.png").toURI().toString());

    private final Image wall01Image = new Image(new File("assets/pictures/walls/wall_01.png").toURI().toString());
    private final Image wall02Image = new Image(new File("assets/pictures/walls/wall_02.png").toURI().toString());

    private final Image decoration01Image = new Image(new File("assets/pictures/decorations/decoration_01.png").toURI().toString()),
            decoration02Image = new Image(new File("assets/pictures/decorations/decoration_02.png").toURI().toString()),
            decoration03Image = new Image(new File("assets/pictures/decorations/decoration_03.png").toURI().toString()),
            decoration04Image = new Image(new File("assets/pictures/decorations/decoration_04.png").toURI().toString()),
            decoration05Image = new Image(new File("assets/pictures/decorations/decoration_05.png").toURI().toString()),
            decoration06Image = new Image(new File("assets/pictures/decorations/decoration_06.png").toURI().toString()),
            decoration07Image = new Image(new File("assets/pictures/decorations/decoration_07.png").toURI().toString()),
            decoration08Image = new Image(new File("assets/pictures/decorations/decoration_08.png").toURI().toString()),
            decoration09Image = new Image(new File("assets/pictures/decorations/decoration_09.png").toURI().toString()),
            decoration10Image = new Image(new File("assets/pictures/decorations/decoration_10.png").toURI().toString()),
            decoration11Image = new Image(new File("assets/pictures/decorations/decoration_11.png").toURI().toString()),
            decoration12Image = new Image(new File("assets/pictures/decorations/decoration_12.png").toURI().toString()),
            decoration13Image = new Image(new File("assets/pictures/decorations/decoration_13.png").toURI().toString()),
            decoration14Image = new Image(new File("assets/pictures/decorations/decoration_14.png").toURI().toString());

    private final Image controllerLaser01Image = new Image(new File("assets/pictures/controllers/controllerLaser.png").toURI().toString()),
            controllerLaser02Image = new Image(new File("assets/pictures/controllers/controllerLaser.png").toURI().toString()),
            controllerNet01Image = new Image(new File("assets/pictures/controllers/controllerNet.png").toURI().toString()),
            controllerNet02Image = new Image(new File("assets/pictures/controllers/controllerNet.png").toURI().toString()),
            controllerOxygenImage = new Image(new File("assets/pictures/controllers/controllerOxygen.png").toURI().toString()),
            controllerScanning01Image = new Image(new File("assets/pictures/controllers/controllerScanning.png").toURI().toString()),
            controllerSteering01Image = new Image(new File("assets/pictures/controllers/controllerSteering.png").toURI().toString()),
            controllerOutside01Image = new Image(new File("assets/pictures/controllers/controllerOutside.png").toURI().toString());

    private final Image exitNorthImage = new Image(new File("assets/pictures/controllers/controllerExit.png").toURI().toString()),
            exitWestImage = new Image(new File("assets/pictures/controllers/controllerExit.png").toURI().toString()),
            exitSouthImage = new Image(new File("assets/pictures/controllers/controllerExit.png").toURI().toString()),
            exitEastImage = new Image(new File("assets/pictures/controllers/controllerExit.png").toURI().toString());

    private Player player;

    /**
     * Initialize the TileManager and its {@link domain.GameElement}.
     * <p>
     * Will run {@link #createTiles()}, {@link #createTileMap()} and initialize
     * the {@link Player}.
     */
    @Override
    public void init() {
        createTiles();
        createTileMap();
        player = new Player();
        super.init();
    }

    /**
     * Update all the {@link domain.GameElement}s related to this
     * {@link domain.Manager}.
     */
    @Override
    public void update() {
        super.update();
    }

    private void createTiles() {

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

        this.wall01 = new Tile('+', true, GameObjectType.DECORATION, null, this.WALL_01_IMAGE);
        this.wall02 = new Tile('/', true, GameObjectType.DECORATION, null, this.WALL_02_IMAGE);

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

        this.controllerLaser01 = new Tile('!', false, GameObjectType.CONTROL, new ControlLaser(((SystemsManager) this.getManager(SystemsManager.class))), this.CONTROLLER_LASER_01_IMAGE);
        this.controllerLaser02 = new Tile('|', false, GameObjectType.CONTROL, new ActivatorLaser(((SystemsManager) this.getManager(SystemsManager.class))), this.CONTROLLER_LASER_01_IMAGE);

        this.controllerNet01 = new Tile('#', false, GameObjectType.CONTROL, new ControlNet(((SystemsManager) this.getManager(SystemsManager.class))), this.CONTROLLER_NET_01_IMAGE);
        this.controllerNet02 = new Tile('%', false, GameObjectType.CONTROL, new ActivatorNet(((SystemsManager) this.getManager(SystemsManager.class))), this.CONTROLLER_NET_02_IMAGE);

        this.controllerOxygen01 = new Tile(';', false, GameObjectType.CONTROL, new ControlOxygen(((ResourcesManager) this.getManager(ResourcesManager.class))), this.CONTROLLER_OXYGEN_IMAGE);
        this.controllerOxygen02 = new Tile(',', false, GameObjectType.CONTROL, new ActivatorOxygen1(((ResourcesManager) this.getManager(ResourcesManager.class))), this.CONTROLLER_OXYGEN_IMAGE);
        this.controllerOxygen03 = new Tile('"', false, GameObjectType.CONTROL, new ActivatorOxygen2(((ResourcesManager) this.getManager(ResourcesManager.class))), this.CONTROLLER_OXYGEN_IMAGE);
        this.controllerOxygen04 = new Tile('`', false, GameObjectType.CONTROL, new ActivatorOxygen3(((ResourcesManager) this.getManager(ResourcesManager.class))), this.CONTROLLER_OXYGEN_IMAGE);

        this.controllerScanning = new Tile('?', false, GameObjectType.CONTROL, new ControllerScanning(((SystemsManager) this.getManager(SystemsManager.class))), this.SCANNING_IMAGE);
        this.activatorScanning_01 = new Tile('[', false, GameObjectType.CONTROL, new ActivatorScanning1(((SystemsManager) this.getManager(SystemsManager.class))), this.SCANNING_IMAGE);
        this.activatorScanning_02 = new Tile(']', false, GameObjectType.CONTROL, new ActivatorScanning2(((SystemsManager) this.getManager(SystemsManager.class))), this.SCANNING_IMAGE);
        this.activatorScanning_03 = new Tile('(', false, GameObjectType.CONTROL, new ActivatorScanning3(((SystemsManager) this.getManager(SystemsManager.class))), this.SCANNING_IMAGE);
        this.activatorScanning_04 = new Tile(')', false, GameObjectType.CONTROL, new ActivatorScanning4(((SystemsManager) this.getManager(SystemsManager.class))), this.SCANNING_IMAGE);
        
        this.controllerOutside_01 = new Tile('*', false, GameObjectType.CONTROL, new ControllerOutside(((ResourcesManager) this.getManager(ResourcesManager.class))), this.CONTROLLER_OUTSIDE_01_IMAGE);

        this.controllerSteering01 = new Tile('<', false, GameObjectType.CONTROL, new ControllerSteering(((SystemsManager) this.getManager(SystemsManager.class))), this.CONTROLLER_STEERING_IMAGE);
        this.controllerSteering02 = new Tile('>', false, GameObjectType.CONTROL, new ActivatorSteering(((SystemsManager) this.getManager(SystemsManager.class))), this.CONTROLLER_STEERING_IMAGE);

        this.northExit = new Tile('N', false, GameObjectType.NORTH, new ExitNorth(), this.NORTH_EXIT_IMAGE);
        this.westExit = new Tile('W', false, GameObjectType.WEST, new ExitWest(), this.WEST_EXIT_IMAGE);
        this.southExit = new Tile('S', false, GameObjectType.SOUTH, new ExitSouth(), this.SOUTH_EXIT_IMAGE);
        this.eastExit = new Tile('E', false, GameObjectType.EAST, new ExitEast(), this.EAST_EXIT_IMAGE);

        this.nothing = new Tile('.', true, GameObjectType.DECORATION, null, null);
    }

    private void createTileMap() {

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

        getTileMap().put(this.controllerScanning.getSYMBOL(), this.controllerScanning);
        getTileMap().put(this.activatorScanning_01.getSYMBOL(), this.activatorScanning_01);
        getTileMap().put(this.activatorScanning_02.getSYMBOL(), this.activatorScanning_02);
        getTileMap().put(this.activatorScanning_03.getSYMBOL(), this.activatorScanning_03);
        getTileMap().put(this.activatorScanning_04.getSYMBOL(), this.activatorScanning_04);
        
        
        getTileMap().put(this.controllerSteering01.getSYMBOL(), this.controllerSteering01);
        getTileMap().put(this.controllerSteering02.getSYMBOL(), this.controllerSteering02);

        getTileMap().put(this.northExit.getSYMBOL(), this.northExit);
        getTileMap().put(this.westExit.getSYMBOL(), this.westExit);
        getTileMap().put(this.southExit.getSYMBOL(), this.southExit);
        getTileMap().put(this.eastExit.getSYMBOL(), this.eastExit);

        getTileMap().put(this.nothing.getSYMBOL(), this.nothing);

    }

    /**
     * Clear the tile map for all its content.
     */
    public void clearTileMap() {
        this.tileMap.clear();
    }

    /**
     * Get {@link #tileMap}.
     * 
     * @return the tileMap
     */
    public HashMap<Character, Tile> getTileMap() {
        return tileMap;
    }

    /**
     * Get {@link #player}.
     * 
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }
}
