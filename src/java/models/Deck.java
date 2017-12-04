/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Suguru
 */
public class Deck {
    
    private String id;    
    private String deckName;
    private String classid;
   
    public Deck() {
    }
    
    public Deck(String id, String deckName, String classid) {
        this.id = id;
        this.deckName = deckName;
        this.classid = classid;
    }
   
}
