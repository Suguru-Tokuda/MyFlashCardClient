/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Suguru
 */
public class Deck {
    
    private String id;    
    private String deckName;
    private String classid;
    private String userid;
   
    public Deck() {
    }
    
    public Deck(String id, String deckName, String classid) {
        this.id = id;
        this.deckName = deckName;
        this.classid = classid;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the deckName
     */
    public String getDeckName() {
        return deckName;
    }

    /**
     * @param deckName the deckName to set
     */
    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    /**
     * @return the classid
     */
    public String getClassid() {
        return classid;
    }

    /**
     * @param classid the classid to set
     */
    public void setClassid(String classid) {
        this.classid = classid;
    }

    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    
   
}
