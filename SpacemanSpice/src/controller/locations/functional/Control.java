package controller.locations.functional;

import controller.locations.Exit;
import controller.locations.ExitDirection;
import controller.locations.Location;
import controller.locations.Room;
import controller.locations.gameobjects.SteeringControl;

/**
 * Functional location, that controls the movement of the spaceship.
 */

public final class Control extends Location {

    /**
     * Constructor that runs the createLocation method.
     */
    
    public Control() {
        super("Control", "In this location the ship is controlled.");

        createLocation();
    }

    @Override
    protected void createLocation() {
        /*The rooms in the control location are created-----------------------*/

        /*Steering------------------------------------------------------------*/
        Room steeringRoom = new Room("Control Steering", "The ship is controlled from here.");
        steeringRoom.addGameObject(new SteeringControl());
        super.addRoom(steeringRoom);

        /*Navigation----------------------------------------------------------*/
        Room navigationRoom = new Room("Control Navigation", "The ships current position is stored here.");
        super.addRoom(navigationRoom);

        /*Control-------------------------------------------------------------*/
        Room controlRoom = new Room("Control Observation", "It is from here, all outside oberservations can be made.");
        super.addRoom(controlRoom);

        /*Setting exits and entrances-----------------------------------------*/
        super.addEntrance(controlRoom);

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
