/*
 * ListMenuView.java
 *
 * The ListMenuView Class for the cityOfAaron project
 * Created in the view package.
 * 
 * Created on Nov 5, 2018, 9:55:27 PM
 * Created by artieman1
 * Updated on Nov 15, 2018
 * Updated by artieman1
 *
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: Class to view the lists of items, Animals, tools, Provisions, Team
 */

package view;
import cityofaaron.CityOfAaron; //Importing the CityOfAaron class for the GAME objec
import control.GameControl;
import model.*; //Importing the model packages for the reference to the Game model
import java.util.ArrayList;
import static view.MenuView.keyboard;


public class ListMenuView extends MenuView {
        
    private Game game = CityOfAaron.getGame();
    
    /**
     * Purpose: Public constructor for the ListMenuView
     * Creates a menu specific to the List Menu
     * We pass the menu as a string and the number of menu options to be processed
     * in the Menu View display menu and get options methods.
     * @Param none
     * @Return none
     */
    public ListMenuView () {
    super(  "\n" +
            "*********************************\n" +
            "** CITY OF AARON: IN-LIST MENU **\n" +
            "*********************************\n" +
            " 1 - List the animals in the storehouse\n" +
            " 2 - List the tools in the storehouse\n" +
            " 3 - List the provisions in the storehouse\n" +
            " 4 - List the Developers\n" +
            " 5 - Return to the Main menu\n"
            ,5);
    }
    
    /**
     * Purpose: To perform the player's desired action<p>
     * @Param none
     */
    @Override public void doAction(int option) {
        switch (option) {
            case 1: //List the animals
                listAnimals();
                break;
            case 2: //List tools
                listTools();
                break;
            case 3: //List provisions
                listProvisions();
                break;
            case 4: //List developers
                listTeam();
                break;
            case 5: //Return to the calling menu
                return;
        }
    }
    
    /**
     * Purpose: Display the list of animals that the player has<p>
     * @Param none
     */
    public void listAnimals() {
        
        // track valid answers to save to disk
        boolean notValidInput = true;
        // response to question yes/no
        int response = 0;
        // Reponse to question for filename
        String strResponse;
        // Variable for ArrayList to be displayed
        ArrayList<ListItem> animals = game.getAnimals();
        System.out.println("City of Aaron animal list");
        
        System.out.println("Here is a list of animals\n" +
                "------------------------------------");
        // Itterate through animals
        for (ListItem animal: animals) {
            System.out.println(animal.getName() + "\t" + animal.getNumber());
        }
        
        // Prompt for writing to file
        while (notValidInput) {
            System.out.println("\n\nWould you like to save a copy to file?\n" +
                    "\t1 = Yes\t2 = No");
            response = keyboard.nextInt();
            if (response < 0 || response > 2) {
                System.out.println("You must enter a value of 1 or 2");
            }
            else {
                notValidInput = false;
            }
        }
        if (response == 1) {
            System.out.println("Please enter a filename");
            strResponse = keyboard.next();
            // call method to print to file
            GameControl.printAnimals(strResponse);
        }
    }
    
    /**
     * @author Nick
     * Purpose: Display the list of tools that the player has
     * @Param none
     * @Return none
     */
    public void listTools() {
        // Variable for getting users input wheter to print
        int print;
        
        // Get tools list from game object
        ArrayList<ListItem> tools = game.getTools();
        
        // Print off header
        System.out.println("City of Aaron tool list");
        System.out.println("Here is a list of tools\n" +
                "------------------------------------");
        
        // Print off tools and quantities
        for (ListItem tool: tools) {
            System.out.println(tool.getName() + "\t" + tool.getNumber());
        }
        
        // Prompt to print report
        System.out.println("\nWould you like to save a copy to disk? " 
                + "\n 1 - Yes \n 2 - No");
        
        // Get user input
        print = keyboard.nextInt();
        
        // 1 = write to disk, 2 = return to menu, other = invalid & return to menu
        if (print == 1) {
            printToolsView();
        }
        else if (print == 2){}
        else {
            System.out.println("Invalid entry.");
        }
    }

    /**
     * Purpose: Display the list the provisions that the player has<p>
     * @Param none
     */
    public void listProvisions() {
        // get provisions list from game object
        ArrayList<ListItem> provisions = game.getProvisions();
        
        // list header
        System.out.println("City of Aaron Provisions List");
        System.out.println("Here is a list of provisions\n" +
                "---------------------------------------");
        
        // display provisions and quantities
        for (ListItem provision: provisions) {
            System.out.println(provision.getName() + "\t" + provision.getNumber());
        }
    }
    
    /**
     * Purpose: List the team members that created this application<p>
     * @Param none
     */
    public void listTeam() {
        System.out.println("Members of the development team:\n" +
                "-----------------------------------------------------------");
        for ( TeamMember teamMember : TeamMember.values() ) {
            System.out.println( (teamMember.ordinal()+1) + ".) " + teamMember.getName() +
                    "\tTitle: " + teamMember.getTitle());
        }
    }

    /**
     * printToolsView method
     * @author Nick
     * Purpose: print to file the tools array
     * @Param none
     * @Return none
     */
    public void printToolsView() {
        // declare a string to hold the file name
        String filename;

        // prompt the user for a file name, get and save the user’s input
        System.out.println("Enter file name.");
        
        // Clear keyboard
        keyboard.nextLine();
        // Get user input for file name
        filename = keyboard.next();
        
        // Send data to control layer
        GameControl.printTools(filename);
    }
}
