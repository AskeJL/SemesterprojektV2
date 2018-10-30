package spacemanspice.locations;

import java.util.ArrayList;
import spacemanspice.locations.functional.*;
import spacemanspice.locations.nonfunctional.*;

/**
 *
 * @author sbang
 */
public class LocationsController {

    private final static ArrayList<Location> LOCATIONS = new ArrayList<>();
    
    public static void init() {
        createLocations();
    }

    private static void createLocations() {
        // Adding functional locations
        LOCATIONS.add(new Laser());
        LOCATIONS.add(new Control());
        
        // Adding non-functional locations
        LOCATIONS.add(new Hallway01());
    }
    
    public ArrayList<Location> getLocations() {
        return LocationsController.LOCATIONS;
    }
}
