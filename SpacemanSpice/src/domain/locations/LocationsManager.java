package domain.locations;

import domain.Manager;
import domain.GameElement;
import java.util.List;
import domain.GameUpdateable;
import domain.locations.gameobjects.DamageRepair;
import domain.locations.gameobjects.GameObjectType;
import domain.locations.gameobjects.LaserControl;
import domain.locations.gameobjects.NetControl;
import domain.locations.gameobjects.OxygenControl;
import domain.locations.gameobjects.ScanningControl;
import domain.locations.gameobjects.SteeringControl;
import domain.resources.ResourcesManager;
import domain.systems.SystemsManager;
import java.util.ArrayList;
import java.util.HashMap;

public class LocationsManager extends Manager implements GameUpdateable {

    private final int NUMBER_OF_TILES_X_AXIS = 28;
    private final int NUMBER_OF_TILES_Y_AXIS = 16;

    private Room currentRoom;
    private Location currentLocation;

    private Room personalCorridorRoom;
    private Room personalToiletRoom;
    private Room personalBedroom;
    
    private Room scanningControlRoom;
    private Room scanningDisplayRoom;
    private Room scanningSensorRoom;

    private Room controlSteeringRoom;
    private Room controlNavigationRoom;
    private Room controlObservationRoom;
    
    private Room oxygenCorridorRoom;
    private Room oxygenStorageRoom;
    private Room oxygenRefuelRoom;
    
    private Room outsideRoom;
    private Room outsideAirlockRoom;
    
    private Room netCorridorRoom;
    private Room netControlRoom;
    private Room netBayRoom;
    
    private Room laserCorridorRoom;
    private Room laserTechnicRoom;
    private Room laserControlRoom;
    
    private Room mainhall01Room;
    private Room mainhall02Room;
    private Room hallway01Room;
    private Room hallway02Room;
    
    private Location personal;
    private final String PERSONAL_MAP_PATH = "/assets/maps/personalMap.txt";
    private Location scanner;
    private final String SCANNER_MAP_PATH = "/assets/maps/scannerMap.txt";
    private Location control;
    private final String CONTROL_MAP_PATH = "/assets/maps/controlMap.txt";
    private Location oxygen;
    private final String OXYGEN_MAP_PATH = "/assets/maps/oxygenMap.txt";
    private Location outside;
    private final String OUTSIDE_MAP_PATH = "/assets/maps/outsideMap.txt";
    private Location net;
    private final String NET_MAP_PATH = "/assets/maps/netMap.txt";
    private Location laser;
    private final String LASER_MAP_PATH = "/assets/maps/laserMap.txt";

    private Location mainhall01;
    private final String MAINHALL01_MAP_PATH = "/assets/maps/mainhall01Map.txt";
    private Location mainhall02;
    private final String MAINHALL02_MAP_PATH = "/assets/maps/mainhall02Map.txt";
    private Location hallway01;
    private final String HALLWAY01_MAP_PATH = "/assets/maps/hallway01Map.txt";
    private Location hallway02;
    private final String HALLWAY02_MAP_PATH = "/assets/maps/hallway02Map.txt";

    private final HashMap<String, Location> locationMap = new HashMap<>();
    private final HashMap<String, Room> roomMap = new HashMap<>();

    
    /**
     * temporary variable
     */
    private Boolean status = false;

    public LocationsManager() {

    }

    public LocationsManager(List<GameElement> elements) {
        super(elements);
    }

    @Override
    public void init() {
        if (status == true) {
            createRoomsCLI();
            setCurrentRoom(this.personalCorridorRoom);
        } else if (status == false) {
            createLocationsGUI();
            setCurrentLocation(this.personal);
        }
        super.init();
    }

    @Override
    public void update() {
        super.update();
    }

