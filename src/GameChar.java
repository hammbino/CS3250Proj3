/**
 * Created by jeffreyhammond on 10/6/16.
 */
public class GameChar {
    String[] inventory = {"brass lantern", "rope", "rations", "staff"};

    public void printInventory () {
        //You are carrying:
        System.out.println("You are carrying:");
        //Array of items
        for (String temp : inventory) {
            System.out.println(temp);
        }
    }
    //methods to execute the go and inventory commands

    //The go and inventory commands should be executed by an instance of the GameChar class

    //the part of the map visible to the character should be determined by a GameChar object

    //Your program should use the size of the map when it checks to see if a move is valid
}
