package domain.locations;

/**
 * An object within the game that is interact-able. Either by directly using it,
 * or picking it up for later use. An example could be a chair or an air tank.
 * Different kinds of GameObjects can be found here: {@link GameObjectType}
 *
 * @see GameObjectType
 * @see domain.interactions.commands.Interact
 */
public abstract class GameObject {

    /**
     * The name of the GameObject.
     */
    private String name;

    /**
     * The description of the GameObject.
     */
    private String description;

    /**
     * The type of GameObject.
     */
    private GameObjectType type;
    
    private final ExitDirection exitDirection;

    /**
     * An object within the game.
     *
     * @param name of the GameObject.
     * @param description of the GameObject.
     * @param type of the GameObject.
     * @param exitDirection , which exit the player comes out of.
     */
    protected GameObject(String name, String description, GameObjectType type, ExitDirection exitDirection) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.exitDirection = exitDirection;
    }

    /**
     * Interact with the object. (Needs implementation from child)
     */
    public abstract void interact();

    /**
     * Set the {@link GameObject#name} of this GameObject.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the {@link #description description} of this GameObject.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the {@link #type type} of this GameObject.
     *
     * @param type The type to set.
     */
    public void setType(GameObjectType type) {
        this.type = type;
    }

    /**
     * Get the {@link #name name} of the GameObject.
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the {@link #description description} of the GameObject.
     *
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get the {@link #type type} of GameObject.
     *
     * @return
     */
    public GameObjectType getType() {
        return this.type;
    }

    /**
     * @return the exitDirection
     */
    public ExitDirection getExitDirection() {
        return exitDirection;
    }
}
