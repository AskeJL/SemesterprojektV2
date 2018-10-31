
package spacemanspice.locations.functional;

import spacemanspice.locations.Exit;
import spacemanspice.locations.ExitDirection;
import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

public class Personal extends Location{
    
    public Personal(){
        super("Personal" , "this is the personal room");
        
        createLocation();
    }
    
    @Override
    public void createLocation(){
        
        //The three rooms in personal are added here
        //Main room corridor
        Room corridorRoom = new Room("Personal corridor" , "Main corridor of the personal room");
        super.addRoom(corridorRoom);
        //Toilet room
        Room toiletRoom = new Room("Toilet" , "this is the toilet");
        super.addRoom(toiletRoom);
        //Bedroom
        Room bedroomRoom = new Room("Bedroom" , "This is the bedroom");
        super.addRoom(bedroomRoom);
        
        //Here we set the exits up
        corridorRoom.addExit(new Exit(ExitDirection.NORTH, toiletRoom));
        corridorRoom.addExit(new Exit(ExitDirection.EAST, bedroomRoom));
        
        toiletRoom.addExit(new Exit(ExitDirection.SOUTH, corridorRoom));
        bedroomRoom.addExit(new Exit(ExitDirection.WEST, corridorRoom));
    }
    
    @Override
    public String toString(){
        return "locations.functional.Personal : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
}
