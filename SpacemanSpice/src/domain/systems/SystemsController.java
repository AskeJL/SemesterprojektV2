package domain.systems;

import data.read.DataReader;
import domain.game.Controller;
import domain.resources.ResourcesController;
import java.util.List;

/**
 * The main controller for the domain.systems package. This will control all the
 * other classes within the package.
 *
 * @see Score
 * @see Wave
 */
public class SystemsController extends Controller implements DataReader {

    /**
     * The identifier for a small fragment. (1)
     */
    private final static int SMALL_FRAGMENT_IDENTIFIER = 1;
    /**
     * The identifier for a medium fragment. (2)
     */
    private final static int MEDIUM_FRAGMENT_IDENTIFIER = 2;
    /**
     * The identifier for a large fragment. (3)
     */
    private final static int LARGE_FRAGMENT_IDENTIFIER = 3;

    /**
     * Whether or not the player is ready to start the {@link Wave}.
     */
    private static boolean playerReady = false;

    /**
     * Whether or not a small fragment should be destroyed in the next update.
     */
    private static boolean smallFragmentDestroyed = false;
    /**
     * Whether or not a medium fragment should be destroyed in the next update.
     */
    private static boolean mediumFragmentDestroyed = false;
    /**
     * Whether or not a large fragment should be destroyed in the next update.
     */
    private static boolean largeFragmentDestroyed = false;
    
    private static List<String> newWaveIncoming;
    private static List<String> waveHit;

    /**
     * Initialize the {@link domain.game.Controller controller}. Will initialize
     * needed classes.
     */
    public static void init() {
        newWaveIncoming = SystemsData.getTextString("newWaveIncoming.txt");
        waveHit = SystemsData.getTextString("waveHit.txt");
    }

    /**
     * Update the {@link domain.game.Controller controller}. If
     * {@link #playerReady playerReady} is true, the {@link Wave} will begin.
     * <br><br>
     * This checks for fragment destruction and when the {@link Wave}s start and
     * end.
     */
    public static void update() {
        if (playerReady) {
            if (ResourcesController.getCurrentTime() >= ResourcesController.getWaveTime()) {
                if (Wave.getSmallFragments() > 0 || Wave.getMediumFragments() > 0 || Wave.getLargeFragments() > 0) {
                    ResourcesController.decreaseLife(Wave.getSmallFragments(), Wave.getMediumFragments(), Wave.getLargeFragments());
                    SystemsData.printText(waveHit);
                }
                ResourcesController.setRandTime();
                System.out.println(ResourcesController.getRandTime());
                Wave.incrementNumberOfWaves();
                Wave.createWave();
                SystemsData.printText(newWaveIncoming);
                ResourcesController.getInitTime();
            }

            if (smallFragmentDestroyed) {
                Score.updateScore(1);
                Wave.updateWave(1);
                setSmallFragmentDestroyed(false);
            }
            if (mediumFragmentDestroyed) {
                Score.updateScore(2);
                Wave.updateWave(2);
                setMediumFragmentDestroyed(false);
            }
            if (largeFragmentDestroyed) {
                Score.updateScore(3);
                Wave.updateWave(3);
                setLargeFragmentDestroyed(false);
            }
        }
    }

    /**
     * Set the {@link #smallFragmentDestroyed} boolean.
     *
     * @param bool
     */
    public static void setSmallFragmentDestroyed(boolean bool) {
        smallFragmentDestroyed = bool;
    }

    /**
     * Set the {@link #mediumFragmentDestroyed} boolean.
     *
     * @param bool
     */
    public static void setMediumFragmentDestroyed(boolean bool) {
        mediumFragmentDestroyed = bool;
    }

    /**
     * Set the {@link #largeFragmentDestroyed} boolean.
     *
     * @param bool
     */
    public static void setLargeFragmentDestroyed(boolean bool) {
        largeFragmentDestroyed = bool;
    }

    /**
     * Set the {@link #playerReady} boolean.
     *
     * @param bool
     */
    public static void setPlayerReady(boolean bool) {
        SystemsController.playerReady = bool;
    }

    /**
     * Get {@link #SMALL_FRAGMENT_IDENTIFIER}.
     *
     * @return
     */
    public static int getSmallFragmentIdentifier() {
        return SMALL_FRAGMENT_IDENTIFIER;
    }

    /**
     * Get {@link #MEDIUM_FRAGMENT_IDENTIFIER}.
     *
     * @return
     */
    public static int getMediumFragmentIdentifier() {
        return MEDIUM_FRAGMENT_IDENTIFIER;
    }

    /**
     * Get {@link #LARGE_FRAGMENT_IDENTIFIER}.
     *
     * @return
     */
    public static int getLargeFragmentIdentifier() {
        return LARGE_FRAGMENT_IDENTIFIER;
    }

    /**
     * Get {@link Wave#smallFragments}.
     *
     * @return
     */
    public static int getSmallFragments() {
        return Wave.getSmallFragments();
    }

    /**
     * Get {@link Wave#mediumFragments}.
     *
     * @return
     */
    public static int getMediumFragments() {
        return Wave.getMediumFragments();
    }

    /**
     * Get {@link Wave#largeFragments}.
     *
     * @return
     */
    public static int getLargeFragments() {
        return Wave.getLargeFragments();
    }

    /**
     * Get {@link Score#score}.
     *
     * @return
     */
    public static int getScore() {
        return Score.getScore();
    }

    /**
     * Get {@link #playerReady}.
     *
     * @return
     */
    public static boolean getPlayerReady() {
        return SystemsController.playerReady;
    }
}
