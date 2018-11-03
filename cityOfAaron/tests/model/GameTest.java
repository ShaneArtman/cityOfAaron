/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author artieman1
 */
public class GameTest {
    
    public GameTest() {
    }

    /**
     * Test of getCropData method, of class Game.
     */
    @Test
    public void testGetCropData() {
        System.out.println("getCropData");
        Game instance = new Game();
        CropData expResult = null;
        CropData result = instance.getCropData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCropData method, of class Game.
     */
    @Test
    public void testSetCropData() {
        System.out.println("setCropData");
        CropData _cropData = null;
        Game instance = new Game();
        instance.setCropData(_cropData);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnimals method, of class Game.
     */
    @Test
    public void testGetAnimals() {
        System.out.println("getAnimals");
        Game instance = new Game();
        ArrayList<ListItem> expResult = null;
        ArrayList<ListItem> result = instance.getAnimals();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnimals method, of class Game.
     */
    @Test
    public void testSetAnimals() {
        System.out.println("setAnimals");
        ArrayList<ListItem> _animals = null;
        Game instance = new Game();
        instance.setAnimals(_animals);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTools method, of class Game.
     */
    @Test
    public void testGetTools() {
        System.out.println("getTools");
        Game instance = new Game();
        ArrayList<ListItem> expResult = null;
        ArrayList<ListItem> result = instance.getTools();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTools method, of class Game.
     */
    @Test
    public void testSetTools() {
        System.out.println("setTools");
        ArrayList<ListItem> _tools = null;
        Game instance = new Game();
        instance.setTools(_tools);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProvisions method, of class Game.
     */
    @Test
    public void testGetProvisions() {
        System.out.println("getProvisions");
        Game instance = new Game();
        ArrayList<ListItem> expResult = null;
        ArrayList<ListItem> result = instance.getProvisions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProvisions method, of class Game.
     */
    @Test
    public void testSetProvisions() {
        System.out.println("setProvisions");
        ArrayList<ListItem> _provisions = null;
        Game instance = new Game();
        instance.setProvisions(_provisions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayer method, of class Game.
     */
    @Test
    public void testSetPlayer() {
        System.out.println("setPlayer");
        Player _thePlayer = null;
        Game instance = new Game();
        instance.setPlayer(_thePlayer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayer method, of class Game.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        Game instance = new Game();
        Player expResult = null;
        Player result = instance.getPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
