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
    
    /**
     * Boolean used to create an easy wave
     */
    private boolean easy = true;
    
    /**
     * Boolean used to create a hard wave
     */
    private boolean hard = false;
    
    /**
     * Int to set max amount of shots laser is available to play
     */
    private final int MAX_AMOUNT_OF_LASER_SHOTS = 3;
    /**
     * Int to decide how man shots that have been shot
     */
    private int amountOfLaserShots;
    
    /**
     * Int to set max net health
     */
    private final int NET_MAX_HEALTH = 100;
    /**
     * Int to net's current healt
     */
    private int netCurrentHealth;
    
    private ResourcesManager resourcesManager;
    private SystemsManager systemsManager;
    
    @Override
    public void init() {
        GameElementGroup group = this.gameElementGroup;
        
        this.resourcesManager = (ResourcesManager) group.getManagerGroup().getManager(ResourcesManager.class);
        this.systemsManager = (SystemsManager) group.getManager();
        setAmountOfLaserShots(0);
        setNetCurrentHealth(getNET_MAX_HEALTH());
    }

    /**
     * Create the wave. This will use in-built formulas based on the
     * {@link #numberOfWaves} to compute the amount of fragments to create.
     * Creates different waves based on wether {@link #easy} is true og {@link #hard} is true.
     *
     * @see #setDifficultyEasy() 
     * @see #setDifficultyHard() 
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
    
    /**
     * Sets {@link #smallFragments} to 0
     * 
     * @param smallValue 
     */
    public void setSmallFragments(int smallValue) {
        smallFragments = 0;
    }

    /**
     * Get number of {@link #smallFragments smallFragments}.
     *
     * @return number of small fragments
     */
    public int getSmallFragments() {
        return smallFragments;
    }
    
    /**
     * Sets {@link #mediumFragments} to 0
     * 
     * @param mediumValue 
     */
    public void setMediumFragments(int mediumValue) {
        mediumFragments = 0;
    }
    
    /**
     * Sets {@link #numberOfWaves} to i
     * 
     * @param i 
     */
    public void setNumberOfWaves(int i) {
        numberOfWaves = i;
    }

    /**
     * Get number of {@link #mediumFragments mediumFragments}.
     *
     * @return number of medium fragments
     */
    public int getMediumFragments() {
        return mediumFragments;
    }
    
    /**
     * Sets {@link #largeFragments} to 0
     * 
     * @param largeValue 
     */
    public void setLargeFragments(int largeValue) {
        largeFragments = 0;
    }

    /**
     * Get number of {@link #largeFragments largeFragments}.
     *
     * @return number of large fragments
     */
    public int getLargeFragments() {
        return largeFragments;
    }

    /**
     * Get number of waves {@link #numberOfWaves}.
     *
     * @return number of wave
     */
    public int getNumberOfWaves() {
        return numberOfWaves;
    }
    
    /**
     * Set diffiuclty booleans {@link #easy bool} and {@link #hard bool}
     * Used to make easy waves
     * 
     * @see #createWave() 
     */
    public void setDifficultyEasy(){
        this.easy = true;
        this.hard = false;
    }
    
    /**
     * Set diffiuclty booleans {@link #easy bool} and {@link #hard bool}
     * Used to make hard waves
     * 
     * @see #createWave() 
     */
    public void setDifficultyHard(){
        this.hard = true;
        this.easy = false;
    }
    
    /**
     * Get {@link #MAX_AMOUNT_OF_LASER_SHOTS}
     * 
     * @return max shots the laser can fire
     */
    public int getMAX_AMOUNT_OF_LASER_SHOTS() {
        return MAX_AMOUNT_OF_LASER_SHOTS;
    }
    
     /**
     * Get {@link #amountOfLaserShots}
     * Used to control laser
     * 
     * @return the number of time the laser has shoot
     * @see domain.locations.gameobjects.LaserArmingSystem
     */
    public int getAmountOfLaserShots() {
        return amountOfLaserShots;
    }
    
    /**
     * Set {@link #amountOfLaserShots int}
     * Used to control laser
     * 
     * @param amountOfLaserShots 
     * @see domain.locations.gameobjects.LaserControl
     */
    public void setAmountOfLaserShots(int amountOfLaserShots) {
        this.amountOfLaserShots = amountOfLaserShots;
    }
    
    /**
     * Get {@link #NET_MAX_HEALTH}
     * Used to control net
     * 
     * @return the number of time the laser has shoot
     *  @see domain.locations.gameobjects.NetRepair
     */
    public int getNET_MAX_HEALTH() {
        return NET_MAX_HEALTH;
    }
    
    /**
     * Get {@link #netCurrentHealth}
     * Used to control net
     * 
     * @return the the current healt of the net
     *  @see domain.locations.gameobjects.NetControl
     */
    public int getNetCurrentHealth() {
        return netCurrentHealth;
    }
    
    /**
     * Set {@link #netCurrentHealth int}
     * Used to control net
     * 
     * @param netCurrentHealth
     * @see domain.locations.gameobjects.NetRepair
     */
    public void setNetCurrentHealth(int netCurrentHealth) {
        this.netCurrentHealth = netCurrentHealth;
    }
}
