package sample.controller;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        int firstIndex=0;
        int lastIndex=0;



        //далее тут у два раза кладем в массивы и сохраняем проверял как обрезаются пробелы
        //сделай чтобы совпадения искались и для каждый выбранной программы доставались exe
        //может даже файл с ехе сделать чтобы ехе сохранялис в строку
        //переводим в более удобочитаемую форму


        //при поиске директорий еще отсеиваются программы без директорий, надо сделать так чтобы программы с директориями записались в файл с программами


        for (String l : lines){
          //   matcher = pattern1.matcher (l.trim());


            list.add(l.trim());

            //  System.out.println(list.add(l.trim())+" fgffffffffffffffffffffffffffffffffffff");
        }


builder.setLength(0);
        for (int i=0;i<list.size();i++){

       builder.append(list.get(i)+"\n");
        }


        //ставим массив в лист
        for (String l : lines2){
            list2.add(l.trim());
          //    System.out.println(l.trim());
        }
        builder2.setLength(0);
        for (int i=0;i<list2.size();i++){

            builder2.append(list2.get(i)+"\n");
        }


    //    AllStaticData.getApp().saveAllProgrammPC(builder);
     //   AllStaticData.getApp().saveListOfEXEFilesInDirectories(builder2);


        //  System.out.println(list);
    //    System.out.println(list2);



        int count=0;
        //перебор на поиск совпадений программ и вытяегивание ехе
        for (int i=0;i<list.size();i++){
            for (int j=0;j<list2.size();j++){
             //   if (list.get(i).contains(list2.get(j))){
                if (Objects.equals(list.get(i),list2.get(j))){

                    //System.out.println(list2.get(j)+" ssssssssssssssssssssssssssssssssssss \n");
                 s+=   list2.get(j)+" ssssssssssssssssssssssssssssssssssss \n";
list3.add(list2.get(j));

                }

            }
        }

        System.out.println(list3);


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
