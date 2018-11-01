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
public class Net extends Location {
    
    
    public Net() {
        super("Net", "In this location the net is controlled and repaired");
        
        createLocation();
    }
    @Override
    public void createLocation() {
        /*The romms in the control location are created-----------------------*/
        
        /*Corridor------------------------------------------------------------*/
        Room NetCorridor = new Room("Net corridor","This is the main corridor in the location");
        
        super.addRoom(NetCorridor);
        
        /*Net control---------------------------------------------------------*/
        Room NetRoom = new Room("net Room","Here you control the space net");
        
        super.addRoom(NetRoom);
        
        /*Netbay--------------------------------------------------------------*/
        Room NetBay = new Room("Net bay","Here you can fix your net");
        
        super.addRoom(NetBay);
        
        /*Setting exits and entrances-----------------------------------------*/
        super.addEntrance(NetCorridor);
        
        NetCorridor.addExit(new Exit(ExitDirection.EAST,NetRoom));
        NetCorridor.addExit(new Exit(ExitDirection.WEST,NetBay));
        
        NetRoom.addExit(new Exit(ExitDirection.WEST,NetCorridor));
        
        NetBay.addExit(new Exit(ExitDirection.EAST,NetCorridor));
        
       
        
    }

    @Override
    public String toString() {
        return "locations.Room : Name[" + this.getName() + "] Description[" + this.getDescription() + this.getExits()+ "]";
    }
    
}
