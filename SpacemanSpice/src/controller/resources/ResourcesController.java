package controller.resources;

import controller.game.Controller;

public class ResourcesController extends Controller {
    
    public static void init(){
        Time.init();
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
}    
