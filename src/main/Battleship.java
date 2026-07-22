
package main;
/*
You can't Run this you need to go to Main class
 */

import java.util.Random;
import java.util.Scanner;

public class Battleship {
    char [][] board = {
            {'~','~','~','~','~'},
            {'~','~','~','~','~'},
            {'~','~','~','~','~'},
            {'~','~','~','~','~'},
            {'~','~','~','~','~'},
    };
    char [][] hiddenBoard = {
            {'~','~','~','~','~'},
            {'~','~','~','~','~'},
            {'~','~','~','~','~'},
            {'~','~','~','~','~'},
            {'~','~','~','~','~'},
    };
    int shipParts = 3;
    int hit = 0;



    public void printBoard(){
        System.out.println("_____________");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j==0){
                    System.out.print("| ");
                }
                System.out.print(board[i][j]+" ");
                if (j==4){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
    public void placeShips(){
        Random ran = new Random();
        int row = ran.nextInt(5);
        int col = ran.nextInt(3);
        for (int i = 0; i < shipParts; i++) {
            hiddenBoard[row][col+i] = 'S';
        }

    }
    public boolean attack(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Row(1-5)");
        int row = sc.nextInt() -1;
        System.out.println("Enter Column(1-5)");
        int col = sc.nextInt() -1;
        

        if (hiddenBoard[row][col] == 'S'){
            System.out.println("Hit!........");
            hiddenBoard[row][col] = 'H';
            board[row][col] = 'X';
            hit++;
            if (hit==shipParts){
                System.out.println("Congratulations You Won");
                printBoard();
                return true;
            }
            return false;
        }
        else {
                 Main.clearScreen();
            board[row][col] = 'O';
            return false;
        }
    }

    public static void main() {
        Battleship main = new Battleship();
        main.placeShips();
        int attempts = 5;
        boolean win = false;
        while (!win || attempts==0){
            main.printBoard();
            win = main.attack();
            if (!win){
                attempts--;
            }
        }
    }
}
