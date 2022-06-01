package sample.controller.ClassesWorkingWithFXML;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.AllStaticData;
import sample.controller.ChangingTheAppColor;
import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.WorkingHours;

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
    private TableColumn<WorkingHours, Date> date;

    @FXML
    private TableColumn<WorkingHours, String > program;

    @FXML
    private TableView<WorkingHours> table;

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
    private TableColumn<WorkingHours, String> time;
    @FXML
    private TableColumn<WorkingHours, String> working_hours;

    ObservableList<WorkingHours> list = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        colorUp.styleProperty().set(AllStaticData.getPaneUp().getStyle());
        colorDown.styleProperty().set(AllStaticData.getPaneDown().getStyle());







        StatisticsForTheSelectedTimeButton.setOnAction(actionEvent ->
                {
                    //метод когда введены две даты
                    if (!textDay.getText().equals("")&& !textDay.getText().equals(null) && !textMoth.getText().equals("")&& !textMoth.getText().equals(null)&&!textYear.getText().equals("")&&!textYear.getText().equals(null)
                            &&!textDay1.getText().equals("")&&!textDay1.getText().equals(null) && !textMoth1.getText().equals("")&&!textMoth1.getText().equals(null)&&!textYear1.getText().equals("")&&!textYear1.getText().equals(null)) {
                        list.clear();
String date1=textDay.getText()+"."+textMoth.getText()+"."+textYear.getText();
String date2=textDay1.getText()+"."+textMoth1.getText()+"."+textYear1.getText();
                        DatabaseHandler handler=new DatabaseHandler();
                        ResultSet check = handler.getBetweenDate(AllStaticData.login,date1,date2);

                        try {
                            //надо поставить ограничитель на дату

                            //пока есть записи выводится все
                            while (check.next()){

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


                    }
                    else if (!textDay.getText().equals("")&& !textDay.getText().equals(null) && !textMoth.getText().equals("")&& !textMoth.getText().equals(null)&&!textYear.getText().equals("")&&!textYear.getText().equals(null)){
                        list.clear();
                        String date1=textDay.getText()+"."+textMoth.getText()+"."+textYear.getText();

                        DatabaseHandler handler=new DatabaseHandler();
                        ResultSet check = handler.getFirstDate(AllStaticData.login,date1);

                        try {
                            //надо поставить ограничитель на дату

                            //пока есть записи выводится все
                            while (check.next()){

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
                    }
                    else if  (!textDay1.getText().equals("")&&!textDay1.getText().equals(null) && !textMoth1.getText().equals("")&&!textMoth1.getText().equals(null)&&!textYear1.getText().equals("")&&!textYear1.getText().equals(null)){
                    list.clear();
                    String date2=textDay1.getText()+"."+textMoth1.getText()+"."+textYear1.getText();

                    DatabaseHandler handler=new DatabaseHandler();
                    ResultSet check = handler.getLastDate(AllStaticData.login,date2);

                    try {
                        //надо поставить ограничитель на дату

                        //пока есть записи выводится все
                        while (check.next()){

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
        stage.setResizable(false);
        //отслеживание закрытия окна
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing stat");
                AllStaticData.setCloseStatistics(true);

            }
        });
    }

}
