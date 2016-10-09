import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by jeffreyhammond on 10/6/16.
 */
public class Map {
    int mapColumn;
    int mapRow;
    char [][] map;

    //method to read a map from a text file
    Map (String inputFile) {
        map = createMap(inputFile);
    }

    private char[][] createMap (String inputFile) {
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new FileInputStream(inputFile));
        } catch (FileNotFoundException x) {
            System.out.println("File open failed on file: " + inputFile);
            x.printStackTrace();
            System.exit(0);   // TERMINATE THE PROGRAM
        }

        // use first line of file to determine map dimensions
        if (!fileIn.hasNextInt()) {
            System.out.println("File did not give the map dimensions");
            System.exit(0);   // TERMINATE THE PROGRAM
        }

        this.mapRow = fileIn.nextInt();
        this.mapColumn = fileIn.nextInt();
        String line = fileIn.nextLine(); //gets the rest of the line

        System.out.println(mapRow + " " + mapColumn);//Todo remove this line

        char[][] charMap = new char[mapRow][mapColumn];

        int row = 0;
        while (fileIn.hasNextLine() && row < mapColumn) {
            line = fileIn.nextLine();
            System.out.println(line);//Todo remove this line
            for (int col = 0; col < mapColumn; col++) {
                charMap[row][col] = line.charAt(col);
            }
            row++;
        }
        System.out.println();
        return charMap;
    }

    public char[][] getMap () {
        return map;
    }

    public char getTerrain (Point currentLocal) {
        return map[currentLocal.x][currentLocal.y];
    }
}