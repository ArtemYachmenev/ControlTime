package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.User;
import sample.view.animations.Shake;

public class WindowAuthorization {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CreateNewProfileButton;

    @FXML
    private TextField LoginField;

    @FXML
    private Button PasswordRecoveryButton;

    @FXML
    private PasswordField PssswordField;

    @FXML
    private Button EntranceButton;

    @FXML
    void initialize() {

        CreateNewProfileButton.setOnAction(actionEvent ->
        {
            System.out.println("нажата кнопка создания нового профиля");
            openNewSceneNewProfile("/sample/view/fxml/ControlTime.NewProfile.fxml");

        });


        PasswordRecoveryButton.setOnAction(actionEvent ->
        {
            System.out.println("нажата кнопка восстановления пароля");
            openNewScenePasswordRecovery("/sample/view/fxml/ControlTime.PasswordRecovery.fxml");

        });


        EntranceButton.setOnAction(actionEvent ->
        {
            System.out.println("нажата кнопка входа");
            String loginText= LoginField.getText().trim();
            String loginPassword= PssswordField.getText().trim();
            if (!loginText.equals("") && !loginPassword.equals("")){
            loginUser(loginText,loginPassword);
            }
            else
                System.out.println("login and password is empty");
        });
    }

    //проверка на существующего юзера
    private void loginUser(String loginText,String loginPassword){
        DatabaseHandler dbHandler=new DatabaseHandler();
        User user=new User();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
        ResultSet result= dbHandler.getUser(user);
        int counter=0;

            try {
                if (result.next()) {
                    counter++;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        if (counter>=1){
            System.out.println("success");
            openNewSceneMenu("/sample/view/fxml/ControlTime.Menu.fxml");

        }
        else {
            Shake userLogAnim=new Shake(LoginField);
            Shake userPassAnim=new Shake(PssswordField);
            userLogAnim.playAnim();
            userPassAnim.playAnim();
        }


    }
// открывает следующую сцену меню
    public void openNewSceneMenu (String window){
        EntranceButton.getScene().getWindow().hide();
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

    // открывает следующую сцену восстановление пароля
    public void openNewScenePasswordRecovery (String window){
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

    }

    // открывает следующую сцену создания профиля
    public void openNewSceneNewProfile (String window){
        CreateNewProfileButton.getScene().getWindow().hide();
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
