package sample.controller.ClassesWorkingWithFXML.SettingsPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import sample.controller.AllStaticData;
import sample.controller.DownloadAndSaveConfigApp;

public class PaneInfoMes {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton ChoiceInfoMes;

    @FXML
    private MenuItem allTime;

    @FXML
    private MenuItem timeProgOrSite;




    @FXML
    void initialize() {
        ChoiceInfoMes.setText(AllStaticData.getTextChoiceInfoMesSett());
        allTime.setOnAction(ActionEvent -> {
            //меняем описание меню
            System.out.println("фиксация всего времени");
            ChoiceInfoMes.setText(allTime.getText());
            //сохранение состояния ползунка
            AllStaticData.setTextChoiceInfoMesSett(ChoiceInfoMes.getText());
//сразу сохраняем изменения настроек
            AllStaticData.getApp().saveStaticData();
        });
        timeProgOrSite.setOnAction(ActionEvent -> {
            //меняем описание меню
            System.out.println("фиксация программы или сайта");
            ChoiceInfoMes.setText(timeProgOrSite.getText());
            //сохранение состояния ползунка
            AllStaticData.setTextChoiceInfoMesSett(ChoiceInfoMes.getText());
//сразу сохраняем изменения настроек
            AllStaticData.getApp().saveStaticData();

        });

    }

}
