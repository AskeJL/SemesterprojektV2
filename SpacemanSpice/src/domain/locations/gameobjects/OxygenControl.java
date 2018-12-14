package domain.locations.gameobjects;

import domain.DomainReader;
import domain.DomainRequester;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.resources.Oxygen;
import domain.resources.ResourcesManager;
import domain.tutorial.TutorialManager;

/**
 * Used to fill up the players oxygen.
 * <br><br>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Oxygen
 */
public class OxygenControl extends GameObject {

    private final ResourcesManager resourcesManager;
    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();
    
    public OxygenControl(ResourcesManager resources) {
        super("Oxygen control", "This is the refilling station for oxygen", GameObjectType.CONTROL, null);
        this.resourcesManager = resources;
    }

    /**
     * Refills the players {@link domain.resources.Oxygen}. This will call the
     * {@link ResourcesController#increaseOxygen(int)}
     * <p>
     * This will always fill the {@link domain.resources.Oxygen} completely.
     *
     * @see domain.resources.Oxygen
     * @see domain.resources.ResourcesController
     */
    @Override
    public void interact() {
        Oxygen oxygen = resourcesManager.getOxygen();
        if(oxygen.isOxygenGenerator1On() && oxygen.isOxygenGenerator2On() && oxygen.isOxygenGenerator3On() == true){
            requester.requestAirSound();
            reader.storeln("You interact with the Oxygen refilling control");
            oxygen.increaseValue(100 - oxygen.getValue());
            oxygen.setOxygenGenerator1On(false);
            oxygen.setOxygenGenerator2On(false);
            oxygen.setOxygenGenerator3On(false);
            if(((TutorialManager)resourcesManager.getManager(TutorialManager.class)).getTutorial() == true) {
                ((TutorialManager)resourcesManager.getManager(TutorialManager.class)).setOxygenActivated(true);
                ((TutorialManager)resourcesManager.getManager(TutorialManager.class)).setOxygenCharged(true);
            }
        }
        else{
            reader.storeln("The oxygen tank is empty, activate all of the oxygen generators to fill up the tank!");
            if(((TutorialManager)resourcesManager.getManager(TutorialManager.class)).getTutorial() == true) {
                ((TutorialManager)resourcesManager.getManager(TutorialManager.class)).setOxygenActivated(true);
            }
        }
        
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }

}
