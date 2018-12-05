package presentation.controllers;

import javafx.scene.Scene;
import presentation.GUIManager;

public abstract class ViewController {

    protected static GUIManager guiManager;
    private Scene scene;
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

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public Scene getScene() {
        return this.scene;
    }
}
