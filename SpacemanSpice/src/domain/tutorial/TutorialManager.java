package domain.tutorial;

import data.AssetType;
import data.Data;
import domain.Manager;
import domain.DomainReader;
import domain.GameElementGroup;
import domain.GameUpdateable;
import domain.interactions.Commands;
import domain.interactions.InteractionsManager;
import domain.interactions.commands.Clear;
import domain.locations.LocationsManager;
import domain.systems.SystemsManager;
import domain.systems.Wave;
import java.util.List;

public class TutorialManager extends Manager implements GameUpdateable {

    private final Data data = new Data();

    private List<String> introduction,
            gUIintroduction,
            gUIaIintro1,
            gUIaIintro2,
            gUIaIintro3,
            gUIaIintro4,
            gUIaIintro5,
            gUIaIintro6,
            gUIaIintro7,
            gUIaIintro8,
            gUIaIintro9,
            gUIaIintro10,
            gUIaIintro11,
            gUIaIintro12,
            gUIaIintro13,
            gUIaIintro14,
            gUIaIintro15,
            gUIaIintro16,
            gUIaIintro17,
            gUIaIintro18,
            aIintro1,
            aIintro2,
            aIintro3,
            aIintro4,
            aIintro5,
            aIintro6,
            aIintro7,
            aIintro8,
            aIintro9,
            aIintro10,
            aIintro11,
            aIintro12,
            aIintro13,
            aIintro14,
            aIintro15,
            aIintro16,
            aIintro17;

    private int counter = 0;
    private boolean gui = true;
    private boolean tutorial = true;
    private boolean continueActivated = false;
    private boolean scannerActivated = false;
    private boolean scannerCalibrated = false;
    private boolean laserActivated = false;
    private boolean laserCharged = false;
    private boolean oxygenActivated = false;
    private boolean oxygenCharged = false;
    private boolean damageRepairActivated = false;
    private boolean netActivated = false;
    private boolean netRepaired = false;
    private boolean steeringActivated = false;
    private boolean steeringCharged = false;
    

    private InteractionsManager interactionsManager;
    private LocationsManager locationsManager;
    private SystemsManager systemsManager;

    public TutorialManager() {

    }

    /**
     * Pre-load all the introduction files. Uses the
     * {@link TutorialData#getTextString(java.lang.String)} to get the files.
     */
    @Override
    public void init() {
        GameElementGroup group = this.gameElementGroup;

        interactionsManager = (InteractionsManager) group.getManagerGroup().getManager(InteractionsManager.class);
        locationsManager = (LocationsManager) group.getManagerGroup().getManager(LocationsManager.class);

        introduction = getTextToString("Non-GUI_Introduction.txt");
        aIintro1 = getTextToString("Non-GUI_AI_Intro1.txt");
        aIintro2 = getTextToString("Non-GUI_AI_Intro2.txt");
        aIintro3 = getTextToString("Non-GUI_AI_Intro3.txt");
        aIintro4 = getTextToString("Non-GUI_AI_Intro4.txt");
        aIintro5 = getTextToString("Non-GUI_AI_Intro5.txt");
        aIintro6 = getTextToString("Non-GUI_AI_Intro6.txt");
        aIintro7 = getTextToString("Non-GUI_AI_Intro7.txt");
        aIintro8 = getTextToString("Non-GUI_AI_Intro8.txt");
        aIintro9 = getTextToString("Non-GUI_AI_Intro9.txt");
        aIintro10 = getTextToString("Non-GUI_AI_Intro10.txt");
        aIintro11 = getTextToString("Non-GUI_AI_Intro11.txt");
        aIintro12 = getTextToString("Non-GUI_AI_Intro12.txt");
        aIintro13 = getTextToString("Non-GUI_AI_Intro13.txt");
        aIintro14 = getTextToString("Non-GUI_AI_Intro14.txt");
        aIintro15 = getTextToString("Non-GUI_AI_Intro15.txt");
        aIintro16 = getTextToString("Non-GUI_AI_Intro16.txt");
        aIintro17 = getTextToString("Non-GUI_AI_Intro17.txt");
        
        gUIintroduction = getTextToString("GUI_Introduction.txt");
        gUIaIintro1 = getTextToString("GUI_AI_Intro1.txt");
        gUIaIintro2 = getTextToString("GUI_AI_Intro2.txt");
        gUIaIintro3 = getTextToString("GUI_AI_Intro3.txt");
        gUIaIintro4 = getTextToString("GUI_AI_Intro4.txt");
        gUIaIintro5 = getTextToString("GUI_AI_Intro5.txt");
        gUIaIintro6 = getTextToString("GUI_AI_Intro6.txt");
        gUIaIintro7 = getTextToString("GUI_AI_Intro7.txt");
        gUIaIintro8 = getTextToString("GUI_AI_Intro8.txt");
        gUIaIintro9 = getTextToString("GUI_AI_Intro9.txt");
        gUIaIintro10 = getTextToString("GUI_AI_Intro10.txt");
        gUIaIintro11 = getTextToString("GUI_AI_Intro11.txt");
        gUIaIintro12 = getTextToString("GUI_AI_Intro12.txt");
        gUIaIintro13 = getTextToString("GUI_AI_Intro13.txt");
        gUIaIintro14 = getTextToString("GUI_AI_Intro14.txt");
        gUIaIintro15 = getTextToString("GUI_AI_Intro15.txt");
        gUIaIintro16 = getTextToString("GUI_AI_Intro16.txt");
        gUIaIintro17 = getTextToString("GUI_AI_Intro17.txt");
        gUIaIintro18 = getTextToString("GUI_AI_Intro18.txt");
        
        super.init();
    }

