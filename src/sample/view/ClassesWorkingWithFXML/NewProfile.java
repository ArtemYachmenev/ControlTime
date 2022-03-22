package sample.view.ClassesWorkingWithFXML;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class NewProfile {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AnswerField;

    @FXML
    private TextField LoginField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField PatronymicField;

    @FXML
    private PasswordField PssswordField;

    @FXML
    private Button RegisterAProfile;

    @FXML
    private TextField SecondNameField;

    @FXML
    private TextField SecretField;

    @FXML
    void initialize() {
        RegisterAProfile.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка регистрации");
        });

    }

}
