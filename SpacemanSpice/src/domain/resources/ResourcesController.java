package domain.resources;

import domain.game.Controller;
import domain.locations.LocationsController;
import domain.systems.SystemsController;

public class ResourcesController extends Controller {
    
    public static void init(){
        Time.init();
        
        Time.update();
        Oxygen.update();
    }
    
    public static void update(){
        Time.update();
        Oxygen.update();
        if(Oxygen.getOxygen() <= 0 ){
            System.out.println("You are out of oxygen. Too bad, you are dead..");
            System.out.println("Score: " + SystemsController.getScore());
            Controller.setRunning(false);
        }
        Life.update();
        if(Life.getLife() < 80){
            LocationsController.disableMainhalls();
        }
        else if(Life.getLife() >= 80){
            LocationsController.enableMainhalls();
        }
        else if(Life.getLife() <= 0){
            System.out.println("The ship is destroyed. Too bad, you are dead..");
            System.out.println("Score: " + SystemsController.getScore());
            Controller.setRunning(false);
        }
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
    
    public static int getLife(){
        return Life.getLife();
    }
    
    public static long getRemainingTime(){
        return Time.getRemainingTime();
    }
    
    public static void increaseOxygen(int oxygen){
        Oxygen.increaseOxygen(oxygen);
    }
    
    public static void setRepairTrue(){
        Life.setRepairTrue();
    }
    
    public static void setWaveTime(long newWaveTime){
        Time.setWaveTime(newWaveTime);
    }
    
    public static long getWaveTime(){
        return Time.getWaveTime();
    }
}    
