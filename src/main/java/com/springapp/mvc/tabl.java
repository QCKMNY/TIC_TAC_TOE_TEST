package com.springapp.mvc;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Mary on 27.10.2016.
 */
@Service
public class tabl {
    public static final int boardSize = 3;
    public HashMap<String, char[][]> Players;
    private Random rnd = new Random(System.currentTimeMillis());

    public tabl() {
        Players = new HashMap<String, char[][]>();//TODO from file reading?
    }

    public void addPlayer(String player) {
        char[][] t = new char[boardSize][boardSize];
        if (player.equals("Alex")) {
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    if (j == 0) t[i][j] = 'X';
                    else t[i][j] = ' ';
                }
            }
        } else {
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    t[i][j] = ' ';
                }
            }
        }
        Players.put(player, t);
    }

    public String ComputerStep(String Nick, char XorO) {
        char[][] playBoard = Players.get(Nick);
        String cellID = "eror";
        boolean possibleStep = false;
        do {
            int i = rnd.nextInt(boardSize);
            int j = rnd.nextInt(boardSize);
            char cell = playBoard[i][j];

            if (cell != 'X' && cell != 'O') {
                if (XorO == 'X')
                    playBoard[i][j] = 'O';
                else if (XorO == 'O')
                    playBoard[i][j] = 'X';
                possibleStep = true;
                cellID = i + "x" + j;
            }
        } while (!possibleStep);

        return cellID;
    }

    public void PlayerStep(String Nick, char XorO, String cellID) {
        char[][] playBoard = Players.get(Nick);
        int i = Character.getNumericValue(cellID.charAt(0));
        //int i = cellID.charAt(0);
        int j = Character.getNumericValue(cellID.charAt(2));
        char curval = playBoard[i - 1][j - 1];
        if (curval == ' ') {
            playBoard[i - 1][j - 1] = XorO;
        }
        //TODO проверка на не пустую ячейку-> exception/
    }


}
