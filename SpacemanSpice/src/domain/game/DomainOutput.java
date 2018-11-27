package domain.game;

import domain.interactions.InteractionsController;

public class DomainOutput {
    private static Game game;
    private static InteractionsController interactionsController;
    
    private static String outputText = "";
    
    public DomainOutput() {
        
    }
    
    DomainOutput(Game game) {
        DomainOutput.game = game;
    }
    
    public void init() {
        for(Controller c : game.getControllers()) {
            if(c instanceof InteractionsController) {
                interactionsController = (InteractionsController) c;
            }
        }
    }
    
    public void println(String text) {
        outputText += text + "\n";
    }
    
    public String getOutputText() {
        return outputText;
    }
}