    /**
     * Check how far the player has come in the introduction. Will use
     * {@link TutorialData#println(List)} to print the next dialog for the
     * player.
     */
    @Override
    public void update() {
        if (gui == true) {
            if (tutorial) {
                Commands commands = interactionsManager.getCommands();
                
                switch (counter) {
                    case 0:
                        println(gUIintroduction);
                        counter++;
                        System.out.println("This is the GUI tutorial.");

                        break;
                    case 1:
                        if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue") || continueActivated == true) {
                            println(gUIaIintro1);
                            commands.setLastCommand(new Clear());
                            counter++;
                        }
                        break;
                    case 2:
                        if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue") || continueActivated == true) {
                            println(gUIaIintro2);
                            commands.setLastCommand(new Clear());
                            counter++;
                        }
                        break;
                    case 3:
                        if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue") || continueActivated == true) {
                            println(gUIaIintro3);
                            commands.setLastCommand(new Clear());
                            counter++;
                        }
                        break;
                    case 4:
                        if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue") || continueActivated == true) {
                            println(gUIaIintro4);
                            commands.setLastCommand(new Clear());
                            counter++;
                        }
                        break;
                    case 5:
                        if (scannerActivated == true) {
                            println(gUIaIintro5);
                            counter++;
                        }
                        break;
                    case 6:
                        if (/*scannerCalibrated == true &&*/ scannerActivated == true) {
                            println(gUIaIintro6);
                            counter++;
                        }
                        break;
                    case 7:
                        if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue") || continueActivated == true) {
                            println(gUIaIintro7);
                            commands.setLastCommand(new Clear());
                            counter++;
                        }
                        break;
                    case 8:
                        if (laserCharged == true && laserActivated == true) {
                            println(gUIaIintro8);
                            counter++;
                        }
                        break;
                    case 9:
                        if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue") || continueActivated == true) {
                            println(gUIaIintro9);
                            commands.setLastCommand(new Clear());
                            counter++;
                        }
                        break;
                    case 10:
                        if (netRepaired == true && netActivated == true) {
                            println(gUIaIintro10);
                            counter++;
                        }
                        break;
                    case 11:
                        if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue") || continueActivated == true) {
                            println(gUIaIintro11);
                            commands.setLastCommand(new Clear());
                            counter++;
                        }
                        break;
                    case 12:
                        if (steeringActivated == true) {
                            println(gUIaIintro12);
                            counter++;
                        }
                        break;
                    case 13:
                        if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue") || continueActivated == true) {
                            println(gUIaIintro13);
                            commands.setLastCommand(new Clear());
                            counter++;
                        }
                        break;
                    case 14:
                        if (damageRepairActivated == true) {
                            println(gUIaIintro14);
                            counter++;
                        }
                        break;
                    case 15:
                        if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue") || continueActivated == true) {
                            println(gUIaIintro15);
                            commands.setLastCommand(new Clear());
                            counter++;
                        }
                        break;
                    case 16:
                        if (oxygenActivated == true) {
                            println(gUIaIintro16);
                            counter++;
                        }
                        break;
                    case 17:
                        if (oxygenCharged == true && oxygenActivated == true) {
                            println(gUIaIintro17);
                            counter++;
                        }
                        break;
                    case 18:
                        if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue") || continueActivated == true) {
                            println(gUIaIintro18);
                            commands.setLastCommand(new Clear());
                            counter++;
                            setTutorial(false);
                        }
                        break;
                }
                continueActivated = false;
                scannerActivated = false;
                laserActivated = false;
                oxygenActivated = false;
                damageRepairActivated = false;
                netActivated = false;
                steeringActivated = false;
            }
        } else if (tutorial) {
            Commands commands = interactionsManager.getCommands();
            switch (counter) {
                case 0:
                    println(introduction);
                    counter++;
                    System.out.println("This is not the GUI tutorial.");

                    break;
                case 1:
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro1);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 2:
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro2);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 3:
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro3);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 4:
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("show") && interactionsManager.getLastParameter().equals("map")) {
                        println(aIintro4);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 5:
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro5);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 6:
                    if (locationsManager.getCurrentRoom().getName().equalsIgnoreCase("Scanning Control") && interactionsManager.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro6);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 7:
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro7);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 8:
                    if (locationsManager.getCurrentRoom().getName().equalsIgnoreCase("Laser Controls") && interactionsManager.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro8);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 9:
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro9);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 10:
                    if (locationsManager.getCurrentRoom().getName().equalsIgnoreCase("Net Control") && interactionsManager.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro10);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 11:
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro11);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 12:
                    if (locationsManager.getCurrentRoom().getName().equalsIgnoreCase("Control Steering") && interactionsManager.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro12);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 13:
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro13);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 14:
                    if (locationsManager.getCurrentRoom().getName().equalsIgnoreCase("Outside") && interactionsManager.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro14);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 15:
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("show") && interactionsManager.getLastParameter().equals("oxygen")) {
                        println(aIintro15);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 16:
                    if (locationsManager.getCurrentRoom().getName().equalsIgnoreCase("Oxygen Refuel") && interactionsManager.getLastCommandName().equalsIgnoreCase("interact")) {
                        println(aIintro16);
                        commands.setLastCommand(new Clear());
                        counter++;
                    }
                    break;
                case 17:
                    if (interactionsManager.getLastCommandName().equalsIgnoreCase("continue")) {
                        println(aIintro17);
                        counter++;
                        setTutorial(false);
                    }
                    break;
            }
        }
    }

    /**
     * Print a List of Strings to the console.
     *
     * @param text List to print.
     */
    void println(List<String> text) {
        DomainReader reader = new DomainReader();
        for (String string : text) {
            reader.storeln(string);
        }
    }

    @Override
    public String toString() {
        String info = "domain.tutorial.TutorialManager";
        info += super.toString();
        return info;
    }

    /**
     * Request data from the data-layer using
     * {@link TutorialData#requestData(data.AssetType, java.lang.String)}.
     *
     * @param filename The name of the file.
     * @return
     */
    List<String> getTextToString(String filename) {
        return data.readData(AssetType.TEXT, filename);
    }

    public boolean getTutorial() {
        return this.tutorial;
    }

    public void setTutorial(boolean bool) {
        this.tutorial = bool;
    }
    
    public void setContinue(boolean bool) {
        this.continueActivated = bool;
        
    }
    
    public void setScannerActivated(boolean bool) {
        this.scannerActivated = bool;
    }
    
    public void setScannerCalibrated(boolean bool) {
        this.scannerCalibrated = bool;
    }
    
    public void setLaserActivated(boolean bool) {
        this.laserActivated = bool;
    }
    
    public void setLaserCharged(boolean bool) {
        this.laserCharged = bool;
    }
    
    public void setOxygenActivated(boolean bool) {
        this.oxygenActivated = bool;
    }
    
    public void setOxygenCharged(boolean bool) {
        this.oxygenCharged = bool;
    }
    
    public void setDamageRepairActivated(boolean bool) {
        this.damageRepairActivated = bool;
    }
    
    public void setNetActivated(boolean bool) {
        this.netActivated = bool;
    }
    
    public void setNetRepaired(boolean bool) {
        this.netRepaired = bool;
    }
    
    public void setSteeringActivated(boolean bool) {
        this.steeringActivated = bool;
    }
    
    public void setSteeringCharged(boolean bool) {
        this.steeringCharged = bool;
    }
}
