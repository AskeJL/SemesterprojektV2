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
import domain.sound.SoundPlayer;
import domain.systems.SystemsManager;
import domain.tutorial.TutorialManager;
import java.util.HashMap;

/**
 * This is used to request actions from the domain layer. To request an action
 * it is to be implemented like this.<p>
 *
 * DomainRequester requester = new DomainRequester();
 * requester.requestRunCommand(command);
 *
 * @see DomainReader
 */
public class DomainRequester implements InteractionsRequest {

    /**
     * The {@link ManagerGroup} of for the domain layer.
     */
    private static ManagerGroup group;

    /**
     * Initialize the reader. This is necessary before using the class.
     *
     * @param group The manager group of a domain.
     */
    void init(ManagerGroup group) {
        DomainRequester.group = group;
    }

    /**
     * Request a command from
     * {@link domain.interactions.Parser#getCommand(java.lang.String)} to run.
     *
     * @param input The command to run.
     * @see InteractionsRequest
     */
    @Override
    public void requestRunCommand(String input) {
        InteractionsManager interactions = (InteractionsManager) group.getManager(InteractionsManager.class);

        if (interactions != null) {
            interactions.runCommand(input);
        }
    }

    /**
     * Request a reset from the domain. This will reset all necessary variables
     * to run the game again.
     */
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

    /**
     * Request {@link domain.resources.Life#setDifficultyEasy() and
     * {@link domain.systems.Wave#setDifficultyEasy().
     */
    public void requestDifficultyEasy() {
        ResourcesManager resources = (ResourcesManager) group.getManager(ResourcesManager.class);
        SystemsManager systems = (SystemsManager) group.getManager(SystemsManager.class);

        if (resources != null) {
            resources.getLife().setDifficultyEasy();
        }
        if (systems != null) {
            systems.getWave().setDifficultyEasy();
        }
    }

    /**
     * Request {@link domain.resources.Life#setDifficultyHard() and
     * {@link domain.systems.Wave#setDifficultyHard().
     */
    public void requestDifficultyHard() {
        ResourcesManager resources = (ResourcesManager) group.getManager(ResourcesManager.class);
        SystemsManager systems = (SystemsManager) group.getManager(SystemsManager.class);

        if (resources != null) {
            resources.getLife().setDifficultyHard();
        }
        if (systems != null) {
            systems.getWave().setDifficultyHard();
        }
    }

    /**
     * Request game music from {@link domain.sound.SoundPlayer#playGameMusic()}.
     */
    public void requestGameMusic() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.playGameMusic();
        }
    }

    /**
     * Request locations sound from
     * {@link domain.sound.SoundPlayer#playLocationSound()}.
     */
    public void requestLocationSound() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.playLocationSound();
        }
    }

    /**
     * Request door sound from {@link domain.sound.SoundPlayer#playDoorSound()}.
     */
    public void requestDoorSound() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.playDoorSound();
        }
    }

    /**
     * Request console sound from
     * {@link domain.sound.SoundPlayer#playConsoleSound()}.
     */
    public void requestConsoleSound() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.playConsoleSound();
        }
    }
    
    /**
     * Request console sound from
     * {@link domain.sound.SoundPlayer#playScanningConsoleSound()}.
     */
    public void requestScanningConsoleSound() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.playScanningConsoleSound();
        }
    }
    
     /**
     * Request console sound from
     * {@link domain.sound.SoundPlayer#playActivatorConsoleSound()}.
     */
    public void requestActivatorConsoleSound() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.playActivatorConsoleSound();
        }
    }

    /**
     * Request siren sound from
     * {@link domain.sound.SoundPlayer#playSireenSound()}.
     */
    public void requestSirenSound() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.playSireenSound();
        }
    }
    
    /**
     * Request stop of siren sound from
     * {@link domain.sound.SoundPlayer#stopSireenSound()}.
     */
    public void requestStopSirenSound() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.stopSireenSound();
        }
    }
     
    /**
     * Request laser sound from
     * {@link domain.sound.SoundPlayer#playLaserSound()}.
     */
     public void requestLaserSound(){
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
        sound.playLaserSound();
        }
     }
     
     /**
     * Request siren sound from
     * {@link domain.sound.SoundPlayer#playLaserChargeSound()}.
     */
     public void requestLaserChargeSound() {
         SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
        sound.playLaserChargeSound();
        }
     }

    /**
     * Request move sound from {@link domain.sound.SoundPlayer#playMoveSound()}.
     */
    public void requestMoveSound() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.playMoveSound();
        }
    }

    /**
     * Request air sound from {@link domain.sound.SoundPlayer#playAirSound()}.
     */
    public void requestAirSound() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.playAirSound();
        }
    }

    /**
     * Request repair sound from
     * {@link domain.sound.SoundPlayer#playRepairSound()}.
     */
    public void requestRepairSound() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.playRepairSound();
        }
    }

    /**
     * Request start sounds from {@link domain.sound.SoundPlayer#startSounds()}.
     */
    public void requestStartSounds() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.startSounds();
        }
    }

    /**
     * Request stop sounds from {@link domain.sound.SoundPlayer#stopSounds()}.
     */
    public void requestStopSounds() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.stopSounds();
        }
    }

    /**
     * Request mute sounds from {@link domain.sound.SoundPlayer#mute()}.
     */
    public void requestMuteSounds() {
        SoundPlayer sound = ((SoundManager) group.getManager(SoundManager.class)).getSoundPlayer();
        if (sound != null) {
            sound.mute();
        }
    }

    /**
     * Request tile map from
     * {@link domain.locations.gameobjects.TileManager#tileMap}.
     *
     * @return The full tile map. (This includes the complex classes..)
     */
    public HashMap<Character, Tile> requestTileMap() {
        TileManager tiles = (TileManager) group.getManager(TileManager.class);
        return tiles != null ? tiles.getTileMap() : new HashMap<>();
    }

    /**
     * Request locations map from
     * {@link domain.locations.LocationsManager#locationMap}.
     *
     * @return The full locations map. (This includes a complex class..)
     */
    public HashMap<String, Location> requestLocationsMap() {
        LocationsManager locations = (LocationsManager) group.getManager(LocationsManager.class);
        return locations != null ? locations.getLocationMaps() : new HashMap<>();
    }

    /**
     * Request player from
     * {@link domain.locations.gameobjects.TileManager#player}.
     *
     * @return The player. (This is a complex type..)
     */
    public Player requestPlayer() {
        TileManager tiles = (TileManager) group.getManager(TileManager.class);
        return tiles != null ? tiles.getPlayer() : new TileManager().getPlayer();
    }

    /**
     * Request to set
     * {@link domain.locations.LocationsManager#setCurrentLocation(domain.locations.Location)}.
     *
     * @param name Name of the location to set.
     */
    public void requestSetCurrentLocation(Location name) {
        LocationsManager locations = (LocationsManager) group.getManager(LocationsManager.class);
        if (locations != null) {
            locations.setCurrentLocation(name);
        }
    }
}
