package controller.resources;

/**
 * Class that controls the oxygen resource
 */
public class Oxygen {

    private static int oxygen = 100;
    private static final long TIME_BEFORE_LOSING_OXYGEN = 5;
    private static long lastTime;

    public static void update() {
        if (Life.getLife() <= 50) {
            oxygen -= (Time.getCurrentTime() - lastTime) / TIME_BEFORE_LOSING_OXYGEN;
        }

        lastTime = Time.getCurrentTime();
    }

    /**
     * Method used to decrease the oxygen variable
     *
     * @param decreaseValue
     */
    public void decreaseOxygen(int decreaseValue) {
        oxygen -= decreaseValue;
    }

    /**
     * Method used to increase the oxygen variable
     *
     * @param increaseValue
     */
    public static void increaseOxygen(int increaseValue) {
        oxygen += increaseValue;
    }

    public static int getOxygen() {
        return oxygen;
    }
}
