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
public class SchoolClass implements Comparable<SchoolClass> {
    
    private String id;
    private String classnumber;
    private String classname;
    
    public SchoolClass() {
    }
    
    public SchoolClass(String classnumber, String classname) {
        this.classnumber = classnumber;
        this.classname = classname;
    }

    public SchoolClass(String id, String classnumber, String classname) {
        this.id = id;
        this.classnumber = classnumber;
        this.classname = classname;
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
    public String getClassnumber() {
        return classnumber;
    }

    /**
     * @param classNum the classNum to set
     */
    public void setClassnumber(String classnumber) {
        this.classnumber = classnumber;
    }

    /**
     * @return the name
     */
    public String getClassname() {
        return classname;
    }

    /**
     * @param name the name to set
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public int compareTo(SchoolClass o) {        
        if (this.classnumber.compareTo(o.getClassnumber()) > 0) {
            return -1;
        } else if (this.classnumber.compareTo(o.getClassnumber()) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    
    
    
    
}
