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
}    
