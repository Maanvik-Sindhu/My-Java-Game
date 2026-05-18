import java.util.Scanner;
import Capture_Food.*;
import TicTacToe.*;
import HangMan.*;

public class Main {

    static boolean morePlay(){
        Scanner sc = new Scanner(System.in);
        boolean un = false;
        System.out.println("Do you want more!..........");
        System.out.println("Write Y for YES and N for NO");
        while (!un){
            String more = sc.next().toUpperCase();

            if(more.startsWith("Y")){
                un = true;
                return true;
            }
            else if(more.startsWith("N")){
                un = true;
                return false;
            }
            else {
                System.out.println("Can't understand say that again");
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean more;

        Guess_The_Number GTN = new Guess_The_Number();
        Rock_Paper_Scissor RPS = new Rock_Paper_Scissor();
        Capture_The_Food CTF = new Capture_The_Food();
        TicTacToe TTT = new TicTacToe();
        HangMan HM = new HangMan();
        Battleship BS = new Battleship();
        CoinToss CT = new CoinToss();


        boolean play = false;


        while (!play){
            System.out.println("What you want to play");
            System.out.println("Write: \nG for Guess The Number \nC for Capture The Food \nR for Rock Paper Scissor \nT for Tic Tac Toe \nH for HangMan \nB for Battleship \nCT for Coin Toss");
            String choice = sc.next().toUpperCase();
            if(choice.startsWith("G")){
                GTN.main();
                more = morePlay();

                if (more){
                    continue;
                }
                else {
                    break;
                }
            }
            else if (choice.startsWith("R")){
                RPS.main();
                more = morePlay();
                if (more){
                    continue;
                }
                else {
                    break;
                }
            }
            else if (choice.startsWith("C")){
                CTF.main();
                more = morePlay();
                if (more){
                    continue;
                }
                else {
                    break;
                }
            }
            else if (choice.startsWith("T")){
                TTT.main();
                more = morePlay();
                if (more){
                    continue;
                }
                else {
                    break;
                }
            }
            else if (choice.startsWith("H")){
                HM.main();
                more = morePlay();
                if (more){
                    continue;
                }
                else {
                    break;
                }
            }
            else if (choice.startsWith("B")){
                BS.main();
                more = morePlay();
                if (more){
                    continue;
                }
                else {
                    break;
                }
            }
            else if (choice.startsWith("CT")){
                CT.main();
                more = morePlay();
                if (more){
                    continue;
                }
                else {
                    break;
                }
            }
            else {
                System.out.println("Can't Understand!...........");
            }
        }
        System.out.println("Thanks for playing!.........");

    }
}