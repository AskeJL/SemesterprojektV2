package domain.locations.gameobjects;

import domain.DomainReader;
import domain.DomainRequester;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsManager;
import domain.systems.Wave;

/**
 * An activator for the {@link ControlLaser}. This is paired with the
 * {@link ControlLaser} and its main job is to activate the controller.
 * <p>
 * To activate it, the player simply has to interact with it. This will charge
 * the {@link ControlLaser}.
 *
 * @see ControlLaser
 */
public class ActivatorLaser extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();

    public ActivatorLaser(SystemsManager systems) {
        super("Laser arming system.", "The laser is armed from here.", GameObjectType.CONTROL, null);
        this.systemsManager = systems;
    }

    /**
     * Upon interaction, this activator will grant the player 3 shots to the
     * laser - if not already charged.
     */
    @Override
    public void interact() {
        Wave wave = systemsManager.getWave();

        if (wave.getAmountOfLaserShots() < 3) {
            requester.requestLaserChargeSound();
            wave.setAmountOfLaserShots(wave.getMAX_AMOUNT_OF_LASER_SHOTS());
            reader.storeln("Laser has now enough power for 3 shots.");
        } else {
            reader.storeln("Laser is fully charged!");
        }
    }

}
