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

/*
 * Inplement the serializable interface to write class as a Java Bean
*/
import java.io.Serializable;

public class Game implements Serializable {
    
    private Player thePlayer;
    
    public Game () { }

    public void setPlayer(Player _thePlayer){
        this.thePlayer = _thePlayer;
    }
    
    public Player getPlayer(){
        return this.thePlayer;
    }
}
