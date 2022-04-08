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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WindowSettings {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Exit;

    @FXML
    private Label Restoring;

    @FXML
    private AnchorPane allPane;

    @FXML
    private Button colorAppButton;

    @FXML
    private Button infoMessegeButton;

    @FXML
    private Button messegeButton;

    @FXML
    private Button profileButton;

    @FXML
    private StackPane stackPane;

    @FXML
    private Button timerButton;

    @FXML
    void initialize() {

// загружается первая панель настройка цвета приложения
        try {
            Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingColorPane.fxml"));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
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
@FXML
    public void SettingColorPane(javafx.event.ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingColorPane.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);

    }

// загружается  панель настройка сообщений
@FXML
    public void SettingInfoMesPane(javafx.event.ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingInfoMesPane.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);

    }

    // загружается  панель настройка информации сообщений
    @FXML
    public void SettingMessagePane(javafx.event.ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingMessagePane.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);

    }

    // загружается  панель настройка времени работы и отдыха
    @FXML
    public void SettingTimerPane(javafx.event.ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingTimerPane.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);

    }

    // загружается  панель настройка профиля
    @FXML
    public void SettingProfilePane(javafx.event.ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/SettingProfilePane.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);

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



