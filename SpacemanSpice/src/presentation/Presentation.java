package presentation;

import java.io.IOException;
import javafx.stage.Stage;

public class Presentation implements PresentationRequest, PresentationUpdate {

    public ViewManager viewManager;
    
    public Presentation(ViewManager viewManager) {
        this.viewManager = viewManager;
    }
    
    @Override
    public void sendInit() throws IOException {
        viewManager.init();
    }

    @Override
    public void sendStage(Stage stage) {
        viewManager.setStage(stage);
    }

    @Override
    public String requestLastPath() {
        return viewManager.getLastPath();
    }

    @Override
    public void sendUpdate() {
        viewManager.update();
    }
}
