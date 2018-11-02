package spacemanspice.locations.functional;

import spacemanspice.locations.Exit;
import spacemanspice.locations.ExitDirection;
import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

/**
 * Functional location, the personal room of spaceman Spice.
 */

public final class Personal extends Location {

    /**
     * Constructor that runs the createLocation method.
     */
    
    public Personal() {
        super("Personal", "This location contains toilets and beerooms");

        createLocation();
    }

    @Override
    protected void createLocation() {
        /*The rooms in the personal location are created----------------------*/

        /*Corridor------------------------------------------------------------*/
        Room corridorRoom = new Room("Personal corridor", "Main corridor of the personal room");
        super.addRoom(corridorRoom);

        /*Toilet--------------------------------------------------------------*/
        Room toiletRoom = new Room("Toilet", "this is the toilet");
        super.addRoom(toiletRoom);

        /*bedroom-------------------------------------------------------------*/
        Room bedroomRoom = new Room("Bedroom", "This is the bedroom");
        super.addRoom(bedroomRoom);

        /*Setting exits and entrances-----------------------------------------*/
        super.addEntrance(corridorRoom);

        corridorRoom.addExit(new Exit(ExitDirection.NORTH, toiletRoom));
        corridorRoom.addExit(new Exit(ExitDirection.EAST, bedroomRoom));

        toiletRoom.addExit(new Exit(ExitDirection.SOUTH, corridorRoom));

        bedroomRoom.addExit(new Exit(ExitDirection.WEST, corridorRoom));
    }

    @Override
    public String toString() {
        return "locations.functional.Personal : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
}
