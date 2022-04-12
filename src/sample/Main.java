package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.DownloadAndSaveConfigApp;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //загружаем цвет приложения
        DownloadAndSaveConfigApp app=new DownloadAndSaveConfigApp();
        app.DownloadColorApp();

        Parent root = FXMLLoader.load(getClass().getResource("view/fxml/ControlTime.Menu.fxml"));
        primaryStage.setTitle("TimeControl");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
