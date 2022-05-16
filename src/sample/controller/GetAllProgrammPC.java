package sample.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class GetAllProgrammPC {

    // public static StringBuilder programs=new StringBuilder();
    public static StringBuilder disk = new StringBuilder();
    public static StringBuilder program = new StringBuilder();
    public static StringBuilder dir = new StringBuilder();

    public static boolean programsHaveChanged=false;
    public static StringBuilder listOfEXEFilesInDirectories = new StringBuilder();
    // команда  с дополнительными параметрами
//" Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | " +
//                    "Select-Object DisplayName, DisplayVersion, Publisher, InstallDate | Format-Table -AutoSize "
    public static void getAllProgramPowershall()  {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("powershell " + " Get-ChildItem HKLM:" +
                    "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*, HKLM:\\Software" +
                    "\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* " +
                    "| % { Get-ItemProperty $_.PsPath } | Select DisplayName | Sort-Object Displayname -Descending " +
                    "| Out-File -Width 200 "
                    + CreatingAndDeletingADirectory.programPCPowershell);
            p.getOutputStream().close();

        } catch (IOException e) {
            e.printStackTrace();
        }
//            Process p = Runtime.getRuntime().exec("powershell " + " Get-ChildItem HKLM:" +
//                    "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*, HKLM:\\Software" +
//                    "\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* " +
//                    "| % { Get-ItemProperty $_.PsPath } | Select DisplayName | Sort-Object Displayname -Descending " );
        try {
            p.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

// каждый запуск делаем файл для сравнения если список приложений пк изменился то обновляем список путей
    public static void newAllProgramPowershall()  {

        Process p = null;


        try {
            p = Runtime.getRuntime().exec("powershell " + " Get-ChildItem HKLM:" +
                    "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*, HKLM:\\Software" +
                    "\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* " +
                    "| % { Get-ItemProperty $_.PsPath } | Select DisplayName | Sort-Object Displayname -Descending | Out-File  -Width 200 " +
                    CreatingAndDeletingADirectory.programPCPowershellCompare);

          
           
            p.getOutputStream().close();






        } catch (IOException e) {
            e.printStackTrace();
        }
//            Process p = Runtime.getRuntime().exec("powershell " + " Get-ChildItem HKLM:" +
//                    "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*, HKLM:\\Software" +
//                    "\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* " +
//                    "| % { Get-ItemProperty $_.PsPath } | Select DisplayName | Sort-Object Displayname -Descending " );
        try {
            p.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    // каждый запуск делаем файл для сравнения если список приложений пк изменился то обновляем список путей
    public static void comparisonAllProgramPowershall()  {
        String line=new String();
        Process p = null;
        StringBuilder builder=AllStaticData.app.downloadNewAllProgramPCPowershell();
        StringBuilder builder2=AllStaticData.app.downloadOldAllProgramPCPowershell();
       // System.out.println(builder2);
       // System.out.println(builder2 + " gggggggggggggggggggggggggggggggggggggggggggggggg");


//сравниваение фалов с пк программами если не сходится то все обновляем
     //  if (builder.compareTo(builder2)!=0){
        if (!Objects.equals(builder.toString().length(),builder2.toString().length())){
//грузим файлы в директориях
            GetAllProgrammPC.getAllProgramPowershall();
            //загружаем все диски пк
            GetAllProgrammPC.getListDiskPC();

//грузим директории без дубликатов
            GetAllProgrammPC.searchForTheProgramPowershellDirectory();
            GetAllProgrammPC.getListOfEXEFilesInDirectories();
            programsHaveChanged=true;



        }




    }


//чистим дубликаты программ из ответа повершелла
    public static void getAllProgrammPC(){ //> С:\list-of-programs.txt
        ArrayList<String> list=new ArrayList<>();


        //> С:\list-of-programs.txt
            // String programs_name = " Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | " +
            //         "Select-Object DisplayName"; //<-- команда для вывода всех программ и сохранения в текстовом файле
            String process_line;

            //открываем поевершелл пишем команду по выводу всех приложений
//            Process p = Runtime.getRuntime().exec("powershell " + " Get-ChildItem HKLM:" +
//                    "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*, HKLM:\\Software" +
//                    "\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* " +
//                    "| % { Get-ItemProperty $_.PsPath } | Select DisplayName | Sort-Object Displayname -Descending " +
//                    "| Out-File -Width 200 "
//                    + CreatingAndDeletingADirectory.programPCPowershell);
////            Process p = Runtime.getRuntime().exec("powershell " + " Get-ChildItem HKLM:" +
////                    "\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*, HKLM:\\Software" +
////                    "\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* " +
////                    "| % { Get-ItemProperty $_.PsPath } | Select DisplayName | Sort-Object Displayname -Descending " );
//            p.getOutputStream().close();

            //читаем строки и сохраняем их
//            BufferedReader input =
//                    new BufferedReader(new InputStreamReader(p.getInputStream()));
//            while (((process_line = input.readLine()) != null)) {
//
//                list.add(process_line.trim());
//
//            }

            //сделать цикл перезаписи файла для сортировки от пустых строк в этом методе
            //читаем строки и сохраняем их

            //грузим список программ пк и кладем их и в массив для разбивки
            StringBuilder builder= AllStaticData.getApp().downloadAllProgramPCPowershell();
            String[] lines = builder.toString().split("\\n");


            //ставим массив в лист
            for (String l : lines){
                list.add(l);
                //  System.out.println(list);
            }

//            list.remove(0);
//            list.remove(1);
//            list.remove(list.size()-2);
//            list.remove(list.size()-1);
            //цикл фильтрующий список листа с программами Objects.equals(list.get(i),"\n")
            for (int i=0;i<list.size();i++){
                if (list.get(i).equals(null)||Objects.equals(list.get(i),"\n")||list.get(i).equals("")||list.get(i).contains("-----------")||list.get(i).contains("DisplayName")
                        ||list.get(i).equals(" ")||Objects.equals(list.get(i),"")||list.get(i).equals("\s")||Objects.equals(list.get(i),"\\n")||list.get(i).contains("                                                ")){
                    list.set(i,"");

                }

            }

//цикл втсавляющий не пустые строки в список листа с программами
            for (int i=0; i<list.size();i++){
                if (!(Objects.equals(list.get(i),""))&&!(Objects.equals(list.get(i),"\n"))&&!(list.get(i).equals("\s"))&&!(list.get(i).equals(" "))) {
                    program.append(list.get(i) + "\n");
                }
            }





            CreatingAndDeletingADirectory.overwritingListPrograms();
          AllStaticData.getApp().saveAllProgrammPC(program);
         // builder1.setLength(0);
            // закрываем чтение
            // закрываем процесс






    }




    public static void getListDiskPC(){
        ArrayList<String> list=new ArrayList<>();
        try {

            String programs_name = "wmic logicaldisk get name"; //<-- команда для вывода всех дисков пк
            String process_line;

            //открываем cmd пишем команду по выводу всех дисков
            Process p = Runtime.getRuntime().exec(programs_name);



            //читаем строки и сохраняем их
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while (((process_line = input.readLine()) != null)) {

                list.add(process_line.trim());

            }

//
            //цикл фильтрующий список листа с дисками
            for (int i=0; i<list.size();i++){
                if ((list.get(i).equals(null))||(list.get(i).equals("\\n"))||(list.get(i).equals(""))||(list.get(i).equals("Name"))||(list.get(i).equals(""))){
                    list.set(i,"");
                }
                //  System.out.println(list.get(i));

            }

//цикл втсавляющий не пустые строки в список листа с дисками
            for (int i=0; i<list.size();i++){
                if (!(list.get(i).equals(""))&&!(list.get(i).equals("\n"))&&!(list.get(i).equals("\s"))) {
                    disk.append(list.get(i) + "\n");
                }
            }





            AllStaticData.app.saveAllDiskPC(disk);
            // закрываем чтение
            input.close();
            // закрываем процесс
            p.getOutputStream().close();

        } catch (Exception err) {
            err.printStackTrace();
        }
    }


    //ищем директории по запросу
    public static void getAllProgramDirPowershell() {
        try {
            Process p = null;


            //команда для поиска прог и их директорий
            p=Runtime.getRuntime().exec("powershell Get-ChildItem HKLM:\\SOFTWARE" +
                    "\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*, HKLM:\\Software\\Wow6432Node" +
                    "\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | % " +
                    "{ Get-ItemProperty $_.PsPath } | Select DisplayName,InstallLocation | " +
                    "Sort-Object Displayname -Descending | Out-File  -Width 200 " +
                    CreatingAndDeletingADirectory.listDir);



            p.getOutputStream().close();

        } catch (Exception err) {
            err.printStackTrace();
        }


    }
    //ищем для программ директории
    public static void searchForTheProgramPowershellDirectory(){

            ArrayList<String> list=new ArrayList<>();
        ArrayList<String> list2=new ArrayList<>();
            String process_line;





            StringBuilder builder= AllStaticData.getApp().downloadAllProgramPowershellDirectory();
            String[] lines = builder.toString().split("\\n");


            //ставим массив в лист
            for (String l : lines){
                list.add(l+"~~~~~");
             //     System.out.println(list);
            }




//            list.remove(0);
//            list.remove(1);
//            list.remove(list.size()-2);
//            list.remove(list.size()-1);
            //цикл фильтрующий список листа с программами
            for (int i=0;i<list.size();i++){
                if (list.get(i).equals(null)||list.get(i).equals("\n")||list.get(i).equals("")||list.get(i).contains("---------------")||list.get(i).contains("InstallLocation")
                        ||list.get(i).equals("")||list.get(i).equals("\s")||list.get(i).equals("\n")){
                    list.set(i,"");

                }

            }

//цикл втсавляющий не пустые строки в список листа с программами
            for (int i=0; i<list.size();i++){
                if (!(list.get(i).equals(""))&&!(list.get(i).equals("\n"))&&!(list.get(i).equals("\s"))&&!(list.get(i).equals(" "))) {
                    dir.append(list.get(i) + "\n");
                }
            }





            CreatingAndDeletingADirectory.overwritingProgramsDirPowershell();
            AllStaticData.getApp().saveDirProgrammPC(dir);
            //команда для поиска прог и их директорий 2


    }


    //ищем файлы в директориях программ пк

    //может надо из выгруженного списка отделить директории и их потом вставить в запрос
    //можно в каждой строке искать до диска

    public static void getListOfEXEFilesInDirectories(){
        try {


        String line = "";
        String str=new String();

        Process p = null;



        //добавь в файл сохранения директорий стоп символы для нахождения последнего индекса



        //для вырывания директорий программ
        StringBuilder builder= AllStaticData.getApp().downloadDirProgrammPC();
        String[] lines = builder.toString().split("\\n");
        ArrayList<String> list=new ArrayList<>();

        //для вырывания дисков где лежат директории
            StringBuilder builder2= AllStaticData.getApp().downloadAllDiskPC();
        String[] lines2 = builder2.toString().split("\\n");
        ArrayList<String> list2=new ArrayList<>();

            //для сохранения директорий

            ArrayList<String> list3=new ArrayList<>();
            StringBuilder builder3= new StringBuilder();


        //ставим массив в лист
        for (String l : lines){
            list.add(l);
            //  System.out.println(list+" fgffffffffffffffffffffffffffffffffffff");
        }

            //ставим массив в лист
            for (String l : lines2){
                list2.add(l);
                //  System.out.println(list);
            }


//            int indexFirst=0;
//            int indexIntermediate=0;
//            int indexLast=0;



//цикл втсавляющий не пустые строки в список листа с программами
            //перебирающий и вырывающий пити директорий
        for (int i=0; i<list.size()-1;i++){
            if (!(list.get(i).equals(""))&&!(list.get(i).equals("\n"))&&!(list.get(i).equals("\s"))&&!(list.get(i).equals(" "))) {
                for (int j=0; j<list2.size();j++) {
                    //если строка  содержит тот или иной диск
                    if(list.get(i).contains(list2.get(j))){

                        //присваиваем индексам место где идет этот диск
                        int   indexFirst = list.get(i).indexOf(list2.get(j));
                        //индекс откуда начинается конец ~~~~~
                        int  indexLast=list.get(i).indexOf("~~~~~");

                       // line = list.get(i).substring(indexFirst, indexLast);
str=list.get(i);
//название программы
String substr=str.substring(0, indexFirst-1);
//ее путь
String substr2=str.substring(indexFirst, indexLast-1);
                      //  System.out.println(list2.get(j));
                     //   System.out.println(indexFirst);
                     //   System.out.println(substr2);

                      //  System.out.println((str.substring(0, indexFirst-1)+" ggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));



//команда для поиска ехе файлов в этих директориях
                        p=Runtime.getRuntime().exec("powershell Get-ChildItem  -path \\\""+substr2 +"\\\" -Recurse *.exe | Select Name");

                        //если у программы есть exe то записываем его
                        BufferedReader inputGetNameProg =
                                new BufferedReader(new InputStreamReader(p.getInputStream()));
                        while ((line = inputGetNameProg.readLine()) != null) {
                            if (line.contains(".exe")) {
                                builder3.append(substr+"\n");
                                break;
                            }}

                        BufferedReader input =
                                new BufferedReader(new InputStreamReader(p.getInputStream()));
                        while ((line = input.readLine()) != null) {

                                // line = input.readLine();
                                if (!(line.contains("Name")) && !(line.contains("----")) && !(line.equals("\\n")) && !(line.equals("\\s"))) {

                                    //   System.out.println("1111111111111111111111111111111111111111111111");
                                    System.out.println(line);
                                    builder3.append(line + "\n");
                                }


                        }
                      //  builder3.append("~~~~~ \n");
                        p.getOutputStream().close();



                    }


                }

            }

        }

//            for (int i=0; i<list3.size();i++) {
//                builder3.append(list3.get(i)+"\n");
//            }










            // CreatingAndDeletingADirectory.overwritingProgramsDirPowershell();
        AllStaticData.getApp().saveListOfEXEFilesInDirectories(builder3);
        //команда для поиска прог и их директорий 2

        } catch (Exception err) {
            err.printStackTrace();
        }
    }



}
