package controller.resources;

import java.util.Date;

/**
 * Class used to count time.
 */
public class Time {

    private static long initTime;
    private static long currentTime;
    private static long waveTime;

    private Time() {
        
    }

    /**
     * Method that sets start time and maximum time.
     */
    static void init() {
        initTime = new Date().getTime() / 1000;
    }

    /**
     * Method that compares updates time variable, based on current time.
     */
    static void update() {
        currentTime = new Date().getTime() / 1000 - initTime;
    }

    static long getInitTime() {
        return Time.initTime;
    }

    static long getCurrentTime() {
        return Time.currentTime;
    }

    static void setWaveTime(long newWaveTime) {
        waveTime = newWaveTime;
    }

    static long getWaveTime() {
        return waveTime;
    }

    static long getRemainingTime() {
        return waveTime - currentTime;
    }
}
