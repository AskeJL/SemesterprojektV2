package domain.locations.nonfunctional;

import domain.locations.Exit;
import domain.locations.Location;
import domain.locations.Room;

/**
 * Nonfunctional location, that connects the functional location: Control, Oxygen, Outside.
 */
public final class Hallway02 extends Location {

    public Hallway02() {
        super("Hallway 02", "The hallway connecting airlock, oxygen and navigation");
        
        createLocationCLI();
    }
    
    /**
     *  Makes a gui Hallway02 location
     *  Sends name, desciption, exits and map file name
     * 
     * @param gui 
     * 
     * @see domain.locations.LocationsManager#createLocationGUI() 
     */
    public Hallway02(Boolean gui){
                   super(
                   "Hallway02", 
                   "The hallway connecting airlock, oxygen and navigation.",
                   new Exit('W' ,"Control"),
                   null,
                   new Exit('N', "Outside"),
                   new Exit('W', "Oxygen"), 
                   "hallway02Map.txt");
    }
    
     @Override
    public void init() {
       
    }
     /**
     * Makes a CLI Hallway02 location by adding rooms to a location
     * 
     * @see domain.locations.LocationsManager#createLocations() 
     */
    @Override
    protected void createLocationCLI() {
        /*The room in the hallway02 location are created----------------------*/
        
        /*Hallway 02----------------------------------------------------------*/
        Room hallway02 = new Room("Hallway 02","This hallway connects the airlock, navigation and oxygen");
        super.addRoom(hallway02);
    }

    @Override
    public String toString() {
        return "locations.Room : Name[" + this.getName() + "] Description[" + this.getDescription() +" The exits are"+ this.getExits()+ "]";
    }

   
}
