package domain;

/**
 * An instance of this is responsible for managing a {@link GameElementGroup}.
 * It is also an essential part in linking instances together.
 * <p>
 * The manager has to be added to the main {@link Game#managerGroup} to function
 * properly. Otherwise, it won't get initialized and updated as expected.
 * <p>
 * A manager is close to useless without a {@link GameElementGroup}, so remember
 * to include that upon implementation.
 * 
 * @see ManagerGroup
 */
public abstract class Manager {

    /**
     * A group of all the {@link Manager}s that are instantiated to manage the
     * game. (It is through this, the manager can access other managers)
     */
    protected ManagerGroup managerGroup;

    /**
     * This managers group of {@link GameElement}s.
     */
    protected GameElementGroup gameElementGroup;

    protected Manager() {
    }

    public Manager(GameElementGroup group) {
        this.gameElementGroup = group;
    }

    /**
     * Initialize the manager by initializing all the {@link GameElement}s in
     * the {@link #gameElementGroup}.
     * <p>
     * This calls each {@link GameElement}s {@link GameElement#init()} method.
     */
    public void init() {
        for (GameElement e : gameElementGroup.getGameElements()) {
            e.init();
        }
    }

    /**
     * Update the manager by updating all the {@link GameElement}s in the
     * {@link #gameElementGroup}.
     * <p>
     * The update will only occur if the {@link GameElement} is an instance of
     * {@link GameUpdateable}.
     */
    public void update() {
        for (GameElement e : gameElementGroup.getGameElements()) {
            if (e instanceof GameUpdateable) {
                ((GameUpdateable) e).update();
            }
        }
    }

    /**
     * Set {@link #managerGroup}.
     *
     * @param group Group to set.
     */
    public void setManagerGroup(ManagerGroup group) {
        this.managerGroup = group;
    }

    /**
     * Set {@link #gameElementGroup} as well as calling the groups
     * {@link GameElementGroup#setManager(domain.Manager)}, setting it to this
     * {@link Manager}. This also sets this {@link ManagerGroup} to the
     * {@link GameElementGroup}s instance of the {@link ManagerGroup}.
     *
     * @param group Group to set.
     */
    public void setGameElementGroup(GameElementGroup group) {
        group.setManager(this);
        this.setManagerGroup(group.getManagerGroup());
        this.gameElementGroup = group;
    }

    /**
     * Get {@link #managerGroup}.
     *
     * @return The manager group.
     */
    public ManagerGroup getManagerGroup() {
        return this.managerGroup;
    }

    /**
     * Get {@link #gameElementGroup}.
     *
     * @return The {@link GameElement} group.
     */
    public GameElementGroup getGameElementGroup() {
        return this.gameElementGroup;
    }

    /**
     * Get a {@link Manager} from the {@link #managerGroup}.
     * <p>
     * Calls the {@link ManagerGroup#getManager(java.lang.Class)}.
     *
     * @param className Class name to look for.
     * @return The requested manager if present. If not, null.
     */
    public Manager getManager(Class className) {
        return this.managerGroup.getManager(className);
    }

    /**
     * This toString will print out, not only itself, but the
     * {@link GameElementGroup} too.
     *
     * @return A String.
     */
    @Override
    public String toString() {
        String info = "[domain.Manager]\n";
        info += "GameElementGroup: " + gameElementGroup + "\n";
        return info;
    }
}
