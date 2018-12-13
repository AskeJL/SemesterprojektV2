package domain.locations.gameobjects;

import domain.DomainReader;
import domain.DomainRequester;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsManager;
import domain.systems.Wave;

/**
 * Used to catch medium fragments.
 * <p>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Net
 */
public class ControlNet extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();
    
    public ControlNet(SystemsManager systems) {
        super("Net Control", "The net is controlled from here.", GameObjectType.CONTROL, null);
        
        this.systemsManager = systems;
    }

    /**
     * Catch a medium fragment. This will set the
     * {@link domain.systems.SystemsController#setMediumFragmentDestroyed(boolean)}
     * boolean.
     * <p>
     * Only runs if there are any medium fragments to destroy.
     *
     * @see domain.systems.Wave
     * @see domain.systems.SystemsController
     */
    @Override
    public void interact() {
        Wave wave = systemsManager.getWave();
        if(wave.getNetCurrentHealth() > 0){
        requester.playConsoleSound();
        reader.storeln("Interacting with net control.");
        systemsManager.setMediumFragmentDestroyed(true);
        wave.setNetCurrentHealth(wave.getNetCurrentHealth()-10);
        }
        else{
            reader.storeln("Net is too damaged, repair it in order to keep using it!");
        }
        }

    @Override
    public String toString() {
        return "GameObject.NetControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }

}
