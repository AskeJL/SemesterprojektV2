package domain.resources;

import java.util.Date;

/**
 * This is used by other systems to keep track of how much time passes. Because
 * of how the system works (prompts for user input on one thread), this class
 * proves to be vital for managing a system.
 *
 * @see domain.systems.Wave
 * @see domain.systems.SystemsController
 */
public class Time extends ResourcesElement {

    /**
     * The time when the {@link domain.game.Game} initialized.
     */
    private static long initTime;
    /**
     * How much time has passed since {@link #initTime initTime}.
     */
    private static long currentTime;
    /**
     * For how long time the wave elapses.
     */
    private static long waveTime;
    private static long randTime;

    Time(ResourcesController resources) {
        super(resources);
        
        initTime = new Date().getTime() / 1000;
    }

    /**
     * Update the class. This will update the {@link #currentTime currentTime}.
     */
    void update() {
        
    }

    /**
     * Set the {@link #waveTime waveTime}.
     *
     * @param time The new time.
     */
    void setWaveTime(long time) {
        waveTime = time;
    }

    /**
     * Get the {@link #initTime initTime}.
     *
     * @return
     */
    long getInitTime() {
        return Time.initTime;
    }

    /**
     * Get the {@link #currentTime currentTime}.
     *
     * @return
     */
    long getCurrentTime() {
        return new Date().getTime() / 1000 - initTime;
    }

    /**
     * Get the {@link #waveTime waveTime}.
     *
     * @return
     */
    long getWaveTime() {
        return waveTime;
    }

    /**
     * Get the {@link #getRemainingTime() remainingTime}.
     *
     * @return
     */
    long getRemainingTime() {
        return waveTime - (new Date().getTime() / 1000 - initTime);
    }
    
    void setRandTime(){
        randTime = ((long )(Math.random() * 20 + 5)); 
    }
    
    long getRandTime(){
        return randTime;
    }

    @Override
    protected boolean runTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
