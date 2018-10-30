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
        super("Outside","You are now outside the ship, here you can repair some off the damage it has taken");
        
        createLocation();
    }

    @Override
    public void createLocation() {
        
        // The outside location object is created here toogether with the airlock.
        Room outside = new Room("Outside","You are now outside");
        super.addRoom(outside);
        
        Room airlock = new Room("airlock","You are now in the airlock");
        super.addRoom(airlock);
        
        
        // Outside and airlock is given exits
        outside.addExit(new Exit(ExitDirection.EAST,airlock));
        
        airlock.addExit(new Exit(ExitDirection.WEST,airlock));
        airlock.addExit(new Exit(ExitDirection.NORTH,airlock));
        airlock.addExit(new Exit(ExitDirection.EAST,airlock));
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
