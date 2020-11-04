package com.nafaa.midtermyoussefnafaa;

import java.util.Random;

public class Dice {

    // properties of the class Dice

    private int numSides;
    private int sideUp;

    // Constructor with one parameter
    public Dice(int numSides) {

        if(numSides < 4 || numSides > 20)
            return;
        this.numSides = numSides;
    }


    // Accessors

    // Access the Up of the dice
    public int getSideUp() {
        return this.sideUp;
    }

    /* This method will return a random number
     * forTrue10 will be = 0 if we roll up true dice 10 and 1 otherwise
     */
    private int getRandomFor(int number, int forTrue10) {
        Random random = new Random();
        return (random.nextInt(number)+forTrue10);
    }
    // Method roll that will show a sideup of a dice randomly
    public void roll(int forTrue10) {
        this.sideUp = getRandomFor(this.numSides, forTrue10);
    }
}
