import java.util.Random;
import java.util.Scanner;
// 0 is wrong 1 is right
/**
 * Write a description of class WeakestLink here.
 * 
 * @author Ryan Lake and Chris Do 
 * @version 1.1
 */
public  class WeakestLink
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);

        int p1points = 0;
        int p2points = 0;
        int p3points = 0;
        int p4points = 0;
        int p5points = 0;

        int counter = 0;

        boolean p1out = false;
        boolean p2out = false;
        boolean p3out = false;
        boolean p4out = false;
        boolean p5out = false;

        int player = 1;
        int comp2 = 2;
        int comp3 = 3;
        int comp4 = 4;
        int comp5 = 5;

        String p2name = "Chris";
        String p3name = "Ryan";
        String p4name = "Jenny";
        String p5name = "Elise";

        System.out.println("Please enter your name:");
        String name = scan.nextLine();
        System.out.println("Welcome! Let's play The Weakest Link! You player 1.");
        System.out.println("");

        System.out.println("Round one: Addition. You will have numbers up to 1000");
        round1(name, p2name, p3name, p4name, p5name, counter, p1out, p2out, p3out, p4out, p5out, player, comp2, comp3, comp4, comp5);

    }

    public static void round1(String name ,String p2name ,String p3name, String p4name, String p5name, Integer counter, Boolean p1out, Boolean p2out, Boolean p3out, Boolean p4out, Boolean p5out, Integer player1, Integer comp2, Integer comp3, Integer comp4, Integer comp5)
    {
        Random gen = new Random();
        Scanner scan = new Scanner(System.in);
        
        int tries = 3;
        
        
        int x = gen.nextInt(100)+1;
        int y = gen.nextInt(100)+1;
        
        
        
        int p2 = gen.nextInt(2);
        int p3 = gen.nextInt(2);
        int p4 = gen.nextInt(2);
        int p5 = gen.nextInt(2);
        
        int p1RW = 0;
        int p2RW = 0;
        int p3RW = 0;
        int p4RW = 0;
        int p5RW = 0;
       
        
        int pointsPossible = 10;
        
        
        System.out.println("Welcome to round one!!!");
        System.out.println("");
        
        
        String answer = "";
        
        boolean right = false; 
        do
        {
            System.out.println("What is " + x +" plus " + y +"?");
            answer = scan.nextLine();
            if(answer.equals(x+y))
            {
                System.out.println("That is correct ");
                p1RW = p1RW+1;
            }
           
            
        }while(tries==0 && right == false);
        
        
    }


    public static void round2(String name, String p2name, String p3name, String p4name, String p5name, Integer counter, Boolean p1out, Boolean p2out, Boolean p3out, Boolean p4out, Boolean p5out, Integer player, Integer comp2, Integer comp3, Integer comp4, Integer comp5)
    {
        Random gen = new Random();
        Scanner scan = new Scanner(System.in);
        String answer = "";
        int x = gen.nextInt(100)+1;
        int y = gen.nextInt(100)+1;
        int pointsPossible = 10;
        int tries = 3;

        int nump1right = 0;
        int nump2right = 0;
        int nump3right = 0;
        int nump4right = 0;
        int nump5right = 0;

        int p2right = 0;
        int p3right = 0;
        int p4right = 0;
        int p5right = 0;

        boolean right = false;
        do
        {
            System.out.println(name + ", what is " + x + " times " + y + "?");
            answer = scan.nextLine();
            do
            {
                if(answer.equals(x*y))
                {
                    System.out.println("That is correct");
                    pointsPossible = pointsPossible + 10;
                    nump1right = nump1right+1;
                    right = true;
                }
                else if(!answer.equals(x*y))
                {
                    System.out.println("I'm sorry. That is incorrect");
                    tries = tries-1;
                }
            }while (tries > 0 && right == false);
            if (tries == 0)
            {
                pointsPossible = 10;
            }
            tries = 3;

            //P2 Right?-------------------------------------------------

            if(p2out == false)
            {
                p2right = gen.nextInt(2);
                if(p2right == 0)
                {
                    System.out.println(p2name + " got the question wrong.");
                    pointsPossible = 10;
                }
                else if (p2right == 1)
                {
                    System.out.println(p2name + " got the question right!");
                    pointsPossible = pointsPossible+10;
                }
            }

            //P3 Right?--------------------------------------------
            if(p3out == false)
            {
                p3right = gen.nextInt(2);
                if(p3right == 0)
                {
                    System.out.println(p3name + " got the question wrong.");
                    pointsPossible = 10;
                }
                else if (p3right == 1)
                {
                    System.out.println(p3name + " got the question right!");
                    pointsPossible = pointsPossible+10;
                }
            }

            //P4 Right?----------------------------------------------
            if(p4out == false)
            {
                p4right = gen.nextInt(2);
                if(p4right == 0)
                {
                    System.out.println(p4name + " got the question wrong.");
                    pointsPossible = 10;
                }
                else if (p4right == 1)
                {
                    System.out.println(p4name + " got the question right!");
                    pointsPossible = pointsPossible+10;
                }
            }

            //P5 Right?------------------------------------------------
            if(p5out == false)
            {
                p5right = gen.nextInt(2);
                if(p5right == 0)
                {
                    System.out.println(p5name + " got the question wrong.");
                    pointsPossible = 10;
                }
                else if (p5right == 1)
                {
                    System.out.println(p5name + " got the question right!");
                    pointsPossible = pointsPossible+10;
                }
            }
        }while (counter <= 3);
    }
}
