package sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubstitutingSettingsAndConfigurations {


    public void setConstConfigApp(String confApp, String settApp) {


//        //извлекаем данные из конфига для статика AllTimeConfig
//        int indexAllTimeConfig = confApp.indexOf("AllStaticData.getAllTimeConfig()");
////8 это индекс где начинается это слово
//        System.out.println(indexAllTimeConfig);
//int lastIndexAllTimeConfig=indexAllTimeConfig+"AllStaticData.getAllTimeConfig()".length()-1;
//      //  длина слова
//        System.out.println("AllStaticData.getAllTimeConfig()".length());
//        //длина вместе с началом конфига и длиной геттера
//        System.out.println(lastIndexAllTimeConfig);
//        //находим индекс значения константы
//        int indexAllTimeConfigMeaningStart = lastIndexAllTimeConfig+2 ;
//        System.out.println(indexAllTimeConfigMeaningStart);
//        System.out.println(confApp.charAt(indexAllTimeConfigMeaningStart));
//        //объявляем конечный индекс состояния
////присваиваем индексу значение
//        int  indexAllTimeConfigMeaningEnd=confApp.indexOf( " ",indexAllTimeConfigMeaningStart);
//        System.out.println(indexAllTimeConfigMeaningEnd);
//        //вырезаем состояние из строки
//        String AllTimeConfigMeaning
//                =String.valueOf(confApp.substring(indexAllTimeConfigMeaningStart,indexAllTimeConfigMeaningEnd));
//        AllStaticData.setAllTimeConfig(Boolean.valueOf(AllTimeConfigMeaning));
//
//        //извлекаем данные из конфига для статика TimeSiteProgrConfig
//        int indexTimeSiteProgrConfig = confApp.indexOf("AllStaticData.getTimeSiteProgrConfig()");
//        int lastIndexTimeSiteProgrConfig=
//                indexTimeSiteProgrConfig+"AllStaticData.getTimeSiteProgrConfig()".length()-1;
//
//        int indexTimeSiteProgrConfigMeaningStart = lastIndexTimeSiteProgrConfig+2 ;
//        int  indexTimeSiteProgrConfigMeaningEnd=confApp.indexOf( " ",indexTimeSiteProgrConfigMeaningStart);
//
//        //вырезаем состояние из строки
//        String TimeSiteProgrConfigMeaning
//                =String.valueOf(confApp.substring(indexTimeSiteProgrConfigMeaningStart,indexTimeSiteProgrConfigMeaningEnd));
//        AllStaticData.setTimeSiteProgrConfig(Boolean.valueOf(TimeSiteProgrConfigMeaning));
//
//        //извлекаем данные из конфига для статика messegeConfig
//        int indexMessegeConfig = confApp.indexOf("AllStaticData.getMessegeConfig()");
//        int lastIndexMessegeConfig=
//                indexMessegeConfig+"AllStaticData.getMessegeConfig()".length()-1;
//
//        int indexMessegeConfigMeaningStart = lastIndexMessegeConfig+2 ;
//        int  indexMessegeConfigMeaningEnd=confApp.indexOf( " ",indexMessegeConfigMeaningStart);
//
//        //вырезаем состояние из строки
//        String MessegeConfigConfigMeaning
//                =String.valueOf(confApp.substring(indexMessegeConfigMeaningStart,indexMessegeConfigMeaningEnd));
//        AllStaticData.setMessegeConfig(Boolean.valueOf(MessegeConfigConfigMeaning));

        //создаем лист со статиками конфига, не знаю как сделать так чтобы в массив вкладывались загруженные значения
        //1ый вариант
//        ArrayList<Boolean> conf=new ArrayList<>();
//        conf.add(0,AllStaticData.allTimeConfig);
//        conf.add(1,AllStaticData.TimeSiteProgrConfig);
//        conf.add(2,AllStaticData.messegeConfig);
//        conf.add(3,AllStaticData.workTimeConfig);
//        conf.add(4,AllStaticData.chillTimeConfig);
//        conf.add(5,AllStaticData.allSoundConfig);
//        //2ой вариант
//        Boolean[] b={AllStaticData.allTimeConfig,AllStaticData.TimeSiteProgrConfig,
//                AllStaticData.messegeConfig,AllStaticData.workTimeConfig,
//                AllStaticData.chillTimeConfig,AllStaticData.allSoundConfig};


        //цикл изъятия состояний статиков конфига
        for (int i = 0; i < 6; i++) {
            //извлекаем данные из конфига для статиков
            int firstIndexConfig = confApp.indexOf("AllStaticData");
            int lastIndexConfig = confApp.indexOf(" ", firstIndexConfig);
            int indexMeaningStart = lastIndexConfig + 1;
         //   System.out.println(confApp.charAt(indexMeaningStart));
            int indexConfigMeaningEnd = confApp.indexOf(" ", indexMeaningStart);
         //   System.out.println(confApp.charAt(indexConfigMeaningEnd));
            //вырезаем состояние из строки
            String ConfigMeaning
                    = String.valueOf(confApp.substring(indexMeaningStart, indexConfigMeaningEnd));
            //может в будущем найдешь как изменять значения в массивах
//b[i]=Boolean.valueOf(ConfigMeaning);
            // conf.set(i,Boolean.valueOf(ConfigMeaning));


          //  System.out.println(ConfigMeaning);

            if (i == 0) {
                AllStaticData.setAllTimeConfig(Boolean.valueOf(ConfigMeaning));
            } else if (i == 1) {
                AllStaticData.setTimeSiteProgrConfig(Boolean.valueOf(ConfigMeaning));
            } else if (i == 2) {
                AllStaticData.setMessegeConfig(Boolean.valueOf(ConfigMeaning));
            } else if (i == 3) {
                AllStaticData.setWorkTimeConfig(Boolean.valueOf(ConfigMeaning));
            } else if (i == 4) {
                AllStaticData.setChillTimeConfig(Boolean.valueOf(ConfigMeaning));
            } else if (i == 5) {
                AllStaticData.setAllSoundConfig(Boolean.valueOf(ConfigMeaning));
            }

            confApp = confApp.substring(indexConfigMeaningEnd + 1, confApp.length());
       //     System.out.println(confApp);

        }

        String sett=settApp;
        //цикл изъятия состояний настроек конфига
        for (int i = 0; i < 7; i++) {
            int firstIndexSett = settApp.indexOf("AllStaticData");
            int lastIndexSett = settApp.indexOf(" ", firstIndexSett);
            int indexMeaningStart = lastIndexSett + 1;
            System.out.println(settApp.charAt(indexMeaningStart));
            int indexSettMeaningEnd;
            String SettMeaning;

            if (i==6){
                indexSettMeaningEnd = settApp.indexOf(" ", indexMeaningStart);
                System.out.println(settApp.charAt(indexSettMeaningEnd));
                SettMeaning
                        = String.valueOf(settApp.substring(indexMeaningStart, indexSettMeaningEnd));
                System.out.println(SettMeaning);
                AllStaticData.setCheckChillSett(Boolean.valueOf(SettMeaning));

break;
            }

                 indexSettMeaningEnd = (settApp.indexOf(" A", indexMeaningStart));
                System.out.println(settApp.charAt(indexSettMeaningEnd));
                 SettMeaning
                        = String.valueOf(settApp.substring(indexMeaningStart, indexSettMeaningEnd));
                System.out.println(SettMeaning);
                if (i == 0) {
                    AllStaticData.setTextSplitChoiceMesSett(SettMeaning);
                } else if (i == 1) {
                    AllStaticData.setCheckSoundAppSett(Boolean.valueOf(SettMeaning));
                } else if (i == 2) {
                    AllStaticData.setTextChoiceInfoMesSett(SettMeaning);
                } else if (i == 3) {
                    AllStaticData.setTextsplitChoiceMesWorkSett(SettMeaning);
                } else if (i == 4) {
                    AllStaticData.setCheckWorkSett(Boolean.valueOf(SettMeaning));
                } else if (i == 5) {
                    AllStaticData.setTextsplitChoiceMesChillSett(SettMeaning);
                }


            settApp = settApp.substring(indexSettMeaningEnd + 1, settApp.length());
            System.out.println(settApp);


        }

    }
}

