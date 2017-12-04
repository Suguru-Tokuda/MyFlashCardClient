package api;

import org.json.*;
import models.Deck;

/**
 * This class processes a JSON String into object.
 * @author Suguru
 */
public class DeckStore {
    
    private Deck[] decks;
    private Deck tempDeck;
    private DecksAPI decksAPI = new DecksAPI();    
    
    public Deck[] getDecksByClassid(String classid) {
        
        String jsonString = decksAPI.getDecksForClassid(classid);
        
        
        
        
        
    }
    
    
    
}
