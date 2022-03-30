package sample.controller.ClassesWorkingWithFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.User;


public class WindowNewProfile {

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
    private PasswordField PasswordField;

    @FXML
    private Button RegisterAProfile;

    @FXML
    private TextField SecondNameField;

    @FXML
    private TextField SecretField;

    @FXML
    void initialize() {
        //обработчик бд
        DatabaseHandler dbHandler=new DatabaseHandler();
        RegisterAProfile.setOnAction(ActionEvent -> {

            createNewProfile();
            System.out.println("нажата кнопка регистрации");


        });

    }

    // метод берет из полей текст и переносит в метод обработки текста
    private void createNewProfile() {
        //обработчик бд
        DatabaseHandler dbHandler=new DatabaseHandler();
        String  login=LoginField.getText();
        String password=PasswordField.getText();
        String name=NameField.getText();
        String secondName=SecondNameField.getText();
        String secret=SecretField.getText();
        String answer=AnswerField.getText();

        User user=new User(login,password,name,secondName, secondName,answer);


        //получаем нового пользователя
        dbHandler.signUpUser(user);

    }

}
