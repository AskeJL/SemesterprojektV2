package controller.resources;

/**
 * Element superclass used for various resource classes
 */
public class Element {
    
    private final double START_VALUE = 0;
    private double increment;
    private double decrement;
    private double max;
    private double min;
    
    protected Element() {}
    
    /**
     * method used to update value
     */
    static void update(){
        
    }
    
    @Override
    public String toString(){
        String s = "";
        return s;
    }
   
    public void setIncrement(double incrementValue){
        
    }
    
    public void setDecrement(double decrementValue){
        
    }
    
    public void setMax(double maxValue){
        
    }
    
    public void setMin(double minValue){
        
    }
    
    public double getIncrement(){
        return this.increment;
    }
    
    public double getDecrement(){
        return this.decrement;
    }
    
    public double getMax(){
        return this.max;
    }
    
    public double getMin(){
        return this.min;
    }
    
    
    
}
