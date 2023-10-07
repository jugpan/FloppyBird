package com.example.floppybird;

public class BackgroundImage {

    private int backgroundX, backgroundY, backgroundVelocity;

    public BackgroundImage(){
        backgroundX = 0;
        backgroundY = 0;
        backgroundVelocity = 3;
    }

    public int getBackgroundX() {
        return backgroundX;
    }

    public int getBackgroundY() {
        return backgroundY;
    }

    public void setBackgroundX(int backgroundX) {
        this.backgroundX = backgroundX;
    }

    public void setBackgroundY(int backgroundY) {
        this.backgroundY = backgroundY;
    }

    public int getBackgroundVelocity() {
        return backgroundVelocity;
    }

    public void setBackgroundVelocity(int backgroundVelocity) {
        this.backgroundVelocity = backgroundVelocity;
    }
}
