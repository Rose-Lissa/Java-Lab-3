module com.minesweeper.lab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;

    opens com.minesweeper.lab3 to javafx.fxml;
    exports com.minesweeper.lab3;
    exports com.minesweeper.lab3.game;
    opens com.minesweeper.lab3.game to javafx.fxml;
    exports com.minesweeper.lab3.consoleview.utility;
    opens com.minesweeper.lab3.consoleview.utility to javafx.fxml;
}