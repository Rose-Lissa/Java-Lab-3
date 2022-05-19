package com.minesweeper.lab3.game.field;

import com.minesweeper.lab3.game.Cells;

import java.util.ArrayList;
import java.util.List;

public class ForegroundField extends Field {
    public ForegroundField (int sizeX, int sizeY){
        super(sizeX, sizeY);
    }
    public List<Cells> getField() {
        return field;
    }

    public void generateField() {
        super.generateField();
        for(int i = 0; i < sizeX*sizeY; i++){
            addCell(Cells.UNKNOWN);
        }
    }

    public boolean isUnknownCell(int x, int y){
        return getCell(x, y) == Cells.UNKNOWN;
    }
}
