package domain.tutorial;

import domain.game.Controller;
import domain.interactions.InteractionsController;
import domain.locations.LocationsController;
import java.util.List;

public class TutorialController extends Controller {

    private static List<String> introduction;
    private static List<String> aIintro1;
    private static List<String> aIintro2;

    private static boolean continuing = false;
    
    private static boolean tutorial1 = false;
    private static boolean tutorial2 = false;
    private static boolean tutorial3 = false;
    private static boolean tutorial4 = false;
    private static boolean tutorial5 = false;
    private static boolean tutorial6 = false;
    private static boolean tutorial7 = false;

    public static void init() {
        introduction = TutorialData.getTextString("Introduction.txt");
        aIintro1 = TutorialData.getTextString("AI_Intro1.txt");
    }

    public static void update() {
        if(continuing == true && counter = 0){
            
        }
        
        
        
        
        if (tutorial1) {
            TutorialData.printText(introduction);
            tutorial1 = false;
            tutorial2 = true;
        }
        if (tutorial2 && LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Scanning Control") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
            System.out.println("Good job");
            System.out.println("Now go to the laser and try that out");
            tutorial2 = false;
            tutorial3 = true;
        }
        if (tutorial3 && LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Laser Controls") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
            System.out.println("Good job");
            System.out.println("Now you need to go to the net room");
            tutorial3 = false;
            tutorial4 = true;
        }
        if (tutorial4 && LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Net Control") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
            System.out.println("Good job");
            System.out.println("Now you need to go to the sterring");
            tutorial4 = false;
            tutorial5 = true;
        }
        if (tutorial5 && LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Control Steering") &&InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
            System.out.println("Good job");
            System.out.println("Now you need to go outside");
            tutorial5 = false;
            tutorial6 = true;
        }
        if (tutorial6 && LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Outside") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
            System.out.println("Good job");
            System.out.println("Now you need to go to the oxygen reefil");
            tutorial6 = false;
            tutorial7 = true;
        }
        if (tutorial7 && LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Outside") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
            System.out.println("Good job");
            System.out.println("You have now tried all functions on the ship");
            System.out.println("Enter start when you are ready to begin the game");
            tutorial7 = false;
        }
    }
    
    public static void getContinuing(){
        
    }
    
    public static void setContinuing(){
        continuing = true;
    }
}
