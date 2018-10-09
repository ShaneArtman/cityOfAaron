/*
 * Player.java
 *
 * The Player Class for the cityOfAaron project
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
 * Implements the serializable interface to write class as a Java Bean
*/
import java.io.Serializable;
/**
 *
 * @author nrham
 */
public class Player implements Serializable {
    
    private String name;
    
    public Player(){ }
    
    public String getName(){
        return name;
    }
    
    public void setName(String _name) {
        name = _name;
    }
}
