package controller.resources;

import controller.systems.SystemsController;

public class ResourcesController {
    
    
    
    /**
     * Method used to manipulate the time resource
     * @return time parameter
     */
    public static double getTime(){
       return Time.getTime();
    }
    public static void initTime(){
        Time.startTime();
    }
    public static void hitLife(int hitSmallFragments, int hitMediumFragments, int hitLargeFragments){
        Life.decreaseLife(hitSmallFragments, hitMediumFragments, hitLargeFragments);
    }
    public static void updateResources(){
        Time.updateTime();
        Life.updateLife();
    }
}    
