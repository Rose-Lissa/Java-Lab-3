package com.minesweeper.lab3.consoleview.utility.actions;

import com.minesweeper.lab3.game.GameController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class InputToAction {
    InputToAction(Pattern pattern){
        this.pattern = pattern;
    }

    public boolean isValidInput(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    abstract void doAction(String input);

    protected final Pattern pattern;
    protected final Pattern word = Pattern.compile("\\w+");
}


