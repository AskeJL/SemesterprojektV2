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
import presentation.tiles.InteractableType;
import static presentation.tiles.InteractableType.EAST;

/**
 *
 * @author askel
 */
public class Soundplayer implements LocationsReader {
    
    
    public void playLocationSound(){
        
        if (this.readCurrentRoom() == "Outside"){
        String musicFile = "C:/Users/askel/OneDrive/SemesterprojektV2/SpacemanSpice/assets/sounds/retro_beeps_collect_item_01.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        }
        else{
        String musicFile = "C:/Users/askel/OneDrive/SemesterprojektV2/SpacemanSpice/assets/sounds/retro_beeps_collect_item_01.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        }
    }
    
    public void playInteractionSound(){
        
        if("" == ""){
        String musicFile = "C:/Users/askel/OneDrive/SemesterprojektV2/SpacemanSpice/assets/sounds/beep_04.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        }
        else{
        String musicFile = "C:/Users/askel/OneDrive/SemesterprojektV2/SpacemanSpice/assets/sounds/FREE_SOUND_FX_Doors_Sci_Fi_Space_Door.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        }
    }
    
}
