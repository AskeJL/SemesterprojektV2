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
public class ActivatorLaser extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();

    public ActivatorLaser(SystemsManager systems) {
        super("Laser arming system.", "The laser is armed from here.", GameObjectType.CONTROL, null);
        this.systemsManager = systems;
    }

    @Override
    public void interact() {
        Wave wave = systemsManager.getWave();

        if (wave.getAmountOfLaserShots() < 3) {
            wave.setAmountOfLaserShots(wave.getMAX_AMOUNT_OF_LASER_SHOTS());
            reader.storeln("Laser has now enough power for 3 shots.");
        } else {
            reader.storeln("Laser is fully charged!");
        }
    }

}
