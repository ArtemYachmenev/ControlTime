package sample.Контроллер.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Модель.AllStaticData;

public class WindowSettings {
    @FXML
    private AnchorPane colorDown;
    @FXML
    private AnchorPane colorUp;
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
        colorUp.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorDown.styleProperty().set(AllStaticData.getPaneDown().getStyle());

        try {
            Parent fxml=FXMLLoader.load(getClass().getResource("/sample/Вид/fxml/SettingsPane/SettingColorPane.fxml"));
            stackPane.getChildren().removeAll();
            stackPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            Logger.getLogger(WindowSettings.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }

        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
           openMenu("/sample/Вид/fxml/TimeControl.Menu.fxml");
        });
    }

// загружается  панель настройка цвета
@FXML
    public void SettingColorPane(javafx.event.ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/Вид/fxml/SettingsPane/SettingColorPane.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);
    System.out.println("нажата кнопка изменения цвета приложения");

    }

    // загружается  панель настройка профиля
    @FXML
    public void SettingProfilePane(javafx.event.ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/Вид/fxml/SettingsPane/SettingProfilePane.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);
        System.out.println("нажата кнопка изменения профиля");

    }

    // загружается  панель  отслеживания программ

    @FXML
    public void SettingProgramPane(javafx.event.ActionEvent event) throws IOException {

        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/Вид/fxml/SettingsPane/ProgramList.fxml"));
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
            stage.setResizable(false);
            //отслеживание закрытия окна
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    System.out.println("Stage is closing menu");
                    AllStaticData.setCloseMenu(true);

                }
            });
        }



}



