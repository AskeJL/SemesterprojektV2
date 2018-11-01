package spacemanspice.locations.nonfunctional;

import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

public class Mainhall01 extends Location {
    
    
    public Mainhall01(){
        super("Mainhall01", "This is the 1st mainhall on the space ship");
        
        createLocation();
    }
    
    
    @Override
    public void createLocation(){
        /*The romm in the control location are created------------------------*/
        
        /*Mainhall 01---------------------------------------------------------*/
        Room mainhall01 = new Room("Mainhall", "This is the upper part of the mainhall.");
        super.addRoom(mainhall01);
        
        /*Adding entrance-----------------------------------------------------*/
        super.addEntrance(mainhall01);
    }
    
    
    @Override
    public String toString(){
        return "locations.nonfunctional.Mainhall01 : Name[" + this.getName() + "] Description [" + this.getDescription() + "]";
    }
    
}
