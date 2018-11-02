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
    private Room roomExit;
    private Location locationExit;
    private ExitDirection direction;
    
    public Exit(ExitDirection d, Room exit){
        this.direction = d;
        this.roomExit = exit;
        this.exitToRoom = true;
    }
    
    public Exit(ExitDirection d, Location exit, Room entrance){
        this.direction = d;
        this.roomExit = entrance;
        this.locationExit = exit;
        this.exitToLocation = true;
    }
    
    @Override
    public String toString() {
        if(exitToRoom) {
            return "locations.Exit : Exit[" + this.roomExit.getName() + "] Direction[" + this.direction + "]";
        } else {
            return "locations.Exit : Exit[" + this.locationExit.getName() + "] Direction[" + this.direction + "]";
        }
    }
    
    public void setRoomExit(Room exit) {
        this.roomExit = exit;
    }
    
    public void setLocationExit(Location exit) {
        this.locationExit = exit;
    }
    
    public void setDirection(ExitDirection direction) {
        this.direction = direction;
    }
    
    public Room getRoomExit() {
        return this.roomExit;
    }
    
    public Location getLocationExit() {
        return this.locationExit;
    }
    
    public ExitDirection getDirection() {
        return this.direction;
    }
    
}
