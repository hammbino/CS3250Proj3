import java.awt.*;

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

}

