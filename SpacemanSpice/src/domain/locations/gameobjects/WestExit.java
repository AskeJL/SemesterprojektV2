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
public class WestExit extends GameObject{

    /**
     *
     */
    public WestExit(){
        super("West exit", "You can go west from here.", GameObjectType.WEST);
    }
    @Override
    public void interact() {
        //Go north from here.
    }
    
}