    /**
     * Creates all the predetermined locations. This is created based on a map
     * (Hard-coded).
     * <p>
     * Exits are added after creation.
     */
    private void createRoomsCLI() {
        
        this.personalCorridorRoom = new Room("Personal Corridor", "Main corridor of the personal room", this.scanningControlRoom, this.mainhall01Room, this.hallway01Room, this.personalBedroom, null, null, null);
        this.personalToiletRoom = new Room("Personal Toilet", "this is the toilet", null, null, this.personalBedroom, null, null, null, null);
        this.personalBedroom = new Room("Personal Bedroom", "This is the bedroom", this.personalToiletRoom, this.personalCorridorRoom, null, null, null, null, null);
        
        this.scanningControlRoom =new Room("Scanning Control", "Space debris can be scanned from here.", this.scanningSensorRoom, this.controlObservationRoom, this.personalCorridorRoom, this.scanningDisplayRoom, GameObjectType.CONTROL, new ScanningControl((SystemsManager)this.fetchController(SystemsManager.class)), null);
        this.scanningDisplayRoom= new Room("Scanning Display", "The most recent scan can be viewed here.", null, this.scanningControlRoom,null, null, null, null, null);
        this.scanningSensorRoom= new Room("Scanning Sensor", "The sensor equipment", null, null, this.scanningControlRoom, null, null, null, null);
        
        this.controlSteeringRoom = new Room("Control Steering", "The ship is controlled from here.", null, null, this.controlObservationRoom, null, GameObjectType.CONTROL, new SteeringControl((SystemsManager)this.fetchController(SystemsManager.class)), null);
        this.controlNavigationRoom = new Room("Control Navigation", "The ships current position is stored here.", null, null, this.hallway02Room, this.controlSteeringRoom, null, null, null);
        this.controlObservationRoom = new Room("Control Observation", "It is from here, all outside observations can be made.", this.controlSteeringRoom, this.controlNavigationRoom, this.mainhall01Room, this.scanningControlRoom, null, null, null);

        this.oxygenCorridorRoom = new Room("Oxygen Corridor", "Main corridor of the oxygen room", this.oxygenStorageRoom, this.hallway02Room, this.oxygenRefuelRoom, this.mainhall01Room, null, null, null);
        this.oxygenStorageRoom = new Room("Oxygen Storage", "Here the oxygen is storaged", null, null, this.oxygenCorridorRoom, null, null, null, null);
        this.oxygenRefuelRoom = new Room("Oxygen Refuel", "Here oxygen suply can be refilled", this.oxygenCorridorRoom,null, null, null, GameObjectType.CONTROL, new OxygenControl((ResourcesManager)this.fetchController(ResourcesManager.class)), null);
        
        this.outsideRoom = new Room("Outside", "You are now outside and here you can repair the ship", null, null, null, this.outsideAirlockRoom, GameObjectType.CONTROL, new DamageRepair((ResourcesManager)this.fetchController(ResourcesManager.class)), null);
        this.outsideAirlockRoom = new Room("Airlock", "You are now in the airlock", this.hallway02Room, this.outsideRoom, null, this.mainhall02Room, null, null, null);
        
        this.netCorridorRoom = new Room("Net Corridor","This is the main corridor in the location", this.mainhall02Room, this.netBayRoom, null, this.netControlRoom, null, null, null);
        this.netControlRoom = new Room("Net Control","Here you control the space net", this.hallway01Room, this.netCorridorRoom, null, null, GameObjectType.CONTROL, new NetControl((SystemsManager)this.fetchController(SystemsManager.class)), null);
        this.netBayRoom = new Room("Net Bay","Here you can fix your net", null, null, null, this.netCorridorRoom, null, null, null);
        
        this.laserCorridorRoom = new Room("Laser Corridor", "Main corridor for the laser.", this.laserTechnicRoom, this.mainhall02Room, this.laserControlRoom, this.hallway02Room, null, null, null);
        this.laserTechnicRoom = new Room("Laser Technic", "The technical parts of the laser.", null, null, this.laserCorridorRoom, null, null, null, null);
        this.laserControlRoom = new Room("Laser Controls", "The controls for the laser.", this.laserCorridorRoom, null, null, null, GameObjectType.CONTROL, new LaserControl((SystemsManager)this.fetchController(SystemsManager.class)), null);

        this.mainhall01Room = new Room("Mainhall 01", "This is the upper part of the mainhall.", this.controlSteeringRoom, this.oxygenCorridorRoom, this.mainhall02Room, this.personalCorridorRoom, null, null, null);
        this.mainhall02Room = new Room("Mainhall 02", "This is the lower part of the mainhall.", this.mainhall01Room, this.outsideAirlockRoom, this.netCorridorRoom, this.laserCorridorRoom, null, null, null);
        this.hallway01Room = new Room("Hallway 01", "This hallway connects the Personal, Laser and Net", this.personalCorridorRoom, this.laserCorridorRoom, this.netControlRoom, null, null, null, null);
        this.hallway02Room = new Room("Hallway 02","This hallway connects the airlock, navigation and oxygen", this.controlNavigationRoom, null, this.oxygenCorridorRoom, this.outsideAirlockRoom, null, null, null);
        
        roomMap.put(this.personalCorridorRoom.getNAME(), this.personalCorridorRoom);
    }

