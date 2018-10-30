/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacemanspice.locations.functional;

import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

/**
 *
 * @author sbang
 */
public class Net extends Location {
    
    
    public Net() {
        super("This it the net location", "In this room you can control the net and catch debree");
        
        createLocation();
    }
    @Override
    public void createLocation() {
        
        Room NetCorridor = new Room("Net corridor","You are now in the net corridor");
        super.addRoom(NetCorridor);
        
        Room NetRoom = new Room("net Room","Here you control the space net");
        super.addRoom(NetRoom);
        
        Room NetBay = new Room("Net bay","Here you can fix your net");
        super.addRoom(NetBay);
       
        
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
