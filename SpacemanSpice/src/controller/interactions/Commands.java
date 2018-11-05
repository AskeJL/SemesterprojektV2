package controller.interactions;

import controller.interactions.commands.*;
import java.util.ArrayList;
import java.util.List;

public class Commands {

    private static final List<Command> COMMAND_WORDS = new ArrayList<>();

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
        if (commandWord != null) {
            Command command = getCommand(commandWord);
            if (command == null) {
                System.out.println("I don't know that command. \nThese are the commands available:");
                showCommands();
                return null;
            }

            if (parameter != null) {
                if (command.hasParameter()) {
                    if (command.checkAvailableParameter(parameter)) {
                        command.setCurrentParameter(parameter);
                    } else {
                        System.out.println("Wrong parameter.");
                        command.showAvailableParameters();
                        return null;
                    }
                }
                return command;
            } else {
                if (command.hasParameter()) {
                    System.out.println("Missing parameter.");
                    command.showAvailableParameters();
                    return null;
                }
                return command;
            }
        }
        return null;
    }

    /**
     * Displays the available commands to the user.
     */
    public static void showCommands() {
        for(Command command : COMMAND_WORDS) {
            System.out.format("   %-10s\n", command.getName());
        }
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
