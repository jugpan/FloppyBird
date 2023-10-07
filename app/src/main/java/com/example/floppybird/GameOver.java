package com.example.floppybird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    ImageView playAgain;
    TextView score, highScore;
    Button leave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_game_over);
        playAgain = findViewById(R.id.PlayAgain);
        score = findViewById(R.id.Score);
        highScore = findViewById(R.id.HighScore);
        leave = findViewById(R.id.Btn_Leave);

        int curScore = getIntent().getExtras().getInt("Score");
        SharedPreferences sharedPref = getSharedPreferences("Preference", 0);
        int scorePref = sharedPref.getInt("scorePref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        if(curScore > scorePref){
            scorePref = curScore;
            editor.putInt("scorePref", scorePref);
            editor.commit();
        }

        score.setText("" + curScore);
        highScore.setText("" + scorePref);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOver.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}