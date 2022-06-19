package sample.Модель;

import sample.Контроллер.ClassesWorkingWithFXML.SettingsPane.PaneColorSet;

import java.nio.file.Files;
import java.nio.file.Path;

import static sample.Модель.AllStaticData.*;

//проверка на новых пользователей, если новый то сохраняем новые для них настройки и конфиги, грузим стандартное оформление
public class CheckingForANewUser {
    public static void CheckingForANewUser() {
        if (Files.exists(Path.of(dirProfile +
                "\\saveDown_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt"))==true){
            AllStaticData.getApp().DownloadColorApp();
            System.out.println("у профиля уже сформирована директория");
        }
        else{
            CreatingAndDeletingADirectory.setDir();
            PaneColorSet.setStandartColor();
            AllStaticData.getApp().saveUsedListNewProgr();
            GetAllProgrammPC.getAllProgramPowershall();
            GetAllProgrammPC.comparisonAllProgramPowershall();
            System.out.println("новая директория для нового пользователя");
        }

    }
}
