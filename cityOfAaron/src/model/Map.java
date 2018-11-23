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
    
    /**
     * default Map constructor
     * Purpose: Set data members to default values
     * @param none
     * @return none
     */
    public Map() { }

    /**
    * parameterized Map constructor
    * Purpose: Set data members to default values
    * @param 
    * @return none
    */
    public Map(int _cols, int _rows) {
        rowCount = _rows;
        colCount = _cols;
        // creat the array of location objects
        locations = new Location[_cols][_rows];
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

   /**
    * getLocation method
    * Purpose: returns the location object at the given row and column
    * @param row and column
    * @return location object
    */
    public Location getLocation(int col, int row) {
        return locations[col][row];
    }
    
    /**
    * setLocation method
    * Purpose: stores a location object at the row and column
    * @param row and column, reference to a location object
    * @return void
    */
    public void setLocation(int col, int row, Location _location){
        locations[col][row] = _location;
    }
    
    /**
     * setLocation method
     * Purpose: stores location objects at the rows and columns
     * @param col
     * @param row
     * @param col2
     * @param row2
     * @param _location 
     * @return none
     */
    public void setLocation(int col, int row, int col2, int row2, Location _location){    
        for (int i = col;i<=col2; i++) {
            for (int j = row;j<=row2; j++) {
                locations[i][j] = _location;
            }
        }
    }
}
