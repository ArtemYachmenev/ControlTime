package sample.controller.ClassesWorkingWithFXML.SettingsPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.controller.ChangingTheAppColor;
import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.User;

import static sample.controller.Database.Const.BACKGROUNDCOL;

public class PaneColorSet {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button colorAppButton;


    @FXML
    private Button standartButton;




    @FXML
    void initialize() {

        colorAppButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка смены фона приложения");
            //  setColor("/sample/view/fxml/ControlTime.Menu.fxml");
            setNewColor();
            setNewScene("/sample/view/fxml/ControlTime.Settings.fxml");

        });
        standartButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка смены фона приложения на стандартный");
            //  setColor("/sample/view/fxml/ControlTime.Menu.fxml");
            setStandartColor();
            setNewScene("/sample/view/fxml/ControlTime.Settings.fxml");


        });

    }

    //обновление сцены настроек с новым цветом
    private void setNewScene(String window) {
        colorAppButton.getScene().getWindow().hide();
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

//получаем цвет приложения
//    public String dowloadColor(){
//
//
//    }


    //взятие следующего цвета приложения
    public void setNewColor() {
        System.out.println("смена цвета");
        DatabaseHandler dbHandler=new DatabaseHandler();
        //остаемся в диапазоне цветов
        if (BACKGROUNDCOL>4){
            BACKGROUNDCOL=1;
        }
//вытягиваем цвета из бд
            ResultSet checkResultUp = dbHandler.getColorUp(BACKGROUNDCOL);
            ResultSet checkResultDown = dbHandler.getColorDown(BACKGROUNDCOL);
            BACKGROUNDCOL++;

            try {
                if (checkResultUp.next() && checkResultDown.next()) {
                    ChangingTheAppColor color=new ChangingTheAppColor();
                    color.changeColorApp(checkResultUp.getString("codeup"),checkResultDown.getString("codedown"));

                    System.out.println(checkResultUp.getString("codeup"));
                    System.out.println(checkResultDown.getString("codedown"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


    }

    //стандартный цвет
    public static void setStandartColor(){
        System.out.println("стандартный цвет");
        DatabaseHandler dbHandler=new DatabaseHandler();
        ResultSet checkResultUp = dbHandler.getColorUp(1);
        ResultSet checkResultDown = dbHandler.getColorDown(1);
        try {
        if (checkResultUp.next() && checkResultDown.next()) {
            ChangingTheAppColor color=new ChangingTheAppColor();
            color.changeColorApp(checkResultUp.getString("codeup"),checkResultDown.getString("codedown"));

            System.out.println(checkResultUp.getString("codeup"));
            System.out.println(checkResultDown.getString("codedown"));
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}


