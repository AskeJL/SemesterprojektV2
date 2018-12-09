package domain.locations.functional;

import domain.locations.Exit;
import domain.locations.ExitDirection;
import domain.locations.Location;
import domain.locations.Room;
import domain.locations.gameobjects.ScanningControl;
import domain.systems.SystemsManager;

/**
 * Functional location, where fragments can be identified.
 */
public final class Scanning extends Location {

    /**
     * Constructor that runs the createLocationCLI method.
     */
    public Scanning() {
        super("Scanning", "In this location spacedebris can be scanned.");

        createLocationCLI();
    }
    
    public Scanning(Boolean gui){
                   super(
                   "Scanning", 
                   "In this location spacedebris can be scanned.",
                   null,
                   new Exit('e', "Control"),
                   new Exit('n', "Personal"),
                   null, 
                   "scanningMap.txt");
    }

    @Override
    protected void createLocationCLI() {
        /*The rooms in the scanning location are created----------------------*/

        /*Scanning room-------------------------------------------------------*/
        Room scanningRoom = new Room("Scanning Control", "Space debris can be scanned from here.");
        scanningRoom.addGameObject(new ScanningControl((SystemsManager) locationsManager.fetchController(SystemsManager.class)));
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
