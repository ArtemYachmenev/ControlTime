package sample.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


//создает директорию для профиля пользователя
public  class CreatingADirectory {

  //public static File   dirProfile = new File("C://dataControlTime//"+AllStaticData.getLogin());
  public static Path dirProfile;


  //создаем директории для профля
    static {
        try {
            dirProfile = Files.createDirectories(Path.of("C:\\dataControlTime\\"+LoginOfTheWorkingUser.getUserLogin()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //переопределяем директории для профля
    public static void setDir() {
        try {
            dirProfile = Files.createDirectories(Path.of("C:\\dataControlTime\\"+LoginOfTheWorkingUser.getUserLogin()));
        } catch (IOException e) {
            e.printStackTrace();
        }
   }

   public Path getDir() {
      return dirProfile;
   }


}
