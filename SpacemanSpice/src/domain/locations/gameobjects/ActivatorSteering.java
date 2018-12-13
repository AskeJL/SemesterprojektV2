package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;

/**
 * An activator for the {@link ConstrolSteering}. This is paired with the
 * {@link ConstrolSteering} and its main job is to activate the controller.
 * <p>
 * To activate it, the player simply has to interact with it. This will charge
 * the {@link ConstrolSteering}.
 *
 * @see ConstrolSteering
 */
public class ActivatorSteering extends GameObject{

    public ActivatorSteering(){
        super("Steering overcharge.", "You can overcharge the thrusters here.", GameObjectType.CONTROL, null);
    }
    
    /**
     * Upon interaction, nothing happens...
     */
    @Override
    public void interact() {
        
    }
}
