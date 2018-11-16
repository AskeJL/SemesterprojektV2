package domain.locations;

import java.util.ArrayList;

/**
 * This is used to group together a series of {@link Room}s, and is only created
 * once in the {@link LocationsController#createLocations()}.
 * <br><br>
 * Within the Location is the {@link Location#rooms rooms} and
 * {@link Location#exits exits} stored which are filled upon creation
 * ({@link #createLocation()}).
 */
public abstract class Location {

    /**
     * Name of the Location.
     */
    private String name;

    /**
     * Description of the location.
     */
    private String description;

    /**
     * The {@link Exit} references to other Locations are stored here.
     */
    private ArrayList<Exit> exits = new ArrayList<>();

    /**
     * The {@link Room}s associated with this location.
     */
    private ArrayList<Room> rooms = new ArrayList<>();

    protected Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Add an {@link Exit} to the location.
     *
     * @param exit The exit to add.
     */
    public void addExit(Exit exit) {
        this.exits.add(exit);
    }

    /**
     * Add a {@link Room} to the location.
     *
     * @param room The room to add.
     */
    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    /**
     * Create this explicit location. The {@link Location#rooms} are defined and
     * filled in here, as well as the {@link Location#exits}
     */
    protected abstract void createLocation();

    @Override
    public abstract String toString();

    /**
     * Set the {@link #description description} of this Location.
     *
     * @param description Description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the {@link #exits exits} to this location.
     *
     * @param exits Exits to set.
     */
    public void setExits(ArrayList<Exit> exits) {
        this.exits = exits;
    }

    /**
     * Set the {@link #rooms rooms} to this location.
     *
     * @param rooms Rooms to set.
     */
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * Get the {@link #name name} of this Location.
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the {@link #description description} of this Location.
     *
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get the {@link #exits exits} of this Location.
     *
     * @return
     */
    public ArrayList<Exit> getExits() {
        return this.exits;
    }

    /**
     * Get the {@link #rooms rooms} of this Location.
     *
     * @return
     */
    public ArrayList<Room> getRooms() {
        return this.rooms;
    }
}
