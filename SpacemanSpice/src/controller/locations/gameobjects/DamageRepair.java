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
public class DamageRepair extends GameObject {
    
    public DamageRepair(){
        super("Damage repair","Here you can repair some of the ships damage",GameObjectType.CONTROL);
    }

    @Override
    public void interact() {
        System.out.println("You begin reparing the ship");
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }
    
}
