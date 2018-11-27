package presentation;

import java.io.IOException;

/**
 * An interface to the presentation-layer for requesting updates. The intent of
 * this, is for the domain layer to update the presentation layer when prompted.
 *
 * @see ViewManager#update()
 */
public interface PresentationUpdate {

    /**
     * Request update from {@link ViewManager}.
     */
    default void sendUpdateRequest() {
        ViewManager.update();
    }
}