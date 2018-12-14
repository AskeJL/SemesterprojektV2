package domain.interactions;

import domain.DomainReader;
import domain.GameElement;
import domain.GameElementGroup;
import domain.interactions.commands.Inspect;
import domain.interactions.commands.Quit;
import domain.interactions.commands.Clear;
import domain.interactions.commands.Continue;
import domain.interactions.commands.Help;
import domain.interactions.commands.Show;
import domain.interactions.commands.Start;
import domain.locations.LocationsManager;
import domain.resources.ResourcesManager;
import domain.systems.SystemsManager;
import domain.tutorial.TutorialManager;
import java.util.ArrayList;
import java.util.List;

public class Commands extends GameElement {

    private final DomainReader reader = new DomainReader();

    /**
     * A list of all the {@link Command}'s. These are initialized in the
     * {@link Commands#init() init()} method.
     */
    private final List<Command> commandWords = new ArrayList<>();
    /**
     * This is where the last called {@link Command} is stored. (Is sat to the
     * {@link domain.interactions.commands.Clear Clear} command as default)
     */
    private static Command lastCommand = new Clear();
    /**
     * This is where the last called parameter is stored.
     */
    private static String lastParameter = "";

    public Commands() {

    }

    @Override
    public void init() {
        GameElementGroup group = this.getGameElementGroup();

        ResourcesManager resources = (ResourcesManager) group.getManagerGroup().getManager(ResourcesManager.class);
        SystemsManager systems = (SystemsManager) group.getManagerGroup().getManager(SystemsManager.class);
        TutorialManager tutorial = (TutorialManager) group.getManagerGroup().getManager(TutorialManager.class);
        LocationsManager locations = (LocationsManager) group.getManagerGroup().getManager(LocationsManager.class);
        InteractionsManager interactions = (InteractionsManager) group.getManagerGroup().getManager(InteractionsManager.class);

        commandWords.add(new Show(resources));
        commandWords.add(new Start(systems, tutorial));
        commandWords.add(new Clear());
        commandWords.add(new Quit());
        commandWords.add(new Inspect(locations));
        commandWords.add(new Help(interactions));
        commandWords.add(new Continue());
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
                reader.storeln("I don't know that command. \nThese are the commands available:");
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
                        reader.storeln("Wrong parameter.");
                        command.showAvailableParameters();
                        return null;
                    }
                }
                return command;
            } else {
                if (command.hasParameter()) {
                    if (!command.getName().equalsIgnoreCase("help")) {
                        reader.storeln("Missing parameter.");
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
        reader.storeln(data);
    }

    @Override
    public String toString() {
        String string = "domain.interactions.Commands";

        for (Command command : commandWords) {
            string += "\n    " + command.toString();
        }

        return string;
    }

    public void setLastCommand(Command command) {
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
    public List<Command> getCommandWords() {
        return commandWords;
    }

    /**
     * Get the name of the {@link Commands#lastCommand last valid command}
     * called.
     *
     * @return
     */
    public String getLastCommandName() {
        return lastCommand.getName();
    }

    /**
     * Get the {@link Commands#lastParameter last valid parameter}.
     *
     * @return
     */
    public String getLastParameter() {
        return lastParameter;
    }
}
