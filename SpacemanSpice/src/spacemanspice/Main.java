package spacemanspice;

import spacemanspice.locations.Location;
import spacemanspice.locations.LocationsController;

/**
 *
 * @author sbang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new Game().play();
        
        
        LocationsController.init();
        
        // Testing all the main room exits.
        for(Location location : LocationsController.getLocations()) {
            System.out.println(location.getName() + " : " + location.getRooms().get(0).getExits());
        }
        
        // Testing all the locations exits.
        for(Location location : LocationsController.getLocations()) {
            System.out.println(location.getName() + " : " + location.getExits());
        }
    }
}
