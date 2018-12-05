package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.resources.Oxygen;
import domain.resources.ResourcesManager;

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
    
    public OxygenControl(ResourcesManager resources) {
        super("Oxygen control", "This is the refilling station for oxygen", GameObjectType.CONTROL);  
        
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
        reader.storeln("You interact with the Oxygen refilling control");
        Oxygen oxygen = resourcesManager.getOxygen();
        oxygen.increaseValue(100 - oxygen.getValue());
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }

}
