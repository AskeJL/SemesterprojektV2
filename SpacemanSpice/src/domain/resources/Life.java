package domain.resources;

/**
 * This is used by other systems to compute the current life of the ship
 * in the game.
 * 
 * @see domain.systems.Wave
 * @see domain.systems.SystemsController
 */
public class Life {

    /**
     * The damage the ship receives when hit by a small fragment.
     *
     * @see domain.systems.Wave
     */
    private static final int SMALL_FRAGMENT_DAMAGE = 5;

    /**
     * The damage the ship receives when hit by a medium fragment.
     *
     * @see domain.systems.Wave
     */
    private static final int MEDIUM_FRAGMENT_DAMAGE = 10;

    /**
     * The damage the ship receives when hit by a large fragment.
     *
     * @see domain.systems.Wave
     */
    private static final int LARGE_FRAGMENT_DAMAGE = 15;

    /**
     * The amount the ship will be repaired upon
     * {@link domain.locations.gameobjects.DamageRepair reparation} (How much a
     * reparation "heals")
     */
    private static final int REPAIR_AMOUNT = 5;

    /**
     * Whether or not to repair the ship in the next
     * {@link Life#update() update}.
     */
    private static boolean repair = false;

    /**
     * Life of the ship. Will decrease upon collision with fragments. Will
     * increase upon
     * {@link domain.locations.gameobjects.DamageRepair reparation}.
     */
    private static int life = 50;

    private Life() {
    }

    /**
     * Will update {@link #life} based on the {@link Life#repair repair} boolean.
     */
    static void update() {
        if (life < 100 && repair == true) {
            life += REPAIR_AMOUNT;
        }
        if (life >= 100) {
            life = 100;
        }
        repair = false;
    }

    /**
     * Decrease the {@link #life} based on the number of fragments assigned.
     *
     * @param hitSmallFragments, amount of small fragments
     * @param hitMediumFragments, amount of medium fragments
     * @param hitLargeFragments, amount of large fragments
     *
     * @see Life#SMALL_FRAGMENT_DAMAGE
     * @see Life#MEDIUM_FRAGMENT_DAMAGE
     * @see Life#LARGE_FRAGMENT_DAMAGE
     */
    static void decreaseLife(int hitSmallFragments, int hitMediumFragments, int hitLargeFragments) {
        if (hitSmallFragments >= 0) {
            life -= (SMALL_FRAGMENT_DAMAGE * hitSmallFragments);
        }
        if (hitMediumFragments >= 0) {
            life -= (MEDIUM_FRAGMENT_DAMAGE * hitMediumFragments);
        }
        if (hitLargeFragments >= 0) {
            life -= (LARGE_FRAGMENT_DAMAGE * hitLargeFragments);
        }
        if (life <= 0) {
            //Game over.
        }
    }

    /**
     * Set the {@link Life#repair repair} to true. Preparing the reparation for
     * the next update.
     */
    static void setRepairTrue() {
        repair = true;
    }

    /**
     * Get the {@link Life#life life} of the ship.
     *
     * @return
     */
    static int getLife() {
        return life;
    }
}
