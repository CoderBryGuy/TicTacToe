package com.example.hackeru.tictactoe;

/**
 * Created by Bryan on 5/22/2016.
 */
public class VictoryChecker {
    boolean[] isWinner = new boolean[3];
    boolean aWin = true;

    public boolean isWinner(GameGrid[] grid){
        if(grid.length < 3){return aWin = false;}

        //this whole algorithm needs to be rewritten
        for (int i = 0; i < grid.length; i++) {
            if (i+1 % 3 == 0){
                for (int j = 3; j > 0; j--) {
                    if(!(grid[i].getPlayer()==grid[(i+1)-j].getPlayer()))
                    {
                        aWin = false;
                    }

            }
        }
        }

   return aWin;
    }
}
