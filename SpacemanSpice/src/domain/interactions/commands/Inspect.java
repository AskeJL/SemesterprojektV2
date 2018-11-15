package domain.interactions.commands;

import data.AssetType;
import data.read.DataReader;
import domain.interactions.Command;
import domain.locations.LocationsController;

public class Inspect extends Command implements DataReader {

    public Inspect() {
        super("inspect", "Inspect the room you are in.", false);
    }

    @Override
    protected void checkAvailableParameters() {

    }

    @Override
    protected void run() {
        for (String string : this.requestData(AssetType.DESCRIPTION, LocationsController.getCurrentRoom().getName() + ".txt")) {
            System.out.println(string);
        }
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Inspect: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        System.out.println("Inspect the room. This will give you an idea of the surroundings you are currently in.");
    }

}
