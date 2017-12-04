package api;

import java.util.ArrayList;
import java.util.List;
import models.Deck;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 * This class processes a JSON String into object.
 *
 * @author Suguru
 */
public class DeckStore {

    private List<Deck> tempDeckList;
    private Deck tempDeck;
    private DecksAPI decksAPI = new DecksAPI();

    ObjectMapper mapper = new ObjectMapper();
    JSONParser jParser = new JSONParser();
    JSONObject jsonObject;
    String jsonString;
    JSONArray jsonArray;

    public List<Deck> getDecksByClassid(String classid) {

        jsonString = decksAPI.getDecksForClassid(classid);

        mapper = new ObjectMapper();
        tempDeck = null;
        tempDeckList = new ArrayList<>();
        try {
            jsonArray = (JSONArray) jParser.parse(jsonString);
            for (int i = 0; i < jsonArray.size(); i++) {
                tempDeck = mapper.readValue(jsonArray.get(i).toString(), Deck.class);
                tempDeckList.add(tempDeck);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return tempDeckList;
    }
    
    public List<Deck> getAllDecks() {
        
        jsonString = decksAPI.getAllDecks();

        mapper = new ObjectMapper();
        tempDeck = null;
        tempDeckList = new ArrayList<>();
        try {
            jsonArray = (JSONArray) jParser.parse(jsonString);
            for (int i = 0; i < jsonArray.size(); i++) {
                tempDeck = mapper.readValue(jsonArray.get(i).toString(), Deck.class);
                tempDeckList.add(tempDeck);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return tempDeckList;
    }

}
