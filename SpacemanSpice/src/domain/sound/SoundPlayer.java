
package domain.sound;

import domain.GameElement;
import domain.GameElementGroup;
import domain.locations.LocationsManager;
import java.io.File;
import javafx.scene.media.AudioClip;
import presentation.GUIManager;
import presentation.draw.DrawController;

public class SoundPlayer extends GameElement {

    private DrawController drawController;
    private LocationsManager locationsManager;
    
    // Variables used to decide what sounds are playing
    private boolean game = true;
    private boolean mute = false;
    String a = "outside";
    int door = 1;

    // Initializes all the AudioClip instances for the different sounds and music in the game
    private final String gameMusicFile = "assets/sounds/Space_Pursuit.wav";
    private AudioClip gameMusic = new AudioClip(new File(gameMusicFile).toURI().toString());

    String backSoundFile = "assets/sounds/Background_spacesounds.wav";
    AudioClip backSound = new AudioClip(new File(backSoundFile).toURI().toString());

    String sireenSoundFile = "assets/sounds/alarm_siren_warning_01.wav";
    AudioClip sireenSound = new AudioClip(new File(sireenSoundFile).toURI().toString());

    String moveSpaceshipSoundFile = "assets/sounds/retro_spaceship_engine_03.wav";
    AudioClip moveSpaceshipSound = new AudioClip(new File(moveSpaceshipSoundFile).toURI().toString());

    String consoleSoundFile = "assets/sounds/beep_09.wav";
    AudioClip consoleSound = new AudioClip(new File(consoleSoundFile).toURI().toString());

    String airSoundFile = "assets/sounds/AirTank_Sound.wav";
    AudioClip airSound = new AudioClip(new File(airSoundFile).toURI().toString());

    String repairSoundFile = "assets/sounds/RepairSound.wav";
    AudioClip repairSound = new AudioClip(new File(repairSoundFile).toURI().toString());

    String laserSoundFile = "assets/sounds/sci-fi_weapon_laser_small_03.wav";
    AudioClip laserSound = new AudioClip(new File(laserSoundFile).toURI().toString());

    String laserChargeSoundFile = "assets/sounds/LaserCharge_Sound.wav";
    AudioClip laserChargeSound = new AudioClip(new File(laserChargeSoundFile).toURI().toString());

    private final String buttonHover = "assets/sounds/menu/button_hover.wav";
    private final String buttonClick = "assets/sounds/menu/button_click.wav";

    @Override
    public void init() {
        GameElementGroup group = this.gameElementGroup;
        GUIManager gui = (GUIManager) group.getManagerGroup().getManager(GUIManager.class);
        drawController = (DrawController) gui.getGameElementGroup().getGameElement(DrawController.class);
        this.locationsManager = (LocationsManager) group.getManagerGroup().getManager(LocationsManager.class);
    }
    /**
    * Play the game music if {@link domain.locations.LocationsManager#getCurrentLocation().getName()} != "outside"
    * Stop game music if {@link domain.locations.LocationsManager#getCurrentLocation().getName()} equals "outside"
    */
    public void playGameMusic() {
        if (game == true && mute == false && locationsManager.getCurrentLocation() != null && !locationsManager.getCurrentLocation().getName().equalsIgnoreCase(a)) {
            if (gameMusic.isPlaying() == false) {
                gameMusic.setVolume(0.2);
                gameMusic.play();
            }
        }
        if (locationsManager.getCurrentLocation() != null && locationsManager.getCurrentLocation().getName().equalsIgnoreCase(a)) {
            gameMusic.stop();
        }
    }
    
    /**
     * Play background sounds if {@link domain.locations.LocationsManager#getCurrentLocation().getName()} != "outside"
     */
    public void playLocationSound() {
        if (game == true && mute == false && locationsManager.getCurrentLocation() != null && !locationsManager.getCurrentLocation().getName().equalsIgnoreCase(a)) {
            if (backSound.isPlaying() == false) {
                backSound.setVolume(0.1);
                backSound.play();
            }
        } else if (locationsManager.getCurrentLocationName().equalsIgnoreCase(a)) {
            backSound.stop();
        }
    }
    
