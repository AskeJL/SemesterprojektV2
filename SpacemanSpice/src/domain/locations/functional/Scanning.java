package domain.locations.functional;

import domain.locations.Exit;
import domain.locations.ExitDirection;
import domain.locations.Location;
import domain.locations.Room;
import domain.locations.gameobjects.ControlScanning;
import domain.systems.SystemsManager;

/**
 * Functional location, where fragments can be identified.
 */
public final class Scanning extends Location {

    private SystemsManager systemsManager;

    public Scanning() {
        super("Scanning", "In this location spacedebris can be scanned.");
    }

    public Scanning(Boolean gui) {
        super(
                "Scanning",
                "In this location spacedebris can be scanned.",
                null,
                new Exit('E', "Control"),
                new Exit('N', "Personal"),
                null,
                "scanningMap.txt");
    }

    /**
     * Will call the {@link domain.systems.SystemsManager} in the main
     * {@link domain.ManagerGroup}. Then proceeds to
     * {@link #createLocationCLI()}
     */
    @Override
    public void init() {
        systemsManager = (SystemsManager) this.gameElementGroup.getManagerGroup().getManager(SystemsManager.class);

        createLocationCLI();
    }

    /**
     * Creates a scanning {@link Room}, a display {@link Room} and a sensor
     * {@link Room}.
     * <p>
     * A {@link ControlScanning} is added to the scanning {@link Room}.
     */
    @Override
    protected void createLocationCLI() {
        /*The rooms in the scanning location are created----------------------*/

 /*Scanning room-------------------------------------------------------*/
        Room scanningRoom = new Room("Scanning Control", "Space debris can be scanned from here.");
        scanningRoom.addGameObject(new ControlScanning(this.systemsManager));
        super.addRoom(scanningRoom);

        /*Display room--------------------------------------------------------*/
        Room displayRoom = new Room("Scanning Display", "The most recent scan can be viewed here.");
        super.addRoom(displayRoom);

        /*Sensor room---------------------------------------------------------*/
        Room sensorRoom = new Room("Scanning Sensor", "The sensor equipment");
        super.addRoom(sensorRoom);

        /*Setting exits and entrances-----------------------------------------*/
        scanningRoom.addExit(new Exit(ExitDirection.NORTH, sensorRoom));
        scanningRoom.addExit(new Exit(ExitDirection.EAST, displayRoom));
        displayRoom.addExit(new Exit(ExitDirection.WEST, scanningRoom));
        sensorRoom.addExit(new Exit(ExitDirection.SOUTH, scanningRoom));
    }

    @Override
    public String toString() {
        return "locations.functional.Scanning : Name [" + this.getName() + "] Description [" + this.getDescription() + "]";
    }
}
