package domain;

import java.util.List;

public class ManagerGroup {
    private final List<Manager> managers;
    
    public ManagerGroup(List<Manager> manager) {
        this.managers = manager;
    }
    
    public void add(Manager manager) {
        this.managers.add(manager);
    }
    
    public Manager getManager(Class manager) {
        for(Manager m : managers) {
            if(m.getClass().getCanonicalName().equals(manager.getCanonicalName())) {
                return m;
            }
        }
        System.out.println("Couldn't find " + manager + " in " + this.getClass().getCanonicalName());
        return null;
    }
    
    public List<Manager> getManagers() {
        return this.managers;
    }
    
    @Override
    public String toString() {
        String info = "domain.ManagerGroup\n";
        for(Manager manager : this.managers) {
            info += "  " + manager + "\n";
        }
        return info;
    }
}
