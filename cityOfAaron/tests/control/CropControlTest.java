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
        
    }

    /**
     * Test of sellLand method, of class CropControl.
     */
    @Test
    public void testSellLand1() {
        System.out.println("sellLand1");
        int landPrice = 18;
        int acresToSell = 100;
        CropData cropData = new CropData();
        cropData.setAcresOwned(3000);
        int expResult = 2900;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
       
    }

    @Test
    public void testSellLand2() {
        System.out.println("sellLand2");
        int landPrice = 20;
        int acresToSell = -500;
        CropData cropData = new CropData();
        cropData.setAcresOwned(3000);
        int expResult = -1;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testSellLand3() {
        System.out.println("sellLand3");
        int landPrice = 22;
        int acresToSell = 3100;
        CropData cropData = new CropData();
        cropData.setAcresOwned(3000);
        int expResult = -1;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testSellLand4() {
        System.out.println("sellLand4");
        int landPrice = 24;
        int acresToSell = 0;
        CropData cropData = new CropData();
        cropData.setAcresOwned(3000);
        int expResult = 3000;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testSellLand5() {
        System.out.println("sellLand5");
        int landPrice = 18;
        int acresToSell = 3000;
        CropData cropData = new CropData();
        cropData.setAcresOwned(3000);
        int expResult = 0;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
       
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
     * Test of setOffering method, of class CropControl.
     */
    @Test
    public void testSetOffering1() {
        System.out.println("setOffering1");
        int percentOfOffering = 50;
        int expResult = 50;
        int result = CropControl.setOffering(percentOfOffering);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSetOffering2() {
        System.out.println("setOffering2");
        int percentOfOffering = -20;
        int expResult = -1;
        int result = CropControl.setOffering(percentOfOffering);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSetOffering3() {
        System.out.println("setOffering3");
        int percentOfOffering = 130;
        int expResult = -1;
        int result = CropControl.setOffering(percentOfOffering);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSetOffering4() {
        System.out.println("setOffering4");
        int percentOfOffering = 0;
        int expResult = 0;
        int result = CropControl.setOffering(percentOfOffering);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSetOffering5() {
        System.out.println("setOffering5");
        int percentOfOffering = 100;
        int expResult = 100;
        int result = CropControl.setOffering(percentOfOffering);
        assertEquals(expResult, result);
        
    }
}
