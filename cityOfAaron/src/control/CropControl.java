/*
 * CropControl.java
 *
 * The Player Class for the cityOfAaron project
 * Created in the model package.
 * 
 * Created on Oct 22, 2018, 5:10:40 PM
 * Created by Team
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: class contains all of the calculation methods for managing the crops
 */

package control;
// Import random number generator class
import java.util.Random;


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

}
