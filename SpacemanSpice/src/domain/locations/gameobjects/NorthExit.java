/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.ExitDirection;
import domain.locations.GameObject;
import domain.locations.GameObjectType;

/**
 *
 * @author Lupo
 */
public class NorthExit extends GameObject{

    private final DomainReader reader = new DomainReader();
    private final ExitDirection northExit = ExitDirection.NORTH;
    /**
     *
     */
    public NorthExit(){
        super("North exit", "You can go north from here.", GameObjectType.NORTH, ExitDirection.NORTH);
    }
    @Override
    public void interact() {
        reader.storeln("Interacting with north door.");
    }
    
}
