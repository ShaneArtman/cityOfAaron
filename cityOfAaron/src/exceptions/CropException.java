/**
 * Purpose: Exceptions class for CropControl
 * 
 * CropException.java
 *
 * The CropException Class for the cityOfAaron project
 * Created in the exceptions package.
 * 
 * Created on Nov 27, 2018, 11:31:05 AM
 * Created by Team
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga  
 */

package exceptions;

public class CropException extends Exception {
    /**
     * Default constructor
     * Purpose: Initializes data members to default values
     * @param none
     * @return none
     */
    public CropException() { }
    
    /**
     * Parameterized constructor
     * Purpose: Initializes data members to value passed as a parameter
     * @param string containing error message
     * @return none
     */
    public CropException(String string) {
        super(string);
    }
}
