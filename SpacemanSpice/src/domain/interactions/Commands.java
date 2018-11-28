package domain.interactions;

import domain.interactions.commands.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The main collection of {@link Command}'s as well as the main logic for
 * managing all the commands.
 *
 * It is from here, the commands are
 * {@link Commands#validateCommand(String, String) validate and checked for parameters}
 * etc.
 *
 * @see Command
 * @see InteractionsController
 * @see Parser
 */
public class Commands extends InteractionsElement {

    /**
     * A list of all the {@link Command}'s. These are initialized in the
     * {@link Commands#init() init()} method.
     */
    private final List<Command> commandWords = new ArrayList<>();
    /**
     * This is where the last called {@link Command} is stored. (Is sat to the
     * {@link domain.interactions.commands.Clear Clear} command as default)
     */
    private static Command lastCommand;
    /**
     * This is where the last called parameter is stored.
     */
    private static String lastParameter = "";

    public Commands(InteractionsController interact) {
        super(interact);

        lastCommand = new Clear(interactionsController);
        
        commandWords.add(new Go(interactionsController));
        commandWords.add(new Help(interactionsController));
        commandWords.add(new Interact(interactionsController));
        commandWords.add(new Clear(interactionsController));
        commandWords.add(new Start(interactionsController));
        commandWords.add(new Continue(interactionsController));
        commandWords.add(new Inspect(interactionsController));
    }

    /**
     * Checks to see if the inserted Strings match any {@link Command}. Will
     * then return the {@link Command} with an assigned parameter (if given).
     *
     * @param commandWord The String to validate. Needs to be the name of the
     * {@link Command}.
     * @param parameter The parameter for the {@link Command}.
     * @return Returns null if no command matched.
     */
    Command validateCommand(String commandWord, String parameter) {
        // After the Continue() command was added some bugs arised. 
        // As a result of this, this method has become slighty messy and needs
        // refactoring.
        if (commandWord != null) {
            Command command = getCommand(commandWord);
            if (command == null) {
                output.println("I don't know that command. \nThese are the commands available:");
                lastCommand = commandWords.get(0);
                showCommands();
                return null;
            }
            lastCommand = command;

            command.checkAvailableParameters();

            if (parameter != null) {
                if (command.hasParameter()) {
                    if (command.checkAvailableParameter(parameter)) {
                        command.setCurrentParameter(parameter);
                        lastParameter = parameter;
                        lastCommand = command;
                    } else {
                        output.println("Wrong parameter.");
                        command.showAvailableParameters();
                        return null;
                    }
                }
                return command;
            } else {
                if (command.hasParameter()) {
                    if (!command.getName().equalsIgnoreCase("help")) {
                        output.println("Missing parameter.");
                    }
                    command.showAvailableParameters();
                    return null;
                }
                lastCommand = command;
                return command;
            }
        }
        return null;
    }

    /**
     * Displays the {@link Commands#commandWords COMMAND_WORDS} to the user.
     */
    void showCommands() {
        String data = "";
        for (Command command : commandWords) {
            data += "   " + command.getName() + "\n";
        }
        output.println(data);
    }

    void setLastCommand(Command command) {
        lastCommand = command;
    }

    /**
     * Gets the {@link Command} based in its index.
     *
     * @param index Index of the {@link Command}.
     * @return
     */
    Command getCommand(int index) {
        return commandWords.get(index);
    }

    /**
     * Get the {@link Command} based on its name.
     *
     * @param name Name of the {@link Command}.
     * @return
     */
    Command getCommand(String name) {
        for (Command command : commandWords) {
            if (name.equals(command.getName())) {
                return command;
            }
        }
        return null;
    }

    /**
     * Get all the {@link Commands#commandWords COMMAND_WORDS}.
     *
     * @return A List of command words.
     */
    List<Command> getCommandwords() {
        return commandWords;
    }

    /**
     * Get the name of the {@link Commands#lastCommand last valid command}
     * called.
     *
     * @return
     */
    String getLastCommandName() {
        return lastCommand.getName();
    }

    /**
     * Get the {@link Commands#lastParameter last valid parameter}.
     *
     * @return
     */
    String getLastParameter() {
        return lastParameter;
    }

    @Override
    protected boolean runTest() {
        boolean passed = true;
        for (Command command : commandWords) {
            if (command != null) {
                System.out.format("  %2s %-10s: ", "Testing", command.getName());
                if (command.runTest()) {
                    System.out.println("[Passed] " + command);
                } else {
                    System.out.println("[Failed] " + command);
                    passed = false;
                }
            } else {
                System.out.println("[Failed][null] " + command);
                passed = false;
            }
        }
        return passed;
    }
}
