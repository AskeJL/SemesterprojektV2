package controller.resources;

import java.util.Date;
/**
 * Class used to count time.
 */
public class Time extends Element {
    
    private static long waveTime = 0;
    private static long countdown = 60;
    
    private static long startWaveTime;
    
    private static long maxWaveTime;
    
    private static long currentTime;
    
    private static long oxygenTime;
    
    /**
     * Method that sets start time and maximum time.
     */
    public static void startTime(){
       startWaveTime = (new Date().getTime()/1000);
       maxWaveTime = startWaveTime + countdown;
    }
    /**
     * Method that compares updates time variable, based on current time.
     */
    public static void updateTime(){
        if(waveTime == 0){
            startTime();
        }
        currentTime =(new Date().getTime()/1000);
        waveTime = maxWaveTime - currentTime;
        System.out.println(waveTime);
    }
    
    static long getTime(){
        return waveTime;
    }
    
    static long getcurrentTime(){
        return currentTime;
    }
    
    static long getOxygenTime(){
        return oxygenTime;
    }
    
    static long getStartTime(){
        return startWaveTime;
    }
    
    static void setOxygenTime(long newOxygenTime){
        oxygenTime = newOxygenTime;
    }
}
