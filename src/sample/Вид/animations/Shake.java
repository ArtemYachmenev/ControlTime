package sample.Вид.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

// тряска объектов при непраильном вводе данных
public class Shake {
    private TranslateTransition tt;
//настройки анимации
    public Shake(Node node) {
        tt = new TranslateTransition(Duration.millis(100), node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }

    //играет анимацию shake

    public void playAnim(){
        tt.playFromStart();
    }
}
