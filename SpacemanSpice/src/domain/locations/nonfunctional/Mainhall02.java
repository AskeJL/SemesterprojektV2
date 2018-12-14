package domain.locations.nonfunctional;

import domain.locations.Exit;
import domain.locations.Location;
import domain.locations.Room;

/**
 * Nonfunctional location, that connects the functional location: Laser, Net, Outside.
 */
public final class Mainhall02 extends Location {
    
    public Mainhall02(){
        super("Mainhall02", "This is the 2nd mainhall on the space ship");
        
        createLocationCLI();
    }
    
    /**
     *  Makes a gui Mainhall02 location
     *  Sends name, desciption, exits and map file name
     * 
     * @param gui
     * 
     * @see domain.locations.LocationsManager#createLocationGUI() 
     */
    public Mainhall02(Boolean gui){
                   super(
                   "Mainhall02", 
                   "This is the 2nd mainhall on the space ship.",
                   new Exit('S', "Mainhall01"),
                   new Exit('E', "Outside"),
                   new Exit('N', "Net"),
                   new Exit('W', "Laser"), 
                   "mainhall02Map.txt");
    }

    @Override
    public void init() {

    }
    
    /**
     * Makes a CLI Mainhall01 location by adding rooms to a location
     * 
     * @see domain.locations.LocationsManager#createLocations() 
     */
    @Override
    protected void createLocationCLI(){
        /*The room in the location are created--------------------------------*/
        
        /*Mainhall 02---------------------------------------------------------*/
        Room mainhall02 = new Room("Mainhall 02", "This is the lower part of the mainhall.");
        super.addRoom(mainhall02);
    }
    
    @Override
    public String toString(){
        return "locations.nonfunctional.Mainhall02 : Name[" + this.getName() + "] Description [" + this.getDescription() + "]";
    }
}
