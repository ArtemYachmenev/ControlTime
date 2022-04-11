package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.User;

public class WindowPasswordRecovery3 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NewPassword;

    @FXML
    private Label Restoring2;

    @FXML
    private Button SavePasswordButton;

    @FXML
    private Button Exit;

    @FXML
    void initialize() {
        SavePasswordButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка сохранения нового пароля");
            String newPass=NewPassword.getText().trim();
            changingThePassword(newPass);

        });

        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
            openPR2("/sample/view/fxml/ControlTime.PasswordRecovery2.fxml");


        });


    }

    //изменяет пароль
    public void changingThePassword(String pass){

        WindowPasswordRecovery recovery=new WindowPasswordRecovery();
        String login=recovery.userLogin;
        User passUser=new User();
        DatabaseHandler dbHandler=new DatabaseHandler();
        passUser.setPassword(pass);
        passUser.setLogin(login);
        dbHandler.newPass(passUser);

        openMenu("/sample/view/fxml/ControlTime.Menu.fxml");




    }




    //открывает меню приложения
    public void openMenu(String window) {
        SavePasswordButton.getScene().getWindow().hide();
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

    //открытие второго окна восст пароля
    public void openPR2 (String window){
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

    }
}

