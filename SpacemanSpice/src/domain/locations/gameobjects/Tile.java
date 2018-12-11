/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;
import javafx.scene.image.Image;

/**
 *
 * @author Lupo
 */
public class Tile {
    
    private final char SYMBOL;
    
    private int TILE_POSITION_X_AXIS;
    private int TILE_POSITION_Y_AXIS;
    
    private final Boolean SOLID;
    private final GameObjectType GAME_OBJECT_TYPE;
    private final GameObject GAME_OBJECT;
    
    private final Image TILE_IMAGE;
    
    public Tile(char symbol, Boolean isSolid, GameObjectType type, GameObject gameObject, Image img){
        
        this.SYMBOL = symbol;
        this.SOLID = isSolid;
        this.GAME_OBJECT_TYPE = type;
        this.GAME_OBJECT = gameObject;
        this.TILE_IMAGE = img;
    }

    /**
     * @return the SYMBOL
     */
    public char getSYMBOL() {
        return SYMBOL;
    }

    /**
     * @return the TILE_POSITION_X_AXIS
     */
    public int getTILE_POSITION_X_AXIS() {
        return TILE_POSITION_X_AXIS;
    }

    /**
     * @param TILE_POSITION_X_AXIS the TILE_POSITION_X_AXIS to set
     */
    public void setTILE_POSITION_X_AXIS(int TILE_POSITION_X_AXIS) {
        this.TILE_POSITION_X_AXIS = TILE_POSITION_X_AXIS;
    }

    /**
     * @return the TILE_POSITION_Y_AXIS
     */
    public int getTILE_POSITION_Y_AXIS() {
        return TILE_POSITION_Y_AXIS;
    }

    /**
     * @param TILE_POSITION_Y_AXIS the TILE_POSITION_Y_AXIS to set
     */
    public void setTILE_POSITION_Y_AXIS(int TILE_POSITION_Y_AXIS) {
        this.TILE_POSITION_Y_AXIS = TILE_POSITION_Y_AXIS;
    }

    /**
     * @return the SOLID
     */
    public Boolean getSOLID() {
        return SOLID;
    }

    /**
     * @return the GAME_OBJECT_TYPE
     */
    public GameObjectType getGAME_OBJECT_TYPE() {
        return GAME_OBJECT_TYPE;
    }

    /**
     * @return the GAME_OBJECT
     */
    public GameObject getGAME_OBJECT() {
        return GAME_OBJECT;
    }

    /**
     * @return the TILE_IMAGE
     */
    public Image getTILE_IMAGE() {
        return TILE_IMAGE;
    }
}
