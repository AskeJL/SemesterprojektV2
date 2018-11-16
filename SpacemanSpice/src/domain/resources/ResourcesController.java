package domain.resources;

import domain.game.Controller;
import domain.systems.SystemsController;

/**
 * The main controller for the domain.resources package. This will control all
 * the other classes within the package.
 *
 * @see Life
 * @see Oxygen
 * @see Time
 */
public class ResourcesController extends Controller {

    /**
     * Initialize the {@link domain.game.Controller controller}. Will initialize
     * needed classes.
     */
    public static void init() {
        Time.init();

        Time.update();
        Oxygen.update();
    }

    /**
     * Update the {@link domain.game.Controller controller}.
     * <br><br>
     * As well as updating the some of the classes this will also look for
     * changes regarding {@link Life} and {@link Oxygen}. If one of them reaches
     * below 0, the {@link domain.game.Game} will end.
     */
    public static void update() {
        Time.update();
        Oxygen.update();
        if (Oxygen.getOxygen() <= 0) {
            System.out.println("You are out of oxygen. Too bad, you are dead..");
            System.out.println("Score: " + SystemsController.getScore());
            Controller.setRunning(false);
        }
        Life.update();
        if (Life.getLife() <= 0) {
            System.out.println("The ship is destroyed. Too bad, you are dead..");
            System.out.println("Score: " + SystemsController.getScore());
            Controller.setRunning(false);
        }
    }

    /**
     * Decrease the {@link Life} of the hull based on the amount of fragments.
     * This calls the {@link Life#decreaseLife(int, int, int)} method.
     *
     * @param hitSmallFragments Amount of small fragments that hit.
     * @param hitMediumFragments Amount of medium fragments that hit.
     * @param hitLargeFragments Amount of Large fragments that hit.
     */
    public static void decreaseLife(int hitSmallFragments, int hitMediumFragments, int hitLargeFragments) {
        Life.decreaseLife(hitSmallFragments, hitMediumFragments, hitLargeFragments);
    }

    /**
     * Increase the {@link Oxygen#oxygen} from {@link Oxygen}. Uses the
     * {@link Oxygen#increaseOxygen(int)} method.
     *
     * @param oxygen Amount to increase with.
     */
    public static void increaseOxygen(int oxygen) {
        Oxygen.increaseOxygen(oxygen);
    }

    public static void setRepairTrue() {
        Life.setRepairTrue();
    }

    public static void setWaveTime(long newWaveTime) {
        Time.setWaveTime(newWaveTime);
    }

    /**
     * Get the {@link Time#currentTime} from {@link Time}.
     *
     * @return
     */
    public static long getCurrentTime() {
        return Time.getCurrentTime();
    }

    /**
     * Get the {@link Time#initTime} from {@link Time}.
     *
     * @return
     */
    public static long getInitTime() {
        return Time.getInitTime();
    }

    /**
     * Get the {@link Oxygen#oxygen} from {@link Oxygen}.
     *
     * @return
     */
    public static int getOxygen() {
        return Oxygen.getOxygen();
    }

    /**
     * Get the {@link Life#life} from {@link Life}.
     *
     * @return
     */
    public static int getLife() {
        return Life.getLife();
    }

    /**
     * Get the {@link Time#getRemainingTime()} from {@link Time}.
     *
     * @return
     */
    public static long getRemainingTime() {
        return Time.getRemainingTime();
    }

    /**
     * Get the {@link Time#waveTime} from {@link Time}.
     *
     * @return
     */
    public static long getWaveTime() {
        return Time.getWaveTime();
    }
}
