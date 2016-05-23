package com.example.hackeru.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView gamePiece;
    LinearLayout gameRow, layout, mainLayout;
    Boolean is1stPlayerTurn = true;
    GameGrid[] gameGrid = new GameGrid[9];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout)findViewById(R.id.mainLayout);
        //gameBoard = (ImageView)findViewById(R.id.board);
        populateBoard();
    }

    void populateBoard() {
        int counter = 1;

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(256, 256);
        layoutParams.setMargins(0, 20,5, 100);

        for (int i = 0; i < 3; i++) {
            gameRow = new LinearLayout(this);
            gameRow.findViewWithTag(Integer.toString(i+1));


            for (int j = 0; j < 3; j++) {

                TextView textView = new TextView(this);
                textView.setText(Integer.toString(counter));
                gameRow.addView(textView);

                gamePiece =  new ImageView(this);
                gamePiece.setLayoutParams(layoutParams);
                gamePiece.setTag(counter++);
                gamePiece.setOnClickListener(this);

                gameRow.addView(gamePiece);
            }
            layout.addView(gameRow);
        }
    }

    @Override
    public void onClick(View v) {
        ImageView clickedImg = (ImageView)v;
        int tag = (int)clickedImg.getTag();
        //Toast.makeText(this, Integer.toString( tag), Toast.LENGTH_SHORT).show();

        if(gameGrid[tag-1]!= null){
            Toast.makeText(this, "You already clicked this box", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            if (is1stPlayerTurn == true) {
                gameGrid[tag-1] = new GameGrid(true, tag, GameGrid.Player.MARIO);
                clickedImg.setImageResource(R.drawable.mario);
                clickedImg.setVisibility(View.VISIBLE);
                is1stPlayerTurn = false;
                Toast.makeText(this, "Mario", Toast.LENGTH_SHORT).show();
            }
            else if (is1stPlayerTurn == false){
                gameGrid[tag-1] = new GameGrid(true, tag, GameGrid.Player.BOWSER);
                clickedImg.setImageResource(R.drawable.bowser);
                clickedImg.setVisibility(View.VISIBLE);
                is1stPlayerTurn = true;
                Toast.makeText(this, "Bowser", Toast.LENGTH_SHORT).show();
            }
        }
    }
}//class
