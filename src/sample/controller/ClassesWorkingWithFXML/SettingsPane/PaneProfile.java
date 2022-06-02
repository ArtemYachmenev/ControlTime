package sample.controller.ClassesWorkingWithFXML.SettingsPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.AllStaticData;
import sample.controller.ClassesWorkingWithFXML.WindowAuthorization;
import sample.controller.ClassesWorkingWithFXML.WindowPasswordRecovery;
import sample.controller.CreatingAndDeletingADirectory;
import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.User;
import sample.controller.LoginOfTheWorkingUser;
import static sample.controller.AllStaticData.*;
import javax.swing.*;

public class PaneProfile {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteProfile;

    @FXML
    private Button exitButton;


    @FXML
    void initialize() {
        exitButton.setOnAction(ActionEvent -> {
            System.out.println("выход из профиля");
            if (executorServiceStartTrackingTheWorkOfPrograms!=null) {
                executorServiceStartTrackingTheWorkOfPrograms.shutdown();
            }
            exit("/sample/view/fxml/ControlTime.Authorization.fxml");

        });

        deleteProfile.setOnAction(ActionEvent -> {
            System.out.println("удаление профиля");

            confirmationOfDeletion();
        });

    }

    //подтверждение удаления
    private void confirmationOfDeletion()  {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтверждение действия");
        alert.setHeaderText("Вы действительно хотите удалить профиль?");


        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null) {
            System.out.println("exit");;
        } else if (option.get() == ButtonType.OK) {
            System.out.println("Profile deleted!");
            realDeleteProfile();
        } else if (option.get() == ButtonType.NO) {
            System.out.println("Cancelled");
        }
    }

    //удаление профиля
    private void realDeleteProfile() {
        //создаем подключение к бд и вытягиваем логин
        DatabaseHandler dbHandler=new DatabaseHandler();
        //удаляем логин
        dbHandler.deleteUser(LoginOfTheWorkingUser.getUserLogin());
        //удаляем директорию
        CreatingAndDeletingADirectory.deleteDir(dirProfile);
        openAut("/sample/view/fxml/ControlTime.Authorization.fxml");
    }

    //открытие окно меню
    public void openAut (String window){

        exitButton.getScene().getWindow().hide();
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
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing aut");
                AllStaticData.setCloseAuthorization(true);

            }
        });

    }


    public void exit(String window){
        exitButton.getScene().getWindow().hide();
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
