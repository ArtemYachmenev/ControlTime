package sample.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartTrackingTheWorkOfPrograms {


    public static void runProgramAndWait() {

        //грузим приложения которые надо отслеживать
        StringBuilder builder = AllStaticData.getApp().downloadAListOfUsedApplicationsTracking();
        String[] lines = builder.toString().split("\\n");
        ArrayList<String> list = new ArrayList<>();

        //грузим ехе
        StringBuilder builder2 = AllStaticData.getApp().downloadListOfEXEFilesInDirectories();
        String[] lines2 = builder2.toString().split("\\n");
        ArrayList<String> list2 = new ArrayList<>();


        //лист для хранения .exe
        ArrayList<String> list3 = new ArrayList<>();
        //лист для хранения .exe без пустых строк
        ArrayList<String> list4 = new ArrayList<>();
        String s = new String();
        String a = new String();
        StringBuilder builder3 = new StringBuilder();
        int firstIndex = 0;
        int lastIndex = 0;


        //далее тут у два раза кладем в массивы и сохраняем проверял как обрезаются пробелы
        //сделай чтобы совпадения искались и для каждый выбранной программы доставались exe
        //может даже файл с ехе сделать чтобы ехе сохранялис в строку
        //переводим в более удобочитаемую форму


        //при поиске директорий еще отсеиваются программы без директорий, надо сделать так чтобы программы с директориями записались в файл с программами


        for (String l : lines) {
            //   matcher = pattern1.matcher (l.trim());


            list.add(l.trim());

            //  System.out.println(list.add(l.trim())+" fgffffffffffffffffffffffffffffffffffff");
        }


        builder.setLength(0);
        for (int i = 0; i < list.size(); i++) {

            builder.append(list.get(i) + "\n");
        }


        //ставим массив в лист
        for (String l : lines2) {
            list2.add(l.trim());
            //    System.out.println(l.trim());
        }
        builder2.setLength(0);
        for (int i = 0; i < list2.size(); i++) {

            builder2.append(list2.get(i) + "\n");
        }


        //    AllStaticData.getApp().saveAllProgrammPC(builder);
        //   AllStaticData.getApp().saveListOfEXEFilesInDirectories(builder2);


        System.out.println(list + " gggggggggggggggggggggggggggggggggggggggggggggg");
        System.out.println(list2 + " aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


        int count = 0;
        //перебор на поиск совпадений программ и вытяегивание ехе
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list2.get(j).contains("***** ")) {
                    firstIndex = list2.get(j).indexOf(" ");
                    //   System.out.println(firstIndex + " xxxxxxxxxxxxxxxxxxx");
                    //    lastIndex = list2.get(j).indexOf(list2.get(j).length()-1);
                    //    System.out.println(lastIndex + " yyyyyyyyyyyyyyyyyyyyyy");
                    s = list2.get(j).substring(firstIndex + 1, list2.get(j).length());
                    System.out.println(s + " ppppppppppppppppppppppp");
                    if (list.get(i).contains(s)) {
                   //     builder3.append("***** " + s + "\n");
                        list3.add("***** " + s);
                        count++;

                        //    if (Objects.equals(list.get(i),list2.get(j))) {
                        for (int k = j + 1; k < list2.size(); k++) {

                            if (!list2.get(k).contains("***** ")) {
                                //       System.out.println(list2.get(j));
                                //System.out.println(list2.get(j)+" ssssssssssssssssssssssssssssssssssss \n");
                                //  a += list2.get(k);
                          //      builder3.append(list2.get(k) + "\n");
                                list3.add(list2.get(k));
                            } else break;
                        }
                    //    builder3.append("*****");
                       // list3.add("***** ");
                    }

                }

                //  s=null;

            }
        }

        //   System.out.println(a+" ssssssssssssssssssssssssssssssssssss" );
        for (int j = 0; j < list3.size(); j++) {

        //    System.out.println(list3.get(j) + " ");
            if (!list3.get(j).equals("\n")&&!list3.get(j).equals(null)&&!list3.get(j).equals("")&&!list3.get(j).equals(" ")&&!list3.get(j).equals("\s")&&!list3.get(j).equals(" \n")){
                list4.add(list3.get(j));
            }

        }

        for (int j = 0; j < list4.size(); j++) {
            System.out.println( list4.get(j));
        }


        System.out.println(count);
      //  System.out.println(builder3);

        doesItWorkOrNot(list4,count);
        // System.out.println(doesItWorkOrNot());
    }

    //сделать так чтобы от каждой проги шли треды с со списками запущенных ехе Boolean

    //чтобы от каждой прогри шел отдельный поток с ехе, и от каждого ехе свой проверяющий поток

    //в файле где ехе приложений надо добавить pid
    public static void doesItWorkOrNot(ArrayList<String> list, int count) {

        String progName;

        //индексы для вырезания названий программ
        int firstIndex = 0;
        int lastIndex = 0;

        ArrayList<String> listProgEXE=new ArrayList<>();

        for (int j = 0; j < list.size(); j++) {

            //если есть звезды то делаем цикл по доставанию программы и ее ехе
            if (list.get(j).contains("***** ")) {


                //вырезаем имя программы
                firstIndex = list.get(j).indexOf(" ");
                progName = list.get(j).substring(firstIndex + 1, list.get(j).length());
                listProgEXE.add(progName);
                //отсчет +2 чтобы отступить от изначального назваиня программы и пропустить пробел и звезды
                for (int k = j + 2; k < list.size(); k++) {
                    if (!list.get(j).equals("\n") && !list.get(j).equals(null) && !list.get(j).equals("") && !list.get(j).equals(" ") && !list.get(j).equals("\s") && !list.get(j).equals(" \n")&&!list.get(k).contains("***** ")) {
                        listProgEXE.add(list.get(k));
                    }
                    //если находим другие звезды то выходим из цикла
                    if (list.get(k).contains("***** ")) {
                        break;
                    }
                }
            }
        }

        //просто смотрим что все нормально
        for (int j = 0; j < listProgEXE.size(); j++) {
            System.out.println(listProgEXE.get(j));
        }

        ExecutorService executorService= Executors.newFixedThreadPool(count);
        for (int i=0;i<count;i++){

        }



//
////        ProcessHandle.allProcesses()
////                .forEach(process -> System.out.println(processDetails(process)));
  //      System.out.println(vmRunning);
 //   }
//
//    private static String processDetails(ProcessHandle process) {
//        return String.format("%8d %8s %10s %26s %-40s",
//                process.pid(),
//                process.info(),
//                text(process.parent().map(ProcessHandle::pid)),
//                text(process.info().user()),
//                text(process.info().startInstant()),
//                text(process.info().commandLine()));
//    }
//
//    private static String text(Optional<?> optional) {
//        return optional.map(Object::toString).orElse("-");
//    }
//
//


//        String line;
//        Process process;
//        java.lang.Runtime runtime;
//        try {
//            runtime = Runtime.getRuntime();
//            process = runtime.exec("ProtonVPN");
//            process.waitFor();
//            if (0 == process.waitFor ()) {
//                System.out.println("govno");
//            }
//            else {
//                System.out.println("huinya");
//            }
//            BufferedReader input =
//                    new BufferedReader(new InputStreamReader(process.getInputStream()));
//            while ((line = input.readLine()) != null) {
//                System.out.println(process.waitFor()); //<-- Parse data here.
//
//                process.waitFor();
//            }
//
//
//            return true;
//
//        } catch (InterruptedException e) {
//            System.out.println("no1");
//            return false;
//        } catch (Exception e) {
//            System.out.println("no2");
//            return false;
//        }
    }
}
class CheckProcess implements Runnable{

    String nameProgram;
    int countEXE;
    ArrayList<String> nameEXE;


    @Override
    public void run() {
        //тут показвает запущен ли процесс
        boolean vmRunning = ProcessHandle.allProcesses()
                .map(ProcessHandle::info)
                .map(ProcessHandle.Info::command)
                .flatMap(Optional::stream)
                .anyMatch(s -> s.contains("Battle.net.exe"));
    }
}



