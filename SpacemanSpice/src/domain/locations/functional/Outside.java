package domain.locations.functional;

import domain.locations.Exit;
import domain.locations.ExitDirection;
import domain.locations.Location;
import domain.locations.Room;
import domain.locations.gameobjects.ControlOutside;
import domain.resources.ResourcesManager;

/**
 * Functional location, where the player can repair the spaceship. 
 */
public final class Outside extends Location {

    private ResourcesManager resourcesManager;
    
    /**
     * Constructor that runs the createLocationCLI method.
     */
    public Outside() {
        super("Outside", "This location contains the airlock and from here it is possible to go outside");
    }

    public Outside(Boolean gui){
                   super(
                   "Outside", 
                   "This location contains the airlock and from here it is possible to go outside.",
                   new Exit('S', "Hallway02"),
                   null,
                   null,
                   new Exit('W', "Mainhall02"), 
                   "outsideMap.txt");
    }
    
    /**
     * Will call the {@link domain.systems.SystemsManager} in the main
     * {@link domain.ManagerGroup}. Then proceeds to
     * {@link #createLocationCLI()}
     */
    @Override
    public void init() {
        resourcesManager = (ResourcesManager) this.gameElementGroup.getManagerGroup().getManager(ResourcesManager.class);

        createLocationCLI();
    }
    
    /**
     * Creates an outside {@link Room} and an airlock
     * {@link Room}.
     * <p>
     * A {@link ControlOutside} is added to the outside {@link Room}.
     */
    @Override
    protected void createLocationCLI() {
        /*The rooms in the outside location are created-----------------------*/

        /*outside-------------------------------------------------------------*/
        Room outside = new Room("Outside", "You are now outside and here you can repair the ship");
        outside.addGameObject(new ControlOutside(resourcesManager));
        super.addRoom(outside);

        /*Airlock----------------------------------------------------------*/
        Room airlock = new Room("Airlock", "You are now in the airlock");
        super.addRoom(airlock);

        /*Setting exits and entrances-----------------------------------------*/
        outside.addExit(new Exit(ExitDirection.EAST, airlock));
        airlock.addExit(new Exit(ExitDirection.WEST, outside));
    }

    @Override
    public String toString() {
        return "locations.Room : Name[" + this.getName() + "] Description[" + this.getDescription() + this.getExits() + "]";
    }
}
