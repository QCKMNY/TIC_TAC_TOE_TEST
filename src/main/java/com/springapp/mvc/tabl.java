package com.springapp.mvc;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by Mary on 27.10.2016.
 */
@Service
public class tabl {

        public HashMap<String,char[][]> Players;

        public tabl(){
            Players=new HashMap<String, char[][]>();//TODO from file reading?
        }
        public void addPlayer(String player){
            char[][] t = new char[3][3];
            if (player.equals("Alex")) {
                for (int i=0;i<3; i++) {
                    for (int j=0; j<3;j++) {
                        t[i][j] = 'x';
                    }
                }
            }
            else {
                for (int i=0;i<3; i++) {
                    for (int j=0; j<3;j++) {
                        t[i][j] = ' ';
                    }
                }
            }
            Players.put(player,t);
        }



}
