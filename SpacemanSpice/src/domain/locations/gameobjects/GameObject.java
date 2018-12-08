package domain.locations.gameobjects;

/**
 * An object within the game that is interact-able. Either by directly using it,
 * or picking it up for later use. An example could be a chair or an air tank.
 * Different kinds of GameObjects can be found here: {@link GameObjectType}
 *
 * @see GameObjectType
 * @see domain.interactions.commands.Interact
 */
public abstract class GameObject {
    
    private final String name;
    
    protected GameObject(String name){
        this.name = name;
    }
    /**
     * Interact with the object. (Needs implementation from child)
     */
    public abstract void interact();

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
}
    