//                 if (i<5) {
//                 indexSettMeaningEnd = (settApp.indexOf("A", indexMeaningStart))-1;
//                System.out.println(settApp.charAt(indexSettMeaningEnd));
//                 SettMeaning
//                        = String.valueOf(settApp.substring(indexMeaningStart, indexSettMeaningEnd));
//                System.out.println(SettMeaning);
//                if (i == 0) {
//                    AllStaticData.setTextSplitChoiceMesSett(SettMeaning);
//                } else if (i == 1) {
//                    AllStaticData.setCheckSoundAppSett(Boolean.valueOf(SettMeaning));
//                } else if (i == 2) {
//                    AllStaticData.setTextChoiceInfoMesSett(SettMeaning);
//                } else if (i == 3) {
//                    AllStaticData.setTextsplitChoiceMesWorkSett(SettMeaning);
//                } else if (i == 4) {
//                    AllStaticData.setCheckWorkSett(Boolean.valueOf(SettMeaning));
//                } else if (i == 5) {
//                    AllStaticData.setTextsplitChoiceMesChillSett(SettMeaning);
//                }
//                settApp = settApp.substring(indexSettMeaningEnd + 1, settApp.length());
//
//            }
//            indexSettMeaningEnd = settApp.indexOf(" ", indexMeaningStart);
//            System.out.println(settApp.charAt(indexSettMeaningEnd));
//            SettMeaning
//                    = String.valueOf(settApp.substring(indexMeaningStart, indexSettMeaningEnd));
//            System.out.println(SettMeaning);
//                AllStaticData.setCheckChillSett(Boolean.valueOf(SettMeaning));
//
//            settApp = settApp.substring(indexSettMeaningEnd + 1, settApp.length());
//            System.out.println(settApp);