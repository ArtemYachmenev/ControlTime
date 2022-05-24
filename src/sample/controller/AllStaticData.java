package sample.controller;

import javafx.scene.layout.AnchorPane;

public class AllStaticData {


    // цвет верхней и нижней панели приложения
    public static AnchorPane paneUp=new AnchorPane();
    public static AnchorPane paneDown=new AnchorPane();

    //public static int countLinesListProgr=0;
    //держит в себе названия программ, если пользоваетль не выбрал программы то сохр старые из загрузовчного списка
    public static StringBuilder ListAllProgr=new StringBuilder();
    //держит в себе названия программ, если пользоваетль выбрал программы то сохр старые из загрузовчного списка
    public static StringBuilder ListUsedProgr=new StringBuilder();
    //держит в себе названия программ из пк и программ пользователя
    public static StringBuilder GeneralListOfPrograms=new StringBuilder();

    // логин пользователя который опряделяется в LoginOfTheWorkingUser
    //при использовании LoginOfTheWorkingUser он начинает носить его логин
   public static String login=null;



    //переменная для вызова сохранения
    public static   DownloadAndSaveConfigApp  app=new DownloadAndSaveConfigApp();

    //используется для запомиания логина в авторизации
    public static String userLoginAut=null;



    //используется для запоминания имени секрета и ответа в восставновлении 1
    public static String userLoginRecovery=null;
    public static String userSecretRecovery=null;
    public static String userAnswerRecovery=null;

    //используется для хранения значения включения или выключения приложения в меню
    public static volatile boolean  OnOrOffAppButtonMenu=false;

    //сохранение состояний чекбоксов персонального конфига
    public static boolean allTimeConfig=false;
    public static boolean TimeSiteProgrConfig=false;
    public static boolean messegeConfig=false;
    public static boolean workTimeConfig=false;
    public static boolean chillTimeConfig=false;
    public static boolean allSoundConfig=false;

    //сохранение состояний чекбоксов и выдвижных предложений персональных настроек
    public static String textChoiceInfoMesSett=new String("Вариант информации в уведомлении");
    public static boolean checkSoundAppSett=false;
    public static String textSplitChoiceMesSett=new String("Выберите вариант вывода уведомлений");
    public static String textsplitChoiceMesWorkSett=new String("Выберите таймер работы");
    public static String textsplitChoiceMesChillSett=new String("Выберите таймер отдыха");
    public static boolean checkWorkSett=false;
    public static boolean checkChillSett=false;


    //держание цветов приложения не используется (возможна модификация)
    public static String colorUpApp=null;
    public static String colorDownApp=null;


    //переменные которые мониторят закрытие приложения.
    // если они станут тру, то должно запускаться сохранение чекбоксов и при загрузке прил должно загр их состояние
    public static boolean closeMain=false;
    public static boolean closeAuthorization=false;
    public static boolean closeMenu=false;
    public static boolean closeNewProfile=false;
    public static boolean closePassRecovery=false;
    public static boolean closePassRecovery2=false;
    public static boolean closePassRecovery3=false;
    public static boolean closePersonalConfig=false;
    public static boolean closeSettings=false;
    public static boolean closeStatistics=false;
    public static boolean closeStatistics7=false;
    public static boolean closeStatistics24=false;
    public static boolean closeStatisticsSelectTime=false;

    //статик который вбирает одно закрытое окно и запускает сохранение конфига и настроек
    public static boolean checkCloseWindow=false;

    public static AnchorPane getPaneUp() {
        return paneUp;
    }

    public static void setPaneUp(AnchorPane paneUp) {
        AllStaticData.paneUp = paneUp;
    }

    public static AnchorPane getPaneDown() {
        return paneDown;
    }

    public static void setPaneDown(AnchorPane paneDown) {
        AllStaticData.paneDown = paneDown;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        AllStaticData.login = login;
    }

    public static DownloadAndSaveConfigApp getApp() {
        return app;
    }

    public static void setApp(DownloadAndSaveConfigApp app) {
        AllStaticData.app = app;
    }

    public static String getTextsplitChoiceMesWorkSett() {
        return textsplitChoiceMesWorkSett;
    }

    public static void setTextsplitChoiceMesWorkSett(String textsplitChoiceMesWorkSett) {
        AllStaticData.textsplitChoiceMesWorkSett = textsplitChoiceMesWorkSett;
    }

