package domain.locations;

import domain.locations.gameobjects.GameObject;
import domain.locations.gameobjects.GameObjectType;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * A room within a location.
 * <br><br>
 * Primarily used within the {@link LocationsController#createLocations()}, as
 * it is only to be sat at the initialization of the game.
 */
public class Room {

    /**
     * The name of the room.
     */
    private final String NAME;

    /**
     * The description of the room.
     */
    private final String DESCRIPTION;

    private final Room NORTH_EXIT;
    private final Room WEST_EXIT;
    private final Room SOUTH_EXIT;
    private final Room EAST_EXIT;

    
    private final ArrayList<Exit> currentExits = new ArrayList<>();

    private final GameObjectType GAME_OBJECT_TYPE;
    private final GameObject gameObject;
    
    private final String TEXT_MAP_FILE_PATH;
    
    

    public Room(String name, String description, Room nExit, Room wExit, Room sExit, Room eExit, GameObjectType type, GameObject gameObject, String fileLocation) {

        this.NAME = name;
        this.DESCRIPTION = description;
        this.NORTH_EXIT = nExit;
        this.WEST_EXIT = wExit;
        this.SOUTH_EXIT = sExit;
        this.EAST_EXIT = eExit;
        this.GAME_OBJECT_TYPE = type;
        this.gameObject = gameObject;
        this.TEXT_MAP_FILE_PATH = fileLocation;
        
        init();
    }

    private void init() {
        if(NORTH_EXIT != null){
        this.currentExits.add(new Exit(this, this.NORTH_EXIT, ExitDirection.NORTH));
        }
        if(WEST_EXIT != null){
        this.currentExits.add(new Exit(this, this.WEST_EXIT, ExitDirection.WEST));
        }
        if(SOUTH_EXIT != null){
        this.currentExits.add(new Exit(this, this.SOUTH_EXIT, ExitDirection.SOUTH));
        }
        if(EAST_EXIT != null){
        this.currentExits.add(new Exit(this, this.EAST_EXIT, ExitDirection.EAST));
        }
        
    }

    /**
     * @return the currentExits
     */
    public ArrayList<Exit> getExits() {
        return currentExits;
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
    public Room getNORTH_EXIT() {
        return NORTH_EXIT;
    }

    /**
     * @return the WEST_EXIT
     */
    public Room getWEST_EXIT() {
        return WEST_EXIT;
    }

    /**
     * @return the SOUTH_EXIT
     */
    public Room getSOUTH_EXIT() {
        return SOUTH_EXIT;
    }

    /**
     * @return the EAST_EXIT
     */
    public Room getEAST_EXIT() {
        return EAST_EXIT;
    }

    /**
     * @return the GAME_OBJECT_TYPE
     */
    public GameObjectType getGAME_OBJECT_TYPE() {
        return GAME_OBJECT_TYPE;
    }

    /**
     * @return the TEXT_MAP_FILE_PATH
     */
    public String getTEXT_MAP_FILE_PATH() {
        return TEXT_MAP_FILE_PATH;
    }

    /**
     * @return the gameObject
     */
    public GameObject getGameObject() {
        return gameObject;
    }
}
