package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsManager;
import domain.systems.Wave;
import domain.tutorial.TutorialManager;

/**
 * An activator for the {@link ConstrolSteering}. This is paired with the
 * <p>
 * {@link ConstrolSteering} and its main job is to activate the controller.
 * To activate it, the player simply has to interact with it. This will charge
 * the {@link ConstrolSteering}.
 *
 * @see ConstrolSteering
 */
public class ActivatorSteering extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader  reader = new DomainReader();
    
    public ActivatorSteering(SystemsManager systems) {
        super("Steering activator", "Overcharges the ships reactor to fly away in high speed.", GameObjectType.CONTROL, null);
        this.systemsManager = systems;
    }

    @Override
    public void interact() {
        
        Wave wave = systemsManager.getWave();
        
        if(wave.isThrustersOn() == false){
            wave.setThrustersOn(true);
            reader.storeln("Reactor is overcharged! You can use the thrusters to fly away now!");
        }
        if(((TutorialManager)systemsManager.getManager(TutorialManager.class)).getTutorial() == true) {
            systemsManager.setLargeFragmentDestroyed(true);
            ((TutorialManager)systemsManager.getManager(TutorialManager.class)).setSteeringCharged(true);
        }
        else{
            reader.storeln("Reactor is already overcharged");
        }
    }
}
       
    


