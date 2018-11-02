package spacemanspice.locations.nonfunctional;

import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

/**
 * Nonfunctional location, that connects the functional locations: Personal, Net, Laser
 */

public final class Hallway01 extends Location {

    /**
     * Constructor that runs the createLocation method.
     */
    
    public Hallway01() {
        super("Hallway01", "Hallway connecting Personal, Laser and Net");
        
        createLocation();
    }

    @Override
    protected void createLocation() {
        /*The rooms in the hallway01 location are created---------------------*/
        
        /*Hallway-------------------------------------------------------------*/
        Room hallway = new Room("Hallway", "This hallway connects the Personal, Laser and Net");
        super.addRoom(hallway);
        
        /*Setting entrance----------------------------------------------------*/
        super.addEntrance(hallway);
    }

    @Override
    public String toString() {
        return "locations.functional.Control : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
    
}
