package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
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


    public  String login;
    public String secret;
    public String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public WindowPasswordRecovery2() {

    }



    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getLogin(){
        return login;

    }

    public void setLogin(String login){
        this.login=login;

    }

//загрузка секрета
    public void downloadSecretAndAnswer(){
        WindowPasswordRecovery recovery=new WindowPasswordRecovery();
        answer= String.valueOf(recovery.saveLogin(getAnswer().toString()));
        System.out.println(answer);
        LabelSecret.setText(recovery.saveLogin(getLogin()).toString());
    }

    @FXML
    void initialize() {
        downloadSecretAndAnswer();
        SendAReplyButton.setOnAction(ActionEvent -> {
            String answer=AnswerFieldRecovery2.getText().trim();
            System.out.println("нажата кнопка ответа на секретный вопрос");
               userAnswer(answer);


        });

    }


    //сравнение введенной строки с ответом
    public void userAnswer (String answer){

        if (!answer.equals("")) {

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
        stage.showAndWait();

    }

}

