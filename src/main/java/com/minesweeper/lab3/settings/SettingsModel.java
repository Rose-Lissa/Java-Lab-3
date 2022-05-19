package com.minesweeper.lab3.settings;

import com.minesweeper.lab3.db.FileSettingsDB;
import com.minesweeper.lab3.db.Settings;
import com.minesweeper.lab3.db.SettingsDB;
import com.minesweeper.lab3.settings.observer.SettingsObservable;

public class SettingsModel extends SettingsObservable {
    SettingsDB settingsDB;
    Settings settings;

    public SettingsModel(){
        settingsDB = new FileSettingsDB();
    }

    public void downloadSettings(){
        settings = settingsDB.downloadSettings();
        notifyObservers();
    }

    public void updateSettings(Settings settings){
        settingsDB.saveSettings(settings);
        this.settings = settings;
        notifyObservers();
    }

    @Override
    public Settings getSettings() {
        return settings;
    }
}
