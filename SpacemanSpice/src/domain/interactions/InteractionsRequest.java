package domain.interactions;

/**
 * An interface to the domain-layer for requesting interactions. The intent of
 * this, is for the presentation layer to interact with the domain.interactions
 * package.
 *
 * @see InteractionController
 */
public interface InteractionsRequest {

    /**
     * Request {@link InteractionsController} to
     * {@link InteractionsController#runCommand(java.lang.String) runCommand}.
     *
     * @param input The input string from the console.
     * @return
     */
    default String requestRunCommand(String input) {
        InteractionsController.runCommand(input);
        return InteractionsController.getOutputText();
    }

    /**
     * Request {@link InteractionsController#setRunning(boolean)} is set to
     * false.
     */
    default void requestQuit() {
        InteractionsController.setRunning(false);
    }
}
