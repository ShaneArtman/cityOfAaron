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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buyLand method, of class CropControl.
     * Test Case 1
     */
    @Test
    public void testBuyLandCase1() {
        System.out.println("buyLand - Test Case 1");
        CropData _cropData = new CropData();
        _cropData.setAcresOwned(100);
        _cropData.setWheatInStore(1000);
        
        int landPrice = 20;
        int acresToBuy = 10;
        int expResult = 110;
        int result = CropControl.buyLand(landPrice, acresToBuy, _cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of buyLand method, of class CropControl.
     * Test Case 2
     */
    @Test
    public void testBuyLandCase2() {
        System.out.println("buyLand - Test Case 2");
        CropData _cropData = new CropData();
        _cropData.setAcresOwned(100);
        _cropData.setWheatInStore(1000);
        
        int landPrice = 20;
        int acresToBuy = -10;
        int expResult = -1;
        int result = CropControl.buyLand(landPrice, acresToBuy, _cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of buyLand method, of class CropControl.
     * Test Case 3
     */
    @Test
    public void testBuyLandCase3() {
        System.out.println("buyLand - Test Case 3");
        CropData _cropData = new CropData();
        _cropData.setAcresOwned(100);
        _cropData.setWheatInStore(1000);
        
        int landPrice = 20;
        int acresToBuy = 100;
        int expResult = -1;
        int result = CropControl.buyLand(landPrice, acresToBuy, _cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of buyLand method, of class CropControl.
     * Test Case 4
     */
    @Test
    public void testBuyLandCase4() {
        System.out.println("buyLand - Test Case 4");
        CropData _cropData = new CropData();
        _cropData.setAcresOwned(100);
        _cropData.setWheatInStore(1000);
        
        int landPrice = 20;
        int acresToBuy = 50;
        int expResult = 150;
        int result = CropControl.buyLand(landPrice, acresToBuy, _cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of buyLand method, of class CropControl.
     * Test Case 5
     */
    @Test
    public void testBuyLandCase5() {
        System.out.println("buyLand - Test Case 5");
        CropData _cropData = new CropData();
        _cropData.setAcresOwned(100);
        _cropData.setWheatInStore(1000);
        
        int landPrice = 20;
        int acresToBuy = 0;
        int expResult = 100;
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buyLand method, of class CropControl.
     */
    @Test
    public void testBuyLand() {
        System.out.println("buyLand");
        int landPrice = 0;
        int acresToBuy = 0;
        CropData _cropData = null;
        int expResult = 0;
        int result = CropControl.buyLand(landPrice, acresToBuy, _cropData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcEatenByRats method, of class CropControl.
     */
    @Test
    public void testCalcEatenByRats() {
        System.out.println("calcEatenByRats");
        CropData RatTestCropData = new CropData();
        RatTestCropData.setWheatInStore(4111);
        System.out.println("Wheat in the store: " + RatTestCropData.getWheatInStore());
        int expResult = 0;
        int result = (CropControl.calcEatenByRats(RatTestCropData)) >= 0? 0:1;
        assertEquals(expResult, result);
    }

    /**
     * Test of growPopulation method, of class CropControl.
     */
    @Test
    public void testGrowPopulation() {
        System.out.println("growPopulation");
        CropData _cropData = null;
        int expResult = 0;
        int result = CropControl.growPopulation(_cropData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcStarved method, of class CropControl.
     */
    @Test
    public void testCalcStarved() {
        System.out.println("calcStarved");
        CropData _cropData = null;
        int expResult = 0;
        int result = CropControl.calcStarved(_cropData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
