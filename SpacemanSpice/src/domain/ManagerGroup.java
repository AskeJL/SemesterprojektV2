package domain;

import java.util.List;

/**
 * The manager group is in charge of organizing all the {@link Manager}s into
 * one group. By doing this, every {@link GameElement} present in the
 * {@link Manager}s authority is accessible for every other {@link GameElement}.
 * <p>
 * The main manager group is made in the {@link Game} is works as the main logic
 * for the game.
 *
 * @see Manager
 * @see Game#managerGroup
 */
public class ManagerGroup {

    /**
     * The main list of {@link Manager}s for this group.
     */
    private final List<Manager> managers;

    public ManagerGroup(List<Manager> manager) {
        this.managers = manager;
    }

    /**
     * Add a {@link Manager} to the {@link #managers} list.
     *
     * @param manager Manager to add.
     */
    public void add(Manager manager) {
        this.managers.add(manager);
    }

    /**
     * Get another {@link Manager} from the {@link #managers} list.
     *
     * @param manager Manager to look for.
     * @return The requested manager if found. If not, null.
     */
    public Manager getManager(Class manager) {
        for (Manager m : managers) {
            if (m.getClass().getCanonicalName().equals(manager.getCanonicalName())) {
                return m;
            }
        }
        System.out.println("Couldn't find " + manager + " in " + this.getClass().getCanonicalName());
        return null;
    }

    /**
     * Get the {@link #managers} list.
     *
     * @return The list of managers.
     */
    public List<Manager> getManagers() {
        return this.managers;
    }

    /**
     * This toString, not only represents itself but also all of its
     * {@link Manager}s.
     *
     * @return A String.
     */
    @Override
    public String toString() {
        String info = "domain.ManagerGroup\n";
        for (Manager manager : this.managers) {
            info += "  " + manager + "\n";
        }
        return info;
    }
}
