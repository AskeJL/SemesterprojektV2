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
public class Time {

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

    private Time() {
    }

    /**
     * Initialize the class. This needs to be called before anything else. Will
     * set the {@link #initTime initTime}.
     */
    static void init() {
        initTime = new Date().getTime() / 1000;
    }

    /**
     * Update the class. This will update the {@link #currentTime currentTime}.
     */
    static void update() {
        currentTime = new Date().getTime() / 1000 - initTime;
    }

    /**
     * Set the {@link #waveTime waveTime}.
     *
     * @param time The new time.
     */
    static void setWaveTime(long time) {
        waveTime = time;
    }

    /**
     * Get the {@link #initTime initTime}.
     *
     * @return
     */
    static long getInitTime() {
        return Time.initTime;
    }

    /**
     * Get the {@link #currentTime currentTime}.
     *
     * @return
     */
    static long getCurrentTime() {
        return Time.currentTime;
    }

    /**
     * Get the {@link #waveTime waveTime}.
     *
     * @return
     */
    static long getWaveTime() {
        return waveTime;
    }

    /**
     * Get the {@link #getRemainingTime() remainingTime}.
     *
     * @return
     */
    static long getRemainingTime() {
        return waveTime - currentTime;
    }
}
