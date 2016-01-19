
import becker.robots.*;
public class efficientRobot extends IndestructibleRobot
{

    public efficientRobot(City c, int s, int a, Direction d, int b)
    {
        super(c,s,a,d,b);
    }

    public void move(int i)
    {
        for (int j = 0; j < i; j++)
        {
            super.move();
        }
    }

    public void pickThing(int num)
    {
        for ( int i = 0; i < num; i++ )
        {
            super.pickThing();
        }
    }

    public void putThing(int num)
    {
        for ( int i = 0; i < num; i++ )
        {
            super.putThing();
        }
    }
    public void setDirection(Direction direction)
    {
        while (super.getDirection() != direction)
        {
            super.turnLeft();
        }        
    }

}
