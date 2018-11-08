package controller.resources;

import java.util.Date;
/**
 * Class used to count time.
 */
public class Time extends Element {
    
    private static long initTime;
    private static long currentTime;
    
    /**
     * Method that sets start time and maximum time.
     */
    static void init(){
       initTime = new Date().getTime() / 1000;
    }
    /**
     * Method that compares updates time variable, based on current time.
     */
    static void update(){
        currentTime = new Date().getTime() / 1000 - initTime;
    }
    
    static long getInitTime() {
        return Time.initTime;
    }
    
    static long getCurrentTime() {
        return Time.currentTime;
    }
}
