/*
 * CropView.java
 *
 * The Player Class for the cityOfAaron project
 * Created in the view package.
 * 
 * Created on Nov 5, 2018, 11:51:51 AM
 * Created by Team
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: <What is the purpose of the file?>
 */

package view;
import model.*;
import control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;


public class CropView {
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);   

    // Get references to the Game object and the CropData object
    static private Game game = CityOfAaron.getGame();
    static private CropData cropData = game.getCropData();
    
    /** The runCropView method()
    * Purpose: runs the methods to manage the crops game
    * Parameters: none
    * Returns: none
    * =================================================================
    */
    public static void runCropView()
    {
        // call the buyLandView( ) method
        feedPeopleView();
        buyLandView( );

        /** add calls to the other crop view methods
        * as they are written:
        * sellLandView()
        * feedPeopleView()
        * plantCropsView()
        * displayCropsReportView()
        */
    }

    /** The buyLandView method
    * Purpose: interface with the user input for buying land
    * Parameters: none
    * Returns: none
    * ==================================================================
    */
    public static void buyLandView()
    {
     // Get the cost of land for this round.
     int price = CropControl.calcLandCost();

    // Prompt the user to enter the number of acres to buy
    System.out.format("Land is selling for %d bushels per acre.%n",price);
    System.out.print("\nHow many acres of land do you wish to buy? "); 

    //  Get the user’s input and save it.
    int toBuy;
    toBuy = keyboard.nextInt();

    // Call the buyLand( ) method in the control layer to buy the land
    CropControl.buyLand(price, toBuy, cropData);
    
    // output how much land we now own
    System.out.format("You now own %d acres of land. ", cropData.getAcresOwned());
    }
   
    public static void feedPeopleView()
    {
        /*
         * 1. Prompt the user for the amount of grain to set aside to feed people
         * consider stating how many people are in the population and the amount
         * of grain in the store.
         * 
         * 2. Collect the user input
         * Verify that the city has that amount in storage and correct error
         * by prompting for additional data
         *
         * 3. Subtract from wheat in storage
         *
         * 4. Update game for busels to feed people
         *
         * 5. Display the results
         *
        */
        
        int userInput = 0;
        int wheatInStorehouse = game.getCropData().getWheatInStore();
        System.out.println("\n\nGlad you are thinking of all of those that have\n" +
                "worked so hard and provided food for the town. Now it\n" +
                "is time to feed them. Remember that it takes 20 bushels\n " +
                "per person to keep them from starving. Based on this year's \n" +
                "harvest, we have the following:\n");
        //Do this loop while the user is inputting incorrect options for wheat
        do {
            System.out.println("----------------------------------\nPopulation: " + 
                    game.getCropData().getPopulation() + "\n" +
                    "Wheat in storehouse: " + 
                    wheatInStorehouse + "\n" +
                    "How much wheat do you want to set aside for food?\n" +
                    "Please enter in multiples of 20.");
            userInput = keyboard.nextInt();
            if (userInput > wheatInStorehouse || userInput < 0 || userInput % 20 != 0) {
                System.out.println("\n\nYou Entered: " + userInput + "\n" +
                        "You must select a value between " +
                        "0 (starve us all) and " + wheatInStorehouse + 
                        "Also, it must be in multiples of 20\n" +
                        "\nPlease enter a valid amount of wheat\n");
            }
        } while (userInput > wheatInStorehouse || userInput < 0 || (userInput > 0 && userInput % 20 != 0));
        System.out.println("Need to set cropdata now");
    }
}
