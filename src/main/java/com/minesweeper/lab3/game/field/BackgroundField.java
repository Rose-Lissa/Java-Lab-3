package com.minesweeper.lab3.game.field;

import com.minesweeper.lab3.game.Cells;

import java.util.Random;

public class BackgroundField extends Field{

    public BackgroundField (int sizeX, int sizeY, int numBomb){
        super(sizeX, sizeY);
        this.numBomb = numBomb;
        randGen = new Random();
    }


    public void generateField() {
        super.generateField();
        initializeEmptyField();
        arrangeBombs();
        initializeNumbersAroundBombs();
    }

    private void initializeEmptyField(){
        for(int i = 0; i < getSizeX()*getSizeY(); i++){
            addCell(Cells.EMPTY);
        }
    }

    private void arrangeBombs() {
        for(int i = 0; i < numBomb; i++){
            int bombPlace;
            do{
                bombPlace = randGen.nextInt(getSizeX() * getSizeY() - 1);
            }while (getCell(bombPlace) != Cells.EMPTY);
            setCell(bombPlace, Cells.BOMB);
        }
    }

    private void initializeNumbersAroundBombs(){
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                if(getCell(i, j) != Cells.BOMB){
                    int numBombsAround = countBombsAround(i, j);
                    setCell(i, j, numBombsAroundToCells(numBombsAround));
                }
            }
        }
    }

    private Cells numBombsAroundToCells(int numBombsAround){
        return switch (numBombsAround) {
            case 0 -> Cells.EMPTY;
            case 1 -> Cells.ONE;
            case 2 -> Cells.TWO;
            case 3 -> Cells.THREE;
            case 4 -> Cells.FOUR;
            case 5 -> Cells.FIVE;
            case 6 -> Cells.SIX;
            case 7 -> Cells.SEVEN;
            case 8 -> Cells.EIGHT;
            default ->
                    //TODO add exception
                    Cells.EMPTY;
        };
    }

    private int countBombsAround(int x, int y){
        int numBombsAround = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i == 0 && j == 0)
                    continue;
                if((x+i) >= sizeX || (x+i) < 0)
                    continue;
                if((y+j) >= sizeY || (y+j) < 0)
                    continue;
                if(getCell(x + i, y + j) == Cells.BOMB)
                    numBombsAround++;
            }
        }
        return numBombsAround;
    }

    private final int numBomb;
    private final Random randGen;
}
