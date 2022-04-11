package sample.controller;

import javafx.scene.layout.AnchorPane;

public class ChangingTheAppColor {

    public static AnchorPane paneUp=new AnchorPane();
    public static AnchorPane paneDown=new AnchorPane();







    public void changeColorApp(String up, String down){

        paneUp.styleProperty().set("-fx-background-color: "+up);
        paneDown.styleProperty().set("-fx-background-color: "+down);


    }

}
