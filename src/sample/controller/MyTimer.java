package sample.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class MyTimer implements Runnable{

    int firstIndex = 0;
    int lastIndex = 0;
 static volatile   String s;
    public    ExecutorService executorService;
   static int count=0;



    @Override
    public void run() {
        count=0;
        AllStaticData.nameProg.clear();
        //считаем колво приложений

        for (int i = 0; i < AllStaticData.oneProgAndEXE.size(); i++) {
            if (AllStaticData.oneProgAndEXE.get(i).toString().contains("***** ")) {
                count++;
            }
        }
        executorService= Executors.newFixedThreadPool(count);
   //     System.out.println(count);

            //проверяем работает есть ли тру у приложений, если есть запускаем выполнение потоков на отсчет времени, если нет то стопим
            for (int i = 0; i < AllStaticData.oneProgAndEXE.size(); i++) {
                if (AllStaticData.oneProgAndEXE.get(i).toString().contains("***** ")) {
                    firstIndex = AllStaticData.oneProgAndEXE.get(i).toString().indexOf(" ");

                    s = AllStaticData.oneProgAndEXE.get(i).toString().substring(firstIndex + 1, AllStaticData.oneProgAndEXE.get(i).toString().length());



                    System.out.println(s+" отслеживается");
                    //добавляем имя проги для того чтобы потом записать ее в бд
                    AllStaticData.nameProg.add(s);
                    for (int k = i + 1; k < AllStaticData.oneProgAndEXE.size(); k++) {

                        if (!AllStaticData.oneProgAndEXE.get(k).toString().contains("***** ")) {
                            if (AllStaticData.oneProgAndEXE.get(k).toString().contains("true")) {


executorService.execute(new ApplicationWorkingHours());
//чистим имя
                                // AllStaticData.nameProg.clear();
                            }

                        }
                        if (AllStaticData.oneProgAndEXE.get(k).toString().contains("***** ")) {
                            break;
                        }
                    }
                }
            }
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

class ApplicationWorkingHours implements Runnable {
    //отсчет времени
    long startTime = System.currentTimeMillis();
//берем индекс проги
    int count=MyTimer.count;
int i=count-1;
//имя проги
    String s=MyTimer.s;
    @Override
    public void run() {

        while (!StartTrackingTheWorkOfPrograms.executorService.isShutdown()) {
         //   System.out.println("ждем");
        }
        if (StartTrackingTheWorkOfPrograms.executorService.isShutdown()) {
            AllStaticData.workTimer=false;
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println(s+" "+elapsedTime);
        }

    }
}