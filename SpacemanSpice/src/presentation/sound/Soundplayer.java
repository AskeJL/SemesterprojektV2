/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.sound;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author askel
 */
public class Soundplayer {
    
    
    
    
    
    public static void playSound(){
        String musicFile = "C:/Users/askel/OneDrive/SemesterprojektV2/SpacemanSpice/assets/sounds/retro_beeps_collect_item_01.wav";

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    
}
