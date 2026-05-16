package HangMan;

/*
You can't Run this you need to go to Main class
 */

import java.util.Scanner;

public class HangMan {
    Scanner sc = new Scanner(System.in);
    WordGenerator w = new WordGenerator();
    private String actualWord = w.getWord();
    int length =actualWord.length();

    private char []word = new char[length];
    char []shownWord = new char[length];
    char alphabet;
    private int attempts = 5;

    public void setWord(){
        for (int i=0; i<length; i++){
            word[i] = actualWord.charAt(i);
        }
    }
    public void setShownWord() {
        for (int i=0; i< word.length; i++){
            this.shownWord[i] = '_';
        }
    }

    public void getWord() {
        for (int i=0; i<length; i++){
            System.out.println(word[i]);
        }
    }

    public int getAttempts() {
        return attempts;
    }

    public void getShownWord(){
        for (int i = 0; i< shownWord.length; i++) {
            System.out.print(shownWord[i]);
        }
        System.out.println();
    }

    public void guessWord(){
        System.out.println("Enter Alphabet");
        try {
            alphabet = sc.next().toUpperCase().charAt(0);
        }
        catch (Exception e) {
            System.out.println("SOME ERROR OCCURRED");
        }

    }

    public boolean isCorrect(){
        boolean b = false;
        for (int i=0; i< word.length; i++){
            if (word[i] == alphabet){
                shownWord[i] = word[i];
                b = true;
            }
        }
        if (!b){
            attempts--;
        }
            return b;
    }

    public boolean isWin(){
        boolean b = true;
        for (int i=0; i< word.length; i++){
            if (!(word[i] == shownWord[i])){
                b = false;
            }
        }
        return b;
    }

    public static void main() {
        HangMan h = new HangMan();
        System.out.println("WELCOME TO HANGMAN");
        h.setShownWord();
        h.setWord();
        boolean b = false;
        while (!b) {
            h.getShownWord();
            System.out.println("Attempts: " + h.getAttempts());
            h.guessWord();
            h.isCorrect();
            b = h.isWin();
            if (h.getAttempts() == 0) {
                break;
            }
        }
        if (h.getAttempts() == 0) {
            System.out.println("You Lost");
            System.out.println("It was: ");
            h.getWord();

        } else {
            System.out.println("CONGRATULATIONS YOU WON");
            System.out.print("It was: ");
            h.getShownWord();
            System.out.println();
        }
    }
}
