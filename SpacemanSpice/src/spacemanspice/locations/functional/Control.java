/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacemanspice.locations.functional;

import spacemanspice.locations.Exit;
import spacemanspice.locations.ExitDirection;
import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

/**
 *
 * @author sbang
 */
public class Control extends Location {

    public Control() {
        super("Control", "The ship is navigated from here.");
        
        createLocation();
    }

    @Override
    public void createLocation() {
        /*Steering------------------------------------------------------------*/
        Room steeringRoom = new Room("Control Steering", "The ship is controlled from here.");
        
        super.addRoom(steeringRoom);
        
        /*Navigation----------------------------------------------------------*/
        Room navigationRoom = new Room("Control Navigation", "The ships current position is stored here.");
        
        super.addRoom(navigationRoom);
        
        /*Control-------------------------------------------------------------*/
        Room controlRoom = new Room("Control Observation", "It is from here, all outside oberservations can be made.");
        
        super.addRoom(controlRoom);
        
        /*Setting exits-------------------------------------------------------*/
        controlRoom.addExit(new Exit(ExitDirection.NORTH, steeringRoom));
        controlRoom.addExit(new Exit(ExitDirection.WEST, navigationRoom));
        
        navigationRoom.addExit(new Exit(ExitDirection.EAST, controlRoom));
        steeringRoom.addExit(new Exit(ExitDirection.SOUTH, controlRoom));
    }

    @Override
    public String toString() {
        return "locations.functional.Control : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
    
}
