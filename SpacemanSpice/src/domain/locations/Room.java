package domain.locations;

import domain.locations.functional.Oxygen;
import java.util.ArrayList;

/**
 * A room within a location.
 * <br><br>
 * Primarily used within the {@link LocationsController#createLocations()}, as
 * it is only to be sat at the initialization of the game.
 */
public class Room {

    /**
     * The name of the room.
     */
    private String name;

    /**
     * The description of the room.
     */
    private String description;

    /**
     * All the {@link Exit}s within the room.
     */
    private ArrayList<Exit> exits = new ArrayList<>();

    /**
     * All the {@link GameObject}s within the room.
     */
    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    /**
     * Whether or not this room has {@link Oxygen}.
     */
    private boolean hasOxygen;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Add an {@link Exit} to the room.
     *
     * @param exit to add.
     */
    public void addExit(Exit exit) {
        this.exits.add(exit);
    }

    /**
     * Add a {@link GameObject} to the room.
     *
     * @param gameObject GameObject to add.
     */
    public void addGameObject(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    @Override
    public String toString() {
        return "locations.Room : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }

    /**
     * Get the {@link #name name} of this room.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get the {@link #description description} of this room.
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the {@link #exits exits} of this room.
     *
     * @return
     */
    public ArrayList<Exit> getExits() {
        return exits;
    }

    /**
     * Get one of the {@link #exits} in this room based on the direction.
     * (north, south, west, east)
     *
     * @param direction Direction of the {@link Exit}.
     * @return
     */
    public Exit getExit(String direction) {
        for (Exit exit : exits) {
            if (exit.getDirection().name().toLowerCase().equals(direction.toLowerCase())) {
                return exit;
            }
        }
        return null;
    }

    /**
     * Get the {@link #gameObjects gameObjects} of this room.
     *
     * @return
     */
    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    /**
     * Check to see if this room {@link #hasOxygen hasOxygen}.
     *
     * @return
     */
    public boolean isHasOxygen() {
        return hasOxygen;
    }

    /**
     * Set the {@link #name name} of this room.
     *
     * @param name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the {@link #description description} of this room.
     *
     * @param description Description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the {@link #exits exits} to this room.
     *
     * @param exits Exits to set.
     */
    public void setExits(ArrayList<Exit> exits) {
        this.exits = exits;
    }

    /**
     * Set the {@link #gameObjects gameObjects} for this room.
     *
     * @param gameObjects GameObjects to set.
     */
    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    /**
     * Set whether or not this room {@link #hasOxygen hasOxygen} in it.
     *
     * @param hasOxygen
     */
    public void setHasOxygen(boolean hasOxygen) {
        this.hasOxygen = hasOxygen;
    }
}
