package domain.systems;

import domain.resources.ResourcesController;
import java.util.Random;

/**
 * This creates the waves for the game and destroys it as the player interacts
 * with various controls.
 * <br><br>
 * Mainly spawn in the number of fragments and then continues to keep track of
 * said numbers.
 *
 * @see SystemsController
 * @see domain.locations.functional.Laser
 * @see domain.locations.functional.Net
 * @see domain.locations.functional.Control
 */
public class Wave {

    /**
     * The number of waves the player has gone through (Including the one
     * currently within).
     */
    private static int numberOfWaves = 0;

    /**
     * How many small fragments there are in the wave.
     */
    private static int smallFragments;
    /**
     * How many medium fragments there are in the wave.
     */
    private static int mediumFragments;
    /**
     * How many large fragments there are in the wave.
     */
    private static int largeFragments;

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

    private Wave() {
    }

    /**
     * Create the wave. This will use in-built formulas based on the
     * {@link #numberOfWaves} to compute the amount of fragments to create.
     *
     * @see domain.resources.ResourcesController#setWaveTime(long)
     */
    static void createWave() {
        System.out.println("New wave of fragments incoming!");
        System.out.println("Head to the scanning room to identify them");
        ResourcesController.setWaveTime(ResourcesController.getCurrentTime() + 120);
        Random random = new Random();
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
    }

    /**
     *
     * Update the amount of fragments based on the fragment identifiers.<br>
     * {@link SystemsController#SMALL_FRAGMENT_IDENTIFIER}<br>
     * {@link SystemsController#MEDIUM_FRAGMENT_IDENTIFIER}<br>
     * {@link SystemsController#LARGE_FRAGMENT_IDENTIFIER}<br>
     * <br><br>
     * Also randomized the amount of fragments destroyed when the player
     * interacts with the controllers. This depends on each of the fragments
     * {@link #SMALL_DESTRUCTION_INDEX}
     *
     * @see SystemsController
     * @param fragmentIdentifier
     */
    static void updateWave(int fragmentIdentifier) {
        if (fragmentIdentifier == SystemsController.getSmallFragmentIdentifier()) {
            int newIndex = smallFragments > SMALL_DESTRUCTION_INDEX ? SMALL_DESTRUCTION_INDEX : smallFragments;
            int destructionIndex = (int) (Math.random() * newIndex + 1);
            smallFragments -= destructionIndex;

            if (destructionIndex > 1) {
                System.out.println("You destroyed " + destructionIndex + " small fragments!");
            } else {
                System.out.println("You destroyed " + destructionIndex + " small fragment!");
            }

            if (smallFragments < 0) {
                smallFragments = 0;
            }
        }

        if (fragmentIdentifier == SystemsController.getMediumFragmentIdentifier()) {
            int newIndex = mediumFragments > MEDIUM_DESCTRUCTION_INDEX ? MEDIUM_DESCTRUCTION_INDEX : mediumFragments;
            int destructionIndex = (int) (Math.random() * newIndex);
            mediumFragments -= destructionIndex;

            if (destructionIndex > 1) {
                System.out.println("You caught " + destructionIndex + " medium fragments!");
            } else {
                System.out.println("You caught " + destructionIndex + " medium fragment!");
            }

            if (mediumFragments < 0) {
                mediumFragments = 0;
            }
        }

        if (fragmentIdentifier == SystemsController.getLargeFragmentIdentifier()) {
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
    static void incrementNumberOfWaves() {
        numberOfWaves++;
    }

    /**
     * Get number of {@link #smallFragments smallFragments}.
     *
     * @return
     */
    static int getSmallFragments() {
        return smallFragments;
    }

    /**
     * Get number of {@link #mediumFragments mediumFragments}.
     *
     * @return
     */
    static int getMediumFragments() {
        return mediumFragments;
    }

    /**
     * Get number of {@link #largeFragments largeFragments}.
     *
     * @return
     */
    static int getLargeFragments() {
        return largeFragments;
    }
}
