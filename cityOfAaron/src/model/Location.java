/*
 * Location.java
 *
 * The Location Class for the cityOfAaron project
 * Created in the model package.
 * 
 * Created on Oct 9, 2018, 10:46:55 PM
 * Created by artieman1
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: To store the locations that exist within the game map
 */

package model;

import java.io.Serializable;

public class Location implements Serializable {

    //Variables include the description and symbol of the location
    private String description;
    private String symbol;
    
    //public constructor
    public Location() { }
    
    public String getDescription () {
        return this.description;
    }
    
    public void setDescription (String _description) {
        this.description = _description;
    }
    
    public String getSymbol () {
        return this.symbol;
    }
    
    public void setSymbol (String _symbol) {
        this.symbol = _symbol;
    }
}
