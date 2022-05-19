package com.minesweeper.lab3.db;

import java.io.*;
import java.util.*;

public class FileHighScoresDB implements HighScoresDB {
    private final Settings settings;
    private String fileName;

    public FileHighScoresDB(Settings settings) {
        this.settings = settings;
        generateFileName();
    }

    @Override
    public void saveScores(Scores scores) {
        Set<Scores> highScores = addScoresToHighScores(scores);

        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName))){
            stream.writeObject(highScores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Scores> downloadHighScores() {
        Set<Scores> highScores = new TreeSet<>();
        File saveFile = new File(fileName);
        if(saveFile.exists()){
            try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName))){
                highScores = (TreeSet<Scores>)reader.readObject();
            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return highScores;
    }

    private Set<Scores> addScoresToHighScores(Scores scores){
        Set<Scores> highScores = downloadHighScores();
        highScores.add(scores);
        if(highScores.size() > MAX_NUM_SCORES){
            Iterator<Scores> it = highScores.iterator();
            Scores badlyScores = null;
            while (it.hasNext()){
                badlyScores = it.next();
            }
            highScores.remove(badlyScores);
        }
        return highScores;
    }

    private void generateFileName(){
        fileName = "high-scores/" +
                Integer.toString(settings.getSizeX()) + " " +
                Integer.toString(settings.getSizeY()) + " " +
                Integer.toString(settings.getNumBomb()) + ".dat";
    }
}
