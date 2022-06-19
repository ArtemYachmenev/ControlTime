package sample.Контроллер.ClassesWorkingWithFXML;

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
import sample.Модель.*;
import static sample.Модель.AllStaticData.*;

public class WindowMenu {
    @FXML
    private AnchorPane colorDown;
    @FXML
    private AnchorPane colorUp;
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
    @FXML
    void initialize() {
        //устанавливаем директорию  зашедшего пользователя (меняем с пользователя Null на нашего)
        CreatingAndDeletingADirectory.setDir();
        CheckingForANewUser.CheckingForANewUser();
        //сравниваем списки
        GetAllProgrammPC.comparisonAllProgramPowershall();
        //ставим настройки цевета
        colorDown.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorUp.styleProperty().set(AllStaticData.getPaneDown().getStyle());
        OnButton.setOnAction(ActionEvent -> {
            сlickButtonOn();
            System.out.println(AllStaticData.getOnOrOffAppButtonMenu());
        });
        PersonalizationButton.setOnAction(ActionEvent -> {
            openPers("/sample/Вид/fxml/ControlTime.PersonalConfig.fxml");
        });
        SettingsButton.setOnAction(ActionEvent -> {
            SettingsButton.getScene().getWindow().hide();
            openSett("/sample/Вид/fxml/TimeControl.Settings.fxml");
        });
        StatisticsButton.setOnAction(ActionEvent -> {
            openStat("/sample/Вид/fxml/TimeControl.ShowingStatistics.fxml");
        });
        Exit.setOnAction(ActionEvent -> {
            openAut("/sample/Вид/fxml/TimeControl.Authorization.fxml");
        });
    }
    public void сlickButtonOn(){
        if (AllStaticData.OnOrOffAppButtonMenu==true){
            AllStaticData.OnOrOffAppButtonMenu=false;
executorServiceStartTrackingTheWorkOfPrograms.shutdown();
        }
        else if (AllStaticData.OnOrOffAppButtonMenu==false) {
            AllStaticData.OnOrOffAppButtonMenu = true;

            StartTrackingTheWorkOfPrograms.runProgramAndWait();
        }
    }
    //открытие окно меню
    public void openAut (String window){
        if (executorServiceStartTrackingTheWorkOfPrograms!=null) {
            executorServiceStartTrackingTheWorkOfPrograms.shutdown();
        }
      //  OnButton.setStyle("");
      //  AllStaticData.b=null;
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing aut");
                AllStaticData.setCloseAuthorization(true);
            }
        });
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing pers config");
                AllStaticData.setClosePersonalConfig(true);
            }
        });
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing stat");
                AllStaticData.setCloseStatistics(true);
            }
        });
    }

    //открытие окно настроек
    public void openSett (String window){
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing sett");
                AllStaticData.setCloseSettings(true);
            }
        });
    }
}

