package com.example.floppybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap backgroundPic;

    Bitmap[] bird;

    Bitmap tubeTop, tubeBottom;
    Bitmap redTubeTop, redTubeBottom;

    public BitmapBank(Resources resources){
        backgroundPic = BitmapFactory.decodeResource(resources, R.drawable.background_game);
        backgroundPic = scaleImage(backgroundPic);
        bird = new Bitmap[4];
        bird[0] = BitmapFactory.decodeResource(resources, R.drawable.bird_frame1);
        bird[1] = BitmapFactory.decodeResource(resources, R.drawable.bird_frame2);
        bird[2] = BitmapFactory.decodeResource(resources, R.drawable.bird_frame3);
        bird[3] = BitmapFactory.decodeResource(resources, R.drawable.bird_frame4);

        tubeTop = BitmapFactory.decodeResource(resources, R.drawable.tube_top);
        tubeBottom = BitmapFactory.decodeResource(resources, R.drawable.tube_bottom);
        redTubeTop = BitmapFactory.decodeResource(resources, R.drawable.red_tube_top);
        redTubeBottom = BitmapFactory.decodeResource(resources, R.drawable.red_tube_bottom);

    }

    public Bitmap getRedTubeTop() {
        return redTubeTop;
    }

    public Bitmap getRedTubeBottom() {
        return redTubeBottom;
    }

    public Bitmap getTubeTop() {
        return tubeTop;
    }

    public Bitmap getTubeBottom() {
        return tubeBottom;
    }

    public int getTubeWidth(){
        return tubeTop.getWidth();
    }

    public int getTubeHeight(){
        return tubeTop.getHeight();
    }

    public Bitmap getBird(int frame){
        return bird[frame];
    }

    public int getBirdWidth(){
        return bird[0].getWidth();
    }

    public int getBirdHeight(){
        return bird[0].getHeight();
    }

    public Bitmap getBackground(){
        return backgroundPic;
    }

    public int getBackgroundWidth(){
        return backgroundPic.getWidth();
    }

    public int getBackgroundHeight(){
        return backgroundPic.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float ratioWH = getBackgroundWidth() / getBackgroundHeight();
        int backgroundsScaleWidth = (int) ratioWH * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundsScaleWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
