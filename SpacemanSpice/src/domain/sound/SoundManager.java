/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.sound;

import domain.GameElementGroup;
import domain.Manager;

/**
 *
 * @author askel
 */
public class SoundManager extends Manager {

    private SoundPlayer sound;

    public SoundManager() {

    }

    @Override
    public void init() {
        GameElementGroup group = this.getGameElementGroup();
        this.sound = (SoundPlayer) group.getGameElement(SoundPlayer.class);

        super.init();
    }

    public void playGameMusic() {
        sound.playGameMusic();
    }

    public void playLocationSound() {
        sound.playLocationSound();
    }

    public void playDoorSound() {
        sound.playDoorSound();
    }

    public void playConsoleSound() {
        sound.playConsoleSound();
    }
    
    public void playSireenSound() {
        sound.playSireenSound();
    }
    
     public void playMoveSound(){
         sound.playMoveSound();
     }
     
     public void playAirSound(){
         sound.playAirSound();
     }
     
     public void playRepairSound(){
         sound.playRepairSound();
     }

    public void startSounds() {
        sound.startSounds();
    }

    public void stopSounds() {
        sound.stopSounds();
    }

    public void mute() {
        sound.mute();
    }

    @Override
    public String toString() {
        String info = "domain.sound.SoundManager";
        info += super.toString();
        return info;
    }
}
