package domain.resources;

public interface ResourcesElement {
    
    public void decreaseValue(int value);

    public void increaseValue(int value);

    public void setValue(int value);
    
    public int getValue();
}
