/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.CropData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nrham
 */
public class CropControlTest {
    
    public CropControlTest() {
    }

    /**
     * Test of calcLandCost method, of class CropControl.
     */
    @Test
    public void testCalcLandCost() {
        System.out.println("calcLandCost");
        int expResult = 0;
        int result = CropControl.calcLandCost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sellLand method, of class CropControl.
     */
    @Test
    public void testSellLand() {
        System.out.println("sellLand");
        int landPrice = 10;
        int acresToSell = 20;
        CropData cropData = null;
        int expResult = 0;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of buyLand method, of class CropControl.
     */
    @Test
    public void testBuyLand() {
        System.out.println("buyLand");
        
        CropData _cropData = new CropData();
        _cropData.setWheatInStore(1000);
        _cropData.setAcresOwned(100);
        
        int landPrice = 20;
        int acresToBuy = 10;
        int expResult = 110;
        int result = CropControl.buyLand(landPrice, acresToBuy, _cropData);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of feedPeople method, of class CropControl.
     */
    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople");
        int bushelsReservedForFood = 0;
        CropData _cropData = null;
        int expResult = 0;
        int result = CropControl.feedPeople(bushelsReservedForFood, _cropData);
        assertEquals(expResult, result);
    }
    
}
