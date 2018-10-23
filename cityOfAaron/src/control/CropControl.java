/*
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
 * Purpose: <What is the purpose of the file?>
 */

package control;


public class CropControl {
    
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
        
    }
    
    public static int feedPeople(int bushelsReservedForFood, CropData _cropData) {
        //Test to user input for invalid values
        if (bushelsReservedForFood < 0 || bushelsReservedForFood > _cropData.getWheatInStore()) {
            return -1; //The user entered an invalid value or more wheat than was available
        }
        //Update the data in CropData object
        _cropData.setWheatForFood(bushelsReservedForFood);
        _cropData.setWheatInStore(_cropData.getWheatInStore()-bushelsReservedForFood);
        return 0;
    }

}
