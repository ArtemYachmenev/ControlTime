package sample.controller;

import java.io.*;

public class DownloadAndSaveConfigApp implements Serializable {


    //сохраняем цвета приложения
    public void saveColorApp(String up, String down){
        try (FileOutputStream fs = new FileOutputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\saveUp.txt");
             ObjectOutputStream os = new ObjectOutputStream(fs)) {
            //пишет в начале иероглифы
            os.writeObject(up);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileOutputStream fs = new FileOutputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\saveDown.txt");
             ObjectOutputStream os = new ObjectOutputStream(fs)) {
            //пишет в начале иероглифы
            os.writeObject(down);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //загружаем цвета приложения
    public void DownloadColorApp(){
        ChangingTheAppColor color=new ChangingTheAppColor();
        String colorUp=null;
        String colorDown=null;
        try (FileInputStream fis = new FileInputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\saveUp.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            colorUp = (String) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (FileInputStream fis = new FileInputStream("C:\\Users\\iachm\\IdeaProjects\\ControlTime\\saveDown.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            colorDown = (String) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //загруженные цвета устанавливаем в цвет приложения
        color.changeColorApp(colorUp,colorDown);

    }
}
