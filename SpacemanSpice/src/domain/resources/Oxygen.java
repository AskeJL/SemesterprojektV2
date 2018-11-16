package domain.resources;

import domain.locations.LocationsController;

/**
 * This is used by other systems to compute the current amount of oxygen the
 * player has. The oxygen will vary depending on where the player is, and the
 * amount of damage the ship has taken ({@link Life}).
 *
 * @see domain.systems.Wave
 * @see domain.systems.SystemsController
 */
public class Oxygen {

    /**
     * Amount of oxygen the player currently has.
     */
    private static int oxygen = 100;
    /**
     * How fast the oxygen will decline.
     */
    private static final long TIME_BEFORE_LOSING_OXYGEN = 2;

    /**
     * Holds the last time the oxygen was computed. Used for calculation between
     * updates.
     */
    private static long lastTime;

    private Oxygen() {
    }

    /**
     * Will decrease oxygen if {@link Life#life} is below 50. Oxygen will also
     * decrease if the player is currently standing in a place without oxygen.
     *
     * @see domain.locations.functional.Outside
     * @see domain.locations.functional.Oxygen
     */
    static void update() {
        if (Life.getLife() <= 50) {
            oxygen -= (Time.getCurrentTime() - lastTime) / TIME_BEFORE_LOSING_OXYGEN;
        } else if(LocationsController.getCurrentRoom().getName().equalsIgnoreCase("outside")) {
            oxygen -= (Time.getCurrentTime() - lastTime) / TIME_BEFORE_LOSING_OXYGEN;
        }

        lastTime = Time.getCurrentTime();
    }

    /**
     * Increase {@link #oxygen oxygen}.
     *
     * @param value How much to increase.
     */
    static void increaseOxygen(int value) {
        oxygen += value;
    }

    /**
     * Get {@link #oxygen oxygen}.
     *
     * @return
     */
    static int getOxygen() {
        return oxygen;
    }
}
