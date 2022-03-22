package sample.view.ClassesWorkingWithFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
        });

    }

}

