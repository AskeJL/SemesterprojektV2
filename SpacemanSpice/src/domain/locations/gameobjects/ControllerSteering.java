package domain.locations.gameobjects;

import domain.DomainReader;
import domain.DomainRequester;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsManager;
import domain.systems.Wave;

/**
 * Used to dodge large fragments.
 * <p>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Laser
 */
public class ControllerSteering extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();
    
    public ControllerSteering(SystemsManager systems) {
        super("Steering Control", "The ship is flown from here.", GameObjectType.CONTROL, null);
        
        this.systemsManager = systems;
    }

    /**
     * Destroy a large fragment. This will set the
     * {@link domain.systems.SystemsController#setLargeFragmentDestroyed(boolean)}
     * boolean.
     * <p>
     * Only runs if there are any small fragments to destroy.
     *
     * @see domain.systems.Wave
     * @see domain.systems.SystemsController
     */
    @Override
    public void interact() {
        Wave wave = systemsManager.getWave();
        if(wave.isThrustersOn() == true){
        reader.storeln("Interacting with the steering controls.");
        if (systemsManager.getWave().getLargeFragments() != 0) {
            systemsManager.setLargeFragmentDestroyed(true);
            requester.requestMoveSound();
            reader.storeln("You have moved the ship out of danger.");
        }
        }
        else {
            reader.storeln("You don't have enough power to move the ship!");
        }
    }

    @Override
    public String toString() {
        return "GameObject.SteeringControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
}
