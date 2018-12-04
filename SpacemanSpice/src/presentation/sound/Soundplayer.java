/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.sound;

import domain.locations.LocationsReader;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author askel
 */
public class Soundplayer{

    public void playLocationSound() {

        if ( presentation.game.draw.DrawController.getCurrentLocationName() == "Outside") {
            String musicFile = "C:/Users/askel/OneDrive/SemesterprojektV2/SpacemanSpice/assets/sounds/retro_beeps_collect_item_01.wav";
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();

        } else {
            String musicFile = "C:/Users/askel/OneDrive/SemesterprojektV2/SpacemanSpice/assets/sounds/background_room_interior_hum_loop_03.wav";
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        }
    }

    public void playDoorSound() {
        String musicFile = "C:/Users/askel/OneDrive/SemesterprojektV2/SpacemanSpice/assets/sounds/FREE_SOUND_FX_Doors_Sci_Fi_Space_Door.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public void playInteractionSound() {
        String musicFile = "C:/Users/askel/OneDrive/SemesterprojektV2/SpacemanSpice/assets/sounds/beep_04.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}
