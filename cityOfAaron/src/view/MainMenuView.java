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
    
}
