package com.minesweeper.lab3.game.observer;

import com.minesweeper.lab3.Observable;
import com.minesweeper.lab3.game.Cells;
import com.minesweeper.lab3.game.State;
import java.util.List;

public abstract class GameObservable extends Observable {
    abstract public List<Cells> getField();
    abstract public State getState();
    abstract public int getSizeX();
    abstract public int getSizeY();
    abstract public long getTimePassed();
}
