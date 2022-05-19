package com.minesweeper.lab3;

import com.minesweeper.lab3.mainmenu.*;

import javax.swing.*;

public class MinesweeperRunner {
    public static void main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Main thread: " + Thread.currentThread().getName());
        MinesweeperLauncher launcher = new MinesweeperLauncher(Service.UI.Graphic);
        launcher.toMainMenu();
    }
}

//package com.minesweeper.lab3;
//import java.io.*;
//
//public class MinesweeperRunner {
//    public static void resetScreen() {
//        try {
//            if (System.getProperty("os.name").contains("Windows"))
//                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//            else
//                Runtime.getRuntime().exec("clear");
//        } catch (IOException | InterruptedException ex) {}
//    }
//
//    public static void clearScreen() {
//        System.out.print("\033[H\033[2J");
//    }
//
//    public static void gotoXY(int row, int column) {
//        System.out.print(String.format("\033[%d;%df", row, column));
//    }
//
//    public static void setColor(int color) {
//        System.out.print(String.format("\033[3%dm", color));
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        resetScreen();
//        for(int a = 0; a < 10; a++) {
//            clearScreen();
//            gotoXY(a + 1, a + 1);
//            setColor(a);
//            System.out.println("this is " + a);
//            Thread.sleep(500);
//        }
//    }
//}