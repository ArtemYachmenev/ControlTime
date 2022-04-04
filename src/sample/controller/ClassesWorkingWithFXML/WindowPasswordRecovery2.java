package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WindowPasswordRecovery2 {


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
        WindowPasswordRecovery recovery=new WindowPasswordRecovery();
        LabelSecret.setText(recovery.userSecret);

        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
            openPR("/sample/view/fxml/ControlTime.PasswordRecovery.fxml");


        });


    }

    @FXML
    void initialize() {
        //тут не открывается третье окно воостановления пароля возможно из за того что старые не закрываются и не ввыдится текст
        downloadSecretAndAnswer();
        SendAReplyButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка ответа на секретный вопрос");
            String answer=AnswerFieldRecovery2.getText().trim();
            userAnswer(answer);
        });

    }

//метод сравнивающий два ответа пользователя
    public boolean twoAnswers(String answer) {
        WindowPasswordRecovery recovery=new WindowPasswordRecovery();
        return  (answer.equals(recovery.userSecret) ) ;
    }




    //загрузка секрета и сравнение введенной строки с ответом
    public void userAnswer (String userAnswer){
        WindowPasswordRecovery recovery=new WindowPasswordRecovery();
       String answer=recovery.userSecret;

        if (Objects.equals(answer,userAnswer)) {
            openNewSceneRecovery3("/sample/view/fxml/ControlTime.PasswordRecovery3.fxml");
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

    }

}
