package spacemanspice.locations.functional;

import spacemanspice.locations.Exit;
import spacemanspice.locations.ExitDirection;
import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

public class Scanning extends Location {
    
    public Scanning(){
        super("Scanning", "In this location spacedebree can be scanned.");
        
        createLocation();
    }
    
    @Override
    public void createLocation(){
        /*The romms in the control location are created-----------------------*/
        
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
