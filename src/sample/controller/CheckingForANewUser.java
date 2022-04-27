package sample.controller;

import sample.controller.ClassesWorkingWithFXML.SettingsPane.PaneColorSet;

import java.nio.file.Files;
import java.nio.file.Path;

//проверка на новых пользователей, если новый то сохраняем новые для них настройки и конфиги, грузим стандартное оформление
public class CheckingForANewUser {



    public static void CheckingForANewUser() {
        if (Files.exists(Path.of(CreatingAndDeletingADirectory.dirProfile +
                "\\saveConfig_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt"))==true){
            //грузим его цвета и все данные
          //  Files.isRegularFile()
            AllStaticData.getApp().DownloadColorApp();
            AllStaticData.getApp().downloadConfigAndSetting();
         //   AllStaticData.getApp().downloadListProgr();
         //   AllStaticData.getApp().downloadAListOfUsedApplications();
            System.out.println("у профиля уже сформирована директория");
        }
        else{
            CreatingAndDeletingADirectory.setDir();
            PaneColorSet.setStandartColor();
            AllStaticData.getApp().saveStaticDataForANewUser();
            AllStaticData.getApp().saveListNewProgr();
            AllStaticData.getApp().saveUsedListNewProgr();
            AllStaticData.getApp().downloadConfigAndSetting();
            System.out.println("новая директория для нового пользователя");
        }

    }
}
