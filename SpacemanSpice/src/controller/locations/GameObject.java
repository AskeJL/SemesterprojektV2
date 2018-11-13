package controller.locations;

/**
 * An object within the game that is interact-able. Either by directly using it,
 * or picking it up for later use. An example could be a chair or an air tank.
 */
public abstract class GameObject {

    private String name;
    private String description;
    private GameObjectType type;

    /**
     * An object within the game.
     *
     * @param name of the GameObject.
     * @param description of the GameObject.
     * @param type of the GameObject.
     */
    protected GameObject(String name, String description, GameObjectType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    /**
     * Interact with the object.
     */
    public abstract void interact();

    @Override
    public abstract String toString();

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(GameObjectType type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public GameObjectType getType() {
        return this.type;
    }
}
