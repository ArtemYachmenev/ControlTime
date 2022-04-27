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

import javax.swing.*;

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
    private Button selectBth;

  //  @FXML
 //   private Label selectedLbl;

    @FXML
    private TextField textField;

    @FXML
    void initialize() {
        StringBuilder builder=new StringBuilder();
        StringBuilder usedListBuilder=new StringBuilder();

        // создаем список объектов
        ObservableList<String> langs = FXCollections.observableArrayList(AllStaticData.getApp().downloadListProgr());
        //список объектов которые пользователь использует
        ObservableList<String> usedLangs = FXCollections.observableArrayList(AllStaticData.getApp().downloadAListOfUsedApplications());

//строка перехватывает данные и мешает, разобраться позже почтему
    //    langsListView1 = new ListView<String>(langs);


//в листы просмотров вставляем сохраненные данные
    langsListView1.setItems(langs);
        selectProgr.setItems(usedLangs);


        // получаем модель выбора элементов из общего листа
        MultipleSelectionModel<String> langsSelectionModel = langsListView1.getSelectionModel();
        langsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        //получаем модель выбора элементов из используемого листа
        MultipleSelectionModel<String> usedLangsSelectionModel = selectProgr.getSelectionModel();
        usedLangsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);


        // устанавливаем слушатель общего листа для отслеживания изменений
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

            // устанавливаем слушатель используемого листа для отслеживания изменений


        }
                // устанавливаем слушатель используемого листа для отслеживания изменений




        );

        // устанавливаем слушатель используемого листа для отслеживания изменений
        usedLangsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){

            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){

                String selectedItems = "";
                if(!usedListBuilder.isEmpty())
                { usedListBuilder.setLength(0);
                }
                ObservableList<String> selected = usedLangsSelectionModel.getSelectedItems();
                for (String item : selected){
                    selectedItems += item + "\n";

                    // System.out.println(selectedItems);

                }



                //  selectedLbl.setText("Выбрано: " + selectedItems);
                //  textProg.setText(selectedItems);

                //    System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;");
                usedListBuilder.append(selectedItems);


            }
            // устанавливаем слушатель используемого листа для отслеживания изменений


        }
        // устанавливаем слушатель используемого листа для отслеживания изменений




        );









        // кнопка сохранить для сохр проложений в списке
        addBtn.setOnAction(event -> {

            //принимает в себя не пустые слова и вставляет дополнительные строки
            StringBuilder builder1=new StringBuilder();
            if (!textField.getText().trim().equals(null)&&!textField.getText().trim().equals("")&&!textField.getText().trim().equals(" ")) {
                langs.add(textField.getText());
                //добаляем слово из строки в массив
                AllStaticData.ListAllProgr.append(textField.getText()).append("\n");


                //созадем массив с дополнительными разделениями на строки, можно доработать (обойтись без дополнительного разделения на строки)
                String[] lines = AllStaticData.ListAllProgr.toString().split("\\n");
                for (String l:lines){
                    //   System.out.println(l+" fffffffffffffffffffffffffffffff");
                    //если в строке есть данные то вписываем в билдер2 в строку
                    if (!l.equals(null)&&!l.equals("")&&!l.equals(" ")){
                        builder1.append(l+"\n");
                    }
                }


                AllStaticData.getApp().saveListProg(  builder1);

            }
            else
                System.out.println("не введено название приложения");;





        });

        //кнопка удаления из общего списка
        deleteBtn.setOnAction(event -> {
            //делает удаление из статического листа приложений
            StringBuilder builder1=new StringBuilder();
            //принимает в себя не пустые слова и вставляет дополнительные строки
            StringBuilder builder2=new StringBuilder();
         //   смотрим чтобы поле было не пустым
            if (!textField.getText().trim().equals(null)&&!textField.getText().trim().equals("")&&!textField.getText().trim().equals(" ")) {
                langs.remove(textField.getText());


                //хранит текст из поля
                String s=textField.getText();
                //берет индекс первого символа искомого слова
                int i = AllStaticData.ListAllProgr.indexOf(s);
                if(i < 0) {
                    return;
                }

                //оставляет вместо удаленного текста пустую строку
                builder1=   AllStaticData.ListAllProgr.delete(i, i + s.length());
                //созадем массив с дополнительными разделениями на строки, можно доработать (обойтись без дополнительного разделения на строки)
                String[] lines = builder1.toString().split("\\n");
                for (String l:lines){
                 //   System.out.println(l+" fffffffffffffffffffffffffffffff");
                    //если в строке есть данные то вписываем в билдер2 в строку
                    if (!l.equals(null)&&!l.equals("")&&!l.equals(" ")){
                        builder2.append(l+"\n");
                    }
                }


                AllStaticData.getApp().saveListProg(  builder2);

            }
           else
                System.out.println("не введено приложение для удаления");



        });

//кнопка выбрать переносит название программы в лист используемых программ
        selectBth.setOnAction(actionEvent -> {
            StringBuilder builder1=new StringBuilder();
            if (!textField.getText().trim().equals(null)&&!textField.getText().trim().equals("")&&!textField.getText().trim().equals(" ")) {
                usedLangs.add(textField.getText());
                //добаляем слово из строки в массив
                AllStaticData.ListUsedProgr.append(textField.getText()).append("\n");


                //созадем массив с дополнительными разделениями на строки, можно доработать (обойтись без дополнительного разделения на строки)
                String[] lines = AllStaticData.ListUsedProgr.toString().split("\\n");
                for (String l:lines){
                    //   System.out.println(l+" fffffffffffffffffffffffffffffff");
                    //если в строке есть данные то вписываем в билдер2 в строку
                    if (!l.equals(null)&&!l.equals("")&&!l.equals(" ")){
                        builder1.append(l+"\n");
                    }
                }


                AllStaticData.getApp().saveAListOfUsedApplications(  builder1);

            }
            else
                System.out.println("не введено название используемого приложения");;





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

