/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.util.ArrayList;
import java.util.List;
import models.SchoolClass;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 * This class processes JSON String into SchoolClass objects
 * @author Suguru
 */
public class SchoolClassStore {
    
    private List<SchoolClass> tempSchoolClassList;
    private SchoolClass tempSchoolClass;
    private SchoolClassAPI schoolClassAPI = new SchoolClassAPI();
    
    ObjectMapper mapper = new ObjectMapper();
    JSONParser jParser = new JSONParser();
    JSONObject jsonObject;
    String jsonString;
    JSONArray jsonArray;
    
    public List<SchoolClass> getAllSchoolClasses() {
        jsonString = schoolClassAPI.getAllClasses();

        mapper = new ObjectMapper();
        tempSchoolClass = null;
        tempSchoolClassList = new ArrayList<>();
        try {
            jsonArray = (JSONArray) jParser.parse(jsonString);
            for (int i = 0; i < jsonArray.size(); i++) {
                tempSchoolClass = mapper.readValue(jsonArray.get(i).toString(), SchoolClass.class);
                tempSchoolClassList.add(tempSchoolClass);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return tempSchoolClassList;
    }
    
}
