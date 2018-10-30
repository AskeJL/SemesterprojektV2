/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacemanspice.locations;

import java.util.ArrayList;

/**
 *
 * @author sbang
 */
public class Room {
    private String name;
    private String description;
    private ArrayList<Exit> exits = new ArrayList<>();
    private ArrayList<GameObject> gameObjects = new ArrayList<>();
    private boolean hasOxygen;
    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public void addExit(Exit exit) {
        this.exits.add(exit);
    }
    
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
