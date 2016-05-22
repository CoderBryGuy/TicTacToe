package com.example.hackeru.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

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

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(356, 356);
        layoutParams.setMargins(0, 20,5, 180);

        for (int i = 0; i < 3; i++) {
            gameRow = new LinearLayout(this);
            gameRow.findViewWithTag(Integer.toString(i+1));


            for (int j = 0; j < 3; j++) {
                gamePiece =  new ImageView(this);

                gamePiece.setLayoutParams(layoutParams);
                gamePiece.setTag(j+i);
                gamePiece.setOnClickListener(this);

                gameRow.addView(gamePiece);
            }
            layout.addView(gameRow);
        }
    }

    @Override
    public void onClick(View v) {
        ImageView clickedImg = (ImageView)v;
        // selectedPiece.getTag();
        //clickedImg.setVisibility(View.INVISIBLE);


        if(is1stPlayerTurn == true){

            clickedImg.setImageResource(R.drawable.mario);
            clickedImg.setVisibility(View.VISIBLE);
            is1stPlayerTurn = false;
        }
        else if(is1stPlayerTurn == false){

            clickedImg.setImageResource(R.drawable.bowser);
            clickedImg.setVisibility(View.VISIBLE);
            is1stPlayerTurn = true;
        }
    }
}//class
