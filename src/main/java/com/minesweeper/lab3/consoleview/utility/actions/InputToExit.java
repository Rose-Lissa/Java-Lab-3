package com.minesweeper.lab3.consoleview.utility.actions;

import com.minesweeper.lab3.game.GameController;

import java.util.regex.Pattern;

public class InputToExit extends InputToAction {
    private Action action;

    public InputToExit(Action action) {
        super(Pattern.compile("\\s*q\\s*"));
        this.action = action;
    }

    public interface Action{
        void doAction();
    }

    @Override
    public void doAction(String input) {
        action.doAction();
    }
}
