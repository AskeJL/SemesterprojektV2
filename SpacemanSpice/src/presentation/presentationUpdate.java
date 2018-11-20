package presentation;

/**
 * An interface to the presentation-layer for requesting an update. The intent
 * of this, is for the domain layer to continuously update the presentation
 * layer.
 * 
 * @see ViewManager#update() 
 */
public interface presentationUpdate {

    /**
     * Request an update to the current view.
     */
    default void updateRequest() {
        ViewManager.update();
    }
}
