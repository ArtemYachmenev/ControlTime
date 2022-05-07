package sample.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetAllProgrammPC {

    public static StringBuilder programs=new StringBuilder();
    public static StringBuilder disk=new StringBuilder();

// команда  с дополнительными параметрами
//" Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | " +
//                    "Select-Object DisplayName, DisplayVersion, Publisher, InstallDate | Format-Table -AutoSize "

    public static void getAllProgrammPC(){ //> С:\list-of-programs.txt
        ArrayList<String> list=new ArrayList<>();
        try {
            //> С:\list-of-programs.txt
            String programs_name = " Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | " +
                    "Select-Object DisplayName"; //<-- команда для вывода всех программ и сохранения в текстовом файле
            String process_line;

            //открываем поевершелл пишем команду по выводу всех приложений
            Process p = Runtime.getRuntime().exec("powershell " +programs_name);



            //читаем строки и сохраняем их
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while (((process_line = input.readLine()) != null)) {

                    list.add(process_line.trim());

            }

//            list.remove(0);
//            list.remove(1);
//            list.remove(list.size()-2);
//            list.remove(list.size()-1);
            //цикл фильтрующий список листа с программами
            for (int i=0; i<list.size();i++){
                if ((list.get(i).equals(null))||(list.get(i).equals("\\n"))||(list.get(i).equals(""))||(list.get(i).equals("-----------"))||(list.get(i).contains("DisplayName"))||(list.get(i).equals(""))){
                    list.set(i,"");
                }
              //  System.out.println(list.get(i));

            }

//цикл втсавляющий не пустые строки в список листа с программами
            for (int i=0; i<list.size();i++){
                if (!(list.get(i).equals(""))&&!(list.get(i).equals("\n"))&&!(list.get(i).equals("\s"))) {
                    programs.append(list.get(i) + "\n");
                }
            }





            AllStaticData.app.saveAllProgrammPC(programs);
            // закрываем чтение
            input.close();
            // закрываем процесс
            p.getOutputStream().close();

        } catch (Exception err) {
            err.printStackTrace();
        }


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


    //ищем для программ директории
    public static void searchForTheProgramDirectory(){
        try {

        String[] linesDisk =AllStaticData.getApp().downloadAllDiskPC().toString().split("\\n");
            String[] linesProgrammPC =AllStaticData.getApp().downloadAllProgramPC().toString().split("\\n");

            String programs_name;
            String process_line;
        ArrayList<String> listDisk=new ArrayList<>();
            ArrayList<String> listprogramPC=new ArrayList<>();
            ArrayList<String> listDir=new ArrayList<>();
            ArrayList<String> listExe=new ArrayList<>();


            //присваеиваем массиву диски
            for (String l : linesDisk) {
            if (!l.equals(null) && !l.equals("") && !l.equals(" ")&& !l.equals("null")) {
                listDisk.add(l);
            }
        }
            //присваиваем массиву программы пк
            for (String l : linesProgrammPC) {
                if (!l.equals(null) && !l.equals("") && !l.equals(" ")&& !l.equals("null")) {
                    listprogramPC.add(l);

                }
            }
          //  System.out.println(listprogramPC);
            Process p = null;
        for (int i=0;i<listDisk.size();i++){
            for (int j=0;j<listprogramPC.size();j++) {
                //открываем cmd пишем команду по выводу инфы по директориям программ
                 p = Runtime.getRuntime().exec(listDisk.get(i) + " "+listprogramPC.get(j)+
                        " .exe /s /b");
                 //s нужно для поиска в подтиректориях b для сокр вывода
                //читаем строки и сохраняем их
                BufferedReader input =
                        new BufferedReader(new InputStreamReader(p.getInputStream()));
                while (((process_line = input.readLine()) != null)) {

                    listDir.add(process_line.trim());


                }
                input.close();
                p.getOutputStream().close();
                //ты написал запрос по нахождению дерикторий
                // теперь из этих директорий надо найти ехе

            }
        }



//
            //цикл фильтрующий список листа с дисками
//            for (int i=0; i<list.size();i++){
//                if ((list.get(i).equals(null))||(list.get(i).equals("\\n"))||(list.get(i).equals(""))||(list.get(i).equals("Name"))||(list.get(i).equals(""))){
//                    list.set(i,"");
//                }
//                //  System.out.println(list.get(i));
//
//            }


            //" Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | " +
//                    "Select-Object DisplayName, DisplayVersion, Publisher, InstallDate | Format-Table -AutoSize "


//            programs_name = "wmic logicaldisk get name"; //<-- команда для вывода всех дисков пк
//
//
//            //открываем cmd пишем команду по выводу всех дисков
//            Process p = Runtime.getRuntime().exec(programs_name);
//
//
//
//            //читаем строки и сохраняем их
//            BufferedReader input =
//                    new BufferedReader(new InputStreamReader(p.getInputStream()));
//            while (((process_line = input.readLine()) != null)) {
//
//                list.add(process_line.trim());
//
//            }
//
////
//            //цикл фильтрующий список листа с программами
//            for (int i=0; i<list.size();i++){
//                if ((list.get(i).equals(null))||(list.get(i).equals("\\n"))||(list.get(i).equals(""))||(list.get(i).equals("-----------"))||(list.get(i).contains("DisplayName"))||(list.get(i).equals(""))){
//                    list.set(i,"");
//                }
//                //  System.out.println(list.get(i));
//
//            }
//
////цикл втсавляющий не пустые строки в список листа с программами
//            for (int i=1; i<list.size();i++){
//                if (!(list.get(i).equals(""))&&!(list.get(i).equals("\n"))&&!(list.get(i).equals("\s"))) {
//                    disk.append(list.get(i) + "\n");
//                }
//            }
//
//
//
//
//
//            AllStaticData.app.saveAllDiskPC(disk);
//            // закрываем чтение
//            input.close();
//            // закрываем процесс
//            p.getOutputStream().close();
//
        } catch (Exception err) {
            err.printStackTrace();
        }
    }


}
