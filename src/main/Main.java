package main;

import java.io.*;
import java.util.Scanner;
import main.Capture_Food.*;
import main.TicTacToe.*;
import main.HangMan.*;

public class Main {

    public static void clearScreen(){
        try {
            // Method 1: Standard ANSI Escape Codes (Works on Linux, macOS, and modern Windows 10/11)
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Method 2: OS-Specific Process Builder (Fallback for standard system terminals)
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Executes the 'cls' command inside the Windows command prompt environment
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Executes the 'clear' command on Linux and macOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            // Method 3: Visual Fallback (If running inside restricted IDE consoles like Eclipse)
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    
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


        boolean play = true;


        while (play){
            play = false;
            System.out.println("What you want to play");
            System.out.println("Write: \nG for Guess The Number \nC for Capture The Food \nR for Rock Paper Scissor \nT for Tic Tac Toe \nH for HangMan \nB for Battleship \nCT for Coin Toss");
            String choice = sc.next().toUpperCase();
            clearScreen();
            if(choice.equals("G")){
                GTN.main();
            }
            else if (choice.equals("R")){
                RPS.main();
            }
            else if (choice.equals("C")){
                CTF.main();
            }
            else if (choice.equals("T")){
                TTT.main();
            }
            else if (choice.equals("H")){
                HM.main();
            }
            else if (choice.equals("B")){
                BS.main();
            }
            else if (choice.equals("CT")){
                CT.main();
            }
            else {
                System.out.println("Can't Understand!...........");
                play = true;
            }
            System.out.println("\n");
            play = morePlay();
            clearScreen();
        }
        System.out.println("Thanks for playing!.........");

    }
}