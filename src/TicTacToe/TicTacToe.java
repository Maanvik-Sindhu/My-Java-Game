package TicTacToe;

import java.util.Scanner;

public class TicTacToe implements TicTacToe_Methods{
    char [][] board = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
    };
    char player = 'O';
    @Override
    public void printBoard() {
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (j==2){
                    System.out.print(board[i][j]);
                }
                else {
                    System.out.print(board[i][j] + "   |   ");
                }
            }
            if (i==2){
                System.out.println();
            }
            else {
                System.out.println("\n___________________");
            }
        }
    }

    @Override
    public boolean isWritten(int i, int j) {
        return board[i][j] != ' ';

    }

    @Override
    public int playerInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    @Override
    public void positionOfPlayers() {
        boolean repeat = false;

        System.out.println("Enter Number of block");
        int input;
        do {
            repeat = false;
            input = playerInput();
            if (input == 1) {
                if (!isWritten(0,0)){
                    this.board[0][0] = player;
                }
                else {
                    System.out.println("There is already written");
                    System.out.println("Enter Again");
                    repeat = true;
                }
            }
            else if (input == 2) {
                if (!isWritten(0,1)){
                    this.board[0][1] = player;
                }
                else {
                    System.out.println("There is already written");
                    System.out.println("Enter Again");
                    repeat = true;
                }
            }
            else if (input == 3) {
                if (!isWritten(0,2)){
                    this.board[0][2] = player;
                }
                else {
                    System.out.println("There is already written");
                    System.out.println("Enter Again");
                    repeat = true;
                }
            }
            else if (input == 4) {
                if (!isWritten(1,0)){
                    this.board[1][0] = player;
                }
                else {
                    System.out.println("There is already written");
                    System.out.println("Enter Again");
                    repeat = true;
                }
            }
            else if (input == 5) {
                if (!isWritten(1,1)){
                    this.board[1][1] = player;
                }
                else {
                    System.out.println("There is already written");
                    System.out.println("Enter Again");
                    repeat = true;
                }
            }
            else if (input == 6) {
                if (!isWritten(1,2)){
                    this.board[1][2] = player;
                }
                else {
                    System.out.println("There is already written");
                    System.out.println("Enter Again");
                    repeat = true;
                }
            }
            else if (input == 7) {
                if (!isWritten(2,0)){
                    this.board[2][0] = player;
                }
                else {
                    System.out.println("There is already written");
                    System.out.println("Enter Again");
                    repeat = true;
                }
            }
            else if (input == 8) {
                if (!isWritten(2,1)){
                    this.board[2][1] = player;
                }
                else {
                    System.out.println("There is already written");
                    System.out.println("Enter Again");
                    repeat = true;
                }
            }
            else if (input == 9) {
                if (!isWritten(2,2)){
                    this.board[2][2] = player;
                }
                else {
                    System.out.println("There is already written");
                    System.out.println("Enter Again");
                    repeat = true;
                }
            }
            else {
                System.out.println("Can't Understand write from 1 to 9");
                repeat = true;
            }
        }while (repeat);
    }

    @Override
    public char isWin() {
        if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||
                (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
                (board[2][0] == 'X' && board[1][1] == 'X' &&board[0][2] == 'X')){
            return 'X';
        }
        else if ((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
                (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||
                (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||
                (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
                (board[2][0] == 'O' && board[1][1] == 'O' &&board[0][2] == 'O')){
            return 'O';
        }
        else {
            return 0;
        }
    }

    public void main() {
        TicTacToe main = new TicTacToe();
        while (true) {
            main.printBoard();
            main.positionOfPlayers();
            if(main.isWin() != 0){
                break;
            }

            if (main.player == 'O') {
                main.player = 'X';
            } else if (main.player == 'X') {
                main.player = 'O';
            }
        }
        if (main.player == 'O') {
            main.player = 'X';
        } else if (main.player == 'X') {
            main.player = 'O';
        }
        main.printBoard();
        System.out.println("Congratulations player "+main.player+" has Won");
    }
}