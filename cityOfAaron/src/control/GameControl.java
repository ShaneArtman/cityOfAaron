/*
 * GameControl.java
 *
 * The GameControl Class for the cityOfAaron project
 * Created in the control package.
 * 
 * Created on Nov 3, 2018, 12:50:52 AM
 * Created by artieman1
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: <What is the purpose of the file?>
 */

package control;
import model.*;
import cityofaaron.CityOfAaron;


public class GameControl {
    
    //size of the Locations array
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
      // Create a new Game object.
    private static Game game = new Game();
    /**
     * Purpose: Create the Game object and starts the game
     * Created: 11.3.18
     * @author Shane Artman
     * @param _name 
     */
    public static void createNewGame (String _name) {
      

        // Create a new Player object
        Player player = new Player();

        //  Store the name of the player in the Player object
        player.setName(_name);
        
        // Store a reference to the Player object in the Game object
        game.setPlayer(player);
        
        // Save a reference to the Game object in the static variable
        CityOfAaron.setGame(game);

        // declared in the CityOfAaron class.
    }
    
    /**
     * createCropDataObject method
     * Purpose: create cropData object and set initial values for cropData
     * @param none
     * @return none
     */
    public static void createCropDataObject() {
        // Create a CropData object
        CropData cropData = new CropData();
        
        // Initialize the data values in the CropData object
        //setting test values
        cropData.setYear(0);
        cropData.setPopulation(100);
        cropData.setNewPeople(5);
        cropData.setCropYield(3);
        cropData.setNumberWhoDied(0);
        cropData.setWheatInStore(2700);
        cropData.setAcresOwned(1000);
        cropData.setAcresPlanted(1000);
        cropData.setHarvest(3000);
        // added to get CropView working - Nick
        cropData.setWheatForFood(2000);
        
        // Save a reference to the CropData object in the Game object
        game.setCropData(cropData);
    }
    
    /**
     * createMap method
     * Purpose: creates the location objects and the map
     * @param none
     * @return none
     */
    public static void createMap() {
        //creat the map object, 5x5. refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);
        
    }

}
