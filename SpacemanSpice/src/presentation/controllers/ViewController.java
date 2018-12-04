package presentation.controllers;

import javafx.scene.Parent;
import presentation.GUIManager;

public abstract class ViewController {

    protected static GUIManager guiManager;
    private Parent parent;
    private String path;

    public abstract void update();

    public void setManager(GUIManager gui) {
        guiManager = gui;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ViewController && this.path != null && ((ViewController) o).path != null) {
            return this.path.equals(((ViewController) o).path);
        }
        return false;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public Parent getParent() {
        return this.parent;
    }
}
