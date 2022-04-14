package sample.controller.ClassesWorkingWithFXML.SettingsPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import sample.controller.AllStaticData;

public class PaneTime {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton ChoiceTimerChill;

    @FXML
    private MenuButton ChoiceTimerWork;

    @FXML
    private CheckBox checkTimerChill;

    @FXML
    private CheckBox checkTimerWork;

    @FXML
    private MenuItem fifteenChill;

    @FXML
    private MenuItem fifteenWork;

    @FXML
    private MenuItem fortyFiveChill;

    @FXML
    private MenuItem fortyFiveWork;

    @FXML
    private MenuItem hourChill;

    @FXML
    private MenuItem hourWork;

    @FXML
    private MenuItem thirtyChill;

    @FXML
    private MenuItem thirtyWork;




    @FXML
    void initialize() {
        ChoiceTimerWork.setText(AllStaticData.getTextsplitChoiceMesWorkSett());
        ChoiceTimerChill.setText(AllStaticData.getTextsplitChoiceMesChillSett());

        checkTimerWork.setSelected(AllStaticData.getCheckWorkSett());
        checkTimerChill.setSelected(AllStaticData.getCheckChillSett());
        checkTimerWork.setOnAction(ActionEvent -> {
            System.out.println("нажат чекбокс включения или отключения таймера работы");
            WorkTrueOrFalse(checkTimerWork.isSelected());

        });
        checkTimerChill.setOnAction(ActionEvent -> {
            System.out.println("нажат чекбокс включения или отключения таймера отдыха");
            ChillTrueOrFalse(checkTimerWork.isSelected());

        });
        fifteenWork.setOnAction(ActionEvent -> {
            System.out.println("15 минут работы");
            ChoiceTimerWork.setText(fifteenWork.getText());
            //если это выбрано то сохраняем найстройку в статик
            AllStaticData.setTextsplitChoiceMesWorkSett(ChoiceTimerWork.getText());

        });
        thirtyWork.setOnAction(ActionEvent -> {
            System.out.println("30 минут работы");
            ChoiceTimerWork.setText(thirtyWork.getText());
            //если это выбрано то сохраняем найстройку в статик
            AllStaticData.setTextsplitChoiceMesWorkSett(ChoiceTimerWork.getText());
        });
        fortyFiveWork.setOnAction(ActionEvent -> {
            System.out.println("45 минут работы");
            ChoiceTimerWork.setText(fortyFiveWork.getText());
            //если это выбрано то сохраняем найстройку в статик
            AllStaticData.setTextsplitChoiceMesWorkSett(ChoiceTimerWork.getText());
        });
        hourWork.setOnAction(ActionEvent -> {
            System.out.println("час работы");
            ChoiceTimerWork.setText(hourWork.getText());
            //если это выбрано то сохраняем найстройку в статик
            AllStaticData.setTextsplitChoiceMesWorkSett(ChoiceTimerWork.getText());
        });
        fifteenChill.setOnAction(ActionEvent -> {
            System.out.println("15 минут отдыха");
            ChoiceTimerChill.setText(fifteenChill.getText());
            //если это выбрано то сохраняем найстройку в статик
            AllStaticData.setTextsplitChoiceMesChillSett(ChoiceTimerChill.getText());

        });
        thirtyChill.setOnAction(ActionEvent -> {
            System.out.println("30 минут отдыха");
            ChoiceTimerChill.setText(thirtyChill.getText());
            //если это выбрано то сохраняем найстройку в статик
            AllStaticData.setTextsplitChoiceMesChillSett(ChoiceTimerChill.getText());
        });
        fortyFiveChill.setOnAction(ActionEvent -> {
            System.out.println("45 минут отдыха");
            ChoiceTimerChill.setText(fortyFiveChill.getText());
            //если это выбрано то сохраняем найстройку в статик
            AllStaticData.setTextsplitChoiceMesChillSett(ChoiceTimerChill.getText());
        });
        hourChill.setOnAction(ActionEvent -> {
            System.out.println("час отдыха");
            ChoiceTimerChill.setText(hourChill.getText());
            //если это выбрано то сохраняем найстройку в статик
            AllStaticData.setTextsplitChoiceMesChillSett(ChoiceTimerChill.getText());
        });



    }

    private void ChillTrueOrFalse(boolean selected) {
        if (selected==true) {
            AllStaticData.setCheckChillSett(true);
        }
        else
            AllStaticData.setCheckChillSett(false);

    }


    private void WorkTrueOrFalse(boolean selected) {
        if (selected==true) {
            AllStaticData.setCheckWorkSett(true);

        }
        else AllStaticData.setCheckWorkSett(false);
    }

}

