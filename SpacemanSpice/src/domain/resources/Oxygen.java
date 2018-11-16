package domain.resources;

import domain.locations.LocationsController;

/**
 * Class that controls the oxygen resource
 */
public class Oxygen {

    private static int oxygen = 100;
    private static final long TIME_BEFORE_LOSING_OXYGEN = 2;
    private static long lastTime;
    
    private Oxygen(){
        
    }

    static void update() {
        if (Life.getLife() <= 50) {
            oxygen -= (Time.getCurrentTime() - lastTime) / TIME_BEFORE_LOSING_OXYGEN;
        } else if(LocationsController.getCurrentRoom().getName().equalsIgnoreCase("outside")) {
            oxygen -= (Time.getCurrentTime() - lastTime) / TIME_BEFORE_LOSING_OXYGEN;
        }

        lastTime = Time.getCurrentTime();
    }

    /**
     * Method used to increase the oxygen variable
     *
     * @param increaseValue
     */
    static void increaseOxygen(int increaseValue) {
        oxygen += increaseValue;
    }

    static int getOxygen() {
        return oxygen;
    }
}
