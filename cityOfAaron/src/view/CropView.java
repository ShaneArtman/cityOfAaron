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
import exceptions.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;
import java.util.ArrayList;

public class CropView {

    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);

    // Get references to the Game object and the CropData object
    static private Game game = CityOfAaron.getGame();
    static private CropData cropData = game.getCropData();

    /**
     * The runCropView method() Purpose: runs the methods to manage the crops
     * game Parameters: none Returns: none
     * =================================================================
     */
    public static void runCropView() {
        // call the buyLandView( ) method
        displayCropsReportView();
        payOfferingView();
        buyLandView();
        sellLandView();
        feedPeopleView();
        plantCropsView();
        wheatSurplusView();

        /**
         * add calls to the other crop view methods as they are written:
         * sellLandView() feedPeopleView() plantCropsView()
         * displayCropsReportView()
         *
         * Shane - Comments Without giving too much away, we may want to display
         * the population growth, amount of food that is required to feed all
         * people, the amount of wheat in the storehouse, the amount of land
         * available for sale and the population growth before they make a
         * decision to buy land, feed people, etc.
         *
         * Also, I would think that the order would be something like:
         *
         * Eaten by rats (limited to what is in the storehouse today) Harvest
         * growPopulation Sell Land Feed People Calc Starved - Not sure that
         * happens here Buy Land
         *
         *
         */
    }

    /**
     * payOfferingView method
     *
     * @author Nick Purpose: Have player pay an offering from last years harvest
     * Parameters: none Returns: none
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
            if (CropControl.setOffering(toOffer) == -1) {
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
        } else if (toOffer <= 10) {
            System.out.println("The Lord blesses those that remember Him.");
        } else if (toOffer <= 30) {
            System.out.println("A very generous offer indeed!");
        } else {
            System.out.println("May the Lord bless this people!");
        }

    }

    /**
     * The buyLandView method Purpose: interface with the user input for buying
     * land Parameters: none Returns: none
     * ==================================================================
     */
    public static void buyLandView() {
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();

        // Prompt the user to enter the number of acres to buy
        System.out.format("\n\nLand is selling for %d bushels per acre.%n", price);

        //  Get the user’s input and save it.
        int toBuy;
        boolean paramsNotOkay;
        do {
            paramsNotOkay = false;
            System.out.print("\nHow many acres of land do you wish to buy? \n");
            toBuy = keyboard.nextInt();
            // try block calls method that could throw an exception
            try {
                // Call the buyLand( ) method in the control layer to buy the land
                CropControl.buyLand(price, toBuy, cropData);
            } // to be executed when an exception is caught
            catch (CropException e) {
                System.out.println("I am sorry, this cannot be done");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while (paramsNotOkay);
        // output how much land we now own
        System.out.format("You now own %d acres of land.\n", cropData.getAcresOwned());
    }

    /**
     * Purpose: To feed the people, the user muse input the amount of wheat to
     * to feed them. The options will force values between 0 and wheat in the
     * storehouse as well as force multiples of 20 as it takes 20 bushels to
     * feed 1 person<p>
     * Once the player decides on the amount of food, decrement the food from
     * the store
     *
     * @param none
     * @return none
     */
    public static void feedPeopleView() {
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

        System.out.println("\n\nGlad you are thinking of all of those that have\n"
                + "worked so hard and provided food for the town. Now it\n"
                + "is time to feed them. Based on this year's harvest, \n"
                + "we have the following:\n");

        boolean paramsNotOkay;
        //Do this loop while the user is inputting incorrect options for wheat
        do {
            paramsNotOkay = false;
            // Display to the user what is in the store
            System.out.println("----------------------------------\nPopulation: "
                    + game.getCropData().getPopulation() + "\n"
                    + "Wheat in storehouse: "
                    + wheatInStorehouse + "\n"
                    + "How much wheat do you want to set aside for food?\n");

            // Collect input from the user
            userInput = keyboard.nextInt();
            try {
                // Need to now set the wheat for food
                CropControl.feedPeople(userInput, game.getCropData());
            } catch (CropException e) {
                paramsNotOkay = true;
                // Test for error in user input
                System.out.println("\n\nYou must select a value between "
                        + "0 (starve us all) and " + wheatInStorehouse
                        + "\n" + e.getMessage() + "\n");
            }
        } while (paramsNotOkay);

        //Display the result to the user
        System.out.println(
                "The food in the storehouse is now: "
                + game.getCropData().getWheatInStore() + "\n"
                + "and the food for feeding people is now "
                + game.getCropData().getWheatForFood());
    }

    /**
     * sellLandView method Purpose: display price land sells for per acre to
     * user and prompt for input on how much to sell. input must be between 0
     * and acres owned and amount.
     *
     * @param none
     */
    public static void sellLandView() {
        //get the cost of land for this round
        int price = CropControl.calcLandCost();
        // Define variable for checking for exceptions

        boolean paramsNotOkay;

        do {
            // Set variable to check for exceptions
            paramsNotOkay = false;
            // Variable for getting user input

            int toSell;
            //prompt the user to enter the number of acres to sell
            System.out.format("\nLand is selling for %d bushels per acre.%n", price);
            System.out.println("\nHow man acres of land do you wish to sell? ");
            //get user's input and save it
            toSell = keyboard.nextInt();

            try {
                //call sellLand() method in the control layer to sell the land
                CropControl.sellLand(price, toSell, cropData);

            } catch (CropException e) {
                // Print exception report to user
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay
                        = true;

            }
        } while (paramsNotOkay);
        //output updated land owned and wheat in storehouse
        System.out.format("\nCurrent acres owned: %d", cropData.getAcresOwned());
        System.out.format("\nCurrent wheat in storehoues: %d\n", cropData.getWheatInStore());

    }

    /**
     * plantCropsView method 
     * Purpose: Display acres owned, wheat in store, and population then prompt
     * player for input on how many acres are to be planted for crops.
     * @param none
     */
    public static void plantCropsView() {        
        int toPlant;
        boolean paramsNotOkay;
        do{
            paramsNotOkay = false;
            //display current land, wheat, and population
            System.out.format("\n\nAcres of land owned: %d\n", cropData.getAcresOwned());
            System.out.format("Bushels of Wheat in storehouse: %d\n", cropData.getWheatInStore());
            System.out.format("Current city population: %d\n", cropData.getPopulation());
            System.out.println("\n1 bushel of wheat can plant 2 acres, "
                + "while 1 person can take care of 10 acres planted.\n"
                + "How many acres of land do you wish to plant? ");
            toPlant = keyboard.nextInt();
            try {
                //call plantCrops() method to plant crops
                CropControl.plantCrops(toPlant, cropData);
            }
            catch(CropException e) {
                //error message to be displayed
                System.out.println("I am sorry, this cannot be done.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);
        //output acres planted for future harvest
        System.out.format("\nYou have planted %d acres of land for next year's harvest.", cropData.getAcresPlanted());
        System.out.format("\nCurrent wheat in storehoues: %d\n", cropData.getWheatInStore());
    }

    /**
     * displayCropsReportView method purpose: display annual report parameters:
     * none returns: none
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
        cropData
                .setPopulation(cropData.getPopulation() + growth - starved);

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
    /**
     * wheatSurplusView method
     * Purpose: Offer option to buy more tools to improve harvest
     */
    public static void wheatSurplusView() {
        // Get current amount of wheat in store
        int wheat = cropData.getWheatInStore();
        // Ammount of wheat spent on tools
        int spend;
        // Cost per tool
        int costPerTool = 50; 
        
        // Prompt if user wants to buy tools
        System.out.println("\n\nYou have " + wheat + " extra wheat in store." 
            + "\nWould you like to buy tools to improve harvesting" 
            + " returns?\n 1 - Yes\n 2 - No");
        
        // get user input
        spend = keyboard.nextInt();
        
        // If yes, run buyTools()
        if (spend == 1) {
            // Display current amount of tools
            // Get tools list from game object
            ArrayList<ListItem> tools = game.getTools();

            // Print off header
            System.out.println("\nHere is a list of tools in store\n" +
                    "------------------------------------");

            // Print off tools and quantities
            for (ListItem tool: tools) {
                System.out.println(tool.getName() + "\t" + tool.getNumber());
            }
            
            // do while check variable
            int check = 0;
            do{ 
                // Ask how many tools to buy
                System.out.println("\nEach tool costs " + costPerTool + " wheat. " 
                        + "How much would you like to spend on new tools?");
                spend = keyboard.nextInt();
                
                if (spend > wheat) {
                    System.out.println("\nYou do not have that much wheat.");
                }
                else if (spend == 0) {
                    System.out.println("\nOkay.  No new tools this year then.");
                    check = 1;
                }
                else if (spend < costPerTool) {
                    System.out.println("\nThat is not enough to purchase a tool.");
                }
                else {
                    GameControl.buyTools(costPerTool, wheat, spend, cropData);
                    check = 1;
                }
            } while (check != 1);
        }
        
    }
}
