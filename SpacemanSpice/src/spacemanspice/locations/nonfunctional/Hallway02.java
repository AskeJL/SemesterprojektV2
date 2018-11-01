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
public class Hallway02 extends Location {

    public Hallway02() {
        super("Hallway 02", "The hallway connecting airlock, oxygen and navigation");
        
        createLocation();
    }

    @Override
    public void createLocation() {
        /*The romm in the control location are created-----------------------*/
        
        /*Hallway 02------------------------------------------------------------*/
        Room hallway02 = new Room("Hallway 02","This hallway connects the airlock, navigation and oxygen");
       
        super.addRoom(hallway02);
        
        /*Setting entrance-----------------------------------------*/
        super.addEntrance(hallway02);
    }

    @Override
    public String toString() {
        return "locations.Room : Name[" + this.getName() + "] Description[" + this.getDescription() +" The exits are"+ this.getExits()+ "]";
    }
    
}
