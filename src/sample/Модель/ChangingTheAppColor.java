package sample.Модель;


//меняет цвет приложения
public class ChangingTheAppColor {
    //создаем объект загрузки и сохранения цвета приложения
DownloadAndSaveConfigApp app=new DownloadAndSaveConfigApp();




//устанавливаем цвета для верха и низа приложения
    public void changeColorApp(String up, String down){
        AllStaticData.getPaneUp().styleProperty().set("-fx-background-color: "+up);
        AllStaticData.getPaneDown().styleProperty().set("-fx-background-color: "+down);
      //  app.saveColorApp(up,down);
    }

}
