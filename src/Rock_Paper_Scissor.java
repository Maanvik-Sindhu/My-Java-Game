/*
You can't Run this you need to go Games Runner
 */

import java.util.Random;
import java.util.Scanner;

class Rock_Paper_Scissor {
    static void ComChoice(int n){
        if (n == 0){
            System.out.println("Computer choice: Rock");
        }
        else if (n == 1) {
            System.out.println("Computer choice: Paper");
        }
        else if(n == 2){
            System.out.println("Computer choice: Scissor");
        }

    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        System.out.println("Welcome to Rock , Paper , Scissor");
        System.out.println("How many rounds do you want to play");
        int round = sc.nextInt();

        int MyScore = 0;
        int ComScore = 0;

        for(int i = 1; i<=round; i++){
            System.out.println("Write 0 for rock , 1 for Paper , 2 for Scissor");
            byte me = sc.nextByte(3);
            int com = ran.nextInt(3);

            if (me == 0 && com == 1 || me == 1 && com == 2 || me == 2 && com == 0) {
                System.out.println("you lost");
                ComChoice(com);
                ComScore = ComScore + 1;
            }
            else if (me == 0 && com == 2 || me == 1 && com == 0 || me == 2 && com == 1) {
                System.out.println("you won");
                ComChoice(com);
                MyScore = MyScore + 1;
            }
            else {
                System.out.println("Draw");
                ComChoice(com);
            }
        }
        if(MyScore > ComScore){
            System.out.printf("Score is: %d , %d \n",MyScore,ComScore);
            System.out.println("You won the Match");
        }
        else if(MyScore == ComScore){
            System.out.printf("Score is: %d , %d \n",MyScore,ComScore);
            System.out.println("This match is draw");
        }
        else if(MyScore < ComScore){
            System.out.printf("Score is: %d , %d \n",MyScore,ComScore);
            System.out.println("You lost the Match");
        }
    }
}