import java.awt.Color;
import java.util.*;
import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Color;
import java.awt.geom.GeneralPath;
import java.lang.Math;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class main
{
    static Timer t1;    
    static int turn = 0; //variables that can be used in other classes to modify the timer feature
    static int secondTurn = 0;
    static boolean timerB = true;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in); //object to take inputs

        String redD, blueD, robotShape; /*string variables. redD and blueD are variables for directions of robots, and 
        robotShape is a variable to take input from the user for the shape of the robot.*/
        City board = new City();

        int[] blueOriginal = {11,31,24,44}; /*array of Initial locations for robots. These arrays do not change. 
        Tens digit represents the row, ones represents the columns*/ 
        int[] redOriginal = {21,41,14,34};

        int redWin = 0; //variables to store the number of wins of players.
        int blueWin = 0;

        for (int i = 2; i <= 5; i++) // this forloop creates walls around the gaming area, so that the robots do not go outside of the gameboard.
        {
            Wall w1 = new Wall(board, 1,i-1,Direction.NORTH);
            Wall w2 = new Wall(board, i-1,1,Direction.WEST);
            Wall w3 = new Wall(board, i-1,4,Direction.EAST);
            Wall w4 = new Wall(board, 4,i-1,Direction.SOUTH);
        }

        LabelIcon one = new LabelIcon(); //label icons are labels for the robots to determine the difference between 4 of a user's robots.
        LabelIcon two = new LabelIcon();
        LabelIcon three = new LabelIcon();
        LabelIcon four = new LabelIcon();

        one.setLabel("1"); // robots are labeled from 1 to 4
        two.setLabel("2");
        three.setLabel("3");
        four.setLabel("4");

        efficientRobot blue1 = new efficientRobot (board, 1,1, Direction.EAST,0); /*efficient robots. They are indestructible, and  
        have two move options. */
        efficientRobot red1 = new efficientRobot (board, 2,1, Direction.EAST,0); 
        efficientRobot blue2 = new efficientRobot (board, 3,1, Direction.EAST,0);
        efficientRobot red2 = new efficientRobot (board, 4,1, Direction.EAST,0);
        efficientRobot red3 = new efficientRobot (board, 1,4, Direction.WEST,0);
        efficientRobot blue3 = new efficientRobot (board, 2,4, Direction.WEST,0);
        efficientRobot red4 = new efficientRobot (board, 3,4, Direction.WEST,0);
        efficientRobot blue4 = new efficientRobot (board, 4,4, Direction.WEST,0);

        efficientRobot[] blueRobot = {blue1, blue2, blue3, blue4}; //array of robots
        efficientRobot[] redRobot = {red1, red2, red3, red4};

        CircleIcon redCircle = new CircleIcon(Color.RED,0.6); //circle icon for the robots. Gives the option of choosing the shape of the robot.
        CircleIcon blueCircle = new CircleIcon(Color.BLUE,0.6);

        SquareIcon redSquare = new SquareIcon(Color.RED,0.7);
        SquareIcon blueSquare = new SquareIcon(Color.BLUE,0.7);

        CompositeIcon redCircle1 = new CompositeIcon(redCircle, one); //icon with both shape and label
        CompositeIcon redCircle2 = new CompositeIcon(redCircle, two);
        CompositeIcon redCircle3 = new CompositeIcon(redCircle, three);
        CompositeIcon redCircle4 = new CompositeIcon(redCircle, four);

        CompositeIcon blueCircle1 = new CompositeIcon(blueCircle, one);
        CompositeIcon blueCircle2 = new CompositeIcon(blueCircle, two);
        CompositeIcon blueCircle3 = new CompositeIcon(blueCircle, three);
        CompositeIcon blueCircle4 = new CompositeIcon(blueCircle, four);

        CompositeIcon redSquare1 = new CompositeIcon(redSquare, one);
        CompositeIcon redSquare2 = new CompositeIcon(redSquare, two);
        CompositeIcon redSquare3 = new CompositeIcon(redSquare, three);
        CompositeIcon redSquare4 = new CompositeIcon(redSquare, four);

        CompositeIcon blueSquare1 = new CompositeIcon(blueSquare, one);
        CompositeIcon blueSquare2 = new CompositeIcon(blueSquare, two);
        CompositeIcon blueSquare3 = new CompositeIcon(blueSquare, three);
        CompositeIcon blueSquare4 = new CompositeIcon(blueSquare, four);

        efficientRobot[] robotBlueArray = {blue1, blue2, blue3, blue4}; //arrays of robots
        efficientRobot[] robotRedArray = {red1, red2, red3, red4};

        System.out.println("Type in the number of games you want to play"); //ask how many games will be played
        int numOfGames = Integer.parseInt(in.nextLine());


        for (int j = 0; j < 2; j++) //this forloop lets the users choose which shape the user wants his/her robot to be
        {
            if (j == 0)
            {
                System.out.println("Player Red, Choose the shape of your robots (A for Arrow, C for Circle, S for Square)");
            }
            else
            {
                System.out.println("Player Blue, Choose the shape of your robots (A for Arrow, C for Circle, S for Square)");
            }
            robotShape = in.nextLine().toUpperCase();
            if(robotShape.equals("A")) 
            {          
                if(j==0)
                {
                    red1.setLabel("1");
                    red2.setLabel("2");
                    red3.setLabel("3");
                    red4.setLabel("4");

                }
                else
                {
                    blue1.setColor(Color.BLUE);
                    blue2.setColor(Color.BLUE);
                    blue3.setColor(Color.BLUE);
                    blue4.setColor(Color.BLUE);

                    blue1.setLabel("1");
                    blue2.setLabel("2");
                    blue3.setLabel("3");
                    blue4.setLabel("4");
                }
            }
            else if(robotShape.equals("C"))
            {

                if ( j == 0)
                {                        
                    robotRedArray[0].setIcon(redCircle1);
                    robotRedArray[1].setIcon(redCircle2);
                    robotRedArray[2].setIcon(redCircle3);
                    robotRedArray[3].setIcon(redCircle4);
                }
                else
                {
                    robotBlueArray[0].setIcon(blueCircle1);
                    robotBlueArray[1].setIcon(blueCircle2);
                    robotBlueArray[2].setIcon(blueCircle3);
                    robotBlueArray[3].setIcon(blueCircle4);
                }

            }
            else if(robotShape.equals("S"))
            {                
                if ( j == 0)
                {
                    robotRedArray[0].setIcon(redSquare1);
                    robotRedArray[1].setIcon(redSquare2);
                    robotRedArray[2].setIcon(redSquare3);
                    robotRedArray[3].setIcon(redSquare4);
                }
                else
                {
                    robotBlueArray[0].setIcon(blueSquare1);
                    robotBlueArray[1].setIcon(blueSquare2);
                    robotBlueArray[2].setIcon(blueSquare3);
                    robotBlueArray[3].setIcon(blueSquare4);
                }
            }
        }

        int trn; //counts which turn it is
        int checkTrn; // integer to check the value of trn
        int num; //takes input of the player for which robot to move

        new ScoreBoard("SCORE BOARD"); //label that displays scores
        new Timers("<< Press Start"); //label that displays the time of each turn.

        for (int i = 1; i <= numOfGames; i ++) //forloop that repeats the game.
        {

            ScoreBoard.scoreBoard.setText("Red : "+ redWin + "     " +"Blue : " + blueWin); /*whenever a game starts, the scores 
            are changed appropriately*/
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
            System.out.println("------------------GAME START-----------------");
            System.out.println("--------------------------GAME NUMBER " + i + "------");
            System.out.println("---------------------------------------------");

            trn = 0; // the turn is reset to 0 every time the game is repeated

            int[] blueArray = {11,31,24,44}; //the position arrays of the robots are reset to original
            int[] redArray = {21,41,14,34};
            Timers.startTime = 21; //timer is set to 20 seconds everytime the player's turn starts
                Timers.t1 = new Timer();

            do
            {
                turn = 0;
                trn += 1; // 1 is added every turn
                checkTrn = trn;
                mainIfLoop: //name of the loop
                if (trn %2 == 1) //when trn is odd, it's red's turn
                {
                    System.out.println("Red's turn");                  
                    System.out.println("Pick a Robot (1,2,3,4)");
                    do //if the user inputs something other than the options, it asks for the input again
                    {
                        num = Integer.parseInt(in.nextLine());
                        
                    }while(!CheckNum(num)); 
                    System.out.println("Choose Direction. (N,S,E,W)");
                    do //if the user inputs something other than the options, it asks for the input again
                    {                    
                        redD = in.nextLine();
                    }while(!CheckLetter(redD));

                    if (turn == 1) //when timer reaches 0, turn becomes 1 from the Timers class
                    {
                        System.out.println("Your time has ended, the current move will not count"); /*even though the inputs may have
                        occured, it is not counted if the time has ended already*/
                        break mainIfLoop;
                    }

                    if (num ==1) //these if statements move the appropriate robot according to num variable.
                    {
                        trn = moveDirection(num, redD, red1, redArray,trn);
                    }
                    else if (num == 2)
                    {
                        trn = moveDirection(num, redD, red2, redArray, trn);
                    }
                    else if (num ==3)
                    {
                        trn = moveDirection(num, redD, red3, redArray,trn);
                    }
                    else
                    {
                        trn = moveDirection(num, redD, red4, redArray, trn);
                    }
                    if(checkTrn == trn) // if trn is subtracted by 1 because the player has made an unacceptable move, timer is not reset.
                    {
                        Timers.startTime = 21; //timer is set to 20 seconds everytime the player's turn starts
                        Timers.t1 = new Timer();
                    }
                }
                else /*when trn is even, it's blue's turn. all of the else statement 
                is same as the previous if statement except, it's for blue*/
                {
                    System.out.println("Blue's turn");
                    System.out.println("Pick a Robot(1,2,3,4)");
                    do
                    {
                        num = Integer.parseInt(in.nextLine());
                    }while(!CheckNum(num));

                    System.out.println("Choose Direction. (N,S,E,W)");
                    do
                    {          
                        blueD = in.nextLine();
                    }while(!CheckLetter(blueD));

                    if (turn == 1)
                    {
                        System.out.println("Your time has ended, the current move will not count");
                        break mainIfLoop;
                    }

                    if (num ==1)
                    {
                        trn = moveDirection(num, blueD, blue1, blueArray, trn);
                    }
                    else if (num == 2)
                    {
                        trn = moveDirection(num, blueD, blue2, blueArray, trn);
                    }
                    else if (num ==3)
                    {
                        trn = moveDirection(num, blueD, blue3, blueArray, trn);
                    }
                    else
                    {
                        trn = moveDirection(num, blueD, blue4, blueArray, trn);
                    }
                    if(checkTrn == trn)
                    {
                        Timers.startTime = 21; //timer is set to 20 seconds everytime the player's turn starts
                        Timers.t1 = new Timer();
                    }
                }
            }while (!
            CheckColumn(redArray)&&!
            CheckColumn(blueArray)&&!
            CheckRow(redArray)&&!
            CheckRow(blueArray)&&!
            CheckDiagonal(redArray)&&!
            CheckDiagonal(blueArray)); // this do loop runs until red/blue makes a 3 in a row/column/diagonal

            if(trn %2 == 1) // if trn is odd when the game ends, then red is the winner
            {
                System.out.println("Red wins");
                redWin += 1;
            }
            else// if not, blue is the winner
            {
                System.out.println("Blue wins");
                blueWin += 1;
            }

            for (int k =0; k < 4; k ++) //this forloop puts the robots in their original positions
            {
                OriginalPosition(blueArray, blueOriginal, robotBlueArray, k);
            }
            for (int k =0; k < 4; k ++)
            {
                OriginalPosition(redArray, redOriginal, robotRedArray, k);
            }

            Timers.startTime = 21; //timer is reset everytime the game ends
            Timers.t1 = new Timer();
        }
    }

    //     public static boolean CheckTime()
    //     {
    //         if(Integer.parseInt(Timers.label.getText())== 1)
    //         {
    //             return false;
    //         }
    //         else
    //         {
    //             return true;
    //         }
    //     }

    public static boolean CheckNum(int num) // checks if the input num is an appropriate option.
    {
        if (num == 1 || num == 2 || num == 3 || num ==4)
        {
            return true;
        }
        else
        {
            System.out.println("Type the number again");
            return false;
        }
    }

    public static boolean CheckLetter(String NSEW) // checks if the input NSEW is an appropriate option.
    {
        if (NSEW.toUpperCase().equals("N") || NSEW.toUpperCase().equals("S") || NSEW.toUpperCase().equals("E")|| NSEW.toUpperCase().equals("W"))
        {
            return true;            
        }
        else
        {
            System.out.println("Type the direction again");

            return false;
        }
    }

    public static int moveDirection(int num, String NSEW, efficientRobot karel,int[] array, int trn) 
    {
        //sets the direction of the robot that the player selected and moves one unit to that direction
        //changes the values of the arrays according to the changed position.
        Direction direction;
        int directionNum;
        int initialAvenue, initialStreet;

        if (NSEW.toUpperCase().equals("N"))
        {
            directionNum = -10;
            direction = Direction.NORTH;
            karel.setDirection(direction);        
            initialAvenue = karel.getAvenue();
            initialStreet = karel.getStreet();
            karel.move();

            if (initialAvenue == karel.getAvenue() && initialStreet == karel.getStreet()) /* if the initial
            values of avenue and street equal the current after it "moved", then player has made an illegal move and has to repeat */
            {
                while(initialAvenue == karel.getAvenue()&&initialStreet == karel.getStreet())
                {
                    trn -= 1;
                    return trn;   
                }
            }
            else
            {
                array[num-1] = array[num-1] + directionNum;
            }

        }
        else if(NSEW.toUpperCase().equals("S"))
        {
            directionNum = 10;
            direction = Direction.SOUTH;
            karel.setDirection(direction);        
            initialAvenue = karel.getAvenue();
            initialStreet = karel.getStreet();
            karel.move();

            if (initialAvenue == karel.getAvenue() && initialStreet == karel.getStreet())
            { 
                trn -= 1;
                return trn;
            }
            else
            {
                array[num-1] = array[num-1] + directionNum;

            }
        }
        else if(NSEW.toUpperCase().equals("E"))
        {
            directionNum = 1;
            direction = Direction.EAST;
            karel.setDirection(direction);        
            initialAvenue = karel.getAvenue();
            initialStreet = karel.getStreet();
            karel.move();

            if (initialAvenue == karel.getAvenue()  && initialStreet == karel.getStreet())
            {                
                trn -= 1;
                return trn;
            }
            else
            {
                array[num-1] = array[num-1] + directionNum;
            }
        }
        else 
        {
            directionNum = -1;
            direction = Direction.WEST;
            karel.setDirection(direction);        
            initialAvenue = karel.getAvenue();
            initialStreet = karel.getStreet();
            karel.move();

            if (initialAvenue == karel.getAvenue() && initialStreet == karel.getStreet())
            {          
                trn -= 1;
                return trn;
            }
            else
            {
                array[num-1] = array[num-1] + directionNum;
            }
        }
        return trn;
    }

    public static boolean CheckColumn(int[] array) //checks if the robots are in a column
    {
        int sameColumn = 0;
        int sameColumnAndAdjacent = 0;
        for (int j = 0; j < 4; j ++) //checks every combination of 4 robots 
        {
            for (int i=1; i < 4-j; i++)
            {
                if ((array[j] - array[j+i])%10 == 0) 
                {                    
                    sameColumn +=1;                        
                    if(Math.abs((array[j]/10)-(array[j+i]/10))==1)
                    {
                        sameColumnAndAdjacent += 1;
                    }
                }                
            }
        }
        if (sameColumn >= 3 && sameColumnAndAdjacent >= 2) /*if more than 3 are in the same column and more than 2 combinations are adjacent,
        then the robots are in a column*/ 
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean CheckRow(int[] array) //checks if the robots are in a row
    {
        int sameRow = 0;
        int sameRowAndAdjacent = 0;
        for (int j = 0; j < 4; j ++)
        {
            for (int i=1; i < 4-j; i++)
            {
                if (Math.abs(array[j] - array[j+i]) < 4 )
                { 
                    sameRow += 1;
                    if(Math.abs(array[j] - array[j+i]) == 1)
                    {
                        sameRowAndAdjacent+=1;
                    }
                }
            }
        }
        if (sameRow >= 3 && sameRowAndAdjacent >= 2)/*if more than 3 are in the same row and more than 2 combinations are adjacent,
        then the robots are in a row*/ 
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean CheckDiagonal(int[] array) //checks if the robots are in a diagonal
    {
        int diagonalSlopePositive = 0;
        int diagonalSlopeNegative = 0;
        for (int j = 0; j < 4; j ++)
        {
            for (int i=1; i < 4-j; i++)
            {
                if (Math.abs(array[j] - array[j+i]) == 9  || Math.abs(array[j] - array[j+i]) == 18) 
                // if there are two robots that are in the same diagonal (with positive slope) and is adjacent or only 1 apart, add 1  
                //unnecessary to count the ones that are 2 apart because they are not in the diagonal to make 3 in a row
                {
                    diagonalSlopePositive += 1;
                }
                else if (Math.abs(array[j] - array[j+i]) == 11 || Math.abs(array[j] - array[j+i]) == 22)
                // if there are two robots that are in the same diagonal (with negative slope) and is adjacent or only 1 apart, add 1   
                {
                    diagonalSlopeNegative += 1;
                }
            }
        }
        if (diagonalSlopePositive >= 3 || diagonalSlopeNegative >= 3) //if 3 or more combinations are in the same diagonal, then it's a 3 in a row
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void OriginalPosition(int[] currentArray, int[] originalArray,  efficientRobot[] robotArray, int x) // moves the robots
    //to its original position
    {
        if(currentArray[x]/10 != originalArray[x]/10)
        {
            if(currentArray[x]/10 > originalArray[x]/10)
            {
                robotArray[x].setDirection(Direction.NORTH);
                for (int i =0; i < currentArray[x]/10 - originalArray[x]/10; i ++)
                {                  
                    robotArray[x].originMove(); // a new type of move where robots can overlap.
                }
            }
            else if(currentArray[x]/10 < originalArray[x]/10)
            {
                robotArray[x].setDirection(Direction.SOUTH);
                for (int i =0; i < originalArray[x]/10 - currentArray[x]/10; i ++)
                {
                    robotArray[x].originMove();
                }
            }          

        }
        if(currentArray[x]%10 != originalArray[x]%10) // (Change Made) else if to if 
        {
            if(currentArray[x]%10 < originalArray[x]%10)
            {       
                robotArray[x].setDirection(Direction.EAST);
                for (int i =0; i < originalArray[x]%10 - currentArray[x]%10; i ++)
                {
                    robotArray[x].originMove();
                }
            }
            else if(currentArray[x]%10 > originalArray[x]%10)
            {
                robotArray[x].setDirection(Direction.WEST);
                for (int i =0; i < currentArray[x]%10 - originalArray[x]%10; i ++)
                {
                    robotArray[x].originMove();
                }
            }          

        }
    }

}