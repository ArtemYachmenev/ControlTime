package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.AllStaticData;

public class WindowPasswordRecovery2 {

    @FXML
    private AnchorPane colorDown;

    @FXML
    private AnchorPane colorUp;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AnswerFieldRecovery2;

    @FXML
    private Label LabelSecret;

    @FXML
    private Label Restoring2;

    @FXML
    private Button SendAReplyButton;

    @FXML
    private Button Exit;




//загрузка секрета
    public void downloadSecretAndAnswer(){
        LabelSecret.setText(AllStaticData.getUserSecretRecovery());

        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
            openPR("/sample/view/fxml/TimeControl.PasswordRecovery.fxml");


        });


    }

    @FXML
    void initialize() {
        colorUp.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorDown.styleProperty().set(AllStaticData.getPaneDown().getStyle());

        //тут не открывается третье окно воостановления пароля возможно из за того что старые не закрываются и не ввыдится текст
        downloadSecretAndAnswer();
        SendAReplyButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка ответа на секретный вопрос");
            String answer=AnswerFieldRecovery2.getText().trim();
            userAnswer(answer);
        });

    }

//метод сравнивающий два ответа пользователя
    //не включен, работает без преопределения
    public boolean twoAnswers(String answer) {
        return  (answer.equals(AllStaticData.getUserSecretRecovery()) ) ;
    }




    //загрузка секрета и сравнение введенной строки с ответом
    public void userAnswer (String userAnswer){
       String answer=AllStaticData.getUserAnswerRecovery();

        if (Objects.equals(answer,userAnswer)) {
            openNewSceneRecovery3("/sample/view/fxml/TimeControl.PasswordRecovery3.fxml");
        }
        else {
            System.out.println("ответ не введен или не верен");
        }

    }




    //открытие окна восстановление пароля 3
    public void openNewSceneRecovery3 (String window){
        SendAReplyButton.getScene().getWindow().hide();
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing revovery 3");
                AllStaticData.setClosePassRecovery3(true);

            }
        });

    }

    //открытие первого окна восст пароля
    public void openPR (String window){
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing recovery 1");
                AllStaticData.setClosePassRecovery(true);

            }
        });

    }

}

