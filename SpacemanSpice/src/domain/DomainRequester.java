package domain;

import domain.interactions.InteractionsManager;
import domain.interactions.InteractionsRequest;
import domain.locations.Location;
import domain.locations.LocationsManager;
import domain.locations.gameobjects.Player;
import domain.locations.gameobjects.Tile;
import domain.locations.gameobjects.TileManager;
import domain.resources.ResourcesManager;
import domain.systems.SystemsManager;
import domain.tutorial.TutorialManager;
import java.util.HashMap;


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
        TileManager tiles = (TileManager) group.fetchController(TileManager.class);
        
        resources.getOxygen().setValue(100);
        resources.getLife().setValue(100);
        
        systems.setNumberOfWaves(0);
        systems.setPlayerReady(false);
        systems.init();
        
        locations.clearLocationMap();
        locations.init();
        
        tutorial.init();
        
        tiles.clearTileMap();
        tiles.init();
    }

    public void requestDifficultyEasy() {
        ResourcesManager resources = (ResourcesManager) group.fetchController(ResourcesManager.class);
        SystemsManager systems = (SystemsManager) group.fetchController(SystemsManager.class);
        
        resources.getLife().setDifficultyEasy();
        
        systems.setDifficultyEasy();
    }

    public void requestDifficultyHard() {
        ResourcesManager resources = (ResourcesManager) group.fetchController(ResourcesManager.class);
        SystemsManager systems = (SystemsManager) group.fetchController(SystemsManager.class);
        
        resources.getLife().setDifficultyHard();
        
        systems.setDifficultyHard();
    }
    
    public HashMap<Character, Tile> getTileMap(){
        TileManager tiles = (TileManager) group.fetchController(TileManager.class);
        return tiles.getTileMap();
    }
    
    public HashMap<String, Location> getLocationMap(){
        LocationsManager locations = (LocationsManager) group.fetchController(LocationsManager.class);
        return locations.getLocationMap();
    }
    
    public Player getPlayer(){
        TileManager tiles = (TileManager) group.fetchController(TileManager.class);
        return tiles.getPlayer();
    }
}
