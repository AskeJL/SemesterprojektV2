package domain.tutorial;

import domain.game.Controller;
import domain.interactions.InteractionsController;
import domain.locations.LocationsController;
import java.util.List;

public class TutorialController extends Controller {

    private static List<String> introduction;
    private static List<String> aIintro1;
    private static List<String> aIintro2;
    private static List<String> aIintro3;
    private static List<String> aIintro4;
    private static List<String> aIintro5;
    private static List<String> aIintro6;
    private static List<String> aIintro7;
    private static List<String> aIintro8;
    private static List<String> aIintro9;
    private static List<String> aIintro10;
    private static List<String> aIintro11;
    private static List<String> aIintro12;
    private static List<String> aIintro13;
    private static List<String> aIintro14;
    private static List<String> aIintro15;
    private static List<String> aIintro16;
    private static List<String> aIintro17;

    private static int counter = 0;
    private static boolean tutorial = true;

    public static void init() {
        introduction = TutorialData.getTextString("Introduction.txt");
        aIintro1 = TutorialData.getTextString("AI_Intro1.txt");
        aIintro2 = TutorialData.getTextString("AI_Intro2.txt");
        aIintro3 = TutorialData.getTextString("AI_Intro3.txt");
        aIintro4 = TutorialData.getTextString("AI_Intro4.txt");
        aIintro5 = TutorialData.getTextString("AI_Intro5.txt");
        aIintro6 = TutorialData.getTextString("AI_Intro6.txt");
        aIintro7 = TutorialData.getTextString("AI_Intro7.txt");
        aIintro8 = TutorialData.getTextString("AI_Intro8.txt");
        aIintro9 = TutorialData.getTextString("AI_Intro9.txt");
        aIintro10 = TutorialData.getTextString("AI_Intro10.txt");
        aIintro11 = TutorialData.getTextString("AI_Intro11.txt");
        aIintro12 = TutorialData.getTextString("AI_Intro12.txt");
        aIintro13 = TutorialData.getTextString("AI_Intro13.txt");
        aIintro14 = TutorialData.getTextString("AI_Intro14.txt");
        aIintro15 = TutorialData.getTextString("AI_Intro15.txt");
        aIintro16 = TutorialData.getTextString("AI_Intro16.txt");
        aIintro17 = TutorialData.getTextString("AI_Intro17.txt");
    }

    public static void update() {

        switch (counter) {
            case 0:
                TutorialData.printText(introduction);
                counter++;

                break;
            case 1:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue") && tutorial == true) {
                    TutorialData.printText(aIintro1);
                    counter++;
                }
                break;
            case 2:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue") && tutorial == true) {
                    TutorialData.printText(aIintro2);
                    counter++;
                }
                break;
            case 3:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue") && tutorial == true) {
                    TutorialData.printText(aIintro3);
                    counter++;
                }
                break;
            case 4:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("show") && InteractionsController.getLastParameter().equals("map") && tutorial == true) {
                    TutorialData.printText(aIintro4);
                    counter++;
                }
                break;
            case 5:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue") && tutorial == true) {
                    TutorialData.printText(aIintro5);
                    counter++;
                }
                break;
            case 6:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Scanning Control") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact") && tutorial == true) {
                    TutorialData.printText(aIintro6);
                    counter++;
                }
                break;
            case 7: 
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue") && tutorial == true){
                    TutorialData.printText(aIintro7);
                    counter++;
                }
                break;
            case 8:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Laser Controls") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact") && tutorial == true){
                    TutorialData.printText(aIintro8);
                    counter++;
                }
                break;
            case 9:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue") && tutorial == true){
                    TutorialData.printText(aIintro9);
                    counter++;
                }
                break;
            case 10:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Net Control") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact") && tutorial == true){
                   TutorialData.printText(aIintro10);
                   counter++;
                }
                break;
            case 11:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue") && tutorial == true){
                    TutorialData.printText(aIintro11);
                    counter++;
                }
                break;   
            case 12:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Control Steering") &&InteractionsController.getLastCommandName().equalsIgnoreCase("interact") && tutorial == true){
                    TutorialData.printText(aIintro12);
                    counter++;
                }
                break;
            case 13:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue") && tutorial == true){
                    TutorialData.printText(aIintro13);
                    counter++;
                }
                break;
            case 14:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Outside") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact") && tutorial == true){
                    TutorialData.printText(aIintro14);
                    counter++;
                }
                break;
            case 15:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("show") && InteractionsController.getLastParameter().equals("oxygen") && tutorial == true){
                    TutorialData.printText(aIintro15);
                    counter++;
                }
                break;
            case 16:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Oxygen Refuel") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact") && tutorial == true){
                    TutorialData.printText(aIintro16);
                    counter++;
                }
                break;
            case 17:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue") && tutorial == true){
                    TutorialData.printText(aIintro17);
                    counter++;
                    TutorialController.setTutorial(false);
                }
                break;
        }
    }
    public static void getTutorial(){
        
    }
    public static void setTutorial(boolean bool){
        tutorial = bool;
    }
}
