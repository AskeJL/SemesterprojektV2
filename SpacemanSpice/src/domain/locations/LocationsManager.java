package domain.locations;

import domain.GameElementGroup;
import domain.locations.functional.*;
import domain.locations.nonfunctional.*;
import domain.Manager;
import java.util.List;
import domain.GameUpdateable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is responsible of keep track of where the player is, how the map looks
 * and how it is connected.
 * <p>
 * Upon initialization ({@link #init()}) this will create all the locations
 * depending on whether or not this play through is GUI or CLI.
 */
public class LocationsManager extends Manager implements GameUpdateable {

    /**
     * All the locations managed by the {@link LocationsManager}.
     */
    private final List<Location> locations = new ArrayList<>();

    /**
     * The room the player is currently in. (This is not set when using a GUI
     * instance)
     */
    private Room currentRoom;

    /**
     * The locations the player is currently in.
     */
    private Location currentLocation;

    /**
     * All the different maps for the locations are stored here (to reference
     * the location, use the name of the location as key).
     */
    private HashMap<String, Location> locationMaps = new HashMap<>();

    /**
     * Whether or not this is a GUI or a CLI instance. (Should be directly
     * connected to {@link domain.Game}.
     */
    private final boolean guiOn = true;

    /**
     * Initialize the locations. Firstly calls the
     * {@link Location#init(domain.locations.LocationsManager)}. Then, based on
     * the {@link #guiOn}, initializes the appropriate locations.
     * <p>
     * Sets the {@link #currentLocation} to "Personal, making the game start
     * there.
     * <p>
     * Finally calls the {@link domain.Manager#init()} to initialize
     * {@link GameElement}s managed by this {@link domain.Manager}.
     */
    @Override
    public void init() {
        Location.init(this);

        if (guiOn == true) {
            createLocationGUI();
            currentLocation = getLocationMaps().get("Personal");
        } else {
            createLocations();
            currentLocation = locations.get(5);
            currentRoom = currentLocation.getRooms().get(2);
        }
        super.init();
    }

    /**
     * Updates the {@link domain.Manager}.
     * <p>
     * Finally calls the {@link domain.Manager#update()} to update
     * {@link GameElement}s managed by this {@link domain.Manager}.
     */
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
    private void createLocations() {
        Location laser = new Laser(),
                control = new Control(),
                net = new Net(),
                outside = new Outside(),
                oxygen = new Oxygen(),
                personal = new Personal(),
                scanning = new Scanning(),
                hallway01 = new Hallway01(),
                hallway02 = new Hallway02(),
                mainhall01 = new Mainhall01(),
                mainhall02 = new Mainhall02();

        // Adding functional locations
        locations.add(laser);     // 0
        locations.add(control);   // 1
        locations.add(net);       // 2
        locations.add(outside);   // 3
        locations.add(oxygen);    // 4
        locations.add(personal);  // 5
        locations.add(scanning);  // 6

        // Adding non-functional locations
        locations.add(hallway01); // 7
        locations.add(hallway02); // 8
        locations.add(mainhall01);// 9
        locations.add(mainhall02);// 10

        GameElementGroup locationGroup = new GameElementGroup();
        locationGroup.setManagerGroup(this.getManagerGroup());
        for (Location location : locations) {
            locationGroup.add(location);
            location.init();
        }

        // Connecting locations (Should be moved to another method: connectLocations)
        // Laser connects to mainhall02 from corridor due WEST
        // Laser connects to hallway01 from corridor due EAST
        laser.addExit(new Exit(ExitDirection.WEST, mainhall02, laser.getRooms().get(0), mainhall02.getRooms().get(0)));
        laser.addExit(new Exit(ExitDirection.EAST, hallway01, laser.getRooms().get(0), hallway01.getRooms().get(0)));

        // Control connects to mainhall01 from control due SOUTH
        // Control connects to scanning from control due EAST
        // Control connects to hallway02 from navigation due SOUTH
        control.addExit(new Exit(ExitDirection.SOUTH, mainhall01, control.getRooms().get(2), mainhall01.getRooms().get(0)));
        control.addExit(new Exit(ExitDirection.EAST, scanning, control.getRooms().get(2), scanning.getRooms().get(0)));
        control.addExit(new Exit(ExitDirection.SOUTH, hallway02, control.getRooms().get(1), hallway02.getRooms().get(0)));

        // Net connects to mainhall02 from corridor due NORTH
        // Net connects to hallway01 from corridor due SOUTH
        net.addExit(new Exit(ExitDirection.NORTH, mainhall02, net.getRooms().get(0), mainhall02.getRooms().get(0)));
        net.addExit(new Exit(ExitDirection.NORTH, hallway01, net.getRooms().get(1), hallway01.getRooms().get(0)));

        // Outside connects to hallway02 from airlock due NORTH
        // Outside conncets to mainhall02 from airlock due EAST
        outside.addExit(new Exit(ExitDirection.NORTH, hallway02, outside.getRooms().get(1), hallway02.getRooms().get(0)));
        outside.addExit(new Exit(ExitDirection.EAST, mainhall02, outside.getRooms().get(1), mainhall02.getRooms().get(0)));

        // Oxygen connects to hallway02 from corridor due EAST
        // Oxygen connects to mainhall01 from corridor due WEST
        oxygen.addExit(new Exit(ExitDirection.WEST, hallway02, oxygen.getRooms().get(0), hallway02.getRooms().get(0)));
        oxygen.addExit(new Exit(ExitDirection.EAST, mainhall01, oxygen.getRooms().get(0), mainhall01.getRooms().get(0)));

        // Personal connects to mainhall01 from corridor due WEST
        // Personal connects to hallway01 from corridor due SOUTH
        // Personal connects to scanning from corridor due NORTH
        personal.addExit(new Exit(ExitDirection.WEST, mainhall01, personal.getRooms().get(0), mainhall01.getRooms().get(0)));
        personal.addExit(new Exit(ExitDirection.SOUTH, hallway01, personal.getRooms().get(0), hallway01.getRooms().get(0)));
        personal.addExit(new Exit(ExitDirection.NORTH, scanning, personal.getRooms().get(0), scanning.getRooms().get(0)));

        // Scanning connects to personal from scanning due SOUTH
        // Scanning connects to control from scanning due WEST
        scanning.addExit(new Exit(ExitDirection.SOUTH, personal, scanning.getRooms().get(0), personal.getRooms().get(0)));
        scanning.addExit(new Exit(ExitDirection.WEST, control, scanning.getRooms().get(0), control.getRooms().get(2)));

        // Hallway01 connects to net from hallway01 due SOUTH
        // Hallway01 connects to laser from hallway01 due WEST
        // Hallway01 connects to personal from hallway01 due NORTH
        hallway01.addExit(new Exit(ExitDirection.SOUTH, net, hallway01.getRooms().get(0), net.getRooms().get(1)));
        hallway01.addExit(new Exit(ExitDirection.WEST, laser, hallway01.getRooms().get(0), laser.getRooms().get(0)));
        hallway01.addExit(new Exit(ExitDirection.NORTH, personal, hallway01.getRooms().get(0), personal.getRooms().get(0)));

        // Hallway02 connects to control from hallway02 due NORTH
        // Hallway02 connects to oxygen from hallway02 due EAST
        // Hallway02 conencts to outside from hallway02 due SOUTH
        hallway02.addExit(new Exit(ExitDirection.NORTH, control, hallway02.getRooms().get(0), control.getRooms().get(1)));
        hallway02.addExit(new Exit(ExitDirection.EAST, oxygen, hallway02.getRooms().get(0), oxygen.getRooms().get(0)));
        hallway02.addExit(new Exit(ExitDirection.SOUTH, outside, hallway02.getRooms().get(0), outside.getRooms().get(1)));

        // Mainhall01 connects to oxygen from mainhall01 due WEST
        // Mainhall01 connects to personal from mainhall01 due EAST
        // Mainhall01 connects to control from mainhall01 due NORTH
        mainhall01.addExit(new Exit(ExitDirection.WEST, oxygen, mainhall01.getRooms().get(0), oxygen.getRooms().get(0)));
        mainhall01.addExit(new Exit(ExitDirection.EAST, personal, mainhall01.getRooms().get(0), personal.getRooms().get(0)));
        mainhall01.addExit(new Exit(ExitDirection.NORTH, control, mainhall01.getRooms().get(0), control.getRooms().get(2)));
        mainhall01.addExit(new Exit(ExitDirection.SOUTH, mainhall02, mainhall01.getRooms().get(0), mainhall02.getRooms().get(0)));

        // Mainhall02 connects to mainhall01 from mainhall due NORTH
        // Mainhall02 connects to outside from mainhall due WEST
        // Mainhall02 connects to laser from mainhall due EAST
        // Mainhall02 connects to net from mainhall due SOUTH
        mainhall02.addExit(new Exit(ExitDirection.NORTH, mainhall01, mainhall02.getRooms().get(0), mainhall01.getRooms().get(0)));
        mainhall02.addExit(new Exit(ExitDirection.WEST, outside, mainhall02.getRooms().get(0), outside.getRooms().get(1)));
        mainhall02.addExit(new Exit(ExitDirection.EAST, laser, mainhall02.getRooms().get(0), laser.getRooms().get(0)));
        mainhall02.addExit(new Exit(ExitDirection.SOUTH, net, mainhall02.getRooms().get(0), net.getRooms().get(0)));
    }

    /**
     * Creates locations for GUI view mode and puts them in
     * {@link #locationMaps} for later referencing.
     */
    private void createLocationGUI() {
        Location personal = new Personal(this.guiOn),
                scanning = new Scanning(this.guiOn),
                control = new Control(this.guiOn),
                oxygen = new Oxygen(this.guiOn),
                outside = new Outside(this.guiOn),
                net = new Net(this.guiOn),
                laser = new Laser(this.guiOn),
                mainhall01 = new Mainhall01(this.guiOn),
                mainhall02 = new Mainhall02(this.guiOn),
                hallway01 = new Hallway01(this.guiOn),
                hallway02 = new Hallway02(this.guiOn);

        this.getLocationMaps().put(personal.getName(), personal);
        this.getLocationMaps().put(scanning.getName(), scanning);
        this.getLocationMaps().put(control.getName(), control);
        this.getLocationMaps().put(oxygen.getName(), oxygen);
        this.getLocationMaps().put(outside.getName(), outside);
        this.getLocationMaps().put(net.getName(), net);
        this.getLocationMaps().put(laser.getName(), laser);
        this.getLocationMaps().put(mainhall01.getName(), mainhall01);
        this.getLocationMaps().put(mainhall02.getName(), mainhall02);
        this.getLocationMaps().put(hallway01.getName(), hallway01);
        this.getLocationMaps().put(hallway02.getName(), hallway02);
    }

    /**
     * Clears the {@link #locationMaps}.
     */
    public void clearLocationMap() {
        locationMaps.clear();
    }

    @Override
    public String toString() {
        String info = "domain.locations.LocationsManager";
        info += super.toString();
        return info;
    }

    /**
     * Get all the {@link Location}s created in {@link #createLocations()}.
     *
     * @return
     */
    public List<Location> getLocations() {
        return this.locations;
    }

    /**
     * Set the {@link #currentRoom currentRoom}.
     *
     * @param room Room to set.
     */
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    /**
     * Set the {@link #currentLocation currentLocation}.
     *
     * @param location Location to set.
     */
    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    /**
     * Get the {@link #currentRoom currentRoom}.
     *
     * @return
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Get the {@link #currentLocation currentLocation}.
     *
     * @return
     */
    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    /**
     * Get {@link #locationMaps}
     *
     * @return The locationMaps map.
     */
    public HashMap<String, Location> getLocationMaps() {
        return locationMaps;
    }

    /**
     * Get the name of {@link #currentLocation}.
     *
     * @return The name of the current location.
     */
    public String getCurrentLocationName() {
        return this.getCurrentLocation().getName();
    }
}
