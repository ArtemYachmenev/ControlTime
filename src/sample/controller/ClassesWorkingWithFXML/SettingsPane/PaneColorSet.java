package sample.controller.ClassesWorkingWithFXML.SettingsPane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PaneColorSet {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button colorAppButton;

    @FXML
    private Button colorButton;

    @FXML
    private Button standartButton;

    public boolean colorApp=false;
    public boolean colorBut=false;
    public boolean standartColor=false;



    @FXML
    void initialize() {
colorAppButton.setOnAction(ActionEvent-> {
    System.out.println("нажата кнопка выхода");
    //  setColor("/sample/view/fxml/ControlTime.Menu.fxml");


});

    }


    //переключение на цвета приложения
  //  public void setColor(boolean allT){
  //      if (allT==true) {
   //         all=true;
   //     }
   //     else all=false;

    }


