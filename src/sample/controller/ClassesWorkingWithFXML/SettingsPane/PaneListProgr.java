package sample.controller.ClassesWorkingWithFXML.SettingsPane;

import java.io.*;
import java.net.URL;
import java.util.Objects;
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


    @FXML
    private Button deleteUsedBth;

    @FXML
    private Button selectUsedBth;

    //  @FXML
    //   private Label selectedLbl;

    @FXML
    private TextField textField;

    @FXML
    void initialize() {
        StringBuilder builder = new StringBuilder();
        StringBuilder usedListBuilder = new StringBuilder();

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
        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue) {

                String selectedItems = "";
                if (!builder.isEmpty()) {
                    builder.setLength(0);
                }
                ObservableList<String> selected = langsSelectionModel.getSelectedItems();
                for (String item : selected) {
                    selectedItems += item + "\n";

                    // System.out.println(selectedItems);
                }
                //  selectedLbl.setText("Выбрано: " + selectedItems);
                //  textProg.setText(selectedItems);

                //    System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;");
                builder.append(selectedItems);
            }
        }
        );

        // устанавливаем слушатель используемого листа для отслеживания изменений
        usedLangsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue) {
                String selectedItems = "";
                if (!usedListBuilder.isEmpty()) {
                    usedListBuilder.setLength(0);
                }
                ObservableList<String> selected = usedLangsSelectionModel.getSelectedItems();
                for (String item : selected) {
                    selectedItems += item + "\n";
                    // System.out.println(selectedItems);
                }

                //  selectedLbl.setText("Выбрано: " + selectedItems);
                //  textProg.setText(selectedItems);
                //    System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;");
                usedListBuilder.append(selectedItems);
            }
        }
        );
        // кнопка сохранить для сохр всех проложений в списке
        addBtn.setOnAction(event -> {

            //принимает в себя не пустые слова и вставляет дополнительные строки
            StringBuilder builder1 = new StringBuilder();
            if (!textField.getText().trim().equals(null) && !textField.getText().trim().equals("") && !textField.getText().trim().equals(" ")) {
                langs.add(textField.getText());
                //добаляем слово из строки в массив
                AllStaticData.ListAllProgr.append(textField.getText()).append("\n");
                //созадем массив с дополнительными разделениями на строки, можно доработать (обойтись без дополнительного разделения на строки)
                String[] lines = AllStaticData.ListAllProgr.toString().split("\\n");
                for (String l : lines) {
                    //   System.out.println(l+" fffffffffffffffffffffffffffffff");
                    //если в строке есть данные то вписываем в билдер2 в строку
                    if (!l.equals(null) && !l.equals("") && !l.equals(" ")) {
                        builder1.append(l + "\n");
                    }
                }
                AllStaticData.getApp().saveListProg(builder1);
            } else
                System.out.println("не введено название приложения");
            ;
        });

        //кнопка удаления из общего списка
        deleteBtn.setOnAction(event -> {
            //делает удаление из статического листа приложений
            StringBuilder builder1 = new StringBuilder();
            //принимает в себя не пустые слова и вставляет дополнительные строки
            StringBuilder builder2 = new StringBuilder();
            //   смотрим чтобы поле было не пустым
            if (!textField.getText().trim().equals(null) && !textField.getText().trim().equals("") && !textField.getText().trim().equals(" ")) {
                langs.remove(textField.getText());


                //хранит текст из поля
                String s = textField.getText();
                //берет индекс первого символа искомого слова
                int i = AllStaticData.ListAllProgr.indexOf(s);
                if (i < 0) {
                    return;
                }
                //оставляет вместо удаленного текста пустую строку
                builder1 = AllStaticData.ListAllProgr.delete(i, i + s.length());
                //созадем массив с дополнительными разделениями на строки, можно доработать (обойтись без дополнительного разделения на строки)
                String[] lines = builder1.toString().split("\\n");
                for (String l : lines) {
                    //   System.out.println(l+" fffffffffffffffffffffffffffffff");
                    //если в строке есть данные то вписываем в билдер2 в строку
                    if (!l.equals(null) && !l.equals("") && !l.equals(" ")) {
                        builder2.append(l + "\n");
                    }
                }
                AllStaticData.getApp().saveListProg(builder2);
            } else
                System.out.println("не введено приложение для удаления");
        });

