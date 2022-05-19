package com.minesweeper.lab3.mainmenu;

import com.minesweeper.lab3.mainmenu.observer.MainMenuObservable;

import javax.swing.*;
import java.awt.*;

public class GraphicMainMenuView extends JFrame implements MainMenuView{
    private static final String title = "Minesweeper";

    private MainMenuObservable observable;
    private MainMenuController controller;

    private int width = 200;
    private int height = 300;
    private JPanel mainPanel;
    private JPanel buttonsPanel;

    public GraphicMainMenuView(MainMenuObservable observable, MainMenuController controller){
        super(title);

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
    }

    @Override
    public void update() {
        addButtons();
    }

    private void addButtons(){
        buttonsPanel.setLayout(new GridLayout(0,1 , 1, 1));
        for(MenuOptions option : observable.getOptions()){
            JButton button = createButton(option);
            buttonsPanel.add(button);
        }
    }

    private JButton createButton(MenuOptions option){
        JButton button = new JButton();
        button.setText(MenuOptions.menuOptionsToString(option));
        button.addActionListener(event -> {
            controller.goTo(option);
            if(option == MenuOptions.EXIT){
                dispose();
            }
        });
        return button;
    }
}
