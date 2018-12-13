package domain.resources;

public interface ResourcesElement {
    
    /**
     * Used to decrease a ResourceElement value
     * 
     * @param value 
     */
    public void decreaseValue(int value);
    
    /**
     * Used to increase a ResourceElement value
     * 
     * @param value 
     */
    public void increaseValue(int value);
    
    /**
     * Used to set a ResourceElement value
     * 
     * @param value 
     */
    public void setValue(int value);
    
    /**
     * Used get a ResourceElement value
     * 
     * @return value 
     */
    public int getValue();
}
