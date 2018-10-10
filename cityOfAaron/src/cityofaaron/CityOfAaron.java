/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 * All Classes are to be written as Java Beans (Serializable)
 * Another Test - Yet Another
 */
package cityofaaron;
//import the classes from the model package
import model.*;

public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create an instance of the player and game classes
        
        //Player Class instantiated
        Player myPlayer = new Player();
        myPlayer.setName("Pudentane");
        
        //Game Class instantiated
        Game myGame = new Game();
        myGame.setPlayer(myPlayer);
        
        
        //Location Class Instantiated
        Location myLocation = new Location();
        // Set values into the new location class - test.
        // Later, these will be set in the Map Class
        myLocation.setDescription("My Favorite Place");
        myLocation.setSymbol("∆");
        
        System.out.println("The player's name is: " + myGame.getPlayer().getName() + "\n");
        System.out.println("One of the team members name is: " + TeamMember.SHANE.getName());
        System.out.println("And their title is:" + TeamMember.SHANE.getTitle());
        System.out.println("myLocation description: " + myLocation.getDescription());
        System.out.println("myLocation symbol = " + myLocation.getSymbol());
        
        //ListItem Class Instantiated
        ListItem myItem = new ListItem();
        //Set test values
        myItem.setName("Hammer");
        myItem.setNumber(3);
        
        System.out.println("You currently have " + myItem.getNumber() + " " + myItem.getName() + "/s on hand.");
        
    }
     
}
