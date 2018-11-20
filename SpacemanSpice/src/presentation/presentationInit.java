package presentation;

/**
 * An interface to the presentation-layer for requesting initialization. The
 * intent of this, is for the domain layer to initialize the presentation layer
 * when prompted.
 *
 * @see ViewManager#init(int sceneIndex)
 */
public interface presentationInit {

    /**
     * Request initialization from {@link ViewManager}.
     *
     * @param viewIndex The index of the view the program should initialize
     * with.
     */
    default void initRequest(int viewIndex) {
        ViewManager.init(viewIndex);
    }
}
