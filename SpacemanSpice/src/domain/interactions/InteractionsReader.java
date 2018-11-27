package domain.interactions;

import java.util.List;

/**
 * An interface to the domain-layer for reading interactions data. The intent of
 * this, is for the presentation layer to display some of the computations the
 * domain.interactions package is doing.
 *
 * @see InteractionsController
 */
public interface InteractionsReader {

    /**
     * Read the last used {@link Command}.
     *
     * @return The name of the last used command.
     */
    public String requestLastCommand();

    /**
     * Read the last used parameter.
     *
     * @return The parameter as a string.
     */
    public String requestLastParameter();

    /**
     * Read a list of all the implemented command words.
     *
     * @return A list of command names.
     */
    public List<String> requestCommandWords();
    
    /**
     * Request {@link InteractionsController} to
     * {@link InteractionsController#runCommand(java.lang.String) runCommand}.
     *
     * @param input The input string from the console.
     * @return
     */
    public String requestRunCommand(String input);

    /**
     * Request {@link InteractionsController#outputText}.
     * @return 
     */
    public String requestOutputText();
}
