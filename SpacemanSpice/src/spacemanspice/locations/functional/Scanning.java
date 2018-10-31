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
        super.addEntrance(scanningRoom);
    }
    
    //Dette
    //scanningRoom.addExit(new Exit(ExitDirection.WEST, ? ))
    //scanningRoom.addExit(new Exit(ExitDirection.SOUTH, ? ))
    //scanningRoom.addEntrance(new Entrance(EntranceDirection.WEST, ? ))
    //scanningRoom.addEntrance(new Entrance(EntranceDirection.SOUTH, ? ))
    
    //Scanning.addExit(new Exit(ExitDirection.WEST, Control))
    //Scanning.addExit(new Exit(ExitDirection.SOUTH, Personal))
    
    @Override
    public String toString(){
        return "locations.functional.Scanning : Name [" + this.getName() + "] Description [" + this.getDescription() + "]";
    }
}
