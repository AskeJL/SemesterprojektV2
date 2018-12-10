package domain;

public abstract class GameElement {
    
    protected GameElementGroup gameElementGroup;
    
    public abstract void init();
    
    public void setGameElementGroup(GameElementGroup group) {
        this.gameElementGroup = group;
    }
    
    public GameElementGroup getGameElementGroup() {
        return this.gameElementGroup;
    }
}
