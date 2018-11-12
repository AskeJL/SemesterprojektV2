package controller.resources;

import controller.game.Controller;

public class ResourcesController extends Controller {
    
    public static void init(){
        Time.init();
        
        Time.update();
        Oxygen.update();
    }
    
    public static void update(){
        Time.update();
        Oxygen.update();
        Life.updateLife();
    }
    public static void hitLife(int hitSmallFragments, int hitMediumFragments, int hitLargeFragments){
        Life.decreaseLife(hitSmallFragments, hitMediumFragments, hitLargeFragments);
    }
    
    public static long getCurrentTime() {
        return Time.getCurrentTime();
    }
    
    public static long getInitTime() {
        return Time.getInitTime();
    }
    
    public static int getOxygen() {
        return Oxygen.getOxygen();
    }
    
    public static void increaseOxygen(int oxygen){
        controller.resources.Oxygen.increaseOxygen(oxygen);
    }
    
    public static void increaseLife(boolean repair, int repairTimes){
        controller.resources.Life.increaseLife(repair, repairTimes);
    }
    
    public static void setWaveTime(long newWaveTime){
        Time.setWaveTime(newWaveTime);
    }
    
    public static long getWaveTime(){
        return Time.getWaveTime();
    }
}    
