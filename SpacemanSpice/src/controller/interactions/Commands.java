package controller.interactions;

import controller.interactions.commands.*;
import java.util.ArrayList;
import java.util.List;

public class Commands {

    private static final List<Command> COMMAND_WORDS = new ArrayList<>();

    public Commands() {
        // The class is static so the constructer is never called.
    }

    /**
     * Initialize the Commands class.
     */
    public static void init() {
        COMMAND_WORDS.clear();

        COMMAND_WORDS.add(new Go());
        COMMAND_WORDS.add(new Help());
        COMMAND_WORDS.add(new Interact());
        COMMAND_WORDS.add(new Quit());
    }

    /**
     * Checks to see if the inserted Strings match any command. Will return the
     * command with an assigned parameter (if given).
     *
     * @param commandWord The String to validate. Needs to be the name of the
     * command.
     * @param parameter The parameter for the command.
     * @return The command.
     */
    public static Command validateCommand(String commandWord, String parameter) {
        if (commandWord != null && parameter != null) {
            Command command = getCommand(commandWord);
            if (command.hasParameter() && command.checkParameter(parameter)) {
                command.setCurrentParameter(parameter);
                return command;
            }
            System.out.println("Wrong parameter.");
        } else if (commandWord != null) {
            Command command = getCommand(commandWord);
            if (command.hasParameter()) {
                System.out.println("Missing parameter.");
                return null;
            }
            return command;
        }
        return null;
    }

    /**
     * Gets the command based in its index.
     *
     * @param index Index of the command.
     * @return The command.
     */
    public static Command getCommand(int index) {
        return COMMAND_WORDS.get(index);
    }

    /**
     * Get the command based on its name.
     *
     * @param name Name of the command.
     * @return The command.
     */
    public static Command getCommand(String name) {
        for (Command command : COMMAND_WORDS) {
            if (name.equals(command.getName())) {
                return command;
            }
        }
        return null;
    }

    /**
     * Get all the command words.
     *
     * @return A List of command words.
     */
    public static List<Command> getCommandwords() {
        return COMMAND_WORDS;
    }

}
