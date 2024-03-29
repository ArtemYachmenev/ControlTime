package sample;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Модель.*;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
//узнаем основной диск
        GetAllProgrammPC.getFirstDiskPC();
      //  System.out.println(AllStaticData.firstDiskLine);
        //если нет файла со основным диском
       // CreatingAndDeletingADirectory.createFirstDisk();


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
        //если нет файла с ответом о exe в директориях программ то создаем его
        CreatingAndDeletingADirectory.createDataEXE();

//загружаем все программы установленные на пк из повершелла и файл для сравнения

        //  GetAllProgrammPC.getAllProgramPowershall();
        GetAllProgrammPC.getAllProgramDirPowershell();



        //грузим новый список для сравнения приложений пк, обновились или нет
        GetAllProgrammPC.newAllProgramPowershall();



       // AllStaticData.getApp().downloadAllDiskPC();


        //загружаем цвет стандартный цвет приложения
        AllStaticData.getApp().downloadStandartColorApp();


      //  ProcessTracking.trackingProgramm();
        GetAllProgrammPC.getListDiskPC();
        Parent root = FXMLLoader.load(getClass().getResource("Вид/fxml/TimeControl.Authorization.fxml"));
        primaryStage.setTitle("TimeControl");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        primaryStage.setResizable(false);
        //отслеживание закрытия окна
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing main");
                AllStaticData.setCloseMain(true);

            }
        });
    }


    public static void main(String[] args) {

   //     SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.ROOT);

    //    Date date = new Date();


      //  String res2= String.valueOf(date);
      //  System.out.println(res2);

        launch(args);
        //проверяем на зарытие окон
        AllStaticData.getApp().checkingWindowСlosures();


    }
}
