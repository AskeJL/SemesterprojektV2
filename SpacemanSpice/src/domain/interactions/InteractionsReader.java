package domain.interactions;

import java.util.ArrayList;
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
    default String readLastCommant() {
        return InteractionsController.getLastCommandName();
    }

    /**
     * Read the last used parameter.
     *
     * @return The parameter as a string.
     */
    default String readLastParameter() {
        return InteractionsController.getLastParameter();
    }

    /**
     * Read a list of all the implemented command words.
     *
     * @return A list of command names.
     */
    default List<String> readCommandWords() {
        List<String> commands = new ArrayList<>();

        for (Command command : InteractionsController.getCommandWords()) {
            commands.add(command.getName());
        }

        return commands;
    }
}
