package domain;

import domain.interactions.InteractionsManager;
import domain.interactions.InteractionsReader;
import domain.locations.LocationsManager;
import domain.locations.LocationsReader;
import domain.resources.ResourcesManager;
import domain.resources.ResourcesReader;
import domain.systems.Score;
import domain.systems.SystemsManager;
import domain.systems.SystemsReader;

public class DomainReader implements InteractionsReader, LocationsReader, ResourcesReader, SystemsReader {

    private static ManagerGroup group;
    private static String output = "";

    void init(ManagerGroup group) {
        DomainReader.group = group;
    }
    
    public void storeln(String text) {
        DomainReader.output += text + "\n";
    }
    
    public String readOutput() {
        return DomainReader.output;
    }
    
    @Override
    public String readLastCommandName() {
        InteractionsManager interactions = (InteractionsManager) group.fetchController(InteractionsManager.class);

        if (interactions != null) {
            return interactions.getLastCommandName();
        }

        return "Null";
    }

    @Override
    public String readLastParameter() {
        InteractionsManager interactions = (InteractionsManager) group.fetchController(InteractionsManager.class);

        if (interactions != null) {
            return interactions.getLastParameter();
        }

        return "Null";
    }

    @Override
    public String readCurrentRoomName() {
        LocationsManager locations = (LocationsManager) group.fetchController(LocationsManager.class);

        if (locations != null) {
            return locations.getCurrentRoom().getNAME();
        }

        return "";
    }

    @Override
    public String readCurrentLocationName() {
        LocationsManager locations = (LocationsManager) group.fetchController(LocationsManager.class);

        if (locations != null) {
            return locations.getCurrentLocation().getNAME();
        }

        return "";
    }

    @Override
    public int readCurrentTime() {
        ResourcesManager resources = (ResourcesManager) group.fetchController(ResourcesManager.class);

        if (resources != null) {
            return (int) resources.getTime().getCurrentTime();
        }

        return -1;
    }

    @Override
    public int readRemainingTime() {
        ResourcesManager resources = (ResourcesManager) group.fetchController(ResourcesManager.class);

        if (resources != null) {
            return (int) resources.getTime().getRemainingTime();
        }

        return -1;
    }

    @Override
    public int readLifeValue() {
        ResourcesManager resources = (ResourcesManager) group.fetchController(ResourcesManager.class);

        if (resources != null) {
            return resources.getLife().getValue();
        }

        return -1;
    }

    @Override
    public int readOxygenValue() {
        ResourcesManager resources = (ResourcesManager) group.fetchController(ResourcesManager.class);

        if (resources != null) {
            return resources.getOxygen().getValue();
        }

        return -1;
    }

    @Override
    public int readSmallFragments() {
        SystemsManager systems = (SystemsManager) group.fetchController(SystemsManager.class);

        if (systems != null) {
            return systems.getSmallFragments();
        }

        return -1;
    }

    @Override
    public int readMediumFragments() {
        SystemsManager systems = (SystemsManager) group.fetchController(SystemsManager.class);

        if (systems != null) {
            return systems.getMediumFragments();
        }

        return -1;
    }

    @Override
    public int readLargeFragments() {
        SystemsManager systems = (SystemsManager) group.fetchController(SystemsManager.class);

        if (systems != null) {
            return systems.getLargeFragments();
        }

        return -1;
    }

    @Override
    public int readNumberOfWaves() {
        SystemsManager systems = (SystemsManager) group.fetchController(SystemsManager.class);

        if (systems != null) {
            return systems.getNumberOfWaves();
        }

        return -1;
    }

    public int readScore() {
        SystemsManager systems = (SystemsManager) group.fetchController(SystemsManager.class);
        return systems.readScore();
        
    }
}
