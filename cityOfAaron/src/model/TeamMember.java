/*
 * TeamMember.java
 *
 * The TeamMember Class for the cityOfAaron project
 * Created in the model package.
 * 
 * Created on Oct 9, 2018, 09:00:36 AM
 * Created by artieman1
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: List of team members in the development of this applciation
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
public enum TeamMember {
    //Member of the enumeration (Commas seperate the members)
    JONATHAN("Jonathan Unga", "Master and ruler"),
    NICK("Nick Hammond", "Life Coach"),
    SHANE("Shane Artman", "Flat Head");
    
    //data members
    private String name;
    private String title;
    
    // Public Constructor
    // Purpose: Initialize the value of name and title
    // Parameter: Name of the TeamMember and their title
    TeamMember(String _name, String _title) {
        name = _name;
        title = _title;
    }
    
    public String getName() {
        return name;
    }
    
    public String getTitle() {
        return title;
    }

}
