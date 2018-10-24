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

    // calcLandCost() method
    // Purpose: Calculate a random land price between 17 and 26 bushels/acre
    // Parameters: none
    // Returns: the land cost
    public static int calcLandCost(){
        int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;  
        return landPrice;                        
    }

    // The sellLand method
    // Purpose: To sell land
    // Parameters: the price of land, the number of acres to sell, and
    // a reference to a CropData object
    // Returns: the number of acres owned after the sale
    // Pre-conditions: acres to sell must be positive
    // and <= acresOwned

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
     * buyLand(int)
     * Purpose: To buy land
     * @param landPrice the price of land
     * @param acresToBuy the number of acres to buy
     * @param _cropData a reference to a CropData object
     * @return result code of -1 is invalid and 0 is success
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
        return 0; //Success
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
}