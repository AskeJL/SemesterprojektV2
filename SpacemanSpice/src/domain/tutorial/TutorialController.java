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

    private static int counter = 0;

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
    }

    public static void update() {

        switch (counter) {
            case 0:
                TutorialData.printText(introduction);
                counter++;

                break;
            case 1:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                    TutorialData.printText(aIintro1);
                    counter++;
                }
                break;
            case 2:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                    TutorialData.printText(aIintro2);
                    counter++;
                }
                break;
            case 3:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                    TutorialData.printText(aIintro3);
                    counter++;
                }
                break;
            case 4:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("show") && InteractionsController.getLastParameter().equals("map")) {
                    TutorialData.printText(aIintro4);
                    counter++;
                }
                break;
            case 5:
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")) {
                    TutorialData.printText(aIintro5);
                    counter++;
                }
                break;
            case 6:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Scanning Control") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")) {
                    TutorialData.printText(aIintro6);
                    counter++;
                }
                break;
            case 7: 
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")){
                    TutorialData.printText(aIintro7);
                }
                break;
            case 8:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Laser Controls") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")){
                    TutorialData.printText(aIintro8);
                    counter++;
                }
                break;
            case 13:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Net Control") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")){
                   TutorialData.printText(aIintro8);
                   counter++;
                }
                break;
            case 9:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Control Steering") &&InteractionsController.getLastCommandName().equalsIgnoreCase("interact")){
                    TutorialData.printText(aIintro9);
                    counter++;
                }
                break;
            case 10:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Outside") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")){
                    TutorialData.printText(aIintro10);
                    counter++;
                }
                break;
            case 11:
                if (LocationsController.getCurrentRoom().getName().equalsIgnoreCase("Oxygen Refuel") && InteractionsController.getLastCommandName().equalsIgnoreCase("interact")){
                    TutorialData.printText(aIintro11);
                    counter++;
                }
                break;
        }
    }
}
