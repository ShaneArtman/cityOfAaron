/*
 * Map.java
 *
 * The Map Class for the cityOfAaron project
 * Created in the model package.
 * 
 * Created on Nov 2, 2018, 11:48:30 PM
 * Created by artieman1
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: <What is the purpose of the file?>
 */

package model;

import java.io.Serializable;

public class Map implements Serializable {
    // stores the number of rows
    private int rowCount;
    // stores the number of columns
    private int colCount;
    // reference to a 2-dimensional array of location objects
    private Location[][] locations;

    /*
    * Map constructor
    * Purpose: Set data members to default values
    * @param none
    * @return none
    */
    public Map(int _rows, int _cols) {
        rowCount = _rows;
        colCount = _cols;
        // creat the array of location objects
        locations = new Location[_rows][_cols];
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

   /*
    * getLocation method
    * Purpose: returns the location object at the given row and column
    * @param row and column
    * @return location object
    */
    public Location getLocation(int row, int col) {
        return locations[row][col];
    }
    
    /*
    * setLocation method
    * Purpose: stores a location object at the row and column
    * @param row and column, reference to a location object
    * @return void
    */
    public void setLocation(int row, int col, Location _location){
        locations[row][col] = _location;
    }
}
