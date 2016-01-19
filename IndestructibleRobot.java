import becker.robots.*;
import java.util.*;
public class IndestructibleRobot extends Robot //superclass is Robot
{
    //Constructor
    public IndestructibleRobot(City c, int s, int a, Direction d, int b)
    {
        super(c,s,a,d,b);	//calling the contructor of the superclass (Robot)
    }

    public void move()
    {
        if ( super.frontIsClear() ) 
        {
            if(super.getIntersection().getNeighbor(super.getDirection()).countSims(IPredicate.anyRobot)==0)
            {
                super.move(); 
            }
            else
            // if there is a robot in front, it cannot move
            {
                System.out.println("Sorry! I can't go there.");
            }
        }
        else //not really necessary but polite
        {
            System.out.println("Sorry! I can't go there.");
        }
    }
    
    public void originMove() //type of move that is used so that robots can be rearranged into initial position more easily.
    {
        if (super.frontIsClear())
        {
            super.move();
        }
        else
        {
            System.out.println("Sorry! I can't go there.");
        }
    }

    public void pickThing()
    {
        if ( super.canPickThing() )
        {
            super.pickThing();
        }
        else
        {
            System.out.println("Sorry! No thing to pick up.");
        }
    }

    public void putThing()
    {
        if ( super.countThingsInBackpack() > 0 )
        {
            super.putThing();
        }
        else
        {
            System.out.println("Sorry! No thing to put down.");
        }
    }
}

