package com.adaptionsoft.games.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {

    private final List<String> players = new ArrayList<>();

    @Setter
    private int[] places = new int[6];
    private final int[] purses = new int[6];
    private final boolean[] inPenaltyBox = new boolean[6];

    @Getter
    @Setter
    private List<Question> popQuestions = new LinkedList<>();
    @Getter
    @Setter
    private List<Question> scienceQuestions = new LinkedList<>();
    @Getter
    @Setter
    private List<Question> sportsQuestions = new LinkedList<>();
    @Getter
    @Setter
    private List<Question> rockQuestions = new LinkedList<>();

    @Setter
    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;

    /**
     * It used to be possible to construct a game with less than two players and with more than six players however at
     * runtime things did not work out. There was also no validation that the game was in a playable state. The user had
     * to come up with the idea to call the isPlayable method. In this version it will not compile for anything other
     * than 2-6 players. The Game class can only be instantiated it the correct way, and the user gets immediate
     * feedback from the compiler on any usage errors. Granted this type of technique becomes awkward when the number of
     * constructors grows big, in those cases we revert back to a more traditional strategy of runtime validations in
     * the constructor.
     */
    public Game(final String player1, final String player2) {
        add(player1);
        add(player2);
        createQuestions();
    }

    public Game(final String player1, final String player2, final String player3) {
        this(player1, player2);
        add(player3);
    }

    public Game(final String player1, final String player2, final String player3, final String player4) {
        this(player1, player2, player3);
        add(player4);
    }

    public Game(final String player1, final String player2, final String player3, final String player4, final String player5) {
        this(player1, player2, player3, player4);
        add(player5);
    }

    public Game(final String player1, final String player2, final String player3, final String player4, final String player5, final String player6) {
        this(player1, player2, player3, player4, player5);
        add(player6);
    }

    private void createQuestions() {
        @Cleanup
        final IntStream stream = IntStream.range(0, 50);
        stream.forEach(id -> {
            buildLastQuestion(popQuestions, Category.POP, id);
            buildLastQuestion(scienceQuestions, Category.SCIENCE, id);
            buildLastQuestion(sportsQuestions, Category.SPORT, id);
            buildLastQuestion(rockQuestions, Category.ROCK, id);
        });
    }

    private static void buildLastQuestion(final List<Question> questions, final Category category, final int id) {
        final Question question = Question.builder().category(category).id(id).build();
        ((LinkedList<Question>) questions).addLast(question);
    }

    private boolean add(final String playerName) {
        players.add(playerName);

        final int howManyPlayers = howManyPlayers();
        places[howManyPlayers] = 0;
        purses[howManyPlayers] = 0;
        inPenaltyBox[howManyPlayers] = false;

        log.info(playerName + " was added");
        log.info("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(final int roll) {
        log.info(players.get(currentPlayer) + " is the current player");
        log.info("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                log.info(players.get(currentPlayer) + " is getting out of the penalty box");
                movePlayerAndAskQuestion(roll);
            } else {
                log.info(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            movePlayerAndAskQuestion(roll);
        }

    }

    private void movePlayerAndAskQuestion(final int roll) {
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) {
            places[currentPlayer] = places[currentPlayer] - 12;
        }

        log.info(players.get(currentPlayer) + "'s new location is " + places[currentPlayer]);
        log.info("The category is " + currentCategory());
        askQuestion();
    }

    void askQuestion() {
        final Category currentCategory = currentCategory();
        if (Category.POP.equals(currentCategory)) {
            log.info(((LinkedList<Question>) popQuestions).removeFirst().toString());
        } else if (Category.SCIENCE.equals(currentCategory)) {
            log.info(((LinkedList<Question>) scienceQuestions).removeFirst().toString());
        } else if (Category.SPORT.equals(currentCategory)) {
            log.info(((LinkedList<Question>) sportsQuestions).removeFirst().toString());
        } else if (Category.ROCK.equals(currentCategory)) {
            log.info(((LinkedList<Question>) rockQuestions).removeFirst().toString());
        }
    }

    Category currentCategory() {
        final Category[] categories = Category.values();
        final int index = places[currentPlayer] % categories.length;
        return categories[index];
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                log.info("Answer was correct!!!!");
                currentPlayer++;
                if (currentPlayer == players.size()) {
                    currentPlayer = 0;
                }
                purses[currentPlayer]++;
                log.info(players.get(currentPlayer) + " now has " + purses[currentPlayer] + " Gold Coins.");

                return !didPlayerWin();
            }

            currentPlayer++;
            if (currentPlayer == players.size()) {
                currentPlayer = 0;
            }
            return false;
        }

        log.info("Answer was corrent!!!!");
        purses[currentPlayer]++;
        log.info(players.get(currentPlayer) + " now has " + purses[currentPlayer] + " Gold Coins.");

        final boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == players.size()) {
            currentPlayer = 0;
        }

        return !winner;
    }

    public boolean wrongAnswer() {
        log.info("Question was incorrectly answered");
        log.info(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) {
            currentPlayer = 0;
        }
        return false;
    }

    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }
}
