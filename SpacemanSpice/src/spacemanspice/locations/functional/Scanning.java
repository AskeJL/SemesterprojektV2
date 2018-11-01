package spacemanspice.locations.functional;

import spacemanspice.locations.Exit;
import spacemanspice.locations.ExitDirection;
import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

public class Scanning extends Location {
    
    public Scanning(){
        super("Scanning", "Space debris can be scanned from here.");
        createLocation();
    }
    
    @Override
    public void createLocation(){
        Room scanningRoom = new Room("Scanning Scanning", "Space debris can be scanned from here.");
        super.addRoom(scanningRoom);
        
        Room displayRoom = new Room("Display", "The most recent scan can be viewed here.");
        super.addRoom(displayRoom);
        
        Room sensorRoom = new Room("Sensor", "The sensor equipment");
        super.addRoom(sensorRoom);
        
        scanningRoom.addExit(new Exit(ExitDirection.NORTH, sensorRoom));
        scanningRoom.addExit(new Exit(ExitDirection.EAST, displayRoom));
        
        displayRoom.addExit(new Exit(ExitDirection.WEST, scanningRoom));
        sensorRoom.addExit(new Exit(ExitDirection.SOUTH, scanningRoom));
        
        super.addEntrance(scanningRoom);
    }
    
    @Override
    public String toString(){
        return "locations.functional.Scanning : Name [" + this.getName() + "] Description [" + this.getDescription() + "]";
    }
}
