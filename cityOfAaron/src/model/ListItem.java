/*
 * ListItem.java
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

public class ListItem implements Serializable {
    
    private String name;
    private int number;
    
    /**
     * Purpose: This is a public constructor for this class
     * 
     */
    // public constructor
    public ListItem(){
      
    }
    
    /**
     * Purpose: List items constructor for animals <p>
     * @param _animals
     * @param _qty 
     */
    // Paramaterized Constructor for animals
    public ListItem(String _animals, int _qty) {
        name = _animals;
        number = _qty;
    }
    
    /**
     * Purpose: Get the name of this player<p>
     * @return this.name - the user's name as string
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Purpose: Set the name of this player<p>
     * @param _name The name of the user as string
     */
    public void setName(String _name) {
        this.name = _name;
    }
    
    /**
     * Purpose: Get the number of items in this list
     * @return this.number - as a integer
     */
    public int getNumber(){
        return this.number;
    }
    
    /**
     * Purpose: Sets the number of items in this list for the specific object name
     * @param _number as an integer
     */
    public void setNumber(int _number) {
        this.number = _number;
    }
}