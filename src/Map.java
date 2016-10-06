import java.awt.*;
import java.util.Scanner;

/**
 * Created by jeffreyhammond on 10/6/16.
 */
public class Map {

    //method to read a map from a text file
    //The first line contains two integers, separated by white space, that tell the number of rows (r) and columns (c) in the map.
    //The rest of the file is the terrain map

    //The character should start out at (0, 0)
    //first coordinate should be the north/south coordinate (row), which should increase when the game character moves south. The second coordinate should be the east/west coordinate (column)
    //Each time the game character moves, your program should print a message showing the coordinates of the square the character moved to and the terrain of the character's location

    //show the terrain of the map squares surrounding the game character's location.
    //Surrounding map squares are shown in a 3 by 3 square of characters (letters, numbers, or punctuation)

    //Use a capital X to show that squares are off the map

    //method to get the terrain (represented by a char value)

    //also define a Loc class that contains row and column values.
    Point location = new Point(0, 0);

    public void inputHandler () {
        //get a scanner
        Scanner in = new Scanner(System.in);
        String command = "";

        while (!isCommand(command, "q")) {
            System.out.print("> ");
            //get user input from command line
            command = in.nextLine();

            //put input into array
            String[] strCommands = command.split(" +");

            //if statement that checks the command
            command = strCommands[0];
            if (isCommand(command, "g")) {
                if (strCommands.length > 1) {
                    command = strCommands[1];
                    if (isCommand(command, "n")) {
                        String north = "north";
                        Point newLocal = updateNorthSouthLocation(location, -1);
                        if (isOutOfBounds(newLocal)) {
                            //message that would be out of bounds
                            printOutOfBoundsMessage(north);
                        } else {
                            //set new loccation
                            location = newLocal;
                            //dispaly message to user about travel direction
                            printDirectionMoving(north);
                        }
                    } else if (isCommand(command, "s")) {
                        String south = "south";
                        Point newLocal = updateNorthSouthLocation(location, 1);
                        if (isOutOfBounds(newLocal)) {
                            //message that would be out of bounds
                            printOutOfBoundsMessage(south);
                        } else {
                            //set new loccation
                            location = newLocal;
                            //dispaly message to user about travel direction
                            printDirectionMoving(south);
                        }
                    } else if (isCommand(command, "e")) {
                        String east = "east";
                        Point newLocal = updateEastWestLocation(location, 1);
                        if (isOutOfBounds(newLocal)) {
                            //message that would be out of bounds
                            printOutOfBoundsMessage(east);
                        } else {
                            //set new loccation
                            location = newLocal;
                            //dispaly message to user about travel direction
                            printDirectionMoving(east);
                        }
                    } else if (isCommand(command, "w")) {
                        String west = "west";
                        Point newLocal = updateEastWestLocation(location, -1);
                        if (isOutOfBounds(newLocal)) {
                            //message that would be out of bounds
                            printOutOfBoundsMessage(west);
                        } else {
                            //set new loccation
                            location = newLocal;
                            //dispaly message to user about travel direction
                            printDirectionMoving(west);
                        }
                    } else {
                        //unrecognized
                        System.out.println("You can't go that way.");
                    }
                }
            } else if (isCommand(command, "i")) {
                GameChar character = new GameChar();
                character.printInventory();

            } else if (isCommand(command, "q")) {
                //display farewell message
                System.out.println("Farewell");
            } else {
                //unrecognized command
                //Invalid command: ?
                System.out.println("Invalid command: " + command);
            }
            //display message to user about current location
            printCoordinate(location);
        }
    }
    public boolean isCommand(String command, String abreviation) {
        return command.toLowerCase().startsWith(abreviation);
    }

    public void printCoordinate(Point curLocal) {
        //You are at location ? (location)
        System.out.println("You are at location " + (int) curLocal.getY() + "," + (int) curLocal.getX());
    }

    public void printOutOfBoundsMessage (String direction) {
        //"You can't go that far ? (direction)"
        System.out.println("You can't go that far " + direction);
    }

    public void printDirectionMoving (String direction) {
        //Moving ? (direction)...
        System.out.println("Moving " + direction + "...");
    }

    public Point updateNorthSouthLocation(Point curLocal, int incrementBy) {
        return new Point(curLocal.x, curLocal.y + incrementBy);
    }

    public Point updateEastWestLocation(Point curLocal, int incrementBy) {
        return new Point(curLocal.x + incrementBy, curLocal.y);
    }

    public boolean isOutOfBounds(Point location) {
        int x = location.x;
        int y = location.y;

        return x < 0 || x > 4 || y < 0 || y > 4;
    }
}


