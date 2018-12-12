/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.sound;

import domain.GameElement;
import domain.GameElementGroup;
import java.io.File;
import javafx.scene.media.AudioClip;
import presentation.draw.DrawController;

/**
 *
 * @author askel
 */
public class SoundPlayer extends GameElement {

    private boolean game = true;
    private boolean mute = false;
    private final DrawController drawController;
    private SoundManager soundManager;

    String gameMusicFile = "assets/sounds/Space_Pursuit.wav";
    AudioClip gameMusic = new AudioClip(new File(gameMusicFile).toURI().toString());

    String backSoundOutsideFile = "assets/sounds/retro_beeps_collect_item_01.wav";
    AudioClip backSound = new AudioClip(new File(backSoundOutsideFile).toURI().toString());

    String backSound2File = "assets/sounds/Background_spacesounds.wav";
    AudioClip backSound2 = new AudioClip(new File(backSound2File).toURI().toString());

    public SoundPlayer(DrawController draw) {
        this.drawController = draw;
    }

    @Override
    public void init() {
         GameElementGroup group = this.gameElementGroup;
        
        soundManager = (SoundManager) group.getManager();
    }

    public void playGameMusic() {
        if (game == true && mute == false) {
            if (gameMusic.isPlaying() == false) {
                gameMusic.setVolume(0.2);
                gameMusic.play();
            }
        }
    }

    public void playLocationSound() {

        if (game == true && mute == false) {
            if ("Outside".equals(drawController.getCurrentLocationName())) {
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
    }

    public void playDoorSound() {
        if (mute == false) {
            String musicFile = "assets/sounds/FREE_SOUND_FX_Doors_Sci_Fi_Space_Door.wav";
            AudioClip sound = new AudioClip(new File(musicFile).toURI().toString());
            sound.play();
        }
    }

    public void playInteractionSound() {
        if (mute == false) {
            String musicFile = "assets/sounds/beep_04.wav";
            AudioClip sound = new AudioClip(new File(musicFile).toURI().toString());
            sound.play();
        }
    }

    public void startSounds() {
        this.game = true;
    }

    public void stopSounds() {
        gameMusic.stop();
        backSound.stop();
        backSound2.stop();
        this.game = false;
    }

    public void mute() {
        this.mute = !mute;
    }
}
