package domain.interactions.commands;

import domain.interactions.Command;
import domain.interactions.InteractionsController;
import domain.locations.Exit;
import domain.locations.LocationsController;
import java.util.ArrayList;
import java.util.List;

public class Go extends Command {

    private List<Exit> currentExits = new ArrayList<>();

    public Go() {
        super("go", "Walk the player in a direction. [North, South, West, East]", true);

        super.addParameter("north");
        super.addParameter("west");
        super.addParameter("east");
        super.addParameter("south");
    }

    @Override
    public void checkAvailableParameters() {
        currentExits.clear();
        ArrayList<Exit> roomExits = LocationsController.getCurrentRoom().getExits();
        ArrayList<String> parameters = new ArrayList<>();

        for (Exit exit : LocationsController.getCurrentLocation().getExits()) {
            if (exit.getFromRoom().getName().equals(LocationsController.getCurrentRoom().getName())) {
                parameters.add(exit.getDirection().name().toLowerCase());
                currentExits.add(exit);
            }
        }

        for (Exit exit : roomExits) {
            parameters.add(exit.getDirection().name().toLowerCase());
            currentExits.add(exit);
        }

        super.setAvailableParameters(parameters);
    }

    @Override
    public void run() {
        Exit exitTo = null;

        for (Exit exit : this.currentExits) {
            if (exit.getDirection().name().toLowerCase().equals(super.getCurrentParameter())) {
                exitTo = exit;
            }
        }

        if(exitTo != null && exitTo.isExitToLocation()) {
            LocationsController.setCurrentLocation(exitTo.getToLocation());
            LocationsController.setCurrentRoom(exitTo.getToRoom());
        } else if(exitTo != null) {
            LocationsController.setCurrentRoom(exitTo.getFromRoom());
        }
        
        System.out.println("Current location: " + LocationsController.getCurrentLocation().getName());
        System.out.println("Current room: " + LocationsController.getCurrentRoom().getName());
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Go: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }

    @Override
    public void helpInfo() {
        System.out.println("The go function takes takes go and then a secong parameter");
        System.out.println("The parameter are the direction in which there is an exit in the given room");
    }
}
