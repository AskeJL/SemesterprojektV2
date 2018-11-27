package domain.tutorial;

import data.AssetType;
import data.Data;
import domain.game.Controller;
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
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        tutorialData.println(aIintro1);
                        InteractionsController.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 2:
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        tutorialData.println(aIintro2);
                        InteractionsController.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 3:
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        tutorialData.println(aIintro3);
                        InteractionsController.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 4:
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("show") && InteractionsController.getLastParameter().equals("map")) {
                        tutorialData.println(aIintro4);
                        counter++;
                    }
                    break;
                case 5:
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        tutorialData.println(aIintro5);
                        counter++;
                    }
                    break;
                case 6:
                    if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Scanning Control") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        tutorialData.println(aIintro6);
                        counter++;
                    }
                    break;
                case 7:
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        tutorialData.println(aIintro7);
                        counter++;
                    }
                    break;
                case 8:
                    if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Laser Controls") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        tutorialData.println(aIintro8);
                        counter++;
                    }
                    break;
                case 9:
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        tutorialData.println(aIintro9);
                        counter++;
                    }
                    break;
                case 10:
                    if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Net Control") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        tutorialData.println(aIintro10);
                        counter++;
                    }
                    break;
                case 11:
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        tutorialData.println(aIintro11);
                        counter++;
                    }
                    break;
                case 12:
                    if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Control Steering") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        tutorialData.println(aIintro12);
                        counter++;
                    }
                    break;
                case 13:
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        tutorialData.println(aIintro13);
                        counter++;
                    }
                    break;
                case 14:
                    if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Outside") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        tutorialData.println(aIintro14);
                        counter++;
                    }
                    break;
                case 15:
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("show") && InteractionsController.getLastParameter().equals("oxygen")) {
                        tutorialData.println(aIintro15);
                        counter++;
                    }
                    break;
                case 16:
                    if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Oxygen Refuel") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                        tutorialData.println(aIintro16);
                        counter++;
                    }
                    break;
                case 17:
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                        tutorialData.println(aIintro17);
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
            InteractionsController.println(string);
        }
    }
    
    public boolean getTutorial() {
        return this.tutorial;
    }

    public void setTutorial(boolean bool) {
        this.tutorial = bool;
    }
}
