/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.locations;

/**
 *
 * @author sbang
 */
public class Exit {
    private boolean exitToRoom;
    private boolean exitToLocation;
    private Room fromRoom;
    private Room toRoom;
    private Location toLocation;
    private ExitDirection direction;
    
    public Exit(ExitDirection d, Room exit){
        this.direction = d;
        this.fromRoom = exit;
        this.exitToRoom = true;
        this.exitToLocation = false;
    }
    
    public Exit(ExitDirection d, Location toLocation, Room fromRoom, Room toRoom){
        this.direction = d;
        this.toLocation = toLocation;
        this.fromRoom = fromRoom;
        this.toRoom = toRoom;
        this.exitToLocation = true;
        this.exitToRoom = false;
    }
    
    @Override
    public String toString() {
        if(exitToRoom) {
            return "locations.RoomExit : Exit[" + this.fromRoom.getName() + "] Direction[" + this.direction + "]";
        } else {
            return "locations.LocationExit : Exit[" + this.toLocation.getName() + "] Direction[" + this.direction + "] room[" + this.fromRoom.getName() + "]";
        }
    }
    
    public void setFromRoom(Room exit) {
        this.fromRoom = exit;
    }
    
    public void setToLocation(Location exit) {
        this.toLocation = exit;
    }
    
    public void setDirection(ExitDirection direction) {
        this.direction = direction;
    }
    
    public Room getFromRoom() {
        return this.fromRoom;
    }
    
    public Room getToRoom() {
        return this.toRoom;
    }
    
    public Location getToLocation() {
        return this.toLocation;
    }
    
    public ExitDirection getDirection() {
        return this.direction;
    }
    
    public boolean isExitToLocation() {
        return this.exitToLocation;
    }
    
    public boolean isExitToRoom() {
        return this.exitToRoom;
    }
    
}
