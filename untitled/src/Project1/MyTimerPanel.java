package Project1;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

/**********************************************************************************************************
 * CIS 163 01 Project One
 *GUI
 * Creates a graphical user interface that references the GeoCountDownTimer class
 *@author Keilani Bailey & Shayla Hinkley
 *@version 1.0
 **********************************************************************************************************/
public class MyTimerPanel extends JPanel {
        private GeoCountDownTimer geoCountDownTimer1;

    private Timer javaTimer1;
    private Timer javaTimer2;
    private Timer javaTimer3;
    private TimerListener timer1;

    private JLabel display1;
    private JLabel display2;
    private JLabel display3;

    private JButton start1;
    private JButton stop1;
    private JButton reset1;
    private JButton save1;
    private JButton load1;
    private JButton Increase1;
    private JButton decrease1;

    public MyTimerPanel() {
        geoCountDownTimer1 = new GeoCountDownTimer(2019,12,10);
        timer1 = new TimerListener();

        // this calls timer object 10 times per second
        javaTimer1 = new Timer(10, timer1);

        JPanel GeoCoundown1 = new JPanel();
        GeoCoundown1.setLayout(new FlowLayout());
        start1 = new JButton("Start");
        stop1 = new JButton("Stop");
        reset1 = new JButton("Reset");
        load1 = new JButton("Load");
        save1 = new JButton("Save");
        Increase1 = new JButton("Inc");
        decrease1 = new JButton("Dec");
        display1 = new JLabel("");

        GeoCoundown1.add(display1);
        GeoCoundown1.add(start1);
        GeoCoundown1.add(stop1);
        GeoCoundown1.add(reset1);
        GeoCoundown1.add(Increase1);
        GeoCoundown1.add(decrease1);
        GeoCoundown1.add(save1);
        GeoCoundown1.add(load1);

        add(GeoCoundown1);
        start1.addActionListener(new ButListener());
        stop1.addActionListener(new ButListener());
        reset1.addActionListener(new ButListener());
        Increase1.addActionListener(new ButListener());
        decrease1.addActionListener(new ButListener());
        save1.addActionListener(new ButListener());
        load1.addActionListener(new ButListener());


// There is a problem here, your demonstration of your program could take years.  So, you can
// assume that every time the timer object is called equals one day.  So, in about 3 seconds would be
// a month.   That is how you can speed up time.

        javaTimer1.start();
    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            geoCountDownTimer1.inc();
            display1.setText(geoCountDownTimer1.toDateString());

            if (geoCountDownTimer1.equals(new GeoCountDownTimer("12/12/2222"))) {
                System.out.println ("Time is up!");
                javaTimer1.stop();
            }
        }
    }

    private class ButListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == start1){
                javaTimer1.start();
            }
            if(e.getSource() == stop1){
                javaTimer1.stop();
            }
            if(e.getSource() == reset1){
                geoCountDownTimer1 = new GeoCountDownTimer(2019,1,1);
            }
            if(e.getSource() == Increase1){
                geoCountDownTimer1.inc();
                display1.setText(geoCountDownTimer1.toDateString());

//                num++;
//                numLabel.setText("" + num);
//                geoCountDownTimer1 = new GeoCountDownTimer(2019,1,+1);
//                return geoCountDownTimer1++;

            }
            if(e.getSource() == decrease1){
                geoCountDownTimer1.dec();
                display1.setText(geoCountDownTimer1.toDateString());
//                geoCountDownTimer1 = new GeoCountDownTimer(2019,1,-1);
            }
            if(e.getSource() == save1){
                geoCountDownTimer1.save("/Users/keilanibailey/Desktop/CIS163/CIS163Project1/timer1.txt");
//                JFileChooser save1 = new JFileChooser();

                display1.setText(geoCountDownTimer1.toDateString());
                System.out.println(geoCountDownTimer1+" "+"is "+"Saved");
            }
            if(e.getSource() == load1){
                geoCountDownTimer1.load("/Users/keilanibailey/Desktop/CIS163/CIS163Project1/timer1.txt");
//                JFileChooser save1 = new JFileChooser();

                display1.setText(geoCountDownTimer1.toDateString());
            }

        }

    }
    public void printTextField(String text) {
    }

    public static void  main(String[] args) {
        JFrame frame = new JFrame("GeoCountDownTimer");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        GeoCountDownTimer time = new GeoCountDownTimer();

        ThreePanels mainPanel = new ThreePanels();

        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);

        frame.pack();
    }
}