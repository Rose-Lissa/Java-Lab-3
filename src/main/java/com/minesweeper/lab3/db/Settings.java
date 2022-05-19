package com.minesweeper.lab3.db;

import java.io.Serializable;

public class Settings implements Serializable {
    private String userName = "player";
    private int sizeX = 9;
    private int sizeY = 9;
    private int numBomb = 10;

    public Settings(){

    }

    public Settings(String userName, int sizeX, int sizeY, int numBomb) {
        this.userName = userName;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.numBomb = numBomb;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getNumBomb() {
        return numBomb;
    }

    public void setNumBomb(int numBomb) {
        this.numBomb = numBomb;
    }

}
