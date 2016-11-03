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
        public static final int boardSize=3;
        public HashMap<String,char[][]> Players;
        private Random rnd = new Random(System.currentTimeMillis());
        public tabl(){
            Players=new HashMap<String, char[][]>();//TODO from file reading?
        }
        public void addPlayer(String player){
            char[][] t = new char[boardSize][boardSize];
            if (player.equals("Alex")) {
                for (int i=0;i<boardSize; i++) {
                    for (int j=0; j<boardSize;j++) {
                        t[i][j] = 'X';
                    }
                }
            }
            else {
                for (int i=0;i<boardSize; i++) {
                    for (int j=0; j<boardSize;j++) {
                        t[i][j] = ' ';
                    }
                }
            }
            Players.put(player,t);
        }
        public String ComputerStep(String Nick, char XorO){
            char[][] playBoard = Players.get(Nick);
            String cellID="eror";
            boolean possibleStep=false;
            do {
                int i = rnd.nextInt(boardSize);
                int j = rnd.nextInt(boardSize);
                int cell = playBoard[i][j];
                if (!(cell == 'X') && !(cell == 'O')){  //if cell in gameboard empty do:
                    possibleStep=true;
                    cellID=i+"x"+j;
                }
            }   while (!possibleStep);

            return cellID;
        }
    public void PlayerStep(String Nick, char XorO,String cellID){
        char[][] playBoard = Players.get(Nick);
        int i = cellID.charAt(0);
        int j = cellID.charAt(2);
        playBoard[i][j]=XorO;//TODO проверка на не пустую ячейку-> exception/
    }


}
