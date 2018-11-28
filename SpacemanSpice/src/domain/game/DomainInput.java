package domain.game;

import domain.interactions.Command;
import domain.interactions.InteractionsController;
import domain.interactions.InteractionsReader;
import domain.locations.LocationsController;
import domain.locations.LocationsReader;
import domain.resources.ResourcesController;
import domain.resources.ResourcesReader;
import java.util.ArrayList;
import java.util.List;

public class DomainInput implements InteractionsReader, LocationsReader, ResourcesReader {
    
    private InteractionsController interactionsController;
    private LocationsController locationsController;
    private ResourcesController resourcesController;
    
    private final DomainOutput output = new DomainOutput();
    
    public DomainInput() {
        
    }
    
    DomainInput(Game game) {
        interactionsController = (InteractionsController)game.getController(new InteractionsController(game));
        locationsController = (LocationsController)game.getController(new LocationsController(game));
        resourcesController = (ResourcesController)game.getController(new ResourcesController(game));
    }

    @Override
    public String requestLastCommand() {
        return interactionsController.getLastCommandName();
    }

    @Override
    public String requestLastParameter() {
        return interactionsController.getLastParameter();
    }

    @Override
    public List<String> requestCommandWords() {
        List<String> commandWords = new ArrayList<>();
        for (Command command : interactionsController.getCommandWords()) {
            commandWords.add(command.getName());
        }

        return commandWords;
    }

    @Override
    public String requestRunCommand(String input) {
        interactionsController.runCommand(input);
        return output.getOutputText();
    }

    @Override
    public String requestOutputText() {
        return output.getOutputText();
    }

    @Override
    public String requestCurrentRoom() {
        return locationsController.getCurrentRoom().getName();
    }

    @Override
    public String requestCurrentLocation() {
        return locationsController.getCurrentLocation().getName();
    }

    @Override
    public int requestLifeValue() {
        return resourcesController.getLifeValue();
    }

    @Override
    public int requestOxygenValue() {
        return resourcesController.getOxygenValue();
    }

    @Override
    public long requestWaveTime() {
        return resourcesController.getWaveTime();
    }

    @Override
    public long requestCurrentTime() {
        return resourcesController.getCurrentTime();
    }
}
