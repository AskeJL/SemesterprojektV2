package controller.locations.nonfunctional;

import controller.locations.Location;
import controller.locations.Room;

/**
 * Nonfunctional location, that connects the functional location: Laser, Net, Outside.
 */
public final class Mainhall02 extends Location {
    
    /**
     * Constructor that runs the createLocation method.
     */
    public Mainhall02(){
        super("Mainhall02", "This is the 2nd mainhall on the space ship");
        
        createLocation();
    }
    
    @Override
    protected void createLocation(){
        /*The room in the location are created--------------------------------*/
        
        /*Mainhall 02---------------------------------------------------------*/
        Room mainhall02 = new Room("Mainhall 02", "This is the lower part of the mainhall.");
        super.addRoom(mainhall02);
        
        /*Adding entrance-----------------------------------------------------*/
        super.addEntrance(mainhall02);
    }
    
    @Override
    public String toString(){
        return "locations.nonfunctional.Mainhall02 : Name[" + this.getName() + "] Description [" + this.getDescription() + "]";
    }
}
