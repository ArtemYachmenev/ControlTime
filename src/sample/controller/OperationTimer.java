package sample.controller;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import static sample.controller.AllStaticData.goWork;
import static sample.controller.AllStaticData.oneProgAndEXE;

//import static sample.controller.AllStaticData.goWork;

//отслеживает состояния ехе рпограмм
public class OperationTimer implements Runnable {

    //нужно чтобы читались состояния ехе приложения и если есть хоть один тру
    //запускать таймер отсечта времени
    //надо заного искать имена приложений и их количество ехе
    //
    //

    //лист который хранит названия приложений и их состояния
    ArrayList<String> prog = new ArrayList<>();
    //хранит имя приложения и состояния ехе
    ArrayList<Object> trueOrFalse = new ArrayList<>();
    //хранит в себе имя приложения и общее состояние
    ArrayList<Object> goWork = new ArrayList<>();
    //проверка на хотя бы один тру программы
//
    ExecutorService executorService;
int count=0;



    //тут надо из одного листа считать названия приложений и их ехе и наложить их значения в prog
    @Override
    public void run() {


        while (!StartTrackingTheWorkOfPrograms.executorService.isShutdown()) {
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

            for (int i = 0; i < AllStaticData.nameProgCountEXE.size(); i++) {
                if (AllStaticData.nameProgCountEXE.get(i).contains("***** ")) {
                    firstIndex = AllStaticData.nameProgCountEXE.get(i).indexOf(" ");

                    s = AllStaticData.nameProgCountEXE.get(i).substring(firstIndex + 1, AllStaticData.nameProgCountEXE.get(i).length());
                    //     System.out.println(s + " ppppppppppppppppppppppp");


                    prog.add("***** " + s);
                for (int j = 0; j < AllStaticData.workApp.size(); j++) {



                            //    if (Objects.equals(list.get(i),list2.get(j))) {
                            for (int k = i + 1; k < AllStaticData.nameProgCountEXE.size(); k++) {

                                if (!AllStaticData.nameProgCountEXE.get(k).contains("***** ")) {
                                    if (AllStaticData.workApp.get(j).trim().contains(AllStaticData.nameProgCountEXE.get(k).trim())) {
                                        prog.add(AllStaticData.workApp.get(j));
                                    }
                                }  if (AllStaticData.nameProgCountEXE.get(k).contains("***** ")) {
                                    break;
                                }
                            }
                        }

                    }

                }



//                for (int i = 0; i < prog.size(); i++) {
//
//                    System.out.println(prog.get(i)+" vvvvvvvvvvvvvvvvvvvv");
//                }

                //берем только состояния ехе и названия приложений
            for (int i = 0; i < prog.size(); i++) {
                if (prog.get(i).contains("***** ")) {
                    firstIndex = prog.get(i).indexOf(" ");

                    s = prog.get(i).substring(firstIndex + 1, prog.get(i).length());
                    //     System.out.println(s + " ppppppppppppppppppppppp");


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
//            for (int i = 0; i < trueOrFalse.size(); i++) {
//
//                System.out.println(trueOrFalse.get(i)+" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//            }

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
//            for (int i = 0; i < goWork.size(); i++) {
//
//                System.out.println(goWork.get(i));
//            }


            //чистим от дубликатов ехе
            for (int i = 0; i < goWork.size(); i++) {
                if (goWork.get(i).toString().contains("***** ")) {
                    firstIndex = goWork.get(i).toString().indexOf(" ");

                    s = goWork.get(i).toString().substring(firstIndex + 1, goWork.get(i).toString().length());
                    //     System.out.println(s + " ppppppppppppppppppppppp");


                    oneProgAndEXE.add("***** "+s);
count++;
                    for (int k = i + 1; k < goWork.size(); k++) {

                        if (!goWork.get(k).toString().contains("***** ")) {
                            if (goWork.get(k).toString().contains("true"))
                                oneProgAndEXE.add("true");
break;
                        }


                        if (goWork.get(k).toString().contains("***** ")) {
                            break;
                        }
                    }

                }
            }


//            for (int i = 0; i < oneProgAndEXE.size(); i++) {
//
//                System.out.println(oneProgAndEXE.get(i)+" ");
//            }

            //надо чтобы после запуска таймера если приложение включилось оно отслеживалось
            //может сделать алгоритм где после программы есть тру надо запускать его а если нет то опять цикл проходить а сзапущенное пропускать
            if (AllStaticData.workTimer==false){
                AllStaticData.workTimer=true;
                executorService= Executors.newFixedThreadPool(count);
                executorService.execute(new MyTimer());
            }



            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        }

















  //  @Override
    public Object call() throws Exception {
        while (!StartTrackingTheWorkOfPrograms.executorService.isShutdown()) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prog.clear();

            int firstIndex = 0;
            int lastIndex = 0;
            String s;


            for (int i = 0; i < AllStaticData.nameProgCountEXE.size(); i++) {
                if (AllStaticData.nameProgCountEXE.get(i).contains("***** ")) {
                    firstIndex = AllStaticData.nameProgCountEXE.get(i).indexOf(" ");

                    s = AllStaticData.nameProgCountEXE.get(i).substring(firstIndex + 1, AllStaticData.nameProgCountEXE.get(i).length());
                    //     System.out.println(s + " ppppppppppppppppppppppp");


                    prog.add("***** " + s);
                    for (int j = 0; j < AllStaticData.workApp.size(); j++) {



                        //    if (Objects.equals(list.get(i),list2.get(j))) {
                        for (int k = i + 1; k < AllStaticData.nameProgCountEXE.size(); k++) {

                            if (!AllStaticData.nameProgCountEXE.get(k).contains("***** ")) {
                                if (AllStaticData.workApp.get(j).trim().contains(AllStaticData.nameProgCountEXE.get(k).trim())) {
                                    prog.add(AllStaticData.workApp.get(j));
                                }
                            }  if (AllStaticData.nameProgCountEXE.get(k).contains("***** ")) {
                                break;
                            }
                        }
                    }

                }

            }



//                for (int i = 0; i < prog.size(); i++) {
//
//                    System.out.println(prog.get(i)+" vvvvvvvvvvvvvvvvvvvv");
//                }

            //берем только состояния ехе и названия приложений
            for (int i = 0; i < prog.size(); i++) {
                if (prog.get(i).contains("***** ")) {
                    firstIndex = prog.get(i).indexOf(" ");

                    s = prog.get(i).substring(firstIndex + 1, prog.get(i).length());
                    //     System.out.println(s + " ppppppppppppppppppppppp");


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
//            for (int i = 0; i < trueOrFalse.size(); i++) {
//
//                System.out.println(trueOrFalse.get(i)+" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//            }

            //достаем имя приложения и его общее состояние
            for (int i = 0; i < trueOrFalse.size(); i++) {
                if (trueOrFalse.get(i).toString().contains("***** ")) {
                    firstIndex = trueOrFalse.get(i).toString().indexOf(" ");

                    s = trueOrFalse.get(i).toString().substring(firstIndex + 1, trueOrFalse.get(i).toString().length());
                    //     System.out.println(s + " ppppppppppppppppppppppp");


                    goWork.add(s);

                    for (int k = i + 1; k < trueOrFalse.size(); k++) {

                        if (!trueOrFalse.get(k).toString().contains("***** ")) {
                            if (trueOrFalse.get(k).toString().contains("true"))

                                goWork.add("***** true");


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
                    //     System.out.println(s + " ppppppppppppppppppppppp");


                    oneProgAndEXE.add(s);

                    for (int k = i + 1; k < goWork.size(); k++) {

                        if (!goWork.get(k).toString().contains("***** ")) {
                            if (goWork.get(k).toString().contains("true"))
                                oneProgAndEXE.add("***** true");

                        }
                        if (Objects.equals(goWork.get(k).toString(),goWork.get(k+1).toString()))
                        {
                            break;
                        }

                        if (goWork.get(k).toString().contains("***** ")) {
                            break;
                        }
                    }
                }
            }


            for (int i = 0; i < oneProgAndEXE.size(); i++) {

                System.out.println(oneProgAndEXE.get(i)+" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            }
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return oneProgAndEXE;
    }

//    public void checkingTheApplicationLaunch() {
//
//        int firstIndex = 0;
//        int lastIndex = 0;
//        String s;
//
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        for (int i = 0; i < prog.size(); i++) {
//            if (prog.get(i).contains("***** ")) {
//                firstIndex = prog.get(i).indexOf(" ");
//
//                s = prog.get(i).substring(firstIndex + 1, AllStaticData.nameProgCountEXE.get(i).length());
//                //     System.out.println(s + " ppppppppppppppppppppppp");
//
//
//                trueOrFalse.add(s);
//
//                    for (int k = i + 1; k < prog.size(); k++) {
//
//                        if (!prog.get(k).contains("***** ")) {
//
//                            trueOrFalse.add(prog.get(k));
//
//                        }  if (prog.get(k).contains("***** ")) {
//                            break;
//                        }
//                    }
//                }
//            }
//        for (int i = 0; i < trueOrFalse.size(); i++) {
//
//            System.out.println(trueOrFalse.get(i)+" vvvvvvvvvvvvvvvvvvvv");
//        }
//
//        }
}
