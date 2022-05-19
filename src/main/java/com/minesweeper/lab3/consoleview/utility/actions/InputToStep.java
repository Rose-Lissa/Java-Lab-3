package com.minesweeper.lab3.consoleview.utility.actions;

import com.minesweeper.lab3.game.GameController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputToStep extends InputToAction {
    private Action action;
    public InputToStep(Action action){
        super(Pattern.compile("\\s*\\d+\\s+\\d+\\s*"));
        this.action = action;
    }

    public interface Action{
        void doAction(int x, int y);
    }
    @Override
    public void doAction(String input) {
        Matcher wordMatcher = word.matcher(input);
        wordMatcher.find();
        int x = Integer.parseInt(wordMatcher.group());
        wordMatcher.find();
        int y = Integer.parseInt(wordMatcher.group());
        action.doAction(x, y);
    }
}
