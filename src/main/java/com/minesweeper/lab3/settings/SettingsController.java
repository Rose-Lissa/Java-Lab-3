package com.minesweeper.lab3.settings;

import com.minesweeper.lab3.db.Settings;
import com.minesweeper.lab3.settings.observer.SettingsObservable;

public class SettingsController {
    private final SettingsModel model;
    private final SettingsService service;

    public SettingsController(SettingsService service, SettingsModel model){
        this.service = service;
        this.model = model;
    }

    void updateSettings(Settings settings){
        model.updateSettings(settings);
    }

    void goToMainMenu(){
        service.goToMainMenu();
    }
}
