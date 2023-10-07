package com.example.floppybird;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppConstants.gameActivityContext = this;
        //setContentView(R.layout.activity_game);
        gameView = new GameView(this);
        setContentView(gameView);
    }
}