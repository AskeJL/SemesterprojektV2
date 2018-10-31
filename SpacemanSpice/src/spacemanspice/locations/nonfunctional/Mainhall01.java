package spacemanspice.locations.nonfunctional;

import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

public class Mainhall01 extends Location {
    
    //Constructor
    public Mainhall01(){
        super("Mainhall01", "This is the 1st mainhall on the space ship");
        
        createLocation();
    }
    
    //Create location method
    @Override
    public void createLocation(){
        
        //Add rooms
        Room mainhall01 = new Room("Mainhall", "This is the upper part of the mainhall.");
        
        //Added room as entrance
        super.addEntrance(mainhall01);
    }
    
    //toString method
    @Override
    public String toString(){
        return "locations.nonfunctional.Mainhall01 : Name[" + this.getName() + "] Description [" + this.getDescription() + "]";
    }
    
}
