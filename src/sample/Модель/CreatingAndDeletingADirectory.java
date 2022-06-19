package sample.Модель;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

import static sample.Модель.AllStaticData.*;


//создает директорию для профиля пользователя
public  class CreatingAndDeletingADirectory {



    //заново присваиваем переменным пути  для профля и файла со всеми прогарммами чтобы если что ими оперировать
    static {
        try {


            AllStaticData.dirProfile = Files.createDirectories(Path.of(AllStaticData.firstDiskLine+"\\TimeControl\\" + LoginOfTheWorkingUser.getUserLogin()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //переопределяем директории для профля
    public static void setDir() {
        try {
            AllStaticData.dirProfile = Files.createDirectories(Path.of(AllStaticData.firstDiskLine+"\\TimeControl\\" + LoginOfTheWorkingUser.getUserLogin()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //создаем файл со списком файлов в директориях приложений пк
    public static void createListOfEXEFilesInDirectories() {

        listOfEXEFilesInDirectories = new File((AllStaticData.firstDiskLine+"\\TimeControl\\listOfEXEFilesInDirectories.txt"));
        try {
            listOfEXEFilesInDirectories.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //создаем файл со списком файлов в директориях приложений пк
    public static void createDataEXE() {

        dataEXE = new File((AllStaticData.firstDiskLine+"\\TimeControl\\dataEXE.txt"));
        try {
            dataEXE.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //создаем файл со списком приложений
    public static void createListPrograms() {

            programPC = new File((AllStaticData.firstDiskLine+"\\TimeControl\\listPrograms.txt"));
        try {
            programPC.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

        programPCPowershell = new File((AllStaticData.firstDiskLine+"\\TimeControl\\listProgramsPowershell.txt"));
        try {
            programPCPowershell.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //создаем файл со списком приложений новый для сравнения со старым
    public static void createListProgramsPowershellCompare() {

        programPCPowershellCompare = new File((AllStaticData.firstDiskLine+"\\TimeControl\\listProgramsPowershellCompare.txt"));
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


    //создаем файл со списком дисков
    public static void createListDisk() {

        diskPC = new File((AllStaticData.firstDiskLine+"\\TimeControl\\listDisk.txt"));
        try {
            diskPC.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //создаем файл со списком программ пк и их директорий
    public static void createListDirProg() {

        listDir = new File((AllStaticData.firstDiskLine+"\\TimeControl\\listDir.txt"));
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



