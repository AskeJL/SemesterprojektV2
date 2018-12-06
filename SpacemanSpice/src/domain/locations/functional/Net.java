package domain.locations.functional;

import domain.locations.Exit;
import domain.locations.ExitDirection;
import domain.locations.Location;
import domain.locations.Room;
import domain.locations.gameobjects.NetControl;
import domain.systems.SystemsManager;

/**
 * Functional location, that utilizes nets to clear medium fragments.
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
        Room NetCorridor = new Room("Net Corridor","This is the main corridor in the location");
        super.addRoom(NetCorridor);
        
        /*Net control---------------------------------------------------------*/
        Room NetRoom = new Room("Net Control","Here you control the space net");
        NetRoom.addGameObject(new NetControl((SystemsManager) locationsManager.fetchController(SystemsManager.class)));
        super.addRoom(NetRoom);
        
        /*Netbay--------------------------------------------------------------*/
        Room NetBay = new Room("Net Bay","Here you can fix your net");
        super.addRoom(NetBay);
        
        /*Setting exits and entrances-----------------------------------------*/
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
