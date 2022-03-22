package sample.view.ClassesWorkingWithFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WindowPasswordRecovery {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginPasswField;

    @FXML
    private Button PasswordRecovery;

    @FXML
    void initialize() {
        PasswordRecovery.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка поиска пользователя");
        });

    }
}