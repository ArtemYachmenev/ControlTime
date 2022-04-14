package sample.controller.ClassesWorkingWithFXML.SettingsPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import sample.controller.AllStaticData;

public class PaneMessage {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton ChoiceMes;

    @FXML
    private MenuItem allDisplay;

    @FXML
    private MenuItem ghost;

    @FXML
    private MenuItem rightDisplay;

    @FXML
    private CheckBox soundApp;



    @FXML
    void initialize() {
//установка настроек из статических переменных
        ChoiceMes.setText(AllStaticData.getTextSplitChoiceMesSett());
        soundApp.setSelected(AllStaticData.getCheckSoundAppSett());

        soundApp.setOnAction(ActionEvent -> {
            System.out.println("нажат чекбокс включения или отключения звука");
            soundAppTrueOrFalse(soundApp.isSelected());

        });


        ghost.setOnAction(ActionEvent -> {
            System.out.println("исчезающее уведомление");
            ChoiceMes.setText(ghost.getText());
            //сохранение состояния ползунка
            AllStaticData.setTextSplitChoiceMesSett(ChoiceMes.getText());

        });
        allDisplay.setOnAction(ActionEvent -> {
            System.out.println("уведомление на весь экран");
            ChoiceMes.setText(allDisplay.getText());
            //сохранение состояния ползунка
            AllStaticData.setTextSplitChoiceMesSett(ChoiceMes.getText());


        });
        rightDisplay.setOnAction(ActionEvent -> {
            System.out.println("уведомление справа внизу");
            ChoiceMes.setText(rightDisplay.getText());
            //сохранение состояния ползунка
            AllStaticData.setTextSplitChoiceMesSett(ChoiceMes.getText());


        });




    }

    //сохраняем положение чекбокса
    private void soundAppTrueOrFalse(boolean selected) {
        if (selected==true) {
            AllStaticData.setCheckSoundAppSett(true);
        }
        else AllStaticData.setCheckSoundAppSett(false);

    }

}

