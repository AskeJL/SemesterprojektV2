package domain.locations.gameobjects;

import domain.DomainReader;
import domain.DomainRequester;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsManager;
import domain.systems.Wave;
import domain.tutorial.TutorialManager;

/**
 * Used to destroy small fragments.
 * <p>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Laser
 */
public class LaserControl extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();
    
    public LaserControl(SystemsManager systems) {
        super("Laser Control", "The laser is operated from here.", GameObjectType.CONTROL, null);

        this.systemsManager = systems;
    }

    /**
     * Destroy a small fragment. This will set the
     * {@link domain.systems.SystemsController#setSmallFragmentDestroyed(boolean)}
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
        if (wave.getAmountOfLaserShots() > 0) {
            wave.setAmountOfLaserShots(wave.getAmountOfLaserShots()-1);
            reader.storeln("Interacting with laser control");
            systemsManager.setSmallFragmentDestroyed(true);
        } else {
            reader.storeln("The laser needs to be recharged in order to fire again.");
        }
        requester.playConsoleSound();
        
        if(((TutorialManager)systemsManager.getManager(TutorialManager.class)).getTutorial() == true) {
            ((TutorialManager)systemsManager.getManager(TutorialManager.class)).setLaserActivated(true);
        }
    }

    @Override
    public String toString() {
        return "GameObject.LaserControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
}
