/**
 * Purpose: To provide control for the CropData and CropView classes.
 * 
 * CropControl.java
 *
 * The CropControl Class for the cityOfAaron project
 * Created in the control package.
 * 
 * Created on Oct 23, 2018, 4:11:05 PM
 * Created by Team
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * 
 *  
 */

package control;
// Import random number generator class
import java.util.Random;
import model.*;
import exceptions.*;

public class CropControl {
    
    // Constants
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 10;
    private static final int YIELD_BASE = 2;
    private static final int YIELD_RANGE = 4;

    // Random number generator
    private static Random random = new Random();

    /** calcLandCost() method
    * @author Nick
    * Purpose: Calculate a random land price between 17 and 26 bushels/acre
    * Parameters: none
    * @return landPrice the land cost
    */
    public static int calcLandCost(){
        int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;  
        return landPrice;                        
    }

    /** The sellLand method 
    * @author Nick
    * Purpose: To sell land
    * @param landPrice the price of land, 
    * @param acresToSell the number of acres to sell, and
    * @param cropData a reference to a CropData object
    * @return (int) the number of acres owned after the sale
    * Preconditions: acres to sell must be positive
    * and <= acresOwned
    */

    public static int sellLand(int landPrice, int acresToSell, CropData cropData) throws CropException {
        // Get acres owned
        int owned = cropData.getAcresOwned();

        //if acresToSell < 0, Throw exception that entry was too low
        if(acresToSell < 0){
            throw new CropException("A negative number was entered.");
        }
        //if acresToSell > acresOwned, Throw exception that entry was too high
        if(acresToSell > owned){
            throw new CropException("A quantity greater than acres owned was entered.");
        }
        //acresOwned = acresOwned - acresToSell
        owned -= acresToSell;
        cropData.setAcresOwned(owned);
        //wheatInStore = wheatInStore + acresToSell * landPrice
        int wheat = cropData.getWheatInStore();
        wheat+= (acresToSell * landPrice);
        cropData.setWheatInStore(wheat);
        //return acresOwned
        return owned;

    }
    
    /**
     * buyLand(int):int
     * Purpose: To buy land
     * <p>
     * Preconditions: acresToBuy must be greater than or equal to 0 and wheatInStore must be
     * greater than or equal to purchase price
     * @param landPrice the price of land
     * @param acresToBuy the number of acres to buy
     * @param _cropData a reference to a CropData object
     */
    public static void buyLand(int landPrice, int acresToBuy, CropData _cropData) throws CropException {
        if (acresToBuy < 0) {
            // acres to buy input was a negative number
            throw new CropException("A negative number was input. Cannot buy");
        }
        if ((landPrice * acresToBuy) > _cropData.getWheatInStore()) {
            // purchase price is greater than wheat available to purchase with
            throw new CropException("There is not enough wheat to buy this much land");
        }
        //Update the CropData object with acres owned after purchase
        //  and spent wheat from the store
        _cropData.setAcresOwned(_cropData.getAcresOwned() + acresToBuy);
        _cropData.setWheatInStore(_cropData.getWheatInStore()-(acresToBuy*landPrice));
    }
    
    /**
     * Purpose: Set aside grain to feed the people of the City of Aaron
     * <p>
     * Preconditions: bushelsReservedForFood {@literal > 0 and <} wheat that is in the store
     * @author Shane Artman
     * @param bushelsReservedForFood of food to reserve : int
     * @param _cropData CropData object
     * @return result code of -1 is invalid and 0 is success
     * 
     */
    public static void feedPeople(int bushelsReservedForFood, CropData _cropData) throws CropException {
        // Receive input for the amount of grain to set aside (# bushels) as int
        // Validate that the #bushels to set aside exist in the grainary
        // If input > value in the grainary, return -1
        // If input < 0, return -1
        if (bushelsReservedForFood < 0) {
            //The user entered an invalid value (negative)
            throw new CropException("You cannot enter a negative value");
        }
        if (bushelsReservedForFood > _cropData.getWheatInStore()) {
            // The user does not have that much grain
            throw new CropException("You do not have that much grain in the storehouse.");
        }

        //Bushels in the Grainary remaing
        //Bushels set aside for food for currrent year in the game
        _cropData.setWheatForFood(bushelsReservedForFood);
        _cropData.setWheatInStore(_cropData.getWheatInStore()-bushelsReservedForFood);
    }
    
    /**
     * 
     * Purpose: To determine how much of the crop in storage was destroyed by rats and
     * and update the storehouse
     * <p>
     * Pre-conditions: the random generator much generate a value > 0 and less or equal to 5%
     * @author Shane Artman
     * @param _cropData is a CropData object about this users crops
     * @return return damage by rats of storage
     *
     */
    public static int calcEatenByRats(CropData _cropData) {
        double randomNumber = random.nextDouble();
        int ratDamage = (int) Math.floor((randomNumber * .05) * _cropData.getWheatInStore());
        _cropData.setWheatInStore(_cropData.getWheatInStore()-ratDamage);
        // Changed from "return 0" - Nick
        return ratDamage;
    } 

    /**
     * Purpose: To determine how much of the population growth occurs and update the
     * population after the growth.
     * <p>
     * Pre-conditions: the random generator much generate a value {@literal >= 0 and <=} 5% of population
     * @author Shane Artman
     * @param _cropData is a CropData object about this users crops
     * @return (int) return population growth
     *
     */
    public static int growPopulation(CropData _cropData) {
        double randomNumber = random.nextDouble();
        //round down a random growth number of population
        int popGrowth = (int) Math.floor((randomNumber * .05) * _cropData.getPopulation());
        _cropData.setNewPeople(popGrowth);
        // Changed from "return 0" - Nick
        return _cropData.getNewPeople();
    }
    
