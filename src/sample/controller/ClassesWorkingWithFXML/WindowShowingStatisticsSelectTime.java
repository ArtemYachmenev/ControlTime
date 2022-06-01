package sample.controller.ClassesWorkingWithFXML;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.AllStaticData;
import sample.controller.ChangingTheAppColor;
import sample.controller.Database.DatabaseHandler;

public class WindowShowingStatisticsSelectTime {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Exit;

    @FXML
    private Button StatisticsForTheSelectedTimeButton;

    @FXML
    private AnchorPane colorDown;

    @FXML
    private AnchorPane colorUp;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> program;

    @FXML
    private TableView<?> table;

    @FXML
    private TextField textDay;

    @FXML
    private TextField textDay1;

    @FXML
    private TextField textMoth;

    @FXML
    private TextField textMoth1;

    @FXML
    private TextField textYear;

    @FXML
    private TextField textYear1;

    @FXML
    private TableColumn<?, ?> time;

    @FXML
    void initialize() {
        colorUp.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorDown.styleProperty().set(AllStaticData.getPaneDown().getStyle());

        StatisticsForTheSelectedTimeButton.setOnAction(actionEvent ->
                {
                    //метод когда введены две даты
                    if (!textDay.equals("") && !textMoth.equals("")&&!textYear.equals("")&&!textDay.equals("") && !textMoth.equals("")&&!textYear.equals("")) {
String date1=textDay+"-"+textMoth+"-"+textYear;
String date2=textDay1+"-"+textMoth1+"-"+textYear1;
                        DatabaseHandler handler=new DatabaseHandler();
                        ResultSet check = handler.getBetweenDate(AllStaticData.login,date1,date2);

                    }

                });




        Exit.setOnAction(ActionEvent -> {
            System.out.println("нажата кнопка выхода");
            openStat("/sample/view/fxml/ControlTime.ShowingStatistics.fxml");

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
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing stat");
                AllStaticData.setCloseStatistics(true);

            }
        });
    }

}
