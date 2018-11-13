/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.resources.ResourcesController;

/**
 * Oxygen control game object
 */
public class OxygenControl extends GameObject {
    
    public OxygenControl(){
        super("Oxygen control","This is the refilling station for oxygen",GameObjectType.CONTROL);
    }

    @Override
    public void interact() {
        System.out.println("You interact with the Oxygen refilling control");
        int difference;
        difference = 100 - ResourcesController.getOxygen();
        ResourcesController.increaseOxygen(difference);
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }
    
}
