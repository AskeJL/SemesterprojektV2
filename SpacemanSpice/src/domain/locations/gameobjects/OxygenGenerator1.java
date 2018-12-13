/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.resources.Oxygen;
import domain.resources.ResourcesManager;

/**
 *
 * @author Lupo
 */
public class OxygenGenerator1 extends GameObject {

    private final ResourcesManager resourcesManager;
    private final DomainReader reader = new DomainReader();

    public OxygenGenerator1(ResourcesManager resources) {
        super("Oxygen generator.", "You can activate the oxygen generator from here.", GameObjectType.CONTROL, null);
        this.resourcesManager = resources;
    }

    @Override
    public void interact() {
        Oxygen oxygen = resourcesManager.getOxygen();
        if (oxygen.isOxygenGenerator1On() == false) {
            oxygen.setOxygenGenerator1On(true);
            reader.storeln("You have activated the first oxygen generator, activate all and head to the oxygen tank to refill your oxygen levels.");
        }
        else{
            reader.storeln("Generator is on and functioning.");
        }
        }

    }