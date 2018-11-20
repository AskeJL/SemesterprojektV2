package presentation;

import javafx.stage.Stage;

/**
 * An interface to the presentation-layer for requesting initialization. The
 * intent of this, is for the domain layer to initialize the presentation layer
 * when prompted.
 *
 * @see ViewManager#init()
 */
public interface presentationInit {

    /**
     * Request initialization from {@link ViewManager}.
     *
     */
    default void initRequest() {
        ViewManager.init();
    }

    /**
     * Set the current stage of the application.
     *
     * @param stage Stage to set.
     */
    default void sendStageRequest(Stage stage) {
        ViewManager.setStage(stage);
    }
}
