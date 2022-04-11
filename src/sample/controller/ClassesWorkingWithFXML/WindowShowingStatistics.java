package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.controller.ChangingTheAppColor;

public class WindowShowingStatistics {

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
    private Button RecentStatisticsButton;

    @FXML
    private Button StatisticsForTheSelectedTimeButton;

    @FXML
    private Button StatisticsForTheWeekButton;

    @FXML
    void initialize() {
        colorUp.styleProperty().set(ChangingTheAppColor.paneUp.getStyle());
        colorDown.styleProperty().set(ChangingTheAppColor.paneDown.getStyle());

        RecentStatisticsButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка статистика за сегодня");
            openStat24("/sample/view/fxml/StaticsicsScene/ControlTime.ShowingStatistics24.fxml");


        } );

        StatisticsForTheWeekButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка статистики за неделю");
            openStat7("/sample/view/fxml/StaticsicsScene/ControlTime.ShowingStatistics7.fxml");


        });

        StatisticsForTheSelectedTimeButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка статистики за выбранное времея");
            openStatSelectTime("/sample/view/fxml/StaticsicsScene/ControlTime.ShowingStatisticsSelectTime.fxml");


        });

        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
            openMenu("/sample/view/fxml/ControlTime.Menu.fxml");


        });


    }

    //открывает меню приложения
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

    //открывает статистику за день
    public void openStat24(String window) {
        RecentStatisticsButton.getScene().getWindow().hide();
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

    //открывает статистику за неделю
    public void openStat7(String window) {
        StatisticsForTheWeekButton.getScene().getWindow().hide();
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

    //открывает статистику за выбранное время
    public void openStatSelectTime(String window) {
        StatisticsForTheSelectedTimeButton.getScene().getWindow().hide();
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

}

