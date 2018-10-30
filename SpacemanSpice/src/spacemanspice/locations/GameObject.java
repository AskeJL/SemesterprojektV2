/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacemanspice.locations;

/**
 *
 * @author sbang
 */
public class GameObject {
    private String name;
    private String description;
    private GameObjectType type;
    
    public GameObject(String name, String description, GameObjectType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }
    
    public void interact() {
        System.out.println("Not yet implemented.");
    }
    
    @Override
    public String toString() {
        return "locations.GameObject : Name[" + this.name + "] Description[" + this.description + "]";
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setType(GameObjectType type) {
        this.type = type;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public GameObjectType getType() {
        return this.type;
    }
}
