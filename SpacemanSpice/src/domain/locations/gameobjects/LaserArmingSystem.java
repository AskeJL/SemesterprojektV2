/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;

/**
 *
 * @author Lupo
 */
public class LaserArmingSystem extends GameObject {

    public LaserArmingSystem(){
        super("Laser arming system.", "The laser is armed from here.", GameObjectType.CONTROL, null);
    }
    @Override
    public void interact() {
        
    }
    
}
