package sample.Модель;

import static sample.Модель.AllStaticData.login;

public class LoginOfTheWorkingUser {



    //ищем логин пользователя который сейчас в системе
    public static String getUserLogin(){

        //присваиваем строке значение логина восстановления
         AllStaticData.setLogin(AllStaticData.getUserLoginRecovery());
        //если он зашел не с восстановления то присваиваем логин с авторизации
        if (login==null){
            login= AllStaticData.getUserLoginAut();}
        //если логин до сих пор пуст то присваиваем логин с нового профиля
        if (login==null){
            login= AllStaticData.getUserLoginNewProfile();}
        return login;
    }
}
