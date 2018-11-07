package controller.interactions;

import java.util.Scanner;

public class Parser {

    private static final Scanner READER = new Scanner(System.in);

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
     * will return the appropriate command.
     *
     * @return The command that matches the user input.
     */
    static Command getCommand() {
        String[] input = readInput();

        String word1 = input[0];
        String word2 = input[1];

        return Commands.validateCommand(word1, word2);
    }

    /**
     * Print a list of all the available commands.
     */
    void showCommands() {
        for (Command command : Commands.getCommandwords()) {
            System.out.println(command);
        }
    }
}
