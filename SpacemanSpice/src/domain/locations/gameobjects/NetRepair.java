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
import domain.tutorial.TutorialManager;

/**
 *
 * @author Lupo
 */
public class NetRepair extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();
    
    public NetRepair(SystemsManager systems){
        super("Net repair.", "You can repair your net here.", GameObjectType.CONTROL, null);
        this.systemsManager = systems;
    }
    @Override
    public void interact() {
        Wave wave = systemsManager.getWave();
        if(wave.getNetCurrentHealth() == wave.getNET_MAX_HEALTH()){
            reader.storeln("Net has been repaired fully!");
        }
        else{
            wave.setNetCurrentHealth(wave.getNetCurrentHealth() + 10);
            reader.storeln("Net has been repaired, now at: " + wave.getNetCurrentHealth() + "% health");
        }
        if(((TutorialManager)systemsManager.getManager(TutorialManager.class)).getTutorial() == true) {
            ((TutorialManager)systemsManager.getManager(TutorialManager.class)).setNetRepaired(true);
        }
    }
    
}
