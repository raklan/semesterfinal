import java.util.Random;
import java.util.Scanner;
// 0 is wrong 1 is right
/**
 * Write a description of class WeakestLink here.
 *
 * @author Ryan Lake and Chris Do
 * @version 1.0
 */

public class WeakestLink {

    static int p1points = 0;
    static int p2points = 0;
    static int p3points = 0;
    static int p4points = 0;
    static int p5points = 0;

    static String name = " ";
    static String p2name = "Chris";
    static String p3name = "Ryan";
    static String p4name = "Jenny";
    static String p5name = "Elise";

    static boolean p1out = false;
    static boolean p2out = false;
    static boolean p3out = false;
    static boolean p4out = false;
    static boolean p5out = false;

    static int counter = 1;

    static int player = 1;
    static int comp2 = 2;
    static int comp3 = 3;
    static int comp4 = 4;
    static int comp5 = 5;

    static int pointsPossible = 10;

    static Random gen = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[]args) {
        String answer = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your name:");
        name = scan.nextLine();
        System.out.println("Welcome! Let's play The Weakest Link! You player 1.");
        System.out.println("");

        if (p1out == false) {
            System.out.println("Round one: Addition. You will have numbers up to 100");
            round1();
        }
        if (p1out == false) {
            System.out.println("");
            System.out.println("Round Two: Subtraction. You will have numbers up to 100.");
            round2();
        }
        if (p1out == false) {
            System.out.println("");
            System.out.println("Round Three: Multiplacation. You will have numbers up to 100.");
            round3();
        }
        if (p1out == false) {
            System.out.println("");
            System.out.println("Final Round. Are you ready? Y/N");
            answer = scan.nextLine();
            if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes")) {
                finalRound();
            } else if (answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("No")) {
                System.out.println("Too bad.");
                finalRound();
            } else {
                System.out.println("That's not a valid answer, so you are ready.");
                finalRound();
            }
        }

        if (p1out == false && p1points > p2points && p1points > p3points && p1points > p4points && p1points > p5points) {
            System.out.println("The Game is over. You have won with " + p1points + " points. You are the Strongest Link.");
        } else if (p1out == false && p2points > p1points && p2points > p3points && p2points > p4points && p2points > p5points) {
            System.out.println("The Game is over. With " + p2points + " points, " + p2name + " is the Strongest Link.");
        } else if (p1out == false && p3points > p1points && p3points > p2points && p3points > p4points && p3points > p5points) {
            System.out.println("The Game is over. With " + p3points + " points, " + p3name + " is the Strongest Link.");
        } else if (p1out == false && p4points > p1points && p4points > p3points && p4points > p2points && p4points > p5points) {
            System.out.println("The Game is over. With " + p4points + " points, " + p4name + " is the Strongest Link.");
        } else if (p1out == false && p5points > p1points && p5points > p3points && p5points > p4points && p5points > p2points) {
            System.out.println("The Game is over. With " + p5points + " points, " + p5name + " is the Strongest Link.");
        }

        if (p1out == true) {
            System.out.println("Your game is over. You are the Weakest Link. You finished with " + p1points + " points. Thanks for playing!");
        }

    }

    //-----------------------------ROUND 1------------------------------------------------

    public static void round1() {
        counter = 1;
        String answer = "";
        int tries = 3;
        int bank = 0;

        pointsPossible = 10;

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
        do {
            int x = gen.nextInt(100) + 1;
            int y = gen.nextInt(100) + 1;
            System.out.println(name + ", what is " + x + " plus " + y + "?");
            System.out.println("(Or type 'Bank' to bank the possible points.)");
            do {
                answer = scan.nextLine();
                if (answer.equalsIgnoreCase("bank")) {
                    bank = bank + pointsPossible;
                    System.out.println("The Bank is now worth " + bank + " points. The possible points have been reset to 10. Please answer the question now.");
                    answer = scan.nextLine();
                    pointsPossible = 10;
                }
                if (Integer.parseInt(answer) == x + y) {
                    System.out.println("That is correct");
                    pointsPossible = pointsPossible + 10;
                    nump1right = nump1right + 1;
                    right = true;
                } else if (Integer.parseInt(answer) != x + y)  {
                    tries = tries - 1;
                    System.out.println("That is incorrect. You have " + tries + " tries remaining");
                }

            } while (tries > 0 && right == false);
            if (tries == 0) {
                pointsPossible = 10;
            }
            tries = 3;

            //P2 Right?-------------------------------------------------

            if (p2out == false) {
                nump2right = checkAI(p2name, nump2right);
            }

            //P3 Right?--------------------------------------------
            if (p3out == false) {
                nump3right = checkAI(p3name, nump3right);
            }

            //P4 Right?----------------------------------------------
            if (p4out == false) {
                nump4right = checkAI(p4name, nump4right);
            }

            //P5 Right?------------------------------------------------
            if (p5out == false) {
                nump5right = checkAI(p5name, nump5right);
            }
            counter = counter + 1;
            System.out.println("");
        } while (counter <= 3);

        if (nump1right > nump2right && nump1right > nump3right && nump1right > nump4right && nump1right > nump5right) {
            System.out.println(name + ", with " + nump1right + " questions right, you had the most right. You get the points.");
            p1points = p1points + bank;
        } else if (nump2right > nump1right && nump2right > nump3right && nump2right > nump4right && nump2right > nump5right) {
            System.out.println("With " + nump2right + " questions right, " + p2name + "gets the points.");
            p2points = p2points + bank;
        } else if (nump3right > nump1right && nump3right > nump2right && nump3right > nump4right && nump3right > nump5right) {
            System.out.println("With " + nump3right + " questions right, " + p3name + "gets the points.");
            p3points = p3points + bank;
        } else if (nump4right > nump1right && nump4right > nump3right && nump4right > nump2right && nump4right > nump5right) {
            System.out.println("With " + nump4right + " questions right, " + p4name + "gets the points.");
            p4points = p4points + bank;
        } else if (nump5right > nump1right && nump5right > nump2right && nump5right > nump3right && nump5right > nump4right) {
            System.out.println("With " + nump5right + " questions right, " + p5name + "gets the points.");
            p5points = p5points + bank;
        } else {
            System.out.println("There was a tie, so no one gets the points. Sorry.");
        }
        bank = 0;

        System.out.println("");
        voting();

        System.out.println("The Round is over. You have " + p1points + " points.");
    }

    //----------------------------ROUND 2-------------------------------------------------------
    public static void round2() {
        counter = 1;
        String answer = "";
        int tries = 3;
        int bank = 0;

        pointsPossible = 10;

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
        do {
            int x = gen.nextInt(100) + 1;
            int y = gen.nextInt(100) + 1;
            System.out.println(name + ", what is " + x + " minus " + y + "?");
            System.out.println("(Or type 'Bank' to bank the possible points.)");
            do {
                answer = scan.nextLine();
                if (answer.equalsIgnoreCase("bank")) {
                    bank = bank + pointsPossible;
                    System.out.println("The Bank is now worth " + bank + " points. The possible points have been reset to 10. Please answer the question now.");
                    answer = scan.nextLine();
                    pointsPossible = 10;
                }
                if (Integer.parseInt(answer) == x - y) {
                    System.out.println("That is correct");
                    pointsPossible = pointsPossible + 10;
                    nump1right = nump1right + 1;
                    right = true;
                } else if (Integer.parseInt(answer) != x - y)  {
                    tries = tries - 1;
                    System.out.println("That is incorrect. You have " + tries + " tries remaining");
                }

            } while (tries > 0 && right == false);
            if (tries == 0) {
                pointsPossible = 10;
            }
            tries = 3;

            //P2 Right?-------------------------------------------------

            if (p2out == false) {
                nump2right = checkAI(p2name, nump2right);
            }

            //P3 Right?--------------------------------------------
            if (p3out == false) {
                nump3right = checkAI(p3name, nump3right);
            }

            //P4 Right?----------------------------------------------
            if (p4out == false) {
                nump4right = checkAI(p4name, nump4right);
            }

            //P5 Right?------------------------------------------------
            if (p5out == false) {
                nump5right = checkAI(p5name, nump5right);
            }
            counter = counter + 1;
            System.out.println("");
        } while (counter <= 3);

        if (nump1right > nump2right && nump1right > nump3right && nump1right > nump4right && nump1right > nump5right) {
            System.out.println(name + ", with " + nump1right + " questions right, you had the most right. You get the points.");
            p1points = p1points + bank;
        } else if (nump2right > nump1right && nump2right > nump3right && nump2right > nump4right && nump2right > nump5right) {
            System.out.println("With " + nump2right + " questions right, " + p2name + "gets the points.");
            p2points = p2points + bank;
        } else if (nump3right > nump1right && nump3right > nump2right && nump3right > nump4right && nump3right > nump5right) {
            System.out.println("With " + nump3right + " questions right, " + p3name + "gets the points.");
            p3points = p3points + bank;
        } else if (nump4right > nump1right && nump4right > nump3right && nump4right > nump2right && nump4right > nump5right) {
            System.out.println("With " + nump4right + " questions right, " + p4name + "gets the points.");
            p4points = p4points + bank;
        } else if (nump5right > nump1right && nump5right > nump2right && nump5right > nump3right && nump5right > nump4right) {
            System.out.println("With " + nump5right + " questions right, " + p5name + "gets the points.");
            p5points = p5points + bank;
        } else {
            System.out.println("There was a tie, so no one gets the points. Sorry.");
        }
        bank = 0;

        System.out.println("");
        voting();

        System.out.println("The Round is over. You have " + p1points + " points.");

    }

    //-----------------------------------------------ROUND THREE---------------------------------------------------------
    public static void round3() {
        counter = 1;
        String answer = "";
        int tries = 3;
        int bank = 0;

        pointsPossible = 10;

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
        do {
            int x = gen.nextInt(100) + 1;
            int y = gen.nextInt(100) + 1;
            System.out.println(name + ", what is " + x + " times " + y + "?");
            System.out.println("(Or type 'Bank' to bank the possible points.)");
            do {
                answer = scan.nextLine();
                if (answer.equalsIgnoreCase("bank")) {
                    bank = bank + pointsPossible;
                    System.out.println("The Bank is now worth " + bank + " points. The possible points have been reset to 10. Please answer the question now.");
                    answer = scan.nextLine();
                    pointsPossible = 10;
                }
                if (Integer.parseInt(answer) == x * y) {
                    System.out.println("That is correct");
                    pointsPossible = pointsPossible + 10;
                    nump1right = nump1right + 1;
                    right = true;
                } else if (Integer.parseInt(answer) != x * y)  {
                    tries = tries - 1;
                    System.out.println("That is incorrect. You have " + tries + " tries remaining");
                }

            } while (tries > 0 && right == false);
            if (tries == 0) {
                pointsPossible = 10;
            }
            tries = 3;

            //P2 Right?-------------------------------------------------

            if (p2out == false) {
                nump2right = checkAI(p2name, nump2right);
            }

            //P3 Right?--------------------------------------------
            if (p3out == false) {
                nump3right = checkAI(p3name, nump3right);
            }

            //P4 Right?----------------------------------------------
            if (p4out == false) {
                nump4right = checkAI(p4name, nump4right);
            }

            //P5 Right?------------------------------------------------
            if (p5out == false) {
                nump5right = checkAI(p5name, nump5right);
            }
            counter = counter + 1;
            System.out.println("");
        } while (counter <= 3);

        if (nump1right > nump2right && nump1right > nump3right && nump1right > nump4right && nump1right > nump5right) {
            System.out.println(name + ", with " + nump1right + " questions right, you had the most right. You get the points.");
            p1points = p1points + bank;
        } else if (nump2right > nump1right && nump2right > nump3right && nump2right > nump4right && nump2right > nump5right) {
            System.out.println("With " + nump2right + " questions right, " + p2name + "gets the points.");
            p2points = p2points + bank;
        } else if (nump3right > nump1right && nump3right > nump2right && nump3right > nump4right && nump3right > nump5right) {
            System.out.println("With " + nump3right + " questions right, " + p3name + "gets the points.");
            p3points = p3points + bank;
        } else if (nump4right > nump1right && nump4right > nump3right && nump4right > nump2right && nump4right > nump5right) {
            System.out.println("With " + nump4right + " questions right, " + p4name + "gets the points.");
            p4points = p4points + bank;
        } else if (nump5right > nump1right && nump5right > nump2right && nump5right > nump3right && nump5right > nump4right) {
            System.out.println("With " + nump5right + " questions right, " + p5name + "gets the points.");
            p5points = p5points + bank;
        } else {
            System.out.println("There was a tie, so no one gets the points. Sorry.");
        }
        bank = 0;

        System.out.println("");
        voting();

        System.out.println("The Round is over. You have " + p1points + " points.");

    }

    //------------------------------------------------FINAL ROUND----------------------------------------------------------------
    public static void finalRound() {
        counter = 1;
        int tries = 2;
        boolean right = false;

        String answer = "";

        int nump1right = 0;
        int nump2right = 0;
        int nump3right = 0;
        int nump4right = 0;
        int nump5right = 0;

        int p2right = 0;
        int p3right = 0;
        int p4right = 0;
        int p5right = 0;

        int a = gen.nextInt(50) + 1;
        int b = gen.nextInt(50) + 1;
        int c = gen.nextInt(50) + 1;
        int d = gen.nextInt(50) + 1;
        int e = gen.nextInt(50) + 1;

        System.out.println("Welcome to the Final Round. Order of Operations. There are numbers up to 50.");
        System.out.println("You will each have 5 questions. The Player with the most right will gain 200 bonus points.");
        System.out.println("There is no Bank in this round, and you will only have two tries per question.");
        System.out.println("The Player with the most points will be the victor!");

        System.out.println(name + ", what is " + a + " plus " + d + " minus " + b + "?");
        do {
            answer = scan.nextLine();
            if (Integer.parseInt(answer) == (a + d - b)) {
                System.out.println("That is correct");
                nump1right = nump1right + 1;
                right = true;
            } else if (Integer.parseInt(answer) != (a + d - b))  {
                tries = tries - 1;
                System.out.println("That is incorrect. You have " + tries + " tries remaining");
            }

        } while (tries > 0 && right == false);

        //P2 Right?-------------------------------------------------

        if (p2out == false) {
            nump2right = checkAI(p2name, nump2right);
        }

        //P3 Right?--------------------------------------------
        if (p3out == false) {
            nump3right = checkAI(p3name, nump3right);
        }

        //P4 Right?----------------------------------------------
        if (p4out == false) {
            nump4right = checkAI(p4name, nump4right);
        }

        //P5 Right?------------------------------------------------
        if (p5out == false) {
            nump5right = checkAI(p5name, nump5right);
        }

        System.out.println("");

        //-------------------------Q2--------------------
        a = gen.nextInt(50) + 1;
        b = gen.nextInt(50) + 1;
        c = gen.nextInt(50) + 1;
        d = gen.nextInt(50) + 1;
        e = gen.nextInt(50) + 1;

        System.out.println(name + ", what is " + c + " times " + e + " minus " + a + "?");

        do {
            answer = scan.nextLine();
            if (Integer.parseInt(answer) == (c * e - a)) {
                System.out.println("That is correct");
                nump1right = nump1right + 1;
                right = true;
            } else if (Integer.parseInt(answer) != (c * e - a))  {
                tries = tries - 1;
                System.out.println("That is incorrect. You have " + tries + " tries remaining");
            }

        } while (tries > 1 && right == false);

        //P2 Right?-------------------------------------------------

        if (p2out == false) {
            nump2right = checkAI(p2name, nump2right);
        }

        //P3 Right?--------------------------------------------
        if (p3out == false) {
            nump3right = checkAI(p3name, nump3right);
        }

        //P4 Right?----------------------------------------------
        if (p4out == false) {
            nump4right = checkAI(p4name, nump4right);
        }

        //P5 Right?------------------------------------------------
        if (p5out == false) {
            nump5right = checkAI(p5name, nump5right);
        }

        System.out.println("");

        //---------------------Q3--------------------
        a = gen.nextInt(50) + 1;
        b = gen.nextInt(50) + 1;
        c = gen.nextInt(50) + 1;
        d = gen.nextInt(50) + 1;
        e = gen.nextInt(50) + 1;

        System.out.println(name + ", what is " + b + " minus " + e + " times " + c + "?");

        do {
            answer = scan.nextLine();
            if (Integer.parseInt(answer) == (b - e * c)) {
                System.out.println("That is correct");
                nump1right = nump1right + 1;
                right = true;
            } else if (Integer.parseInt(answer) != (b - e * c))  {
                tries = tries - 1;
                System.out.println("That is incorrect. You have " + tries + " tries remaining");
            }

        } while (tries > 0 && right == false);
        tries = 2;

        //P2 Right?-------------------------------------------------

        if (p2out == false) {
            nump2right = checkAI(p2name, nump2right);
        }

        //P3 Right?--------------------------------------------
        if (p3out == false) {
            nump3right = checkAI(p3name, nump3right);
        }

        //P4 Right?----------------------------------------------
        if (p4out == false) {
            nump4right = checkAI(p4name, nump4right);
        }

        //P5 Right?------------------------------------------------
        if (p5out == false) {
            nump5right = checkAI(p5name, nump5right);
        }

        System.out.println("");

        //---------------------Q4--------------------
        a = gen.nextInt(50) + 1;
        b = gen.nextInt(50) + 1;
        c = gen.nextInt(50) + 1;
        d = gen.nextInt(50) + 1;
        e = gen.nextInt(50) + 1;

        System.out.println(name + ", what is " + b + " plus " + a + " times " + d + " minus " + c + "?");

        do {
            answer = scan.nextLine();
            if (Integer.parseInt(answer) == (b + a * d - c)) {
                System.out.println("That is correct");
                nump1right = nump1right + 1;
                right = true;
            } else if (Integer.parseInt(answer) != (b + a * d - c))  {
                tries = tries - 1;
                System.out.println("That is incorrect. You have " + tries + " tries remaining");
            }

        } while (tries > 0 && right == false);
        tries = 2;

        //P2 Right?-------------------------------------------------

        if (p2out == false) {
            nump2right = checkAI(p2name, nump2right);
        }

        //P3 Right?--------------------------------------------
        if (p3out == false) {
            nump3right = checkAI(p3name, nump3right);
        }

        //P4 Right?----------------------------------------------
        if (p4out == false) {
            nump4right = checkAI(p4name, nump4right);
        }

        //P5 Right?------------------------------------------------
        if (p5out == false) {
            nump5right = checkAI(p5name, nump5right);
        }

        System.out.println("");

        //---------------------Q5--------------------
        a = gen.nextInt(50) + 1;
        b = gen.nextInt(50) + 1;
        c = gen.nextInt(50) + 1;
        d = gen.nextInt(50) + 1;
        e = gen.nextInt(50) + 1;

        System.out.println(name + ", what is " + b + " minus " + a + " plus " + d + " times " + c + " minus " + e + "?");

        do {
            answer = scan.nextLine();
            if (Integer.parseInt(answer) == (b - a + d * c - e)) {
                System.out.println("That is correct");
                nump1right = nump1right + 1;
                right = true;
            } else if (Integer.parseInt(answer) != (b - a + d * c - e))  {
                tries = tries - 1;
                System.out.println("That is incorrect. You have " + tries + " tries remaining");
            }

        } while (tries > 0 && right == false);
        tries = 2;

        //P2 Right?-------------------------------------------------

        if (p2out == false) {
            nump2right = checkAI(p2name, nump2right);
        }

        //P3 Right?--------------------------------------------
        if (p3out == false) {
            nump3right = checkAI(p3name, nump3right);
        }

        //P4 Right?----------------------------------------------
        if (p4out == false) {
            nump4right = checkAI(p4name, nump4right);
        }

        //P5 Right?------------------------------------------------
        if (p5out == false) {
            nump5right = checkAI(p5name, nump5right);
        }

        System.out.println("");

        if (nump1right > nump2right && nump1right > nump3right && nump1right > nump4right && nump1right > nump5right) {
            System.out.println(name + ", with " + nump1right + " questions right, you had the most right. You get the points.");
            p1points = p1points + 200;
        } else if (nump2right > nump1right && nump2right > nump3right && nump2right > nump4right && nump2right > nump5right) {
            System.out.println("With " + nump2right + " questions right, " + p2name + "gets the points.");
            p2points = p2points + 200;
        } else if (nump3right > nump1right && nump3right > nump2right && nump3right > nump4right && nump3right > nump5right) {
            System.out.println("With " + nump3right + " questions right, " + p3name + "gets the points.");
            p3points = p3points + 200;
        } else if (nump4right > nump1right && nump4right > nump3right && nump4right > nump2right && nump4right > nump5right) {
            System.out.println("With " + nump4right + " questions right, " + p4name + "gets the points.");
            p4points = p4points + 200;
        } else if (nump5right > nump1right && nump5right > nump2right && nump5right > nump3right && nump5right > nump4right) {
            System.out.println("With " + nump5right + " questions right, " + p5name + "gets the points.");
            p5points = p5points + 200;
        } else {
            System.out.println("There was a tie, so no one gets the points. Sorry.");
        }

    }

    //----------------------------------------------------VOTING METHOD-----------------------------------------------------------------
    public static void voting() {

        String vote = " ";
        int p2vote = 0;
        int p3vote = 0;
        int p4vote = 0;
        int p5vote = 0;

        int vote1 = 0;
        int vote2 = 0;
        int vote3 = 0;
        int vote4 = 0;
        int vote5 = 0;

        boolean voted = false;
        boolean p2voted = false;
        boolean p3voted = false;
        boolean p4voted = false;
        boolean p5voted = false;

        boolean sweetness = false;

        System.out.println("The round is over. It's time to vote. Who do you vote to be out?");

        do {
            System.out.println("Type the respective player's number to vote them out. 2 for Player 2, etc.");
            do {
                vote = scan.nextLine();
                if (Integer.parseInt(vote) == 2) {
                    vote2 = vote2 + 1;
                    voted = true;
                } else if (Integer.parseInt(vote) == 3) {
                    vote3 = vote3 + 1;
                    voted = true;
                } else if (Integer.parseInt(vote) == 4) {
                    vote4 = vote4 + 1;
                    voted = true;
                } else if (Integer.parseInt(vote) == 5) {
                    vote5 = vote5 + 1;
                    voted = true;
                } else {
                    System.out.println("That is not a valid vote. Type 2, 3, 4, or 5 to vote for that player.");
                }
            } while (voted == false);

            if (p2out == false) {
                do {
                    p2vote = gen.nextInt(5) + 1;
                    if (p2vote == 1) {
                        if (p1out == false) {
                            vote1 = vote1 + 1;
                            p2voted = true;
                        }
                    } else if (p2vote == 3) {
                        if (p3out == false) {
                            vote3 = vote3 + 1;
                            p2voted = true;
                        }
                    } else if (p2vote == 4) {
                        if (p4out == false) {
                            vote4 = vote4 + 1;
                            p2voted = true;
                        }
                    } else if (p2vote == 5) {
                        if (p5out == false) {
                            vote5 = vote5 + 1;
                            p2voted = true;
                        }
                    }
                } while (p2voted == false);


                if (p3out == false) {
                    do {
                        p3vote = gen.nextInt(5) + 1;
                        if (p3vote == 1) {
                            if (p1out == false) {
                                vote1 = vote1 + 1;
                                p3voted = true;
                            }
                        } else if (p2vote == 2) {
                            if (p2out == false) {
                                vote2 = vote2 + 1;
                                p3voted = true;
                            }
                        } else if (p3vote == 4) {
                            if (p4out == false) {
                                vote4 = vote4 + 1;
                                p3voted = true;
                            }
                        } else if (p3vote == 5) {
                            if (p5out == false) {
                                vote5 = vote5 + 1;
                                p3voted = true;
                            }
                        } else {
                            p3voted = false;
                        }

                    } while (p3voted == false);
                }

                if (p4out == false) {
                    do {
                        p4vote = gen.nextInt(5) + 1;
                        if (p4vote == 1) {
                            if (p1out == false) {
                                vote1 = vote1 + 1;
                                p4voted = true;
                            }
                        } else if (p4vote == 2) {
                            if (p2out == false) {
                                vote2 = vote2 + 1;
                                p4voted = true;
                            }
                        } else if (p4vote == 3) {
                            if (p3out == false) {
                                vote3 = vote3 + 1;
                                p4voted = true;
                            }
                        } else if (p4vote == 5) {
                            if (p5out == false) {
                                vote5 = vote5 + 1;
                                p4voted = true;
                            }
                        } else {
                            p4voted = false;
                        }

                    } while (p4voted == false);
                }

                if (p5out == false) {
                    do {
                        p5vote = gen.nextInt(5) + 1;
                        if (p5vote == 1) {
                            if (p1out == false) {
                                vote1 = vote1 + 1;
                                p5voted = true;
                            }
                        } else if (p5vote == 3) {
                            if (p3out == false) {
                                vote3 = vote3 + 1;
                                p5voted = true;
                            }
                        } else if (p5vote == 4) {
                            if (p4out == false) {
                                vote4 = vote4 + 1;
                                p5voted = true;
                            }
                        } else if (p5vote == 2) {
                            if (p2out == false) {
                                vote2 = vote2 + 1;
                                p5voted = true;
                            }
                        } else {
                            p5voted = false;
                        }

                    } while (p5voted == false);
                }

                System.out.println(name + ", you have voted for Player " + vote + ".");

                if (p2out == false) {
                    System.out.println("Player 2, " + p2name + ", voted for Player " + p2vote);
                }

                if (p3out == false) {
                    System.out.println("Player 3, " + p3name + ", voted for Player " + p3vote);
                }

                if (p4out == false) {
                    System.out.println("Player 4, " + p4name + ", voted for Player " + p4vote);
                }

                if (p5out == false) {
                    System.out.println("Player 5, " + p5name + ", voted for Player " + p5vote);
                }
                System.out.println("");

                if (vote1 > vote2 && vote1 > vote3 && vote1 > vote4 && vote1 > vote5) {
                    System.out.println(name + ", you are the Weakest Link. You have been voted out. Game Over");
                    p1out = true;
                    sweetness = true;
                } else if (vote2 > vote1 && vote2 > vote3 && vote2 > vote4 && vote2 > vote5) {
                    System.out.println("Player 2, " + p2name + ", is the Weakest Link. They are out.");
                    p2out = true;
                    sweetness = true;
                } else if (vote3 > vote1 && vote3 > vote2 && vote3 > vote4 && vote3 > vote5) {
                    System.out.println("Player 3, " + p3name + ", is the Weakest Link. They are out.");
                    p3out = true;
                    sweetness = true;
                } else if (vote4 > vote1 && vote4 > vote2 && vote4 > vote3 && vote4 > vote5) {
                    System.out.println("Player 4, " + p4name + ", is the Weakest Link. They are out.");
                    p4out = true;
                    sweetness = true;
                } else if (vote5 > vote1 && vote5 > vote2 && vote5 > vote3 && vote5 > vote4) {
                    System.out.println("Player 5, " + p5name + ", is the Weakest Link. They are out.");
                    p5out = true;
                    sweetness = true;
                } else {
                    System.out.println("There was a tie. Please vote again.");
                }
            }
        } while (sweetness == false);
    }

//-------------------------------AI CHECKING------------------------------------------------------------------------
    public static Integer checkAI(String playerName, Integer numRight) {
        int isRight = gen.nextInt(2);
        if (isRight == 0) {
            System.out.println(playerName + " got the question wrong.");
            pointsPossible = 10;
        } else {
            System.out.println(playerName + " got the question right!");
            pointsPossible = pointsPossible + 10;
            numRight = numRight + 1;
        }
        return numRight;
    }
}
