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




//загрузка секрета
    public void downloadSecretAndAnswer(){
        WindowPasswordRecovery recovery=new WindowPasswordRecovery();
       // answer= recovery.saveLogin(getLogin());
       // LabelSecret.setText(recovery.saveLogin(getLogin()));
        LabelSecret.setText(recovery.userSecret);
      //  System.out.println(LabelSecret.getText());

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


    //загрузка и сравнение введенной строки с ответом
    public void userAnswer (String userAnswer){
        WindowPasswordRecovery recovery=new WindowPasswordRecovery();
       String answer=recovery.userSecret;
        if (userAnswer.equals(answer)) {
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

