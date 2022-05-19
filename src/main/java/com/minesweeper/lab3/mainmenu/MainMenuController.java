package com.minesweeper.lab3.mainmenu;

public class MainMenuController {
    public MainMenuController(MainMenuService service, MainMenuModel model) {
        this.service = service;
        this.model = model;
    }

    public void goTo(MenuOptions option){
        service.goTo(option);
    }

    private final MainMenuService service;
    private final MainMenuModel model;
}
