package sample.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Timer implements Runnable{

    int firstIndex = 0;
    int lastIndex = 0;
    String s;
    public    ExecutorService executorService;
    int count=0;



    @Override
    public void run() {
        //считаем колво приложений
        for (int i = 0; i < AllStaticData.oneProgAndEXE.size(); i++) {
            if (AllStaticData.oneProgAndEXE.get(i).toString().contains("***** ")) {
                count++;
            }
        }
        executorService= Executors.newFixedThreadPool(count);


            //проверяем работает есть ли тру у приложений, если есть запускаем выполнение потоков на отсчет времени, если нет то стопим
            for (int i = 0; i < AllStaticData.oneProgAndEXE.size(); i++) {
                if (AllStaticData.oneProgAndEXE.get(i).toString().contains("***** ")) {
                    firstIndex = AllStaticData.oneProgAndEXE.get(i).toString().indexOf(" ");

                    s = AllStaticData.oneProgAndEXE.get(i).toString().substring(firstIndex + 1, AllStaticData.oneProgAndEXE.get(i).toString().length());



                    System.out.println(s+" работает");
                    for (int k = i + 1; k < AllStaticData.oneProgAndEXE.size(); k++) {

                        if (!AllStaticData.oneProgAndEXE.get(k).toString().contains("***** ")) {
                            if (AllStaticData.oneProgAndEXE.get(k).toString().contains("true")) {

executorService.execute(new ApplicationWorkingHours());
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

    @Override
    public void run() {
        while (!StartTrackingTheWorkOfPrograms.executorService.isShutdown()) {

        }
        long elapsedTime = System.currentTimeMillis() - startTime;
    }
}