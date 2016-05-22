package com.example.hackeru.tictactoe;

/**
 * Created by hackeru on 5/22/2016.
 */
public class GameGrid {
    boolean isUsed = false;
    int position;

    public GameGrid(boolean isUsed, int position) {
        this.isUsed = isUsed;
        this.position = position;
    }

    enum Player{
        MARIO, BOWSER
    }
}
