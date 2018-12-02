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

    private String northExitString;
    private String westExitString;
    private String southExitString;
    private String eastExitString;
    
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
    public Location(String locationText, String nExit, String wExit, String sExit, String eExit, String fileLocation){
                
        this.locationDescription = locationText;
        
        this.textMapFileLocation = fileLocation;
        
        this.northExitString = nExit;
        this.westExitString = wExit;
        this.eastExitString = eExit;
        this.southExitString =sExit;
       
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
    public String getNorthExitString() {
        return northExitString;
    }

    /**
     * @return the westExitString
     */
    public String getWestExitString() {
        return westExitString;
    }

    /**
     * @return the southExitString
     */
    public String getSouthExitString() {
        return southExitString;
    }

    /**
     * @param southExitString the southExitString to set
     */
    public void setSouthExitString(String southExitString) {
        this.southExitString = southExitString;
    }

    /**
     * @return the eastExitString
     */
    public String getEastExitString() {
        return eastExitString;
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
