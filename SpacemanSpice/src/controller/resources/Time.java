package controller.resources;

/**
 * Class used to count time in other systems
 */
public class Time extends Element {
    
    
    private static double time;
    
    /**
     * Constructor
     */
    public Time(){
    
    }
    
    /**
     * Method that increases the time variable
     * @param decreaseVariable
     */
    public void decreaseTime(int decreaseVariable){
        time -= decreaseVariable;
    }
    
    /**
     * Method that decreases the time variable
     */
    public void increaseTime(){
        
    }
    
    
    @Override
    public void update(){
        
    }
    
    static double getTime(){
        return time;
    }
    
}
