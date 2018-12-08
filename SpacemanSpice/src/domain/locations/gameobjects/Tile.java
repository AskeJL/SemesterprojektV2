/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.locations.gameobjects;

import javafx.scene.image.Image;

/**
 *
 * @author Lupo
 */
public class Tile {
    
    private final String name;
    private final char SYMBOL;
    
    private final int TILE_SIZE = 32;
    
    private int positionXAXis;
    private int positionYAxis;
    
    private final String description;
    private final GameObjectType gameObjectType;
    
    private final Boolean isSolid;
    private final GameObject gameObject;
    
    private final Image tileImage;
    
    public Tile(String name, char symbol, String description, GameObjectType type, Boolean solid, GameObject gameObject, String imagePath){
        
        this.name = name;
        this.SYMBOL = symbol;
        
        this.description = description;
        this.gameObjectType = type;
        this.isSolid = solid;
        this.gameObject = gameObject;
        
        this.tileImage = new Image(getClass().getResourceAsStream(imagePath));
        
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the SYMBOL
     */
    public char getSYMBOL() {
        return SYMBOL;
    }

    /**
     * @return the TILE_SIZE
     */
    public int getTILE_SIZE() {
        return TILE_SIZE;
    }

    /**
     * @return the positionXAXis
     */
    public int getPositionXAXis() {
        return positionXAXis;
    }

    /**
     * @return the positionYAxis
     */
    public int getPositionYAxis() {
        return positionYAxis;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the gameObjectType
     */
    public GameObjectType getGameObjectType() {
        return gameObjectType;
    }

    /**
     * @return the isSolid
     */
    public Boolean getIsSolid() {
        return isSolid;
    }

    /**
     * @return the tileImage
     */
    public Image getTileImage() {
        return tileImage;
    }

    /**
     * @return the gameObject
     */
    public GameObject getGameObject() {
        return gameObject;
    }

    
    
}
