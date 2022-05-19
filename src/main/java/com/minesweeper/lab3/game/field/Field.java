package com.minesweeper.lab3.game.field;

import com.minesweeper.lab3.game.Cells;

import java.util.ArrayList;
import java.util.List;

public class Field {
    Field(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void copyField(Field field) {
        List<Cells> otherField = field.getField();
        if (this.field.size() != otherField.size()){
            //TODO exception
        }
        for(int i = 0; i < sizeX*sizeY; i++){
            this.field = otherField;
        }
    }

    void generateField(){
        field = new ArrayList<>();
    }

    public void addCell(Cells cell){
        field.add(cell);
    }

    public void setCell(int x, int y, Cells cell){
        field.set(x + y * sizeX, cell);
    }
    public void setCell(int pos, Cells cell){
        field.set(pos, cell);
    }

    public Cells getCell(int x, int y){
        return field.get(x + y * sizeX);
    }
    public Cells getCell(int pos){
        return field.get(pos);
    }

    public List<Cells> getField() {
        return field;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    protected List<Cells> field;
    protected final int sizeX;
    protected final int sizeY;
}
