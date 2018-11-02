package controller.locations.functional;

import controller.locations.Exit;
import controller.locations.ExitDirection;
import controller.locations.Location;
import controller.locations.Room;

/**
 * Functional location, that utilises nets to clear medium fragments.
 */

public final class Net extends Location {
    
    /**
     * Constructor that runs the createLocation method.
     */
    
    public Net() {
        super("Net", "In this location the net is controlled and repaired");
        
        createLocation();
    }
    
    @Override
    protected void createLocation() {
        /*The rooms in the net location are created---------------------------*/
        
        /*Corridor------------------------------------------------------------*/
        Room NetCorridor = new Room("Net corridor","This is the main corridor in the location");
        super.addRoom(NetCorridor);
        
        /*Net control---------------------------------------------------------*/
        Room NetRoom = new Room("net Room","Here you control the space net");
        super.addRoom(NetRoom);
        
        /*Netbay--------------------------------------------------------------*/
        Room NetBay = new Room("Net bay","Here you can fix your net");
        super.addRoom(NetBay);
        
        /*Setting exits and entrances-----------------------------------------*/
        super.addEntrance(NetCorridor);
        
        NetCorridor.addExit(new Exit(ExitDirection.EAST,NetRoom));
        NetCorridor.addExit(new Exit(ExitDirection.WEST,NetBay));
        
        NetRoom.addExit(new Exit(ExitDirection.WEST,NetCorridor));
        
        NetBay.addExit(new Exit(ExitDirection.EAST,NetCorridor));
        
       
        
    }

    @Override
    public String toString() {
        return "locations.Room : Name[" + this.getName() + "] Description[" + this.getDescription() + this.getExits()+ "]";
    }
    
}
