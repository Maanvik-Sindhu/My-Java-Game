package Capture_Food;

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
        System.out.println("___________________________________________________________________________");
        for (int i = 0; i< board.length; i++){
            System.out.print("|");
            for (int j = 0; j< board.length; j++){
                if (j==9){
                    System.out.print(board[i][j]+"");
                }
                else {
                    System.out.print(board[i][j]+"       ");
                }
            }
            System.out.println("|");
        }
        System.out.println("---------------------------------------------------------------------------");
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
        this.board[this.i][this.j] = ' ';
        boolean b = false;
        while (!b)
            switch (CP){
                case "W":
                    this.i = i-1;
                    break;
                case "S":
                    this.i = i+1;
                    break;
                case "A":
                    this.j = j-1;
                    break;
                case "D":
                    this.j = j+1;
            }
            if (CP != "W" ||CP != "S" ||CP != "A" ||CP != "D"){
                System.out.println("Can't understand \n Say That Again");
            }
            else {
                b = true;
            }
    }

    @Override
    public void foodLocation() {
        this.board[this.r1][this.r2] = '*';
    }

    @Override
    public boolean isPlayerWin() {
        Random ran = new Random();
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

    public static void main() {
        Capture_The_Food g = new Capture_The_Food();
        System.out.println("WELCOME TO CAPTURE THE FOOD");
        System.out.println("'@'is you player and '*' is you food");
        int i = 0;
        try {
            while (i<5) {
                do {
                    g.foodLocation();
                }while (false);
                g.playerPosition();
                g.printBoard();
                g.playerMovement();
                if (g.isPlayerWin()){
                    System.out.println("You Capture food");
                    i++;
                }
            }
            if (i==4){
                System.out.println("You Won The Match");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You Hit The Walls!......");
            System.out.println("You Lost!......");
        }

    }
}