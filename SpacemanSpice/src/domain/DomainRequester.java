package domain;

import domain.interactions.InteractionsManager;
import domain.interactions.InteractionsRequest;
import domain.locations.Location;
import domain.locations.LocationsManager;
import domain.locations.gameobjects.Player;
import domain.locations.gameobjects.Tile;
import domain.locations.gameobjects.TileManager;
import domain.resources.ResourcesManager;
import domain.sound.SoundManager;
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
        TileManager tiles = (TileManager) group.getManager(TileManager.class);
        
        resources.getOxygen().setValue(100);
        resources.getLife().setValue(100);
        resources.getTime().init();
        
        systems.getWave().setNumberOfWaves(0);
        systems.setPlayerReady(false);
        
        locations.clearLocationMap();
        locations.init();
        tutorial.init();
        
        tiles.clearTileMap();
        tiles.init();
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
    
    public void playGameMusic() {
        SoundManager sound = (SoundManager) group.getManager(SoundManager.class);
        sound.playGameMusic();
    }

    public void playLocationSound() {
        SoundManager sound = (SoundManager) group.getManager(SoundManager.class);
        sound.playLocationSound();
    }

    public void playDoorSound() {
        SoundManager sound = (SoundManager) group.getManager(SoundManager.class);
        sound.playDoorSound();
    }

    public void playInteractionSound() {
        SoundManager sound = (SoundManager) group.getManager(SoundManager.class);
        sound.playInteractionSound();
    }

    public void startSounds() {
        SoundManager sound = (SoundManager) group.getManager(SoundManager.class);
        sound.startSounds();
    }

    public void stopSounds() {
        SoundManager sound = (SoundManager) group.getManager(SoundManager.class);
        sound.stopSounds();
    }

    public void mute() {
        SoundManager sound = (SoundManager) group.getManager(SoundManager.class);
        sound.mute();
    }
    
    public HashMap<Character, Tile> getTileMap(){
        TileManager tiles = (TileManager) group.getManager(TileManager.class);
        return tiles.getTileMap();
    }
    
    public HashMap<String, Location> getLocationMap(){
        LocationsManager locations = (LocationsManager) group.getManager(LocationsManager.class);
        return locations.getLocationMap();
    }
    
    public Player getPlayer(){
        TileManager tiles = (TileManager) group.getManager(TileManager.class);
        return tiles.getPlayer();
    }
}
