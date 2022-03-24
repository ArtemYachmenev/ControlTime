package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    void initialize() {
        SavePasswordButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка сохранения нового пароля");
            SavePasswordButton.getScene().getWindow().hide();
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

