package controller.resources;

/**
 * This class is used by other systems to consider the current life of the
 * ship in the game.
 */
public class Life extends Element {
    
    private final int SMALL_FRAGMENT = 1;
    private final int MEDIUM_FRAGMENT = 2;
    private final int LARGE_FRAGMENT = 3;
    
    private int smallFragmentDamage = 5;
    private int mediumFragmentDamage = 10;
    private int largeFragmentDamage = 15;
    private int repairAmount = 3;
    
    private int repair;
    
    private int life;
    
    /**
     * Constructor for this class.
     */
    public Life() {
        super.setMax(100);
        super.setMin(0);
    }
    
    /**
     * The method that increases the life value of the ship.
     */
    public void increaseLife(boolean repair, int repairTimes) {
        super.getIncrement();
        
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
    public void decreaseLife(int hitType, int hitTimes) {
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
    
    @Override 
    public void update() {
        
    }
    
    public double getLife() {
        return this.life;
    }
    
}
