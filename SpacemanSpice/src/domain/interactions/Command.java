package domain.interactions;

import domain.DomainReader;
import java.util.ArrayList;

public abstract class Command {
   
    private DomainReader reader = new DomainReader();
    
    /**
     * Name of the Command. (Part of the constructor)
     */
    private String name;
    /**
     * Description of the Command. (Part of the constructor)
     */
    private String description;
    /**
     * Whether or not the Command has a parameter. (Part of the constructor)
     */
    private boolean hasParameter;
    /**
     * The current parameter of this command. Is set in the {@link Commands}
     * class.
     */
    private String currentParameter;
    
    /**
     * All the parameters assigned to this command.
     */
    private final ArrayList<String> parameters = new ArrayList<>();
    /**
     * All the available parameters to this command. (Could vary depending on
     * the {@link domain.locations.Room room} etc.)
     */
    private ArrayList<String> availableParameters = new ArrayList<>();
    
    protected Command(String name, String description, boolean hasParameter) {        
        this.name = name;
        this.description = description;
        this.hasParameter = hasParameter;
    }
    
    /**
     * Validate that this command can be used if called.
     *
     * @param commandWord The command String to validate. (Will compare with
     * command {@link Command#name name}.
     * @return false if the command does not match and true if it does.
     */
    protected boolean validateCommand(String commandWord) {
        return this.name.equals(commandWord);
    }

    /**
     * Checks if the called parameter matches any of the
     * {@link Command#availableParameters}-
     */
    protected abstract void checkAvailableParameters();

    /**
     * Run the command itself. (After checking and validating the input)
     *
     * @see Command#validateCommand(String)
     * @see Command#checkAvailableParameters()
     */
    protected abstract void run();

    /**
     * Add a parameter to the commands parameter list.
     *
     * @param parameter to add.
     */
    protected void addParameter(String parameter) {
        this.parameters.add(parameter);
    }

    /**
     * Check to see if the parameter is within the commands
     * {@link Command#parameters parameter list}.
     *
     * @param parameter Parameter to check.
     * @return True if the parameter was found and false if not.
     */
    protected boolean checkParameter(String parameter) {
        for (String p : this.parameters) {
            if (p.equals(parameter)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check to see if the parameter is within the commands
     * {@link Command#availableParameters available parameter list}.
     *
     * @param parameter Parameter to check.
     * @return True if the parameter was found and false if not.
     */
    protected boolean checkAvailableParameter(String parameter) {
        for (String p : this.availableParameters) {
            if (p.toLowerCase().equals(parameter.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Display this commands {@link Command#parameters parameters} to the user.
     */
    protected void showParameters() {
        if (this.hasParameter) {
            String data = "";
            for (String parameter : this.parameters) {
                data += "    " + parameter + "\n";
            }

            reader.storeln("These are the parameters to the command " + this.name + ":\n" + data);
        }
    }

    /**
     * Display this commands
     * {@link Command#availableParameters available parameter list} to the user.
     */
    protected void showAvailableParameters() {
        if (this.hasParameter) {
            String data = "";
            for (String parameter : this.availableParameters) {
                data += "    " + parameter + "\n";
            }
            
            reader.storeln("These are the available parameters to the command " + this.name + ":\n" + data);
        }
    }

    @Override
    public String toString() {
        return "[GameMechanic]interactions.Command";
    }
    
    /**
     * The info to display when used as a parameter to the
     * '{@link domain.interactions.commands.Help help}' command.
     */
    public abstract void helpInfo();

    /**
     * Set the {@link Command#name name} of the command.
     *
     * @param name Name of the Command.
     */
    protected void setName(String name) {
        this.name = name;
    }

    /**
     * Set the {@link Command#description description} of the command.
     *
     * @param description Description of the Command.
     */
    protected void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the {@link Command#hasParameter hasParameter} of the command.
     *
     * @param bool Whether or not this command has a parameter.
     */
    protected void setHasParameter(boolean bool) {
        this.hasParameter = bool;
    }

    /**
     * Set the {@link Command#currentParameter currentParameter} of the command.
     *
     * @param parameter The name of the current parameter.
     */
    protected void setCurrentParameter(String parameter) {
        this.currentParameter = parameter;
    }

    /**
     * Set the {@link Command#availableParameters available parameters} of the
     * command.
     *
     * @param parameters Available parameters to set.
     */
    protected void setAvailableParameters(ArrayList<String> parameters) {
        this.availableParameters = parameters;
    }

    /**
     * Get the {@link Command#name} of the command.
     *
     * @return {@link #name}
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the {@link Command#description} of the command.
     *
     * @return
     */
    protected String getDescription() {
        return this.description;
    }

    /**
     * Get the {@link Command#hasParameter} of the command.
     *
     * @return
     */
    protected boolean hasParameter() {
        return this.hasParameter;
    }

    /**
     * Get the {@link Command#currentParameter} of the command.
     *
     * @return
     */
    protected String getCurrentParameter() {
        return this.currentParameter;
    }

    /**
     * Get the {@link Command#parameters} of the command.
     *
     * @return
     */
    protected ArrayList<String> getParameters() {
        return this.parameters;
    }

    /**
     * Get the {@link Command#availableParameters} of the command.
     *
     * @return
     */
    protected ArrayList<String> getAvailableParameters() {
        return this.availableParameters;
    }
}
