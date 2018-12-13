/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.sound;

import domain.DomainReader;
import domain.GameElement;
import domain.GameElementGroup;
import domain.locations.LocationsManager;
import java.io.File;
import javafx.scene.media.AudioClip;
import presentation.GUIManager;
import presentation.draw.DrawController;

/**
 *
 * @author askel
 */
public class SoundPlayer extends GameElement {

    private boolean game = true;
    private boolean mute = false;
    private DrawController drawController;
    private LocationsManager locationsManager;
    String a = "outside";
    int door = 1;

    private final String gameMusicFile = "assets/sounds/Space_Pursuit.wav";
    private AudioClip gameMusic = new AudioClip(new File(gameMusicFile).toURI().toString());

    String backSoundFile = "assets/sounds/Background_spacesounds.wav";
    AudioClip backSound = new AudioClip(new File(backSoundFile).toURI().toString());
    
    String sireenSoundFile = "assets/sounds/alarm_siren_warning_01.wav";
    AudioClip sireenSound = new AudioClip(new File(sireenSoundFile).toURI().toString());
    
    String moveSpaceshipSoundFile = "assets/sounds/retro_spaceship_engine_03.wav";
    AudioClip moveSpaceshipSound = new AudioClip(new File(moveSpaceshipSoundFile).toURI().toString());
    
    String consoleSoundFile = "assets/sounds/beep_04.wav";
    AudioClip consoleSound = new AudioClip(new File(consoleSoundFile).toURI().toString());
    
    String airSoundFile = "assets/sounds/AirTank_Sound.wav";
    AudioClip airSound = new AudioClip(new File(airSoundFile).toURI().toString());
   
    String repairSoundFile = "assets/sounds/RepairSound.wav";
    AudioClip repairSound = new AudioClip(new File(repairSoundFile).toURI().toString());
    
    String laserSoundFile = "assets/sounds/sci-fi_weapon_laser_small_03.wav";
    AudioClip laserSound = new AudioClip(new File(laserSoundFile).toURI().toString());
    
    

    
    private final String buttonHover = "assets/sounds/menu/button_hover.wav";
    private final String buttonClick = "assets/sounds/menu/button_click.wav";

    @Override
    public void init() {
        GameElementGroup group = this.gameElementGroup;
        GUIManager gui = (GUIManager) group.getManagerGroup().getManager(GUIManager.class);
        drawController = (DrawController) gui.getGameElementGroup().getGameElement(DrawController.class);
        this.locationsManager = (LocationsManager)group.getManagerGroup().getManager(LocationsManager.class);
    }

    public void playGameMusic() {
        if (game == true && mute == false && locationsManager.getCurrentLocation() != null && !locationsManager.getCurrentLocation().getName().equalsIgnoreCase(a)) {
            if (gameMusic.isPlaying() == false) {
                gameMusic.setVolume(0.2);
                gameMusic.play();
            }
        }  if (locationsManager.getCurrentLocation() != null && locationsManager.getCurrentLocation().getName().equalsIgnoreCase(a)) {
            gameMusic.stop();
        }
    }

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

    public void playDoorSound() {
        if (mute == false) {
            if (door == 1){
            String musicFile = "assets/sounds/FREE_SOUND_FX_Doors_Sci_Fi_Space_Door.wav";
            AudioClip sound = new AudioClip(new File(musicFile).toURI().toString());
            sound.play();
            door = 2;
            } else if (door == 2) {
                String musicFile = "assets/sounds/FREE_SOUND_FX_Doors_Sci_Fi_Space_Door2.wav";
                AudioClip sound = new AudioClip(new File(musicFile).toURI().toString());
                sound.play();
                door = 3;
            } else if (door == 3){
                String musicFile = "assets/sounds/FREE_SOUND_FX_Doors_Sci_Fi_Space_Door3.wav";
                AudioClip sound = new AudioClip(new File(musicFile).toURI().toString());
                sound.play();
                door = 4;
            }
        }
    }

    public void playConsoleSound() {
        if (mute == false) {
            consoleSound.play();
        }
    }
    
    public void playSireenSound(){
        if (mute == false){
            if (gameMusic.isPlaying() == false) {
            sireenSound.play();
            }
        }
    }
    
    public void playMoveSound(){
        if (mute == false){
            moveSpaceshipSound.play();
        }
    }
    
    public void playAirSound(){
        if (mute == false){
            airSound.play();
        }
    }
    
    public void playRepairSound(){
        if (mute == false){
            repairSound.play();
        }
    }
        
    public void playLaserSound(){
        if (mute == false){
            laserSound.play();
        } 
    }

    public void startSounds() {
        this.game = true;
    }

    public void stopSounds() {
        gameMusic.stop();
        backSound.stop();
        this.game = false;
    }

    public void playButtonHoverSound() {
        AudioClip audio = new AudioClip(new File(buttonHover).toURI().toString());
        audio.setVolume(0.3);
        audio.play();
    }
    
    public void playButtonClickSound() {
        AudioClip audio = new AudioClip(new File(buttonClick).toURI().toString());
        audio.setVolume(0.3);
        audio.play();
    }
    
    public void mute() {
        this.mute = !mute;
    }
}
