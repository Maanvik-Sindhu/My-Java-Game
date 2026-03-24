
import java.util.Scanner;
import java.util.Random;

class Guess_The_Number {
    static void IsNumCorrect(int u, int c){
        if(u < c){
            System.out.println("Your number is Smaller");
        }
        else {
            System.out.println("Your number is Greater");
        }
    }

    static void main() {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);

        int Guess = 0;

        int com = ran.nextInt(101);
        System.out.println("Enter number Between 0 and 100");
        int user = sc.nextInt();

        while (com != user){
            IsNumCorrect(user,com);
            Guess ++;
            System.out.println("Enter Number");
            user = sc.nextInt();
        }
        if(com == user){
            System.out.println("You Guess The number");
            System.out.printf("Your Won in %d Guess\n",Guess+1);
        }

    }
}
