package sample.Модель;

import sample.Модель.Database.DatabaseHandler;
import sample.Модель.Database.WorkingHours;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static sample.Модель.AllStaticData.*;


public class MyTimer implements Runnable{

    int firstIndex = 0;
    int lastIndex = 0;
 static volatile   String s;

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
        executorService= Executors.newSingleThreadExecutor();

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
                            }

                        }
                        if (AllStaticData.listRunProg2.get(k).toString().contains("***** ")) {
                            break;
                        }
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
    //полное сохранение времени
    long sumTime=0;
    boolean run;
    //ключ для остановки потока
    boolean runFalse=false;
    //ключ для определения отсчета времени
    boolean keyTime=false;
    //ключ для того если приложение закрылось поток уснул
    boolean keyProgramClose=false;
    //ключ для одинарного отсчета времени если мышь не двигается
    boolean keyMouse=true;
//имя проги
    String s=MyTimer.s;
    @Override
    public void run() {

        while (!executorServiceStartTrackingTheWorkOfPrograms.isShutdown()) {

            //если мышка двигается то идет запись времени
            if (workMouse==true) {
                keyMouse=true;
                synchronized (listRunActual) {

                    for (int j = 0; j < listRunActual.size(); j++) {
                        if (listRunActual.get(j).contains(s)) {
                            run = true;
                            break;

                        } else run = false;
                    }
                    //если  наше приложение остановилось
                    if (run == false) {
                        if (runFalse == false) {


                            //время работы программы при остановке работы приложения
                            elapsedTimeInterrupt = System.currentTimeMillis() - startTime;


                            //если мы закрывали прогармму то суммируем время с текущим и обновляем стартовое время
                            sumTime = sumTime + elapsedTimeInterrupt;

                            System.out.println(s + " поток остановился и проработал " + elapsedTimeInterrupt);
                            //если если сигнал оно останавливается и проверяется запущено ли приложение снова
                            runFalse = true;
                            keyTime = true;
                            keyProgramClose = true;
                        }
                    }

                    if (keyProgramClose == true) {
                        for (int j = 0; j < listRunActual.size(); j++) {
                            if (listRunActual.get(j).contains(s)) {

                                startTime = System.currentTimeMillis();

                                runFalse = false;
                                keyProgramClose = false;
                                //  Thread.currentThread().run();
                                System.out.println("zapushen");
                                break;
                            }
                        }
                        try {

                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
            else {
if (keyMouse==true) {
    //время работы программы при остановке работы приложения
    elapsedTimeInterrupt = System.currentTimeMillis() - startTime;


    //если мы закрывали прогармму то суммируем время с текущим и обновляем стартовое время
    sumTime = sumTime + elapsedTimeInterrupt;
    startTime = System.currentTimeMillis();

    System.out.println(s + " поток остановился и проработал " + elapsedTimeInterrupt);
    System.out.println("мышь не двигается");
    keyMouse=false;
}
                try {

                    Thread.sleep(300000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (executorServiceStartTrackingTheWorkOfPrograms.isShutdown()) {
          //  AllStaticData.workTimer=false;
            if (keyTime==false) {

                elapsedTime = (System.currentTimeMillis() - startTime) +sumTime;
            }
            //если мы перезапускали программу то такая формула
            //сделать нормальный отсечт времени
            else if (keyTime==true){
                    elapsedTime=sumTime;

            }
            System.out.println(s+" "+elapsedTime);
        }
        getDurationBreakdown(elapsedTime);

        String res= String.valueOf(currentDate).substring(11,19);
        Date utilStartDate = currentDate;
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());


        WorkingHours workingHours=new WorkingHours(sqlStartDate,res,s,getDurationBreakdown(elapsedTime));
        DatabaseHandler handler=new DatabaseHandler();
        handler.saveWorkingHours(workingHours, login);
executorService.shutdown();
    }
    public  String getDurationBreakdown(long millis) {
        if(millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);

        sb.append(hours);
        sb.append(" Часов ");
        sb.append(minutes);
        sb.append(" Минут ");
        sb.append(seconds);
        sb.append(" Секунд");

        return(sb.toString());
    }
}