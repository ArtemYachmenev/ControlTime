package sample.controller.ClassesWorkingWithFXML.SettingsPane;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
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
            } else{
                //для сохранения не удаленных строк

                StringBuilder builderSave=new StringBuilder();
            builderSave.append("\n");

            //берет в себя строки из AllStaticData.ListAllProgr

            List<String> list = new ArrayList<>();
            //берет в себя строки из usedListBuilder
            List<String> list2 = new ArrayList<>();
            //дублирует первый лист для беопасного удаления совпадающех строк
            List<String> list3 = list;
            //копирует третий лискт без пробелов и прочего
            List<String> list4 = new ArrayList<>();
            //создаем массивы
            String[] lines = AllStaticData.ListAllProgr.toString().split("\\n");
            String[] lines2 = builder.toString().split("\\n");

            //присваиваем листам значения массивов
            for (String l : lines) {
                list.add(l);
                System.out.println(list+" лист использования");
            }


//присваиваем листам значения массивов
            for (String l : lines2) {
                list2.add(l);
                System.out.println(list2+" лист выделенного");
            }



            //перебор совпадений во всем списке строк и в выбранном, если совпадение есть то удаляем эти строки и листа3
            for (int o=0;o<list.size();o++){
                for (int q=0;q<list2.size();q++){
                    if (Objects.equals(list.get(o),list2.get(q))) {

                        System.out.println(Objects.equals(list.get(o),list2.get(q)));
                        list3.remove(o);

                    }
                }}


            //кладем в лист 4 значения 3го листа без пробелов и прочего

            for (int o=0;o<list3.size();o++) {

                if (!(list3.get(o)).equals(null) && !(list3.get(o)).equals("") && !(list3.get(o)).equals(" ")&& !(list3.get(o)).equals("\\s")&& !(list3.get(o)).equals("\n")) {
                    list4.add(list3.get(o));

                }
            }

            //чистим массив строк
            langs.clear();
            //  usedLangs.setAll("");
            //  System.out.println(usedLangs+" fdsfdfdgfdgfdg");

            //добавляем в чисты массив строк не удаленные строки
            for (int o=0;o<list4.size();o++) {


                langs.add(o,list4.get(o));



            }



//сохраняем в билдер сейв лист 4 с сохраненными строками
            for (int q=0;q<list4.size();q++) {
                if (!(list4.get(q)).equals(null) && !(list4.get(q)).equals("") && !(list4.get(q)).equals(" ")&& !(list4.get(q)).equals("\\s")&& !(list4.get(q)).equals("\n")) {

                    builderSave.append(list4.get(q) + "\n");


                }
            }

            AllStaticData.getApp().saveAListOfUsedApplications(builderSave);

            //присваиваем постоянному массиву реальное количество строк и обнуляем билтеры и листы, иначе нечасто выпаают ошибки

            AllStaticData.ListAllProgr=builderSave;
            usedListBuilder.setLength(0);
            builder.setLength(0);
            list3.clear();


        }
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


//для сохранения не удаленных строк
StringBuilder builderSave=new StringBuilder();
                builderSave.append("\n");

                //берет в себя строки из AllStaticData.ListUsedProgr
                List<String> list = new ArrayList<>();
                //берет в себя строки из usedListBuilder
                List<String> list2 = new ArrayList<>();
                //дублирует первый лист для беопасного удаления совпадающех строк
                List<String> list3 = list;
                //копирует третий лискт без пробелов и прочего
                List<String> list4 = new ArrayList<>();
                //создаем массивы
                String[] lines = AllStaticData.ListUsedProgr.toString().split("\\n");
                String[] lines2 = usedListBuilder.toString().split("\\n");

                //присваиваем листам значения массивов
                for (String l : lines) {
                    list.add(l);
                    System.out.println(list+" лист использования");
                }


//присваиваем листам значения массивов
                for (String l : lines2) {
                    list2.add(l);
                    System.out.println(list2+" лист выделенного");
                }



                //перебор совпадений во всем списке строк и в выбранном, если совпадение есть то удаляем эти строки и листа3
                for (int o=0;o<list.size();o++){
                    for (int q=0;q<list2.size();q++){
                        if (Objects.equals(list.get(o),list2.get(q))) {

                            System.out.println(Objects.equals(list.get(o),list2.get(q)));
                            list3.remove(o);

                    }
                        }}


                //кладем в лист 4 значения 3го листа без пробелов и прочего

                for (int o=0;o<list3.size();o++) {

                    if (!(list3.get(o)).equals(null) && !(list3.get(o)).equals("") && !(list3.get(o)).equals(" ")&& !(list3.get(o)).equals("\\s")&& !(list3.get(o)).equals("\n")) {
                        list4.add(list3.get(o));

                    }
                }

                //чистим массив строк
               usedLangs.clear();
              //  usedLangs.setAll("");
              //  System.out.println(usedLangs+" fdsfdfdgfdgfdg");

                //добавляем в чисты массив строк не удаленные строки
                for (int o=0;o<list4.size();o++) {


                            usedLangs.add(o,list4.get(o));



                    }



//сохраняем в билдер сейв лист 4 с сохраненными строками
                for (int q=0;q<list4.size();q++) {
                    if (!(list4.get(q)).equals(null) && !(list4.get(q)).equals("") && !(list4.get(q)).equals(" ")&& !(list4.get(q)).equals("\\s")&& !(list4.get(q)).equals("\n")) {

                        builderSave.append(list4.get(q) + "\n");


                    }
                }

                AllStaticData.getApp().saveAListOfUsedApplications(builderSave);

                //присваиваем постоянному массиву реальное количество строк и обнуляем билтеры и листы, иначе нечасто выпаают ошибки

                AllStaticData.ListUsedProgr=builderSave;
                usedListBuilder.setLength(0);
                builder.setLength(0);
                list3.clear();


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




