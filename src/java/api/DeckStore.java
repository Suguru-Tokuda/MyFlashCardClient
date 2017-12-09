package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Deck;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

/**
 * This class processes a JSON String into object.
 *
 * @author Suguru
 */
public class DeckStore {

    private List<Deck> tempDeckList;
    private Deck tempDeck;
    private DeckAPI decksAPI = new DeckAPI();

    ObjectMapper mapper = new ObjectMapper();
    JSONParser jParser = new JSONParser();
    JSONObject jsonObject;
    String jsonString;
    JSONArray jsonArray;

    public List<Deck> getDecksByClassid(String classid) throws IOException, ParseException {

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
            JSONObject jsonObject = (JSONObject) jParser.parse(jsonString);
            System.out.println(jsonObject);
            tempDeck = mapper.readValue(jsonObject.toString(), Deck.class);
            tempDeckList.add(tempDeck);
        }
        return tempDeckList;
    }

    public List<Deck> getDeckByUseridAndClassidAndDeckname(String userid, String classid, String deckname) throws IOException, ParseException {

        jsonString = decksAPI.getDeckByUseridAndClassidAndDeckname(tempDeck.getUserid(), tempDeck.getClassid(), tempDeck.getDeckname());

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
            JSONObject jsonObject = (JSONObject) jParser.parse(jsonString);
            System.out.println(jsonObject);
            tempDeck = mapper.readValue(jsonObject.toString(), Deck.class);
            tempDeckList.add(tempDeck);
        }
        return tempDeckList;
    }

    public List<Deck> getAllDecks() throws IOException, ParseException {

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
            JSONObject jsonObject = (JSONObject) jParser.parse(jsonString);
            System.out.println(jsonObject);
            tempDeck = mapper.readValue(jsonObject.toString(), Deck.class);
            tempDeckList.add(tempDeck);
        }

        return tempDeckList;
    }

    public List<Deck> getDecksByKeyword(String keyword) throws IOException, ParseException {
        jsonString = decksAPI.getDecksByKeyword(keyword);

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
            JSONObject jsonObject = (JSONObject) jParser.parse(jsonString);
            System.out.println(jsonObject);
            tempDeck = mapper.readValue(jsonObject.toString(), Deck.class);
            tempDeckList.add(tempDeck);
        }

        return tempDeckList;
    }

    public List<Deck> getDecksByUsername(String username) throws IOException, ParseException {
        jsonString = decksAPI.getDecksByUsername(username);

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
            JSONObject jsonObject = (JSONObject) jParser.parse(jsonString);
            System.out.println(jsonObject);
            tempDeck = mapper.readValue(jsonObject.toString(), Deck.class);
            tempDeckList.add(tempDeck);
        }

        return tempDeckList;
    }

}
