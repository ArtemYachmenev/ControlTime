package sample.controller;

import sample.controller.ClassesWorkingWithFXML.SettingsPane.PaneColorSet;

import java.io.*;
import java.util.ArrayList;

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

    //сохраняем настройки которые лежат в статиках AllStatickData
    public void saveStaticData(){
        try (BufferedWriter fs = new BufferedWriter( new FileWriter( "C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveConfig_"
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
        try (BufferedWriter fs = new BufferedWriter(new FileWriter( "C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveSetting_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
             {
            //пишет в начале иероглифы
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
        try (BufferedReader fis = new BufferedReader(new FileReader( "C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveConfig_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
            {
            config = fis.readLine();
            System.out.println("download "+config);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedReader fis = new BufferedReader(new FileReader( "C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveSetting_"
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


    //сохраняем цвета приложения
    public void saveColorApp(String up, String down){
        try (BufferedWriter fs = new BufferedWriter (new FileWriter( "C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveUp_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt"))) {
            //пишет в начале иероглифы
            fs.write(up);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedWriter  fs = new BufferedWriter (new FileWriter( "C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveDown_"
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
        try (BufferedReader  fis = new BufferedReader (new FileReader( "C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveUp_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
             {
            colorUp = fis.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedReader  fis = new BufferedReader (new FileReader( "C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveDown_"
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
