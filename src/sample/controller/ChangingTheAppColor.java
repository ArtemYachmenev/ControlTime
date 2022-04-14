package sample.controller;

import javafx.scene.layout.AnchorPane;

import java.io.Serializable;


//меняет цвет приложения
public class ChangingTheAppColor {
    //создаем объект загрузки и сохранения цвета приложения
DownloadAndSaveConfigApp app=new DownloadAndSaveConfigApp();
    public static AnchorPane paneUp=new AnchorPane();
    public static AnchorPane paneDown=new AnchorPane();



//устанавливаем цвета для верха и низа приложения
    public void changeColorApp(String up, String down){
        paneUp.styleProperty().set("-fx-background-color: "+up);
        paneDown.styleProperty().set("-fx-background-color: "+down);
        app.saveColorApp(up,down);
    }

}