//кнопка выбрать переносит название программы в лист используемых программ
        selectUsedBth.setOnAction(actionEvent -> {
            StringBuilder builder1 = new StringBuilder();
            if (!textField.getText().trim().equals(null) && !textField.getText().trim().equals("") && !textField.getText().trim().equals(" ")) {
                usedLangs.add(textField.getText());
                //добаляем слово из строки в массив
                AllStaticData.ListUsedProgr.append(textField.getText()).append("\n");


                //созадем массив с дополнительными разделениями на строки, можно доработать (обойтись без дополнительного разделения на строки)
                String[] lines = AllStaticData.ListUsedProgr.toString().split("\\n");
                for (String l : lines) {
                    //   System.out.println(l+" fffffffffffffffffffffffffffffff");
                    //если в строке есть данные то вписываем в билдер2 в строку
                    if (!l.equals(null) && !l.equals("") && !l.equals(" ")) {
                        builder1.append(l + "\n");
                    }
                }
                AllStaticData.getApp().saveAListOfUsedApplications(builder1);
            } else
                System.out.println("не введено название используемого приложения");

        });

        //удаляем строки из листа где лежат используемые приложения
        deleteUsedBth.setOnAction(actionEvent -> {
            //делает удаление из статического листа используемых приложений
            StringBuilder builder1 = new StringBuilder();
            //принимает в себя не пустые слова и вставляет дополнительные строки
            StringBuilder builder2 = new StringBuilder();
            //принмает в себя названия исп программ
            StringBuilder builder3 = new StringBuilder();

            //   смотрим чтобы поле было не пустым
            if (!textField.getText().trim().equals(null) && !textField.getText().trim().equals("") && !textField.getText().trim().equals(" ")) {
                usedLangs.remove(textField.getText());


                //хранит текст из поля
                String s = textField.getText();
                //берет индекс первого символа искомого слова
                int i = AllStaticData.ListUsedProgr.indexOf(s);
                if (i < 0) {
                    return;
                }
                //оставляет вместо удаленного текста пустую строку
                builder1 = AllStaticData.ListUsedProgr.delete(i, i + s.length());
                //созадем массив с дополнительными разделениями на строки, можно доработать (обойтись без дополнительного разделения на строки)
                String[] lines = builder1.toString().split("\\n");
                for (String l : lines) {
                    //   System.out.println(l+" fffffffffffffffffffffffffffffff");
                    //если в строке есть данные то вписываем в билдер2 в строку
                    if (!l.equals(null) && !l.equals("") && !l.equals(" ")) {
                        builder2.append(l + "\n");
                    }
                }
                AllStaticData.getApp().saveAListOfUsedApplications(builder2);
            } else{


                //хранит текст из поля
                String s = new String();
                //берет индекс первого символа искомого слова
                int i=0;
                //берет индекс последнего символа искомого слова
                int a=0;

builder3=AllStaticData.ListUsedProgr;
StringBuilder builder4=new StringBuilder();
String regFirstEng="\\s+[a-zA-Z]+";
String regRus="[а-яА-Я]+";
String regSpace=" ";


                String[] lines = AllStaticData.ListUsedProgr.toString().split("\\n");
                String[] lines2 = usedListBuilder.toString().split("\\n");
                for (String l : lines) {
                    for (String x : lines2) {
                        if (Objects.equals(l,x)){
                            s=l;
                       //     char b=s.charAt(builder3.indexOf());
                       //     char n=s.charAt(s.length()-1);
                      //      String z=s.substring(b);
                      //      System.out.println(z);

                     //       System.out.println(b+" "+n+" fgfggggggggggggggggggg");
                            i = builder3.indexOf(s);
                            a=builder3.lastIndexOf(s);

                            System.out.println(i+"       dfgggggggggggggggggggggggggg");

                         System.out.println(a+"         fffffffffffffffffffffffffffffffff");

                            builder3.replace(i,a+1, "delete");
                            if (!l.equals(null) && !l.equals("delete")&& !l.contains("delete")&& !l.equals("")&& !l.equals(" ")) {
                                builder4.append(l + "\n");
                            }
                            usedLangs.remove(l);

                        }

                    }
                }
                String[] lines3 = builder3.toString().split("\\n");

                for (String l : lines3) {

//                    if (!l.equals(null) && !l.equals("delete")&& !l.contains("delete")&& !l.equals("")&& !l.equals(" ")) {
//                        builder4.append(l + "\n");
//                    }
                }

                builder4=AllStaticData.ListUsedProgr;
                AllStaticData.getApp().saveAListOfUsedApplications(builder4);

                builder4.setLength(0);
                usedListBuilder.setLength(0);
                builder.setLength(0);


              //  System.out.println(builder4+"     dsffffffffffffffffffffffff");

//                String[] lines3 = builder4.toString().split("\\n");
//                for (String l : lines2) {
//                    i = builder3.indexOf(l);
//                           System.out.println(i+"       dfgggggggggggggggggggggggggg");
//                           a=builder3.lastIndexOf("\n");
//                           System.out.println(a+"         fffffffffffffffffffffffffffffffff");
//                         //  s=l.substring(i,a);
//builder4.append(l+ " adsasddddddddddd");




//                }
//                System.out.println(builder4);









//                String[] lines = AllStaticData.ListUsedProgr.toString().split("\\n");
//                String[] lines2 = usedListBuilder.toString().split("\\n");
//                for (String l : lines) {
//                    for (String x : lines2) {
//
//                        System.out.println(Objects.equals(l,x));
//                        if (Objects.equals(l,x)){
//                            //System.out.println(l);
//                            s=l;
//                            i = builder3.indexOf(s);
//                            System.out.println(i+"       dfgggggggggggggggggggggggggg");
//                            a=builder3.lastIndexOf(s);
//                            System.out.println(a+"         fffffffffffffffffffffffffffffffff");
//
//
//
//
//
//                            if (i < 0) {
//                                return;
//                            }
//                            builder3.delete(i, a);
//                            usedLangs.remove(l);
//                        }
//
//                    }
//                }



            //    AllStaticData.getApp().saveAListOfUsedApplications(builder3);
             //   usedListBuilder.setLength(0);
            }

        });

        //перевод программы из общего списка в список используемых приложений
        selectBth.setOnAction(actionEvent -> {
            //первый билдер работает в первом уловий второй во втором они присваивают значения из циклов в уловиях
            StringBuilder builder1 = new StringBuilder();
            StringBuilder builder2=new StringBuilder();


            //   смотрим чтобы поле было не пустым
            if (!textField.getText().trim().equals(null) && !textField.getText().trim().equals("") && !textField.getText().trim().equals(" ")) {
                usedLangs.add(textField.getText());
                //добаляем слово из строки в массив
                AllStaticData.ListUsedProgr.append(textField.getText()).append("\n");


                //созадем массив с дополнительными разделениями на строки, можно доработать (обойтись без дополнительного разделения на строки)
                String[] lines = AllStaticData.ListUsedProgr.toString().split("\\n");
                for (String l : lines) {
                    //   System.out.println(l+" fffffffffffffffffffffffffffffff");
                    //если в строке есть данные то вписываем в билдер2 в строку
                    if (!l.equals(null) && !l.equals("") && !l.equals(" ")) {
                        builder1.append(l + "\n");
                    }
                }
                AllStaticData.getApp().saveAListOfUsedApplications(builder1);
            } else{


                //добавляем в статик переменные из билдера который держит выделенные данные из первого листа
                AllStaticData.ListUsedProgr.append(builder);
                //созадем массив с дополнительными разделениями на строки, можно доработать (обойтись без дополнительного разделения на строки)
                String[] lines = AllStaticData.ListUsedProgr.toString().split("\\n");
                String[] lines2 = builder.toString().split("\\n");
                //присваиваем значения билдеру
                for (String l : lines) {

                    if (!l.equals(null) && !l.equals("") && !l.equals(" ")) {
                        builder2.append(l + "\n");

                    }
                }

                //присваиваем значение массиву строк вытянутых из сохраненного файла где хранятся используемые программы
                for (String l : lines2) {
                    if (!l.equals(null) && !l.equals("") && !l.equals(" ")) {
                        usedLangs.add(l + "\n");
                    }
                }

                AllStaticData.getApp().saveAListOfUsedApplications(builder2);
                //если не обнулять то странно сохраняет строки
                builder.setLength(0);

            }

        });


    }
}




