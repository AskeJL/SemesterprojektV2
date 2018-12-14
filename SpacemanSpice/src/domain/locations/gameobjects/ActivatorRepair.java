package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsManager;
import domain.systems.Wave;

/**
 * An activator for the {@link ControlRepair}. This is paired with the
 * {@link ControlRepair} and its main job is to activate the controller.
 * <p>
 * To activate it, the player simply has to interact with it. This will charge
 * the {@link ControlRepair}.
 *
 * @see ControlRepair
 */
public class ActivatorRepair extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();

    public ActivatorRepair(SystemsManager systems) {
        super("Net repair.", "You can repair your net here.", GameObjectType.CONTROL, null);
        this.systemsManager = systems;
    }

    /**
     * Upon interaction this will restore 10% health to the net if the net is
     * damaged.
     */
    @Override
    public void interact() {
        Wave wave = systemsManager.getWave();
        if (wave.getNetCurrentHealth() == wave.getNET_MAX_HEALTH()) {
            reader.storeln("Net has been repaired fully!");
        } else {
            wave.setNetCurrentHealth(wave.getNetCurrentHealth() + 10);
            reader.storeln("Net has been repaired, now at: " + wave.getNetCurrentHealth() + "% health");
        }
    }
}
