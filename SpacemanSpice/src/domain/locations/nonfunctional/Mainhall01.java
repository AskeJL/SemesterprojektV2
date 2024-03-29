package domain.locations.nonfunctional;

import domain.locations.Exit;
import domain.locations.Location;
import domain.locations.Room;

/**
 * Nonfunctional location, that connects the functional location: Personal, Oxygen, Control.
 */
public final class Mainhall01 extends Location {
    
    public Mainhall01(){
        super("Mainhall01", "This is the 1st mainhall on the space ship");
        
        createLocationCLI();
    }
    
    /**
     *  Makes a gui Mainhall01 location
     *  Sends name, desciption, exits and map file name
     * 
     * @param gui 
     * 
     * @see domain.locations.LocationsManager#createLocationGUI() 
     */
    public Mainhall01(Boolean gui){
                   super(
                   "Mainhall01", 
                   "This is the 1st mainhall on the space ship.",
                   new Exit('S', "Control"),
                   new Exit('E', "Oxygen"),
                   new Exit('N', "Mainhall02"),
                   new Exit('W', "Personal"), 
                   "mainhall01Map.txt");
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
        /*The room in the mainhall01 location are created---------------------*/
        
        /*Mainhall 01---------------------------------------------------------*/
        Room mainhall01 = new Room("Mainhall 01", "This is the upper part of the mainhall.");
        super.addRoom(mainhall01);
    }
    
    @Override
    public String toString(){
        return "locations.nonfunctional.Mainhall01 : Name[" + this.getName() + "] Description [" + this.getDescription() + "]";
    }
}
