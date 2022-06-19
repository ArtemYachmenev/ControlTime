package sample.Модель;

import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class AllStaticData {

    //статики класса GetAllProgramPC
    public static StringBuilder disk = new StringBuilder();
    public static StringBuilder program = new StringBuilder();
    public static StringBuilder dir = new StringBuilder();

    public static boolean programsHaveChanged=false;

    //статик класса MyTimer
    public  static ExecutorService executorService;
    //исполнитель запуска потоков
    public static  volatile   ExecutorService executorServiceStartTrackingTheWorkOfPrograms;
    //путь к профилю
    public static Path dirProfile;
    //файл со всеми прогрмаммами
    public static File programPC;
    // ответ на запрос о всех программах пк повершелла
    public static File programPCPowershell;
    //stroka со основным диском
    public static String firstDisk;
    //файл со всеми дисками
    public static File diskPC;
    //файл со всеми программами+листом с программами пользовтаеля
    //файл со всеми программами пк и директориями
    public static File listDir;
    //файл со всеми программами пк и директориями новый для сравнения
    public static File programPCPowershellCompare;
    //файл со всеми программами пк и директориями
    public static File listOfEXEFilesInDirectories;
    //файл с ответ на запрос о ехе в директориях
    public static File dataEXE;

    // цвет верхней и нижней панели приложения
    public static AnchorPane paneUp=new AnchorPane();
    public static AnchorPane paneDown=new AnchorPane();

    //держит в себе названия программ, если пользоваетль выбрал программы то сохр старые из загрузовчного списка
    public static StringBuilder ListUsedProgr=new StringBuilder();
    //держит в себе названия программ из пк и программ пользователя
    public static StringBuilder ListOfPrograms=new StringBuilder();

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

    //статик который вбирает первый диск для создания всех директорий
    public static String firstDiskLine;
    //статик который вбирает первый диск для создания всех директорий
    public static StringBuilder firstDiskBuilder;

    //лист для понятия работают или нет программы
    public volatile static ArrayList<String> workApp=new ArrayList<>();
    //промежуточный лист для переноса программ и их состояний в таймер
    //лист для хранения назвоний программ и количества их ехе
    public  static ArrayList<String> nameProgCountEXE=new ArrayList<>();
    //хранит в себе имя приложения и общее состояние
  //  public volatile static ArrayList<Object> goWork = new ArrayList<>();
    //хранит в себе имя приложения и общее состояние
    public volatile static  ArrayList<String> oneProgAndEXE=new ArrayList<>();
    //хранит в себе имя приложения для его отслеживания времени
    public volatile static  ArrayList<String> nameProg=new ArrayList<>();
    //хранит состояние таймера его работы
 //   public volatile static boolean workTimer=false;
    //лист для понятия для работающих exe программ чтобы потом их убить
 //   public volatile static ArrayList<String> workAppKill=new ArrayList<>();

    //тестовые значения
//лист который хранит приложения с тру, если тру нет то пишет 0
  public static volatile   ArrayList<String> listRunProg=new ArrayList<>();
    //лист который хранит приложения с тру в новой строке
    public static volatile   ArrayList<Object> listRunProg2=new ArrayList<>();
    //булеан для того чтобы при вызове потока один раз считать количество программ
    public volatile static boolean countProg=false;
    //берет и хранит количество программ
    public volatile static int countProgram=0;
    //лист который хранит приложения с тру в новой строке
    public static volatile   ArrayList<String> listRunIndex=new ArrayList<>();
    //лист который хранит актуальное состояние приложения
    public static volatile   ArrayList<String> listRunActual=new ArrayList<>();
    //булеан для того чтобы при хранить значение работает мышка или нет если да то тру
    public volatile static boolean workMouse;


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
