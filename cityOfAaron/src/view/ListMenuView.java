/*
 * ListMenuView.java
 *
 * The ListMenuView Class for the cityOfAaron project
 * Created in the view package.
 * 
 * Created on Nov 5, 2018, 9:55:27 PM
 * Created by artieman1
 *
 * CIT-260: 08
 * Fall 2018
 * Team members: Shane Artman, Nick Hammond, Jonathan Unga
 *
 * Purpose: Class to view the lists of items, Animals, tools, Provisions, Team
 */

package view;
import cityofaaron.CityOfAaron;
import model.*;


public class ListMenuView extends MenuView {
        
    private Game game = CityOfAaron.getGame();
    public ListMenuView () {
    super(  "\n" +
            "*********************************\n" +
            "** CITY OF AARON: IN-LIST MENU **\n" +
            "*********************************\n" +
            " 1 - List the animals in the storehouse\n" +
            " 2 - List the tools in the storehouse\n" +
            " 3 - List the provisions in the storehouse\n" +
            " 4 - List the Developers\n" +
            " 5 - Return to the Main menu\n",5);
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
        System.out.println("Display a list of animals here");
    }
    
    /**
     * Purpose: Display the list of tools that the player has<p>
     * @Param none
     */
    public void listTools() {
        System.out.println("Display a list of tools here");
    }

    /**
     * Purpose: Display the list the provisions that the player has<p>
     * @Param none
     */
    public void listProvisions() {
        System.out.println("Display a list of provisions here");
    }
    
    /**
     * Purpose: List the team members that created this application<p>
     * @Param none
     */
    public void listTeam() {
        System.out.println("Display the team members here");
    }

}
