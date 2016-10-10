import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jeffreyhammond on 10/6/16.
 */
public class GameChar {

    private static final int NORTH = -1;
    private static final int SOUTH = 1;
    private static final int EAST = 1;
    private static final int WEST = -1;

    private ArrayList<String> inventory;

    //the part of the map visible to the character should be determined by a GameChar object
    private int viewingDistance;

    //Characters location
    private Point location;

    private Map map;

    GameChar (String inputFile) {
        inventory = new ArrayList<>(Arrays.asList("brass lantern", "rope", "rations", "staff"));
        map = new Map(inputFile);
        location = new Point(0, 0);
        viewingDistance = 1;
    }

    //print inventory command
    public void printInventory (GameChar character) {
        //You are carrying:
        System.out.println("You are carrying:");
        //Array of items
        character.inventory.forEach(System.out::println);
    }

    private void handleNorthSouth(int direction, Command command) {
        Point newLocal = updateNorthSouthLocation(location, direction);
        handleDirection(command, newLocal);
    }

    private void handleEastWest(int direction, Command command) {
        Point newLocal = updateEastWestLocation(location, direction);
        handleDirection(command, newLocal);
    }

    //Go command
    public void characterGo (String [] strCommands) {
       if (strCommands.length > 1) {
           Command command = Command.getCommand(strCommands[1]);

           switch (command) {
               case NORTH:
                   handleNorthSouth(NORTH, command);
                   break;
               case SOUTH:
                   handleNorthSouth(SOUTH, command);
                   break;
               case EAST:
                   handleEastWest(EAST, command);
                   break;
               case WEST:
                   handleEastWest(WEST, command);
                   break;
               default:
                   //unrecognized
                   System.out.println("You can't go that way.");
           }
       }

        //display message to user about current location
        printCoordinate(location);
        printMiniMap(map);
    }

    //displays characters current location on the map
    private void printCoordinate(Point curLocal) {
        System.out.println("You are at location " + curLocal.x + "," + curLocal.y + " in terrain " + map.getTerrain(curLocal));
    }

    //prints ouf of bounds message if character is trying to move off the map
    private void printOutOfBoundsMessage (Command command) {
        System.out.println("You can't go that far " + command.getName());
    }

    //prints the direction the character is moving
    private void printDirectionMoving (Command direction) {
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
    private void printMiniMap(Map map) {
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
    private void handleDirection (Command command, Point newLocal) {
        if (isOutOfBounds(newLocal, map)) {
            //message that would be out of bounds
            printOutOfBoundsMessage(command);
        } else {
            //set new loccation
            location = newLocal;
            //printDirectionMoving(north);
            printDirectionMoving(command);
        }
    }
}