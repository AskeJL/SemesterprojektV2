package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsManager;
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
        reader.storeln("Interacting with laser control");
        systemsManager.setSmallFragmentDestroyed(true);
        
        //((TutorialManager)systemsManager.getManager(TutorialManager.class));
    }

    @Override
    public String toString() {
        return "GameObject.LaserControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
}
