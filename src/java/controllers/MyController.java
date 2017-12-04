/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import api.CardAPI;
import api.CardStore;
import api.DeckAPI;
import api.DeckStore;
import api.SchoolClassAPI;
import api.SchoolClassStore;
import java.util.Iterator;
import java.util.List;
import models.Card;

import models.Deck;
import models.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author it354f715
 */
@Controller
public class MyController {
    
    @Autowired
    DeckStore deckStore;
    @Autowired
    CardStore cardStore;
    @Autowired
    SchoolClassStore schoolClassStore;
    @Autowired
    CardAPI cardAPI;
    @Autowired
    DeckAPI deckAPI;
    @Autowired
    SchoolClassAPI schoolClassAPI;
    List<Deck> deckList;
    List<Card> cardList;
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String viewIndex(Model model){
        
        deckList = deckStore.getAllDecks();
        
        model.addAttribute("deckList", deckList);
        
        return "index";
    }
    
    @RequestMapping(value="/viewDeckDetails/{id}", method=RequestMethod.GET)
    public String viewDeckDetails(@PathVariable("id") String deckid, Model model) {
        
        cardList = cardStore.getCardsByDeckid(deckid);
        Iterator<Deck> it = deckList.iterator();
        Deck tempDeck;
        String deckName = null;
        while(it.hasNext()) {
            tempDeck = it.next();
            if (tempDeck.getId().equals(deckid)) {
                deckName = tempDeck.getDeckname();
            }
        }        
        model.addAttribute("deckName", deckName);
        model.addAttribute("cardList", cardList);
        
        return "deckDetails";
    }
    
    @RequestMapping(value="/addDeck", method=RequestMethod.GET)
    public String viewAddDeckPage() {
        return "addDeck";
    }
    
    @RequestMapping(value="/addClass", method=RequestMethod.POST)
    public String postClass(@RequestParam("classname") String classname, @RequestParam("classnumber") String classnumber) {
        
        SchoolClass tempClass = new SchoolClass(classnumber, classname);
        if (schoolClassAPI.postClass(tempClass)) {
            return "somewhere";
        } else {
            return "somewhereelse";
        }
    }
    
}
