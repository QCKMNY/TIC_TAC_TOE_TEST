package com.springapp.mvc;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.ToStringCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mary on 24.10.2016.
 * method getname create user if necessary and starts the game
 * method printWelcome open the user validation form
 */
@Controller(value = "/")
public class ListenerController {
    @Autowired
    tabl tablica;//TODO bean tabl interface?


    @RequestMapping(value = "/loading", method = RequestMethod.GET)
    public String getName(@RequestParam String Nick, ModelMap model) {
        char[][] playBoard = tablica.Players.get(Nick);// TODO COOKIE
        if (playBoard == null) { // проверяет есть ли такой пользователь, если нет-добавляет
            tablica.newGame(Nick);
            playBoard = tablica.Players.get(Nick);
        }
        model.addAttribute("board", playBoard);
        model.addAttribute("Nick", Nick);
        return "tic_tac_toe";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        //TODO check Cookie- else-> return"tic_tac_toe"
        return "login";
    }


    @RequestMapping(value = "/loading", method = RequestMethod.POST)
    public
    @ResponseBody
    String enemyTurn(@RequestParam String nick, @RequestParam(value = "field") String cell,
                     @RequestParam(value = "type") char XorO) {
        //@RequestParam String nick,@RequestParam String cell,@RequestParam char XorO,//  предыдущие перемменные
        JSONObject resultJson = new JSONObject();
        tablica.PlayerStep(nick, XorO, cell);
        String computerStepID = tablica.ComputerStep(nick, XorO);
        resultJson.put("ID", computerStepID);

        if (XorO == 'X')
            XorO = 'O';
        else if (XorO == 'O')
            XorO = 'X';

        String SXorO = "" + XorO;// для создания Json в формате поддерживаемом jQuery.parseJSON
        resultJson.put("compXorO", SXorO);
        return resultJson.toJSONString(); //TODO not new page?
    }

    @RequestMapping(value = "/loading/new", method = RequestMethod.POST)
    public
    @ResponseBody
    String newGame(@RequestParam String nick) {
        JSONObject resultJson = new JSONObject();
        tablica.newGame(nick);
        resultJson.put("response", "success");
        return resultJson.toJSONString(); //TODO not new page?
    }
    /*@RequestMapping(method = RequestMethod.GET)
    public String printWelcome(@CookieValue(value="tabl_tic_tac_toe", defaultValue =  {"dfs","dfs"}) String [] tabl, ModelMap model) {
        return "tic_tac_toe";
    }
    */
}
