package com.springapp.mvc;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mary on 24.10.2016.
 * method getname create user if necessary and starts the game
 * method printWelcome open the user validation form
 */
@Controller
@RequestMapping(value = "/")
public class ListenerController {
    @Autowired
    tabl tablica;//TODO bean tabl interface?


    @RequestMapping(value = "/loading", method = RequestMethod.GET)
    public String getName(@RequestParam String Nick, ModelMap model) {
        char[][] playBoard = tablica.Players.get(Nick);// TODO COOKIE
        if (playBoard == null) { // проверяет есть ли такой пользователь, если нет-добавляет
            tablica.addPlayer(Nick);
            playBoard = tablica.Players.get(Nick);
        }
        for (int i=0;i<tablica.boardSize;i++){
            for (int j=0;j<tablica.boardSize;j++){
                //if (playBoard[i][j] == null]){

                //}
            }
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


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String enemyTurn(@RequestParam String nick,@RequestParam String cell,@RequestParam char XorO, ModelMap model){
        JSONObject resultJson = new JSONObject();
        tablica.PlayerStep(nick,XorO,cell);
        String computerStepID=tablica.ComputerStep(nick,XorO);
        resultJson.put("ID",computerStepID);
        resultJson.put("XorO",XorO);
        return resultJson; //TODO not new page?
    }

    /*@RequestMapping(method = RequestMethod.GET)
    public String printWelcome(@CookieValue(value="tabl_tic_tac_toe", defaultValue =  {"dfs","dfs"}) String [] tabl, ModelMap model) {
        return "tic_tac_toe";
    }
    */
}
