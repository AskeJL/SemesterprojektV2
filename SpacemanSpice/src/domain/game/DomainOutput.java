package domain.game;

public class DomainOutput {
    private static Game game;
    
    private static String outputText = "";
    
    public DomainOutput() {
        
    }
    
    DomainOutput(Game game) {
        DomainOutput.game = game;
    }
    
    public void init() {
        
    }
    
    public void println(String text) {
        outputText += text + "\n";
    }
    
    public String getOutputText() {
        return outputText;
    }
}
