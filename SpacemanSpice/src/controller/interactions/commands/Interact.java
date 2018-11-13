package controller.interactions.commands;

import controller.interactions.Command;
import controller.locations.LocationsController;

public class Interact extends Command {

    public Interact() {
        super("interact", "Interact with an object.", false);
    }

    @Override
    protected void checkAvailableParameters() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void run() {
        if (LocationsController.getCurrentRoom().getGameObjects().isEmpty() == false){
        LocationsController.getCurrentRoom().getGameObjects().get(0).interact();
        }
        else {
            System.out.println("There are nothing to interact with in this room");
        }
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Interact: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }

    @Override
    public void helpInfo() {
        System.out.println("The ineract function lest you interact with object in the room you are in");
//        System.out.println("The interact function takes a parameter which is the thing you would like to interact with");
    }

}
