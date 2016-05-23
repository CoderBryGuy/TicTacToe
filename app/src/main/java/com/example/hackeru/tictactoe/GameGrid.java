package com.example.hackeru.tictactoe;

/**
 * Created by hackeru on 5/22/2016.
 */
public class GameGrid {
    boolean isUsed = false;
    int position;
    Player player;

    public GameGrid(boolean isUsed, int position, Player player) {
        this.isUsed = isUsed;
        this.position = position;
        this.player = player;
    }

    public GameGrid(int position) {
        this.position = position;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public int getPosition() {
        return position;
    }

    public Player getPlayer() {
        return player;
    }

    enum Player{
        MARIO, BOWSER
    }
}
