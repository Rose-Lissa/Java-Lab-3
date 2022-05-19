package com.minesweeper.lab3.settings;

import com.minesweeper.lab3.consoleview.utility.ConsoleView;
import com.minesweeper.lab3.consoleview.utility.actions.ActionsExecutor;
import com.minesweeper.lab3.consoleview.utility.actions.InputToChangeName;
import com.minesweeper.lab3.consoleview.utility.actions.InputToChangeSettings;
import com.minesweeper.lab3.consoleview.utility.actions.InputToExit;
import com.minesweeper.lab3.db.Settings;
import com.minesweeper.lab3.settings.observer.SettingsObservable;

import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleSettingsView extends ConsoleView implements SettingsView {
    private final SettingsObservable observable;
    private ActionsExecutor executor;
    private Settings settings;
    private final SettingsController controller;

    public ConsoleSettingsView(SettingsObservable observable, SettingsController controller){
        observable.registerObserver(this);
        this.observable = observable;
        this.controller = controller;
        executor = new ActionsExecutor.Builder()
                .addAction(new InputToChangeSettings((sizeX, sizeY, numBomb) -> {
                    settings.setSizeX(sizeX);
                    settings.setSizeY(sizeY);
                    settings.setNumBomb(numBomb);
                    controller.updateSettings(settings);
                }))
                .addAction(new InputToChangeName((name) -> {
                    settings.setUserName(name);
                    controller.updateSettings(settings);
                }))
                .addAction(new InputToExit(controller::goToMainMenu))
                .build();
    }

    @Override
    public synchronized void draw(PrintWriter writer) {
        writer.println("Your name: " + settings.getUserName());
        writer.println("Field size: " + settings.getSizeX() + " x "
                + settings.getSizeY() + ", number bomb: " + settings.getNumBomb());
        writer.println("Will change settings or quit: ");
    }

    @Override
    public synchronized void read(Scanner reader) {
        String userInput;
        do{
            userInput = reader.nextLine();
        }while (!executor.parseUserInput(userInput));
    }

    @Override
    public void update() {
        this.settings = observable.getSettings();
        redraw();
    }
}
