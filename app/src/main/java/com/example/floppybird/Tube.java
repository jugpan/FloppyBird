package com.example.floppybird;

import java.util.Random;

public class Tube {

    private int tubeX, topTubeOffsetY;
    private Random random;

    private int tubeColor;

    public Tube(int tubeX, int offset){
        this.tubeX = tubeX;
        this.topTubeOffsetY = offset;
        random = new Random();
    }

    public void setTubeColor(){
        tubeColor = random.nextInt(2);
    }

    public int getTubeColor(){
        return tubeColor;
    }

    public int getTopTubeOffsetY() {
        return topTubeOffsetY;
    }

    public int getTubeX() {
        return tubeX;
    }

    public int getTopTubeY(){
        return topTubeOffsetY - AppConstants.getBitmapBank().getTubeHeight();
    }

    public int getBottomTubeY(){
        return topTubeOffsetY + AppConstants.tubeGap;
    }

    public void setTubeX(int tubeX) {
        this.tubeX = tubeX;
    }

    public void setTopTubeOffsetY(int topTubeOffsetY) {
        this.topTubeOffsetY = topTubeOffsetY;
    }
}
