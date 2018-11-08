package controller.resources;

import java.util.Date;
/**
 * Class used to count time.
 */
public class Time extends Element {
    
    private static double time = 0;
    
    private static Date startTime = new Date();
    private static long startTimeVariable;
    
    private static long maxTime;
    
    private static Date compareTime = new Date();
    private static long compareTimeVariable;
    
    /**
     * Method that sets start time and maximum time.
     */
    public static void startTime(){
       startTimeVariable = (startTime.getTime()/1000);
       maxTime = startTimeVariable + 60;
    }
    /**
     * Method that compares updates time variable, based on current time.
     */
    public static void updateTime(){
        if(time == 0){
            startTime();
        }
        compareTimeVariable =(compareTime.getTime()/1000);
        time = maxTime - compareTimeVariable;
    }
    
    static double getTime(){
        return time;
    }
    
}
