package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controller.*;

import java.io.IOException;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //если нет файла со списком приложений то создаем его
        CreatingAndDeletingADirectory.createListPrograms();
// ставим файл для фалов в директориях приложений
        CreatingAndDeletingADirectory.createListOfEXEFilesInDirectories();
        //если нет файла со списком дисков то создаем его
        CreatingAndDeletingADirectory.createListDisk();
        //если нет файла со списком директорий программ от повершелла то создаем его
        CreatingAndDeletingADirectory.createListProgramsPowershell();
        //если нет файла со списком директорий программ от повершелла для дальнейшего сравнения то создаем его
        CreatingAndDeletingADirectory.createListProgramsPowershellCompare();
        //если нет файла со списком директорий программ то создаем его
        CreatingAndDeletingADirectory.createListDirProg();

//загружаем все программы установленные на пк из повершелла и файл для сравнения

      //  GetAllProgrammPC.getAllProgramPowershall();
        GetAllProgrammPC.getAllProgramDirPowershell();



        //грузим новый список для сравнения приложений пк, обновились или нет
        GetAllProgrammPC.newAllProgramPowershall();



       // AllStaticData.getApp().downloadAllDiskPC();


        //загружаем цвет стандартный цвет приложения
        AllStaticData.getApp().downloadStandartColorApp();


        ProcessTracking.trackingProgramm();

        Parent root = FXMLLoader.load(getClass().getResource("view/fxml/ControlTime.Authorization.fxml"));
        primaryStage.setTitle("TimeControl");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
        //отслеживание закрытия окна
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing main");
                AllStaticData.setCloseMain(true);

            }
        });
    }


    public static void main(String[] args) {


        launch(args);
        //проверяем на зарытие окон
        AllStaticData.getApp().checkingWindowСlosures();


    }
}
