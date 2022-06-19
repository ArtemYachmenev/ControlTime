package sample.Модель;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Objects;
import static sample.Модель.AllStaticData.*;
//тут можно сделать два способа или просто отслеживать координаты мышки или отслеживать нажатие и тп, но для этого надо разворачивать окно поверх окна винды
//пока будут просто координаты
public class MouseTracking  implements MouseListener, MouseMotionListener, Runnable {

    double mouseX=1.0;
    double mouseY=1.0;
    double resultX=0;
    double resultY=0;
    @Override
    public void run() {
        while (!executorServiceStartTrackingTheWorkOfPrograms.isShutdown()){
            mouseX=MouseInfo.getPointerInfo().getLocation().getX();
            mouseY=MouseInfo.getPointerInfo().getLocation().getY();
            if (Objects.equals(mouseX,resultX)==true&&Objects.equals(mouseY,resultY)==true){

                AllStaticData.workMouse=false;

            }
            else   {
                AllStaticData.workMouse=true;
            }
            resultX=mouseX;
            resultY=mouseY;
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
