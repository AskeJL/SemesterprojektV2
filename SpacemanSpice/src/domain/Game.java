/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package domain;

import domain.locations.LocationsManager;
import domain.interactions.Commands;
import domain.interactions.Parser;
import domain.interactions.InteractionsManager;
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

    private ControlGroup controlGroup;
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
        LocationsManager locationsManager = new LocationsManager();
        ResourcesManager resourcesManager = new ResourcesManager();
        InteractionsManager interactionsManager = new InteractionsManager();
        SystemsManager systemsManager = new SystemsManager();
        TutorialManager tutorialManager = new TutorialManager();

        Time time = new Time();
        Life life = new Life();
        Oxygen oxygen = new Oxygen(resourcesManager, locationsManager);

        Commands commands = new Commands(locationsManager, interactionsManager, resourcesManager, systemsManager);
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

        // Add to controller list
        List<Controller> controllers = new ArrayList<>();
        controllers.add(tutorialManager);
        controllers.add(interactionsManager);
        controllers.add(locationsManager);
        controllers.add(resourcesManager);
        controllers.add(systemsManager);

        controlGroup = new ControlGroup(controllers);

        for (Controller c : controlGroup.getControllers()) {
            c.init();
        }
    }

    void initInterfaces() {
        new DomainReader().init(controlGroup);
        new DomainRequester().init(controlGroup);
    }

    void initUI(ViewManager viewManager, Stage stage) {
        if (viewManager instanceof GUIManager) {
            ((GUIManager) viewManager).init(stage);
        } else if (viewManager instanceof CLIManager) {
            System.out.println("CLI");
        }

        this.viewManager = viewManager;
    }

    void update() {
        for (Controller c : controlGroup.getControllers()) {
            c.update();
        }

        viewManager.update();
    }
}
