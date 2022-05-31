package sample.controller;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

//тут можно сделать два способа или просто отслеживать координаты мышки или отслеживать нажатие и тп, но для этого надо разворачивать окно поверх окна винды
//пока будут просто координаты
public class MouseTracking  implements MouseListener, MouseMotionListener, Runnable {


//тут для отслеживания координат
    double mouseX=1.0;
    double mouseY=1.0;
    double resultX=0;
    double resultY=0;
    //ключ для работы метода
boolean keyRun=true;


//это для второго варианты берет размер экрана винды
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    int width = screenSize.width;
    int height = screenSize.height;


    //для отслеживания координат
    public void mouseMove(){

      //  while (mouseX!=0 || mouseY!=0){
       // while (keyRun==true){
        while (!StartTrackingTheWorkOfPrograms.executorService.isShutdown()){
            mouseX=MouseInfo.getPointerInfo().getLocation().getX();
            mouseY=MouseInfo.getPointerInfo().getLocation().getY();
            if (Objects.equals(mouseX,resultX)&&Objects.equals(mouseY,resultY)){
                //чтобы поток записывающий время спал
            }
            resultX=mouseX;
            resultY=mouseY;

            System.out.println(mouseX+" "+mouseY);
        }

    }

    @Override
    public void run() {
        while (!StartTrackingTheWorkOfPrograms.executorService.isShutdown()){
            mouseX=MouseInfo.getPointerInfo().getLocation().getX();
            mouseY=MouseInfo.getPointerInfo().getLocation().getY();
            if (Objects.equals(mouseX,resultX)==true&&Objects.equals(mouseY,resultY)==true){
                //чтобы поток записывающий время спал
                AllStaticData.workMouse=false;
              //  System.out.println(Objects.equals(mouseX,resultX)&&Objects.equals(mouseY,resultY));

            //    System.out.println("нет движения");
            }
            else   {
             //   System.out.println(Objects.equals(mouseX,resultX)&&Objects.equals(mouseY,resultY));
                AllStaticData.workMouse=true;
            }
            resultX=mouseX;
            resultY=mouseY;
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //    System.out.println(mouseX+" "+mouseY);
        }
    }




    //методы для отследивания работы мыши в наложенном окне на окно винды
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("najata");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("otpushena");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("voshla");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("vishla");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("tashitsa");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("dvijetsya");
    }


}
