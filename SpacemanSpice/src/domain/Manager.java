package domain;

public abstract class Manager {

    protected ManagerGroup managerGroup;
    protected GameElementGroup gameElementGroup;

    protected Manager() {}
    
    public Manager(GameElementGroup group) {
        this.gameElementGroup = group;
    }

    public void init() {
        for (GameElement e : gameElementGroup.getElements()) {
            e.init();
        }
    }

    public void update() {
        for (GameElement e : gameElementGroup.getElements()) {
            if (e instanceof GameUpdateable) {
                ((GameUpdateable) e).update();
            }
        }
    }
    
    public void setManagerGroup(ManagerGroup group) {
        this.managerGroup = group;
    }
    
    public void setGameElementGroup(GameElementGroup group) {
        group.setManager(this);
        this.gameElementGroup = group;
    }
    
    public ManagerGroup getManagerGroup() {
        return this.managerGroup;
    }
    
    public GameElementGroup getGameElementGroup() {
        return this.gameElementGroup;
    }
    
    public Manager getManager(Class className) {
        return this.managerGroup.getManager(className);
    }
    
    @Override
    public String toString() {
        String info = "[domain.Manager]\n";
        info += "GameElementGroup: " + gameElementGroup + "\n";
        return info;
    }
}
