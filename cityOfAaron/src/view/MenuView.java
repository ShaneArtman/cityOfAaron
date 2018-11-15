/*
 * MenuView.java
 *
 * The MenuView Class for the cityOfAaron project
 * Created in the view package.
 * 
 * Created on Nov 13, 2018, 8:32:24 PM
 * Created by artieman1
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: Abstract base class for all Menu Views
 */

package view;

import java.util.Scanner;

public abstract class MenuView implements ViewInterface {
    /*
    * Data members common to all menu views
    */
    protected final static Scanner keyboard = new Scanner(System.in);
    //string holds menu string
    protected String menu;
    // int holds max input value
    protected int max;
    
    /*
    * MenuView constructor
    * Purpose: Initialize the view object with the menu string
    * @param menu and max
    * @return none
    */
    public MenuView(String _menu, int _max) {
        menu = _menu;
        max = _max;
    }

    /** 
    * displayMenu method
    * Purpose: displays the menu, gets the user's input, and does the selected
    * action
    * @parameters: none
    * @returns: none
    */
    @Override public void displayMenu() {
        int menuOption;
        do {
            //display the menu
            System.out.println(menu);          
            //prompt the user and get the user's input
            menuOption = getMenuOption();
            //Perform the desired action
            doAction(menuOption);

        } while (menuOption != max);
    }
    
    
    /** The getMenuOption method
    * Purpose: gets the user's input
    * @Parameters none
    * @Returns integer - the option selected     
    */
    @Override public int getMenuOption()   {

        // declare a variable to hold user’s input
        int userInput = 0;

        // begin loop
        do
        {
            // get user input from the keyboard
            userInput = keyboard.nextInt();
            // if it is not a valid value, output an error message
            if(userInput < 1 || userInput > max) {
                 System.out.format("\nError: you must select 1 and %d.", max);
            }
            // loop back to the top of the loop if input was not valid
            // end loop
        } while (userInput < 1 || userInput > max);
        
        return userInput;
    } 
    
}
