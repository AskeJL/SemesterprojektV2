/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.locations.gameobjects;

import domain.DomainReader;
import domain.DomainRequester;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsManager;
import domain.systems.Wave;

/**
 *
 * @author Lupo
 */
public class ActivatorScanning4 extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();

    public ActivatorScanning4(SystemsManager systems) {
        super("Scanning activator 4", "Calibrates the ships sensors in order to scan for fragments.", GameObjectType.CONTROL, null);
        this.systemsManager = systems;
    }

    @Override
    public void interact() {
        Wave wave = systemsManager.getWave();
        requester.requestActivatorConsoleSound();
        wave.setSensor4currentValue(wave.getSensor1currentValue() > wave.getNumberOfWaves() + 2 ? 1 : wave.getSensor4currentValue() + 1);
        reader.storeln("Sensor 4 is being calibrated, progress at: " + wave.getSensor4currentValue());
    }
}
