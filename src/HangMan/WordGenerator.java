package HangMan;

/*
You can't Run this you need to go to Main class
 */

import java.util.Random;

public class WordGenerator {
    Random ran = new Random();
    String []word = {
            "WORD",
            "CHAIR",
            "GLASS",
            "BED",
            "MIRROR",
            "WIRE",
            "CHARGER"
    };

    public String getWord() {
        int num = ran.nextInt(7);
        return word[num];
    }
}
