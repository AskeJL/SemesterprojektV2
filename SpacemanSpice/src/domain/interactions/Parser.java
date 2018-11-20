package domain.interactions;

import java.util.Scanner;

/**
 * The parser reads input Strings and redirects it for
 * {@link Commands#validateCommand(String, String) command validation}. It then
 * receives a validated command (if not validated will be null).
 *
 * @see InteractionsController
 * @see Command
 * @see Commands
 */
public class Parser {

    /**
     * The main scanner used for reading Strings in the class.
     */
    private static final Scanner READER = new Scanner(System.in);

    private Parser() {
    }

    /**
     * Read the two first inputs from the user. Then return the words
     * separately.
     *
     * @return An array of the two Strings.
     */
    private static String[] readInput() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = READER.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next().toLowerCase();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next().toLowerCase();
            }
        }

        String[] words = {word1, word2};
        return words;
    }

    /**
     * Read the user input and determine what command to process. When found,
     * will return the appropriate command. Uses the {@link Parser#readInput()}
     * method.
     *
     * @return The command that matches the user input.
     */
    static Command getCommand() {
        String[] inputs = readInput();

        String word1 = inputs[0];
        String word2 = inputs[1];

        return Commands.validateCommand(word1, word2);
    }

    private static String[] convertInput(String input) {
        String word1 = null;
        String word2 = null;

        Scanner tokenizer = new Scanner(input);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next().toLowerCase();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next().toLowerCase();
            }
        }

        String[] words = {word1, word2};
        return words;
    }

    static Command getCommand(String input) {
        String[] inputs = convertInput(input);

        String word1 = inputs[0];
        String word2 = inputs[1];

        return Commands.validateCommand(word1, word2);
    }

    /**
     * Print a list of all the available commands. Uses the
     * {@link Commands#getCommandwords()}
     */
    void showCommands() {
        for (Command command : Commands.getCommandwords()) {
            System.out.println(command);
        }
    }
}
