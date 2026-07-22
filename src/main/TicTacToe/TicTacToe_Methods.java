package main.TicTacToe;

public interface TicTacToe_Methods {
    void printBoard();
    void positionOfPlayers();
    char isWin();
    boolean isWritten(int i, int j);
    int playerInput();
    void modifyPlayer();
    boolean isFull();
}
