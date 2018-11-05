/**
 * The CropView class - part of the view layer
 * Purpose: View layer for crop management
 * 
 * CropView.java
 *
 * The CropView Class for the cityOfAaron project
 * Created in the view package.
 * 
 * Created on Nov 5, 2018
 * Created by Team
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * 
 *  
 */
package view;
//import CityOfAaron class and all classes in model and control packages
import model.*;
import control.*;
import cityofaaron.CityOfAaron;
import java.util.Scanner;

public class CropView {
    //creat a Scanner object
    private static Scanner keyboard = new Scanner(System.in);
    
    //get references to the Game object and the CropData object
    static private Game game = CityOfAaron.getGame();
    static private CropData cropData = game.getCropData();
    
}
