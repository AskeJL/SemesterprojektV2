package domain.locations.nonfunctional;

import domain.locations.Location;
import domain.locations.Room;

/**
 * Nonfunctional location, that connects the functional location: Personal, Oxygen, Control.
 */
public final class Mainhall01 extends Location {
    
    /**
     * Constructor that runs the createLocation method.
     */
    public Mainhall01(){
        super("Mainhall01", "This is the 1st mainhall on the space ship");
        
        createLocation();
    }
    
    @Override
    protected void createLocation(){
        /*The room in the mainhall01 location are created---------------------*/
        
        /*Mainhall 01---------------------------------------------------------*/
        Room mainhall01 = new Room("Mainhall 01", "This is the upper part of the mainhall.");
        super.addRoom(mainhall01);
    }
    
    @Override
    public String toString(){
        return "locations.nonfunctional.Mainhall01 : Name[" + this.getNAME() + "] Description [" + this.getDescription() + "]";
    }
}
