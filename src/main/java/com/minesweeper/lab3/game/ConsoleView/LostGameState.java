package com.minesweeper.lab3.game.ConsoleView;

import com.minesweeper.lab3.game.Cells;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class LostGameState extends ConsoleGameViewState {
    LostGameState(ConsoleGameView view){
        super(view);
    }

    @Override
    public void drawUI(List<Cells> field, PrintWriter writer) {
        drawField(field);
        writer.println("You lost!");
        printPassedTime();
        writer.println("Waiting \"Enter\" for exit to main menu: ");
    }

    @Override
    public void readUserInput(Scanner reader) {
        reader.nextLine();
        view.controller.closeGame();
    }
}
