package presentation;

import javafx.stage.Stage;

/**
 * The main controller of all the view from the presentation layer. This will
 * control which views to update and initialize.
 */
class ViewManager {

    private static Stage currentStage;
    
    /**
     * Initialize the necessary scene.
     */
    static void init() {
        currentStage.setTitle("Spaceman Spice");
        currentStage.show();
    }

    /**
     * Update a particular view. 
     */
    static void update() {
        
    }
    
    static void setStage(Stage stage) {
        currentStage = stage;
    }
}
