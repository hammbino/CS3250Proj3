//I declare that the following source code is my work.
//I understand and can explain everything I have written, if asked.
//I understand that copying any source code, in whole or in part,
//that is not in my textbook nor provided or expressly permitted by the instructor,
//constitutes cheating. I will receive a zero on this project for
//poor academic performance if I am found in violation of this policy.

//Jeffrey Hammond
//CS3250
//Project 3 - Adventure Game

import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        //Verify a command line parameter given for Map file
        if (args.length < 1) {
            System.out.println("No file was provided.");
            System.exit(0);     // TERMINATE THE PROGRAM
        }

        Adventure adventure = new Adventure();
        adventure.start(args[0]);
    }

    private void start(String inputFile) {
        //create character
        GameChar character = new GameChar(inputFile);

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
                character.characterGo(strCommands);
            } else if (isCommand(command, "i")) {
                character.printInventory(character);
            } else if (isCommand(command, "q")) {
                //display farewell message
                System.out.println("Farewell");
            } else {
                //unrecognized command
                System.out.println("Invalid command: " + command);
            }
        }
        in.close();
    }

    public boolean isCommand(String command, String abreviation) {
        return command.toLowerCase().startsWith(abreviation);
    }
}