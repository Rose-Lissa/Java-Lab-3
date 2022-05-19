package com.minesweeper.lab3.consoleview.utility.actions;

import java.util.ArrayList;
import java.util.List;

public class ActionsExecutor {
    private final List<InputToAction> actions;

    private ActionsExecutor(List<InputToAction> actions){
        this.actions = actions;
    }

    public boolean parseUserInput(String userInput){
        for(InputToAction action : actions){
            if(action.isValidInput(userInput)) {
                action.doAction(userInput);
                return true;
            }
        }
        return false;
    }

    public static class Builder{
        private List<InputToAction> actions;
        public Builder(){
            actions = new ArrayList<>();
        }

        public Builder addAction(InputToAction action){
            actions.add(action);
            return this;
        }

        public ActionsExecutor build(){
            return new ActionsExecutor(actions);
        }
    }
}
