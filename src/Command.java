/**
 * Created by jeffreyhammond on 10/10/16.
 */
public enum Command {

    WEST("west", "w"), NORTH("north", "n"), SOUTH("south", "s"), EAST("east", "e"), INVENTORY("inventory", "i"), GO("go", "g"), QUIT("quit", "q"), NO_COMMAND("none", ""), UNKNOWN("unknown", "na");

    private String abreviation;
    private String name;

    Command (String command, String abbreviation) {
        this.abreviation = abbreviation;
        this.name = command;
    }

    public static Command getCommand(String abreviation) {
        for(Command command: Command.values()) {
            if(abreviation.toLowerCase().startsWith(command.getAbreviation())) {
                return command;
            }
        }
        return UNKNOWN;
    }

    public String getName() {
        return name;
    }

    public String getAbreviation() {
        return abreviation;
    }

    @Override
    public String toString() {
        return name;
    }
}
