package domain.systems;

import data.AssetType;
import data.Data;
import domain.game.Controller;
import domain.interactions.InteractionsController;
import domain.resources.ResourcesController;
import domain.game.Game;
import java.util.List;

/**
 * The main controller for the domain.systems package. This will control all the
 * other classes within the package.
 *
 * @see Score
 * @see Wave
 */
public class SystemsController extends Controller {

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
    
    private static int intro = 1;
    
    private static List<String> finalIntro;
    private static List<String> newWaveIncoming;
    private static List<String> waveHit;
    
    private Data data = new Data();

    public SystemsController(Game game) {
        super(game);
    }
    
    /**
     * Initialize the {@link domain.game.Controller controller}. Will initialize
     * needed classes.
     */
    @Override
    public void init() {
        finalIntro = getTextString("Finalintro.txt");
        newWaveIncoming = getAIString("newWaveIncoming" + (int)(Math.random() * 3 + 1) + ".txt");
        waveHit = getAIString("waveHit" + (int)(Math.random() * 3 + 1) + ".txt");
    }

    /**
     * Update the {@link domain.game.Controller controller}. If
     * {@link #playerReady playerReady} is true, the {@link Wave} will begin.
     * <p>
     * This checks for fragment destruction and when the {@link Wave}s start and
     * end.
     */
    @Override
    public void update() {
        if (playerReady) {
            
            switch (intro) {
                case 1:
                    printText(finalIntro);
                    intro++;
                case 2: 
                    if (InteractionsController.getLastCommandName().equalsIgnoreCase("continue")){
                        intro++;
                    }
            }
            
            if (ResourcesController.getCurrentTime() >= ResourcesController.getWaveTime() && intro == 3) {
                if (Wave.getSmallFragments() > 0 || Wave.getMediumFragments() > 0 || Wave.getLargeFragments() > 0) {
                    ResourcesController.decreaseLife(Wave.getSmallFragments(), Wave.getMediumFragments(), Wave.getLargeFragments());
                    printText(waveHit);
                    Wave.setSmallFragments(0);
                    Wave.setMediumFragments(0);
                    Wave.setLargeFragments(0);
                }
                
                if (ResourcesController.getCurrentTime() >= ResourcesController.getRandTime() + ResourcesController.getWaveTime()){
                    Wave.incrementNumberOfWaves();
                    Wave.createWave();
                    printText(newWaveIncoming);
                }
            }

            if (smallFragmentDestroyed && intro == 3) {
                Score.updateScore(1);
                Wave.updateWave(1);
                setSmallFragmentDestroyed(false);
            }
            if (mediumFragmentDestroyed && intro == 3) {
                Score.updateScore(2);
                Wave.updateWave(2);
                setMediumFragmentDestroyed(false);
            }
            if (largeFragmentDestroyed && intro == 3) {
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

    private List<String> getTextString(String filename) {
        return data.requestData(AssetType.TEXT, filename);
    }
    
    private List<String> getAIString(String filename) {
        return data.requestData(AssetType.AIWAVE, filename);
    }
    
    private void printText(List<String> text) {
        for(String line : text) {
            InteractionsController.println(line);
        }
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
     * Get {@link Wave#numberOfWaves}.
     * 
     * @return 
     */
    public static int getNumberOfWaves(){
        return Wave.getNumberofWaves();
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
