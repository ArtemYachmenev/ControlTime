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
import sample.controller.*;


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
        //если нет общего файла со списком приложений пк и пользователя то создаем его
        CreatingAndDeletingADirectory.createGeneralListOfPrograms();

        //сравниваем списки
        GetAllProgrammPC.comparisonAllProgramPowershall();

        //раньше тут было, теперь это лежит в comparisonAllProgramPowershall
        //форматируем все программы установленные на пк из повершелла
        //        GetAllProgrammPC.getAllProgrammPC();
       // StartTrackingTheWorkOfPrograms.runProgramAndWait();
//грузим файлы в директориях
    //    GetAllProgrammPC.getListOfEXEFilesInDirectories();


        //создаем файл пк программ для сравнения с существующих списком
//        GetAllProgrammPC.comparisonAllProgramPowershall();
//
//
        //если список программ с прошлого запуска пк изменился то ищем новые ехе
//        if (GetAllProgrammPC.programsHaveChanged==true){
//            GetAllProgrammPC.getListOfEXEFilesInDirectories();
//
//        }




        //ставим настройки цевета
        colorDown.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorUp.styleProperty().set(AllStaticData.getPaneDown().getStyle());



        OnButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка включения/выключения");
            klickButtonOn();
            System.out.println(AllStaticData.getOnOrOffAppButtonMenu());

        });
        PersonalizationButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка персонализации");
            openPers("/sample/view/fxml/ControlTime.PersonalConfig.fxml");

        });
        SettingsButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка настроек");
            SettingsButton.getScene().getWindow().hide();
            openSett("/sample/view/fxml/ControlTime.Settings.fxml");

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
        if (AllStaticData.OnOrOffAppButtonMenu==true){
            AllStaticData.OnOrOffAppButtonMenu=false;

StartTrackingTheWorkOfPrograms.executorService.shutdown();
            System.out.println("больше не мониторим работающие exe");
        }
        else if (AllStaticData.OnOrOffAppButtonMenu==false) {
            AllStaticData.OnOrOffAppButtonMenu = true;

            //        запускаем мониторинг работы ехе
            StartTrackingTheWorkOfPrograms.runProgramAndWait();
            System.out.println("мониторим работающие exe");

//            while (true) {
//                for (int k = 0; k < AllStaticData.workApp.size(); k++) {
//                    System.out.println("new newenwnenewnew");
//                    System.out.println(AllStaticData.workApp.get(k));
//                }
//            }
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

