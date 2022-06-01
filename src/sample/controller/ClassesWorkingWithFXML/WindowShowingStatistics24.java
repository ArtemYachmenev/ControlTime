package sample.controller.ClassesWorkingWithFXML;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.AllStaticData;
import sample.controller.ChangingTheAppColor;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.WorkingHours;


public class WindowShowingStatistics24 implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Exit;

    @FXML
    private AnchorPane colorDown;

    @FXML
    private AnchorPane colorUp;

    @FXML
    private TableColumn<WorkingHours, Date> date;

    @FXML
    private TableColumn<WorkingHours, String> program;

    @FXML
    public TableView<WorkingHours> table;

    @FXML
    private TableColumn<WorkingHours, String> time;
    @FXML
    private TableColumn<WorkingHours, String> working_hours;
//надо считаь данные из бд и вставить в лист


   ObservableList<WorkingHours> list = FXCollections.observableArrayList();
    @FXML
    public void initialize(URL url, ResourceBundle resources) {
        colorUp.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorDown.styleProperty().set(AllStaticData.getPaneDown().getStyle());

        DatabaseHandler handler=new DatabaseHandler();
        ResultSet check = handler.get24(AllStaticData.login);
        try {
            //надо поставить ограничитель на дату

            //пока есть записи выводится все
            while (check.next()){
//                System.out.println(check.getString("DATE_OF_WORK")+ " dddddddddd");
//                System.out.println(check.getString("WORKING_HOURS")+ " dddddddddd");
//
//                System.out.println(check.getString("PROGRAM")+ " dddddddddd");
//                System.out.println(check.getString("TIME")+ " dddddddddd");
//                if (!check.next()){
//                    list.add(new WorkingHours("нет данных","нет данных","нет данных"));
//                }
Date  d=check.getDate("DATE_OF_WORK");
String h=check.getString("WORKING_HOURS");
String p=check.getString("PROGRAM");
String t=check.getString("TIME");


             //   System.out.println(h+" eeeeeeeeeeeeeeeeeeeee");
                SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd.MM.YY ");



                String res=oldDateFormat.format(d);

               WorkingHours workingHours=   new WorkingHours(d,h,p,t);
            //    System.out.println(res);

                list.add(new WorkingHours(d,h,p,t));


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        date.setCellValueFactory(new PropertyValueFactory<WorkingHours,Date>("date"));
        working_hours.setCellValueFactory(new PropertyValueFactory<WorkingHours,String>("working_hours"));
        program.setCellValueFactory(new PropertyValueFactory< WorkingHours,String>("program"));
        time.setCellValueFactory(new PropertyValueFactory< WorkingHours,String>("time"));

     //   System.out.println(date);
        table.setItems(list);
     //   System.out.println(table==null);

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

    public static class SettingProfilePane {
    }
}
