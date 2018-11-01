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
public abstract class Location {

    private String name;
    private String description;
    private ArrayList<Exit> exits = new ArrayList<>();
    private ArrayList<Room> entrances = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Add an exit to the location.
     *
     * @param exit to add.
     */
    public void addExit(Exit exit) {
        this.exits.add(exit);
    }

    /**
     * Add an entrance to the location.
     *
     * @param room to add as entrance.
     */
    public void addEntrance(Room room) {
        this.rooms.add(room);
    }

    /**
     * Add a room to the location.
     *
     * @param room to add.
     */
    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    /**
     * Create the explicit location.
     */
    protected abstract void createLocation();

    @Override
    public abstract String toString();

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExits(ArrayList<Exit> exits) {
        this.exits = exits;
    }

    public void setEntrances(ArrayList<Room> entrances) {
        this.entrances = entrances;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<Exit> getExits() {
        return this.exits;
    }

    public ArrayList<Room> getEntrances() {
        return this.entrances;
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }
}
