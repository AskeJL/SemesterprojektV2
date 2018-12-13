package domain.locations.functional;

import domain.locations.Exit;
import domain.locations.ExitDirection;
import domain.locations.Location;
import domain.locations.Room;
import domain.locations.gameobjects.ControllerOutside;
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
    
    @Override
    public void init() {
        resourcesManager = (ResourcesManager) this.gameElementGroup.getManagerGroup().getManager(ResourcesManager.class);

        createLocationCLI();
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
    
    @Override
    protected void createLocationCLI() {
        /*The rooms in the outside location are created-----------------------*/

        /*outside-------------------------------------------------------------*/
        Room outside = new Room("Outside", "You are now outside and here you can repair the ship");
        outside.addGameObject(new ControllerOutside(resourcesManager));
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
