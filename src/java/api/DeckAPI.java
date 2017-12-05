/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import models.Deck;
import models.SchoolClass;

/**
 *
 * @author Suguru
 */
public class DeckAPI {
    
    private static String BASE_URL = "http://gfish3.it.ilstu.edu:8080/stokuda_fall2017_MyFlashCardWS/webresources/entities.decks/";
    
    public static String getBASE_URL() {
        return BASE_URL;
    }
    
    public boolean postDeck(Deck deck) {
        Client client = ClientBuilder.newClient();
        
        String response = client
                .target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN_TYPE)
                .post(Entity.json(deck), String.class);
        return true;
    }
    
    public boolean putDeck(Deck deck, String id) {
        Client client = ClientBuilder.newClient();
        String putURL = BASE_URL + id;
        String response = client
               .target(putURL)
               .request(MediaType.APPLICATION_JSON)
               .accept(MediaType.TEXT_PLAIN_TYPE)
                .put(Entity.json(deck), String.class);
        return true;
    }
    
    public boolean deleteDeck(String id) {
        Client client = ClientBuilder.newClient();
        String deleteURL = BASE_URL + id;
        String response = client
                .target(deleteURL)
                .request()
                .accept(MediaType.TEXT_PLAIN_TYPE)
                .delete(String.class);
        return true;  
    }
    
    public String getAllDecks() {
        Client client = ClientBuilder.newClient();
        String requestURL = BASE_URL;
        
        String response = client
                .target(requestURL)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        return response;
    }
    
    public String getDecksForClassid(String classid) {
        Client client = ClientBuilder.newClient();
        String requestURL = BASE_URL + "findByClassid/" + classid;
                String response = client
                .target(requestURL)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        return response;
    }

    
}
