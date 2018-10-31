package spacemanspice.locations.functional;

import spacemanspice.locations.Exit;
import spacemanspice.locations.ExitDirection;
import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

public class Oxygen extends Location {
    
    public Oxygen(){
        super("Oxygen" , "Oxygen is refueled from here");
        
        createLocation();
    }
    
    @Override
    public void createLocation(){
        
        //The three rooms in oxygen are added here
        //Main corridor
        Room corridorRoom = new Room("Oxygen corridor" , "Main corridor of the oxygen room");
        super.addRoom(corridorRoom);
        //Oxygen storage
        Room storageRoom = new Room("Oxygen storage" , "Here the oxygen is storaged");
        super.addRoom(storageRoom);
        //Oxygen ????
        Room oxygenRoom = new Room("" , "");
        super.addRoom(oxygenRoom);
        
        //Here we set the exits up
        corridorRoom.addExit(new Exit(ExitDirection.NORTH, storageRoom));
        corridorRoom.addExit(new Exit(ExitDirection.SOUTH, oxygenRoom));
        
        storageRoom.addExit(new Exit(ExitDirection.SOUTH, corridorRoom));
        oxygenRoom.addExit(new Exit(ExitDirection.NORTH, corridorRoom));
    }
    
    @Override
    public String toString(){
            return "locations.functional.Oxygen : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
}
