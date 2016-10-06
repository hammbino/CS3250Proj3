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
        Map map = new Map();
        //GameChar character = new GameChar();
        map.inputHandler();
    }

}