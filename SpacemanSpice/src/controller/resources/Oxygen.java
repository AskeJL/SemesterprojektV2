
package controller.resources;

/**
 * Class that controls the oxygen resource
 */
public class Oxygen extends Element {
    
    private static int oxygen = 100;
    private static final long TIME_BEFORE_LOSING_OXYGEN = 10;
    
    public static void update() {
        if(Life.getLife() <= 50 && Time.getCurrentTime() % TIME_BEFORE_LOSING_OXYGEN == 0) {
            oxygen--;
        }
    }
    
    /**
     * Method used to decrease the oxygen variable
     * @param decreaseValue
     */
    public void decreaseOxygen(int decreaseValue){
        oxygen -= decreaseValue;
    }
    
    /**
     * Method used to increase the oxygen variable
     */
    public void increaseOxygen(int increaseValue){
        oxygen += increaseValue;
    }
    
    public double getOxygen(){
        return this.oxygen;
    }
}
