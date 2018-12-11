
package domain;

import domain.locations.LocationsManager;
import domain.interactions.Commands;
import domain.interactions.Parser;
import domain.interactions.InteractionsManager;
import domain.locations.gameobjects.TileManager;
import domain.resources.Life;
import domain.resources.Oxygen;
import domain.resources.ResourcesManager;
import domain.resources.Time;
import domain.systems.Score;
import domain.systems.SystemsManager;
import domain.systems.Wave;
import domain.tutorial.TutorialManager;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import presentation.CLIManager;
import presentation.GUIManager;
import presentation.ViewManager;

public class Game extends Application {

    private ManagerGroup managerGroup;
    private ViewManager viewManager;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initClasses();
        initInterfaces();
        initUI(new GUIManager(), primaryStage);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        }.start();
    }
    
    void initClasses() {
        // Create managers
        LocationsManager locationsManager = new LocationsManager();
        ResourcesManager resourcesManager = new ResourcesManager();
        InteractionsManager interactionsManager = new InteractionsManager();
        SystemsManager systemsManager = new SystemsManager();
        TutorialManager tutorialManager = new TutorialManager();
        TileManager tileManager = new TileManager();

        // Add to manager list
        List<Manager> managers = new ArrayList<>();
        managers.add(interactionsManager);
        managers.add(locationsManager);
        managers.add(resourcesManager);
        managers.add(systemsManager);
        managers.add(tileManager);
        managers.add(tutorialManager);

        managerGroup = new ManagerGroup(managers);
        
        // Create Resources package
        GameElementGroup resourcesGroup = new GameElementGroup();
        resourcesGroup.setManagerGroup(managerGroup);
        resourcesGroup.add(new Time());
        resourcesGroup.add(new Life());
        resourcesGroup.add(new Oxygen());
        resourcesManager.setGameElementGroup(resourcesGroup);

        // Create Interactions package.
        GameElementGroup interactionsGroup = new GameElementGroup();
        interactionsGroup.setManagerGroup(managerGroup);
        interactionsGroup.add(new Commands());
        interactionsGroup.add(new Parser());
        interactionsManager.setGameElementGroup(interactionsGroup);
        
        // Create Systems package.
        GameElementGroup systemsGroup = new GameElementGroup();
        systemsGroup.setManagerGroup(managerGroup);
        systemsGroup.add(new Score());
        systemsGroup.add(new Wave());
        systemsManager.setGameElementGroup(systemsGroup);
        
        // Create Locations package.
        GameElementGroup locationsGroup = new GameElementGroup();
        locationsGroup.setManagerGroup(managerGroup);
        locationsManager.setGameElementGroup(locationsGroup);
        
        // Create Tutorial package.
        GameElementGroup tutorialGroup = new GameElementGroup();
        tutorialGroup.setManagerGroup(managerGroup);
        tutorialManager.setGameElementGroup(tutorialGroup);
        
        // Create Tile package.
        GameElementGroup tileGroup = new GameElementGroup();
        tileGroup.setManagerGroup(managerGroup);
        tileManager.setGameElementGroup(tileGroup);

        for (Manager manager : managerGroup.getManagers()) {
            manager.init();
        }
    }

    void initInterfaces() {
        new DomainReader().init(managerGroup);
        new DomainRequester().init(managerGroup);
    }

    void initUI(ViewManager viewManager, Stage stage) {
        if (viewManager instanceof GUIManager) {
            ((GUIManager) viewManager).init(stage);
        } else if (viewManager instanceof CLIManager) {
            System.out.println("CLI");
        }
        managerGroup.add(viewManager);
        this.viewManager = viewManager;
    }

    void update() {
        for (Manager c : managerGroup.getManagers()) {
            c.update();
        }

        viewManager.update();
    }
}
