package domain.locations.functional;

import domain.locations.Exit;
import domain.locations.ExitDirection;
import domain.locations.Location;
import domain.locations.Room;
import domain.locations.gameobjects.OxygenControl;
import domain.locations.nonfunctional.*;
import domain.resources.ResourcesManager;

/**
 * Functional location, that refuels oxygen.
 */
public final class Oxygen extends Location {

    /**
     * Constructor that runs the createLocationCLI method.
     */
    public Oxygen() {
        super("Oxygen", "Oxygen is refueled from here");

        createLocationCLI();
    }

    public Oxygen(Boolean gui){
                   super(
                   "Oxygen", 
                   "Oxygen is refueled from here.",
                   null,
                   new Exit(ExitDirection.EAST, "Hallway02"),
                   null,
                   new Exit(ExitDirection.WEST, "Mainhall01"), 
                   "oxygenMap.txt");
    }
    
    @Override
    protected void createLocationCLI() {
        /*The rooms in the oxygen location are created------------------------*/

        /*Main corridor-------------------------------------------------------*/
        Room corridorRoom = new Room("Oxygen Corridor", "Main corridor of the oxygen room");
        super.addRoom(corridorRoom);

        /*Storage room--------------------------------------------------------*/
        Room storageRoom = new Room("Oxygen Storage", "Here the oxygen is storaged");
        super.addRoom(storageRoom);

        /*Oxygen room---------------------------------------------------------*/
        Room refuelRoom = new Room("Oxygen Refuel", "Here oxygen suply can be refilled");
        refuelRoom.addGameObject(new OxygenControl((ResourcesManager) locationsManager.fetchController(ResourcesManager.class)));
        super.addRoom(refuelRoom);

        /*Setting exits and entrances-----------------------------------------*/
        corridorRoom.addExit(new Exit(ExitDirection.NORTH, storageRoom));
        corridorRoom.addExit(new Exit(ExitDirection.SOUTH, refuelRoom));
        storageRoom.addExit(new Exit(ExitDirection.SOUTH, corridorRoom));
        refuelRoom.addExit(new Exit(ExitDirection.NORTH, corridorRoom));
    }

    @Override
    public String toString() {
        return "locations.functional.Oxygen : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
}
