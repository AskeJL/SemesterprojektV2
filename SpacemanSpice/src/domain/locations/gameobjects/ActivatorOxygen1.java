package domain.locations.gameobjects;

import domain.DomainReader;
import domain.DomainRequester;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.resources.Oxygen;
import domain.resources.ResourcesManager;

/**
 * One of three activators for the {@link ControlOxygen}. This is paired with
 * the {@link ControlOxygen} and its main job is to help activate the
 * controller.
 * <p>
 * To activate it, the player simply has to interact with it. This will charge
 * the {@link ControlLaser}.
 *
 * @see ControlOxygen
 */
public class ActivatorOxygen1 extends GameObject {

    private final ResourcesManager resourcesManager;
    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();

    public ActivatorOxygen1(ResourcesManager resources) {
        super("Oxygen generator.", "You can activate the oxygen generator from here.", GameObjectType.CONTROL, null);
        this.resourcesManager = resources;
    }

    /**
     * Upon interaction, this activator activate one of three oxygen generator.
     * Nothing will happen until all the generators are turned on.
     */
    @Override
    public void interact() {
        Oxygen oxygen = resourcesManager.getOxygen();
        requester.requestConsoleSound();
        if (oxygen.isOxygenGenerator1On() == false) {
            oxygen.setOxygenGenerator1On(true);
            reader.storeln("You have activated the first oxygen generator, activate all and head to the oxygen tank to refill your oxygen levels.");
        } else {
            reader.storeln("Generator is on and functioning.");
        }
    }
}
