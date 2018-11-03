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
    
    private Player thePlayer;
    private Map theMap;
    private CropData cropData;
    private ArrayList<ListItem> animals;
    private ArrayList<ListItem> tools;
    private ArrayList<ListItem> provisions;

    public Game () { }


    public CropData getCropData() {
        return cropData;
    }

    public void setCropData(CropData _cropData) {
        this.cropData = _cropData;
    }

    public ArrayList<ListItem> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<ListItem> _animals) {
        this.animals = _animals;
    }

    public ArrayList<ListItem> getTools() {
        return tools;
    }

    public void setTools(ArrayList<ListItem> _tools) {
        this.tools = _tools;
    }

    public ArrayList<ListItem> getProvisions() {
        return provisions;
    }

    public void setProvisions(ArrayList<ListItem> _provisions) {
        this.provisions = _provisions;
    }
    

    public void setPlayer(Player _thePlayer){
        this.thePlayer = _thePlayer;
    }
    
    public Player getPlayer(){
        return this.thePlayer;
    }

}
