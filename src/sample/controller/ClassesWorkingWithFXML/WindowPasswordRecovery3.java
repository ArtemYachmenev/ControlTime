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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.AllStaticData;
import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.User;

public class WindowPasswordRecovery3 {
    @FXML
    private AnchorPane colorDown;

    @FXML
    private AnchorPane colorUp;

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
        colorUp.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorDown.styleProperty().set(AllStaticData.getPaneDown().getStyle());

        SavePasswordButton.setOnAction(ActionEvent -> {

            String newPass=NewPassword.getText().trim();
            changingThePassword(newPass);

        });

        Exit.setOnAction(ActionEvent -> {
            openPR2("/sample/view/fxml/TimeControl.PasswordRecovery2.fxml");

        });


    }

    //изменяет пароль
    public void changingThePassword(String pass){

        String login= AllStaticData.getUserLoginRecovery();
        User passUser=new User();
        DatabaseHandler dbHandler=new DatabaseHandler();
        passUser.setPassword(pass);
        passUser.setLogin(login);
        dbHandler.newPass(passUser);

        openMenu("/sample/view/fxml/TimeControl.Menu.fxml");




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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing menu");
                AllStaticData.setCloseMenu(true);

            }
        });
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing recovery 2");
                AllStaticData.setClosePassRecovery2(true);

            }
        });

    }
}

