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
        /*The romms in the control location are created-----------------------*/
        
        /*Main corridor-------------------------------------------------------*/
        Room corridorRoom = new Room("Oxygen corridor" , "Main corridor of the oxygen room");
        
        super.addRoom(corridorRoom);
        
        /*Storage room--------------------------------------------------------*/
        Room storageRoom = new Room("Oxygen storage" , "Here the oxygen is storaged");
        
        super.addRoom(storageRoom);
        
        /*Oxygen room---------------------------------------------------------*/
        Room oxygenRoom = new Room("Oxygen room" , "Here oxygensuply can be refilled");
        super.addRoom(oxygenRoom);
        
        /*Setting exits and entrances-----------------------------------------*/
        super.addEntrance(corridorRoom);
        
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
