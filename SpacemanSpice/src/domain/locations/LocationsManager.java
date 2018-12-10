package domain.locations;

import domain.locations.functional.*;
import domain.locations.nonfunctional.*;
import domain.Manager;
import java.util.List;
import domain.GameUpdateable;
import java.util.ArrayList;

public class LocationsManager extends Manager implements GameUpdateable {

    private final List<Location> locations = new ArrayList<>();
    private Room currentRoom;
    private Location currentLocation;
    
    @Override
    public void init() {
        Location.init(this);
        
        createLocations();
        currentLocation = locations.get(5);
        currentRoom = currentLocation.getRooms().get(2);
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
}