    /**
     * Play sound of opening door.
     * Changes between sounds based on number of times method has been called.
     */
    public void playDoorSound() {
        if (mute == false) {
            if (door == 1) {
                String musicFile = "assets/sounds/FREE_SOUND_FX_Doors_Sci_Fi_Space_Door.wav";
                AudioClip sound = new AudioClip(new File(musicFile).toURI().toString());
                sound.play();
                door = 2;
            } else if (door == 2) {
                String musicFile = "assets/sounds/FREE_SOUND_FX_Doors_Sci_Fi_Space_Door2.wav";
                AudioClip sound = new AudioClip(new File(musicFile).toURI().toString());
                sound.play();
                door = 3;
            } else if (door == 3) {
                String musicFile = "assets/sounds/FREE_SOUND_FX_Doors_Sci_Fi_Space_Door3.wav";
                AudioClip sound = new AudioClip(new File(musicFile).toURI().toString());
                sound.play();
                door = 1;
            }
        }
    }
    
    /**
     * plays a console beep.
     */
    public void playConsoleSound() {
        if (mute == false) {
            consoleSound.play();
        }
    }
    
    /**
     * Plays a sireen sound.
     * Loops continuselse
     * {@link sireenSound}
     */
    public void playSireenSound() {
        if (mute == false) {
            if (sireenSound.isPlaying() == false) {
                sireenSound.setVolume(0.05);
                sireenSound.play();
            }
        }
    }
    
    /**
     * Stops the Sireen sound if playing
     * {@link sireenSound}
     */
    public void stopSireenSound() {
        if (mute == false) {
            if (sireenSound.isPlaying() == false) {
                sireenSound.stop();
            }
        }
    }
    
    /**
     * Plays the sound of spaceship mooving.
     */
    public void playMoveSound() {
        if (mute == false) {
            moveSpaceshipSound.play();
        }
    }
    
    /**
     * Plays the sound of 02 souply being reefilled.
     */
    public void playAirSound() {
        if (mute == false) {
            airSound.play();
        }
    }
    
    /**
     * Plays the sound of ship being repaired.
     */
    public void playRepairSound() {
        if (mute == false) {
            repairSound.play();
        }
    }
    
    /**
     * Plays the sound of a laser being fired.
     */
    public void playLaserSound() {
        if (mute == false) {
            laserSound.play();
        }
    }
    
    /**
     * Plays the sound of a laser charging
     */
    public void playLaserChargeSound() {
        if (mute == false) {
            laserChargeSound.play();
        }
    }
    
    /**
     * sets {@link SoundPlayer#game} to true
     * This is enables the music to be played
     * @see #stopSounds() 
     */
    public void startSounds() {
        this.game = true;
    }
    
    /**
     * stops the current playback of {@link SoundPlayer#gameMusic } and {@link SoundPlayer#backSound}
     * sets {@link SoundPlayer#game} to false
     * this diables the music to be played
     * @see #startSounds() 
     */
    public void stopSounds() {
        gameMusic.stop();
        backSound.stop();
        this.game = false;
    }
    
    /**
     * Plays a sound for huvering over buttons.
     */
    public void playButtonHoverSound() {
        AudioClip audio = new AudioClip(new File(buttonHover).toURI().toString());
        audio.setVolume(0.3);
        audio.play();
    }
    
    /**
     * Plays a click sound.
     */
    public void playButtonClickSound() {
        AudioClip audio = new AudioClip(new File(buttonClick).toURI().toString());
        audio.setVolume(0.3);
        audio.play();
    }
    
    /**
     * Changes the {@link SoundPlayer#mute} boolean to opposite of it's current state.
     * This enables or dissables all sounds abilitie to be played.
     */
    public void mute() {
        this.mute = !mute;
    }
}
