package domain.systems;

/**
 * An interface to the domain-layer for reading systems data. The intent of
 * this, is for the presentation layer to display some of the computations the
 * domain.systems package is doing.
 *
 * @see SystemsController
 */
public interface SystemsReader {
    
    default int readWaveNumber(){
        return SystemsController.getNumberOfWaves();
    }
    /**
     * Read the amount of small fragments.
     *
     * @return Number of fragments.
     */
    default int readSmallFragments() {
        return SystemsController.getSmallFragments();
    }

    /**
     * Read the amount of medium fragments.
     *
     * @return Number of fragments.
     */
    default int readMediumFragments() {
        return SystemsController.getMediumFragments();
    }

    /**
     * Read the amount of large fragments.
     *
     * @return Number of fragments.
     */
    default int readLargeFragments() {
        return SystemsController.getLargeFragments();
    }
    
    default int readScore(){
        return SystemsController.getScore();
    }
}
