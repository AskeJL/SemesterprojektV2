package domain.systems;

import domain.DomainReader;
import domain.GameElement;
import domain.GameElementGroup;
import domain.resources.ResourcesManager;
import domain.resources.Time;
import java.util.Random;

public class Wave extends GameElement {

    private final DomainReader reader = new DomainReader();

    /**
     * The number of waves the player has gone through (Including the one
     * currently within).
     */
    private static int numberOfWaves = 0;

    /**
     * How many small fragments there are in the wave.
     */
    private int smallFragments;
    /**
     * How many medium fragments there are in the wave.
     */
    private int mediumFragments;
    /**
     * How many large fragments there are in the wave.
     */
    private int largeFragments;

    /**
     * The max amount of randomly destroyed small fragments.
     */
    private final static int SMALL_DESTRUCTION_INDEX = 3;
    /**
     * The max amount of randomly destroyed medium fragments.
     */
    private final static int MEDIUM_DESCTRUCTION_INDEX = 2;
    /**
     * The max amount of randomly destroyed large fragments.
     */
    private final static int LARGE_DESCRUCTION_INDEX = 1;

    private boolean easy = true;
    private boolean hard = false;

    private final int MAX_AMOUNT_OF_LASER_SHOTS = 3;
    private int amountOfLaserShots;
    
    private final int NET_MAX_HEALTH = 100;
    private int netCurrentHealth;
    
    private boolean thrustersOn;
    
    private ResourcesManager resourcesManager;
    private SystemsManager systemsManager;
    
    @Override
    public void init() {
        GameElementGroup group = this.gameElementGroup;
        
        this.resourcesManager = (ResourcesManager) group.getManagerGroup().getManager(ResourcesManager.class);
        this.systemsManager = (SystemsManager) group.getManager();
        setAmountOfLaserShots(0);
        setNetCurrentHealth(getNET_MAX_HEALTH());
        setThrustersOn(false);
    }

    /**
     * Create the wave. This will use in-built formulas based on the
     * {@link #numberOfWaves} to compute the amount of fragments to create.
     *
     * @see domain.resources.ResourcesController#setWaveTime(long)
     */
    public void createWave() {
        Time time = resourcesManager.getTime();
        time.setWaveTime(time.getCurrentTime() + 120);
        Random random = new Random();
        if (easy == true) {
            smallFragments = (random.nextInt(3) + 1) * numberOfWaves;

            if (numberOfWaves % 2 == 0) {
                mediumFragments = numberOfWaves / 2;
            } else {
                mediumFragments = 0;
            }

            if (numberOfWaves % 3 == 0) {
                largeFragments = numberOfWaves / 3;
            } else {
                largeFragments = 0;
            }
        } else if (hard == true) {
            smallFragments = (random.nextInt(4) + 2) * numberOfWaves;
            mediumFragments = numberOfWaves / 2;
            if (numberOfWaves % 2 == 0) {
                largeFragments = numberOfWaves / 2;
            } else {
                largeFragments = 0;
            }
        } else {
            easy = true;
        }

        time.setRandomTime();
    }

    /**
     *
     * Update the amount of fragments based on the fragment identifiers.<br>
     * {@link SystemsController#SMALL_FRAGMENT_IDENTIFIER}<br>
     * {@link SystemsController#MEDIUM_FRAGMENT_IDENTIFIER}<br>
     * {@link SystemsController#LARGE_FRAGMENT_IDENTIFIER}<br>
     * <p>
     * Also randomized the amount of fragments destroyed when the player
     * interacts with the controllers. This depends on each of the fragments
     * {@link #SMALL_DESTRUCTION_INDEX}
     *
     * @see SystemsController
     * @param fragmentIdentifier
     */
    void updateWave(int fragmentIdentifier) {
        // Each if-statement can be refactored into a single method then called from a switch(fragmentIdentifier).
        if (fragmentIdentifier == systemsManager.getSmallFragmentIdentifier()) {
            int newIndex = smallFragments > SMALL_DESTRUCTION_INDEX ? SMALL_DESTRUCTION_INDEX : smallFragments;
            int destructionIndex = (int) (Math.random() * (newIndex + 1));
            smallFragments -= destructionIndex;

            if (destructionIndex > 1) {
                reader.storeln("You destroyed " + destructionIndex + " small fragments!");
            } else if (destructionIndex <= 0) {
                reader.storeln("You missed!");
            } else {
                reader.storeln("You destroyed " + destructionIndex + " small fragment!");
            }

            if (smallFragments < 0) {
                smallFragments = 0;
            }
        }

        if (fragmentIdentifier == systemsManager.getMediumFragmentIdentifier()) {
            int newIndex = mediumFragments > MEDIUM_DESCTRUCTION_INDEX ? MEDIUM_DESCTRUCTION_INDEX : mediumFragments;
            int destructionIndex = (int) (Math.random() * (newIndex + 1));
            mediumFragments -= destructionIndex;

            if (destructionIndex > 1) {
                reader.storeln("You caught " + destructionIndex + " medium fragments!");
            } else if (destructionIndex <= 0) {
                reader.storeln("You missed!");
            } else {
                reader.storeln("You caught " + destructionIndex + " medium fragment!");
            }

            if (mediumFragments < 0) {
                mediumFragments = 0;
            }
        }

        if (fragmentIdentifier == systemsManager.getLargeFragmentIdentifier()) {
            largeFragments = 0;
            if (largeFragments < 0) {
                largeFragments = 0;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        return s;
    }

    /**
     * Increase {@link #numberOfWaves numberOfWaves} by 1.
     */
    public void incrementNumberOfWaves() {
        numberOfWaves++;
    }

    public void setSmallFragments(int smallValue) {
        smallFragments = 0;
    }

    /**
     * Get number of {@link #smallFragments smallFragments}.
     *
     * @return
     */
    public int getSmallFragments() {
        return smallFragments;
    }

    public void setMediumFragments(int mediumValue) {
        mediumFragments = 0;
    }

    public void setNumberOfWaves(int i) {
        numberOfWaves = i;
    }

    /**
     * Get number of {@link #mediumFragments mediumFragments}.
     *
     * @return
     */
    public int getMediumFragments() {
        return mediumFragments;
    }

    public void setLargeFragments(int largeValue) {
        largeFragments = 0;
    }

    /**
     * Get number of {@link #largeFragments largeFragments}.
     *
     * @return
     */
    public int getLargeFragments() {
        return largeFragments;
    }

    /**
     * Get number of waves {@link #numberOfWaves}.
     *
     *
     * @return
     */
    public int getNumberOfWaves() {
        return numberOfWaves;
    }
    
    public void setDifficultyEasy(){
        this.easy = true;
        this.hard = false;
    }
    
    public void setDifficultyHard(){
        this.hard = true;
        this.easy = false;
    }

    public int getMAX_AMOUNT_OF_LASER_SHOTS() {
        return MAX_AMOUNT_OF_LASER_SHOTS;
    }

    public int getAmountOfLaserShots() {
        return amountOfLaserShots;
    }

    public void setAmountOfLaserShots(int amountOfLaserShots) {
        this.amountOfLaserShots = amountOfLaserShots;
    }

    public int getNET_MAX_HEALTH() {
        return NET_MAX_HEALTH;
    }

    public int getNetCurrentHealth() {
        return netCurrentHealth;
    }

    public void setNetCurrentHealth(int netCurrentHealth) {
        this.netCurrentHealth = netCurrentHealth;
    }

    public boolean isThrustersOn() {
        return thrustersOn;
    }

    public void setThrustersOn(boolean thrustersOn) {
        this.thrustersOn = thrustersOn;
    }
}
