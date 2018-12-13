
package domain.sound;

import domain.GameElementGroup;
import domain.Manager;

public class SoundManager extends Manager {

    private static SoundPlayer sound;
    
    public SoundManager() {

    }
    
    
    @Override
    public void init() {
        GameElementGroup group = this.getGameElementGroup();
        sound = (SoundPlayer) group.getGameElement(SoundPlayer.class);
        
        super.init();
    }
    
    /**
     * Acesses method {@link domain.sound.SoundPlayer#playGameMusic() 
     */
    public void playGameMusic() {
        sound.playGameMusic();
    }

    /**
     * Acesses method {@link domain.sound.SoundPlayer#playLocationSound()
     */
    public void playLocationSound() {
        sound.playLocationSound();
    }
    
    /**
     * Acesses method {@link domain.sound.SoundPlayer#playDoorSound() 
     */
    public void playDoorSound() {
        sound.playDoorSound();
    }
    
    /**
     * Acesses method {@link domain.sound.SoundPlayer#playConsoleSound() 
     */
    public void playConsoleSound() {
        sound.playConsoleSound();
    }
    
    /**
     * Acesses method {@link domain.sound.SoundPlayer#playSireenSound() 
     */
    public void playSireenSound() {
        sound.playSireenSound();
    }
    
    /**
     * acesses method {@link domain.sound.SoundPlayer#stopSireenSound() 
     */
    public void stopSireenSound(){
        sound.stopSireenSound();
    }
    
    /**
     * Acesses method {@link domain.sound.SoundPlayer#playMoveSound() 
     */
     public void playMoveSound(){
         sound.playMoveSound();
     }
     
     /**
     * Acesses method {@link domain.sound.SoundPlayer#playAirSound() 
     */
     public void playAirSound(){
         sound.playAirSound();
     }
     
     /**
     * Acesses method {@link domain.sound.SoundPlayer#playLaserSound() 
     */
     public void playLaserSound(){
         sound.playLaserSound();
     }
     
     /**
     * Acesses method {@link domain.sound.SoundPlayer#playLaserChargeSound() 
     */
     public void playLaserChargeSound() {
         sound.playLaserChargeSound();
     }
     
     /**
     * Acesses method {@link domain.sound.SoundPlayer#playRepairSound() 
     */
     public void playRepairSound(){
         sound.playRepairSound();
     }
     
     /**
     * Acesses method {@link domain.sound.SoundPlayer#startSounds() 
     */
    public void startSounds() {
        sound.startSounds();
    }
    
    /**
     * Acesses method {@link domain.sound.SoundPlayer#stopSounds() 
     */
    public void stopSounds() {
        sound.stopSounds();
    }
    
    /**
     * Acesses method {@link domain.sound.SoundPlayer#mute() 
     */
    public void mute() {
        sound.mute();
    }

    @Override
    public String toString() {
        String info = "domain.sound.SoundManager";
        info += super.toString();
        return info;
    }
    
    /**
     * Acesses an instance of {@link domain.sound.SoundPlayer}
     * @return {@link #sound}
     */
    public SoundPlayer getSoundPlayer() {
        return sound;
    }
}
