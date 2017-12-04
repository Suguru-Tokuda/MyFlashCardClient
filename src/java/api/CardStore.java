/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.util.ArrayList;
import java.util.List;
import models.Card;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 * This class process JSON String into objects.
 *
 * @author Suguru
 */
public class CardStore {

    private List<Card> tempCardList;
    private Card tempCard;
    private CardAPI cardAPI = new CardAPI();

    ObjectMapper mapper = new ObjectMapper();
    JSONParser jParser = new JSONParser();
    JSONObject jsonObject;
    String jsonString;
    JSONArray jsonArray;

    public List<Card> getCardsByDeckid(String deckid) {

        jsonString = cardAPI.getCardByDeckid(deckid);

        mapper = new ObjectMapper();
        tempCard = null;
        tempCardList = new ArrayList<>();
        try {
            jsonArray = (JSONArray) jParser.parse(jsonString);
            for (int i = 0; i < jsonArray.size(); i++) {
                tempCard = mapper.readValue(jsonArray.get(i).toString(), Card.class);
                tempCardList.add(tempCard);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return tempCardList;
    }

}