    /**
     * Purpose: To determine how many people starved and update the population.
     * <p>
     * Pre-conditions: no requirements as the CropData is the only input source
     * @author Shane Artman
     * @param _cropData is a CropData object about this users crops
     * @return (int) return starved population
     *
     */
    public static int calcStarved(CropData _cropData) {
        int peopleFed = (int) Math.floor(_cropData.getWheatForFood()/20);
        //likely, we are not to calculate other veriables like the number of remaining population
        //  thus, we will not determine that at this time
        if ( _cropData.getPopulation() > peopleFed ) {
            _cropData.setNumberWhoDied(_cropData.getPopulation()-peopleFed);
        // because we are only calculating here, not sure that we should kill the people here
        // _cropData.setPopulation(peopleFed); 
        }
        else
        {
            _cropData.setNumberWhoDied(0);
        }
        //temp return population growth - could be 0/-1
        return _cropData.getNumberWhoDied();
    }

    /**
    * setOffering Method
    * @author Nick
    * Purpose: To set the percentage to be used for an offering.
    * @param percentOfOffering is percentage as a whole number
    * @return Percentage as a whole number
    * @PreConditions: Percentage must be >= 0 and <= 100
    */
    public static int setOffering(int percentOfOffering) {  
        // set min/max values as variables
        final int MIN_PERCENT = 0;
        final int MAX_PERCENT = 100;
        // if percentOfOffering < 0, return -1;
        if (percentOfOffering < MIN_PERCENT) {
            return -1;
        }
        // if percentOfOffering > 100, return -1;
        else if (percentOfOffering > MAX_PERCENT) {
            return -1;
        }
        // return percentOfOffering;
        return percentOfOffering;
    }
    
    /**
     * plantCrops Method
     * Purpose: determine how many acres and wheat owned is used to plant crops
     * @author Jonathan Unga
     * @param acresToPlant is number of acres to be used for planting
     * @param _cropData cropData object
     * Preconditions: acres being planed must be positive and <= acresOwned,
     * population must be >= (acres planted/10), and wheat in store must be >=
     * (acres planted/2)
     */
    public static void plantCrops(int acresToPlant, CropData _cropData) throws CropException {
        int owned = _cropData.getAcresOwned();
        int pop = _cropData.getPopulation();
        int wheat = _cropData.getWheatInStore();
        int planted = _cropData.getAcresPlanted();
        //wheat needed = acresToPlant/2
        int wheatNeeded = acresToPlant / 2;
        //pop needed = acresToPlant/10
        int popNeeded = acresToPlant / 10;
        //check preconditions and throw exception if they are not ok
        if(acresToPlant < 0) {
            //input was negative
            throw new CropException("Cannot plant a negative value");
        }
        if(acresToPlant > owned) {
            //input was more than acres owned
            throw new CropException("The city does not own this much land");
        }
        if(pop < popNeeded) {
            //not enough population to care for crops
            throw new CropException("Not enough people to care for the crops");
        }
        if(wheat < wheatNeeded) {
            //not enough wheat to plant acres input
            throw new CropException("There is insufficient wheat to plant this many acres");
        }
        //subtract wheat needed from wheat in store
        wheat -= wheatNeeded;
        _cropData.setWheatInStore(wheat);
        //set acresPlanted
        _cropData.setAcresPlanted(acresToPlant);
    }
    
     /**
     * harvestCrops Method
     * Purpose: determine how much crops yielded and update wheat in store
     * @author Jonathan Unga
     * @param _cropData cropData object
     * @return amount of crops yielded
     * Preconditions: random generator must generate number >=2 and <=5 for 
     * crops yielded per acre
     */
    public static int harvestCrops(CropData _cropData){
        //generate randome yield number from 2 to 5, set to fixed for test purpose
        /*
         * Shane - Comments - Need to have this as a random number, not a static value
        */
        int cropsYield = 3;
        int acresHarvested = _cropData.getAcresPlanted();
        int wheat = _cropData.getWheatInStore();
        //multiply random yield by acres being harvested to get harvest total
        int harvest = cropsYield * acresHarvested;
        wheat += harvest;
        _cropData.setWheatInStore(wheat);
        _cropData.setHarvest(harvest);
        return harvest;
    }
    
     /**
     * storeWheat Method
     * Purpose: set the amount of wheat in store
     * unsure what this method is to be used for with current information
     * initialized wheatInStore with 2700 based on beginning wheat from document
     * requirements
     * @author Jonathan Unga
     * @param _cropData cropData object
     * @return amount of wheat in store
     * Preconditions: none as number of wheat in beginning is set to 2700
     */
    public static int storeWheat(CropData _cropData){
        //setting initial wheat in store to 2700
        _cropData.setWheatInStore(2700);
        return _cropData.getWheatInStore();
    }
    
     /**
     * payOffering Method
     * Purpose: take specified percent of harvest from wheat in store as offering
     * We assumed that we are to modify the wheatInStore from this calculation
     * based on current information
     * @author Jonathan Unga
     * @param _cropData cropData object
     * @return the amount of wheat as offering
     * Preconditions: need percent of offering from setOffering method
     */
    public static int payOffering(CropData _cropData){
        int percent = _cropData.getOffering();
        double payPercent = (double)percent * .01;
        int wheat = _cropData.getWheatInStore();
        int offering = (int)(payPercent * _cropData.getHarvest());
        _cropData.setWheatInStore(wheat - offering);
        return offering;
    }
}
