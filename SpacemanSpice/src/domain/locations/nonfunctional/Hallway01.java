package domain.locations.nonfunctional;

import domain.locations.Exit;
import domain.locations.Location;
import domain.locations.Room;

/**
 * Nonfunctional location, that connects the functional locations: Personal, Net, Laser
 */
public final class Hallway01 extends Location {

    public Hallway01() {
        super("Hallway01", "Hallway connecting Personal, Laser and Net");
        
        createLocationCLI();
    }
    
    /**
     *  Makes a gui Hallway01 location
     *  Sends name, desciption, exits and map file name
     * 
     * @param gui 
     * 
     * @see domain.locations.LocationsManager#createLocationGUI() 
     */
    public Hallway01(Boolean gui){
                   super(
                   "Hallway01", 
                   "Hallway connecting Personal, Laser and Net.",
                   new Exit('S', "Personal"),
                   new Exit('E', "Laser"),
                   new Exit('E', "Net"),
                   null, 
                   "hallway01Map.txt");
    }
    @Override
    public void init() {
      //Nothing to init
    }
    
    /**
     * Makes a CLI Hallway location by adding rooms to a location
     * 
     * @see domain.locations.LocationsManager#createLocations() 
     */
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
