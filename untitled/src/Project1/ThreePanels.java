package Project1;

import javax.swing.*;
import java.awt.*;

public class ThreePanels extends JPanel {
    private MyTimerPanel p1;
    private MyTimerPanel p2;
    private MyTimerPanel p3;

    public ThreePanels  () {
        p1 = new MyTimerPanel();
        p2 = new MyTimerPanel();
        p3 = new MyTimerPanel();

        setLayout(new GridLayout(3,1));

        add (p1);
        add (p2);
        add (p3);

    }
}
