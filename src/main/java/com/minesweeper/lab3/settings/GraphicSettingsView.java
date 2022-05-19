package com.minesweeper.lab3.settings;

import com.minesweeper.lab3.consoleview.utility.actions.ActionsExecutor;
import com.minesweeper.lab3.db.Settings;
import com.minesweeper.lab3.settings.observer.SettingsObservable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicSettingsView extends JFrame implements SettingsView {
    private JTextField textFieldName;
    private JButton applyButton;
    private JButton exitButton;
    private JSpinner spinnerSizeX;
    private JSpinner spinnerSizeY;
    private JSpinner spinnerNumBomb;
    private JPanel mainPanel;

    private final SettingsObservable observable;
    private Settings settings;
    private final SettingsController controller;

    private final int width = 400;
    private final int height = 200;

    public GraphicSettingsView(SettingsObservable observable, SettingsController controller) {
        this.observable = observable;
        this.controller = controller;
        observable.registerObserver(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setBounds(((int)toolkit.getScreenSize().getWidth() - width) / 2,
                ((int)toolkit.getScreenSize().getHeight() - height) / 2,
                width,
                height);
        setContentPane(mainPanel);


        applyButton.addActionListener(event -> {
            settings.setSizeX((int)spinnerSizeX.getValue());
            settings.setSizeY((int)spinnerSizeY.getValue());
            settings.setNumBomb((int)spinnerNumBomb.getValue());
            settings.setUserName(textFieldName.getText());
            controller.updateSettings(settings);
        });

        exitButton.addActionListener(event -> {
            controller.goToMainMenu();
            dispose();
        });
    }

    @Override
    public void update() {
        this.settings = observable.getSettings();
        spinnerSizeX.setValue(settings.getSizeX());
        spinnerSizeY.setValue(settings.getSizeY());
        spinnerNumBomb.setValue(settings.getNumBomb());
        textFieldName.setText(settings.getUserName());
    }
}
