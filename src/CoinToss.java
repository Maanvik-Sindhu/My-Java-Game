import java.util.Random;
import java.util.Scanner;

/*
You can't Run this you need to go to Main class
 */

public class CoinToss {
    public static void main() {
        int score = 0;
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        for (int round =1; round<=5; round++){
            System.out.println("Round "+round+"-- Guess (Heads/Tails): ");
            String guess = sc.next().toLowerCase();
            String result = ran.nextBoolean() ? "heads" : "tails";
            System.out.println("Result: "+result);
            if (guess.equals(result)){
                System.out.println("Correct!.....");
                score += 10;
            }
            else {
                System.out.println("Wrong!");
            }
        }
        System.out.println("Final Score: "+score);
    }
}
