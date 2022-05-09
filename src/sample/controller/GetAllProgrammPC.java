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

            String process_line;



            Process p = null;


                //команда для поиска прог и их директорий
                p=Runtime.getRuntime().exec("powershell Get-ChildItem HKLM:\\SOFTWARE" +
                        "\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*, HKLM:\\Software\\Wow6432Node" +
                        "\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | % " +
                        "{ Get-ItemProperty $_.PsPath } | Select DisplayName,InstallLocation | " +
                        "Sort-Object Displayname -Descending | Out-File -Width 200 " +
                        CreatingAndDeletingADirectory.listDir.toString());



                p.getOutputStream().close();





        } catch (Exception err) {
            err.printStackTrace();
        }
    }


}
