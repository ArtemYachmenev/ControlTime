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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.AllStaticData;
import sample.controller.ChangingTheAppColor;
import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.User;
import sample.view.animations.Shake;



public class WindowPasswordRecovery {



    @FXML
    private AnchorPane colorDown;

    @FXML
    private AnchorPane colorUp;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginPasswField;

    @FXML
    private Button PasswordRecoveryButton;

    @FXML
    private Button Exit;

    @FXML
    void initialize() {
        colorUp.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorDown.styleProperty().set(AllStaticData.getPaneDown().getStyle());

        PasswordRecoveryButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка поиска пользователя");
            String login=LoginPasswField.getText().trim();
            AllStaticData.setUserLoginRecovery(login);
            if (!login.equals("")){
                //открытие следующего окна восстановления
                int res=CheckLoginUser(login);
                if (res>=1){
                    openNewSceneRecovery2("/sample/view/fxml/ControlTime.PasswordRecovery2.fxml");

                }
            }
            else
                System.out.println("login is empty");
        });
        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
            openAut("/sample/view/fxml/ControlTime.Authorization.fxml");


        });


        }


    //проверка на существующий логин
    public int  CheckLoginUser(String login){
        DatabaseHandler dbHandler=new DatabaseHandler();
        int count = 0;
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
            System.out.println("логин существует");
            saveLogin(login);
            saveAnswer(login);
        } else {
            System.out.println("логина не существует");

        }
        return count;
    }

    //принятие логина и получение вопроса
    public String saveLogin(String loginText){
        User secretUser=new User();
        DatabaseHandler dbHandler=new DatabaseHandler();
        secretUser.setLogin(loginText);
        ResultSet result= dbHandler.getSecretLogin(secretUser);
        try {
            if (result.next()) {
           secretUser.setQuestion(result.getString("question"));
                System.out.println(result.getString("question"));
                AllStaticData.setUserSecretRecovery(secretUser.getQuestion());

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return secretUser.getQuestion();

    }

    //принятие логина и получение ответа
    public String  saveAnswer(String loginText){
        User answerUser=new User();
        DatabaseHandler dbHandler=new DatabaseHandler();
        answerUser.setLogin(loginText);
        ResultSet result= dbHandler.getAnswer(answerUser);
        try {
            if (result.next()) {
                answerUser.setAnswer(result.getString("answer"));
                AllStaticData.setUserAnswerRecovery(answerUser.getAnswer());
               System.out.println(answerUser.getAnswer());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return answerUser.getAnswer();

    }


    //открытие окна восстановление пароля 2
    public void openNewSceneRecovery2 (String window){
        PasswordRecoveryButton.getScene().getWindow().hide();
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
                System.out.println("Stage is closing recovery 2");
                AllStaticData.setClosePassRecovery2(true);

            }
        });

    }

    //открытие окно меню
    public void openAut (String window){
        Exit.getScene().getWindow().hide();
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




    }


