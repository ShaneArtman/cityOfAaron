/**
 * The MainMenuView class - part of the view layer
 * Purpose: View layer for main menu
 * 
 * MainMenuView.java
 *
 * The MainMenuView Class for the cityOfAaron project
 * Created in the view package.
 * 
 * Created on Oct 30, 2018
 * Created by Team
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * 
 *  
 */

package view;

import java.util.Scanner;
//Import the cityofaaron package CityOfAaron class
// Comment - Shane - Why are we doing this here?
import cityofaaron.CityOfAaron;
import control.*;
import model.*;

public class MainMenuView extends MenuView {
    private final String BANNER_PAGE =
        "\tGovernor, welcome. Before you arrived the people of the City of Aaron have \n" +
        "suffered famine, pestilence and death. Our lives are in your hands. Please serve \n" +
        "us well and we will care for your well-being. We are giving you 10 years to help us \n" +
        "recover and each year we will evaluate your progress. We have lost so many of our family \n" +
        "and friends; we have placed a review at the end of each year. If you fail to feed us, \n" +
        "we will banish you from your position. If you feed us well, we will work hard for you. \n" +
        "Please do not forget who really provides for all of us and pay your tithes and offerings; \n" +
        "do not become prideful.\n\n" +
        "\tWe have enabled you to manage all aspects of the development of our town for feeding \n" +
        "our people. You can purchase and sell land using our most valuable treasure, wheat. You can \n" +
        "then plant new crops, decide how much of the harvest is to be set aside for food for the \n" +
        "following year and use the remaining amount to buy more land. Be wary of our rat problems \n" +
        "and the vast changes in climate that have impacts on the harvest and how much wheat is left \n" +
        "in the store at the end of the year.\n\n" +
        "\tWe also have many of our women big with child and nomads that meander into town. We do not \n" +
        "let anyone go hungry. So, make sure that you plan for growth of people every year.\n\n" +
        "\tFor all the people who starve, you will be less able to put up the harvest and plant \n" +
        "new fields. Good luck and may God bless you.\n\n";
    
    /** 
    * The MainMenuView constructor
    * Purpose: Initialize the menu data
    * @parameters: none
    * @returns: none
    */
    public MainMenuView() {
        super("\n" +
                "*********************************\n" +
                "* CITY OF AARON: MAIN GAME MENU *\n" +
                "*********************************\n" +
                " 1 - Start new game\n" +
                " 2 - Get and start a saved game\n" +
                " 3 - Get help on playing the game\n" +
                " 4 - Save game\n" +
                " 5 - Quit\n", 5);   
    }
    
    /** The doAction method
    * Purpose: performs the selected action
    * Parameters: option
    * Returns: none
    * ===================================  
    */
    @Override public void doAction(int option)
    {
        switch(option)
        {
            case 1: // create and start a new game
                startNewGame();
                //Shane - Display some test data - remove later...
                break;
            case 2: // get and start a saved game
                startSavedGame();
                break;
            case 3: // get help menu
                displayHelpMenuView();
                break;
            case 4: // save game
                saveGame();
                break;
            case 5: // display goodbye
                System.out.println("Thanks for playing ... goodbye.");
        }

    } 

    /**
     * startNewGame method<p>
     * Purpose: Creates new game object and starts the game<p>
     * @param none
     * ===================================  
     */
     public void startNewGame() {
        // Display the Banner Page.
        System.out.println("\n\n" + BANNER_PAGE + "\n\n");
        
        // Prompt for and get the user’s name.
        String name;
        System.out.println("Please tell us your name:\n");
        name = keyboard.next();
        
        // Call the createNewGame() method in the GameControl class
        GameControl.createNewGame(name);
        
        // Display a welcome message
        System.out.println("Welcome, " + name + " have fun!!!");
        
        // Display the Game menu
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
     }

    /** 
    * startSavedGame Method
    * Purpose: Retrieves saved game object and starts game
    * Parameters: none
    * Returns: none
    * ===================================  
    */
    public void startSavedGame( ) {
        System.out.println("\nStart saved game option selected.");
        
        // get rid of nl character left in the stream
        keyboard.nextLine(); 
        
        // prompt user and get a file path
        System.out.println("Enter file name.");
        String filepath = keyboard.next();
         
        // call the getSavedGame( ) method in the GameControl class to load the game
        GameControl.getSavedGame(filepath);
        
        // display the game menu for the loaded game
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();

    }

    /** 
    * displayHelpMenuView Method
    * Purpose: Displays help options
    * Parameters: none
    * Returns: none
    * ===================================  
    */
    public void displayHelpMenuView( ) {
         HelpMenuView hmv = new HelpMenuView();
         hmv.displayMenu();
    }

    /** 
    * displaySavedGameView Method
    * Purpose: Saves game
    * Parameters: none
    * Returns: none
    * ===================================  
    */
    public void displaySaveGameView( ) {
         System.out.println("\nDisplay save game option selected.");
    }

    /**
     * loadSavedGame Method
     * Purpose: loading a previously saved game
     * @Param none
     * @Return none
     */
    public void loadSavedGame() {
        System.out.println("This is the loadSavedGame method");
    }
    
    /**
     * displayHelpMenu Method
     * Purpose: display help menu
     * @Param none
     * @Return none
     */
    public void displayHelpMenu() {
        System.out.println("This is the displayHelpMenu method");
    }
    
    /**
     * saveGame Method
     * Purpose: save the existing game
     * @Param none
     * @Return none
     */
    public void saveGame() {
        // Check if game exists
        
        if(CityOfAaron.getGame() != null){
           
            // Get game object
            Game game = CityOfAaron.getGame();
            String filename;
            
            // Ask user for file name
            System.out.println("Please enter file name.");
            filename = keyboard.next();
            
            // Send to control layer saveGame
            GameControl.saveGame(game,filename);
            
            // Clear input
            keyboard.nextLine();
        }
        else {
            System.out.println("You must create a game before saving.");
            }
    }
        
    
    
}
