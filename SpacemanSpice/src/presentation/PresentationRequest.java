package presentation;

import java.io.IOException;
import javafx.stage.Stage;

/**
 * An interface to the presentation-layer for requesting initialization. The
 * intent of this, is for the domain layer to initialize the presentation layer
 * when prompted.
 *
 * @see ViewManager#init()
 */
public interface PresentationRequest {

    /**
     * Request initialization from {@link ViewManager}.
     *
     * @throws java.io.IOException
     */
    default void sendInitRequest() throws IOException {
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
    
    default String lastPathRequest() {
        return ViewManager.getLastPath();
    }
}