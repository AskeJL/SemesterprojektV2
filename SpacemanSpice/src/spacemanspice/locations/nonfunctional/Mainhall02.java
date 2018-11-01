package spacemanspice.locations.nonfunctional;

import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

public class Mainhall02 extends Location {
    
    public Mainhall02(){
        super("Mainhall02", "This is the 2nd mainhall on the space ship");
        
        createLocation();
    }
    
    @Override
    public void createLocation(){
        /*The romm in the location are created--------------------------------*/
        
        /*Mainhall 02---------------------------------------------------------*/
        Room mainhall02 = new Room("Mainhall", "This is the upper part of the mainhall.");
        
        super.addRoom(mainhall02);
        
        /*Adding entrance-----------------------------------------------------*/
        super.addEntrance(mainhall02);
    }
    
    @Override
    public String toString(){
        return "locations.nonfunctional.Mainhall02 : Name[" + this.getName() + "] Description [" + this.getDescription() + "]";
    }
    
}
