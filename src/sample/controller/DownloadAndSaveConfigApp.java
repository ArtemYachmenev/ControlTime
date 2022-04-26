package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.controller.ClassesWorkingWithFXML.SettingsPane.PaneColorSet;

import java.io.*;

//сохраняет и грузит настройки приложения
public class DownloadAndSaveConfigApp implements Serializable {





    //проверка на закрытие окон приложения, можно потом развить
    public void checkingWindowСlosures(){

        AllStaticData.checkCloseWindow=AllStaticData.getCloseMain()||AllStaticData.getCloseAuthorization()||AllStaticData.getCloseMenu()
                ||AllStaticData.getCloseNewProfile()||AllStaticData.getClosePassRecovery()||
        AllStaticData.getClosePassRecovery2()||AllStaticData.getClosePassRecovery3()||AllStaticData.getClosePersonalConfig()
                ||AllStaticData.getCloseSettings()||AllStaticData.getCloseStatistics()||AllStaticData.getCloseStatistics7()
                ||AllStaticData.getCloseStatistics24()||AllStaticData.getCloseStatisticsSelectTime();
        if (AllStaticData.checkCloseWindow==true){
            //если окно закрылось вызываем сохранение настроек
            saveStaticData();
        }

    }

    //сохраняем настройки которые лежат в статиках AllStaticData
    public void saveStaticData(){

        try (BufferedWriter fs = new BufferedWriter( new FileWriter( CreatingAndDeletingADirectory.dirProfile +
               "\\saveConfig_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt"))){
            //сохранение статиков конфига
            String config="config: AllStaticData.getAllTimeConfig() "+AllStaticData.getAllTimeConfig()+" AllStaticData.getTimeSiteProgrConfig() "+AllStaticData.getTimeSiteProgrConfig()+
                    " AllStaticData.getMessegeConfig() "+AllStaticData.getMessegeConfig()+" AllStaticData.getWorkTimeConfig() "+AllStaticData.getWorkTimeConfig()+
                    " AllStaticData.getChillTimeConfig() "+
                    AllStaticData.getChillTimeConfig()+" AllStaticData.getAllSoundConfig() "+AllStaticData.getAllSoundConfig()+" .";
            fs.write(config);
            System.out.println("save "+config);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedWriter fs = new BufferedWriter(new FileWriter( CreatingAndDeletingADirectory.dirProfile+"\\saveSetting_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
             {
            //сохранение настроек пользователя
            String setting="setting: AllStaticData.getTextSplitChoiceMesSett() "+AllStaticData.getTextSplitChoiceMesSett()+" AllStaticData.getCheckSoundAppSett() "+
                    AllStaticData.getCheckSoundAppSett()+" AllStaticData.getTextChoiceInfoMesSett() "+
                    AllStaticData.getTextChoiceInfoMesSett()+" AllStaticData.getTextsplitChoiceMesWorkSett() "
                    +AllStaticData.getTextsplitChoiceMesWorkSett()+" AllStaticData.getCheckWorkSett() "+
                    AllStaticData.getCheckWorkSett()+" AllStaticData.getTextsplitChoiceMesChillSett() "+AllStaticData.getTextsplitChoiceMesChillSett()
                    +" AllStaticData.getCheckChillSett() "+ AllStaticData.getCheckChillSett()+" .";
            fs.write(setting);
            System.out.println("save "+setting);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //загружаем цвета конфиг и настройки пользователя
    public void downloadConfigAndSetting(){
        String config=null;
        String setting=null;
        try (BufferedReader fis = new BufferedReader(new FileReader( CreatingAndDeletingADirectory.dirProfile+"\\saveConfig_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
            {
            config = fis.readLine();
            System.out.println("download "+config);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedReader fis = new BufferedReader(new FileReader( CreatingAndDeletingADirectory.dirProfile+"\\saveSetting_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
             {
            setting =  fis.readLine();
            System.out.println("download "+setting);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //загруженные цвета устанавливаем в конфиги и настройки
        SubstitutingSettingsAndConfigurations configurations=new SubstitutingSettingsAndConfigurations();
        configurations.setConstConfigApp(config, setting);



    }

    //сохранение приложений нового пользователя
    public void saveListNewProgr() {

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(CreatingAndDeletingADirectory.dirProfile +
                "\\saveListProgr_"
                + LoginOfTheWorkingUser.getUserLogin() + ".txt"))) {
            //сохранение статиков конфига
            String ListProgr ="";
            fs.write(ListProgr);
            System.out.println("save listProgr for new profile" + ListProgr);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //сохранение отслеживаемых приложений пользователя
    public void saveAListOfUsedApplications(String s) {

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(CreatingAndDeletingADirectory.dirProfile +
                "\\saveListUsedProgr_"
                + LoginOfTheWorkingUser.getUserLogin() + ".txt"))) {
            //сохранение статиков конфига
            String ListProgr =s;
            fs.write(ListProgr);
            System.out.println("save " + ListProgr);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //сохранение всех приложений пользователя
    public void saveListProg(StringBuilder s) {

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(CreatingAndDeletingADirectory.dirProfile +
                "\\saveListProgr_"
                + LoginOfTheWorkingUser.getUserLogin() + ".txt"))) {
            //сохранение статиков конфига
            StringBuilder ListProgr =s;
            fs.write(String.valueOf(ListProgr));
            System.out.println("save \n" + ListProgr);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //загрузка приложений пользователя
    public ObservableList<String> downloadListProgr() {
        String list="";
        ObservableList<String> progr = FXCollections.observableArrayList();

        int count=0;

        //считаем сколько строк
        try (BufferedReader fis = new BufferedReader(new FileReader( CreatingAndDeletingADirectory.dirProfile+"\\saveListProgr_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
        {

            while (list!=null){
                list =  fis.readLine();
                count++;
                System.out.println(count+"//////////////////////");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//читаем нужное количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader( CreatingAndDeletingADirectory.dirProfile+"\\saveListProgr_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
        {


            //   list =  fis.readLine();
            for  (int i=0;i<count-1;i++) {
                if (i==(count-2)){
                    list =  fis.readLine();

                    progr.add(i,list);
                    break;
                }
                list =  fis.readLine();

progr.add(i,list);
            }
            //  progr= FXCollections.observableArrayList(list);
           // progr= FXCollections.observableArrayList(builder.toString());

            System.out.println("download list \n"+progr);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

return  progr;
    }







    //сохраняем настройки которые лежат в статиках AllStaticData для нового профиля
    public void saveStaticDataForANewUser(){
//конфиг н пользователя
        try (BufferedWriter fs = new BufferedWriter( new FileWriter( CreatingAndDeletingADirectory.dirProfile +
                "\\saveConfig_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt"))){
            //сохранение статиков конфига
            String config="config: AllStaticData.getAllTimeConfig() "+false+" AllStaticData.getTimeSiteProgrConfig() "+false+
                    " AllStaticData.getMessegeConfig() "+false+" AllStaticData.getWorkTimeConfig() "+false+
                    " AllStaticData.getChillTimeConfig() "+
                    false+" AllStaticData.getAllSoundConfig() "+false+" .";
            fs.write(config);
            System.out.println("save "+config);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedWriter fs = new BufferedWriter(new FileWriter( CreatingAndDeletingADirectory.dirProfile+"\\saveSetting_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
        {
            //сохранение настроек пользователя
            String setting="setting: AllStaticData.getTextSplitChoiceMesSett() "+"Вариант вывода уведомлений"+" AllStaticData.getCheckSoundAppSett() "+
                    false+" AllStaticData.getTextChoiceInfoMesSett() "+
                    "Вариант информации в уведомлении"+" AllStaticData.getTextsplitChoiceMesWorkSett() "
                    +"Таймер работы"+" AllStaticData.getCheckWorkSett() "+
                    false+" AllStaticData.getTextsplitChoiceMesChillSett() "+"Таймер перерыва"
                    +" AllStaticData.getCheckChillSett() "+ false+" .";
            fs.write(setting);
            System.out.println("save "+setting);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //создание документа для хранения программ пользователя
        try (BufferedWriter fs = new BufferedWriter( new FileWriter( CreatingAndDeletingADirectory.dirProfile +
                "\\saveListProgr_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt"))){
            //сохранение статиков конфига
            String ListProgr="list: ";
            fs.write(ListProgr);
            System.out.println("save "+ListProgr);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    //сохраняем цвета приложения
    public void saveColorApp(String up, String down){
        try (BufferedWriter fs = new BufferedWriter (new FileWriter( CreatingAndDeletingADirectory.dirProfile+"\\saveUp_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt"))) {
            //пишет в начале иероглифы
            fs.write(up);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedWriter  fs = new BufferedWriter (new FileWriter( CreatingAndDeletingADirectory.dirProfile+"\\saveDown_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
              {
            //пишет в начале иероглифы
            fs.write(down);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //загружаем цвета приложения
    public void DownloadColorApp(){
        ChangingTheAppColor color=new ChangingTheAppColor();
        String colorUp=null;
        String colorDown=null;
        try (BufferedReader  fis = new BufferedReader (new FileReader( CreatingAndDeletingADirectory.dirProfile+"\\saveUp_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
             {
            colorUp = fis.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedReader  fis = new BufferedReader (new FileReader( CreatingAndDeletingADirectory.dirProfile+"\\saveDown_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
              {
            colorDown =  fis.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //загруженные цвета устанавливаем в цвет приложения
        color.changeColorApp(colorUp,colorDown);

    }

    //ставим стандартные цвета
    public void downloadStandartColorApp(){
        PaneColorSet.setStandartColor();
    }
}
