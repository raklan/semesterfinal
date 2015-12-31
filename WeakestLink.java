import java.util.Random;
import java.util.Scanner;
// 0 is wrong 1 is right
/**
 * Write a description of class WeakestLink here.
 *
 * @author Ryan Lake and Chris Do
 * @version 1.1
 */

public  class WeakestLink {

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
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your name:");
        name = scan.nextLine();
        System.out.println("Welcome! Let's play The Weakest Link! You player 1.");
        System.out.println("");

        System.out.println("Round one: Addition. You will have numbers up to 1000");
        round2();


    }

    public static void round1() {
        if (p1out == false) {

            int tries = 3;


            int x = gen.nextInt(100) + 1;
            int y = gen.nextInt(100) + 1;

            int vote1 = 0;
            int vote2 = 0;
            int vote3 = 0;
            int vote4 = 0;
            int vote5 = 0;

            boolean voted = false;

            int p2right = 0;
            int p3right = 0;
            int p4right = 0;
            int p5right = 0;

            int nump1right = 0;
            int nump2right = 0;
            int nump3right = 0;
            int nump4right = 0;
            int nump5right = 0;


            int pointsPossible = 10;


            System.out.println("");


            String answer = "";

            boolean right = false;
            do {
                System.out.println("What is " + x + " plus " + y + "?");
                answer = scan.nextLine();
                if (answer.equals(x + y)) {
                    System.out.println("That is correct.");
                    nump1right = nump1right + 1;
                    pointsPossible = pointsPossible + 10;
                } else if (!answer.equals(x + y)) {
                    System.out.println("That is incorrect. You have " + tries + " remaining");
                    tries = tries - 1;
                }


            } while (tries > 0 && right == false);
            if (tries == 0) {
                pointsPossible = 10;
            }

            //P2 Right?-------------------------------------------------

            if (p2out == false) {
                p2right = gen.nextInt(2);
                if (p2right == 0) {
                    System.out.println(p2name + " got the question wrong.");
                    pointsPossible = 10;
                } else if (p2right == 1) {
                    System.out.println(p2name + " got the question right!");
                    pointsPossible = pointsPossible + 10;
                    nump2right = nump2right + 1;
                }
            }

            //P3 Right?--------------------------------------------
            if (p3out == false) {
                p3right = gen.nextInt(2);
                if (p3right == 0) {
                    System.out.println(p3name + " got the question wrong.");
                    pointsPossible = 10;
                } else if (p3right == 1) {
                    System.out.println(p3name + " got the question right!");
                    pointsPossible = pointsPossible + 10;
                    nump3right = nump3right + 1;
                }
            }

            //P4 Right?----------------------------------------------
            if (p4out == false) {
                p4right = gen.nextInt(2);
                if (p4right == 0) {
                    System.out.println(p4name + " got the question wrong.");
                    pointsPossible = 10;
                } else if (p4right == 1) {
                    System.out.println(p4name + " got the question right!");
                    pointsPossible = pointsPossible + 10;
                    nump4right = nump4right + 1;
                }
            }

            //P5 Right?------------------------------------------------
            if (p5out == false) {
                p5right = gen.nextInt(2);
                if (p5right == 0) {
                    System.out.println(p5name + " got the question wrong.");
                    pointsPossible = 10;
                } else if (p5right == 1) {
                    System.out.println(p5name + " got the question right!");
                    pointsPossible = pointsPossible + 10;
                    nump5right = nump5right + 1;
                }
            }


        }
    }


    //----------------------------ROUND 2-------------------------------------------------------


    public static void round2() {
        if (p1out == false) {
            String answer = "";
            int tries = 2;
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
                        System.out.println("That is incorrect. You have " + tries + " tries remaining");
                        tries = tries - 1;
                    }

                } while (tries > 0 && right == false);
                if (tries == 0) {
                    pointsPossible = 10;
                }
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
    }


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
                        vote1 = vote1 + 1;
                        p2voted = true;
                    } else if (p2vote == 3) {
                        vote3 = vote3 + 1;
                        p2voted = true;
                    } else if (p2vote == 4) {
                        vote4 = vote4 + 1;
                        p2voted = true;
                    } else if (p2vote == 5) {
                        vote5 = vote5 + 1;
                        p2voted = true;
                    } else {
                        p2voted = false;
                    }

                } while (p2voted == false);
            }

            if (p3out == false) {
                do {
                    p3vote = gen.nextInt(5) + 1;
                    if (p3vote == 1) {
                        vote1 = vote1 + 1;
                        p3voted = true;
                    } else if (p2vote == 2) {
                        vote2 = vote2 + 1;
                        p3voted = true;
                    } else if (p3vote == 4) {
                        vote4 = vote4 + 1;
                        p3voted = true;
                    } else if (p3vote == 5) {
                        vote5 = vote5 + 1;
                        p3voted = true;
                    } else {
                        p3voted = false;
                    }

                } while (p3voted == false);
            }

            if (p4out == false) {
                do {
                    p4vote = gen.nextInt(5) + 1;
                    if (p4vote == 1) {
                        vote1 = vote1 + 1;
                        p4voted = true;
                    } else if (p4vote == 2) {
                        vote2 = vote2 + 1;
                        p4voted = true;
                    } else if (p4vote == 3) {
                        vote3 = vote3 + 1;
                        p4voted = true;
                    } else if (p4vote == 5) {
                        vote5 = vote5 + 1;
                        p4voted = true;
                    } else {
                        p4voted = false;
                    }

                } while (p4voted == false);
            }

            if (p4out == false) {
                do {
                    p5vote = gen.nextInt(5) + 1;
                    if (p5vote == 1) {
                        vote1 = vote1 + 1;
                        p5voted = true;
                    } else if (p5vote == 3) {
                        vote3 = vote3 + 1;
                        p5voted = true;
                    } else if (p5vote == 4) {
                        vote4 = vote4 + 1;
                        p5voted = true;
                    } else if (p5vote == 2) {
                        vote2 = vote2 + 1;
                        p5voted = true;
                    } else {
                        p5voted = false;
                    }

                } while (p5voted == false);
            }

            System.out.println(name + ", you have voted for Player " + vote + ".");
            System.out.println("Player 2, " + p2name + ", voted for Player " + p2vote);
            System.out.println("Player 3, " + p3name + ", voted for Player " + p3vote);
            System.out.println("Player 4, " + p4name + ", voted for Player " + p4vote);
            System.out.println("Player 5, " + p5name + ", voted for Player " + p5vote);
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

        } while (sweetness == false);
    }

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
