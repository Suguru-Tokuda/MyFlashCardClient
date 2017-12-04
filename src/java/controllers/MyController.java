/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import api.DeckStore;
import java.util.List;
import models.Deck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author it354f715
 */
@Controller
public class MyController {
    
    DeckStore deckStore = new DeckStore();
    List<Deck> deckList;
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String viewIndex(){
        
        deckList = deckStore.getAllDecks();
        
        if (deckList != null) {
            for (Deck deck : deckList) {
                System.out.println(deck.getDeckName());
            }
        }
        
        
        
        return "index";
    }
    
}
