package sample.Модель;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.Executors;

import static sample.Модель.AllStaticData.*;
public class StartTrackingTheWorkOfPrograms {


    public static void runProgramAndWait() {

        //каждый раз обновляем лист
        AllStaticData.nameProgCountEXE=new ArrayList<>();
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

        for (String l : lines) {

            list.add(l.trim());
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
        int count = 0;
        //перебор на поиск совпадений программ и вытяегивание ехе
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list2.get(j).contains("***** ")) {
                    firstIndex = list2.get(j).indexOf(" ");

                    s = list2.get(j).substring(firstIndex + 1, list2.get(j).length());
                    if (list.get(i).contains(s)) {
                        list3.add("***** " + s);
                        count++;

                        for (int k = j + 1; k < list2.size(); k++) {

                            if (!list2.get(k).contains("***** ")) {

                                list3.add(list2.get(k));
                            } else break;
                        }

                    }

                }

            }
        }

        //   System.out.println(a+" ssssssssssssssssssssssssssssssssssss" );
        for (int j = 0; j < list3.size(); j++) {

        //    System.out.println(list3.get(j) + " ");
            if (!list3.get(j).equals("\n")&&!list3.get(j).equals(null)&&!list3.get(j).equals("")&&!list3.get(j).equals(" ")&&!list3.get(j).equals("\s")&&!list3.get(j).equals(" \n")){
                list4.add(list3.get(j));
            }

        }

        doesItWorkOrNot(list4);

    }

    public static void doesItWorkOrNot(ArrayList<String> list) {

        String progName="";

        //индексы для вырезания названий программ
        int firstIndex = 0;
        int lastIndex = 0;

        ArrayList<String> listProgEXE=new ArrayList<>();


        //исполнитель запуска потоков
      // executorService= Executors.newFixedThreadPool(count);
        executorServiceStartTrackingTheWorkOfPrograms= Executors.newFixedThreadPool(3);

        int sumEXE=0;
        for (int j = 0; j < list.size(); j++) {

            //если есть звезды то делаем цикл по доставанию программы и ее ехе
            if (list.get(j).contains("***** ")) {


                //вырезаем имя программы
                firstIndex = list.get(j).indexOf(" ");
                progName = list.get(j).substring(firstIndex + 1, list.get(j).length());
             //   listProgEXE.add(progName);
                //добавляем в лист имя программы
                AllStaticData.nameProgCountEXE.add(list.get(j));
                //отсчет +2 чтобы отступить от изначального назваиня программы и пропустить пробел и звезды
                for (int k = j + 2; k < list.size(); k++) {
                    if (!list.get(j).equals("\n") && !list.get(j).equals(null) && !list.get(j).equals("") && !list.get(j).equals(" ") && !list.get(j).equals("\s") && !list.get(j).equals(" \n")&&!list.get(k).contains("***** ")) {
                        listProgEXE.add(list.get(k));
                        //добавляем в лист количесво ехе
                        AllStaticData.nameProgCountEXE.add(list.get(k));
                        sumEXE++;
                    }
                    //если находим другие звезды то выходим из цикла
                    if (list.get(k).contains("***** ")) {
                        break;
                    }

                }


            }
        }
        //запускаем поток
        executorServiceStartTrackingTheWorkOfPrograms.execute(new CheckProcess(progName,sumEXE,listProgEXE));

        //добавляем в лист имя программы и количесво ехе
        //запускаем прогу в которой в которой должен работать счетчик
        OperationTimer operationTimer=new OperationTimer();
        executorServiceStartTrackingTheWorkOfPrograms.execute(new OperationTimer());

        executorServiceStartTrackingTheWorkOfPrograms.execute(new MouseTracking());

    }
}
class CheckProcess implements Runnable {

    String nameProgram;
    int countEXE;
    ArrayList<String> nameEXE;
  //  int d=0;
    boolean activity = false;

    public CheckProcess(String nameProgram, int countEXE, ArrayList<String> nameEXE) {
        this.nameProgram = nameProgram;
        this.countEXE = countEXE;
        this.nameEXE = nameEXE;
    }

//26 05 сделан статик список который сохраняет и перезаписывает состояния ехе, в таймере и тп надо будет потом найти названия приложений можно сделать еще один статик и брать приложения из метода сверху
    @Override
    public  void run() {

        //пока выполнитель не выключен работает
        while (!executorServiceStartTrackingTheWorkOfPrograms.isShutdown()) {
            //каждый раз чистим список
            AllStaticData.workApp.clear();

//добавляем имя программы
            //тут показвает запущен ли процесс
            for (int i = 0; i < nameEXE.size(); i++) {
                int finalI = i;

                boolean vmRunning = ProcessHandle.allProcesses()
                        .map(ProcessHandle::info)
                        .map(ProcessHandle.Info::command)
                        .flatMap(Optional::stream)
                        .anyMatch(s -> s.contains(nameEXE.get(finalI)));
                activity = vmRunning;

                //добавляем элементы
                AllStaticData.workApp.add(nameEXE.get(i) + " " + vmRunning);

            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }

        }

    }
}




