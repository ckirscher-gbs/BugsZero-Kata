
package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

import com.adaptionsoft.games.model.Game;

public class GameRunner {

    private static boolean HAS_WINNER;

    public static void main(final String[] args) {
        final Random rand = new Random();
        playGame(rand);
    }

    public static void playGame(final Random rand) {
        final Game aGame = new Game("Chet", "Pat", "Sue");

        do {
            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                HAS_WINNER = aGame.wrongAnswer();
            } else {
                HAS_WINNER = aGame.wasCorrectlyAnswered();
            }
        }
        while (!HAS_WINNER);
    }
}
