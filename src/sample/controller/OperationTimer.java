package sample.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class OperationTimer implements Runnable {

    //нужно чтобы читались состояния ехе приложения и если есть хоть один тру
    //запускать таймер отсечта времени
    //надо заного искать имена приложений и их количество ехе
    //
    //

    //лист который хранит названия приложений и их состояния
    ArrayList<String> prog = new ArrayList<>();

    //тут надо из одного листа считать названия приложений и их ехе и наложить их значения в prog
//    public void checkingTheApplicationLaunch() {
//
//        System.out.println("huifffffffffffffffffffffffff");
//
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            prog.clear();
//            for (int i = 0; i < AllStaticData.nameProgCountEXE.size(); i++) {
//                for (int j = 0; j < AllStaticData.workApp2.size(); j++) {
//                    if (AllStaticData.nameProgCountEXE.get(i).contains("***** ")) {
//                        prog.add(AllStaticData.nameProgCountEXE.get(i));
//                        for (int k = i + 1; k < AllStaticData.nameProgCountEXE.size(); k++) {
//                            //&& nameProgAndEXE.get(k).contains(workApp.get(j))
//                            if (!AllStaticData.nameProgCountEXE.get(k).contains("***** ")) {
//                                prog.add(AllStaticData.workApp2.get(j));
//                            } else break;
//                        }
//
//
//                    }
//
//                }
//            }
//            for (int i = 0; i < prog.size(); i++) {
//
//                System.out.println(prog.get(i)+" vvvvvvvvvvvvvvvvvvvv");
//            }
//
//
//
//    }


    @Override
    public void run() {


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














//копия
//            for (int i = 0; i < AllStaticData.nameProgCountEXE.size(); i++) {
//
//                if (AllStaticData.nameProgCountEXE.get(i).contains("***** ")) {
//                    //  System.out.println(AllStaticData.nameProgCountEXE.get(i));
//                    prog.add(AllStaticData.nameProgCountEXE.get(i));
//                    for (int k = i + 1; k < AllStaticData.nameProgCountEXE.size(); k++) {
//                        for (int j = 0; j < AllStaticData.workApp.size(); j++) {
//                            if (!AllStaticData.nameProgCountEXE.get(k).contains("***** ")) {
//                                if (AllStaticData.workApp.get(j).trim().contains(AllStaticData.nameProgCountEXE.get(k).trim())) {
//                                    prog.add(AllStaticData.workApp.get(j));
//                                }
//                            } else break;
//
//                        }
//
//                    }
//
//
//                }
//            }


//                for (int i = 0; i < AllStaticData.nameProgCountEXE.size(); i++) {
//                    for (int j = 0; j < AllStaticData.workApp.size(); j++) {
//                        if (AllStaticData.nameProgCountEXE.get(j).contains("***** ")) {
//                            firstIndex = AllStaticData.nameProgCountEXE.get(i).indexOf(" ");
//
//                            s = AllStaticData.nameProgCountEXE.get(i).substring(firstIndex + 1, AllStaticData.nameProgCountEXE.get(i).length());
//                            //     System.out.println(s + " ppppppppppppppppppppppp");
//                            if (AllStaticData.nameProgCountEXE.get(i).contains(s)) {
//
//                                prog.add("***** " + s);
//
//
//                                //    if (Objects.equals(list.get(i),list2.get(j))) {
//                                for (int k = i + 1; k < AllStaticData.nameProgCountEXE.size(); k++) {
//
//                                    if (!AllStaticData.nameProgCountEXE.get(k).contains("***** ")) {
//                                        if (AllStaticData.workApp.get(j).contains(AllStaticData.nameProgCountEXE.get(k))) {
//                                            prog.add(AllStaticData.workApp.get(i));
//                                        }
//                                    } else break;
//                                }
//                            }
//                        }
//
//                    }
//                }

//удаляем дубликаты
//                Set<String> set = new HashSet<String>(prog);
//                String[] result = set.toArray(new String[set.size()]);
//                prog.clear();
//                //присваиваем листам значения массивов
//                for (String l : result) {
//                    //   cleanListBuilder.add(l);
//                    //  System.out.println(list+" лист использования");
//                    prog.add(l);
//                }


                for (int i = 0; i < prog.size(); i++) {

                    System.out.println(prog.get(i)+" vvvvvvvvvvvvvvvvvvvv");
                }

            }

        }
    }

// старый код длясоединения названий прог и состояний их ехе
//                for (int i = 0; i < AllStaticData.nameProgCountEXE.size(); i++) {
//                    for (int j = 0; j < AllStaticData.workApp.size(); j++) {
//                        if (AllStaticData.nameProgCountEXE.get(i).contains("***** ")) {
//                            prog.add(AllStaticData.nameProgCountEXE.get(i));
//                            for (int k = i + 1; k < AllStaticData.nameProgCountEXE.size(); k++) {
//                                //&& nameProgAndEXE.get(k).contains(workApp.get(j))
//                                if (!AllStaticData.nameProgCountEXE.get(k).contains("***** ")&& !AllStaticData.nameProgCountEXE.get(k).equals(null)) {
//                                    prog.add(AllStaticData.workApp.get(j));
//                                }
//                                if (AllStaticData.nameProgCountEXE.get(k).contains("***** ")) {
//                                    break;
//                                };
//                            }
//
//
//                        }
//
//                    }
//                }