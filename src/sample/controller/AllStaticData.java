package sample.controller;

public class AllStaticData {
    //используется для запомиания логина в авторизации
    public static String userLoginAut=null;



    //используется для запоминания имени секрета и ответа в восставновлении 1
    public static String userLoginRecovery=null;
    public static String userSecretRecovery=null;
    public static String userAnswerRecovery=null;

    //используется для хранения значения включения или выключения приложения в меню
    public static boolean OnOrOffAppButtonMenu=false;

    //сохранение состояний чекбоксов персонального конфига
    public static boolean allTimeConfig=false;
    public static boolean TimeSiteProgrConfig=false;
    public static boolean messegeConfig=false;
    public static boolean workTimeConfig=false;
    public static boolean chillTimeConfig=false;
    public static boolean allSoundConfig=false;

    //держание цветов приложения
    public static String colorUpApp=null;
    public static String colorDownApp=null;


    //сохранение настроек пользователя
    public void saveConfigsProfile(){

    }

    public static boolean getAllTimeConfig() {
        return allTimeConfig;
    }

    public static void setAllTimeConfig(boolean allTimeConfig) {
        AllStaticData.allTimeConfig = allTimeConfig;
    }

    public static boolean getTimeSiteProgrConfig() {
        return TimeSiteProgrConfig;
    }

    public static void setTimeSiteProgrConfig(boolean timeSiteProgrConfig) {
        TimeSiteProgrConfig = timeSiteProgrConfig;
    }

    public static boolean getMessegeConfig() {
        return messegeConfig;
    }

    public static void setMessegeConfig(boolean messegeConfig) {
        AllStaticData.messegeConfig = messegeConfig;
    }

    public static boolean getWorkTimeConfig() {
        return workTimeConfig;
    }

    public static void setWorkTimeConfig(boolean workTimeConfig) {
        AllStaticData.workTimeConfig = workTimeConfig;
    }

    public static boolean getChillTimeConfig() {
        return chillTimeConfig;
    }

    public static void setChillTimeConfig(boolean chillTimeConfig) {
        AllStaticData.chillTimeConfig = chillTimeConfig;
    }

    public static boolean getAllSoundConfig() {
        return allSoundConfig;
    }

    public static void setAllSoundConfig(boolean allSoundConfig) {
        AllStaticData.allSoundConfig = allSoundConfig;
    }

    public static String getUserLoginNewProfile() {
        return userLoginNewProfile;
    }

    public static void setUserLoginNewProfile(String userLoginNewProfile) {
        AllStaticData.userLoginNewProfile = userLoginNewProfile;
    }

    //используется для запоминания логина при создании профиля
    public static String userLoginNewProfile=null;

    public static boolean getOnOrOffAppButtonMenu() {
        return OnOrOffAppButtonMenu;
    }

    public static void setOnOrOffAppButtonMenu(boolean onOrOffAppButtonMenu) {
        OnOrOffAppButtonMenu = onOrOffAppButtonMenu;
    }

    public static String getUserLoginRecovery() {
        return userLoginRecovery;
    }

    public static void setUserLoginRecovery(String userLoginRecovery) {
        AllStaticData.userLoginRecovery = userLoginRecovery;
    }

    public static String getUserSecretRecovery() {
        return userSecretRecovery;
    }

    public static void setUserSecretRecovery(String userSecretRecovery) {
        AllStaticData.userSecretRecovery = userSecretRecovery;
    }

    public static String getUserAnswerRecovery() {
        return userAnswerRecovery;
    }

    public static void setUserAnswerRecovery(String userAnswerRecovery) {
        AllStaticData.userAnswerRecovery = userAnswerRecovery;
    }



    public static String getUserLoginAut() {
        return userLoginAut;
    }

    public static void setUserLoginAut(String userLoginAut) {
        AllStaticData.userLoginAut = userLoginAut;
    }


}
