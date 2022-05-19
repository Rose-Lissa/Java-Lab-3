package com.minesweeper.lab3.consoleview.utility.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputToChangeName extends InputToAction{
    private Action action;
    public InputToChangeName(Action action) {
        super(Pattern.compile("\\s*name\\s+\\w+\\s*"));
        this.action = action;
    }

    public interface Action{
        void doAction(String string);
    }

    @Override
    void doAction(String input) {
        Matcher wordMatcher = word.matcher(input);
        wordMatcher.find();
        wordMatcher.group();
        wordMatcher.find();
        String name = wordMatcher.group();
        wordMatcher.find();
        action.doAction(name);
    }
}
