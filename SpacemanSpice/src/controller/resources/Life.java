package controller.resources;

/**
 * This class is used by other systems to consider the current life of the
 * ship in the game.
 */
public class Life extends Element {
    
    private static final int SMALL_FRAGMENT_DAMAGE = 5;
    private static final int MEDIUM_FRAGMENT_DAMAGE = 10;
    private static final int LARGE_FRAGMENT_DAMAGE = 15;
    private static final int repairAmount = 5;
    
    private static boolean repair = false;
    
    private static int life = 50;
    
    public static void update() {
        
    }
    
    /**
     * The method that increases the life value of the ship.
     */
    public static void updateLife() {
        if(life < 100 && repair == true) {
            life += repairAmount;
        }
        if(life >= 100) {
            life = 100;
        }
        repair = false;
    }
    
    /**
     * The method that decreases the life value of the ship.
     * @param hitSmallFragments, amount of small fragments
     * @param hitMediumFragments, amount of medium fragments
     * @param hitLargeFragments, amount of large fragments
     */
    public static void decreaseLife(int hitSmallFragments, int hitMediumFragments, int hitLargeFragments) {
        if(hitSmallFragments >= 0) {
            life -= (SMALL_FRAGMENT_DAMAGE * hitSmallFragments);
        }
        if(hitMediumFragments >= 0) {
            life -= (MEDIUM_FRAGMENT_DAMAGE * hitMediumFragments);
        }
        if(hitLargeFragments >= 0) {
            life -= (LARGE_FRAGMENT_DAMAGE * hitLargeFragments);
            }
        if(life <= 0) {
            //Game over.
        }
    }
    
    public static double getLife() {
        return life;
    }
    
}
