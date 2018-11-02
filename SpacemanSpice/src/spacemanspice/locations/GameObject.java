package spacemanspice.locations;

/**
 * An object within the game that is interactable. Either by directly using it,
 * or picking it up for later use. An example could be a chair or an air tank.
 */
public class GameObject {

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
    public GameObject(String name, String description, GameObjectType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    /**
     * Interact with the object.
     */
    public void interact() {
        System.out.println("Not yet implemented.");
    }

    @Override
    public String toString() {
        return "locations.GameObject : Name[" + this.name + "] Description[" + this.description + "]";
    }

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
