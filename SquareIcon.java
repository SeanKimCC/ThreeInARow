import java.util.*;
import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Color;
import java.awt.geom.GeneralPath;
public class SquareIcon extends ShapeIcon
{
    public SquareIcon(Color color)
    {  
        this(color, 0.8);
    }

    public SquareIcon(Color color, double relativeSize)
    {  
        super(SquareIcon.shape, color, relativeSize);
    }

    private static GeneralPath shape;

    static
    // makes a square icon
    {   shape = new GeneralPath();
        shape.moveTo(0.1,0.1);
        shape.lineTo(0.9,0.1);
        shape.lineTo(0.9,0.9);
        shape.lineTo(0.1,0.9);
        shape.lineTo(0.1,0.1);
        shape.closePath();
    }
}
