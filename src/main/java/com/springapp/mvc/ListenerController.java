package com.springapp.mvc;

import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mary on 24.10.2016.
 */
@Controller
@RequestMapping(value="/")
public class ListenerController {
    @Autowired
    tabl tablica;//TODO bean tabl; interface?
    //tabl Tablica TODO add var+ make bin

    @RequestMapping(value="/loading", method = RequestMethod.GET)
    public String getname(@RequestParam String Nick, ModelMap model) {
        char [][] tablica_play=tablica.Players.get(Nick);// TODO COOKIE
        if (tablica_play!=null){

        }
        else {
            tablica.addPlayer(Nick);
            tablica_play=tablica.Players.get(Nick);
        }
        model.addAttribute("board",tablica_play);
        model.addAttribute("Nick", Nick);
        return "tic_tac_toe";
    }
    /*public String getname(@RequestParam String name, ModelMap model) {
        String out= "Hello ";
        if (name!=null&&name.length()>0)
            out+=name+"!";
        else out+="world!";
        model.addAttribute("message", out);
        return "hello";
    }
    */
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome( ModelMap model) {
        return "login";
    }
    /*@RequestMapping(method = RequestMethod.GET)
    public String printWelcome(@CookieValue(value="tabl_tic_tac_toe", defaultValue =  {"dfs","dfs"}) String [] tabl, ModelMap model) {
        return "tic_tac_toe";
    }
    */
    @RequestMapping(value="/loading", method = RequestMethod.POST)
    public String printWelcome(@RequestParam char ticOrTac,@RequestParam String position, ModelMap model) {//TODO ticortac in tabl; disable param checkbox
        //model.addAttribute("message", );--????
        return "login";
    }

}
