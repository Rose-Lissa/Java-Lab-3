package com.minesweeper.lab3.game.ConsoleView;

import com.minesweeper.lab3.consoleview.utility.ConsoleView;
import com.minesweeper.lab3.game.Cells;
import com.minesweeper.lab3.game.GameController;
import com.minesweeper.lab3.game.GameView;
import com.minesweeper.lab3.game.observer.GameObservable;

import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleGameView extends ConsoleView implements GameView{
    public ConsoleGameView(GameObservable observable, GameController controller) {
        this.observable = observable;
        this.observable.registerObserver(this);
        this.controller = controller;
        writer = new PrintWriter(System.out, true);
        reader = new Scanner(System.in);
    }

    private void readDataFromModel(){
        state = ConsoleGameViewState.changeState(observable.getState(), this);
        sizeX = observable.getSizeX();
        sizeY = observable.getSizeY();
        timePassed = observable.getTimePassed();
    }

    @Override
    synchronized public void update() {
        readDataFromModel();
        redraw();
    }

    synchronized public void draw(PrintWriter writer){
        state.drawUI(observable.getField(), writer);
    }

    synchronized public void read(Scanner reader) {
        state.readUserInput(reader);
    }


    protected int sizeX;
    protected int sizeY;
    protected long timePassed = 0;
    protected PrintWriter writer;
    protected Scanner reader;
    protected GameController controller;
    private final GameObservable observable;
    private ConsoleGameViewState state;
    boolean isShow = false;
    boolean hasUpdate = false;

    protected char cellsToChar(Cells cell) {
        return switch (cell) {
            case EMPTY -> '0';
            case ONE -> '1';
            case TWO -> '2';
            case THREE -> '3';
            case FOUR -> '4';
            case FIVE -> '5';
            case SIX ->  '6';
            case SEVEN -> '7';
            case EIGHT -> '8';
            case BOMB -> '*';
            case UNKNOWN -> '#';
            case FLAG -> '$';
        };
    }

    protected void drawUserCapabilities() {
        writer.println("Write: \"x y\" ,for open cell");
        writer.println("Write: \"f x y\", to place the flag ");
        writer.println("Write: \"df x y\", dell the flag ");
        writer.println("Write: \"q\", for exit");
    }
}
