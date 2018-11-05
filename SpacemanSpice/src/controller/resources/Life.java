package controller.resources;

/**
 * This class is used by other systems to consider the current life of the
 * ship in the game.
 */
public class Life extends Element {
    
    private final double SMALL_FRAGMENT = 1;
    private final double MEDIUM_FRAGMENT = 2;
    private final double LARGE_FRAGMENT = 3;
    
    private double life;
    
    /**
     * Constructor for this class.
     */
    Life() {
        super.setMax(100);
        super.setMin(0);
        
        super.setIncrement(2);
        super.setDecrement(5);
        
        
    }
    
    /**
     * The method that increases the life value of the ship.
     */
    public void increaseLife(int times) {
        super.getIncrement();
        
        
    }
    /**
     * The metod that decreases the life value of the ship.
     */
    public void decreaseLife(int times) {
        super.getDecrement();
        
        
    }
    
    @Override 
    public void update() {
        
    }
    
    public double getLife() {
        return this.life;
    }
    
}
