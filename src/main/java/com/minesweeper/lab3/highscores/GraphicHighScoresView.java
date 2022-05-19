package com.minesweeper.lab3.highscores;

import com.minesweeper.lab3.db.Scores;
import com.minesweeper.lab3.db.Settings;
import com.minesweeper.lab3.highscores.observer.HighScoresObservable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphicHighScoresView extends JFrame implements HighScoresView {
    private JTable tableHighScores;
    private JPanel mainPanel;
    private JSpinner spinnerSizeX;
    private JSpinner spinnerSizeY;
    private JSpinner spinnerNumBomb;
    private JButton downloadHighScoresButton;
    private JButton exitButton;

    Settings settings;
    private List<Scores> highScores;
    private final HighScoresController controller;
    private final HighScoresObservable observable;

    private final int width = 400;
    private final int height = 600;

    public GraphicHighScoresView(HighScoresObservable observable,HighScoresController controller) {
        this.controller = controller;
        this.observable = observable;
        observable.registerObserver(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setBounds(((int)toolkit.getScreenSize().getWidth() - width) / 2,
                ((int)toolkit.getScreenSize().getHeight() - height) / 2,
                width,
                height);
        setContentPane(mainPanel);


        downloadHighScoresButton.addActionListener(event -> {
            settings.setSizeX((int)spinnerSizeX.getValue());
            settings.setSizeY((int)spinnerSizeY.getValue());
            settings.setNumBomb((int)spinnerNumBomb.getValue());
            controller.downloadAnotherHighScores(settings);
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
        this.highScores = observable.getHighScores();
        updateTable();
    }

    private void updateTable(){
        //TODO update table
    }
}
