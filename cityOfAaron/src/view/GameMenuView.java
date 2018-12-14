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
import model.*;

public class GameMenuView extends MenuView {

    Game theGame = CityOfAaron.getGame();

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
                break;
            case 5: // return to main menu
                return;
        }
    }

    /**
     * viewMap Method
     * @author Jon
     * Purpose: Display the map in a table to user with legend for symbols
     * @param none
     * @returns none
     */
    public void viewMap() {
        System.out.println("\n   ***   Village Map   ***\n");
        //create 5x5 array for map display
        String mapDisplayArray[][] = new String[5][5];
        
        //I was having difficulty getting my array to display correctly.
        //I know this is not the most effecient code, but it was what made sense and
        //displayed correctly for me..
        
        //assign string to each cell in array
        mapDisplayArray[0][0] = "| ~~~ ";
        mapDisplayArray[0][1] = "| !!! ";
        mapDisplayArray[0][2] = "| *** ";
        mapDisplayArray[0][3] = "| *** ";
        mapDisplayArray[0][4] = "| $$$ |";
        mapDisplayArray[1][0] = "| ~~~ ";
        mapDisplayArray[1][1] = "| !!! ";
        mapDisplayArray[1][2] = "| ### ";
        mapDisplayArray[1][3] = "| ### ";
        mapDisplayArray[1][4] = "| ### |";
        mapDisplayArray[2][0] = "| ~~~ ";
        mapDisplayArray[2][1] = "| !!! ";
        mapDisplayArray[2][2] = "| ^^^ ";
        mapDisplayArray[2][3] = "| ^^^ ";
        mapDisplayArray[2][4] = "| ^^^ |";
        mapDisplayArray[3][0] = "| ~~~ ";
        mapDisplayArray[3][1] = "| ... ";
        mapDisplayArray[3][2] = "| ... ";
        mapDisplayArray[3][3] = "| ... ";
        mapDisplayArray[3][4] = "| ... |";
        mapDisplayArray[4][0] = "| ~~~ ";
        mapDisplayArray[4][1] = "| --- ";
        mapDisplayArray[4][2] = "| --- ";
        mapDisplayArray[4][3] = "| --- ";
        mapDisplayArray[4][4] = "| --- |";
        //iterate through each array cell and display string to user
        for (int i = 0; i < mapDisplayArray.length; i++) {
            for (int j = 0; j < mapDisplayArray.length; j++) {
                System.out.print(mapDisplayArray[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\nKey:");
        System.out.println("~~~ = River\n!!! = Wheat Fields\n--- = Lamanite Border\n"
                + "... = Desert\n$$$ = Ruler's Court\n*** = Grainary\n"
                + "### = The Village\n^^^ = Forest");
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
