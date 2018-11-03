/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author nrham
 */
public class MainMenuViewTest {
    
    public MainMenuViewTest() {
    }

    /**
     * Test of displayMenuView method, of class MainMenuView.
     */
    @Test
    public void testDisplayMenuView() {
        System.out.println("displayMenuView");
        MainMenuView instance = new MainMenuView();
        instance.displayMenuView();
        
    }

    /**
     * Test of getMenuOption method, of class MainMenuView.
     */
    @Test
    public void testGetMenuOption() {
        System.out.println("getMenuOption");
        MainMenuView instance = new MainMenuView();
        int expResult = 0;
        int result = instance.getMenuOption();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of doAction method, of class MainMenuView.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        int option = 0;
        MainMenuView instance = new MainMenuView();
        instance.doAction(option);
        
    }

    /**
     * Test of startNewGame method, of class MainMenuView.
     */
    @Test
    public void testStartNewGame() {
        System.out.println("startNewGame");
        MainMenuView instance = new MainMenuView();
        instance.startNewGame();
        
    }

    /**
     * Test of startSavedGame method, of class MainMenuView.
     */
    @Test
    public void testStartSavedGame() {
        System.out.println("startSavedGame");
        MainMenuView instance = new MainMenuView();
        instance.startSavedGame();
        
    }

    /**
     * Test of displayHelpMenuView method, of class MainMenuView.
     */
    @Test
    public void testDisplayHelpMenuView() {
        System.out.println("displayHelpMenuView");
        MainMenuView instance = new MainMenuView();
        instance.displayHelpMenuView();
        
    }

    /**
     * Test of displaySaveGameView method, of class MainMenuView.
     */
    @Test
    public void testDisplaySaveGameView() {
        System.out.println("displaySaveGameView");
        MainMenuView instance = new MainMenuView();
        instance.displaySaveGameView();
        
    }
    
}
