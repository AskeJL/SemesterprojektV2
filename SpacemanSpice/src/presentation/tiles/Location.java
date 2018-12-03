package presentation.tiles;

/**
 * 
 * TileMap class
 * This class is used to setup a location and its parameters
 */
public class Location {

    private final int TILE_SIZE = 32;
    private final int NUMBER_OF_TILES_X_AXIS = 28;
    private final int NUMBER_OF_TILES_Y_AXIS = 16;

    private String locationDescription;

    private DirectionCollection northExit;
    private DirectionCollection westExit;
    private DirectionCollection southExit;
    private DirectionCollection eastExit;
    
    private String textMapFileLocation;

    /**
     * Location constructor
     * @param locationText
     * @param nExit
     * @param wExit
     * @param sExit
     * @param eExit
     * @param fileLocation 
     */
    public Location(String locationText, DirectionCollection nExit, DirectionCollection wExit, DirectionCollection sExit, DirectionCollection eExit, String fileLocation){
                
        this.locationDescription = locationText;
        
        this.textMapFileLocation = fileLocation;
        
        this.northExit = nExit;
        this.westExit = wExit;
        this.eastExit = eExit;
        this.southExit =sExit;
       
    } 

    /**
     * @return the TILE_SIZE
     */
    public int getTILE_SIZE() {
        return TILE_SIZE;
    }

    /**
     * @return the NUMBER_OF_TILES_X_AXIS
     */
    public int getNUMBER_OF_TILES_X_AXIS() {
        return NUMBER_OF_TILES_X_AXIS;
    }

    /**
     * @return the NUMBER_OF_TILES_Y_AXIS
     */
    public int getNUMBER_OF_TILES_Y_AXIS() {
        return NUMBER_OF_TILES_Y_AXIS;
    }

    /**
     * @return the currentMapLocation
     */
    public String getLocationDescription() {
        return locationDescription;
    }

    /**
     * @return the northExitString
     */
    public DirectionCollection getNorthExit() {
        return northExit;
    }

    /**
     * @return the westExitString
     */
    public DirectionCollection getWestExit() {
        return westExit;
    }

    /**
     * @return the southExitString
     */
    public DirectionCollection getSouthExit() {
        return southExit;
    }

    /**
     * @return the eastExitString
     */
    public DirectionCollection getEastExit() {
        return eastExit;
    }
    

    /**
     * @return the textMapFileLocation
     */
    public String getTextMapFileLocation() {
        return textMapFileLocation;
    }

    /**
     * @param textMapFileLocation the textMapFileLocation to set
     */
    public void setTextMapFileLocation(String textMapFileLocation) {
        this.textMapFileLocation = textMapFileLocation;
    }
}
