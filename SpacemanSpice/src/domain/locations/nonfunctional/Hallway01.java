package domain.locations.nonfunctional;

import domain.locations.Exit;
import domain.locations.ExitDirection;
import domain.locations.Location;
import domain.locations.Room;

/**
 * Nonfunctional location, that connects the functional locations: Personal, Net, Laser
 */
public final class Hallway01 extends Location {

    /**
     * Constructor that runs the createLocationCLI method.
     */
    public Hallway01() {
        super("Hallway01", "Hallway connecting Personal, Laser and Net");
        
        createLocationCLI();
    }

    public Hallway01(Boolean gui){
                   super(
                   "Hallway01", 
                   "Hallway connecting Personal, Laser and Net.",
                   new Exit(ExitDirection.SOUTH, "Personal"),
                   new Exit(ExitDirection.EAST, "Laser"),
                   new Exit(ExitDirection.EAST, "Net"),
                   null, 
                   "hallway01Map.txt");
    }
    
    @Override
    protected void createLocationCLI() {
        /*The rooms in the hallway01 location are created---------------------*/
        
        /*Hallway-------------------------------------------------------------*/
        Room hallway = new Room("Hallway 01", "This hallway connects the Personal, Laser and Net");
        super.addRoom(hallway);
    }

    @Override
    public String toString() {
        return "locations.functional.Control : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
}
