/*
 * ViewInterface.java
 *
 * The ViewInterface Class for the cityOfAaron project
 * Created in the view package.
 * 
 * Created on Nov 13, 2018, 8:38:33 PM
 * Created by artieman1
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: Abstract class for the View Interfaces
 */

package view;


/**
 * 
 * Purpose: The interface abstract class for the view layer
 * @Param none
 * @author Team
 */
public interface ViewInterface {

    public void displayMenu();
    public int getMenuOption();
    public void doAction(int _userOption);
}
