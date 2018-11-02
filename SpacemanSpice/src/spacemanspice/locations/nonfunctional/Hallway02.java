package spacemanspice.locations.nonfunctional;

import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

/**
 * Nonfunctional location, that connects the functional location: Control, Oxygen, Outside.
 */
public final class Hallway02 extends Location {

    /**
     * Constructor that runs the createLocation method.
     */
    
    public Hallway02() {
        super("Hallway 02", "The hallway connecting airlock, oxygen and navigation");
        
        createLocation();
    }

    @Override
    protected void createLocation() {
        /*The room in the hallway02 location are created----------------------*/
        
        /*Hallway 02----------------------------------------------------------*/
        Room hallway02 = new Room("Hallway 02","This hallway connects the airlock, navigation and oxygen");
        super.addRoom(hallway02);
        
        /*Setting entrance----------------------------------------------------*/
        super.addEntrance(hallway02);
    }

    @Override
    public String toString() {
        return "locations.Room : Name[" + this.getName() + "] Description[" + this.getDescription() +" The exits are"+ this.getExits()+ "]";
    }
    
}
