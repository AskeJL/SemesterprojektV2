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
public class ExitWest extends GameObject{

    private final DomainReader reader = new DomainReader();
    /**
     *
     */
    public ExitWest(){
        super("West exit", "You can go west from here.", GameObjectType.WEST, ExitDirection.WEST);
    }
    @Override
    public void interact() {
        reader.storeln("Interacting with west door.");
    }
    
}
