package domain;

import domain.interactions.InteractionsManager;
import domain.interactions.InteractionsReader;
import domain.locations.LocationsManager;
import domain.locations.LocationsReader;
import domain.resources.ResourcesManager;
import domain.resources.ResourcesReader;
import domain.systems.SystemsManager;
import domain.systems.SystemsReader;

/**
 * This is used to read all the necessary variables from the domain layer. To
 * read these variables you could implement it like this:
 * <p>
 *
 * DomainReader reader = new DomainReader(); String roomName =
 * reader.readCurrentRoomName();
 * 
 * @see DomainRequester
 */
public class DomainReader implements InteractionsReader, LocationsReader, ResourcesReader, SystemsReader {

    /**
     * The {@link ManagerGroup} of for the domain layer.
     */
    private static ManagerGroup group;

    /**
     * The globalized output of the domain layer. Everything the domain layer
     * 'tells' the outside is stored here.
     */
    private static String output = "";

    /**
     * Initialize the reader. This is necessary before using the class.
     *
     * @param group The manager group of a domain.
     */
    void init(ManagerGroup group) {
        DomainReader.group = group;
    }

    /**
     * Store a line to the output of the domain layer. This is primarily used by
     * the domain layer itself - generally replacing System.out.println().
     *
     * @param text The text to store.
     */
    public void storeln(String text) {
        DomainReader.output += text + "\n";
    }

    /**
     * Get the output of the domain layer.
     *
     * @return The currently stored string for the output.
     */
    public String readOutput() {
        return DomainReader.output;
    }

    /**
     * Read the {@link domain.interactions.Commands#lastCommand} name.
     *
     * @return The name of the last command.
     * @see InteractionsReader
     */
    @Override
    public String readLastCommandName() {
        InteractionsManager interactions = (InteractionsManager) group.getManager(InteractionsManager.class);
        return interactions != null ? interactions.getLastCommandName() : "";
    }

    /**
     * Read the {@link domain.interactions.Commands#lastParameter}.
     *
     * @return The last parameter as a String.
     * @see InteractionsReader
     */
    @Override
    public String readLastParameter() {
        InteractionsManager interactions = (InteractionsManager) group.getManager(InteractionsManager.class);
        return interactions != null ? interactions.getLastParameter() : "";
    }

    /**
     * Read the {@link domain.locations.LocationsManager#currentRoom} name.
     *
     * @return The name of the current room.
     * @see LocationsReader
     */
    @Override
    public String readCurrentRoomName() {
        LocationsManager locations = (LocationsManager) group.getManager(LocationsManager.class);
        return locations != null ? locations.getCurrentRoom().getName() : "";
    }

    /**
     * Read the {@link domain.locations.LocationsManager#currentLocation} name.
     *
     * @return The name of the current location.
     * @see LocationsReader
     */
    @Override
    public String readCurrentLocationName() {
        LocationsManager locations = (LocationsManager) group.getManager(LocationsManager.class);
        return locations != null ? locations.getCurrentLocation().getName() : "";
    }

    /**
     * Read the {@link domain.resources.Time#currentTime}.
     *
     * @return The current time in seconds.
     * @see ResourcesReader
     */
    @Override
    public int readCurrentTime() {
        ResourcesManager resources = (ResourcesManager) group.getManager(ResourcesManager.class);
        return resources != null ? (int) resources.getTime().getCurrentTime() : -1;
    }

    /**
     * Read the {@link domain.resources.Time#getRemainingTime()}.
     *
     * @return The remaining time based on the current time and wave time.
     * @see ResourcesReader
     */
    @Override
    public int readRemainingTime() {
        ResourcesManager resources = (ResourcesManager) group.getManager(ResourcesManager.class);
        return resources != null ? (int) resources.getTime().getRemainingTime() : -1;
    }

    /**
     * Read the {@link domain.resources.Life#life}.
     * 
     * @return The life of the spaceship.
     * @see ResourcesReader
     */
    @Override
    public int readLifeValue() {
        ResourcesManager resources = (ResourcesManager) group.getManager(ResourcesManager.class);
        return resources != null ? resources.getLife().getValue() : -1;
    }

    /**
     * Read the {@link domain.resources.Oxygen#oxygen}.
     * 
     * @return The oxygen of the player.
     * @see ResourcesReader
     */
    @Override
    public int readOxygenValue() {
        ResourcesManager resources = (ResourcesManager) group.getManager(ResourcesManager.class);
        return resources != null ? resources.getOxygen().getValue() : -1;
    }

    /**
     * Read the {@link domain.systems.Wave#smallFragments}.
     * 
     * @return The number of small fragments.
     * @see SystemsReader
     */
    @Override
    public int readSmallFragments() {
        SystemsManager systems = (SystemsManager) group.getManager(SystemsManager.class);
        return systems != null ? systems.getWave().getSmallFragments() : -1;
    }

    /**
     * Read the {@link domain.systems.Wave#mediumFragments}.
     * 
     * @return The number of medium fragments.
     * @see SystemsReader
     */
    @Override
    public int readMediumFragments() {
        SystemsManager systems = (SystemsManager) group.getManager(SystemsManager.class);
        return systems != null ? systems.getWave().getMediumFragments() : -1;
    }

    /**
     * Read the {@link domain.systems.Wave#largeFragments}.
     * 
     * @return The number of large fragments.
     * @see SystemsReader
     */
    @Override
    public int readLargeFragments() {
        SystemsManager systems = (SystemsManager) group.getManager(SystemsManager.class);
        return systems != null ? systems.getWave().getLargeFragments() : -1;
    }

    /**
     * Read the {@link domain.systems.Wave#numberOfWaves}.
     * 
     * @return The number of waves.
     * @see SystemsReader
     */
    @Override
    public int readNumberOfWaves() {
        SystemsManager systems = (SystemsManager) group.getManager(SystemsManager.class);
        return systems != null ? systems.getWave().getNumberOfWaves() : -1;
    }

    /**
     * Read the {@link domain.systems.Score#score}.
     * 
     * @return The score for this game.
     * @see SystemsReader
     */
    public int readScore() {
        SystemsManager systems = (SystemsManager) group.getManager(SystemsManager.class);
        return systems != null ? systems.getScore().getValue() : -1;
    }
}
