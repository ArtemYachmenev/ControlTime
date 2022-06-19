package sample.Модель;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import static sample.controller.AllStaticData.goWork;
import static sample.Модель.AllStaticData.*;


//import static sample.controller.AllStaticData.goWork;

//отслеживает состояния ехе рпограмм
public class OperationTimer implements Runnable {


    //лист который хранит названия приложений и их состояния
    ArrayList<String> prog = new ArrayList<>();
    //хранит имя приложения и состояния ехе
    ArrayList<Object> trueOrFalse = new ArrayList<>();
    //хранит в себе имя приложения и общее состояние
    ArrayList<Object> goWork = new ArrayList<>();


    ExecutorService executorService;
int count=0;

    @Override
    public void run() {

        countProg=false;
        listRunProg.clear();
        listRunProg2.clear();
        listRunIndex.clear();
        listRunActual.clear();
        while (!executorServiceStartTrackingTheWorkOfPrograms.isShutdown()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            prog.clear();
            trueOrFalse.clear();
            goWork.clear();
            oneProgAndEXE.clear();
            int firstIndex = 0;
            int lastIndex = 0;
            String s;
            count=0;
            listRunProg.clear();
            for (int i = 0; i < nameProgCountEXE.size(); i++) {
                if (nameProgCountEXE.get(i).contains("***** ")) {
                    firstIndex = nameProgCountEXE.get(i).indexOf(" ");

                    s = nameProgCountEXE.get(i).substring(firstIndex + 1, nameProgCountEXE.get(i).length());
                    prog.add("***** " + s);
                for (int j = 0; j < workApp.size(); j++) {

                            for (int k = i + 1; k < nameProgCountEXE.size(); k++) {

                                if (!nameProgCountEXE.get(k).contains("***** ")) {
                                    if (workApp.get(j).trim().contains(nameProgCountEXE.get(k).trim())) {
                                        prog.add(workApp.get(j));
                                    }
                                }  if (nameProgCountEXE.get(k).contains("***** ")) {
                                    break;
                                }
                            }
                        }

                    }

                }

                //берем только состояния ехе и названия приложений
            for (int i = 0; i < prog.size(); i++) {
                if (prog.get(i).contains("***** ")) {
                    firstIndex = prog.get(i).indexOf(" ");

                    s = prog.get(i).substring(firstIndex + 1, prog.get(i).length());
                    trueOrFalse.add("***** "+s);

                    for (int k = i + 1; k < prog.size(); k++) {

                        if (!prog.get(k).contains("***** ")) {
                            firstIndex = prog.get(k).lastIndexOf(" ");

                            s = prog.get(k).substring(firstIndex + 1, prog.get(k).length());


                            trueOrFalse.add(s);

                        }  if (prog.get(k).contains("***** ")) {
                            break;
                        }
                    }
                }
            }
            //достаем имя приложения и его общее состояние
            for (int i = 0; i < trueOrFalse.size(); i++) {
                if (trueOrFalse.get(i).toString().contains("***** ")) {
                    firstIndex = trueOrFalse.get(i).toString().indexOf(" ");

                    s = trueOrFalse.get(i).toString().substring(firstIndex + 1, trueOrFalse.get(i).toString().length());
                    //     System.out.println(s + " ppppppppppppppppppppppp");


                    goWork.add("***** "+s);

                    for (int k = i + 1; k < trueOrFalse.size(); k++) {

                        if (!trueOrFalse.get(k).toString().contains("***** ")) {
                            if (trueOrFalse.get(k).toString().contains("true"))

                            goWork.add("true");


                        }  if (trueOrFalse.get(k).toString().contains("***** ")) {
                            break;
                        }
                    }
                }
            }

            //чистим от дубликатов ехе
            for (int i = 0; i < goWork.size(); i++) {
                if (goWork.get(i).toString().contains("***** ")) {
                    firstIndex = goWork.get(i).toString().indexOf(" ");

                    s = goWork.get(i).toString().substring(firstIndex + 1, goWork.get(i).toString().length());
                    oneProgAndEXE.add("***** "+s);
count++;
                    for (int k = i + 1; k < goWork.size(); k++) {

                        if (!goWork.get(k).toString().contains("***** ")) {
                            if (goWork.get(k).toString().contains("true")) {
                                oneProgAndEXE.add("true");
                                //добавление в тестовый лист
                                listRunProg.add(s + " 1");
                                //   count++;
                                break;
                            }
                            else listRunProg.add(s+" 0");
                        }


                        if (goWork.get(k).toString().contains("***** ")) {
                            break;
                        }
                    }

                }
            }
            //если лист пустой до добавляем в него изначальные состояния
            synchronized (listRunActual) {
                if (listRunActual.size() != listRunProg.size()||listRunActual.isEmpty()) {
                    listRunActual.clear();
                    for (int i = 0; i < listRunProg.size(); i++) {
                        listRunActual.add(listRunProg.get(i));
                        System.out.println(listRunProg.get(i));
                    }
                 //   System.out.println("перезапись");
                }

            }

            if (countProg==false){
                countProg=true;
                countProgram=count;
                executorService = Executors.newFixedThreadPool(count);
            }

            synchronized (listRunProg2) {
                if (countProgram != 0) {
//можно сделать отсчет от соунт
//можно создать лист в который заносятся индексы запущенных программ после добавления в него при переборе его в цикле чтобы индексы не выпадали
//надо добавить список где наверно храняться индесы и если  совпадают значения то не запускать их

                    for (int k = 0; k < listRunProg.size(); k++) {

                            if (listRunProg.get(k).toString().contains("1")) {
                                lastIndex = listRunProg.get(k).toString().lastIndexOf(" ");

                                s = listRunProg.get(k).toString().substring(0, lastIndex);
                                if (listRunIndex.isEmpty()==true){
                                //    System.out.println("ddddddddddddddddddddddukaaaaaaaaaa");
                                    //добавление в новый тестовый лист2
                                    listRunProg2.add("***** " + s);
                                    listRunProg2.add("true");
                                    listRunIndex.add(listRunProg.get(k));
                                 //   System.out.println(s +" в работу1");
                                    executorService.execute(new MyTimer());
                                    countProgram--;
                                }
                                else {
                                    for (int i = 0; i < listRunActual.size(); i++) {

                                          if (listRunActual.get(i).contains( s)) {
                                            for (int l=0;l<listRunIndex.size();l++) {
                                                //если не найдется в общем списке то переделать может сделать contains по вырезанным именам
                                                if (!listRunIndex.contains(listRunActual.get(i))) {
                                                    listRunProg2.add("***** " + s);
                                                    listRunProg2.add("true");
                                                    listRunIndex.add(listRunProg.get(k));
                                                    executorService.execute(new MyTimer());
                                                    countProgram--;
                                                }
                                            }

                                    }
                                }
                            }
                        }
                    }

                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        }

}
