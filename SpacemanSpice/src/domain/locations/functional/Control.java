package domain.locations.functional;

import domain.locations.Exit;
import domain.locations.ExitDirection;
import domain.locations.Location;
import domain.locations.LocationsManager;
import domain.locations.Room;
import domain.locations.gameobjects.SteeringControl;
import domain.systems.SystemsManager;

/**
 * Functional location, that controls the movement of the spaceship.
 */

public final class Control extends Location {

    private SystemsManager systemsManager;
    
    /**
     * Constructor that runs the createLocation method.
     */
    
    public Control() {
        super("Control", "In this location the ship is controlled.");
    }
    
    @Override
    public void init() {
        systemsManager = (SystemsManager) this.gameElementGroup.getManagerGroup().getManager(SystemsManager.class);

        createLocation();
    }
    
    @Override
    protected void createLocation() {
        /*The rooms in the control location are created-----------------------*/

        /*Steering------------------------------------------------------------*/
        Room steeringRoom = new Room("Control Steering", "The ship is controlled from here.");
        steeringRoom.addGameObject(new SteeringControl(systemsManager));
        super.addRoom(steeringRoom);

        /*Navigation----------------------------------------------------------*/
        Room navigationRoom = new Room("Control Navigation", "The ships current position is stored here.");
        super.addRoom(navigationRoom);

        /*Control-------------------------------------------------------------*/
        Room controlRoom = new Room("Control Observation", "It is from here, all outside oberservations can be made.");
        super.addRoom(controlRoom);

        /*Setting exits and entrances-----------------------------------------*/
        controlRoom.addExit(new Exit(ExitDirection.NORTH, steeringRoom));
        controlRoom.addExit(new Exit(ExitDirection.WEST, navigationRoom));

        navigationRoom.addExit(new Exit(ExitDirection.EAST, controlRoom));

        steeringRoom.addExit(new Exit(ExitDirection.SOUTH, controlRoom));
    }

    @Override
    public String toString() {
        return "locations.functional.Control : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
}
