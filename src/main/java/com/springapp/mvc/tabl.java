package com.springapp.mvc;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Mary on 27.10.2016.
 */
@Service
public class tabl implements Player {
    public static final int boardSize = 3;
    public static final char X='X';
    public static final char O='O';
    public static final char empty=' ';
    public HashMap<String, char[][]> Players;
    private Random rnd = new Random(System.currentTimeMillis());

    public tabl() {
        Players = new HashMap<String, char[][]>();//TODO from file reading?
    }

    public void addPlayer(String nick) {
        Players.put(nick, null);
        newGame(nick);
    }

    public void newGame(String nick) {
        char[][] t = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                t[i][j] = empty;
            }
        }
        Players.put(nick, t);
    }

    public String ComputerStep(String Nick, char XorO) {
        char[][] playBoard = Players.get(Nick);
        String cellID = "eror";
        boolean possibleStep = false;
        do {
            int i = rnd.nextInt(boardSize);
            int j = rnd.nextInt(boardSize);
            char cell = playBoard[i][j];

            if (cell != X && cell != O) {
                if (XorO == X)
                    playBoard[i][j] = O;
                else if (XorO == O)
                    playBoard[i][j] = X;
                possibleStep = true;
                cellID = (i + 1) + "x" + (j + 1);
            }
        } while (!possibleStep);

        return cellID;
    }

    public boolean PlayerStep(String Nick, char XorO, String cellID) {
        boolean possibleStep=false;
        char[][] playBoard = Players.get(Nick);
        int i = Character.getNumericValue(cellID.charAt(0));
        //int i = cellID.charAt(0);
        int j = Character.getNumericValue(cellID.charAt(2));
        char curval = playBoard[i - 1][j - 1];
        if (curval == empty) {
            playBoard[i - 1][j - 1] = XorO;
            possibleStep=true;
        }
        return possibleStep;
        //TODO проверка на не пустую ячейку-> exception/
    }
    public char[][] GetBoard(String Nick){
        char[][] playBoard = Players.get(Nick);// TODO COOKIE
        if (playBoard == null) { // проверяет есть ли такой пользователь, если нет-добавляет
            newGame(Nick);
            playBoard = Players.get(Nick);
        }
      return playBoard;
    }
    public char Switch(char XorO){//TODO вынести логику в отдельный класс
        if (XorO == X) XorO = O;//switch to computer
        else if (XorO == O) XorO = X;
        return XorO;
    }


}

interface Player{
    /*
    public static final int boardSize = 3;
    public static final char X='X';
    public static final char O='O';
    public static final char empty=' ';
*/
    public void addPlayer(String nick);

    public void newGame(String nick);
    public String ComputerStep(String Nick, char XorO);

    public boolean PlayerStep(String Nick, char XorO, String cellID);
    public char[][] GetBoard(String Nick);
    //public int[][]
    public char Switch(char XorO);

}
