/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsManager;
import domain.systems.Wave;

/**
 *
 * @author Lupo
 */
public class ActivatorSteering extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader  reader = new DomainReader();
    
    public ActivatorSteering(SystemsManager systems) {
        super("Steering activator", "Overcharges the ships reactor to fly away in high speed.", GameObjectType.CONTROL, null);
        this.systemsManager = systems;
    }

    @Override
    public void interact() {
        
        Wave wave = systemsManager.getWave();
        
        if(wave.isThrustersOn() == false){
            wave.setThrustersOn(true);
            reader.storeln("Reactor is overcharged! You can use the thrusters to fly away now!");
        }
        else{
            reader.storeln("Reactor is already overcharged");
        }
    }
}
       
    


