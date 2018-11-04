package controller.interactions;

import java.util.ArrayList;

public abstract class Command {

    private String name;
    private String description;
    private boolean hasParameter;
    private String currentParameter;

    private ArrayList<String> parameters = new ArrayList<>();

    protected Command(String name, String description, boolean hasParameter) {
        this.name = name;
        this.description = description;
        this.hasParameter = hasParameter;
    }

    /**
     * Validate that this command can be used if called.
     *
     * @param commandWord The command String to validate. (Will compare with
     * command name.
     * @return false if the command is not accessible and true if it is.
     */
    public boolean validateCommand(String commandWord) {
        return this.name.equals(commandWord);
    }

    /**
     * Checks if the parameter is valid based on where the player currently is.
     *
     * @return false if the parameter isn't valid, true if it is.
     */
    public abstract boolean check();

    /**
     * Run the command itself. (After checking and validating the input)
     */
    public abstract void run();

    public void addParameter(String parameter) {
        this.parameters.add(parameter);
    }

    public boolean checkParameter(String parameter) {
        for (String p : this.parameters) {
            if (p.equals(parameter)) {
                return true;
            }
        }
        return false;
    }

    public void showParameters() {
        if(this.hasParameter) {
            System.out.println("These are the available parameters to the command " + this.name + ":");
            int i = 1;
            for(String parameter : this.parameters) {
                System.out.format("%s %10s\n", i, parameter);
                i++;
            }
        }
    }
    
    @Override
    public abstract String toString();

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHasParameter(boolean bool) {
        this.hasParameter = bool;
    }

    public void setCurrentParameter(String parameter) {
        this.currentParameter = parameter;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean hasParameter() {
        return this.hasParameter;
    }

    public String getCurrentParameter() {
        return this.currentParameter;
    }
}
