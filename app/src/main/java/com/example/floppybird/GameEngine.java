package com.example.floppybird;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    BackgroundImage backgroundImage;
    Bird bird;

    static int gameState;

    ArrayList<Tube> tubes;
    Random random;

    int score;
    int scoringTube;

    Paint scorePaint;

    public GameEngine(){

        backgroundImage = new BackgroundImage();
        bird = new Bird();
        //0 = Not started
        //1 = Playing
        //2 = GameOver
        gameState = 0;
        tubes = new ArrayList<>();
        random = new Random();
        for(int i = 0; i < AppConstants.numberOfTubes;i++){
            int tubeX = AppConstants.SCREEN_WIDTH + i * AppConstants.distanceBetweenTubes;
            int offset = AppConstants.minTubeOffsetY + random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY);
            Tube tube = new Tube(tubeX, offset);
            tubes.add(tube);
        }
        score = 0;
        scoringTube = 0;

        scorePaint = new Paint();
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(80);
        scorePaint.setTextAlign(Paint.Align.LEFT);
    }

    public void updateAndDrawTubes(Canvas canvas){
        if(gameState == 1){

            if((tubes.get(scoringTube).getTubeX() < bird.getBirdX() + AppConstants.getBitmapBank().getBirdHeight()) && (tubes.get(scoringTube).getTopTubeOffsetY() > bird.getBirdY() ||
                    tubes.get(scoringTube).getBottomTubeY() < (bird.getBirdY() + AppConstants.getBitmapBank().getBirdHeight()))){
                gameState = 2;
                //Log.d("Player", "Done");
                AppConstants.getSoundBank().playHit();
                Context context = AppConstants.gameActivityContext;
                Intent intent = new Intent(context, GameOver.class);
                intent.putExtra("Score", score);
                context.startActivity(intent);
                ((Activity) context).finish();
            }
            else if(tubes.get(scoringTube).getTubeX() < bird.getBirdX() - AppConstants.getBitmapBank().getTubeWidth()){
                score++;
                scoringTube++;
                if(scoringTube > AppConstants.numberOfTubes - 1){
                    scoringTube = 0;
                }
                AppConstants.getSoundBank().playPoint();
            }


            for(int i = 0; i < AppConstants.numberOfTubes; i++){
                if(tubes.get(i).getTubeX() <- AppConstants.getBitmapBank().getTubeWidth()){
                    tubes.get(i).setTubeX(tubes.get(i).getTubeX() + AppConstants.numberOfTubes * AppConstants.distanceBetweenTubes);
                    int topTubeOffsetY = AppConstants.minTubeOffsetY + random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
                    tubes.get(i).setTopTubeOffsetY(topTubeOffsetY);
                    tubes.get(i).setTubeColor();
                }
                tubes.get(i).setTubeX(tubes.get(i).getTubeX() - AppConstants.tubeVelocity);
                if(tubes.get(i).getTubeColor() == 0) {
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop(), tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom(), tubes.get(i).getTubeX(), tubes.get(i).getBottomTubeY(), null);
                }
                else{
                    canvas.drawBitmap(AppConstants.getBitmapBank().getRedTubeTop(), tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getRedTubeBottom(), tubes.get(i).getTubeX(), tubes.get(i).getBottomTubeY(), null);
                }
            }
            canvas.drawText(String.valueOf(score), 20, 110, scorePaint);
        }
    }

    public void updateAndDrawBackgroundImage(Canvas canvas){
        backgroundImage.setBackgroundX(backgroundImage.getBackgroundX() - backgroundImage.getBackgroundVelocity());
        if(backgroundImage.getBackgroundX() <- AppConstants.getBitmapBank().getBackgroundWidth()){
            backgroundImage.setBackgroundX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getBackgroundX(), backgroundImage.getBackgroundY(), null);

        if(backgroundImage.getBackgroundX() <- (AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)){
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getBackgroundX() + AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getBackgroundY(), null);
        }
    }

    public void updateAndDrawBird(Canvas canvas){
        if(gameState == 1){
            if(bird.getBirdY() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBirdHeight()) || bird.getVelocity() < 0) {
                bird.setVelocity(bird.getVelocity() + AppConstants.gravity);
                bird.setBirdY(bird.getBirdY() + bird.getVelocity());
            }
        }

        int currentFrame = bird.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapBank().getBird(currentFrame), bird.getBirdX(), bird.getBirdY(), null);
        currentFrame++;
        if(currentFrame > bird.maxFrame){
            currentFrame = 0;
        }
        bird.setCurrentFrame(currentFrame);
    }
}
