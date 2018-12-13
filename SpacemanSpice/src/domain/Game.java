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
import domain.sound.SoundManager;
import domain.sound.SoundPlayer;
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
import presentation.draw.DrawController;

/**
 * This works as the main class for the Game. It's from here all the classes are
 * created and, essentially, managed.
 * <p>
 * All initializations are called from here. These include:
 * {@link #initClasses()}, {@link #initInterfaces()}, {@link #initUI(presentation.ViewManager, javafx.stage.Stage)}.
 */
public class Game extends Application {

    /**
     * A group of all the {@link Manager}s that are instantiated to manage the
     * game.
     */
    private ManagerGroup managerGroup;

    /**
     * The {@link presentation.ViewManager} that will manage the presentation
     * layer.
     */
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

        for (Manager manager : managerGroup.getManagers()) {
            manager.init();
        }

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        }.start();
    }

    /**
     * Initialize the needed classes to run the game. This is necessary to
     * create links between the instances.
     * <p>
     *
     * Upon adding more classes({@link GameElement}), a {@link Manager} is
     * needed to manage the classes. An implementation could look like this:
     * <p>
     *
     * Create a {@link Manager} to manage some classes. InteractionsManager
     * interactions = new InteractionsManager();
     * <p>
     *
     * Create a {@link GameElementGroup} to place the
     * classes({@link GameElement}) in (the classes needs to inherited from
     * {@link GameElement}): GameElementGroup group = new GameElementGroup();
     * <p>
     *
     * Now add the {@link GameElement}s to the group: group.add(new class1());
     * <p>
     *
     * Link the {@link Manager} to the group:
     * interactions.{@link domain.Manager#setGameElementGroup(domain.GameElementGroup) setGameElementGroup(group)};
     * <p>
     *
     * If the {@link GameElement}s in the group needs to access other managers a
     * {@link ManagerGroup} needs to be assigned. Then the group proceeds to
     * call:
     * group.{@link domain.GameElementGroup#setManagerGroup(domain.ManagerGroup) setManagerGroup(domain.ManagerGroup)};
     *
     * @see Manager
     * @see ManagerGroup
     * @see GameElement
     * @see GameElementGroup
     */
    void initClasses() {
        // Create managers
        LocationsManager locationsManager = new LocationsManager();
        ResourcesManager resourcesManager = new ResourcesManager();
        InteractionsManager interactionsManager = new InteractionsManager();
        SystemsManager systemsManager = new SystemsManager();
        TutorialManager tutorialManager = new TutorialManager();
        TileManager tileManager = new TileManager();
        SoundManager soundManager = new SoundManager();

        // Add to manager list
        List<Manager> managers = new ArrayList<>();
        managers.add(interactionsManager);
        managers.add(locationsManager);
        managers.add(resourcesManager);
        managers.add(systemsManager);
        managers.add(tileManager);
        managers.add(tutorialManager);
        managers.add(soundManager);

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

        // Create Sound package
        GameElementGroup soundGroup = new GameElementGroup();
        soundGroup.setManagerGroup(managerGroup);
        soundGroup.add(new SoundPlayer());
        soundManager.setGameElementGroup(soundGroup);
    }

    /**
     * Initialize interfaces to access the domain layer. This is necessary for
     * the correct links between instances occur. It is also important, that
     * this is called after {@link Game#initClasses()}.
     *
     * @see DomainReader
     * @see DomainRequester
     */
    void initInterfaces() {
        new DomainReader().init(managerGroup);
        new DomainRequester().init(managerGroup);
    }

    /**
     * Initialize the presentation layer. This depends on what
     * {@link presentation.ViewManager} is given in the parameter. If it is an
     * instance of {@link presentation.GUIManager}, the presentation layer will
     * be build around that.
     * <p>
     * {@link presentation.CLIManager} is a work in progress and will not work.
     *
     * @param viewManager The ViewManager to manage the presentation layer.
     * @param stage The primary stage called from the
     * {@link Game#start(javafx.stage.Stage)}.
     */
    void initUI(ViewManager viewManager, Stage stage) {
        GameElementGroup group = new GameElementGroup();
        if (viewManager instanceof GUIManager) {
            group.setManagerGroup(managerGroup);
            group.add(new DrawController());
            viewManager.setGameElementGroup(group);

            managerGroup.add(viewManager);

            ((GUIManager) viewManager).setStage(stage);
        } else if (viewManager instanceof CLIManager) {
            System.out.println("CLI");
        }
        this.viewManager = viewManager;
    }

    /**
     * Update all the managers in the {@link Game#managerGroup}.
     */
    void update() {
        for (Manager c : managerGroup.getManagers()) {
            c.update();
        }
        viewManager.update();
    }
}
