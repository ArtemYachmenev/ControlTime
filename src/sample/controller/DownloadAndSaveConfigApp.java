package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.controller.ClassesWorkingWithFXML.SettingsPane.PaneColorSet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

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
            fs.flush();
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
                 fs.flush();
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
                + LoginOfTheWorkingUser.getUserLogin() + ".txt",StandardCharsets.UTF_16LE))) {
            //сохранение статиков конфига
            String ListProgr ="";
            fs.write(ListProgr);
            System.out.println("save all listProgr for new profile" + ListProgr);
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //сохранение выбранных приложений нового пользователя
    public void saveUsedListNewProgr() {

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(CreatingAndDeletingADirectory.dirProfile +
                "\\saveListUsedProgr_"
                + LoginOfTheWorkingUser.getUserLogin() + ".txt",StandardCharsets.UTF_16LE))) {
            //сохранение статиков конфига
            String ListProgr ="";
            fs.write(ListProgr);
            System.out.println("save used listProgr for new profile" + ListProgr);
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //сохранение отслеживаемых приложений пользователя без перезаписи
    public void saveAListOfUsedApplicationsOverwriting(StringBuilder s) {

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(CreatingAndDeletingADirectory.dirProfile +
                "\\saveListUsedProgr_"
                + LoginOfTheWorkingUser.getUserLogin() + ".txt",StandardCharsets.UTF_16LE))) {
            //сохранение текста новым билдером
            StringBuilder ListProgr =s;

            fs.write(String.valueOf(ListProgr));
            System.out.println("save used list \n" + ListProgr);
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //сохранение отслеживаемых приложений пользователя c перезаписью файла
    public void saveAListOfUsedApplications(StringBuilder s) {

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(CreatingAndDeletingADirectory.dirProfile +
                "\\saveListUsedProgr_"
                + LoginOfTheWorkingUser.getUserLogin() + ".txt",true))) {
            //сохранение текста новым билдером
            StringBuilder ListProgr =s;

            fs.write(String.valueOf(ListProgr));
            System.out.println("save used list \n" + ListProgr);
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }



    //загрузка отслеживаемых приложений пользователя
    public ObservableList<String> downloadAListOfUsedApplications() {

        String list="";
        ObservableList<String> progr = FXCollections.observableArrayList();

        int countLinesListProgr=0;

        //считаем сколько строк
        try (BufferedReader fis = new BufferedReader(new FileReader( CreatingAndDeletingADirectory.dirProfile+"\\saveListUsedProgr_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt",StandardCharsets.UTF_16LE)))
        {
            //если в списке что то есть то чистим для загрузки сохраненных приложений
            if (!AllStaticData.ListUsedProgr.isEmpty())
            {
                AllStaticData.ListUsedProgr.setLength(0);
            }
            while (list!=null){
                list =  fis.readLine();
                countLinesListProgr++;
                System.out.println(countLinesListProgr+" стролько строк");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//читаем нужное количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader( CreatingAndDeletingADirectory.dirProfile+"\\saveListUsedProgr_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt",StandardCharsets.UTF_16LE)))
        {

            //   list =  fis.readLine();
            //тк последняя строка то всего нормальных строк -1


            // раньше было i==(countLinesListProgr-2), тем самым не выгружали пустую строку




            for  (int i=0;i<countLinesListProgr-1;i++) {
                if (i==(countLinesListProgr-1)){
                    list =  fis.readLine();


                    progr.add(i,list);

                    AllStaticData.ListUsedProgr.append(list);

                    break;
                }
                list =  fis.readLine();


                //нe пропускает пустые строки
               // if (!list.equals(null) && !list.equals("") && !list.equals(" ")&& !list.equals("\\s")) {
                    progr.add(i, list);
                    AllStaticData.ListUsedProgr.append(list).append("\n");
              //  }

            }
            //  progr= FXCollections.observableArrayList(list);
            // progr= FXCollections.observableArrayList(builder.toString());

            System.out.println("download used list \n"+progr);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedReader  fis = new BufferedReader (new FileReader( "C:\\dataControlTime\\listPrograms.txt")))
        {
            StringBuilder listPrograms=new StringBuilder();

            String line=new String();
            while ((line = fis.readLine()) != null) {
                listPrograms.append(line+"\n");


            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(AllStaticData.ListUsedProgr+" загружаются используемые программмы из загрузовчного списка");
        return  progr;
    }


    //сохранение всех приложений пользователя без перезаписи
    public void saveListProg(StringBuilder s) {

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(CreatingAndDeletingADirectory.dirProfile +
                "\\saveListProgr_"
                + LoginOfTheWorkingUser.getUserLogin() + ".txt", true))) {
            //присваеивание текста новым билдером
            StringBuilder ListProgr =s;

            fs.write(String.valueOf(ListProgr));
            System.out.println("save all list \n" + ListProgr);
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //сохранение всех приложений пользователя с перезаписью
    public void saveListProgOverwriting(StringBuilder s) {

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(CreatingAndDeletingADirectory.dirProfile +
                "\\saveListProgr_"
                + LoginOfTheWorkingUser.getUserLogin() + ".txt",StandardCharsets.UTF_16LE))) {
            //присваеивание текста новым билдером
            StringBuilder ListProgr =s;

            fs.write(String.valueOf(ListProgr));
            System.out.println("save all list \n" + ListProgr);
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //сохранение всех приложений пользователя
    public void saveGeneralListOfPrograms(StringBuilder s) {

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(CreatingAndDeletingADirectory.dirProfile +
                "\\generalListOfPrograms_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt"))) {
            //присваеивание текста новым билдером
            StringBuilder ListProgr =s;

            fs.write(String.valueOf(ListProgr));
            System.out.println("save all list \n" + ListProgr);
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //загрузка приложений пользователя
    public ObservableList<String> downloadListProgr() {
        String list="";
        ObservableList<String> progr = FXCollections.observableArrayList();

        int countLinesListProgr=0;

        //считаем сколько строк
        try (BufferedReader fis = new BufferedReader(new FileReader( CreatingAndDeletingADirectory.dirProfile+"\\saveListProgr_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt",StandardCharsets.UTF_16LE)))
        {
            //если в списке что то есть то чистим для загрузки сохраненных приложений
            if (!AllStaticData.ListAllProgr.isEmpty())
            {
                AllStaticData.ListAllProgr.setLength(0);
            }
            while (list!=null){
                list =  fis.readLine();


                countLinesListProgr++;
                System.out.println(countLinesListProgr+" стролько строк");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//читаем нужное количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader( CreatingAndDeletingADirectory.dirProfile+"\\saveListProgr_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt",StandardCharsets.UTF_16LE)))
        {



            //   list =  fis.readLine();
            //тк последняя строка то всего нормальных строк -1
            for  (int i=0;i<countLinesListProgr-1;i++) {
                if (i==(countLinesListProgr-1)){
                    list =  fis.readLine();


                    progr.add(i,list);

                    AllStaticData.ListAllProgr.append(list);

                    break;
                }
                list =  fis.readLine();

    progr.add(i, list);
    AllStaticData.ListAllProgr.append(list).append("\n");

            }
            //  progr= FXCollections.observableArrayList(list);
           // progr= FXCollections.observableArrayList(builder.toString());

            System.out.println("download list \n"+progr);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(AllStaticData.ListAllProgr+" загружаются программмы из загрузовчного списка");
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
            fs.flush();
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
            fs.flush();
            System.out.println("save "+setting);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //создание документа для хранения программ пользователя
        try (BufferedWriter fs = new BufferedWriter( new FileWriter( CreatingAndDeletingADirectory.dirProfile +
                "\\saveListProgr_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt",StandardCharsets.UTF_16))){
            //сохранение статиков конфига
            String ListProgr="list: ";
            fs.write(ListProgr);
            System.out.println("save "+ListProgr);
            fs.flush();
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
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedWriter  fs = new BufferedWriter (new FileWriter( CreatingAndDeletingADirectory.dirProfile+"\\saveDown_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
              {
            //пишет в начале иероглифы
            fs.write(down);
                  fs.flush();
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


    //сохранение списка программ пк
    public void saveAllProgrammPC(StringBuilder listProgramPC){
      // CreatingAndDeletingADirectory.overwritingListProgramsPowershell();

        try (BufferedWriter fs = new BufferedWriter(new FileWriter("C:\\dataControlTime\\listPrograms.txt",StandardCharsets.UTF_16LE))) {
            //присваеивание текста новым билдером
            StringBuilder ListProgr =listProgramPC;
       //     System.out.println(ListProgr);

            fs.write(String.valueOf(ListProgr));

fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //сохранение списка программ пк
    public void saveDirProgrammPC(StringBuilder listDirProgramPC){
        // CreatingAndDeletingADirectory.overwritingListProgramsPowershell();

        try (BufferedWriter fs = new BufferedWriter(new FileWriter("C:\\dataControlTime\\listDir.txt",StandardCharsets.UTF_16LE))) {
            //присваеивание текста новым билдером
            StringBuilder ListDir =listDirProgramPC;
            //     System.out.println(ListProgr);

            fs.write(String.valueOf(ListDir));

            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    //загрузка списка директорий программ пк
    public StringBuilder downloadDirProgrammPC(){
        // CreatingAndDeletingADirectory.overwritingListProgramsPowershell();

        StringBuilder builder = new StringBuilder();


        int count = 0;

        String list = "";
        //читаем количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader("C:\\dataControlTime\\listDir.txt",StandardCharsets.UTF_16LE))) {
            while (list != null) {
                list = fis.readLine();
               builder.append(list+"\n");
               // System.out.println(count + " стролько строк");

            }

            //   System.out.println(builder);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
return builder;
    }



    //сохранение нового списка программ пк
    public void saveNewAllProgrammPC(){
        // CreatingAndDeletingADirectory.overwritingListProgramsPowershell();

        String s="";
        try (BufferedWriter fs = new BufferedWriter(new FileWriter("C:\\dataControlTime\\listPrograms.txt",StandardCharsets.UTF_16))) {
            //присваеивание текста новым билдером

            //     System.out.println(ListProgr);

            fs.write(String.valueOf(s));

            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //сохранение нового списка программ пк
    public void saveNewAListDirProg(){
        // CreatingAndDeletingADirectory.overwritingListProgramsPowershell();

        String s="";
        try (BufferedWriter fs = new BufferedWriter(new FileWriter("C:\\dataControlTime\\listDir.txt",StandardCharsets.UTF_16))) {
            //присваеивание текста новым билдером

            //     System.out.println(ListProgr);

            fs.write(String.valueOf(s));

            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }



    //сохранение нового списка программ пк и пользователя
    public void saveNewGeneralListOfPrograms(){
        try (BufferedWriter fs = new BufferedWriter(new FileWriter(CreatingAndDeletingADirectory.dirProfile +
                "\\generalListOfPrograms_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt",StandardCharsets.UTF_16LE))) {
            //сохранение статиков конфига
            String ListProgr ="";
            fs.write(ListProgr);
          //  System.out.println("save used listProgr for new profile" + ListProgr);
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //сохранение списка дисков пк
    public void saveAllDiskPC(StringBuilder listDiskPC){
        try (BufferedWriter fs = new BufferedWriter(new FileWriter("C:\\dataControlTime\\listDisk.txt",StandardCharsets.UTF_16LE))) {
            //присваеивание текста новым билдером
            StringBuilder ListDisk =listDiskPC;

            fs.write(String.valueOf(ListDisk));

            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //сохранение списка дисков пк
    public void saveDir(StringBuilder builder){
        try (BufferedWriter fs = new BufferedWriter(new FileWriter("C:\\dataControlTime\\listDir.txt"))) {
            //присваеивание текста новым билдером


            fs.write(String.valueOf(builder));

            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //сохранение списка дисков пк
    public void saveListOfEXEFilesInDirectories(StringBuilder listDiskPC){
        try (BufferedWriter fs = new BufferedWriter(new FileWriter("C:\\dataControlTime\\listOfEXEFilesInDirectories.txt",StandardCharsets.UTF_16LE))) {
            //присваеивание текста новым билдером
            StringBuilder ListDisk =listDiskPC;

            fs.write(String.valueOf(ListDisk));

            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //загрузка списка дисков пк
    public StringBuilder downloadAllDiskPC() {
        String s="";

        StringBuilder list=new StringBuilder();
        try (BufferedReader  fis = new BufferedReader (new FileReader( "C:\\dataControlTime\\listDisk.txt", StandardCharsets.UTF_16LE)))
        {


            while (s != null) {
                s = fis.readLine();
                list.append(s+"\n");


            }
          //  System.out.println(list);



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }



    //грузим лист программ пк из повершелла
    public StringBuilder downloadAllProgramPCPowershell() {
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1=new StringBuilder();

        int count = 0;

        String list = "";
        //читаем количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader(CreatingAndDeletingADirectory.programPCPowershell, StandardCharsets.UTF_16LE))) {
            while (list != null) {
                list = fis.readLine();
                count++;
              //  System.out.println(count + " стролько строк");

            }

            //   System.out.println(builder);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //читаем нужное количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader(CreatingAndDeletingADirectory.programPCPowershell, StandardCharsets.UTF_16LE))) {

            //отсекаем лишние строки, при ответе повершелла их 8
            for (int i = 0; i < count - 1; i++) {
                if (i == (count - 8)) {
                    list = fis.readLine();


                    builder.append(list + "\n");


                    break;
                }
                list = fis.readLine();

                builder.append(list + "\n");

             //   System.out.println(builder);

            }

            //читстим билдер от одинаковых программ


            ArrayList<String> cleanListBuilder = new ArrayList<>();
            // держит в себе билдер с приложениями
            String[] lines = builder.toString().split("\\n");
            //удаляем дубликаты
            Set<String> set = new HashSet<String>(Arrays.asList(lines));
            String[] result = set.toArray(new String[set.size()]);

            //присваиваем листам значения массивов
            for (String l : result) {
             //   cleanListBuilder.add(l);
                //  System.out.println(list+" лист использования");
                builder1.append(l + "\n");
            }
//            for (int o=0;o<cleanListBuilder.size();o++) {
//                builder1.append(cleanListBuilder.get(o) + "\n");
//
//            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //  System.out.println(builder);
        return builder1;
    }


    //грузим старый  лист программ пк из повершелла БЕЗ ИЗМЕНЕНИЙ И ФИЛЬТРА который был сформирован при создании профиля
    public StringBuilder downloadOldAllProgramPCPowershell() {
        String s="";

        StringBuilder list=new StringBuilder();
        try (BufferedReader  fis = new BufferedReader (new FileReader( CreatingAndDeletingADirectory.programPCPowershell, StandardCharsets.UTF_16LE)))
        {


            while (s != null) {
                s = fis.readLine();
                list.append(s+"\n");


            }
            //  System.out.println(list);



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //грузим старый  лист программ пк из повершелла БЕЗ ИЗМЕНЕНИЙ И ФИЛЬТРА который был сформирован при создании профиля
    public StringBuilder downloadNewAllProgramPCPowershell() {
        String s="";

        StringBuilder list=new StringBuilder();
        try (BufferedReader  fis = new BufferedReader (new FileReader( CreatingAndDeletingADirectory.programPCPowershellCompare, StandardCharsets.UTF_16LE)))
        {


            while (s != null) {
                s = fis.readLine();
                list.append(s+"\n");


            }
            //  System.out.println(list);



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    //грузим лист программ пк c директориями из повершелла
    public StringBuilder downloadAllProgramPowershellDirectory() {
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1=new StringBuilder();

        int count = 0;

        String list = "";
        //читаем количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader(CreatingAndDeletingADirectory.listDir, StandardCharsets.UTF_16LE))) {
            while (list != null) {
                list = fis.readLine();
                count++;
                //  System.out.println(count + " стролько строк");

            }

            //   System.out.println(builder);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //читаем нужное количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader(CreatingAndDeletingADirectory.listDir, StandardCharsets.UTF_16LE))) {

            //отсекаем лишние строки, при ответе повершелла их 8
            for (int i = 0; i < count - 1; i++) {
                if (i == (count - 8)) {
                    list = fis.readLine();


                    builder.append(list + "\n");


                    break;
                }
                list = fis.readLine();

                builder.append(list + "\n");

                //   System.out.println(builder);

            }

            //читстим билдер от одинаковых программ


            ArrayList<String> cleanListBuilder = new ArrayList<>();
            // держит в себе билдер с приложениями
            String[] lines = builder.toString().split("\\n");
            //удаляем дубликаты
            Set<String> set = new HashSet<String>(Arrays.asList(lines));
            String[] result = set.toArray(new String[set.size()]);

            //присваиваем листам значения массивов
            for (String l : result) {
                //   cleanListBuilder.add(l);
                //  System.out.println(list+" лист использования");
                builder1.append(l + "\n");
            }
//            for (int o=0;o<cleanListBuilder.size();o++) {
//                builder1.append(cleanListBuilder.get(o) + "\n");
//
//            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //  System.out.println(builder);
        return builder1;
    }


        //объединение списка программ пользователя и пк
    public void addingPcProgramsToTheListOfUsedPrograms(){

        StringBuilder listPrograms=new StringBuilder();

        String line=new String();




        try (BufferedReader  fis = new BufferedReader (new FileReader( CreatingAndDeletingADirectory.dirProfile+"\\saveListProgr_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt",StandardCharsets.UTF_16LE)))
        {
            while ((line = fis.readLine()) != null) {
                listPrograms.append(line+"\n");


            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedReader  fis = new BufferedReader (new FileReader( "C:\\dataControlTime\\listPrograms.txt", StandardCharsets.UTF_16LE)))
        {
            while ((line = fis.readLine()) != null) {
                listPrograms.append(line+"\n");


            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



        //если в файле что то есть то перезаписываем его
        try (BufferedReader  fis = new BufferedReader (new FileReader( CreatingAndDeletingADirectory.dirProfile +
                "\\generalListOfPrograms_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
        {
            if (( fis.readLine()) != null) {
                CreatingAndDeletingADirectory.overwritingGeneralListOfPrograms();


            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(CreatingAndDeletingADirectory.dirProfile +
                "\\generalListOfPrograms_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt",StandardCharsets.UTF_16LE))) {
            //присваеивание текста новым билдером



            fs.write(String.valueOf(listPrograms));
          //  System.out.println("save all list \n" + ListProgr);
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    //загрузка отслеживаемых приложений пользователя из общего списка
    public ObservableList<String> downloadListProgr2() {
        //если нет общего файла со списком приложений пк и пользователя то создаем его
        CreatingAndDeletingADirectory.createGeneralListOfPrograms();

        String list="";
        ObservableList<String> progr = FXCollections.observableArrayList();



        try (BufferedReader  fis = new BufferedReader (new FileReader( CreatingAndDeletingADirectory.dirProfile +
                "\\generalListOfPrograms_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
        {
            StringBuilder listPrograms=new StringBuilder();

            String line=new String();

            while ((line = fis.readLine()) != null) {
                progr.add(line);
                AllStaticData.ListAllProgr.append(line+"\n");


            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return  progr;
    }

    public ObservableList<String> downloadListProgr3() {
        String list="";
        ObservableList<String> progr = FXCollections.observableArrayList();

        int countLinesListProgr=0;

        //считаем сколько строк
        try (BufferedReader fis = new BufferedReader(new FileReader( CreatingAndDeletingADirectory.dirProfile +
                "\\generalListOfPrograms_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
        {
            //если в списке что то есть то чистим для загрузки сохраненных приложений
            if (!AllStaticData.GeneralListOfPrograms.isEmpty())
            {
                AllStaticData.GeneralListOfPrograms.setLength(0);
            }
            while (list!=null){
                list =  fis.readLine();
                countLinesListProgr++;
               // System.out.println(countLinesListProgr+" стролько строк");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//читаем нужное количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader( CreatingAndDeletingADirectory.dirProfile +
                "\\generalListOfPrograms_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt",StandardCharsets.UTF_16LE)))
        {



            //   list =  fis.readLine();
            //тк последняя строка то всего нормальных строк -1
            for  (int i=0;i<countLinesListProgr-1;i++) {
                if (i==(countLinesListProgr-1)){
                    list =  fis.readLine();


                    progr.add(i,list);

                    AllStaticData.GeneralListOfPrograms.append(list);

                    break;
                }
                list =  fis.readLine();


                //нe пропускает пустые строки
                // if (!list.equals(null) && !list.equals("") && !list.equals(" ")&& !list.equals("\\s")) {
                progr.add(i, list);
                AllStaticData.GeneralListOfPrograms.append(list).append("\n");
                //  }

            }
            //  progr= FXCollections.observableArrayList(list);
            // progr= FXCollections.observableArrayList(builder.toString());

           // System.out.println("download list \n"+progr);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
     //   System.out.println(AllStaticData.GeneralListOfPrograms+" загружаются программмы из загрузовчного списка");
        return  progr;
    }


}
