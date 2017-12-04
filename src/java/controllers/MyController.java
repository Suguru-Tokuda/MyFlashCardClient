/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import api.DeckStore;
import java.util.List;
import javax.enterprise.inject.Model;
import models.Deck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
/**
 *
 * @author it354f715
 */
@Controller
public class MyController {
    
    DeckStore deckStore = new DeckStore();
    List<Deck> deckList;
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView viewIndex(){
        
        deckList = deckStore.getAllDecks();
        
        // return back to index.jsp
        ModelAndView model = new ModelAndView("index");
        model.addObject("deckList", deckList);
        return model;
    }
    
}
