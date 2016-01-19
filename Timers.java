import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Timers extends JFrame {
    static Timer t1;    
    static int startTime = 20;
    static JLabel label = new JLabel("20"); // makes a new label for timer

    public Timers(String s) {
        super(s);

        JPanel panel = new JPanel();
        label = new JLabel("");
        panel.add(label);
        add(panel);

        setSize(300, 100); //size
        setLocation(500,80);//location
        setVisible(true);

        t1 = new Timer();

        t1.scheduleAtFixedRate(new TimerTask()
            {
                public void run()
                {

                    if (setTime() > 1)
                    {
                        label.setText(startTime + " "); // uses the timer to set the text of the label
                    }
                    else //when timer is 0, turn variable in main class will be changed to 1
                    {
                        label.setText("0"); 
                        main.turn = 1;
                    }

                }
            }, 1000,1000);
    }

    public static final int setTime() // when time is 1, timer is cancelled
    {
        if (startTime == 1 )
        {
            t1.cancel();
        }
        return --startTime;
    }
}

