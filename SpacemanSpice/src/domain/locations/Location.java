package domain.locations;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is used to group together a series of {@link Room}s, and is only created
 * once in the {@link LocationsController#createLocations()}.
 * <br><br>
 * Within the Location is the {@link Location#rooms rooms} and
 * {@link Location#exits exits} stored which are filled upon creation
 * ({@link #createLocation()}).
 */
public class Location {
    
    /**
     * Name of the Location.
     */
    private final String NAME;

    /**
     * Description of the location.
     */
    private final String DESCRIPTION;

    private final Exit NORTH_EXIT;
    private final Exit WEST_EXIT;
    private final Exit SOUTH_EXIT;
    private final Exit EAST_EXIT;
    
    private final HashMap<String,String> EXITS = new HashMap<>();
    
    private final String TEXT_MAP_FILE_PATH;
    
    public Location(String name, String description, Exit nExit, Exit wExit, Exit sExit, Exit eExit, String fileLocation){
        
        this.NAME = name;
        this.DESCRIPTION = description;
        this.NORTH_EXIT = nExit;
        this.WEST_EXIT = wExit;
        this.SOUTH_EXIT = sExit;
        this.EAST_EXIT = eExit;
        this.TEXT_MAP_FILE_PATH = fileLocation;
    }

    private void init() {

        this.EXITS.put("North ", this.NORTH_EXIT.getToLocation().getNAME());
        this.EXITS.put("West ", this.WEST_EXIT.getToLocation().getNAME());
        this.EXITS.put("South ", this.SOUTH_EXIT.getToLocation().getNAME());
        this.EXITS.put("East ", this.EAST_EXIT.getToLocation().getNAME());
    }

    public HashMap getEXITS() {
        return EXITS;
    }
    /**
     * @return the NAME
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * @return the DESCRIPTION
     */
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    /**
     * @return the NORTH_EXIT
     */
    public Exit getNORTH_EXIT() {
        return NORTH_EXIT;
    }

    /**
     * @return the WEST_EXIT
     */
    public Exit getWEST_EXIT() {
        return WEST_EXIT;
    }

    /**
     * @return the SOUTH_EXIT
     */
    public Exit getSOUTH_EXIT() {
        return SOUTH_EXIT;
    }

    /**
     * @return the EAST_EXIT
     */
    public Exit getEAST_EXIT() {
        return EAST_EXIT;
    }

    /**
     * @return the TEXT_MAP_FILE_PATH
     */
    public String getTEXT_MAP_FILE_PATH() {
        return TEXT_MAP_FILE_PATH;
    }
}
