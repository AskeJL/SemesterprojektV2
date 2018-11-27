package domain.resources;

/**
 * An interface to the domain-layer for reading resources data. The intent of
 * this, is for the presentation layer to display some of the computations the
 * domain.resources package is doing.
 *
 * @see InteractionsController
 */
public interface ResourcesReader {

    /**
     * Read the current amount of {@link Life}.
     *
     * @return Amount of life.
     */
    default int readLife() {
        return ResourcesController.getLife();
    }

    /**
     * Read the current amount of {@link Oxygen}.
     *
     * @return Amount of oxygen.
     */
    default int readOxygen() {
        return ResourcesController.getOxygen();
    }

    /**
     * Read the remaining {@link Time#waveTime}.
     *
     * @return Amount of wave time.
     */
    default long readWaveTime() {
        return ResourcesController.getRemainingTime();
    }

    /**
     * Read the {@link Time#currentTime}.
     *
     * @return Amount of current time.
     */
    default long readCurrentTime() {
        return ResourcesController.getCurrentTime();
    }
}
