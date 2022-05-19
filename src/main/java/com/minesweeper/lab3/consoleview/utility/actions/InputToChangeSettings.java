package com.minesweeper.lab3.consoleview.utility.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputToChangeSettings extends InputToAction{
    private Action action;
    public InputToChangeSettings(Action action) {
        super(Pattern.compile("\\s*field\\s+\\d+\\s+\\d+\\s+\\d+\\s*"));
        this.action = action;
    }

    public interface Action{
        void doAction(int sizeX, int sizeY, int numBomb);
    }

    @Override
    void doAction(String input) {
        Matcher wordMatcher = word.matcher(input);
        wordMatcher.find();
        wordMatcher.group();
        wordMatcher.find();
        int sizeX = Integer.parseInt(wordMatcher.group());
        wordMatcher.find();
        int sizeY = Integer.parseInt(wordMatcher.group());
        wordMatcher.find();
        int numBomb = Integer.parseInt(wordMatcher.group());
        action.doAction(sizeX, sizeY, numBomb);
    }
}
