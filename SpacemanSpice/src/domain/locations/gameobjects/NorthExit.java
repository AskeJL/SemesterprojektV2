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
public class NorthExit extends GameObject{

    /**
     *
     */
    public NorthExit(){
        super("North exit", "You can go north from here.", GameObjectType.NORTH);
    }
    @Override
    public void interact() {
        //Go north from here.
    }
    
}
