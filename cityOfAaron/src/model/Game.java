/*
 * Game.java
 *
 * The Game Class for the cityOfAaron project
 * Created in the model package.
 * 
 * Created on Oct 8, 2018, 09:00:36 PM
 * Created by Team
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: <What is the purpose of the file?>
 */

package model;
import java.util.ArrayList;

/*
 * Inplement the serializable interface to write class as a Java Bean
*/
import java.io.Serializable;

public class Game implements Serializable {
    
    private Player player;
    private Map map;
    private CropData cropData;
    private ArrayList<ListItem> animals;
    private ArrayList<ListItem> tools;
    private ArrayList<ListItem> provisions;
    private boolean endOfGame;

    public Game () { }


    public CropData getCropData() {
        return this.cropData;
    }

    public void setCropData(CropData _cropData) {
        this.cropData = _cropData;
    }

    public ArrayList<ListItem> getAnimals() {
        return this.animals;
    }

    public void setAnimals(ArrayList<ListItem> _animals) {
        this.animals = _animals;
    }

    public ArrayList<ListItem> getTools() {
        return this.tools;
    }

    public void setTools(ArrayList<ListItem> _tools) {
        this.tools = _tools;
    }

    public ArrayList<ListItem> getProvisions() {
        return this.provisions;
    }

    public void setProvisions(ArrayList<ListItem> _provisions) {
        this.provisions = _provisions;
    }

    public void setPlayer(Player _thePlayer){
        this.player = _thePlayer;
    }
    
    public Player getPlayer(){
        return this.player;
    }
 
    public Map getMap() {
        return this.map;
    }

    public void setMap(Map _map) {
        this.map = _map;
    }

    /**
     * setEndOfGame
     * @purpose The purpose for this method to to track the end of the current game
     * expecting a boolean end of game status.
     * @param _endOfGame 
     */
    public void setEndOfGame (boolean _endOfGame) {
        this.endOfGame = _endOfGame;
    }
    
    /**
     * setEndOfGame
     * @purpose The purpose for this method to to track the end of the current game
     * returning a boolean end of game status
     * @return boolean (endOfGame)
     */    
    public boolean getEndOfGame() {
        return this.endOfGame;
    }

}
