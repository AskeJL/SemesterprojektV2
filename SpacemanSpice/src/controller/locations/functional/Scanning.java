package controller.locations.functional;

import controller.locations.Exit;
import controller.locations.ExitDirection;
import controller.locations.Location;
import controller.locations.Room;

/**
 * Functional location, where fragments can be identified.
 */

public final class Scanning extends Location {
    
    /**
     * Constructor that runs the createLocation method.
     */
    
    public Scanning(){
        super("Scanning", "In this location spacedebree can be scanned.");
        
        createLocation();
    }
    
    @Override
    protected void createLocation(){
        /*The rooms in the scanning location are created----------------------*/
        
        /*Scanning room-------------------------------------------------------*/
        Room scanningRoom = new Room("Scanning", "Space debris can be scanned from here.");
        super.addRoom(scanningRoom);
        
        /*Display room--------------------------------------------------------*/
        Room displayRoom = new Room("Display", "The most recent scan can be viewed here.");
        super.addRoom(displayRoom);
        
        /*Sensor room---------------------------------------------------------*/
        Room sensorRoom = new Room("Sensor", "The sensor equipment");
        super.addRoom(sensorRoom);
        
        /*Setting exits and entrances-----------------------------------------*/
          super.addEntrance(scanningRoom);

        scanningRoom.addExit(new Exit(ExitDirection.NORTH, sensorRoom));
        scanningRoom.addExit(new Exit(ExitDirection.EAST, displayRoom));
        
        displayRoom.addExit(new Exit(ExitDirection.WEST, scanningRoom));
        
        sensorRoom.addExit(new Exit(ExitDirection.SOUTH, scanningRoom));
    }
    
    @Override
    public String toString(){
        return "locations.functional.Scanning : Name [" + this.getName() + "] Description [" + this.getDescription() + "]";
    }
}
