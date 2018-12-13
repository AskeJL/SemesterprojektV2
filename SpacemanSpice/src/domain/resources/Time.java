package domain.resources;

import domain.GameElement;
import domain.GameUpdateable;
import java.util.Date;

public class Time extends GameElement implements ResourcesElement, GameUpdateable {

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

    public Time() {
        
    }
    
    /**
     * Initializes the time.
     */
    @Override
    public void init() {
        initTime = new Date().getTime() / 1000;
    }
    
    /**
     * Update the class. This will update the {@link #currentTime currentTime}.
     */
    @Override
    public void update() {
        
    }
    
    /**
    * Nothing to decrease in time
    */
    @Override
    public void decreaseValue(int value) {
        //Nothing to decrease
    }
    
    /**
    * Nothing to increase in time
    */
    @Override
    public void increaseValue(int value) {
        //Noting to increase
    }

    /**
     * Set the {@link #waveTime waveTime}.
     *
     * @param time The new time.
     */
    public void setWaveTime(long time) {
        waveTime = time;
    }
    
    /**
     * set {@link #randTime randTime} to a random between 5 and 25
     */
    public void setRandomTime() {
        randTime = ((long) (Math.random() * 20 + 5));
    }
    
    /*
    * Nothing to set in time
    */
    @Override
    public void setValue(int value) {
        //Nothing to set
    }

    /**
     * Get the {@link #initTime initTime}.
     *
     * @return the init time
     */
    long getInitTime() {
        return Time.initTime;
    }

    /**
     * Get the {@link #currentTime currentTime}.
     *
     * @return the current time
     */
    public long getCurrentTime() {
        return new Date().getTime() / 1000 - initTime;
    }

    /**
     * Get the {@link #waveTime waveTime}.
     *
     * @return the current time since wave was created
     */
    public long getWaveTime() {
        return waveTime;
    }

    /**
     * Get the {@link #getRemainingTime() remainingTime}.
     *
     * @return the remaining wave time
     */
    public long getRemainingTime() {
        return waveTime - (new Date().getTime() / 1000 - initTime);
    }
    
    /**
     * get value for {@link #setRandomTime()}
     * 
     * @return {@link #randTime random time}
     */
    public long getRandomTime() {
        return randTime;
    }
    
    /**
     * gets time between {@link #initTime initTime} and current time
     * 
     * @return int currentTime - initTime
     */
    @Override
    public int getValue() {
        return (int) (new Date().getTime() / 1000 - initTime);
    }
}
