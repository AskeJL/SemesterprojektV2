
package controller.resources;

import controller.locations.LocationsController;

/**
 * Class that controls the oxygen resource
 */
public class Oxygen extends Element {
    
    private static int oxygen = 100;
    
    public static void updateOxygen(){
        if(Life.getLife() <= 50){
                //LocationsController.getCurrentRoom().getName().equals("outside")){
            oxygen -= (Time.getStartTime()-Time.getOxygenTime()-(Time.getcurrentTime()));
        }
        Time.setOxygenTime(Time.getcurrentTime());
        System.out.println(oxygen);
        System.out.println(Time.getOxygenTime());
        System.out.println(Time.getcurrentTime());
    }
    /**
     * Method used to decrease the oxygen variable
     * @param decreaseVariable
     */
    public void decreaseOxygen(int decreaseVariable){
        oxygen -= decreaseVariable;
    }
    
    /**
     * Method used to increase the oxygen variable
     */
    
    public void increaseOxygen(){
        
    }
    
    @Override
    public void update(){
        
    }
    
    public double getOxygen(){
        return this.oxygen;
    }
}
