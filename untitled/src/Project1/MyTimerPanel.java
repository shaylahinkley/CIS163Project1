package Project1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;


public class MyTimerPanel extends JPanel{
    //    private GeoCountDownTimer geoCountDownTimer;
//    private GeoCountDownTimer geoCountDownTimer2;
//
//    private Timer javaTimer;
//    private TimerListener timer;
//    private JLabel label;
//    private JButton button;
//
//    public MyTimerPanel() {
//        geoCountDownTimer = new GeoCountDownTimer(2019,12,10);
//        geoCountDownTimer2 = new GeoCountDownTimer(2019,5,12);
//        timer = new TimerListener();
//        label = new JLabel("");
//        add (label);
//        button = new JButton("Stop");
//        add (button);
//        button.addActionListener(new ButListener());
//
//// this calls timer object 10 times per second
//        javaTimer = new Timer(10, timer);
//
//// There is a problem here, your demonstration of your program could take years.  So, you can
//// assume that every time the timer object is called equals one day.  So, in about 3 seconds would be
//// a month.   That is how you can speed up time.
//
//        javaTimer.start();
//    }
//
//    private class TimerListener implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//
//            geoCountDownTimer2.inc();
//            label.setText(geoCountDownTimer2.toDateString());
//
//            if (geoCountDownTimer.equals(geoCountDownTimer2)) {
//                System.out.println ("Time is up!");
//                javaTimer.stop();
//            }
//        }
//    }
//
//    private class ButListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            javaTimer.stop();
//        }
//
//    }
}