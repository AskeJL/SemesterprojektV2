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
public class ActivatorSteering extends GameObject{

    public ActivatorSteering(){
        super("Steering overcharge.", "You can overcharge the thrusters here.", GameObjectType.CONTROL, null);
    }
    
    @Override
    public void interact() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
