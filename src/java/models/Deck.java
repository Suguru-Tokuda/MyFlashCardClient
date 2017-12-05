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
    private String deckname;
    private String classid;
    private String userid;
   
    public Deck() {
    }
    
    public Deck(String deckname, String classid, String userid) {
        this.deckname = deckname;
        this.classid = classid;
        this.userid = userid;
    }
    
    public Deck(String id, String deckname, String classid, String userid) {
        this.id = id;
        this.deckname = deckname;
        this.classid = classid;
        this.userid = userid;
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
    public String getDeckname() {
        return deckname;
    }

    /**
     * @param deckname the deckName to set
     */
    public void setDeckname(String deckname) {
        this.deckname = deckname;
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
