/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.interactions.commands;

import domain.interactions.Command;
import domain.systems.SystemsController;
import domain.tutorial.TutorialController;

public class Start extends Command {

    public Start() {
        super("start", "Starts the waves and score", false);
    }

    @Override
    public void checkAvailableParameters() {
        
    }

    @Override
    public void run() {
        SystemsController.setPlayerReady(true);
        TutorialController.setTutorial(false);
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Start: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        System.out.println("The start function will start the waves and score system");
    }

}