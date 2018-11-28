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
    public int requestLifeValue();

    /**
     * Read the current amount of {@link Oxygen}.
     *
     * @return Amount of oxygen.
     */
    public int requestOxygenValue();

    /**
     * Read the remaining {@link Time#waveTime}.
     *
     * @return Amount of wave time.
     */
    public long requestWaveTime();

    /**
     * Read the {@link Time#currentTime}.
     *
     * @return Amount of current time.
     */
    public long requestCurrentTime();
}
