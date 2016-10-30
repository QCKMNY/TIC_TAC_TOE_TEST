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
 * method getname create user if necessary and starts the game
 * method printWelcome open the user validation form
 */
@Controller
@RequestMapping(value="/")
public class ListenerController {
    @Autowired
    tabl tablica;//TODO bean tabl interface?


    @RequestMapping(value="/loading", method = RequestMethod.GET)
    public String getname(@RequestParam String Nick, ModelMap model) {
        char [][] tablica_play=tablica.Players.get(Nick);// TODO COOKIE
        if (tablica_play ==null){ // проверяет есть ли такой пользователь, если нет-добавляет
            tablica.addPlayer(Nick);
            tablica_play=tablica.Players.get(Nick);
        }
        model.addAttribute("board",tablica_play);
        model.addAttribute("Nick", Nick);
        return "tic_tac_toe";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome( ModelMap model) {
        //TODO check Cookie- else-> return"tic_tac_toe"
        return "login";
    }

  /*  @RequestMapping(method = RequestMethod.POST)
    public String enemyTurn(@RequestParam String field,@RequestParam char ticOrTac, ModelMap model){
        if (ticOrTac=='x'){

        }
        else if (ticOrTac=='o'){

        }
        else

        return "tic_tac_toe"; //TODO not new page?
    }
*/
    /*@RequestMapping(method = RequestMethod.GET)
    public String printWelcome(@CookieValue(value="tabl_tic_tac_toe", defaultValue =  {"dfs","dfs"}) String [] tabl, ModelMap model) {
        return "tic_tac_toe";
    }
    */
}
