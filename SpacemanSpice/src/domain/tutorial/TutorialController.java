package domain.tutorial;

import domain.game.Controller;
import domain.interactions.InteractionsController;
import domain.locations.LocationsController;
import domain.interactions.Commands;
import java.util.List;

public class TutorialController extends Controller {

    private static List<String> introduction;
    private static List<String> aIintro1;
    private static List<String> aIintro2;
    private static List<String> aIintro3;
    private static List<String> aIintro4;
    private static List<String> aIintro5;
    private static List<String> aIintro6;

    private static boolean continuing = false;
    private static int counter = 0;
    
    private static boolean intro = true;
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
        aIintro2 = TutorialData.getTextString("AI_Intro2.txt");
        aIintro3 = TutorialData.getTextString("AI_Intro3.txt");
        aIintro4 = TutorialData.getTextString("AI_Intro4.txt");
        aIintro5 = TutorialData.getTextString("AI_Intro5.txt");
        aIintro6 = TutorialData.getTextString("AI_Intro6.txt");
    }

    public static void update() {
        
        if (intro) {
            TutorialData.printText(introduction);
            
            intro = false;
            continuing = true;
        }
        
        if(continuing == true && counter == 1){
                TutorialData.printText(aIintro1);
                continuing = false;
            } else if(continuing == true && counter == 2){
                TutorialData.printText(aIintro2);
                continuing = false;
            } else if(continuing == true && counter == 3){
                TutorialData.printText(aIintro3);
                continuing = false;
                tutorial1 = true;
            } else if(continuing == true && counter == 4){
                TutorialData.printText(aIintro5);
                continuing = false;
            }
        
        if(tutorial1){ //&& InteractionsController.getLastCommandName().equalsIgnoreCase("show") && Commands.getCommand.getCurrentParameter("map")){
            TutorialData.printText(aIintro4);
            
            tutorial1 = false;
            tutorial2 = true;
        }
        
        if (tutorial2 && LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Scanning Control") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
            TutorialData.printText(aIintro6);
            counter = 10;
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
        
        switch(counter){
            case 0: 
                counter = 1;
                break;
            case 1: 
                counter = 2;
                break;
            case 2:
                counter =3 ;
                break;
            case 3:
                counter = 4;
                break;
            case 10: 
                System.out.println("What.");
        }
        
    }
    
    public static void getContinuing(){
        
    }
    
    public static void setContinuing(){
        continuing = true;
    }  
}
