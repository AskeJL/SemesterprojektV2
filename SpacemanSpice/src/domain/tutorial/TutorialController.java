package domain.tutorial;

import domain.game.Controller;
import java.util.List;

public class TutorialController extends Controller {

    private static List<String> introduction;

    private static boolean tutorial01 = true;
    private static boolean tutorial02 = false;

    public static void init() {
        introduction = TutorialData.getTextString("Introduction.txt");
    }

    public static void update() {
        if (tutorial01) {
            for (String line : introduction) {
                System.out.println(line);
            }
            tutorial01 = false;
            tutorial02 = true;
        } else if(tutorial02) {
            System.out.println("Test");
        }
    }
}
