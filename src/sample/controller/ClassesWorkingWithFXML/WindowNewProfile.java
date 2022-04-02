package sample.controller.ClassesWorkingWithFXML;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.User;
import sample.view.animations.Shake;


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
            System.out.println("нажата кнопка регистрации");
            createNewProfile();


        });

    }

    // метод берет из полей текст и переносит в метод обработки текста
    private int createNewProfile() {
        //обработчик бд
        DatabaseHandler dbHandler=new DatabaseHandler();
        String  login=LoginField.getText().trim();
        String password=PasswordField.getText().trim();
        String name=NameField.getText().trim();
        String secondName=SecondNameField.getText().trim();
        String secret=SecretField.getText().trim();
        String answer=AnswerField.getText().trim();
        int count = 0;

        //ПРОВЕРКА НА ЗАПОЛНЕННЫЕ ПОЛЯ
        if (!login.equals("") && !password.equals("")&& !name.equals("")&& !secondName.equals("")&& !secret.equals("")&& !answer.equals("")) {

            //проверка на  существующего пользователя

            User CheckUser = new User();
            CheckUser.setLogin(login);
            ResultSet CheckResult = dbHandler.CheckUser(CheckUser);

            try {
                if (CheckResult.next()) {
                    count++;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            if (count >= 1) {
                //почему т строка не возвращается на место
             //   Shake userLogAnim = new Shake(LoginField);
              //  userLogAnim.playAnim();
                System.out.println("логин занят");

            } else {
                System.out.println("success new profile");
                User user = new User(login, password, name, secondName, secret, answer);
                //получаем нового пользователя
                dbHandler.signUpUser(user);
            }
        }
        else {
            System.out.println("поля не заполнены");
        }
        return count;
    }


}
