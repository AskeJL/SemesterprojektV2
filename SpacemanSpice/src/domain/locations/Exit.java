package domain.locations;

/**
 * An exit from on room/location to another. This is used to map out the
 * positions of the {@link Room}s and {@link Location}s.
 *
 * @see LocationsController#createLocations()
 */
public class Exit {

    /**
     * Whether or not this exit is an exit to a {@link Room} or not. (Will be
     * preset in the
     * {@link Exit#Exit(domain.locations.ExitDirection, domain.locations.Room) constructor})
     */
    private final boolean EXIT_TO_ROOM;

    /**
     * Whether or not this exit is an exit to a {@link Location} or not. (Will
     * be preset in the
     * {@link Exit#Exit(domain.locations.ExitDirection, domain.locations.Location, domain.locations.Room, domain.locations.Room) constructor})
     */
    private final boolean EXIT_TO_LOCATION;

    /**
     * What {@link Room} this exit i located in.
     */
    private Room fromRoom;

    /**
     * What {@link Room} this exit leads to.
     */
    private Room toRoom;

    /**
     * What {@link Location} this exit leads to. (Will only be possible if
     * {@link Exit#EXIT_TO_LOCATION} = true)
     */
    private Location toLocation;

    /**
     * The directions of the exit. (WEST, NORTH, EAST, SOUTH)
     * ({@link ExitDirection})
     */
    private ExitDirection direction;

    /**
     * Exit to another {@link Room}.
     *
     * @param direction Directions of the exit. {@link ExitDirection}
     * @param exit The room this exit leads to.
     */
    public Exit(ExitDirection direction, Room exit) {
        this.direction = direction;
        this.fromRoom = exit;
        this.EXIT_TO_ROOM = true;
        this.EXIT_TO_LOCATION = false;
    }

    /**
     * Exit to another {@link Location}.
     *
     * @param direction Direction of the exit. {@link ExitDirection}
     * @param toLocation The locations this exit leads to.
     * @param fromRoom The room this exit is located in.
     * @param toRoom The room this exit leads to.
     */
    public Exit(ExitDirection direction, Location toLocation, Room fromRoom, Room toRoom) {
        this.direction = direction;
        this.toLocation = toLocation;
        this.fromRoom = fromRoom;
        this.toRoom = toRoom;
        this.EXIT_TO_LOCATION = true;
        this.EXIT_TO_ROOM = false;
    }

    @Override
    public String toString() {
        if (EXIT_TO_ROOM) {
            return "locations.RoomExit : Exit[" + this.fromRoom.getName() + "] Direction[" + this.direction + "]";
        } else {
            return "locations.LocationExit : Exit[" + this.toLocation.getNAME() + "] Direction[" + this.direction + "] room[" + this.fromRoom.getName() + "]";
        }
    }

    /**
     * Get the room this exit is located in. {@link Exit#fromRoom}
     *
     * @return
     */
    public Room getFromRoom() {
        return this.fromRoom;
    }

    /**
     * Get the room this exit is leading to. {@link Exit#toRoom}
     *
     * @return
     */
    public Room getToRoom() {
        return this.toRoom;
    }

    /**
     * Get the location this exit leads to. {@link Exit#toLocation}
     *
     * @return
     */
    public Location getToLocation() {
        return this.toLocation;
    }

    /**
     * Get the direction of this exit. {@link Exit#direction}
     *
     * @return
     */
    public ExitDirection getDirection() {
        return this.direction;
    }

    /**
     * See whether or not this exit is to a {@link Location}.
     * {@link Exit#EXIT_TO_LOCATION}
     *
     * @return
     */
    public boolean isEXIT_TO_LOCATION() {
        return this.EXIT_TO_LOCATION;
    }

    /**
     * See whether or not this exit is to a {@link Room}.
     * {@link Exit#EXIT_TO_ROOM}
     *
     * @return
     */
    public boolean isEXIT_TO_ROOM() {
        return this.EXIT_TO_ROOM;
    }

}
