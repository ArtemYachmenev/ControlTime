package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
    private Button Exit;

    public static boolean OnOrOff=false;

    @FXML
    void initialize() {



        OnButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка включения/выключения");
            klickButtonOn();
            System.out.println(OnOrOff);

        });
        PersonalizationButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка персонализации");
            openPers("/sample/view/fxml/ControlTime.PersonalConfig.fxml");

        });
        SettingsButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка настроек");
            SettingsButton.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/fxml/ControlTime.MenuSettings.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        StatisticsButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка статистики");
            openStat("/sample/view/fxml/ControlTime.ShowingStatistics.fxml");
        });

        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
            openAut("/sample/view/fxml/ControlTime.Authorization.fxml");


        });

    }

    //нажатие на кнопку вкл выкл
    public void klickButtonOn(){
        if (OnOrOff==true){
            OnOrOff=false;
        }
        else if (OnOrOff==false) {
            OnOrOff = true;
        }

    }



    //открытие окно меню
    public void openAut (String window){
        Exit.getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root=loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    //открытие окна персонализации
    public void openPers (String window){
        PersonalizationButton.getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root=loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    //открытие окно статистики
    public void openStat (String window){
        Exit.getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root=loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }



}

