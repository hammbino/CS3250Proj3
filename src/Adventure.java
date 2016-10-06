//I declare that the following source code is my work.
//I understand and can explain everything I have written, if asked.
//I understand that copying any source code, in whole or in part,
//that is not in my textbook nor provided or expressly permitted by the instructor,
//constitutes cheating. I will receive a zero on this project for
//poor academic performance if I am found in violation of this policy.

//Jeffrey Hammond
//CS3250
//Project 3 - Adventure Game


import java.awt.*;
import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
//        //Verify a command line parameter given for Map file
//        if (args.length < 1) {
//            System.out.println("No file was provided.");
//            System.exit(0);     // TERMINATE THE PROGRAM
//        }

        Adventure adventure = new Adventure();
        adventure.start();
    }

    private void start() {
        //get a scanner
        Scanner in = new Scanner(System.in);
        String command = "";
        Point location = new Point(0, 0);
        String[] inventory = {"brass lantern", "rope", "rations", "staff"};

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
                printInventory(inventory);

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


    private boolean isCommand(String command, String abreviation) {
        return command.toLowerCase().startsWith(abreviation);
    }

    private void printCoordinate(Point curLocal) {
        //You are at location ? (location)
        System.out.println("You are at location " + (int) curLocal.getY() + "," + (int) curLocal.getX());
    }

    private void printOutOfBoundsMessage (String direction) {
        //"You can't go that far ? (direction)"
        System.out.println("You can't go that far " + direction);
    }

    private void printDirectionMoving (String direction) {
        //Moving ? (direction)...
        System.out.println("Moving " + direction + "...");
    }

    private void printInventory (String[] inventory) {
        //You are carrying:
        System.out.println("You are carrying:");
        //Array of items
        for (String temp : inventory) {
            System.out.println(temp);
        }
    }

    private Point updateNorthSouthLocation(Point curLocal, int incrementBy) {
        return new Point(curLocal.x, curLocal.y + incrementBy);
    }

    private Point updateEastWestLocation(Point curLocal, int incrementBy) {
        return new Point(curLocal.x + incrementBy, curLocal.y);
    }

    private boolean isOutOfBounds(Point location) {
        int x = location.x;
        int y = location.y;

        return x < 0 || x > 4 || y < 0 || y > 4;
    }
}