package com.minesweeper.lab3.db;

import java.io.Serializable;

public class Scores implements Serializable, Comparable<Scores> {
    private String userName;
    private long time;
    public Scores(String userName, long time){
        this.userName = userName;
        this.time = time;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public int compareTo(Scores o) {
        return time != o.time ? (int)(o.time - time) : userName.compareTo(o.userName);
    }
}
