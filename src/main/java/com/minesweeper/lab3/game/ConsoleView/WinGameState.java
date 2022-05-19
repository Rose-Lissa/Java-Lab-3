package com.minesweeper.lab3.game.ConsoleView;

import com.minesweeper.lab3.game.Cells;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class WinGameState extends ConsoleGameViewState{
    WinGameState(ConsoleGameView view) {
        super(view);
    }

    @Override
    public void drawUI(List<Cells> field, PrintWriter writer) {
        drawField(field);
        writer.println("You win!");
        printPassedTime();
        writer.println("Waiting \"Enter\" for exit to main menu: ");
    }

    @Override
    public void readUserInput(Scanner reader) {
        view.reader.nextLine();
        view.controller.closeGame();
    }
}
