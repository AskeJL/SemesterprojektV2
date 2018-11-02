package spacemanspice.locations.functional;

import spacemanspice.locations.Exit;
import spacemanspice.locations.ExitDirection;
import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

/**
 * Functional location, where the player can repair the spaceship. 
 */

public final class Outside extends Location {

    /**
     * Constructor that runs the createLocation method.
     */
    
    public Outside() {
        super("Outside", "This location contains the airlock and from here it is possible to go outside");

        createLocation();
    }

    @Override
    protected void createLocation() {
        /*The rooms in the outside location are created-----------------------*/

        /*outside-------------------------------------------------------------*/
        Room outside = new Room("Outside", "You are now outside and here you can repair the ship");
        super.addRoom(outside);

        /*Airlock----------------------------------------------------------*/
        Room airlock = new Room("airlock", "You are now in the airlock");
        super.addRoom(airlock);

        /*Setting exits and entrances-----------------------------------------*/
        super.addEntrance(airlock);

        outside.addExit(new Exit(ExitDirection.EAST, airlock));

        airlock.addExit(new Exit(ExitDirection.WEST, airlock));
    }

    @Override
    public String toString() {
        return "locations.Room : Name[" + this.getName() + "] Description[" + this.getDescription() + this.getExits() + "]";
    }

}
