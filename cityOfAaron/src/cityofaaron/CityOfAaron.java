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
import view.*;
import control.*; //This may not be needed?

public class CityOfAaron {

    
    //variable to keep reference to the game object
    private static Game theGame = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
            Creating instances of the player and game classes moved to GameControl 
            class in control layer
        */
        
        // Create instance of MainMenuView
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenuView();

        //Location Class Instantiated
        Location myLocation = new Location();
        // Set values into the new location class - test.
        // Later, these will be set in the Map Class
        myLocation.setDescription("My Favorite Place");
        myLocation.setSymbol("∆");
        
        System.out.println("myLocation description: " + myLocation.getDescription());
        System.out.println("myLocation symbol = " + myLocation.getSymbol());
        
        //ListItem Class Instantiated
        ListItem myItem = new ListItem();
        //Set test values
        myItem.setName("Hammer");
        myItem.setNumber(3);
        
        System.out.println("You currently have " + myItem.getNumber() + " " + myItem.getName() + "/s on hand.");
        
        //Moved instantiation of cropData to the GameControl class in the control layer
        //Shane - 11.3.18
                
    }

    /**
     * Purpose: To get the reference to the game object outside this class
     * @author Shane Artman
     * @param none
     * @return theGame object
     */
    public static Game getGame() {
        return theGame;
    }

    /**
     * Purpose: To set reference to theGame object
     * @author Shane Artman
     * @param theGame reference
     * @return theGame object
     */
    public static void setGame(Game theGame) {
        CityOfAaron.theGame = theGame;
    }
    
}
