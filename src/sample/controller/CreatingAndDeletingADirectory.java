package sample.controller;

import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

import static sample.controller.AllStaticData.*;


//создает директорию для профиля пользователя
public  class CreatingAndDeletingADirectory {



    //заново присваиваем переменным пути  для профля и файла со всеми прогарммами чтобы если что ими оперировать
    static {
        try {
           // AllStaticData.app.downloadAllDiskPC();

            AllStaticData.dirProfile = Files.createDirectories(Path.of(AllStaticData.firstDiskLine+"\\ControlTime\\" + LoginOfTheWorkingUser.getUserLogin()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //переопределяем директории для профля
    public static void setDir() {
        try {
            AllStaticData.dirProfile = Files.createDirectories(Path.of(AllStaticData.firstDiskLine+"\\ControlTime\\" + LoginOfTheWorkingUser.getUserLogin()));



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //создаем файл со списком файлов в директориях приложений пк
    public static void createListOfEXEFilesInDirectories() {

        listOfEXEFilesInDirectories = new File((AllStaticData.firstDiskLine+"\\ControlTime\\listOfEXEFilesInDirectories.txt"));
        try {
            listOfEXEFilesInDirectories.createNewFile();
           // AllStaticData.app.saveNewAllProgrammPC();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //создаем файл со списком файлов в директориях приложений пк
    public static void createDataEXE() {

        dataEXE = new File((AllStaticData.firstDiskLine+"\\ControlTime\\dataEXE.txt"));
        try {
            dataEXE.createNewFile();
            // AllStaticData.app.saveNewAllProgrammPC();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //создаем файл со списком приложений
    public static void createListPrograms() {

            programPC = new File((AllStaticData.firstDiskLine+"\\ControlTime\\listPrograms.txt"));
        try {
            programPC.createNewFile();
        //    AllStaticData.app.saveNewAllProgrammPC();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


//    //создаем файл с основным диском
//    public static void createFirstDisk() {
//
//        firstDisk = new File(("C:\\dataControlTime\\firstDisk.txt"));
//        try {
//            firstDisk.createNewFile();
//            //    AllStaticData.app.saveNewAllProgrammPC();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }


    //перезапись файла со списком приложений пк
    public static void overwritingListPrograms() {

        programPC.delete();
        createListPrograms();


    }

    //перезапись файла со списком приложений пк и их директориями
    public static void overwritingProgramsDirPowershell() {

        listDir.delete();
        createListDirProg();


    }
    //перезапись файла со списком exe
    public static void overwritingEXE() {

        listOfEXEFilesInDirectories.delete();
        createListOfEXEFilesInDirectories();


    }

    //создаем файл со списком приложений
    public static void createListProgramsPowershell() {

        programPCPowershell = new File((AllStaticData.firstDiskLine+"\\ControlTime\\listProgramsPowershell.txt"));
        try {
            programPCPowershell.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //создаем файл со списком приложений новый для сравнения со старым
    public static void createListProgramsPowershellCompare() {

        programPCPowershellCompare = new File((AllStaticData.firstDiskLine+"\\ControlTime\\listProgramsPowershellCompare.txt"));
        try {
            programPCPowershellCompare.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //удаляем файл со списком приложений
    public static void overwritingListProgramsPowershell() {

        programPCPowershell.delete();
        createListProgramsPowershell();


    }


    //создаем файл со списком приложений пк+ программами пользователя
    public static void createGeneralListOfPrograms() {

        generalListOfPrograms = new File((dirProfile +
                "\\generalListOfPrograms_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt"));

        try {
            generalListOfPrograms.createNewFile();
            AllStaticData.app.saveNewGeneralListOfPrograms();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //перезапись файла со списком приложений пк+ программами пользователя
    public static void overwritingGeneralListOfPrograms() {

        generalListOfPrograms.delete();
        createGeneralListOfPrograms();


    }
    //перезапись файла со списком приложений пк
    public static void overwritingListOfPrograms() {

        programPC.delete();
        createListPrograms();


    }

    //создаем файл со списком дисков
    public static void createListDisk() {

        diskPC = new File((AllStaticData.firstDiskLine+"\\ControlTime\\listDisk.txt"));
        try {
            diskPC.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //создаем файл со списком программ пк и их директорий
    public static void createListDirProg() {

        listDir = new File((AllStaticData.firstDiskLine+"\\ControlTime\\listDir.txt"));
        try {
            listDir.createNewFile();
            AllStaticData.app.saveNewAListDirProg();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }






    public Path getDir() {
        return dirProfile;
    }

    public static void deleteDir(Path directory) {
//        File[] contents = dirProfile.toFile().listFiles();
//        if (contents != null) {
//            for (File f : contents) {
//                if (!Files.isSymbolicLink(f.toPath())) {
//                    deleteDir(f);
//                }
//            }
//        }
//        file.delete();

//рекурсия
        try {
            Files.walk(dirProfile)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//       try {
//           Files.(dirProfile);
//       } catch (IOException e) {
//           e.printStackTrace();
//       }
   //}


