package domain.locations.functional;

import domain.GameElementGroup;
import domain.locations.Exit;
import domain.locations.ExitDirection;
import domain.locations.Location;
import domain.locations.Room;
import domain.locations.gameobjects.ControlLaser;
import domain.systems.SystemsManager;

/**
 * Functional location, that uses a laser to destroy small fragments
 */
public final class Laser extends Location {
    
    private SystemsManager systemsManager;
    
    /**
     * Constructor that runs the createLocationCLI method.
     */
    public Laser() {
        super("Laser", "The laser is operated from here.");
    }
    
    @Override
    public void init() {
        systemsManager = (SystemsManager) this.gameElementGroup.getManagerGroup().getManager(SystemsManager.class);

        createLocationCLI();
    }

    public Laser(Boolean gui){
                   super(
                   "Laser", 
                   "The laser is operated from here.",
                   null,
                   new Exit('E', "Mainhall02"),
                   null,
                   new Exit('W', "Hallway01"), 
                   "laserMap.txt");
    }
    
    @Override
    protected void createLocationCLI() {
        /*The rooms in the laser location are created-------------------------*/

        /*Corridor------------------------------------------------------------*/
        Room corridorRoom = new Room("Laser Corridor", "Main corridor for the laser.");
        super.addRoom(corridorRoom);

        /*Technic-------------------------------------------------------------*/
        Room technicRoom = new Room("Laser Technic", "The technical parts of the laser.");
        super.addRoom(technicRoom);

        /*Controls------------------------------------------------------------*/
        Room controlsRoom = new Room("Laser Controls", "The controls for the laser.");
        controlsRoom.addGameObject(new ControlLaser(systemsManager));
        
        super.addRoom(controlsRoom);

        /*Setting exits and entrances-----------------------------------------*/
        corridorRoom.addExit(new Exit(ExitDirection.NORTH, technicRoom));
        corridorRoom.addExit(new Exit(ExitDirection.SOUTH, controlsRoom));
        technicRoom.addExit(new Exit(ExitDirection.SOUTH, corridorRoom));
        controlsRoom.addExit(new Exit(ExitDirection.NORTH, corridorRoom));
    }
    
    

    @Override
    public String toString() {
        return "locations.functional.Laser : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
}
