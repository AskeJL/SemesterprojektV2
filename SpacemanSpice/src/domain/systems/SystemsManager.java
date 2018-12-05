package domain.systems;

import data.AssetType;
import data.Data;
import domain.Controller;
import domain.DomainReader;
import domain.GameElement;
import domain.GameUpdateable;
import domain.interactions.InteractionsManager;
import domain.resources.Life;
import domain.resources.ResourcesManager;
import domain.resources.Time;
import java.util.List;

public class SystemsManager extends Controller implements GameUpdateable {
    
    private final DomainReader reader = new DomainReader();
    
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
    private boolean playerReady = false;

    /**
     * Whether or not a small fragment should be destroyed in the next update.
     */
    private boolean smallFragmentDestroyed = false;
    /**
     * Whether or not a medium fragment should be destroyed in the next update.
     */
    private boolean mediumFragmentDestroyed = false;
    /**
     * Whether or not a large fragment should be destroyed in the next update.
     */
    private boolean largeFragmentDestroyed = false;
    
    private int intro = 1;
    
    private List<String> finalIntro;
    private List<String> newWaveIncoming;
    private List<String> waveHit;
    
    private final Data data = new Data();
    
    private Wave wave;
    private Score score;
    private ResourcesManager resourcesManager;
    private InteractionsManager interactionsManager;
    
    public SystemsManager() {

    }

    public SystemsManager(List<GameElement> elements) {
        super(elements);
    }
    
    /**
     * Initialize the {@link domain.game.Controller controller}. Will initialize
     * needed classes.
     */
    @Override
    public void init() {
        this.wave = (Wave)super.getGameElement(Wave.class);
        this.score = (Score)super.getGameElement(Score.class);
        this.resourcesManager = (ResourcesManager)super.getGameElement(ResourcesManager.class);
        this.interactionsManager = (InteractionsManager)super.getGameElement(InteractionsManager.class);
        
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
        Time time = resourcesManager.getTime();
        Life life = resourcesManager.getLife();
        
        if (playerReady) {
            
            switch (intro) {
                case 1:
                    println(finalIntro);
                    intro++;
                case 2: 
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue")){
                        intro++;
                    }
            }
            
            if (time.getCurrentTime() >= time.getWaveTime() && intro == 3) {
                if (wave.getSmallFragments() > 0 || wave.getMediumFragments() > 0 || wave.getLargeFragments() > 0) {
                    life.decreaseValue(wave.getSmallFragments(), wave.getMediumFragments(), wave.getLargeFragments());
                    println(waveHit);
                    wave.setSmallFragments(0);
                    wave.setMediumFragments(0);
                    wave.setLargeFragments(0);
                }
                
                if (time.getCurrentTime() >= time.getRandomTime() + time.getWaveTime()){
                    wave.incrementNumberOfWaves();
                    wave.createWave();
                    println(newWaveIncoming);
                }
            }

            if (smallFragmentDestroyed && intro == 3) {
                score.update(1);
                wave.updateWave(1);
                setSmallFragmentDestroyed(false);
            }
            if (mediumFragmentDestroyed && intro == 3) {
                score.update(2);
                wave.updateWave(2);
                setMediumFragmentDestroyed(false);
            }
            if (largeFragmentDestroyed && intro == 3) {
                score.update(3);
                wave.updateWave(3);
                setLargeFragmentDestroyed(false);
            }
        }
    }

    /**
     * Set the {@link #smallFragmentDestroyed} boolean.
     *
     * @param bool
     */
    public void setSmallFragmentDestroyed(boolean bool) {
        smallFragmentDestroyed = bool;
    }

    /**
     * Set the {@link #mediumFragmentDestroyed} boolean.
     *
     * @param bool
     */
    public void setMediumFragmentDestroyed(boolean bool) {
        mediumFragmentDestroyed = bool;
    }

    /**
     * Set the {@link #largeFragmentDestroyed} boolean.
     *
     * @param bool
     */
    public void setLargeFragmentDestroyed(boolean bool) {
        largeFragmentDestroyed = bool;
    }

    /**
     * Set the {@link #playerReady} boolean.
     *
     * @param bool
     */
    public void setPlayerReady(boolean bool) {
        playerReady = bool;
    }

    private List<String> getTextString(String filename) {
        return data.requestData(AssetType.TEXT, filename);
    }
    
    private List<String> getAIString(String filename) {
        return data.requestData(AssetType.AIWAVE, filename);
    }
    
    private void println(List<String> text) {
        for(String line : text) {
            reader.storeln(line);
        }
    }
    
    /**
     * Get {@link #SMALL_FRAGMENT_IDENTIFIER}.
     *
     * @return
     */
    public int getSmallFragmentIdentifier() {
        return SMALL_FRAGMENT_IDENTIFIER;
    }

    /**
     * Get {@link #MEDIUM_FRAGMENT_IDENTIFIER}.
     *
     * @return
     */
    public int getMediumFragmentIdentifier() {
        return MEDIUM_FRAGMENT_IDENTIFIER;
    }

    /**
     * Get {@link #LARGE_FRAGMENT_IDENTIFIER}.
     *
     * @return
     */
    public int getLargeFragmentIdentifier() {
        return LARGE_FRAGMENT_IDENTIFIER;
    }

    /**
     * Get {@link Wave#smallFragments}.
     *
     * @return
     */
    public int getSmallFragments() {
        return wave.getSmallFragments();
    }

    /**
     * Get {@link Wave#mediumFragments}.
     *
     * @return
     */
    public int getMediumFragments() {
        return wave.getMediumFragments();
    }

    /**
     * Get {@link Wave#largeFragments}.
     *
     * @return
     */
    public int getLargeFragments() {
        return wave.getLargeFragments();
    }
    
    /**
     * Get {@link Wave#numberOfWaves}.
     * 
     * @return 
     */
    public int getNumberOfWaves(){
        return wave.getNumberofWaves();
    }
    /**
     * Get {@link Score#score}.
     *
     * @return
     */
    public Score getScore() {
        return this.score;
    }

    /**
     * Get {@link #playerReady}.
     *
     * @return
     */
    public boolean getPlayerReady() {
        return this.playerReady;
    }
}
