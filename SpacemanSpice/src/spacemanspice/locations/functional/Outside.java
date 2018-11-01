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
public class Outside extends Location{

    public Outside() {
        super("Outside","This location contains the airlock and from here it is possible to go outside");
        
        createLocation();
    }

    @Override
    public void createLocation() {
         /*The romms in the control location are created-----------------------*/
        
        /*outside------------------------------------------------------------*/
        Room outside = new Room("Outside","You are now outside and here you can repair the ship");
        super.addRoom(outside);
        
        /*Airlock----------------------------------------------------------*/
        Room airlock = new Room("airlock","You are now in the airlock");
        super.addRoom(airlock);
        
        
        /*Setting exits and entrances-----------------------------------------*/
        super.addEntrance(airlock);
        
        outside.addExit(new Exit(ExitDirection.EAST,airlock));
        
        airlock.addExit(new Exit(ExitDirection.WEST,airlock));
    }

    @Override
    public String toString() {
        return "locations.Room : Name[" + this.getName() + "] Description[" + this.getDescription() + this.getExits()+ "]";
    }
    
    
}
