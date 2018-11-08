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
    
    /**
     * Life update ved afslutning af en wave.
     */
    if(this.getTime() == 0) {
        SystemController.getSmallFragments();
        SystemController.getMediumFragments();
        SystemController.getLargeFragments();
        
        if(SystemController.getSmallFragments() >= 1) {
            life -= (smallFragmentDamage * SystemController.getSmallFragments())
        }
        if(SystemController.getMediumFragments() >= 1) {
            life -= (mediumFragmentDamage * SystemController.getMediumFragments())
        }
        if(SystemController.getLargeFragments() >= 1) {
            life -= (largeFragmentDamage * SystemController.getLargeFragments())
        }
        
    }
    
    
    
    /**
     * Method used to manipulate the life resource
     */
    public void controlLife(){
        
    }
    
    /**
     * Method used to manipulate the oxygen resource
     */
    public void controlOxygen(){
        
    }
