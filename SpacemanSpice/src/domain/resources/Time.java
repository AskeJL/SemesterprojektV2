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

    @Override
    public void decreaseValue(int value) {

    }

    @Override
    public void increaseValue(int value) {

    }

    /**
     * Set the {@link #waveTime waveTime}.
     *
     * @param time The new time.
     */
    public void setWaveTime(long time) {
        waveTime = time;
    }

    public void setRandomTime() {
        randTime = ((long) (Math.random() * 20 + 5));
    }

    @Override
    public void setValue(int value) {
        
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
    public long getCurrentTime() {
        return new Date().getTime() / 1000 - initTime;
    }

    /**
     * Get the {@link #waveTime waveTime}.
     *
     * @return
     */
    public long getWaveTime() {
        return waveTime;
    }

    /**
     * Get the {@link #getRemainingTime() remainingTime}.
     *
     * @return
     */
    public long getRemainingTime() {
        return waveTime - (new Date().getTime() / 1000 - initTime);
    }

    public long getRandomTime() {
        return randTime;
    }

    @Override
    public int getValue() {
        return (int) (new Date().getTime() / 1000 - initTime);
    }
}
