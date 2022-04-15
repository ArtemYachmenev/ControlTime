package sample.controller.ClassesWorkingWithFXML;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.AllStaticData;
import sample.controller.ChangingTheAppColor;
import sample.controller.DownloadAndSaveConfigApp;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class WindowPersonalConfig {

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
    private CheckBox allTime;

    @FXML
    private CheckBox messenges;

    @FXML
    private CheckBox operationTimer;

    @FXML
    private CheckBox restTimer;

    @FXML
    private CheckBox sound;

    @FXML
    private CheckBox timeSiteProgr;



    @FXML
    void initialize() {
        colorUp.styleProperty().set(ChangingTheAppColor.paneUp.getStyle());
        colorDown.styleProperty().set(ChangingTheAppColor.paneDown.getStyle());

        //устанавливаем сохраненные значения чекбоксов
        allTime.setSelected(AllStaticData.getAllTimeConfig());
        timeSiteProgr.setSelected(AllStaticData.getTimeSiteProgrConfig());
        messenges.setSelected(AllStaticData.getMessegeConfig());
        operationTimer.setSelected(AllStaticData.getWorkTimeConfig());
        restTimer.setSelected(AllStaticData.getChillTimeConfig());
        sound.setSelected(AllStaticData.getAllSoundConfig());



        allTime.setOnAction(ActionEvent -> {
                    System.out.println("нажат чекбокс отслеживания всего времени");
                    allTimeTrueOrFalse(allTime.isSelected());
                });
        messenges.setOnAction(ActionEvent -> {
            System.out.println("нажата чекбокс вывода уведомлений");
            messegeTrueOrFalse(messenges.isSelected());

        });

        operationTimer.setOnAction(ActionEvent -> {
            System.out.println("нажат чекбокс таймера работы");
            operTrueOrFalse(operationTimer.isSelected());


        });

        restTimer.setOnAction(ActionEvent -> {
            System.out.println("нажат чекбокс таймера отдыха");
            restTrueOrFalse(restTimer.isSelected());


        });

        sound.setOnAction(ActionEvent -> {
            System.out.println("нажат чекбокс работы музыки");
            soundTrueOrFalse(sound.isSelected());

        });

        timeSiteProgr.setOnAction(ActionEvent -> {
            System.out.println("нажат чекбокс работы сайтов, программ");
            timeSiteProgrTrueOrFalse(timeSiteProgr.isSelected());


        });


        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
            openMenu("/sample/view/fxml/ControlTime.Menu.fxml");


        });


    }

    //проверка на нажатый чекбокс отселживание вчего времени
    public void allTimeTrueOrFalse(boolean allT){
       if (allT==true) {
           AllStaticData.setAllTimeConfig(true);
       }
       else AllStaticData.setAllTimeConfig(false);

    }

    //проверка на нажатый чекбокс отселживание времени работы на сайтах и прогр
    public void timeSiteProgrTrueOrFalse(boolean b){
        if (b==true) {
            AllStaticData.setTimeSiteProgrConfig(true);
        }
        else AllStaticData.setTimeSiteProgrConfig(false);

    }

    //проверка на нажатый чекбокс появление сообщений
    public void messegeTrueOrFalse(boolean b){
        if (b==true) {
            AllStaticData.setMessegeConfig(true);
        }
        else AllStaticData.setMessegeConfig(false);;

    }

    //проверка на нажатый чекбокс таймер работы
    public void operTrueOrFalse(boolean b){
        if (b==true) {
            AllStaticData.setWorkTimeConfig(true);
        }
        else AllStaticData.setWorkTimeConfig(false);

    }

    //проверка на нажатый чекбокс таймер отдыха
    public void restTrueOrFalse(boolean b){
        if (b==true) {
            AllStaticData.setChillTimeConfig(true);
        }
        else AllStaticData.setChillTimeConfig(false);

    }

    //проверка на нажатый чекбокс работа звука
    public void soundTrueOrFalse(boolean allT){
        if (allT==true) {
            AllStaticData.setAllSoundConfig(true);

        }
        else AllStaticData.setAllSoundConfig(false);

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
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing menu");
                AllStaticData.setCloseMenu(true);


            }
        });
    }
}

