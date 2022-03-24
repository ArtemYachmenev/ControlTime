package sample.controller.ClassesWorkingWithFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WindowMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button OnButton;

    @FXML
    private Button PersonalizationButton;

    @FXML
    private Button SettingsButton;

    @FXML
    private Button StatisticsButton;

    @FXML
    void initialize() {
        OnButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка включения/выключения");
        });
        PersonalizationButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка персонализации");
        });
        SettingsButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка настроек");
        });
        StatisticsButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка сстатистики");
        });

    }

}

