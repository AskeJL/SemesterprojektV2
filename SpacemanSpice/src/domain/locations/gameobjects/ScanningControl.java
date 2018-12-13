package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsManager;
import domain.tutorial.TutorialManager;

/**
 * Used to scan the vicinity of the ship for fragments.
 * <p>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Scanning
 */
public class ScanningControl extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();
    
    public ScanningControl(SystemsManager systems) {
        super("Scanning control", "This is the scanningstation", GameObjectType.CONTROL, null);
        
        this.systemsManager = systems;
    }

    /**
     * Inform the player about the current amount of fragments. (small, medium
     * and large)
     *
     * @see domain.systems.Wave
     * @see domain.systems.SystemsController
     */
    @Override
    public void interact() {
        reader.storeln("You interact with the scanning station.");
        reader.storeln("You interact with the scanningstation\nThere are:\n"
                + "    " + systemsManager.getWave().getSmallFragments() + " small fragments.\n"
                + "    " + systemsManager.getWave().getMediumFragments() + " medium fragments.\n"
                + "    " + systemsManager.getWave().getLargeFragments() + " large fragments.\n");
        
        if(((TutorialManager)systemsManager.getManager(TutorialManager.class)).getTutorial() == true) {
            ((TutorialManager)systemsManager.getManager(TutorialManager.class)).setScannerActivated(true);
        }
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }
}
