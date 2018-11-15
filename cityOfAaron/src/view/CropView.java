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
        displayCropsReportView();
        payOfferingView();
        sellLandView();
        feedPeopleView();
        buyLandView( );
        plantCropsView();

        /** add calls to the other crop view methods
        * as they are written:
        * sellLandView()
        * feedPeopleView()
        * plantCropsView()
        * displayCropsReportView()
        * 
        * Shane - Comments
        * Without giving too much away, we may want to display the population
        * growth, amount of food that is required to feed all people, 
        * the amount of wheat in the storehouse, the amount of land available 
        * for sale and the population growth before they make a decision to buy 
        * land, feed people, etc. 
        * 
        * Also, I would think that the order would be something like:
        * 
        * Eaten by rats (limited to what is in the storehouse today)
        * Harvest
        * growPopulation
        * Sell Land
        * Feed People
        * Calc Starved - Not sure that happens here
        * Buy Land
        * 
        * 
        */
    }
    
    /**
     * payOfferingView method
     * @author Nick
     * Purpose: Have player pay an offering from last years harvest
     * Parameters: none
     * Returns: none
     */
    public static void payOfferingView() {
            // Get las years harvest
            int harvest = cropData.getHarvest(); 
            // Player input variable for offering
            int toOffer;

            // Run do loop while offering input is invalid
            do {
            // Prompt user for offering
            System.out.format("\n\n Last year you harvested %d bushels.\n" 
                    + "What percent would you like to give as an offering?\n", harvest);

            // Get offering percent from player
            toOffer = keyboard.nextInt();
            
            // Verify entry is valid
            if(CropControl.setOffering(toOffer) == -1) {
                System.out.println(toOffer + " is not a valid entry. \n"
                        + "Please re-enter percentage you wish to offer\n\n");
            }
        // Display input loop while input is not valid
        } while (CropControl.setOffering(toOffer) == -1);
                
        // Set offering for cropData
        cropData.setOffering(toOffer);
        
        // Pay offering through payOffering method
        int bushelsOffered = CropControl.payOffering(cropData);
        
        // Display amount offered
        System.out.format("You have offered %d bushels.\n", bushelsOffered);
        
        // Display comment about ammount offered
        if (toOffer <= 5) {
            System.out.println("Remember that the Lord has blessed you with this harvest.");
        }
        else if (toOffer <= 10) {
            System.out.println("The Lord blesses those that remember Him.");
        }
        else if (toOffer <= 30) {
            System.out.println("A very generous offer indeed!");
        }
        else {
            System.out.println("May the Lord bless this people!");
        }
                
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
    System.out.format("\n\nLand is selling for %d bushels per acre.%n",price);
    System.out.print("\nHow many acres of land do you wish to buy? "); 

    //  Get the user’s input and save it.
    int toBuy;
    toBuy = keyboard.nextInt();

    // Call the buyLand( ) method in the control layer to buy the land
    CropControl.buyLand(price, toBuy, cropData);
    
    // output how much land we now own
    System.out.format("You now own %d acres of land.\n", cropData.getAcresOwned());
    }
    
    /**
     * Purpose: To feed the people, the user muse input the amount of wheat to
     * to feed them. The options will force values between 0 and wheat in the storehouse
     * as well as force multiples of 20 as it takes 20 bushels to feed 1 person<p>
     * Once the player decides on the amount of food, decrement the food from the store
     * @param none
     * @return none
     */
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
        //Initializing userInput to a 0 value
        int userInput = 0;
        
        //The amount of wheat in the storehouse before feeding people
        int wheatInStorehouse = game.getCropData().getWheatInStore();
        
        System.out.println("\n\nGlad you are thinking of all of those that have\n" +
                "worked so hard and provided food for the town. Now it\n" +
                "is time to feed them. Remember that it takes 20 bushels\n " +
                "per person to keep them from starving. Based on this year's \n" +
                "harvest, we have the following:\n");
        
        //Do this loop while the user is inputting incorrect options for wheat
        do {
            // Display to the user what is in the store
            System.out.println("----------------------------------\nPopulation: " + 
                    game.getCropData().getPopulation() + "\n" +
                    "Wheat in storehouse: " + 
                    wheatInStorehouse + "\n" +
                    "How much wheat do you want to set aside for food?\n" +
                    "Please enter in multiples of 20.");

            // Collect input from the user
            userInput = keyboard.nextInt();

            // Test for error in user input
            if (userInput > wheatInStorehouse || userInput < 0 || userInput % 20 != 0) {
                //The user has input an incorrect value. Display error message
                System.out.println("\n\nYou Entered: " + userInput + "\n" +
                        "You must select a value between " +
                        "0 (starve us all) and " + wheatInStorehouse + 
                        "Also, it must be in multiples of 20\n" +
                        "\nPlease enter a valid amount of wheat\n");
            }
        } while (userInput > wheatInStorehouse || userInput < 0 || (userInput > 0 && userInput % 20 != 0));
        
        // Need to now set the wheat for food
        CropControl.feedPeople(userInput, game.getCropData());
        
        //Display the result to the user
        System.out.println("The food in the storehouse is now: " + 
                game.getCropData().getWheatInStore() + "\n" +
                "and the food for feeding people is now " + 
                game.getCropData().getWheatForFood());
    }
    
    /**
     * sellLandView method
     * Purpose: display price land sells for per acre to user and prompt for input on how
     * much to sell. input must be between 0 and acres owned and amount.
     * @param none
     */
    public static void sellLandView() {
        //get the cost of land for this round
        int price = CropControl.calcLandCost();
        //prompt the user to enter the number of acres to sell
        System.out.format("\nLand is selling for %d bushels per acre.%n", price);
        System.out.println("\nHow man acres of land do you wish to sell? ");
        //get user's input and save it
        int toSell;
        toSell = keyboard.nextInt();
        //call sellLand() method in the control layer to sell the land
        CropControl.sellLand(price, toSell, cropData);
        //output updated land owned and wheat in storehouse
        System.out.format("\nCurrent acres owned: %d", cropData.getAcresOwned());
        System.out.format("\nCurrent wheat in storehoues: %d\n", cropData.getWheatInStore());        
    }
    
    /**
     * plantCropsView method
     * Purpose: Display acres owned and wheat in store then prompt user for amount
     * they wish to use to plant crops
     * @param none
     */
    public static void plantCropsView() {
        //display current land, wheat, and population
        System.out.format("\n\nHow much land needed for crops?\nAcres of land owned: %d\n", cropData.getAcresOwned());
        System.out.format("Bushels of Wheat in storehouse: %d\n", cropData.getWheatInStore());
        System.out.format("Current city population: %d\n", cropData.getPopulation());
        //display conditions needed to care for crops and prompt user for input
        System.out.println("\n1 bushel of wheat can plant 2 acres, " +
                           "while 1 person can take care of 10 acres planted.\n" +
                           "How many acres of land do you wish to plant? ");
        //get input and save
        int toPlant;
        toPlant = keyboard.nextInt();
        //call plantCrops() method to plant crops
        CropControl.plantCrops(toPlant, cropData);
        //output acres planted for future harvest
        System.out.format("\nYou have planted %d acres of land for next year's harvest.", cropData.getAcresPlanted());
        System.out.format("\nCurrent wheat in storehoues: %d\n", cropData.getWheatInStore());
    }
    
    /**
     * displayCropsReportView method
     * purpose: display annual report
     * parameters: none
     * returns: none
     */
    public static void displayCropsReportView() {
             
        // Calc annual changes
        // Set year by adding 1 each iteration
        cropData.setYear(cropData.getYear() + 1);
        int year = cropData.getYear();
        // Calc how many people starved
        int starved = CropControl.calcStarved(cropData);
        // Random growth to population
        int growth = CropControl.growPopulation(cropData);
        // New population = Existing + Growth - Starved
        cropData.setPopulation(cropData.getPopulation() + growth - starved);        
        
        // The year number (model)
        System.out.println("In year " + year + ":");
        // How many people starved (control)
        System.out.println(starved + " People starved.");
        // How many people came to the city (control)
        System.out.println(growth + " people came to the city.");
        // The current population (model)
        System.out.println("The current population is " + cropData.getPopulation() + ".");
        // The number of acres of crop land owned by the city (model)
        System.out.println("The city now owns " + cropData.getAcresOwned() + " acres of land.");
        // The number of bushels per acre in this years harvest ????
        // ?? Does this need its own CropControl method for randomly setting bushels per acre???
        // The total number of bushels of wheat harvested (control)
        System.out.println("You harvested " + CropControl.harvestCrops(cropData) + " bushels of wheat.");
        // The number of bushels eaten by rats (control)
        System.out.println(CropControl.calcEatenByRats(cropData) + " bushels were eaten by rats.");
        // The number of bushels of wheat in store (model)
        System.out.println("You now have " + cropData.getWheatInStore() + " bushels of wheat in store.");
    }
}
