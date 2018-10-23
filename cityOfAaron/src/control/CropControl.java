/**
 * Purpose: To provide control for the CropData and CropView classes.
 * 
 * CropControl.java
 *
 * The CropControl Class for the cityOfAaron project
 * Created in the control package.
 * 
 * Created on Oct 23, 2018, 4:11:05 PM
 * Created by artieman1
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * 
 *  
 */

package control;


public class CropControl {
    
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
