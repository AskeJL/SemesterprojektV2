
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
        managers.add(tutorialManager);
        managers.add(interactionsManager);
        managers.add(locationsManager);
        managers.add(resourcesManager);
        managers.add(systemsManager);
        managers.add(tileManager);

        managerGroup = new ManagerGroup(managers);

        for (Manager c : managerGroup.getControllers()) {
            c.init(managerGroup);
        } 
        
        // Create the necessary classes for domain
        Time time = new Time();
        Life life = new Life();
        Oxygen oxygen = new Oxygen(resourcesManager, locationsManager);

        Commands commands = new Commands(locationsManager, interactionsManager, resourcesManager, systemsManager, tutorialManager);
        Parser parser = new Parser(commands);

        Score score = new Score(systemsManager);
        Wave wave = new Wave(resourcesManager, systemsManager);

        // Create Resources package
        List<GameElement> resourcesElements = new ArrayList<>();
        resourcesElements.add(time);
        resourcesElements.add(life);
        resourcesElements.add(oxygen);
        resourcesManager.setElements(resourcesElements);

        // Create Interactions package.
        List<GameElement> interactionsElements = new ArrayList<>();
        interactionsElements.add(commands);
        interactionsElements.add(parser);
        interactionsManager.setElements(interactionsElements);

        // Create Systems package.
        List<GameElement> systemsElements = new ArrayList<>();
        systemsElements.add(score);
        systemsElements.add(wave);
        systemsElements.add(resourcesManager);
        systemsElements.add(interactionsManager);
        systemsManager.setElements(systemsElements);

        // Create Tutorial package.
        List<GameElement> tutorialElements = new ArrayList<>();
        tutorialElements.add(interactionsManager);
        tutorialElements.add(locationsManager);
        tutorialManager.setElements(tutorialElements);

        
        for (Manager c : managerGroup.getControllers()) {
            c.init();
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
        for (Manager c : managerGroup.getControllers()) {
            c.update();
        }

        viewManager.update();
    }
}
