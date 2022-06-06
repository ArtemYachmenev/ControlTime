package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.AllStaticData;

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
        colorUp.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorDown.styleProperty().set(AllStaticData.getPaneDown().getStyle());

        RecentStatisticsButton.setOnAction(ActionEvent -> {
            openStat24("/sample/view/fxml/StaticsicsScene/TimeControl.ShowingStatistics24.fxml");
        } );

        StatisticsForTheSelectedTimeButton.setOnAction(ActionEvent -> {
            openStatSelectTime("/sample/view/fxml/StaticsicsScene/TimeControl.ShowingStatisticsSelectTime.fxml");
        });

        Exit.setOnAction(ActionEvent -> {
            openMenu("/sample/view/fxml/TimeControl.Menu.fxml");
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing menu");
                AllStaticData.setCloseMenu(true);

            }
        });
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing open stat 24");
                AllStaticData.setCloseStatistics24(true);

            }
        });
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing stat 7");
                AllStaticData.setCloseStatistics7(true);

            }
        });
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing select time");
                AllStaticData.setCloseStatisticsSelectTime(true);

            }
        });
    }

}

