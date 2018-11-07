package controller.locations;

import java.util.ArrayList;

/**
 * A room within a location. This needs to be within a location. Primarily used
 * within the Locations.createLocation(), as it is only to be sat at the
 * initialization of the game.
 */
public class Room {

    private String name;
    private String description;
    private ArrayList<Exit> exits = new ArrayList<>();
    private ArrayList<GameObject> gameObjects = new ArrayList<>();
    private boolean hasOxygen;

    /**
     * Room with a name and a description.
     *
     * @param name of the room.
     * @param description of the room.
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Add an exit to the room.
     *
     * @param exit to add.
     */
    public void addExit(Exit exit) {
        this.exits.add(exit);
    }

    /**
     * Add a GameObject to the room.
     * @param o GameObject to add.
     */
    public void addGameObject(GameObject o) {
        this.gameObjects.add(o);
    }

    @Override
    public String toString() {
        return "locations.Room : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Exit> getExits() {
        return exits;
    }
    
    public Exit getExit(String direction) {
        for(Exit exit : exits) {
            if(exit.getDirection().name().toLowerCase().equals(direction.toLowerCase())) {
                return exit;
            }
        }
        return null;
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public boolean isHasOxygen() {
        return hasOxygen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExits(ArrayList<Exit> exits) {
        this.exits = exits;
    }
    
    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void setHasOxygen(boolean hasOxygen) {
        this.hasOxygen = hasOxygen;
    }
}
