package com.minesweeper.lab3.mainmenu;

import com.minesweeper.lab3.consoleview.utility.ConsoleView;
import com.minesweeper.lab3.mainmenu.observer.MainMenuObservable;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ConsoleMainMenuView extends ConsoleView implements MainMenuView {
    private final MainMenuObservable observable;
    private final MainMenuController controller;
    private List<MenuOptions> options;

    public ConsoleMainMenuView(MainMenuObservable observable, MainMenuController controller){
        this.controller = controller;
        this.observable = observable;
        observable.registerObserver(this);
    }

    @Override
    synchronized public void draw(PrintWriter writer){
        showMenu();
    }

    @Override
    synchronized public void read(Scanner reader){
        handleInput();
    }

    private void showMenu(){
        writer.println("\t\tMinesweeper\t\t");
        for(int i = 0; i < options.size(); i++){
            writer.println((i+1) + ". " + MenuOptions.menuOptionsToString(options.get(i)));
        }
    }

    private void handleInput(){
        int numOption;
        do {
            writer.println("Choose 1-" + options.size() + ": ");
            numOption = reader.nextInt();
        } while (numOption <= 0 || numOption > options.size());
        controller.goTo(options.get(numOption - 1));
    }

    @Override
    public void update() {
        options = observable.getOptions();
        redraw();
    }
}
