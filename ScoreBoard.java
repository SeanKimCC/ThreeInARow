import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class ScoreBoard extends JFrame
{
    static JLabel scoreBoard = new JLabel("Red : "+ "0" + "     " +"Blue : " + "0"); // makes a scoreboard label object
    public ScoreBoard(String s)
    {
        super(s);
        JPanel panel = new JPanel();
        panel.add(scoreBoard);
        add(panel); // don't really know what these do, just know that they have to be there.
        setSize(300, 100); // size
        setLocation(800,0); // location
        setVisible(true); 
    }
}
