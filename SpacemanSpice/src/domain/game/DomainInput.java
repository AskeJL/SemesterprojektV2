package domain.game;

import domain.interactions.Command;
import domain.interactions.InteractionsController;
import domain.interactions.InteractionsReader;
import java.util.ArrayList;
import java.util.List;

public class DomainInput implements InteractionsReader {

    private static Game game;
    private static InteractionsController interactionsController;
    
    private final DomainOutput output = new DomainOutput();
    
    public DomainInput() {
        
    }
    
    DomainInput(Game game) {
        DomainInput.game = game;
    }
    
    public void init() {
        for(Controller c : game.getControllers()) {
            if(c instanceof InteractionsController) {
                interactionsController = (InteractionsController) c;
            }
        }
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
}
