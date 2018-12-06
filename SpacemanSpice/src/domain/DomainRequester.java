package domain;

import domain.interactions.InteractionsManager;
import domain.interactions.InteractionsRequest;
import domain.locations.LocationsManager;
import domain.resources.ResourcesManager;
import domain.systems.SystemsManager;
import domain.tutorial.TutorialManager;

public class DomainRequester implements InteractionsRequest {

    private static ManagerGroup group;

    void init(ManagerGroup group) {
        DomainRequester.group = group;
    }

    @Override
    public void requestRunCommand(String input) {
        InteractionsManager interactions = (InteractionsManager) group.fetchController(InteractionsManager.class);

        if (interactions != null) {
            interactions.runCommand(input);
        }
    }

    public void requestReset() {
        ResourcesManager resources = (ResourcesManager) group.fetchController(ResourcesManager.class);
        SystemsManager systems = (SystemsManager) group.fetchController(SystemsManager.class);
        LocationsManager locations = (LocationsManager) group.fetchController(LocationsManager.class);
        TutorialManager tutorial = (TutorialManager) group.fetchController(TutorialManager.class);
        resources.setOxygen(100);
        resources.setLife(100);
        systems.setNumberOfWaves(0);
        systems.setPlayerReady(false);
        systems.init();
        locations.init();
        tutorial.init();
    }

    public void requestDifficultyEasy() {
        ResourcesManager resources = (ResourcesManager) group.fetchController(ResourcesManager.class);
        SystemsManager systems = (SystemsManager) group.fetchController(SystemsManager.class);
        resources.setDifficultyEasy();
        systems.setDifficultyEasy();
    }

    public void requestDifficultyHard() {
        ResourcesManager resources = (ResourcesManager) group.fetchController(ResourcesManager.class);
        SystemsManager systems = (SystemsManager) group.fetchController(SystemsManager.class);
        resources.setDifficultyHard();
        systems.setDifficultyHard();
    }
}
