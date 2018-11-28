package domain.locations;

/**
 * An interface to the domain-layer for reading locations data. The intent of
 * this, is for the presentation layer to display some of the computations the
 * domain.locations package is doing.
 *
 * @see LocationsController
 */
public interface LocationsReader {

    /**
     * Read the name of the {@link Room} the player is currently standing in.
     *
     * @return The name of the room.
     */
    public String requestCurrentRoom();

    /**
     * Read the name of the {@link Location} the player is currently standing
     * in.
     *
     * @return THe name of the location.
     */
    public String requestCurrentLocation();
}
