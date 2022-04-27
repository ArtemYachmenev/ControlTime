package sample.controller.ClassesWorkingWithFXML.SettingsPane;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.AllStaticData;
import sample.controller.ClassesWorkingWithFXML.WindowSettings;
import sample.controller.DownloadAndSaveConfigApp;

public class PaneProgram {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NewProgramField;

    @FXML
    private Pane pane;

    @FXML
    private Button selectProg;


    @FXML
    void initialize() {
//getList();


    }

    //открываем лист с управлением приложениями
    @FXML
     void goList(javafx.event.ActionEvent event) throws IOException {
        Parent fxml=FXMLLoader.load(getClass().getResource("/sample/view/fxml/SettingsPane/TestList.fxml"));
        pane.getChildren().removeAll();
         pane.getChildren().setAll(fxml);


    }


//открывается окно где можно выбрать приложения
    public  void getList(){
//        // создаем список объектов
//
//        ObservableList<String> program = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
//        programs = new ListView(program);
//
//        Button addBtn = new Button("Add");
//        Button deleteBtn = new Button("Delete");
//
//        addBtn.setOnAction(event -> program.add(NewProgramField.getText()));
//        deleteBtn.setOnAction(event -> program.remove(NewProgramField.getText()));
//        // получаем модель выбора элементов
//        MultipleSelectionModel<String> programsSelectionModel =  programs.getSelectionModel();
//        programsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);
//
//        // устанавливаем слушатель для отслеживания изменений
//        programsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){
//
//            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){
//
//                String selectedItems = "";
//                ObservableList<String> selected = programsSelectionModel.getSelectedItems();
//                for (String item : selected){
//                    selectedItems += item + " ";
//                }
//                selectedLbl.setText("Selected: " + selectedItems);
//            }
//        });


        Label selectedLbl = new Label();
        TextField textField = new TextField();
        TextField textProg = new TextField();
        // создаем список объектов
        ObservableList<String> langs = FXCollections.observableArrayList(AllStaticData.getApp().downloadListProgr());
        ListView<String> langsListView = new ListView<String>(langs);
        langsListView.setPrefSize(500, 300);

        Button addBtn = new Button("Добавить");
        Button deleteBtn = new Button("Удалить");
        Button selectBth = new Button("Выбрать");



        FlowPane buttonPane = new FlowPane(10, 10, textField, selectBth, addBtn, deleteBtn);
        addBtn.setOnAction(event -> langs.add(textField.getText()));
        deleteBtn.setOnAction(event -> langs.remove(textField.getText()));



        // получаем модель выбора элементов
        MultipleSelectionModel<String> langsSelectionModel = langsListView.getSelectionModel();
        langsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        // устанавливаем слушатель для отслеживания изменений
        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){

            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){

                String selectedItems = "";
                ObservableList<String> selected = langsSelectionModel.getSelectedItems();
                for (String item : selected){
                    selectedItems += item + " ";

                    //System.out.println(item);
                }

                selectedLbl.setText("Выбрано: " + selectedItems);
                textProg.setText(selectedItems);


            }
        });

//кнопка выбрать для выбора проложений и сохранения в список отлеживаемых приложений
       selectBth.setOnAction(actionEvent -> {

       //    AllStaticData.getApp().saveAListOfUsedApplications(textProg.getText());
    //       System.out.println(textProg.getText());

    });

//        addBtn.setOnAction(actionEvent -> {
//            for (String item : selectedProg){
//                AllStaticData.getApp().saveListProgr(item);
//            }
//
//        });





        FlowPane root = new FlowPane(Orientation.VERTICAL, 20, 20, selectedLbl, buttonPane, langsListView);

        Scene scene = new Scene(root, 500, 400);
Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("ListView in JavaFX");
        stage.show();



    }



    }


