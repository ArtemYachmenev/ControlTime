package sample.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetAllProgrammPC {

    public static StringBuilder programs=new StringBuilder();

// команда  с дополнительными параметрами
//" Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | " +
//                    "Select-Object DisplayName, DisplayVersion, Publisher, InstallDate | Format-Table -AutoSize "

    public static void getAllProgrammPC(){ //> С:\list-of-programs.txt
        try {
            String programs_name = " Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | " +
                    "Select-Object DisplayName"; //<-- команда для вывода всех программ и сохранения в текстовом файле
            String process_line;

            //открываем поевершелл пишем команду по выводу всех приложений
            Process p = Runtime.getRuntime().exec("powershell " +programs_name);



            //читаем строки и сохраняем их
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while (((process_line = input.readLine()) != null)) {

                    programs.append(process_line.trim() + "\n");


                    // System.out.println(process_line);

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
}
