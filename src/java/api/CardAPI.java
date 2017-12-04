package api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Card;

/**
 *
 * @author Suguru
 */
public class CardAPI {
    
    private static String BASE_URL = "http://gfish3.it.ilstu.edu:8080/stokuda_fall2017_MyFlashCardWS/webresources/entities.cards/";
    
    public static String getBASE_URL() {
        return BASE_URL;
    }
    
    public boolean postCard(Card card) {
        Client client = ClientBuilder.newClient();
        
        String response = client
                .target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN_TYPE)
                .post(Entity.json(card), String.class);
        return true;
    }
    
    public boolean putCard(Card card, String id) {
        Client client = ClientBuilder.newClient();
        String putURL = BASE_URL + id;
        String response = client
               .target(putURL)
               .request(MediaType.APPLICATION_JSON)
               .accept(MediaType.TEXT_PLAIN_TYPE)
                .put(Entity.json(card), String.class);
        return true;
    }
    
    public boolean deleteCard(String id) {
        Client client = ClientBuilder.newClient();
        String deleteURL = BASE_URL + id;
        String response = client
                .target(deleteURL)
                .request()
                .accept(MediaType.TEXT_PLAIN_TYPE)
                .delete(String.class);
        return true;  
    }
    
    public String getCardForDeckid(String deckid) {
        Client client = ClientBuilder.newClient();
        String requestURL = BASE_URL + "findByDeckid/" + deckid;
        
        String response = client
                .target(requestURL)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        return response;
    }
    
}