    private void createLocationsGUI() {

        this.personal = new Location("Personal",
                "",
                new Exit(this.scanner, ExitDirection.SOUTH),
                new Exit(this.mainhall01, ExitDirection.EAST),
                new Exit(this.hallway01, ExitDirection.NORTH),
                null,
                this.PERSONAL_MAP_PATH);

        this.scanner = new Location("Scanner",
                "",
                null,
                new Exit(this.control, ExitDirection.EAST),
                new Exit(this.personal, ExitDirection.NORTH),
                null,
                this.SCANNER_MAP_PATH);

        this.control = new Location("Control",
                "",
                null,
                new Exit(hallway02, ExitDirection.NORTH),
                new Exit(mainhall01, ExitDirection.NORTH),
                new Exit(scanner, ExitDirection.WEST),
                this.CONTROL_MAP_PATH);

        this.oxygen = new Location("Oxygen",
                "",
                null,
                new Exit(hallway02, ExitDirection.EAST),
                null,
                new Exit(mainhall01, ExitDirection.WEST),
                this.OXYGEN_MAP_PATH);

        this.outside = new Location("Outside",
                "",
                new Exit(hallway02, ExitDirection.SOUTH),
                null,
                null,
                new Exit(mainhall02, ExitDirection.WEST),
                this.OUTSIDE_MAP_PATH);

        this.net = new Location("Net",
                "",
                new Exit(mainhall02, ExitDirection.SOUTH),
                null,
                null,
                new Exit(hallway01, ExitDirection.SOUTH),
                this.NET_MAP_PATH);

        this.laser = new Location("Laser",
                "",
                null,
                new Exit(mainhall02, ExitDirection.EAST),
                null,
                new Exit(hallway01Room, ExitDirection.WEST),
                this.LASER_MAP_PATH);

        this.mainhall01 = new Location("Mainhall01",
                "",
                new Exit(control, ExitDirection.SOUTH),
                new Exit(oxygen, ExitDirection.EAST),
                new Exit(mainhall02, ExitDirection.NORTH),
                new Exit(personal, ExitDirection.WEST),
                this.MAINHALL01_MAP_PATH);

        this.mainhall02 = new Location("Mainhall02",
                "",
                new Exit(mainhall01, ExitDirection.SOUTH),
                new Exit(outside, ExitDirection.EAST),
                new Exit(net, ExitDirection.NORTH),
                new Exit(laser, ExitDirection.WEST),
                this.MAINHALL02_MAP_PATH);

        this.hallway01 = new Location("Hallway01",
                "",
                new Exit(personal, ExitDirection.SOUTH),
                new Exit(laser, ExitDirection.EAST),
                new Exit(net, ExitDirection.EAST),
                null,
                this.HALLWAY01_MAP_PATH);

        this.hallway02 = new Location("Hallway02",
                "",
                new Exit(control, ExitDirection.WEST),
                null,
                new Exit(outside, ExitDirection.NORTH),
                new Exit(oxygen, ExitDirection.WEST),
                this.HALLWAY02_MAP_PATH);

    }

    /**
     * @return the NUMBER_OF_TILES_X_AXIS
     */
    public int getNUMBER_OF_TILES_X_AXIS() {
        return NUMBER_OF_TILES_X_AXIS;
    }

    /**
     * @return the NUMBER_OF_TILES_Y_AXIS
     */
    public int getNUMBER_OF_TILES_Y_AXIS() {
        return NUMBER_OF_TILES_Y_AXIS;
    }

    /**
     * @return the currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * @return the currentLocation
     */
    public Location getCurrentLocation() {
        return currentLocation;
    }

    /**
     * @param currentRoom the currentRoom to set
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * @param currentLocation the currentLocation to set
     */
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    
}
