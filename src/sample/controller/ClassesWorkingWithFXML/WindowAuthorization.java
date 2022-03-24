package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WindowAuthorization {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CreateNewProfileButton;

    @FXML
    private TextField LoginField;

    @FXML
    private Button PasswordRecoveryButton;

    @FXML
    private PasswordField PssswordField;

    @FXML
    private Button EntranceButton;

    @FXML
    void initialize() {
        CreateNewProfileButton.setOnAction(actionEvent ->
        {
            System.out.println("нажата кнопка создания нового профиля");
            CreateNewProfileButton.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/fxml/ControlTime.NewProfile.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        PasswordRecoveryButton.setOnAction(actionEvent ->
        {
            System.out.println("нажата кнопка восстановления пароля");
            PasswordRecoveryButton.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/fxml/ControlTime.PasswordRecovery.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });
        EntranceButton.setOnAction(actionEvent ->
        {
            System.out.println("нажата кнопка входа");
            EntranceButton.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/fxml/ControlTime.Menu.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });


    }

}
