/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacemanspice.locations;

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
    
    public Exit(ExitDirection d, Location exit){
        this.direction = d;
        this.locationExit = exit;
        this.exitToLocation = true;
    }
    
}
