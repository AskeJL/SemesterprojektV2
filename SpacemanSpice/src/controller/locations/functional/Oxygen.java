package controller.locations.functional;

import controller.locations.Exit;
import controller.locations.ExitDirection;
import controller.locations.Location;
import controller.locations.Room;
import controller.locations.gameobjects.OxygenControl;

/**
 * Functional location, that refuels oxygen.
 */
public final class Oxygen extends Location {

    /**
     * Constructor that runs the createLocation method.
     */
    public Oxygen() {
        super("Oxygen", "Oxygen is refueled from here");

        createLocation();
    }

    @Override
    protected void createLocation() {
        /*The rooms in the oxygen location are created------------------------*/

        /*Main corridor-------------------------------------------------------*/
        Room corridorRoom = new Room("Oxygen Corridor", "Main corridor of the oxygen room");
        super.addRoom(corridorRoom);

        /*Storage room--------------------------------------------------------*/
        Room storageRoom = new Room("Oxygen Storage", "Here the oxygen is storaged");
        super.addRoom(storageRoom);

        /*Oxygen room---------------------------------------------------------*/
        Room refuelRoom = new Room("Oxygen Refuel", "Here oxygen suply can be refilled");
        refuelRoom.addGameObject(new OxygenControl());
        super.addRoom(refuelRoom);

        /*Setting exits and entrances-----------------------------------------*/
        super.addEntrance(corridorRoom);

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
