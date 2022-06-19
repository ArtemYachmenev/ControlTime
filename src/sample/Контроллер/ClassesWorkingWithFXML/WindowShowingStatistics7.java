package sample.Контроллер.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Модель.AllStaticData;

public class WindowShowingStatistics7 {
    @FXML
    private AnchorPane colorDown;

    @FXML
    private AnchorPane colorUp;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Exit;

    @FXML
    private Button StatisticsForTheSelectedTimeButton;

    @FXML
    void initialize() {
        colorUp.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorDown.styleProperty().set(AllStaticData.getPaneDown().getStyle());

        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
            openStat("/sample/Вид/fxml/TimeControl.ShowingStatistics.fxml");

        });

    }

    //открывает первое меню статистики
    public void openStat(String window) {
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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing stat");
                AllStaticData.setCloseStatistics(true);

            }
        });
    }

    public static class SettingColorPane {
    }

    public static class SettingInfoMesPane {
    }

    public static class SettingMessagePane {
    }
}
