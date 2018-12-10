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
        InteractionsManager interactions = (InteractionsManager) group.getManager(InteractionsManager.class);

        if (interactions != null) {
            interactions.runCommand(input);
        }
    }

    public void requestReset() {
        ResourcesManager resources = (ResourcesManager) group.getManager(ResourcesManager.class);
        SystemsManager systems = (SystemsManager) group.getManager(SystemsManager.class);
        LocationsManager locations = (LocationsManager) group.getManager(LocationsManager.class);
        TutorialManager tutorial = (TutorialManager) group.getManager(TutorialManager.class);
        
        resources.getOxygen().setValue(100);
        resources.getLife().setValue(100);
        
        systems.getWave().setNumberOfWaves(0);
        systems.setPlayerReady(false);
        
        systems.init();
        locations.init();
        tutorial.init();
    }

    public void requestDifficultyEasy() {
        ResourcesManager resources = (ResourcesManager) group.getManager(ResourcesManager.class);
        SystemsManager systems = (SystemsManager) group.getManager(SystemsManager.class);
        
        resources.getLife().setDifficultyEasy();
        systems.getWave().setDifficultyEasy();
    }

    public void requestDifficultyHard() {
        ResourcesManager resources = (ResourcesManager) group.getManager(ResourcesManager.class);
        SystemsManager systems = (SystemsManager) group.getManager(SystemsManager.class);
        
        resources.getLife().setDifficultyHard();
        systems.getWave().setDifficultyHard();
    }
}
