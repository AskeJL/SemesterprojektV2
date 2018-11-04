package controller.resources;

/**
 * This class is used by other systems to consider the current life of the
 * ship in the game.
 */
public class Life extends Element {
    
    //Life er en double, da vi ikke helt har besluttet os for hvor meget
    //de forskellige typer a debris skal skade skibet (kunne være komma tal).
    private double life;
    
    /**
     * Constructor for this class.
     */
    public Life() {
        
    }
    
    /**
     * The method that increases the life value of the ship.
     */
    public void increaseLife() {
        
    }
    /**
     * The metod that decreases the life value of the ship.
     */
    public void decreaseLife() {
        
    }
    
    @Override 
    public void update() {
        
    }
    
    public double getLife() {
        return this.life;
    }
    
}
