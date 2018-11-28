package domain.tutorial;

import data.AssetType;
import data.Data;
import domain.game.Controller;
import domain.game.DomainOutput;
import domain.game.Game;
import domain.interactions.InteractionsController;
import domain.interactions.commands.Clear;
import domain.locations.LocationsController;
import java.util.List;

/**
 * The main controller for the domain.tutorial package. This will control all
 * the other classes within the package.
 *
 * @see TutorialData
 */
public class TutorialController extends Controller {

    private final InteractionsController interactionsController;
    private final LocationsController locationsController;
    private final DomainOutput output = new DomainOutput();
    
    public TutorialController(Game game) {
        super(game);
        interactionsController = (InteractionsController)game.getController(new InteractionsController(game));
        locationsController = (LocationsController)game.getController(new LocationsController(game));
    }
    
    private List<String> introduction,
            aIintro1,
            aIintro2,
            aIintro3,
            aIintro4,
            aIintro5,
            aIintro6,
            aIintro7,
            aIintro8,
            aIintro9,
            aIintro10,
            aIintro11,
            aIintro12,
            aIintro13,
            aIintro14,
            aIintro15,
            aIintro16,
            aIintro17;

    private int counter = 0;
    private boolean tutorial = true;

    /**
     * Pre-load all the introduction files. Uses the
     * {@link TutorialData#getTextString(java.lang.String)} to get the files.
     */
    @Override
    public void init() {
        introduction = getTextToString("Introduction.txt");
        aIintro1 = getTextToString("AI_Intro1.txt");
        aIintro2 = getTextToString("AI_Intro2.txt");
        aIintro3 = getTextToString("AI_Intro3.txt");
        aIintro4 = getTextToString("AI_Intro4.txt");
        aIintro5 = getTextToString("AI_Intro5.txt");
        aIintro6 = getTextToString("AI_Intro6.txt");
        aIintro7 = getTextToString("AI_Intro7.txt");
        aIintro8 = getTextToString("AI_Intro8.txt");
        aIintro9 = getTextToString("AI_Intro9.txt");
        aIintro10 = getTextToString("AI_Intro10.txt");
        aIintro11 = getTextToString("AI_Intro11.txt");
        aIintro12 = getTextToString("AI_Intro12.txt");
        aIintro13 = getTextToString("AI_Intro13.txt");
        aIintro14 = getTextToString("AI_Intro14.txt");
        aIintro15 = getTextToString("AI_Intro15.txt");
        aIintro16 = getTextToString("AI_Intro16.txt");
        aIintro17 = getTextToString("AI_Intro17.txt");
    }

    /**
     * Check how far the player has come in the introduction. Will use
     * {@link TutorialData#println(List)} to print the next dialog for the
     * player.
     */
    @Override
    public void update() {
        if (tutorial) {
            switch (counter) {
                case 0:
                    println(introduction);
                    counter++;

                    break;
                case 1:
                    if (interactionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro1);
                        interactionsController.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 2:
                    if (interactionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro2);
                        interactionsController.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 3:
                    if (interactionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro3);
                        interactionsController.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 4:
                    if (interactionsController.getLastCommandName().equalsIgnoreCase("show") && interactionsController.getLastParameter().equals("map")) {
                        println(aIintro4);
                        counter++;
                    }
                    break;
                case 5:
                    if (interactionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro5);
                        counter++;
                    }
                    break;
                case 6:
                    if (locationsController.getCurrentRoom().getName().equalsIgnoreCase("Scanning Control") && interactionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro6);
                        counter++;
                    }
                    break;
                case 7:
                    if (interactionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro7);
                        counter++;
                    }
                    break;
                case 8:
                    if (locationsController.getCurrentRoom().getName().equalsIgnoreCase("Laser Controls") && interactionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro8);
                        counter++;
                    }
                    break;
                case 9:
                    if (interactionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro9);
                        counter++;
                    }
                    break;
                case 10:
                    if (locationsController.getCurrentRoom().getName().equalsIgnoreCase("Net Control") && interactionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro10);
                        counter++;
                    }
                    break;
                case 11:
                    if (interactionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro11);
                        counter++;
                    }
                    break;
                case 12:
                    if (locationsController.getCurrentRoom().getName().equalsIgnoreCase("Control Steering") && interactionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro12);
                        counter++;
                    }
                    break;
                case 13:
                    if (interactionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro13);
                        counter++;
                    }
                    break;
                case 14:
                    if (locationsController.getCurrentRoom().getName().equalsIgnoreCase("Outside") && interactionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro14);
                        counter++;
                    }
                    break;
                case 15:
                    if (interactionsController.getLastCommandName().equalsIgnoreCase("show") && interactionsController.getLastParameter().equals("oxygen")) {
                        println(aIintro15);
                        counter++;
                    }
                    break;
                case 16:
                    if (locationsController.getCurrentRoom().getName().equalsIgnoreCase("Oxygen Refuel") && interactionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro16);
                        counter++;
                    }
                    break;
                case 17:
                    if (interactionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro17);
                        counter++;
                        setTutorial(false);
                    }
                    break;
            }
        }
    }

    private final Data data = new Data();
    
    /**
     * Request data from the data-layer using
     * {@link TutorialData#requestData(data.AssetType, java.lang.String)}.
     *
     * @param filename The name of the file.
     * @return
     */
    List<String> getTextToString(String filename) {
        return data.requestData(AssetType.TEXT, filename);
    }

    /**
     * Print a List of Strings to the console.
     *
     * @param text List to print.
     */
    void println(List<String> text) {
        for (String string : text) {
            output.println(string);
        }
    }
    
    public boolean getTutorial() {
        return this.tutorial;
    }

    public void setTutorial(boolean bool) {
        this.tutorial = bool;
    }
}
