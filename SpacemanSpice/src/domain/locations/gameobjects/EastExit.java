/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.GameObject;
import domain.locations.GameObjectType;

/**
 *
 * @author Lupo
 */
public class EastExit extends GameObject{

    private final DomainReader reader = new DomainReader();
    /**
     *
     */
    public EastExit(){
        super("East exit", "You can go east from here.", GameObjectType.EAST);
    }
    @Override
    public void interact() {
        reader.storeln("Interacting with east door.");
    }
    
}
