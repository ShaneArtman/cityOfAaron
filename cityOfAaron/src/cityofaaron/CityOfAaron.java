/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 * All Classes are to be written as Java Beans (Serializable)
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
        myPlayer.setName("Shane");
        
        //Game Class instantiated
        Game myGame = new Game();
        myGame.setPlayer(myPlayer);
        
        
        System.out.println("The player's name is: " + myGame.getPlayer().getName() + "\n");
        System.out.println("One of the team members name is: " + TeamMember.SHANE.getName());
        System.out.println("And their title is:" + TeamMember.SHANE.getTitle());
        
    }
    
}
