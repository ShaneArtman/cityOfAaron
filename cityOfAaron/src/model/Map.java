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
    
    private int rowCount;
    private int colCount;
    private int[][] location;

    public Map() { }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public void setColCount(int colCount) {
        this.colCount = colCount;
    }

    public int[][] getLocation() {
        return location;
    }

    public void setLocation(int[][] location) {
        this.location = location;
    }

}
