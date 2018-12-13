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
    
    private SystemsManager systemsManager;
    
    /**
     * Constructor that runs the createLocationCLI method.
     */
    public Net() {
        super("Net", "In this location the net is controlled and repaired");
    }
    
    @Override
    public void init() {
        systemsManager = (SystemsManager) this.gameElementGroup.getManagerGroup().getManager(SystemsManager.class);
        
        createLocationCLI();
    }
    
    public Net(Boolean gui){
                   super(
                   "Net", 
                   "In this location the net is controlled and repaired.",
                   new Exit('S', "Mainhall02"),
                   null,
                   null,
                   new Exit('S', "Hallway01"), 
                   "netMap.txt");
    }
    
    @Override
    protected void createLocationCLI() {
        /*The rooms in the net location are created---------------------------*/
        
        /*Corridor------------------------------------------------------------*/
        Room NetCorridor = new Room("Net Corridor","This is the main corridor in the location");
        super.addRoom(NetCorridor);
        
        /*Net control---------------------------------------------------------*/
        Room NetRoom = new Room("Net Control","Here you control the space net");
        NetRoom.addGameObject(new NetControl(systemsManager));
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
