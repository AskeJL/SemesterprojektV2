package domain.locations;

/**
 * An interface that defines what important values can be read from the
 * {@link domain.locations} package.
 * <p>
 * This is implemented in the {@link domain.DomainReader} for other layers to
 * access.
 *
 * @see domain.DomainReader
 * @see domain.DomainRequester
 */
public interface LocationsReader {

    /**
     * Read name of the current {@link LocationsManager#getCurrentRoom()}.
     *
     * @return The name as a String.
     */
    public String readCurrentRoomName();

    /**
     * Read name of the current {@link LocationsManager#currentLocation}.
     *
     * @return The name as a String.
     */
    public String readCurrentLocationName();
}
