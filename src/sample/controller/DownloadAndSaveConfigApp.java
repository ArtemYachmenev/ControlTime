package sample.controller;

import sample.controller.ClassesWorkingWithFXML.SettingsPane.PaneColorSet;

import java.io.*;
import java.util.ArrayList;

//сохраняет и грузит настройки приложения
public class DownloadAndSaveConfigApp implements Serializable {

    //проверка на закрытие окон приложения не задействовано, можно потом развить
    public void checkingWindowСlosures(){

        AllStaticData.checkCloseWindow=AllStaticData.closeMain||AllStaticData.closeAuthorization||AllStaticData.closeMenu
                ||AllStaticData.closeNewProfile||AllStaticData.closePassRecovery||
        AllStaticData.closePassRecovery2||AllStaticData.closePassRecovery3||AllStaticData.closePersonalConfig
                ||AllStaticData.closeSettings||AllStaticData.closeStatistics||AllStaticData.closeStatistics7
                ||AllStaticData.closeStatistics24||AllStaticData.closeStatisticsSelectTime;
        if (AllStaticData.checkCloseWindow==true){
            //если окно закрылось вызываем сохранение настроек
            saveStaticData();
        }

    }

    //сохраняем настройки которые лежат в статиках AllStatickData
    public void saveStaticData(){
        try (FileOutputStream fs = new FileOutputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveConfig_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt");
             ObjectOutputStream os = new ObjectOutputStream(fs)) {
            //сохранение статиков конфига
            String config="config: AllStaticData.getAllTimeConfig() "+AllStaticData.getAllTimeConfig()+" AllStaticData.getTimeSiteProgrConfig() "+AllStaticData.getTimeSiteProgrConfig()+
                    " AllStaticData.getMessegeConfig() "+AllStaticData.getMessegeConfig()+" AllStaticData.getWorkTimeConfig() "+AllStaticData.getWorkTimeConfig()+
                    " AllStaticData.getChillTimeConfig() "+
                    AllStaticData.getChillTimeConfig()+" AllStaticData.getAllSoundConfig() "+AllStaticData.getAllSoundConfig();
            os.writeObject(config);
            System.out.println(config);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileOutputStream fs = new FileOutputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveSetting_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt");
             ObjectOutputStream os = new ObjectOutputStream(fs)) {
            //пишет в начале иероглифы
            String setting="setting: AllStaticData.getTextSplitChoiceMesSett() "+AllStaticData.getTextSplitChoiceMesSett()+" AllStaticData.getCheckSoundAppSett() "+
                    AllStaticData.getCheckSoundAppSett()+" AllStaticData.getTextChoiceInfoMesSett() "+
                    AllStaticData.getTextChoiceInfoMesSett()+" AllStaticData.getTextsplitChoiceMesWorkSett() "
                    +AllStaticData.getTextsplitChoiceMesWorkSett()+" AllStaticData.getCheckWorkSett() "+
                    AllStaticData.getCheckWorkSett()+" AllStaticData.getTextsplitChoiceMesChillSett() "+AllStaticData.getTextsplitChoiceMesChillSett()
                    +" AllStaticData.getCheckChillSett() "+ AllStaticData.getCheckChillSett();
            os.writeObject(setting);
            System.out.println(setting);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //загружаем цвета конфиг и настройки пользователя
    public void downloadConfigAndSetting(){
        String colorUp=null;
        String colorDown=null;
        try (FileInputStream fis = new FileInputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveConfig_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            colorUp = (String) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (FileInputStream fis = new FileInputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveSetting_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            colorDown = (String) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //загруженные цвета устанавливаем в цвет приложения


    }


    //сохраняем цвета приложения
    public void saveColorApp(String up, String down){
        try (FileOutputStream fs = new FileOutputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveUp_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt");
             ObjectOutputStream os = new ObjectOutputStream(fs)) {
            //пишет в начале иероглифы
            os.writeObject(up);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileOutputStream fs = new FileOutputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveDown_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt");
             ObjectOutputStream os = new ObjectOutputStream(fs)) {
            //пишет в начале иероглифы
            os.writeObject(down);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //загружаем цвета приложения
    public void DownloadColorApp(){
        ChangingTheAppColor color=new ChangingTheAppColor();
        String colorUp=null;
        String colorDown=null;
        try (FileInputStream fis = new FileInputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveUp_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            colorUp = (String) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (FileInputStream fis = new FileInputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\SaveConfig" +
                "AndSetting\\"+LoginOfTheWorkingUser.getUserLogin()+"\\saveDown_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            colorDown = (String) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
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
