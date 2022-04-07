package sample.controller.ClassesWorkingWithFXML;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WindowSettings {

    @FXML
    private AnchorPane allPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Exit;

    @FXML
    private Label Restoring;

    @FXML
    private Button backgroundButton;

    @FXML
    private Pane colorPane;

    @FXML
    private Button colorAppButton;

    @FXML
    private Button colorButton;

    @FXML
    private Pane infoMesPane;

    @FXML
    private Button infoMessegeButton;

    @FXML
    private Pane messagePane;

    @FXML
    private Button messegeButton;

    @FXML
    private Button profileButton;

    @FXML
    private Pane profilePane;

    @FXML
    private Button standartColor;

    @FXML
    private Button timerButton;

    @FXML
    private Pane timerPane;

    @FXML
    void initialize() {

// загружается первая панель настройка цвета приложения
        try {
            Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingColorPane.fxml"));
            allPane.getChildren().removeAll();
            allPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            Logger.getLogger(WindowSettings.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }


        colorAppButton.setOnAction(actionEvent -> {
            System.out.println("нажата кнопка изменения цвета приложения");



        });
        messegeButton.setOnAction(actionEvent -> {
            System.out.println("нажата кнопка изменения  уведомлений");


        });
        infoMessegeButton.setOnAction(actionEvent -> {
            System.out.println("нажата кнопка изменения информации уведомлений");


        });
        timerButton.setOnAction(actionEvent -> {
            System.out.println("нажата кнопка изменения времени работы и отдыха");


        });
        profileButton.setOnAction(actionEvent -> {
            System.out.println("нажата кнопка изменения профиля");


        });
        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
            openMenu("/sample/view/fxml/ControlTime.Menu.fxml");


        });
    }




// загружается  панель настройка цвета
    public void colorPane(ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingColorPane.fxml"));
        allPane.getChildren().removeAll();
        allPane.getChildren().setAll(fxml);

    }

// загружается  панель настройка сообщений
    public void openMessagePane(ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingMessagePane.fxml"));
        allPane.getChildren().removeAll();
        allPane.getChildren().setAll(fxml);

    }

    // загружается  панель настройка информации сообщений
    public void infoMesPane(ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingInfoMesPane.fxml"));
        allPane.getChildren().removeAll();
        allPane.getChildren().setAll(fxml);

    }

    // загружается  панель настройка времени работы и отдыха
    public void timerPane(ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingTimerPane.fxml"));
        allPane.getChildren().removeAll();
        allPane.getChildren().setAll(fxml);

    }

    // загружается  панель настройка профиля
    public void ProfilePane(ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingProfilePane.fxml"));
        allPane.getChildren().removeAll();
        allPane.getChildren().setAll(fxml);

    }



    //открывает окно меню
        public void openMenu(String window) {
            Exit.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }


    public static class SettingTimerPane {
    }
}



