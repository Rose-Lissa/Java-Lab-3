package com.minesweeper.lab3;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    public Observable(){
    listeners = new ArrayList<>();
}

    public void registerObserver(Observer listener){
        listeners.add(listener);
    }

    public void removeObserver(Observer listener){
        listeners.remove(listener);
    }

    public void notifyObservers(){
        for (Observer listener: listeners) {
            listener.update();
        }
    }

    private final List<Observer> listeners;
}
