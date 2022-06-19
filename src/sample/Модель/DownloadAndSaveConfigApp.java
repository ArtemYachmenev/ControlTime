package sample.Модель;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Контроллер.ClassesWorkingWithFXML.SettingsPane.PaneColorSet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import static sample.Модель.AllStaticData.*;
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
          //  saveStaticData();
        }

    }
    //сохранение выбранных приложений нового пользователя
    public void saveUsedListNewProgr() {

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(dirProfile +
                "\\saveListUsedProgr_"
                + LoginOfTheWorkingUser.getUserLogin() + ".txt",StandardCharsets.UTF_16LE))) {
            //сохранение статиков конфига
            String ListProgr ="";
            fs.write(ListProgr);
       //     System.out.println("save used listProgr for new profile" + ListProgr);
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //сохранение отслеживаемых приложений пользователя без перезаписи
    public void saveAListOfUsedApplicationsOverwriting(StringBuilder s) {

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(dirProfile +
                "\\saveListUsedProgr_"
                + LoginOfTheWorkingUser.getUserLogin() + ".txt",StandardCharsets.UTF_16LE))) {
            //сохранение текста новым билдером
            StringBuilder ListProgr =s;

            fs.write(String.valueOf(ListProgr));
         //   System.out.println("save used list \n" + ListProgr);
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
        try (BufferedReader fis = new BufferedReader(new FileReader( dirProfile+"\\saveListUsedProgr_"
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
            //    System.out.println(countLinesListProgr+" стролько строк");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//читаем нужное количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader( dirProfile+"\\saveListUsedProgr_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt",StandardCharsets.UTF_16LE)))
        {

            for  (int i=0;i<countLinesListProgr-1;i++) {
                if (i==(countLinesListProgr-1)){
                    list =  fis.readLine();


                    progr.add(i,list);

                    AllStaticData.ListUsedProgr.append(list);

                    break;
                }
                list =  fis.readLine();

                    progr.add(i, list);
                    AllStaticData.ListUsedProgr.append(list).append("\n");

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return  progr;
    }


    //загрузка обычного списка билдера используемых приложений для отслеживания времени
    public StringBuilder downloadAListOfUsedApplicationsTracking() {
        String list="";


//читаем нужное количество строк

        StringBuilder listPrograms=new StringBuilder();
        try (BufferedReader  fis = new BufferedReader (new FileReader( dirProfile+"\\saveListUsedProgr_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt",StandardCharsets.UTF_16LE)))
        {


            String line=new String();
            while ((line = fis.readLine()) != null) {
                listPrograms.append(line+"\n");


            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return  listPrograms;
        }


    //сохраняем цвета приложения
    public void saveColorApp(String up, String down){
        try (BufferedWriter fs = new BufferedWriter (new FileWriter( dirProfile+"\\saveUp_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt"))) {
            //пишет в начале иероглифы
            fs.write(up);
            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedWriter  fs = new BufferedWriter (new FileWriter( dirProfile+"\\saveDown_"
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
        try (BufferedReader  fis = new BufferedReader (new FileReader( dirProfile+"\\saveUp_"
                +LoginOfTheWorkingUser.getUserLogin()+".txt")))
             {
            colorUp = fis.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedReader  fis = new BufferedReader (new FileReader( dirProfile+"\\saveDown_"
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

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(AllStaticData.firstDiskLine+"\\TimeControl\\listPrograms.txt",StandardCharsets.UTF_16LE))) {
            //присваеивание текста новым билдером
            StringBuilder ListProgr =listProgramPC;
       //     System.out.println(ListProgr);

            fs.write(String.valueOf(ListProgr));

fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //сохранение списка директорий программ пк
    public void saveDirProgrammPC(StringBuilder listDirProgramPC){
        // CreatingAndDeletingADirectory.overwritingListProgramsPowershell();

        try (BufferedWriter fs = new BufferedWriter(new FileWriter(AllStaticData.firstDiskLine+"\\TimeControl\\listDir.txt",StandardCharsets.UTF_16LE))) {
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

        String list = "";
        //читаем количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader(AllStaticData.firstDiskLine+"\\TimeControl\\listDir.txt",StandardCharsets.UTF_16LE))) {
            while (list != null) {
                list = fis.readLine();
               builder.append(list+"\n");
               // System.out.println(count + " стролько строк");

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

return builder;
    }


    //сохранение нового списка директорий программ пк
    public void saveNewAListDirProg(){

        String s="";
        try (BufferedWriter fs = new BufferedWriter(new FileWriter(AllStaticData.firstDiskLine+"\\TimeControl\\listDir.txt",StandardCharsets.UTF_16))) {
            //присваеивание текста новым билдером

            //     System.out.println(ListProgr);

            fs.write(String.valueOf(s));

            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    //сохранение списка дисков пк
    public void saveAllDiskPC(StringBuilder listDiskPC){
        try (BufferedWriter fs = new BufferedWriter(new FileWriter(AllStaticData.firstDiskLine+"\\TimeControl\\listDisk.txt",StandardCharsets.UTF_16LE))) {
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
        try (BufferedWriter fs = new BufferedWriter(new FileWriter(AllStaticData.firstDiskLine+"\\TimeControl\\listDir.txt"))) {
            //присваеивание текста новым билдером
            fs.write(String.valueOf(builder));

            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //сохранение списка ехе пк
    public void saveListOfEXEFilesInDirectories(StringBuilder listDiskPC){
        try (BufferedWriter fs = new BufferedWriter(new FileWriter(AllStaticData.firstDiskLine+"\\TimeControl\\listOfEXEFilesInDirectories.txt",StandardCharsets.UTF_16LE))) {
            //присваеивание текста новым билдером
            StringBuilder ListDisk =listDiskPC;

            fs.write(String.valueOf(ListDisk));

            fs.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //загрузка списка .exe программ
    public StringBuilder downloadListOfEXEFilesInDirectories() {

        String s="";

        StringBuilder list=new StringBuilder();
//читаем нужное количество строк

        StringBuilder listPrograms=new StringBuilder();
        try (BufferedReader  fis = new BufferedReader (new FileReader( AllStaticData.firstDiskLine+"\\TimeControl\\listOfEXEFilesInDirectories.txt",StandardCharsets.UTF_16LE)))
        {
            String line=new String();
            while ((line = fis.readLine()) != null) {
                listPrograms.append(line+"\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return  listPrograms;
    }


    //загрузка списка дисков пк
    public StringBuilder downloadAllDiskPC() {
        String s="";

        StringBuilder list=new StringBuilder();
        try (BufferedReader  fis = new BufferedReader (new FileReader( AllStaticData.firstDiskLine+"\\TimeControl\\listDisk.txt", StandardCharsets.UTF_16LE)))
        {


            while (s != null) {
                s = fis.readLine();
                list.append(s+"\n");


            }
            System.out.println(list);



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
        try (BufferedReader fis = new BufferedReader(new FileReader(programPCPowershell, StandardCharsets.UTF_16LE))) {
            while (list != null) {
                list = fis.readLine();
                count++;

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //читаем нужное количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader(programPCPowershell, StandardCharsets.UTF_16LE))) {

            //отсекаем лишние строки, при ответе повершелла их 8
            for (int i = 0; i < count - 1; i++) {
                if (i == (count - 8)) {
                    list = fis.readLine();
                    builder.append(list + "\n");

                    break;
                }
                list = fis.readLine();

                builder.append(list + "\n");
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
        try (BufferedReader  fis = new BufferedReader (new FileReader( programPCPowershell, StandardCharsets.UTF_16LE)))
        {

            while (s != null) {
                s = fis.readLine();
                list.append(s+"\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //грузим старый  лист программ пк из повершелла БЕЗ ИЗМЕНЕНИЙ И ФИЛЬТРА который был сформирован при создании профиля
    public StringBuilder downloadNewAllProgramPCPowershell() {
        String s="";

        StringBuilder list=new StringBuilder();
        try (BufferedReader  fis = new BufferedReader (new FileReader( programPCPowershellCompare, StandardCharsets.UTF_16LE)))
        {
            while (s != null) {
                s = fis.readLine();
                list.append(s+"\n");
            }

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
        try (BufferedReader fis = new BufferedReader(new FileReader(listDir, StandardCharsets.UTF_16LE))) {
            while (list != null) {
                list = fis.readLine();
                count++;

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //читаем нужное количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader(listDir, StandardCharsets.UTF_16LE))) {

            //отсекаем лишние строки, при ответе повершелла их 8
            for (int i = 0; i < count - 1; i++) {
                if (i == (count - 8)) {
                    list = fis.readLine();


                    builder.append(list + "\n");


                    break;
                }
                list = fis.readLine();

                builder.append(list + "\n");
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

                builder1.append(l + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
      //    System.out.println(builder);
        return builder1;
    }
//грузим лист програм пк для их отображения в настройках
    public ObservableList<String> downloadListProgr() {
        String list="";
        ObservableList<String> progr = FXCollections.observableArrayList();

        int countLinesListProgr=0;

        //считаем сколько строк
        try (BufferedReader fis = new BufferedReader(new FileReader( AllStaticData.firstDiskLine+"\\TimeControl\\listPrograms.txt")))
        {
            //если в списке что то есть то чистим для загрузки сохраненных приложений
            if (!AllStaticData.ListOfPrograms.isEmpty())
            {
                AllStaticData.ListOfPrograms.setLength(0);
            }
            while (list!=null){
                list =  fis.readLine();
                countLinesListProgr++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//читаем нужное количество строк
        try (BufferedReader fis = new BufferedReader(new FileReader( AllStaticData.firstDiskLine+"\\TimeControl\\listPrograms.txt",StandardCharsets.UTF_16LE)))
        {

            //тк последняя строка то всего нормальных строк -1
            for  (int i=0;i<countLinesListProgr-1;i++) {
                if (i==(countLinesListProgr-1)){
                    list =  fis.readLine();


                    progr.add(i,list);

                    AllStaticData.ListOfPrograms.append(list);

                    break;
                }
                list =  fis.readLine();

                //нe пропускает пустые строки
                progr.add(i, list);
                AllStaticData.ListOfPrograms.append(list).append("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return  progr;
    }
}
