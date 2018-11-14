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

    /**
     * 
     * Purpose: This is the implementation of the interface of displayMenu for the
     * menu view class<p>
     * @Param none
     * @Override Common interface for all menu views 
     */
    public void displayMenu() {
        

    }
    /**
     * 
     * Purpose: This is the implementation of the interface of getMenuOption for the
     * menu view class<p>
     * @Param none
     * @Override Common interface for all menu views 
     */
    public int getMenuOption() {
        
    }

    /**
     * 
     * Purpose: This is the implementation of the interface of doAction for the
     * menu view class<p>
     * @Param none
     * @Override Common interface for all menu views 
     */
    public void doAction(int _userOption) {
        
    }
    
}
