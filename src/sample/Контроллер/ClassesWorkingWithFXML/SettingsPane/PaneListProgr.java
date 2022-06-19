package sample.Контроллер.ClassesWorkingWithFXML.SettingsPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import sample.Модель.AllStaticData;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

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
    @FXML
    private TextField textField;
    @FXML
    void initialize() {
        StringBuilder builder = new StringBuilder();
        StringBuilder usedListBuilder = new StringBuilder();


        ObservableList<String> langs = FXCollections.observableArrayList(AllStaticData.getApp().downloadListProgr());

        ObservableList<String> usedLangs = FXCollections.observableArrayList(AllStaticData.getApp().downloadAListOfUsedApplications());


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

                }

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


                usedListBuilder.append(selectedItems);
            }
        }
        );

        //удаляем строки из листа где лежат используемые приложения
        deleteUsedBth.setOnAction(actionEvent -> {




StringBuilder builderSave=new StringBuilder();
                builderSave.append("\n");

                //берет в себя строки из AllStaticData.ListUsedProgr
                List<String> list = new ArrayList<>();
                //берет в себя строки из usedListBuilder
                List<String> list2 = new ArrayList<>();
                //дублирует первый лист для беозпасного удаления совпадающех строк
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
                AllStaticData.getApp().saveAListOfUsedApplicationsOverwriting(builderSave);

                //присваиваем постоянному массиву реальное количество строк и обнуляем билтеры и листы, иначе нечасто выпаают ошибки
                AllStaticData.ListUsedProgr=builderSave;
                usedListBuilder.setLength(0);
                builder.setLength(0);
                list3.clear();


        });

        //перевод программы из общего списка в список используемых приложений
        selectBth.setOnAction(actionEvent -> {
            StringBuilder builder1 = new StringBuilder();
            StringBuilder builder2=new StringBuilder();

                List<String> list = new ArrayList<>();
//берет в себя строки из builder
                List<String> list2 = new ArrayList<>();
                //берет в себя строки которых нет с списке пользователя
                List<String> list3 = new ArrayList<>();
                //присваиваем переменной данные
                builder2=AllStaticData.ListUsedProgr;
                //создаем массивы
                // держит в себе билдер с выбранными приложениями
                String[] lines = builder2.toString().split("\\n");
                // держит в себе билдер с выбранными строками
                String[] lines2 = builder.toString().split("\\n");
                //присваиваем листам значения массивов
                for (String l : lines) {
                    list.add(l);
                }

                for (String l : lines2) {
                    list2.add(l);
                }

                //если лист используемых приложений не содержит выбранных приложений из общего листа то сохраняем их в третий лист
                    for (int a=0;a<list2.size();a++) {
                        if (!list.contains(list2.get(a))) {
                            list3.add(list2.get(a));
                        }

                    }
                    //цикл для приваивания данных листа таблице и билдеру
                for (int i=0;i<list3.size();i++) {
                    if (!list3.get(i).equals(null) && !list3.get(i).equals("") && !list3.get(i).equals(" ")) {
                        usedLangs.add(list3.get(i) + "\n");
                        builder2.append(list3.get(i) + "\n");
                    }
                }
                //обнуляем чтобы в памяти выбранные элементы не хранились и сохраняем
                builder.setLength(0);
                AllStaticData.getApp().saveAListOfUsedApplicationsOverwriting(builder2);
        });
    }
}




