package sample.controller.ClassesWorkingWithFXML.SettingsPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

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

    public static String textsplitChoiceMesWork=new String("Выберите таймер работы");
    public static String textsplitChoiceMesChill=new String("Выберите таймер отдыха");
    public static boolean checkWork=false;
    public static boolean checkChill=false;


    @FXML
    void initialize() {
        ChoiceTimerWork.setText(textsplitChoiceMesWork);
        ChoiceTimerChill.setText(textsplitChoiceMesChill);

        checkTimerWork.setSelected(checkWork);
        checkTimerChill.setSelected(checkChill);
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
            textsplitChoiceMesWork=ChoiceTimerWork.getText();
        });
        thirtyWork.setOnAction(ActionEvent -> {
            System.out.println("30 минут работы");
            ChoiceTimerWork.setText(thirtyWork.getText());
            textsplitChoiceMesWork=ChoiceTimerWork.getText();
        });
        fortyFiveWork.setOnAction(ActionEvent -> {
            System.out.println("45 минут работы");
            ChoiceTimerWork.setText(fortyFiveWork.getText());
            textsplitChoiceMesWork=ChoiceTimerWork.getText();
        });
        hourWork.setOnAction(ActionEvent -> {
            System.out.println("час работы");
            ChoiceTimerWork.setText(hourWork.getText());
            textsplitChoiceMesWork=ChoiceTimerWork.getText();
        });
        fifteenChill.setOnAction(ActionEvent -> {
            System.out.println("15 минут отдыха");
            ChoiceTimerChill.setText(fifteenChill.getText());
            textsplitChoiceMesChill=ChoiceTimerChill.getText();

        });
        thirtyChill.setOnAction(ActionEvent -> {
            System.out.println("30 минут отдыха");
            ChoiceTimerChill.setText(thirtyChill.getText());
            textsplitChoiceMesChill=ChoiceTimerChill.getText();
        });
        fortyFiveChill.setOnAction(ActionEvent -> {
            System.out.println("45 минут отдыха");
            ChoiceTimerChill.setText(fortyFiveChill.getText());
            textsplitChoiceMesChill=ChoiceTimerChill.getText();
        });
        hourChill.setOnAction(ActionEvent -> {
            System.out.println("час отдыха");
            ChoiceTimerChill.setText(hourChill.getText());
            textsplitChoiceMesChill=ChoiceTimerChill.getText();
        });



    }

    private void ChillTrueOrFalse(boolean selected) {
        if (selected==true) {
            checkChill=true;
        }
        else checkChill=false;
    }


    private void WorkTrueOrFalse(boolean selected) {
        if (selected==true) {
            checkWork=true;
        }
        else checkWork=false;
    }

}

