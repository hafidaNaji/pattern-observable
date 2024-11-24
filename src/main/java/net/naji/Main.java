package net.naji;

import net.naji.obs.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        Observer o1 = new ObserverImpl1();
        Observer o2 = new ObserverImpl2();
        observable.subscribe(o1);

        observable.subscribe(new Observer() {
            @Override
            public void update(Observable o) {
                if(o instanceof ObservableImpl obs){
                    System.out.println("+++++++++++Obs Impl 3+++++++++++++++");
                    System.out.println("Res = " +((ObservableImpl) o).getState() * Math.cos(((ObservableImpl) o).getState()));
                    System.out.println("++++++++++++++++++++++++++++++++");
                }

            }
        });

        observable.subscribe((obs) -> {
            if(obs instanceof ObservableImpl o){
                System.out.println("+++++++++++Obs Impl 3+++++++++++++++");
                System.out.println("Res = " +o.getState() * Math.cos(o.getState()));
                System.out.println("++++++++++++++++++++++++++++++++");
            }

        });
        observable.setState(60);
        observable.setState(80);
        observable.subscribe(o2);
        observable.setState(100);

        Button button =new Button("ok");
        button.addActionListener(e -> {
            System.out.println(e.getSource());
        });
    }
}