package domain.resources;

import domain.GameElement;

public interface ResourcesElement extends GameElement {
    
    public void decreaseValue(int value);

    public void increaseValue(int value);

    public void setValue(int value);
    
    public int getValue();
}
