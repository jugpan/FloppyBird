package com.example.floppybird;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView playBtn;
    Button aboutMenu;
    Button leaveMenu;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppConstants.initialization(this.getApplicationContext());

        playBtn = findViewById(R.id.playBtn);
        aboutMenu = findViewById(R.id.AboutMenu);
        leaveMenu = findViewById(R.id.LeaveMenu);

        dialog = new Dialog(MainActivity.this);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Toast.makeText(MainActivity.this, "Play!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });

        aboutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AboutMenu();
            }
        });

        leaveMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

    }

    private void AboutMenu(){
        Button close;
        dialog.setContentView(R.layout.aboutscreen);
        close = dialog.findViewById(R.id.Close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void onBackPressed() {

    }
}