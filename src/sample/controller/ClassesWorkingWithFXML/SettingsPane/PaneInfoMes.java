package sample.controller.ClassesWorkingWithFXML.SettingsPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

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

    public static String textChoiceInfoMes=new String("Вариант информации в уведомлении");


    @FXML
    void initialize() {
        ChoiceInfoMes.setText(textChoiceInfoMes);
        allTime.setOnAction(ActionEvent -> {
            //меняем описание меню
            System.out.println("фиксация всего времени");
            ChoiceInfoMes.setText(allTime.getText());
            textChoiceInfoMes=ChoiceInfoMes.getText();

        });
        timeProgOrSite.setOnAction(ActionEvent -> {
            //меняем описание меню
            System.out.println("фиксация программы или сайта");
            ChoiceInfoMes.setText(timeProgOrSite.getText());
            textChoiceInfoMes=ChoiceInfoMes.getText();


        });

    }

}
