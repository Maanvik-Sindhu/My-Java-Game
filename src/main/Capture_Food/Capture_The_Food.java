package main.Capture_Food;

import main.Main;

/*
You can't Run this you need to go to Main class
 */

import java.util.*;
public class Capture_The_Food implements Important_Methods{
    int i = 0;
    int j = 0;

    Random ran = new Random();
    int r1 = ran.nextInt(10);
    int r2 = ran.nextInt(10);

    char [][] board = {
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},

    };
    @Override
    public void printBoard() {
        System.out.println("_______________________________________");
        for (int i = 0; i< board.length; i++){
            System.out.print("|");
            for (int j = 0; j< board.length; j++){
                if (j==9){
                    System.out.print(board[i][j]+"");
                }
                else {
                    System.out.print(board[i][j]+"   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("---------------------------------------");
    }

    @Override
    public void playerPosition() {
            this.board[this.i][this.j] = '@';

    }

    @Override
    public void playerMovement() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter W,S,A,D to control player");

        String CP = sc.next().toUpperCase();

        // Clear old position
        this.board[this.i][this.j] = ' ';

        switch (CP) {
            case "W":
                this.i--;
                break;
            case "S":
                this.i++;
                break;
            case "A":
                this.j--;
                break;
            case "D":
                this.j++;
                break;
            default:
                System.out.println("Invalid Input! Please enter W, A, S, or D");
        }
    }

    @Override
    public void foodLocation() {
        this.board[this.r1][this.r2] = '*';
    }

    @Override
    public boolean isPlayerWin() {
        if (this.i == this.r1 && this.j== this.r2){
            this.board[r1][r2] = ' ';
            this.r1 = ran.nextInt(10);
            this.r2 = ran.nextInt(10);
            foodLocation();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void placeObstacles(int count){
        int x,y;
        for (int k = 0; k < count; k++) {
            x = ran.nextInt(10);
            y = ran.nextInt(10);
            if ((x == i && y == j) || (x == r1 && y == r2)) {
                k--;
                continue;
            }
            board[x][y] = '#';
        }
    }

    @Override
    public boolean checkObstacles() {
        if (board[i][j]=='#'){
            System.out.println("You Hit the Obstacle!......");
            System.out.println("You Lost");
            return true;
        }
        else {
            return false;
        }
    }

    public static void main() {
        Capture_The_Food g = new Capture_The_Food();
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO CAPTURE THE FOOD");
        System.out.println("Select difficulty: \ne for easy, \nm for medium, \nh for hard");
        String dif = sc.next();
        if (dif.equalsIgnoreCase("h")){
            g.placeObstacles(15);
        }
        else if (dif.equalsIgnoreCase("m")) {
            g.placeObstacles(10);
        }
        else {
            g.placeObstacles(5);
        }
             Main.clearScreen();


        System.out.println("'@'is you player and '*' is you food");
        int i = 0;
        try {
            while (i<3) {
                do {
                    g.foodLocation();
                }while (false);
                g.playerPosition();
                g.printBoard();
                g.playerMovement();
                if (g.isPlayerWin()){
                    System.out.println("You Won!....");
                    i++;
                }
                else if (g.checkObstacles()) {
                    break;
                }
                    Main.clearScreen();
            }
            if (i==2){
                System.out.println("You Won The Match");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You Hit The Walls!......");
            System.out.println("You Lost!......");
        }

    }
}