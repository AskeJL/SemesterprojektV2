package controller.resources;

/**
 * This class is used by other systems to consider the current life of the
 * ship in the game.
 */
public class Life extends Element {
    
    private static final int SMALL_FRAGMENT = 1;
    private static final int MEDIUM_FRAGMENT = 2;
    private static final int LARGE_FRAGMENT = 3;
    
    private static int smallFragmentDamage = 5;
    private static int mediumFragmentDamage = 10;
    private static int largeFragmentDamage = 15;
    private static int repairAmount = 3;
    
    private static int repair;
    
    private static int life = 50;
    
    public static void update() {
        
    }
    
    /**
     * The method that increases the life value of the ship.
     */
    public static void increaseLife(boolean repair, int repairTimes) {
        if(life < 100 && repair == true) {
            life += (repairAmount * repairTimes);
        }
        if(life >= 100) {
            life = 100;
        }
    }
    
    /**
     * The method that decreases the life value of the ship.
     */
    public static void decreaseLife(int hitType, int hitTimes) {
        if(hitType == 1) {
            life -= (smallFragmentDamage * hitTimes);
        }
        if(hitType == 2) {
            life -= (mediumFragmentDamage * hitTimes);
        }
        if(hitType == 3) {
            life -= (largeFragmentDamage * hitTimes);
        }
        if(life <= 0) {
            //Game over.
        }
    }
    
    public static double getLife() {
        return life;
    }
    
}
