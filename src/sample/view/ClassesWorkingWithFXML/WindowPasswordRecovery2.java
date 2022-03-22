package sample.view.ClassesWorkingWithFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    void initialize() {
        SendAReplyButton.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка ответа на секретный вопрос");
        });

    }

}

