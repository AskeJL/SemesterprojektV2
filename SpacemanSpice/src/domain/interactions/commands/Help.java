package domain.interactions.commands;

import domain.DomainReader;
import domain.interactions.Command;
import domain.interactions.InteractionsManager;
import domain.locations.LocationsManager;
import domain.systems.SystemsManager;

/**
 * This command is responsible for helping the player with information. The
 * 'help' command can be called by itself or accompanied by a parameter.
 *
 * Say, if the player needed help with a specific command, it could be achieved
 * with: 'help go'. This will call the helpInfo from the Go command.
 */
public class Help extends Command {

    private final InteractionsManager interactionsManager;
    private final DomainReader reader = new DomainReader();

    public Help(InteractionsManager interactions) {
        super("help", "Display the help list.", true);
        
        this.interactionsManager = interactions;
        
        for(Command command : interactionsManager.getCommands().getCommandWords()) {
            super.addParameter(command.getName());
        }
    }

    /**
     * All {@link Command#availableParameters available parameters} are set to
     * all the {@link Command#parameters primary parameters}.
     */
    @Override
    public void checkAvailableParameters() {
        super.setAvailableParameters(super.getParameters());
    }

    /**
     * Calls the 'parameters' helpInfo() method.
     *
     * Say, if the player entered 'help go', the {@link Go#helpInfo()} method
     * would be called. (A method that the implementation overrides).
     */
    @Override
    public void run() {
        for (String parameter : super.getAvailableParameters()) {
            if (parameter.equalsIgnoreCase(super.getCurrentParameter())) {
                Command command = interactionsManager.getCommand(super.getCurrentParameter().toLowerCase());
                if(command != null) {
                    command.helpInfo();
                }
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "domain.interactions.commands.Help: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }

    @Override
    public void helpInfo() {
        reader.storeln("The help function can tell you which commands you can use in the given room");
    }

    /**
     * This showAvailableParameters() method is special, because it will only
     * show if the {@link Help} {@link Command} is called by itself. If that
     * happens, the {@link Help} command will print out specific guidance to
     * that room. (Directions, interactions and available commands)
     */
    @Override
    public void showAvailableParameters() {
        LocationsManager locationsManager = (LocationsManager) interactionsManager.getManager(LocationsManager.class);
        SystemsManager systemsManager = (SystemsManager) interactionsManager.getManager(SystemsManager.class);

        reader.storeln("Current location:");
        reader.storeln(String.format("%10s %s", "", locationsManager.getCurrentLocation().getName()));

        reader.storeln("Available commands: ");
        if (!systemsManager.getPlayerReady()) {
            reader.storeln(super.getAvailableParameters().toString());
        } else {
            reader.storeln(super.getAvailableParameters().subList(0, super.getAvailableParameters().size() - 1).toString());
        }
    }
}
