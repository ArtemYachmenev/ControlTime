package sample.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// процесс отслеживания времени работы программы
public class ProcessTracking {

    public static boolean programActivity=false;

    public static void trackingProgramm(){
        try {
            String pr_name = "RazerCentralService.exe"; //<-- искомый процесс
            String process_line;
            int flag = 0;
            Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((process_line = input.readLine()) != null) {

                if (process_line.indexOf(pr_name)>=0){ // <-- поиск процесса System
                    System.out.println(process_line.substring(process_line.indexOf(pr_name)));

                    flag = 1 ;
                }
            }
            if (flag==0){
                System.out.println("процесс не обнаружен");
            }
            if (flag==1){
                programActivity=true;
            }

            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        System.out.println(programActivity);
//return programActivity;

    }
}
