package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.AllStaticData;
import sample.controller.ChangingTheAppColor;
import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.User;
import sample.view.animations.Shake;


public class WindowNewProfile {

    @FXML
    private AnchorPane colorDown;

    @FXML
    private AnchorPane colorUp;

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
    private Button Exit;

    @FXML
    void initialize() {
        colorUp.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorDown.styleProperty().set(AllStaticData.getPaneDown().getStyle());

        RegisterAProfile.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка регистрации");
            createNewProfile();


        });

        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
            openAut("/sample/view/fxml/ControlTime.Authorization.fxml");


        });

    }

    // метод берет из полей текст и переносит в метод обработки текста db
    private void createNewProfile() {
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
                AllStaticData.setUserLoginNewProfile(user.getLogin());
                openMenu("/sample/view/fxml/ControlTime.Menu.fxml");
            }
        }
        else {
            System.out.println("поля не заполнены");
        }

    }


    //открывает окно авторизации
    public void openAut(String window) {
        Exit.getScene().getWindow().hide();
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
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing authorization");
                AllStaticData.setCloseAuthorization(true);

            }
        });
    }

    //открывает окно меню
    public void openMenu(String window) {
        RegisterAProfile.getScene().getWindow().hide();
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
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing menu");
                AllStaticData.setCloseMenu(true);

            }
        });
    }


}
