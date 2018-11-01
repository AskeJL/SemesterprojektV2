/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacemanspice.locations.nonfunctional;

import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

/**
 *
 * @author sbang
 */
public class Hallway01 extends Location {

    public Hallway01() {
        super("Hallway01", "Hallway connecting Personal, Laser and Net");
        
        createLocation();
    }

    @Override
    public void createLocation() {
        /*The romms in the control location are created-----------------------*/
        
        /*Hallway-------------------------------------------------------------*/
        Room hallway = new Room("Hallway", "This hallway connects the Personal, Laser and Net");
        
        super.addRoom(hallway);
        
        /*Setting entrance----------------------------------------------------*/
        super.addEntrance(hallway);
    }

    @Override
    public String toString() {
        return "locations.functional.Control : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
    
}
