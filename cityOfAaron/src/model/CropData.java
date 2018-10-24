/*
 * CropData.java
 *
 * The Crop Data class for the City of Aaron project
 * Created in the Model package
 * 
 * Created on Oct 11, 2018 10:22 am
 * Created by Jonathan Unga
 *
 * CIT-260: 08
 * Fall 2018
 * Team Members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: To store data for crops in the City of Aaron project
 */

package model;

/*
 * implements serializable interface for Javabean
 */
import java.io.Serializable;

public class CropData implements Serializable {
    
    //instance variables
    private int year;
    private int population;
    private int acresOwned;
    private int cropYield;
    private int wheatInStore;
    private int numberWhoDied;
    private int newPeople;
    private int harvest;
    private int wheatForFood;
    private int acresPlanted;
    
    //empty public constructor
    public CropData() { }
    
    //getter and setters for each instance variable
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int _year) {
        this.year = _year;
    }
    
    public int getPopulation() {
        return this.population;
    }
    
    public void setPopulation(int _population) {
        this.population = _population;
    }
    
    public int getAcresOwned() {
        return this.acresOwned;
    }
    
    public void setAcresOwned(int _acresOwned) {
        this.acresOwned = _acresOwned;
    }
    
    public int getCropYield() {
        return this.cropYield;
    }
    
    public void setCropYield(int _cropYield) {
        this.cropYield = _cropYield;
    }
    
    public int getWheatInStore() {
        return this.wheatInStore;
    }
    
    public void setWheatInStore(int _wheatInStore) {
        this.wheatInStore = _wheatInStore;
    }
    
    public int getNumberWhoDied() {
        return this.numberWhoDied;
    }
    
    public void setNumberWhoDied(int _numberWhoDied) {
        this.numberWhoDied = _numberWhoDied;
    }
    
    public int getNewPeople() {
        return this.newPeople;
    }
    
    public void setNewPoeple(int _newPeople) {
        this.newPeople = _newPeople;
    }
    
    public int getHarvest() {
        return this.harvest;
    }
    
    public void setHarvest(int _harvest) {
        this.harvest = _harvest;
    }
    
    public int getWheatForFood() {
        return this.wheatForFood;
    }
    
    public void setWheatForFood(int _wheatForFood) {
        this.wheatForFood = _wheatForFood;
    }
    
    public int getAcresPlanted() {
        return this.acresPlanted;
    }
    
    public void setAcresPlanted(int _acresPlanted) {
        this.acresPlanted = _acresPlanted;
    }
    
}
