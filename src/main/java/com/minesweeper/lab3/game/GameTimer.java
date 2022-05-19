package com.minesweeper.lab3.game;

import com.minesweeper.lab3.game.GameModel;

import java.util.Date;

public class GameTimer implements Runnable{
    GameModel model;
    boolean isCountTime;
    Date startTime;

    public GameTimer(GameModel model){
        this.model = model;
        isCountTime = true;
    }
    @Override
    public void run() {
        System.out.println("Time thread start: " + Thread.currentThread().getName());
        startTime = new Date();
        while (isCountTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            model.setTimePassed(new Date().getTime() - startTime.getTime());
        }
        System.out.println(Thread.currentThread().getName() + " Time thread end");
    }

    public void stop(){
        isCountTime = false;
    }
}
