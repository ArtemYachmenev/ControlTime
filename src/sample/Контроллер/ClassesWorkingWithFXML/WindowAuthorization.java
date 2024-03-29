package sample.Контроллер.ClassesWorkingWithFXML;

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
import sample.Модель.AllStaticData;
import sample.Контроллер.ClassesWorkingWithFXML.SettingsPane.PaneColorSet;
import sample.Модель.Database.DatabaseHandler;
import sample.Модель.Database.User;

public class WindowAuthorization {
    @FXML
    private AnchorPane colorDown;
    @FXML
    private AnchorPane colorUp;
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
        PaneColorSet.setStandartColorAut();
        CreateNewProfileButton.setOnAction(actionEvent ->
        {
            openNewSceneNewProfile("/sample/Вид/fxml/TimeControl.NewProfile.fxml");
        });
        PasswordRecoveryButton.setOnAction(actionEvent ->
        {
            openNewScenePasswordRecovery("/sample/Вид/fxml/TimeControl.PasswordRecovery.fxml");
        });

        EntranceButton.setOnAction(actionEvent ->
        {

            String loginText= LoginField.getText().trim();
           String loginPassword= PssswordField.getText().trim();
            if (!loginText.equals("") && !loginPassword.equals("")){
                try {
                    loginUser(loginText,loginPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    //проверка на существующего юзера
    private void loginUser(String loginText,String loginPassword) throws SQLException {
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
            //записываем в статич перем логин юзера
            AllStaticData.setUserLoginAut(user.getLogin());
            System.out.println(AllStaticData.getUserLoginAut());

            openNewSceneMenu("/sample/Вид/fxml/TimeControl.Menu.fxml");

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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing menu");
                AllStaticData.setCloseMenu(true);
            }
        });
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing recovery 1");
                AllStaticData.setClosePassRecovery(true);
            }
        });

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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing new profile");
                AllStaticData.setCloseNewProfile(true);
            }
        });

    }


}
