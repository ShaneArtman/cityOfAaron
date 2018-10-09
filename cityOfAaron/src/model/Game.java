/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nrham
 */
public class Game {
    
    private Player thePlayer;
    
    public Game () {
}

    public void setPlayer(Player _thePlayer){
        this.thePlayer = _thePlayer;
    }
    
    public Player getPlayer(){
        return thePlayer;
    }
}
