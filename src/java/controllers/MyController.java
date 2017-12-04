/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author it354f715
 */
@Controller
public class MyController {
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String viewIndex(){
        return "index";
    }
    
}
