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
    
    // public constructor
    public ListItem(){
      
    }
    
    // Paramaterized Constructor for animals
    public ListItem(String _animals, int _qty) {
        name = _animals;
        number = _qty;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String _name) {
        this.name = _name;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public void setNumber(int _number) {
        this.number = _number;
    }
}