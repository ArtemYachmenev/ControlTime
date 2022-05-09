package sample.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;


//создает директорию для профиля пользователя
public  class CreatingAndDeletingADirectory {

    //public static File   dirProfile = new File("C://dataControlTime//"+AllStaticData.getLogin());
    //путь к профилю
    public static Path dirProfile;
    //файл со всеми прогрмаммами
    public static File programPC;
    //файл со всеми дисками
    public static File diskPC;
    //файл со всеми программами+листом с программами пользовтаеля
    public static File generalListOfPrograms;
    //файл со всеми программами+листом с программами пользовтаеля
    public static File listDir;
   // public static File programPCAll;

    //заново присваиваем переменным пути  для профля и файла со всеми прогарммами чтобы если что ими оперировать
    static {
        try {
            dirProfile = Files.createDirectories(Path.of("C:\\dataControlTime\\" + LoginOfTheWorkingUser.getUserLogin()));
          //  programPC= Files.createDirectories(Path.of("C:\\dataControlTime\\" + "listPrograms.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //переопределяем директории для профля
    public static void setDir() {
        try {
            dirProfile = Files.createDirectories(Path.of("C:\\dataControlTime\\" + LoginOfTheWorkingUser.getUserLogin()));



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //создаем файл со списком приложений
    public static void createListPrograms() {

            programPC = new File(("C:\\dataControlTime\\listPrograms.txt"));
        try {
            programPC.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //создаем файл со списком приложений пк+ программами пользователя
    public static void createGeneralListOfPrograms() {

        generalListOfPrograms = new File((CreatingAndDeletingADirectory.dirProfile +
                "\\generalListOfPrograms_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt"));
        try {
            generalListOfPrograms.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //перезапись файла со списком приложений пк+ программами пользователя
    public static void overwritingGeneralListOfPrograms() {

        generalListOfPrograms.delete();
        createGeneralListOfPrograms();


    }

    //создаем файл со списком дисков
    public static void createListDisk() {

        diskPC = new File(("C:\\dataControlTime\\listDisk.txt"));
        try {
            diskPC.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //создаем файл со списком программ пк и их директорий
    public static void createListDirProg() {

        listDir = new File(("C:\\dataControlTime\\listDir.txt"));
        try {
            listDir.createNewFile();

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


