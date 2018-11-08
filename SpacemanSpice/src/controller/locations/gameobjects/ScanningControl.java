/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.locations.gameobjects;

import controller.locations.GameObject;
import controller.locations.GameObjectType;

/**
 *
 * @author askel
 */
public class ScanningControl extends GameObject {
    
    public ScanningControl(){
        super("Scanning control","This is the scanningstation",GameObjectType.CONTROL);
    }

    @Override
    public void interact() {
        System.out.println("You interact with the scanningstation");
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }
    
}