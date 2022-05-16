package sample.controller;

import java.util.ArrayList;
import java.util.Objects;

public class StartTrackingTheWorkOfPrograms {


    public static void runProgramAndWait(){

        //грузим приложения которые надо отслеживать
        StringBuilder builder= AllStaticData.getApp().downloadAListOfUsedApplicationsTracking();
        String[] lines = builder.toString().split("\\n");
        ArrayList<String> list=new ArrayList<>();

        //грузим ехе
        StringBuilder builder2= AllStaticData.getApp().downloadListOfEXEFilesInDirectories();
        String[] lines2 = builder2.toString().split("\\n");
        ArrayList<String> list2=new ArrayList<>();


        //лист для хранения .exe
        ArrayList<String> list3=new ArrayList<>();
        String s=new String();



        //переводим в более удобочитаемую форму
        for (String l : lines){
            list.add(l);
            //  System.out.println(list+" fgffffffffffffffffffffffffffffffffffff");
        }

        //ставим массив в лист
        for (String l : lines2){
            list2.add(l);
            //  System.out.println(list);
        }

        int count=0;
        //перебор на поиск совпадений программ и вытяегивание ехе
        for (int i=0;i<list.size();i++){
            for (int j=0;j<list2.size();j++){
                if (list.get(i).contains(list2.get(j))){
                    count=j+1;
                    while (count>=0){
                        if (!list2.get(count).equals("")&&!list2.get(count).equals("\n")&&!list2.get(count).equals("\s")) {
                            s += list2.get(count);
                            count++;
                        }
                        else break;

                    }


                }

            }
        }

        System.out.println(s);


        Process process;
        java.lang.Runtime runtime;
        try{
            runtime = Runtime.getRuntime();
           // process = runtime.exec();
           // process.waitFor();
        //    return true;
     //   }catch (InterruptedException e){
        //    return false;
        }
        catch (Exception e){
        //    return false;
        }
    }



}