    public static String getTextsplitChoiceMesChillSett() {
        return textsplitChoiceMesChillSett;
    }

    public static void setTextsplitChoiceMesChillSett(String textsplitChoiceMesChillSett) {
        AllStaticData.textsplitChoiceMesChillSett = textsplitChoiceMesChillSett;
    }

    public static boolean getCheckWorkSett() {
        return checkWorkSett;
    }

    public static void setCheckWorkSett(boolean checkWorkSett) {
        AllStaticData.checkWorkSett = checkWorkSett;
    }

    public static boolean getCheckChillSett() {
        return checkChillSett;
    }

    public static void setCheckChillSett(boolean checkChillSett) {
        AllStaticData.checkChillSett = checkChillSett;
    }

    public static boolean getCheckSoundAppSett() {
        return checkSoundAppSett;
    }

    public static void setCheckSoundAppSett(boolean checkSoundAppSett) {
        AllStaticData.checkSoundAppSett = checkSoundAppSett;
    }

    public static String getTextSplitChoiceMesSett() {
        return textSplitChoiceMesSett;
    }

    public static void setTextSplitChoiceMesSett(String textSplitChoiceMesSett) {
        AllStaticData.textSplitChoiceMesSett = textSplitChoiceMesSett;
    }

    public static String getTextChoiceInfoMesSett() {
        return textChoiceInfoMesSett;
    }

    public static void setTextChoiceInfoMesSett(String textChoiceInfoMesSett) {
        AllStaticData.textChoiceInfoMesSett = textChoiceInfoMesSett;
    }

    public static boolean getCloseMain() {
        return closeMain;
    }

    public static void setCloseMain(boolean closeMain) {
        AllStaticData.closeMain = closeMain;
    }


    public static boolean getCloseAuthorization() {
        return closeAuthorization;
    }

    public static void setCloseAuthorization(boolean closeAuthorization) {
        AllStaticData.closeAuthorization = closeAuthorization;
    }

    public static boolean getCloseMenu() {
        return closeMenu;
    }

    public static void setCloseMenu(boolean closeMenu) {
        AllStaticData.closeMenu = closeMenu;
    }

    public static boolean getCloseNewProfile() {
        return closeNewProfile;
    }

    public static void setCloseNewProfile(boolean closeNewProfile) {
        AllStaticData.closeNewProfile = closeNewProfile;
    }

    public static boolean getClosePassRecovery() {
        return closePassRecovery;
    }

    public static void setClosePassRecovery(boolean closePassRecovery) {
        AllStaticData.closePassRecovery = closePassRecovery;
    }

    public static boolean getClosePassRecovery2() {
        return closePassRecovery2;
    }

    public static void setClosePassRecovery2(boolean closePassRecovery2) {
        AllStaticData.closePassRecovery2 = closePassRecovery2;
    }

    public static boolean getClosePassRecovery3() {
        return closePassRecovery3;
    }

    public static void setClosePassRecovery3(boolean closePassRecovery3) {
        AllStaticData.closePassRecovery3 = closePassRecovery3;
    }

    public static boolean getClosePersonalConfig() {
        return closePersonalConfig;
    }

    public static void setClosePersonalConfig(boolean closePersonalConfig) {
        AllStaticData.closePersonalConfig = closePersonalConfig;
    }

    public static boolean getCloseSettings() {
        return closeSettings;
    }

    public static void setCloseSettings(boolean closeSettings) {
        AllStaticData.closeSettings = closeSettings;
    }

    public static boolean getCloseStatistics() {
        return closeStatistics;
    }

    public static void setCloseStatistics(boolean closeStatistics) {
        AllStaticData.closeStatistics = closeStatistics;
    }

    public static boolean getCloseStatistics7() {
        return closeStatistics7;
    }

    public static void setCloseStatistics7(boolean closeStatistics7) {
        AllStaticData.closeStatistics7 = closeStatistics7;
    }

    public static boolean getCloseStatistics24() {
        return closeStatistics24;
    }

    public static void setCloseStatistics24(boolean closeStatistics24) {
        AllStaticData.closeStatistics24 = closeStatistics24;
    }

    public static boolean getCloseStatisticsSelectTime() {
        return closeStatisticsSelectTime;
    }

    public static void setCloseStatisticsSelectTime(boolean closeStatisticsSelectTime) {
        AllStaticData.closeStatisticsSelectTime = closeStatisticsSelectTime;
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
