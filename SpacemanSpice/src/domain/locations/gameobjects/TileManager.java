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
 * @author sbang
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

    /**
     * Create all the tiles necessary to draw the map. Primarily uses the
     * {@link Tile}.
     */
    private void createTiles() {
        this.floor01 = new Tile('0', false, GameObjectType.DECORATION, null, this.floor01Image);
        this.floor02 = new Tile('1', false, GameObjectType.DECORATION, null, this.floor02Image);
        this.floor03 = new Tile('2', false, GameObjectType.DECORATION, null, this.floor03Image);
        this.floor04 = new Tile('3', false, GameObjectType.DECORATION, null, this.floor04Image);
        this.floor05 = new Tile('4', false, GameObjectType.DECORATION, null, this.floor05Image);
        this.floor06 = new Tile('5', false, GameObjectType.DECORATION, null, this.floor06Image);
        this.floor07 = new Tile('6', false, GameObjectType.DECORATION, null, this.floor07Image);
        this.floor08 = new Tile('7', false, GameObjectType.DECORATION, null, this.floor08Image);
        this.floor09 = new Tile('8', false, GameObjectType.DECORATION, null, this.floor09Image);
        this.floor10 = new Tile('9', false, GameObjectType.DECORATION, null, this.floor10Image);

        this.wall01 = new Tile('+', true, GameObjectType.DECORATION, null, this.wall01Image);
        this.wall02 = new Tile('/', true, GameObjectType.DECORATION, null, this.wall02Image);

        this.decoration01 = new Tile('a', true, GameObjectType.DECORATION, null, this.decoration01Image);
        this.decoration02 = new Tile('b', true, GameObjectType.DECORATION, null, this.decoration02Image);
        this.decoration03 = new Tile('c', true, GameObjectType.DECORATION, null, this.decoration03Image);
        this.decoration04 = new Tile('d', true, GameObjectType.DECORATION, null, this.decoration04Image);
        this.decoration05 = new Tile('e', true, GameObjectType.DECORATION, null, this.decoration05Image);
        this.decoration06 = new Tile('f', true, GameObjectType.DECORATION, null, this.decoration06Image);
        this.decoration07 = new Tile('g', true, GameObjectType.DECORATION, null, this.decoration07Image);
        this.decoration08 = new Tile('h', true, GameObjectType.DECORATION, null, this.decoration08Image);
        this.decoration09 = new Tile('i', false, GameObjectType.DECORATION, null, this.decoration09Image);
        this.decoration10 = new Tile('j', true, GameObjectType.DECORATION, null, this.decoration10Image);
        this.decoration11 = new Tile('k', true, GameObjectType.DECORATION, null, this.decoration11Image);
        this.decoration12 = new Tile('l', true, GameObjectType.DECORATION, null, this.decoration12Image);
        this.decoration13 = new Tile('m', true, GameObjectType.DECORATION, null, this.decoration13Image);
        this.decoration14 = new Tile('n', false, GameObjectType.DECORATION, null, this.decoration14Image);

        this.controllerLaser01 = new Tile('!', false, GameObjectType.CONTROL, new ControlLaser(((SystemsManager) this.getManager(SystemsManager.class))), this.controllerLaser01Image);
        this.controllerLaser02 = new Tile('|', false, GameObjectType.CONTROL, new ActivatorLaser(((SystemsManager) this.getManager(SystemsManager.class))), this.controllerLaser01Image);

        this.controllerNet01 = new Tile('#', false, GameObjectType.CONTROL, new ControlNet(((SystemsManager) this.getManager(SystemsManager.class))), this.controllerNet01Image);
        this.controllerNet02 = new Tile('%', false, GameObjectType.CONTROL, new ActivatorRepair(((SystemsManager) this.getManager(SystemsManager.class))), this.controllerNet02Image);

        this.controllerOxygen01 = new Tile(';', false, GameObjectType.CONTROL, new ControlOxygen(((ResourcesManager) this.getManager(ResourcesManager.class))), this.controllerOxygenImage);
        this.controllerOxygen02 = new Tile(',', false, GameObjectType.CONTROL, new ActivatorOxygen1(((ResourcesManager) this.getManager(ResourcesManager.class))), this.controllerOxygenImage);
        this.controllerOxygen03 = new Tile('"', false, GameObjectType.CONTROL, new ActivatorOxygen2(((ResourcesManager) this.getManager(ResourcesManager.class))), this.controllerOxygenImage);
        this.controllerOxygen04 = new Tile('`', false, GameObjectType.CONTROL, new ActivatorOxygen3(((ResourcesManager) this.getManager(ResourcesManager.class))), this.controllerOxygenImage);

        this.controllerScanning01 = new Tile('?', false, GameObjectType.CONTROL, new ControlScanning(((SystemsManager) this.getManager(SystemsManager.class))), this.controllerScanning01Image);
        this.controllerOutside01 = new Tile('*', false, GameObjectType.CONTROL, new ControlRepair(((ResourcesManager) this.getManager(ResourcesManager.class))), this.controllerOutside01Image);
        this.controllerSteering01 = new Tile('^', false, GameObjectType.CONTROL, new ControlSteering(((SystemsManager) this.getManager(SystemsManager.class))), this.controllerSteering01Image);

        this.northExit = new Tile('N', false, GameObjectType.NORTH, new ExitNorth(), this.exitNorthImage);
        this.westExit = new Tile('W', false, GameObjectType.WEST, new ExitWest(), this.exitWestImage);
        this.southExit = new Tile('S', false, GameObjectType.SOUTH, new ExitSouth(), this.exitSouthImage);
        this.eastExit = new Tile('E', false, GameObjectType.EAST, new ExitEast(), this.exitEastImage);

        this.nothing = new Tile('.', true, GameObjectType.DECORATION, null, null);
    }

    /**
     * Uses all the tiles created in {@link #createTiles()} to populate a
     * HashMap.
     */
    private void createTileMap() {
        getTileMap().put(this.floor01.getSymbol(), this.floor01);
        getTileMap().put(this.floor02.getSymbol(), this.floor02);
        getTileMap().put(this.floor03.getSymbol(), this.floor03);
        getTileMap().put(this.floor04.getSymbol(), this.floor04);
        getTileMap().put(this.floor05.getSymbol(), this.floor05);
        getTileMap().put(this.floor06.getSymbol(), this.floor06);
        getTileMap().put(this.floor07.getSymbol(), this.floor07);
        getTileMap().put(this.floor08.getSymbol(), this.floor08);
        getTileMap().put(this.floor09.getSymbol(), this.floor09);
        getTileMap().put(this.floor10.getSymbol(), this.floor10);

        getTileMap().put(this.wall01.getSymbol(), this.wall01);
        getTileMap().put(this.wall02.getSymbol(), this.wall02);

        getTileMap().put(this.decoration01.getSymbol(), this.decoration01);
        getTileMap().put(this.decoration02.getSymbol(), this.decoration02);
        getTileMap().put(this.decoration03.getSymbol(), this.decoration03);
        getTileMap().put(this.decoration04.getSymbol(), this.decoration04);
        getTileMap().put(this.decoration05.getSymbol(), this.decoration05);
        getTileMap().put(this.decoration06.getSymbol(), this.decoration06);
        getTileMap().put(this.decoration07.getSymbol(), this.decoration07);
        getTileMap().put(this.decoration08.getSymbol(), this.decoration08);
        getTileMap().put(this.decoration09.getSymbol(), this.decoration09);
        getTileMap().put(this.decoration10.getSymbol(), this.decoration10);
        getTileMap().put(this.decoration11.getSymbol(), this.decoration11);
        getTileMap().put(this.decoration12.getSymbol(), this.decoration12);
        getTileMap().put(this.decoration13.getSymbol(), this.decoration13);
        getTileMap().put(this.decoration14.getSymbol(), this.decoration14);

        getTileMap().put(this.controllerLaser01.getSymbol(), this.controllerLaser01);
        getTileMap().put(this.controllerLaser02.getSymbol(), this.controllerLaser02);

        getTileMap().put(this.controllerNet01.getSymbol(), this.controllerNet01);
        getTileMap().put(this.controllerNet02.getSymbol(), this.controllerNet02);

        getTileMap().put(this.controllerOxygen01.getSymbol(), this.controllerOxygen01);
        getTileMap().put(this.controllerOxygen02.getSymbol(), this.controllerOxygen02);
        getTileMap().put(this.controllerOxygen03.getSymbol(), this.controllerOxygen03);
        getTileMap().put(this.controllerOxygen04.getSymbol(), this.controllerOxygen04);

        getTileMap().put(this.controllerScanning01.getSymbol(), this.controllerScanning01);
        getTileMap().put(this.controllerOutside01.getSymbol(), this.controllerOutside01);
        getTileMap().put(this.controllerSteering01.getSymbol(), this.controllerSteering01);

        getTileMap().put(this.northExit.getSymbol(), this.northExit);
        getTileMap().put(this.westExit.getSymbol(), this.westExit);
        getTileMap().put(this.southExit.getSymbol(), this.southExit);
        getTileMap().put(this.eastExit.getSymbol(), this.eastExit);

        getTileMap().put(this.nothing.getSymbol(), this.nothing);
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
