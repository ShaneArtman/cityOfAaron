/*
 * GameMenuView.java
 *
 * The Player Class for the cityOfAaron project
 * Created in the view package.
 * 
 * Created on Nov 5, 2018, 4:15:01 PM
 * Created by Nick H
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: <What is the purpose of the file?>
 */
package view;

import cityofaaron.CityOfAaron;
import java.util.Scanner;
import model.*;

public class GameMenuView extends MenuView {

    private Game theGame = CityOfAaron.getGame();

    /**
     * The GameMenuView constructor Purpose: Initialize the game menu data
     *
     * @parameters: none
     * @returns: none
     */
    public GameMenuView() {
        super("\n"
                + "*********************************\n"
                + "** CITY OF AARON: IN-GAME MENU **\n"
                + "*********************************\n"
                + " 1 - View the map\n"
                + " 2 - View/Print a list\n"
                + " 3 - Move to a new location\n"
                + " 4 - Manage the crops\n"
                + " 5 - Return to the Main menu\n",
                5);
    }

    /**
     * doAction Method Purpose: Perform action selected by user Pre-Conditions:
     *
     * @param option user input 1-5
     * @returns none
     * ====================================================================
     */
    @Override
    public void doAction(int option) {
        switch (option) {
            case 1: // view map
                viewMap();
                break;
            case 2: // view lists menu
                viewList();
                break;
            case 3: // move to new location
                moveToNewLocation();
                break;
            case 4: // manage crops
                manageCrops();
                // Test for the end of game and return to calling method
                //Game game = CityOfAaron.getGame();
                // Test for the end of game and return to calling method
                if (theGame != null) {
                    if (theGame.getEndOfGame()) {
                        System.out.println("You have reached the end of the game. Please \n"
                                + "return to the main menu and start another journey\n\n");
                        return;
                    }
                }

                break;
            case 5: // return to main menu
                return;
        }
    }

    /**
     * viewMap Method Purpose: View map locations Pre-Conditions:
     *
     * @param
     * @returns none
     * ====================================================================
     */
    public void viewMap() {
        System.out.println("This is the viewMap method.");
    }

    /**
     * viewList Method Purpose: view list menu Pre-Conditions:
     *
     * @param
     * @returns none
     * ====================================================================
     */
    public void viewList() {
        ListMenuView lmv = new ListMenuView();
        lmv.displayMenu();
    }

    /**
     * moveToNewLocation Method Purpose: Change players location Pre-Conditions:
     *
     * @param
     * @returns none
     * ====================================================================
     */
    public void moveToNewLocation() {
        System.out.println("This is the moveToNewLocation method.");
    }

    /**
     * manageCrops Method Purpose: manage crops Pre-Conditions:
     *
     * @param
     * @returns none
     * ====================================================================
     */
    public void manageCrops() {
        //Display the crop management view
        CropView.runCropView();
    }

}
