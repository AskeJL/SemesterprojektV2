/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.sound;

import java.io.File;
import javafx.scene.media.AudioClip;

/**
 *
 * @author askel
 */
public class Soundplayer {

    String gameMusicFile = "assets/sounds/Visager_-_05_-_Battle.MP3";
    AudioClip gameMusic = new AudioClip(new File(gameMusicFile).toURI().toString());

    String backSoundOutsideFile = "assets/sounds/retro_beeps_collect_item_01.wav";
    AudioClip backSound = new AudioClip(new File(backSoundOutsideFile).toURI().toString());
    
    String backSound2File = "assets/sounds/background_room_interior_hum_loop_03.wav";
    AudioClip backSound2 = new AudioClip(new File(backSound2File).toURI().toString());

    public void playGameMusic() {
        if (gameMusic.isPlaying() == false) {
            gameMusic.setVolume(0.02);
            gameMusic.play();
        }
    }

    public void playLocationSound() {
        
        if (presentation.game.draw.DrawController.getCurrentLocationName() == "Outside") {
            if (backSound.isPlaying() == false) {
                backSound.play();
            }

        } else {
            if (backSound2.isPlaying() == false) {
                backSound2.setVolume(0.1);
                backSound2.play();
            }
        }
    }

    public void playDoorSound() {
        String musicFile = "assets/sounds/FREE_SOUND_FX_Doors_Sci_Fi_Space_Door.wav";
        AudioClip sound = new AudioClip(new File(musicFile).toURI().toString());
        sound.play();
    }

    public void playInteractionSound() {
        String musicFile = "assets/sounds/beep_04.wav";
        AudioClip sound = new AudioClip(new File(musicFile).toURI().toString());
        sound.play();
    }
    
    public void stopSounds(){
        gameMusic.stop();
        backSound.stop();
        backSound2.stop();
    }
}
