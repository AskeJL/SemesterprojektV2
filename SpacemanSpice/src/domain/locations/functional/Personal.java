package domain.locations.functional;

import domain.locations.Exit;
import domain.locations.ExitDirection;
import domain.locations.Location;
import domain.locations.Room;

/**
 * Functional location, the personal room of spaceman Spice.
 */
public final class Personal extends Location {

    public Personal() {
        super("Personal", "This location contains toilets and beerooms");
    }

    public Personal(Boolean gui) {
        super(
                "Personal",
                "This location contains a toilet and a bedroom.",
                new Exit('S', "Scanning"),
                new Exit('E', "Mainhall01"),
                new Exit('N', "Hallway01"),
                null,
                "personalMap.txt");
    }

    /**
     * Calls the {@link #createLocationCLI()} method.
     */
    @Override
    public void init() {
        createLocationCLI();
    }

    /**
     * Creates a corridor {@link Room}, a toilet {@link Room} and a bedroom
     * {@link Room}.
     */
    @Override
    protected void createLocationCLI() {
        /*The rooms in the personal location are created----------------------*/

        /*Corridor------------------------------------------------------------*/
        Room corridorRoom = new Room("Personal Corridor", "Main corridor of the personal room");
        super.addRoom(corridorRoom);

        /*Toilet--------------------------------------------------------------*/
        Room toiletRoom = new Room("Personal Toilet", "this is the toilet");
        super.addRoom(toiletRoom);

        /*bedroom-------------------------------------------------------------*/
        Room bedroomRoom = new Room("Personal Bedroom", "This is the bedroom");
        super.addRoom(bedroomRoom);

        /*Setting exits and entrances-----------------------------------------*/
        corridorRoom.addExit(new Exit(ExitDirection.EAST, bedroomRoom));
        toiletRoom.addExit(new Exit(ExitDirection.SOUTH, bedroomRoom));
        bedroomRoom.addExit(new Exit(ExitDirection.NORTH, toiletRoom));
        bedroomRoom.addExit(new Exit(ExitDirection.WEST, corridorRoom));
    }

    @Override
    public String toString() {
        return "locations.functional.Personal : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
}
