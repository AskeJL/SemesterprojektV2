
package controller.resources;

/**
 * Class that controls the oxygen resource
 */
public class Oxygen extends Element {
    
    private int oxygen;
    
    /**
     * Constructor
     */
    public Oxygen(){
        oxygen = 100;
        this.setMax(100);
        this.setMin(0);
    }
    
    /**
     * Method used to decrease the oxygen variable
     * @param decreaseVariable
     */
    public void decreaseOxygen(int decreaseVariable){
        oxygen -= decreaseVariable;
    }
    
    /**
     * Method used to increase the oxygen variable
     */
    
    public void increaseOxygen(){
        
    }
    
    @Override
    public void update(){
        
    }
    
    public double getOxygen(){
        return this.oxygen;
    }
}
