package domain.tutorial;

import domain.game.Controller;
import domain.interactions.InteractionsController;
import java.util.List;

public class TutorialController extends Controller {

    private static List<String> introduction;
    private static List<String> aIintro1;
    private static List<String> aIintro2;
    private static List<String> aIintro3;
    private static List<String> aIintro4;
    private static List<String> aIintro5;
    private static List<String> aIintro6;

    private static int counter = 0;

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
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("help") && InteractionsController.getLastParameter().equals("show")) {
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
                if (InteractionsController.getLastCommandName().equalsIgnoreCase("help") && InteractionsController.getLastParameter().equals("interact")) {
                    TutorialData.printText(aIintro6);
                    counter++;
                }
                break;
        }
    }
}
