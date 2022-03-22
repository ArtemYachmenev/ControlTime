package sample.view.ClassesWorkingWithFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class WindowSampleAuthorization {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CreateNewProfile;

    @FXML
    private TextField LoginField;

    @FXML
    private Button PasswordRecovery;

    @FXML
    private PasswordField PssswordField;

    @FXML
    void initialize() {
        CreateNewProfile.setOnAction(actionEvent ->
        {
            System.out.println("нажата кнопка создания нового профиля");
        });
        PasswordRecovery.setOnAction(actionEvent ->
        {
            System.out.println("нажата кнопка восстановления пароля");
        });

    }

}
