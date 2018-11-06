
package controller.systems;

import controller.resources.*;


public class SystemsController {

    SystemsController(){
        
    }
    
    
    public boolean initSystemsController(){
       boolean status = true;
       Score score = new Score();
       Life life = new Life();
       Oxygen oxygen = new Oxygen();
       
       while(status == true){
           
           Wave wave = new Wave();
           Time waveTimer = new Time();
           waveTimer.setMax(60);
           for(Here, we count time down){
               waveTimer.decreaseTime(1);
               oxygen.decreaseOxygen(1);
               
               
        }
               
               
           }
           
           
           
           
           
           if(life.getLife() == 0 || oxygen.getOxygen() == 0){
               status = false;
           }
           
           
           return status;
       }
      
       Time waveTimer = new Time();
       
       
       
    }
    /**
     * Destroy a small fragment and update score
     */
    
        
        
    
    
    public void controlWave(){
        
    }
    public void controlScore(){
        
    }
}


