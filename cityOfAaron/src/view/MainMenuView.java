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

public class MainMenuView {
    Scanner keyboard = new Scanner(System.in);
    private String theMenu;
    private int max;
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
    
    // The MainMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    //Returns: none
    // =====================================================================
    public MainMenuView() {
        theMenu = "\n" +
                "*********************************\n" +
                "* CITY OF AARON: MAIN GAME MENU *\n" +
                "*********************************\n" +
                " 1 - Start new game\n" +
                " 2 - Get and start a saved game\n" +
                " 3 - Get help on playing the game\n" +
                " 4 - Save game\n" +
                " 5 - Quit\n";
        max = 5;   
    }
    
    // The displayMenuView method
    // Purpose: dislpays the menu, gets the user's input, and does the selected
    // action
    // Paramters: none
    // Returns: none
    // ========================================================================
    public void displayMenuView() {
        int menuOption;
        do {
            //display the menu
            System.out.println(theMenu);            
            //prompt the user and get the user's input
            menuOption = getMenuOption();
            //Perform the desired action
            doAction(menuOption);
            
        } while (menuOption != max);
    }
    
    
    /** The getMenuOption method
    * Purpose: gets the user's input
    * @Parameters none
    * @Return integer - the option selected
    * ===================================     
    */
    public int getMenuOption()
    {
        // Slide 45 says code for this comes earlier in slideshow.
        // Code taken from slides 10 - 19

        // declare a variable to hold user’s input
        int userInput = 0;
        final int MAX = 5;
        Scanner keyboard = new Scanner(System.in);

        // begin loop
        do
        {
            /*
                Shane - Comments - I would think that we should display the menu
                here. Otherwise the user will eventually scroll past the menu and
                will not see the options.
            */
            
            // get user input from the keyboard
            userInput = keyboard.nextInt();
            // if it is not a valid value, output an error message
            if(userInput < 1 || userInput > MAX) {
                 System.out.println("Error: you must select 1, 2, 3, 4, or 5");
            }
            // loop back to the top of the loop if input was not valid
            // end loop
        } while (userInput < 1 || userInput > MAX);

        /*
            *** Shane - Comments - Why are we running the switch here and in the 
            *** doAction method?

        switch(userInput)
        {
            case 1: // create and start a new game
                startNewGame();
                break;
            case 2: // get and start a saved game
                loadSavedGame();
                break;
            case 3: // get help menu
                displayHelpMenu();
                break;
            case 4: // save game
                saveGame();
                break;
            case 5:
                System.out.println("Thanks for playing ... goodbye.");
                return 0;
        }
        */
        
        
        //Missing Return - SAA 11.2.18
        return userInput;
    } 
    
    /** The doAction method
    * Purpose: performs the selected action
    * Parameters: none
    * Returns: none
    * ===================================  
    */
    public void doAction(int option)
    {
        switch(option)
        {
            case 1: // create and start a new game
                startNewGame();
                //Shane - Display some test data - remove later...
                testData();
                break;
            case 2: // get and start a saved game
                startSavedGame();
                break;
            case 3: // get help menu
                displayHelpMenuView();
                break;
            case 4: // save game
                displaySaveGameView();
                break;
            case 5: // display goodbye
                System.out.println("Thanks for playing ... goodbye.");
        }

    } 

    /**
     * startNewGame method
     * Purpose: Creates new game object and starts the game
     * @Param none
     * @Return none
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
    }

    /** 
    * displayHelpMenuView Method
    * Purpose: Displays help options
    * Parameters: none
    * Returns: none
    * ===================================  
    */
    public void displayHelpMenuView( ) {
         System.out.println("\nDisplay help menu option selected.");
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
        System.out.println("This is the saveGame method");
    }
    private static void testData() {
        // Display test data
        System.out.println("\n\nDisplaying some test data for development - Remove later...");
        Game myGame = CityOfAaron.getGame();
        CropData myCropData = myGame.getCropData();
        Player myPlayer = myGame.getPlayer();

        //From initial testing - will remove later - Shane 11.3.18
        System.out.println("The year is " + myCropData.getYear() + ".\nOur population: " + myCropData.getPopulation()
                + "\nAcres owned: " + myCropData.getAcresOwned() + "\nCrop yield: " + myCropData.getCropYield() + "\nWheat in Store: "
                + myCropData.getWheatInStore() + "\nNumbers died: " + myCropData.getNumberWhoDied() + "\nNewcomers: " + myCropData.getNewPeople()
                + "\nHarvest: " + myCropData.getHarvest() + "\nWheat for food: " + myCropData.getWheatForFood()
                + "\nAcres Planted: " + myCropData.getAcresPlanted());
        System.out.println("The player's name is: " + myPlayer.getName() + "\n");
        System.out.println("One of the team members name is: " + TeamMember.SHANE.getName());
        System.out.println("And their title is:" + TeamMember.SHANE.getTitle());


    }
}
