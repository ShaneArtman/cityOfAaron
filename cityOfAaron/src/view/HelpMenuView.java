/*
 * HelpMenuView.java
 *
 * The HelpMenuView Class for the cityOfAaron project
 * Created in the view package.
 * 
 * Created on Nov 5, 2018, 9:25:18 AM
 * Created by Jonathan Unga
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: Display options with helpful info about the game to the user
 */
package view;
import cityofaaron.CityOfAaron;
import model.*;
import control.*;
import java.util.Scanner;

public class HelpMenuView {
    private String helpMenu = "\n" +
            "****************************\n" +
            "* CITY OF AARON: HELP MENU *\n" +
            "****************************\n" +
            " 1 - What are the goals of the game?\n" +
            " 2 - Where is the city of Aaron?\n" +
            " 3 - How do I view the map?\n" +
            " 4 - How do I move to another Location?\n" +
            " 5 - How do I display a list of animals, provisions and tools in the city storehouse?\n" +
            " 6 - Return to the Main Menu\n";
    private final int max = 6;
    private static Scanner keyboard = new Scanner(System.in);
    private Game game = CityOfAaron.getGame();
    
    public HelpMenuView() { }
    
    /**
     * displayMenuView method
     * Purpose: display the Help Menu
     * @param none
     */
    public void displayMenuView() {
        int menuOption = 0;
        do {
            //display the help menu
            System.out.println(helpMenu);
            //get user's input
            menuOption = getMenuOption();
            //perform selected action
            doAction(menuOption);
        } while(menuOption != max);
    }
    
    public int getMenuOption() {
        int userInput = 0;
        //check for valid user input
        do {
            userInput = keyboard.nextInt();
            //error message for invalid input
            if (userInput < 1 || userInput > max) {
                System.out.println("Error, please enter an option from 1 to 6\n");
                //loop back to top of loop for invalid input
            }
        } while (userInput < 1 || userInput > max);
        return userInput;
    }
    
    /**
     * doAction method
     * Purpose: performs selected action
     * @param none
     */
    public void doAction(int option) {
        switch (option) {
            case 1: //message on what game goals are
                viewGoals();
                break;
            case 2: //message on where city is located
                viewLocationHelp();
                break;
            case 3: //message on how to view map
                viewMapHelp();
                break;
            case 4: //message on how to move locations
                viewMoveHelp();
                break;
            case 5: //message on how to display storehouse lists
                viewListHelp();
                break;
            case 6: //return to main menu
                return;
        }
    }
    
    /**
     * viewGoals method
     * Purpose: help message displayed on goals of the game
     * @param none
     */
    public void viewGoals() {
        System.out.println("Display game goals help message");
    }
    
    /**
     * viewLocationHelp method
     * Purpose: help message on where the city of Aaron is located
     * @param none
     */
    public void viewLocationHelp() {
        System.out.println("Display location of City of Aaron message");
    }
    
    /**
     * viewMapHelp method
     * Purpose: help message on how to view the map
     * @param none
     */
    public void viewMapHelp() {
        System.out.println("Display how to view map message");
    }
    
    /**
     * viewMoveHelp method
     * Purpose: help message on how to move locations
     * @param none
     */
    public void viewMoveHelp() {
        System.out.println("Display how to move locations message");
    }
    
    /**
     * viewListHelp method
     * Purpose: help message on how to display lists in city storehouse
     * @param none
     */
    public void viewListHelp() {
        System.out.println("Display how to view lists of items in storehouse message");
    }
}
