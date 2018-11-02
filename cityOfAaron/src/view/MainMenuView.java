/*
 * The MainMenuView class - part of the view layer
 * Purpose of class - manage the main menu
 * Author: Team
 * Date last modified: 10/30/18
 */
package view;

import java.util.Scanner;

public class MainMenuView {
    Scanner keyboard = new Scanner(System.in);
    private String theMenu;
    private int max;
    
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
    * Parameters: none
    * Returns: integer - the option selected
    * ===================================     
    */
    public int getMenuOption()
    {
        // Slide 45 says code for this comes earlier in slideshow.
        // Code taken from slides 10 - 19

        // declare a variable to hold user’s input
        int userInput = 0;
        final int MAX = 5;
        Scanner keyboard = new Scanner( );

        // begin loop
        do
        {
            // get user input from the keyboard
            userInput = keyboard.nextInt();
            // if it is not a valid value, output an error message
            if(userInput < 1 || userInput > MAX)
                 System.out.println(“Error: you must select 1, 2, 3, 4, or 5”;
            // loop back to the top of the loop if input was not valid
            // end loop
        } while (userInput < 1 || userInput > MAX);

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
        }
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
    * Parameters: none
    * Returns: none
    * ===================================  
    */
     public void startNewGame() {
         System.out.println("\nStart new game option selected.");
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

}
