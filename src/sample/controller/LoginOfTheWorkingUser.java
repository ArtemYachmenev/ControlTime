package sample.controller;

public class LoginOfTheWorkingUser {
   static String login=null;



    //ищем логин пользователя который сейчас в системе
    public static String getUserLogin(){
        //присваиваем строке значение логина восстановления
         login=AllStaticData.getUserLoginRecovery();
        //если он зашел не с восстановления то присваиваем логин с авторизации
        if (login==null){
            login= AllStaticData.getUserLoginAut();}
        //если логин до сих пор пуст то присваиваем логин с нового профиля
        if (login==null){
            login= AllStaticData.getUserLoginNewProfile();}
        return login;
    }
}
