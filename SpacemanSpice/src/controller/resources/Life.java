package controller.resources;

/**
 * This class is used by other systems to consider the current life of the
 * ship in the game.
 */
public class Life extends Element {
    
    private final int SMALL_FRAGMENT = 1;
    private final int MEDIUM_FRAGMENT = 2;
    private final int LARGE_FRAGMENT = 3;
    
    private int hit;
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
    public void increaseLife(boolean repair) {
        super.getIncrement();
        
        if(repair == true) {
            super.setIncrement(2);
        }
        
        
    }
    /**
     * The method that decreases the life value of the ship.
     */
    public void decreaseLife(int hit) {
        super.getDecrement();
        
        if(hit == SMALL_FRAGMENT) {
            super.setDecrement(5);
        }
        if(hit == MEDIUM_FRAGMENT) {
            super.setDecrement(10);
        }
        if(hit == LARGE_FRAGMENT) {
            super.setDecrement(15);
        }
        
    }
    
    @Override 
    public void update() {
        
    }
    
    public double getLife() {
        return this.life;
    }
    
}
