package com.minesweeper.lab3.db;

import java.io.*;

public class FileSettingsDB implements SettingsDB {
    public final String fileName = "data/settings.dat";

    @Override
    public Settings downloadSettings() {
        Settings settings = new Settings(DEFAULT_USER_NAME, DEFAULT_SIZE_X, DEFAULT_SIZE_Y, DEFAULT_NUM_BOMB);
        File saveFile = new File(fileName);
        if(saveFile.exists()){
            try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName))){
                settings = (Settings)reader.readObject();
            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return settings;
    }

    @Override
    public void saveSettings(Settings settings) {
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName))){
            writer.writeObject(settings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
