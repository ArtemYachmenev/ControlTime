package sample.controller.ClassesWorkingWithFXML.SettingsPane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.controller.AllStaticData;
import sample.controller.DownloadAndSaveConfigApp;

public class PaneListProgr {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Pane pane;

    @FXML
    private ListView<String> langsListView1;

    @FXML
    private ListView<String> selectProgr;

    @FXML
    private Button saveBth;

  //  @FXML
 //   private Label selectedLbl;

    @FXML
    private TextField textField;

    @FXML
    void initialize() {
        StringBuilder builder=new StringBuilder();

        // создаем список объектов
        ObservableList<String> langs = FXCollections.observableArrayList(AllStaticData.getApp().downloadListProgr());

//строка перехватывает данные и мешает, разобраться позже почтему
    //    langsListView1 = new ListView<String>(langs);


    langsListView1.setItems(langs);



        // получаем модель выбора элементов
        MultipleSelectionModel<String> langsSelectionModel = langsListView1.getSelectionModel();
        langsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        // устанавливаем слушатель для отслеживания изменений
        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){

            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){

                String selectedItems = "";
                if(!builder.isEmpty()){
                    builder.setLength(0);
                }
                ObservableList<String> selected = langsSelectionModel.getSelectedItems();
                for (String item : selected){
                    selectedItems += item + "\n";

                   // System.out.println(selectedItems);

                }


              //  selectedLbl.setText("Выбрано: " + selectedItems);
              //  textProg.setText(selectedItems);

            //    System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;");
                builder.append(selectedItems);


            }

        });

        // кнопка сохранить для сохр проложений в списке
        addBtn.setOnAction(event -> {
            langs.add(textField.getText());


            //      StringBuilder builder1=AllStaticData.ListAllProgr.append(builder);
                AllStaticData.getApp().saveListProg( AllStaticData.ListAllProgr.append("\n").append(textField.getText()));
            //    System.out.println(builder1+" сохряются программмы из загрузовчного списка");



        });

        deleteBtn.setOnAction(event -> {
            langs.remove(textField.getText());


        });

//кнопка сохранить для сохр проложений
        saveBth.setOnAction(actionEvent -> {
//            if (!builder.isEmpty()) {
//
//                AllStaticData.getApp().saveListProg(builder);
//
//            }
//            else {
//                AllStaticData.getApp().saveListProg( AllStaticData.ListAllProgr);
//                System.out.println(AllStaticData.ListAllProgr+" сохряются программмы из загрузовчного списка");
//            }
        });





    }



// не используется
    public  void getList(){





        TextField textProg = new TextField();
        // создаем список объектов
        ObservableList<String> langs = FXCollections.observableArrayList(AllStaticData.getApp().downloadListProgr());

         langsListView1 = new ListView<String>(langs);


        Button addBtn = new Button("Добавить");
        Button deleteBtn = new Button("Удалить");
        Button selectBth = new Button("Выбрать");



        addBtn.setOnAction(event -> langs.add(textField.getText()));
        deleteBtn.setOnAction(event -> langs.remove(textField.getText()));



        // получаем модель выбора элементов
        MultipleSelectionModel<String> langsSelectionModel = langsListView1.getSelectionModel();
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

                //selectedLbl.setText("Выбрано: " + selectedItems);
                textProg.setText(selectedItems);


            }
        });

//кнопка выбрать для выбора проложений и сохранения в список отлеживаемых приложений
        selectBth.setOnAction(actionEvent -> {

         //   AllStaticData.getApp().saveListProg(textProg.getText());

        });





    }

}

