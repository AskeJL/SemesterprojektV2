package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A managed group of {@link GameElement}s. By putting {@link GameElement}s in
 * this group the group will be, initialized, updated and linked with the rest
 * of the system if implemented properly.
 * <p>
 * When implementing the group, it will need a {@link Manager} to manage it. If
 * the {@link GameElement}s needs to interact with other groups, a
 * {@link ManagerGroup} needs to be assigned.
 * <p>
 * This is mostly used in {@link Game#initClasses()}.
 */
public class GameElementGroup {

    /**
     * A group of all the {@link Manager}s that are instantiated to manage the
     * game.
     */
    private ManagerGroup managerGroup;

    /**
     * The {@link Manager} that manages this group.
     */
    private Manager manager;

    /**
     * All the {@link GameElement}s that are currently stored in this group.
     */
    private final List<GameElement> gameElements = new ArrayList<>();

    /**
     * Add a {@link GameElement} to the {@link #gameElements} list.
     *
     * @param element Element to add.
     */
    public void add(GameElement element) {
        element.setGameElementGroup(this);
        this.gameElements.add(element);
    }

    /**
     * Set the {@link #managerGroup}. (There can be only one)
     *
     * @param group Group to set.
     */
    public void setManagerGroup(ManagerGroup group) {
        this.managerGroup = group;
    }

    /**
     * Set the {@link #manager}. (There can be only one)
     *
     * @param manager Manager to set.
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    /**
     * Get the {@link #managerGroup}.
     *
     * @return This manager group.
     */
    public ManagerGroup getManagerGroup() {
        return this.managerGroup;
    }

    /**
     * Get the {@link #manager}
     *
     * @return This manager.
     */
    public Manager getManager() {
        return this.manager;
    }

    /**
     * Get a {@link GameElement} upon request.
     *
     * @param gameElement element to look for.
     * @return The element if it was found. Will return null if otherwise.
     */
    public GameElement getGameElement(Class gameElement) {
        for (GameElement e : gameElements) {
            if (e.getClass().getCanonicalName().equals(gameElement.getCanonicalName())) {
                return e;
            }
        }
        System.out.println("Couldn't find " + gameElement + " in " + this.getClass().getCanonicalName());
        return null;
    }

    /**
     * Get the {@link #gameElements} list.
     *
     * @return A list of all this groups elements.
     */
    public List<GameElement> getGameElements() {
        return this.gameElements;
    }

    /**
     * This toString will display all the groups elements as well as itself.
     *
     * @return A String.
     */
    @Override
    public String toString() {
        String info = "domain.GameElementGroup\n";
        for (GameElement element : this.gameElements) {
            info += "  " + element + "\n";
        }
        return info;
    }
}
