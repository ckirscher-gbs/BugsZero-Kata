package com.adaptionsoft.games.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    private List<String> popQuestions = new LinkedList<>();
    @Getter
    @Setter
    private List<String> scienceQuestions = new LinkedList<>();
    @Getter
    @Setter
    private List<String> sportsQuestions = new LinkedList<>();
    @Getter
    @Setter
    private List<String> rockQuestions = new LinkedList<>();

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
        for (int i = 0; i < 50; i++) {
            ((LinkedList<String>) popQuestions).addLast("Pop Question " + i);
            ((LinkedList<String>) scienceQuestions).addLast("Science Question " + i);
            ((LinkedList<String>) sportsQuestions).addLast("Sports Question " + i);
            ((LinkedList<String>) rockQuestions).addLast(createRockQuestion(i));
        }
    }

    public String createRockQuestion(final int index) {
        return "Rock Question " + index;
    }

    private boolean add(final String playerName) {
        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(final int roll) {
        System.out.println(players.get(currentPlayer) + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
                movePlayerAndAskQuestion(roll);
            } else {
                System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
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

        System.out.println(players.get(currentPlayer) + "'s new location is " + places[currentPlayer]);
        System.out.println("The category is " + currentCategory());
        askQuestion();
    }

    void askQuestion() {
        final Category currentCategory = currentCategory();
        if (Category.POP.equals(currentCategory)) {
            System.out.println(((LinkedList<String>) popQuestions).removeFirst());
        } else if (Category.SCIENCE.equals(currentCategory)) {
            System.out.println(((LinkedList<String>) scienceQuestions).removeFirst());
        } else if (Category.SPORT.equals(currentCategory)) {
            System.out.println(((LinkedList<String>) sportsQuestions).removeFirst());
        } else if (Category.ROCK.equals(currentCategory)) {
            System.out.println(((LinkedList<String>) rockQuestions).removeFirst());
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
                System.out.println("Answer was correct!!!!");
                currentPlayer++;
                if (currentPlayer == players.size()) {
                    currentPlayer = 0;
                }
                purses[currentPlayer]++;
                System.out.println(players.get(currentPlayer) + " now has " + purses[currentPlayer] + " Gold Coins.");

                return !didPlayerWin();
            }

            currentPlayer++;
            if (currentPlayer == players.size()) {
                currentPlayer = 0;
            }
            return false;
        }

        System.out.println("Answer was corrent!!!!");
        purses[currentPlayer]++;
        System.out.println(players.get(currentPlayer) + " now has " + purses[currentPlayer] + " Gold Coins.");

        final boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == players.size()) {
            currentPlayer = 0;
        }

        return !winner;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
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
