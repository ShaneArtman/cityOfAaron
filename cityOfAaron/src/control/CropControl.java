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

public class CropControl {
    
    // Constants
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 10;

    // Random number generator
    private static Random random = new Random();

    /** calcLandCost() method
    * Purpose: Calculate a random land price between 17 and 26 bushels/acre
    * Parameters: none
    * @return landPrice the land cost
    */
    public static int calcLandCost(){
        int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;  
        return landPrice;                        
    }

    /** The sellLand method ;
    * Purpose: To sell land
    * @param landPrice the price of land, 
    * @param acresToSell the number of acres to sell, and
    * @param cropData a reference to a CropData object
    * @return (int) the number of acres owned after the sale
    * Pre-conditions: acres to sell must be positive
    * and <= acresOwned
    */

    public static int sellLand(int landPrice, int acresToSell, CropData cropData){
        
        //if acresToSell < 0, return -1
        if(acresToSell < 0){
              return -1;
        }
        
        //if acresToSell > acresOwned, return -1
        int owned = cropData.getAcresOwned();
        if(acresToSell > owned){
             return -1;
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
     * @param landPrice the price of land
     * @param acresToBuy the number of acres to buy
     * @param _cropData a reference to a CropData object
     * @return (int) result code of -1 is invalid and 0 is success
     * Pre-conditions: acresToBuy must be greater than or equal to 0 and wheatInStore must be
     * greater than or equal to purchase price
     */
    public static int buyLand(int landPrice, int acresToBuy, CropData _cropData) {
        if (landPrice < 0 || acresToBuy < 0
                || (landPrice * acresToBuy) > _cropData.getWheatInStore()) {
            //The landPrice or acresToBuy had invalid values or the purchase price
            //  was greater than the wheat available to purchase with
            return -1;
        }
        //Update the CropData object with acres owned after purchase
        //  and spent wheat from the store
        _cropData.setAcresOwned(_cropData.getAcresOwned() + acresToBuy);
        _cropData.setWheatInStore(_cropData.getWheatInStore()-(acresToBuy*landPrice));
        return _cropData.getAcresOwned(); //Success
    }
    
    /**
     * Purpose: Set aside grain to feed the people of the City of Aaron
     * 
     * @param bushelsReservedForFood of food to reserve : int
     * @param _cropData CropData object
     * @return result code of -1 is invalid and 0 is success
     * 
     * Pre-Conditions: bushelsReservedForFood > 0 and < wheat that is in the store
     */
    public static int feedPeople(int bushelsReservedForFood, CropData _cropData) {
        // Receive input for the amount of grain to set aside (# bushels) as int
        // Validate that the #bushels to set aside exist in the grainary
        // If input > value in the grainary, return -1
        // If input < 0, return -1
        if (bushelsReservedForFood < 0 || bushelsReservedForFood > _cropData.getWheatInStore()) {
            return -1; //The user entered an invalid value or more wheat than was available
        }

        // If input <= value in the grainary, return 0 and update the following:
        //Bushels in the Grainary remaing
        //Bushels set aside for food for currrent year in the game
        //Update the data in CropData object
        _cropData.setWheatForFood(bushelsReservedForFood);
        _cropData.setWheatInStore(_cropData.getWheatInStore()-bushelsReservedForFood);
        return 0; //Success   
    }
    
    /**
     * 
     * Purpose: To determine how much of the crop in storage was destroyed by rats and
     * and update the storhouse
     * <p>
     * Pre-conditions: the random generator much generate a value > 0 and less or equal to 5%
     * @param _cropData is a CropData object about this users crops
     * @return return damage by rats of storage
     *
     */
    public static int calcEatenByRats(CropData _cropData) {
        double randomNumber = random.nextDouble();
        int ratDamage = (int) Math.floor((randomNumber * .05) * _cropData.getWheatInStore());
        _cropData.setWheatInStore(_cropData.getWheatInStore()-ratDamage);
        return 0;
    } 

    /**
     * Purpose: To determine how much of the population growth occurs and update the
     * population after the growth.
     * <p>
     * Pre-conditions: the random generator much generate a value >= 1 and <= 5% of population
     * 
     * @param _cropData is a CropData object about this users crops
     * @return (int) return population growth
     *
     */
    public static int growPopulation(CropData _cropData) {
        double randomNumber = random.nextDouble();
        //round down a random growth number of population
        int popGrowth = (int) Math.floor((randomNumber * .05) * _cropData.getPopulation());
        _cropData.setPopulation(popGrowth);
        //temp return population growth - could be 0/-1
        return 0;
    }
    
    /**
     * Purpose: To determine how many people starved and update the population.
     * <p>
     * Pre-conditions: no requirements as the CropData is the only input source
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
    * Purpose: To set the percentage to be used for an offering.
    * @param percentOfOffering is percentage as a whole number
    * @return Percentage as a whole number
    * or return -1 If conditions are not met
    * Pre-Conditions: Percentage must be >= 0 and <= 100
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
        if (percentOfOffering > MAX_PERCENT) {
            return -1;
        }

        // return percentOfOffering;
        return percentOfOffering;

    }
    
    /**
     * plantCrops Method
     * Purpose: determine how many acres and wheat owned is used to plant crops
     * @param acresToPlant is number of acres to be used for planting
     * @param _cropData cropData object
     * @return the number of acres planted and amount of wheat left in storage
     * Pre-conditions: acres being planed must be positive and <= acresOwned,
     * population must be >= (acres planted/10), and wheat in store must be >=
     * (acres planted/2)
     */
    public static int plantCrops(int acresToPlant, CropData _cropData){
        int owned = _cropData.getAcresOwned();
        int pop = _cropData.getPopulation();
        int wheat = _cropData.getWheatInStore();
        int planted = _cropData.getAcresPlanted();
        //wheat needed = acresToPlant/2
        int wheatNeeded = acresToPlant / 2;
        //pop needed = acresToPlant/10
        int popNeeded = acresToPlant / 10;
        //If acresToPlant<0 or acresToPlant>owned or pop<needed or wheat<needed
        // return -1
        if(acresToPlant < 0 || acresToPlant > owned || pop < popNeeded ||
                wheat < wheatNeeded)
            return -1;
        //subtract wheat needed from wheat in store
        wheat -= wheatNeeded;
        _cropData.setWheatInStore(wheat);
        //add acresToPlant to acresPlanted
        planted += acresToPlant;
        _cropData.setAcresPlanted(planted);
        return planted;
    }
}
