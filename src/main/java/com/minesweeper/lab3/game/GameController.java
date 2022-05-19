package com.minesweeper.lab3.game;

public class GameController {
    public GameController(GameService service, GameModel model) {
        this.service = service;
        this.model = model;
    }

    public void setStep(int x, int y){
        model.setStep(x, y);
    }

    public void setFlag(int x, int y){
        model.setFlag(x,y);
    }

    public void deleteFlag(int x, int y){
        model.deleteFlag(x, y);
    }

    public void closeGame(){
        model.endGame();
        service.exitToMainMenu();
    }

    private final GameService service;
    private final GameModel model;
}
