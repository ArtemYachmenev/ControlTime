package sample.controller;

import sample.controller.Database.DatabaseHandler;
import sample.controller.Database.WorkingHours;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static sample.controller.AllStaticData.listRunActual;
import static sample.controller.AllStaticData.listRunProg2;


public class MyTimer implements Runnable{

    int firstIndex = 0;
    int lastIndex = 0;
 static volatile   String s;
    public    ExecutorService executorService;
   static int count=0;



    @Override
    public void run() {
        synchronized (listRunProg2){
        count=0;
        AllStaticData.nameProg.clear();
        //считаем колво приложений

        for (int i = 0; i < AllStaticData.listRunProg2.size(); i++) {
            if (AllStaticData.listRunProg2.get(i).toString().contains("***** ")) {
                count++;
            }
        }
      //  System.out.println(count);
            //делаем один поток count не нужен
        executorService= Executors.newSingleThreadExecutor();
   //     System.out.println(count);

            //проверяем работает есть ли тру у приложений, если есть запускаем выполнение потоков на отсчет времени, если нет то стопим
            for (int i = 0; i < AllStaticData.listRunProg2.size(); i++) {
                if (AllStaticData.listRunProg2.get(i).toString().contains("***** ")) {
                    firstIndex = AllStaticData.listRunProg2.get(i).toString().indexOf(" ");

                    s = AllStaticData.listRunProg2.get(i).toString().substring(firstIndex + 1, AllStaticData.listRunProg2.get(i).toString().length());


                          System.out.println(s+" отслеживается");
                    //добавляем имя проги для того чтобы потом записать ее в бд
                    AllStaticData.nameProg.add(s);
                    for (int k = i + 1; k < AllStaticData.listRunProg2.size(); k++) {

                        if (!AllStaticData.listRunProg2.get(k).toString().contains("***** ")) {
                            if (AllStaticData.listRunProg2.get(k).toString().contains("true")) {


                                executorService.execute(new ApplicationWorkingHours());




//чистим имя

                                // AllStaticData.nameProg.clear();
                            }

                        }
                        if (AllStaticData.listRunProg2.get(k).toString().contains("***** ")) {
                            break;
                        }
                     //   listRunProg2.remove(i);
                      //  listRunProg2.remove(i);
                    }
                }
            }
            //чистим лист
            listRunProg2.clear();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

class ApplicationWorkingHours implements Runnable {
    Date currentDate = new Date();
    //отсчет времени
    long startTime = System.currentTimeMillis();
//берем индекс проги
    int count=MyTimer.count;
int i=count-1;
    long elapsedTime;
    long elapsedTimeInterrupt;
    //массовое сохранение времени
    long sumTime=0;
    boolean run;
    //ключ для остановки потока
    boolean runFalse=false;
    //ключ для определения отсчета времени
    boolean keyTime=false;
    //ключ для того если приложение закрылось поток уснул
    boolean keyProgramClose=false;
//имя проги
    String s=MyTimer.s;
    @Override
    public void run() {

        while (!StartTrackingTheWorkOfPrograms.executorService.isShutdown()) {
         //   System.out.println("ждем");
            //прогоняем цикл
            //не работает тут
            synchronized (listRunActual) {

                for (int j = 0; j < listRunActual.size(); j++) {
                    if (listRunActual.get(j).contains(s)) {
                        run=true;
                        break;
                    //    System.out.println(listRunActual.get(j).contains(s) + "11111111111111111111111");
                    }
                    else run=false;
                 //   runFalse = false;


                }
              //  System.out.println(run+s);
                    //если  наше приложение остановилось
                    if (run==false) {
                        if (runFalse == false) {
                            //  System.out.println(listRunActual.contains(s));
                            //  System.out.println(listRunActual.get(j)+" ffffffffffffffffffffffffffff");
                            //если приложение не включено то сигнал остановки работы потока

                          //  System.out.println("ostanovka");
                         //   Thread.currentThread().interrupt();

                            //время работы программы при остановке работы приложения
                            elapsedTimeInterrupt = System.currentTimeMillis() - startTime;

                            //если мы закрывали прогармму то суммируем время с текущим и обновляем стартовое время
                            sumTime+=elapsedTimeInterrupt;

                            System.out.println(s + " поток остановился и проработал " + elapsedTimeInterrupt);
                            //если если сигнал оно останавливается и проверяется запущено ли приложение снова
                            runFalse=true;
                            keyTime=true;
                            keyProgramClose=true;
                        }
                    }
             //   System.out.println(Thread.currentThread().isInterrupted());
                            if (keyProgramClose==true) {
                               // System.out.println("kaka");


                                for (int j = 0; j < listRunActual.size(); j++) {
                                    if (listRunActual.get(j).contains(s)) {
                                   //     System.out.println(listRunActual.get(j).contains(s) + " kaka");
                                        //если прога перезапущена то обновляем время ее старта
                                        startTime = System.currentTimeMillis();
                                      //  run = true;
                                        runFalse = false;
                                        keyProgramClose = false;
                                        //  Thread.currentThread().run();
                                        System.out.println("zapushen");
                                        break;
                                        //    System.out.println(listRunActual.get(j).contains(s) + "11111111111111111111111");
                                    }
                                }
                                    try {

                                     //   System.out.println(Thread.currentThread().getName());
                                    //    System.out.println(Thread.currentThread().getState());
                                        Thread.sleep(3000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }





//                        for (int j = 0; j < listRunActual.size(); j++) {
//                            if (listRunActual.get(j).contains(s)) {
//                                //если прога перезапущена то обновляем время ее старта
//                                startTime=System.currentTimeMillis();
//                                run=true;
//                                runFalse=false;
//
//                                Thread.currentThread().run();
//                                System.out.println("zapushen");
//                                break;
//                                //    System.out.println(listRunActual.get(j).contains(s) + "11111111111111111111111");
//                            }
                         //   else run=false;
                         //   runFalse=false;



                            //если запущено то запускается опять
//                            if (listRunActual.contains(s)) {
//                                run=true;
//
//runFalse=false;
//                            }
                        }
                    }

         //   }





//                for (int j = 0; j < listRunActual.size(); j++) {
//                 //   System.out.println(s+"11111111111111111111111");
//                    //если есть наше приложение
//                    if (listRunActual.get(j).toString().contains(s)) {
//                      //  System.out.println(listRunActual.get(j)+" ffffffffffffffffffffffffffff");
//                        //если приложение не включено то сигнал остановки работы потока
//                        if (!listRunActual.get(j).toString().contains(" 1")) {
//                            System.out.println("ostanovka");
//                            Thread.currentThread().interrupt();
//                            System.out.println("suka");
//                            //время работы программы при остановке работы приложения
//                            elapsedTimeInterrupt = System.currentTimeMillis() - startTime;
//                            System.out.println(s + " поток остановился и проработал " + elapsedTimeInterrupt);
//                            //если если сигнал оно останавливается и проверяется запущено ли приложение снова
//                        }
//                     else    if (Thread.currentThread().isInterrupted()) {
//
//
//                            //если запущено то запускается опять
//                            if (listRunActual.get(j).toString().contains(" 1")) {
//                                Thread.currentThread().run();
//
//                            }
//                        }
//                    }
//                }
//            }
        }
        if (StartTrackingTheWorkOfPrograms.executorService.isShutdown()) {
          //  AllStaticData.workTimer=false;
            if (keyTime==false) {

                elapsedTime = (System.currentTimeMillis() - startTime) ;
            }
            //если мы перезапускали программу то такая формула
            else if (keyTime==true){
                elapsedTime =(System.currentTimeMillis() - startTime) + sumTime;
            }
            System.out.println(s+" "+elapsedTime);
        }
        getDurationBreakdown(elapsedTime);
        WorkingHours workingHours=new WorkingHours(currentDate.toString(),s,getDurationBreakdown(elapsedTime));
        DatabaseHandler handler=new DatabaseHandler();
        handler.saveWORKINGHOURS(workingHours,AllStaticData.login);

    //    System.out.println(currentDate.toString()+"fdaaaaaaaaaaaaaaaa");
      //  System.out.println(getDurationBreakdown(elapsedTime)+"ffffffffffffffffffffffffffffff");
    }
    public  String getDurationBreakdown(long millis) {
        if(millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

      //  long days = TimeUnit.MILLISECONDS.toDays(millis);
      //  millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
      //  sb.append(days);
     //   sb.append(" Дней ");
        sb.append(hours);
        sb.append(" Часов ");
        sb.append(minutes);
        sb.append(" Минут ");
        sb.append(seconds);
        sb.append(" Секунд");

        return(sb.toString());
    }
}