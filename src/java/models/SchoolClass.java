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
public class SchoolClass {
    
    private String id;
    private String classNum;
    private String name;
    
    public SchoolClass() {
    }

    public SchoolClass(String id, String classNum, String name) {
        this.id = id;
        this.classNum = classNum;
        this.name = name;
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
     * @return the classNum
     */
    public String getClassNum() {
        return classNum;
    }

    /**
     * @param classNum the classNum to set
     */
    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
}