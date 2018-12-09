package domain.resources;

import domain.GameUpdateable;

public class Life implements ResourcesElement, GameUpdateable {

    /**
     * The damage the ship receives when hit by a small fragment.
     *
     * @see domain.systems.Wave
     */
    private static int SMALL_FRAGMENT_DAMAGE = 5;

    /**
     * The damage the ship receives when hit by a medium fragment.
     *
     * @see domain.systems.Wave
     */
    private static int MEDIUM_FRAGMENT_DAMAGE = 10;

    /**
     * The damage the ship receives when hit by a large fragment.
     *
     * @see domain.systems.Wave
     */
    private static int LARGE_FRAGMENT_DAMAGE = 15;

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
    private boolean repair = false;

    /**
     * Life of the ship. Will decrease upon collision with fragments. Will
     * increase upon
     * {@link domain.locations.gameobjects.DamageRepair reparation}.
     */
    private int life = 50;

    public Life() {

    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        if (life < 100 && repair == true) {
            increaseValue(REPAIR_AMOUNT);
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
    public void decreaseValue(int hitSmallFragments, int hitMediumFragments, int hitLargeFragments) {
        if (hitSmallFragments >= 0) {
            decreaseValue(SMALL_FRAGMENT_DAMAGE * hitSmallFragments);
        }
        if (hitMediumFragments >= 0) {
            decreaseValue(MEDIUM_FRAGMENT_DAMAGE * hitMediumFragments);
        }
        if (hitLargeFragments >= 0) {
            decreaseValue(LARGE_FRAGMENT_DAMAGE * hitLargeFragments);
        }
        if (life <= 0) {
            //Game over.
        }
    }

    @Override
    public void decreaseValue(int value) {
        this.life -= value;
    }

    @Override
    public void increaseValue(int value) {
        life += value;
    }

    /**
     * Set the {@link Life#repair repair}. Preparing the reparation for the next
     * update.
     *
     * @param bool
     */
    public void setRepair(boolean bool) {
        this.repair = bool;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setDifficultyEasy() {
        SMALL_FRAGMENT_DAMAGE = 5;
        MEDIUM_FRAGMENT_DAMAGE = 10;
        LARGE_FRAGMENT_DAMAGE = 15;
    }

    public void setDifficultyHard() {
        SMALL_FRAGMENT_DAMAGE = 10;
        MEDIUM_FRAGMENT_DAMAGE = 15;
        LARGE_FRAGMENT_DAMAGE = 20;
    }

    @Override
    public void setValue(int value) {
        this.life = value;
    }

    /**
     * Get the {@link Life#life life} of the ship.
     *
     * @return
     */
    @Override
    public int getValue() {
        return this.life;
    }
}
