package domain.interactions.commands;

import domain.interactions.Command;
import domain.interactions.InteractionsController;
import domain.locations.Exit;
import domain.locations.LocationsController;
import domain.systems.SystemsController;

/**
 * This command is responsible for helping the player with information. The
 * 'help' command can be called by itself or accompanied by a parameter.
 *
 * Say, if the player needed help with a specific command, it could be achieved
 * with: 'help go'. This will call the helpInfo from the Go command.
 */
public class Help extends Command {

    private final LocationsController locationsController;
    
    public Help() {
        super("help", "Display the help list.", true);

        super.addParameter("go");
        super.addParameter("interact");
        super.addParameter("help");
        super.addParameter("quit");
        super.addParameter("clear");
        super.addParameter("start");
        
        locationsController = interactionsController.getLocationsController();
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
                interactionsController.getCommand(super.getCurrentParameter().toLowerCase()).helpInfo();
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Help: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }

    @Override
    public void helpInfo() {
        output.println("The help function can tell you which commands you can use in the given room");
    }

    /**
     * This showAvailableParameters() method is special, because it will only
     * show if the {@link Help} {@link Command} is called by itself. If that
     * happens, the {@link Help} command will print out specific guidance to
     * that room. (Directions, interactions and available commands)
     */
    @Override
    public void showAvailableParameters() {
        output.println("Current room:");
        output.println(String.format("%10s %s", "", locationsController.getCurrentLocation().getNAME() + "/" + locationsController.getCurrentRoom().getName()));

        output.println("You can go:");
        for (Exit exit : locationsController.getCurrentLocation().getExits()) {
            if (exit.getFromRoom().getName().equals(locationsController.getCurrentRoom().getName())) {
                output.println(String.format("%10s %-5s - %-10s", "", exit.getDirection().name().toLowerCase(), exit.getToLocation().getNAME()));
            }
        }
        for (Exit exit : locationsController.getCurrentRoom().getExits()) {
            output.println(String.format("%10s %-5s - %-10s", "", exit.getDirection().name().toLowerCase(), exit.getFromRoom().getName()));
        }

        if (!locationsController.getCurrentRoom().getGameObjects().isEmpty()) {
            output.println("You can interact with:");
            output.println(String.format("%10s %s", "", locationsController.getCurrentRoom().getGameObjects().get(0).getName()));
        }

        output.println("Available commands: ");
        if (!SystemsController.getPlayerReady()) {
            output.println(super.getAvailableParameters().toString());
        } else {
            output.println(super.getAvailableParameters().subList(0, super.getAvailableParameters().size() - 1).toString());
        }
    }
}
