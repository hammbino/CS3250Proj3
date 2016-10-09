import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jeffreyhammond on 10/6/16.
 */
public class GameChar {

    ArrayList<String> inventory;

    //the part of the map visible to the character should be determined by a GameChar object
    int viewingDistance = 1;

    //Characters location
    Point location = new Point(0, 0);

    Map map;

    GameChar (String inputFile) {
        inventory = new ArrayList<>(Arrays.asList("brass lantern", "rope", "rations", "staff"));
        map = new Map(inputFile);
    }

    //print inventory command
    public void printInventory (GameChar character) {
        //You are carrying:
        System.out.println("You are carrying:");
        //Array of items
        for (String temp : character.inventory) {
            System.out.println(temp);
        }
    }

    //Go command
    public void characterGo (String [] strCommands) {
       if (strCommands.length > 1) {
           String command = strCommands[1];
           if (isCommand(command, "n")) {
               String north = "north";
               Point newLocal = updateNorthSouthLocation(location, -1);
               if (isOutOfBounds(newLocal, map)) {
                   //message that would be out of bounds
                   printOutOfBoundsMessage(north);
               } else {
                   //set new loccation
                   location = newLocal;
                   //printDirectionMoving(north);
               }
           } else if (isCommand(command, "s")) {
               String south = "south";
               Point newLocal = updateNorthSouthLocation(location, 1);
               if (isOutOfBounds(newLocal, map)) {
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
               if (isOutOfBounds(newLocal, map)) {
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
               if (isOutOfBounds(newLocal, map)) {
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

        //display message to user about current location
        printCoordinate(location);
        printMiniMap(location, map);
    }

    //check if character is a command
    private boolean isCommand(String command, String abreviation) {
        return command.toLowerCase().startsWith(abreviation);
    }

    //displays characters current location on the map
    private void printCoordinate(Point curLocal) {
        System.out.println("You are at location " + curLocal.x + "," + curLocal.y + " in terrain " + map.getTerrain(curLocal));
    }

    //prints ouf of bounds message if character is trying to move off the map
    private void printOutOfBoundsMessage (String direction) {
        System.out.println("You can't go that far " + direction);
    }

    //prints the direction the character is moving
    private void printDirectionMoving (String direction) {
        System.out.println("Moving " + direction + "...");
    }

    //updates y coordinate if character moves north or south
    private Point updateNorthSouthLocation(Point curLocal, int incrementBy) {
        return new Point(curLocal.x + incrementBy, curLocal.y );
    }

    //updates x coordinate if character moves east or west
    private Point updateEastWestLocation(Point curLocal, int incrementBy) {
        return new Point(curLocal.x, curLocal.y + incrementBy);
    }

    //checks to see if move would be out of bounds
    private boolean isOutOfBounds(Point location, Map map) {
        return location.x < 0 || location.x >= map.mapRow || location.y < 0 || location.y >= map.mapColumn;
    }

    //print mini map surrounding character
    private void printMiniMap(Point curLocal, Map map) {
        int maxRow = location.x + viewingDistance;
        int maxCol = location.y + viewingDistance;
        Point startMini = new Point((location.x - viewingDistance), (location.y - viewingDistance));

        for (int row = startMini.x; row < (maxRow + 1); row++ ) {
            for (int col = startMini.y; col < (maxCol + 1); col++) {
                Point currentPoint = new Point(row, col);
                System.out.print(isOutOfBounds(currentPoint, map) ? 'X' : map.getTerrain(currentPoint));
            }
            System.out.println();
        }
    }
}