package com.adaptionsoft.games.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;

import extension.TestStatusLoggerExtension;

@ExtendWith({ TestStatusLoggerExtension.class })
public class GameTest {

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_0() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 0 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.POP);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_1() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 1 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.SCIENCE);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_2() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 2 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.SPORT);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_3() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 3 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.ROCK);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_4() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 4 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.POP);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_5() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 5 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.SCIENCE);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_6() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 6 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.SPORT);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_7() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 7 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.ROCK);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_8() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 8 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.POP);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_9() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 9 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.SCIENCE);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_10() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 10 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.SPORT);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#currentCategory()}.
     */
    @Test
    public void currentCategory_should_returns_POP_when_current_player_is_in_place_11() {
        // Given
        final Game game = new Game("Chet", "Pat", "Sue");
        game.setCurrentPlayer(0);
        game.setPlaces(new int[] { 11 });

        // When
        final Category result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo(Category.ROCK);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#askQuestion()}.
     */
    @Test
    public void askQuestion_should_remove_first_element_of_popQuestions_when_current_categorie_is_POP() {
        // Given
        final Question popQuestion = new Question(2, Category.POP);
        final LinkedList<Question> popQuestions = new LinkedList<>(Arrays.asList(new Question(1, Category.POP), popQuestion));
        final LinkedList<Question> rockQuestions = new LinkedList<>(Arrays.asList(new Question(2, Category.ROCK), new Question(3, Category.ROCK)));
        final LinkedList<Question> sportsQuestions = new LinkedList<>(
                Arrays.asList(new Question(3, Category.SPORT), new Question(4, Category.SPORT)));
        final LinkedList<Question> scienceQuestions = new LinkedList<>(
                Arrays.asList(new Question(4, Category.SCIENCE), new Question(5, Category.SCIENCE)));

        final Game game = spy(new Game("Chet", "Pat", "Sue"));
        game.setPopQuestions(popQuestions);
        game.setRockQuestions(rockQuestions);
        game.setSportsQuestions(sportsQuestions);
        game.setScienceQuestions(scienceQuestions);
        BDDMockito.given(game.currentCategory()).willReturn(Category.POP);

        // When
        game.askQuestion();

        // Then
        assertThat(game.getPopQuestions()).containsExactly(popQuestion);
        assertThat(game.getRockQuestions()).containsAll(rockQuestions);
        assertThat(game.getSportsQuestions()).containsAll(sportsQuestions);
        assertThat(game.getScienceQuestions()).containsAll(scienceQuestions);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#askQuestion()}.
     */
    @Test
    public void askQuestion_should_remove_first_element_of_rockQuestions_when_current_categorie_is_ROCK() {
        // Given
        final LinkedList<Question> popQuestions = new LinkedList<>(Arrays.asList(new Question(1, Category.POP), new Question(2, Category.POP)));

        final Question rockQuestion = new Question(3, Category.ROCK);
        final LinkedList<Question> rockQuestions = new LinkedList<>(Arrays.asList(new Question(2, Category.ROCK), rockQuestion));
        final LinkedList<Question> sportsQuestions = new LinkedList<>(
                Arrays.asList(new Question(3, Category.SPORT), new Question(4, Category.SPORT)));
        final LinkedList<Question> scienceQuestions = new LinkedList<>(
                Arrays.asList(new Question(4, Category.SCIENCE), new Question(5, Category.SCIENCE)));

        final Game game = spy(new Game("Chet", "Pat", "Sue"));
        game.setPopQuestions(popQuestions);
        game.setRockQuestions(rockQuestions);
        game.setSportsQuestions(sportsQuestions);
        game.setScienceQuestions(scienceQuestions);
        BDDMockito.given(game.currentCategory()).willReturn(Category.ROCK);

        // When
        game.askQuestion();

        // Then
        assertThat(game.getPopQuestions()).containsAll(popQuestions);
        assertThat(game.getRockQuestions()).containsExactly(rockQuestion);
        assertThat(game.getSportsQuestions()).containsAll(sportsQuestions);
        assertThat(game.getScienceQuestions()).containsAll(scienceQuestions);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#askQuestion()}.
     */
    @Test
    public void askQuestion_should_remove_first_element_of_scienceQuestions_when_current_categorie_is_SPORT() {
        // Given
        final LinkedList<Question> popQuestions = new LinkedList<>(Arrays.asList(new Question(1, Category.POP), new Question(2, Category.POP)));
        final LinkedList<Question> rockQuestions = new LinkedList<>(Arrays.asList(new Question(2, Category.ROCK), new Question(3, Category.ROCK)));

        final Question sportQuestion = new Question(4, Category.SPORT);
        final LinkedList<Question> sportsQuestions = new LinkedList<>(Arrays.asList(new Question(3, Category.SPORT), sportQuestion));
        final LinkedList<Question> scienceQuestions = new LinkedList<>(
                Arrays.asList(new Question(4, Category.SCIENCE), new Question(5, Category.SCIENCE)));

        final Game game = spy(new Game("Chet", "Pat", "Sue"));
        game.setPopQuestions(popQuestions);
        game.setRockQuestions(rockQuestions);
        game.setSportsQuestions(sportsQuestions);
        game.setScienceQuestions(scienceQuestions);
        BDDMockito.given(game.currentCategory()).willReturn(Category.SPORT);

        // When
        game.askQuestion();

        // Then
        assertThat(game.getPopQuestions()).containsAll(popQuestions);
        assertThat(game.getRockQuestions()).containsAll(rockQuestions);
        assertThat(game.getSportsQuestions()).containsExactly(sportQuestion);
        assertThat(game.getScienceQuestions()).containsAll(scienceQuestions);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#askQuestion()}.
     */
    @Test
    public void askQuestion_should_remove_first_element_of_scienceQuestions_when_current_categorie_is_SCIENCE() {
        // Given
        final LinkedList<Question> popQuestions = new LinkedList<>(Arrays.asList(new Question(1, Category.POP), new Question(2, Category.POP)));
        final LinkedList<Question> rockQuestions = new LinkedList<>(Arrays.asList(new Question(2, Category.ROCK), new Question(3, Category.ROCK)));
        final LinkedList<Question> sportsQuestions = new LinkedList<>(
                Arrays.asList(new Question(3, Category.SPORT), new Question(4, Category.SPORT)));

        final Question scienceQuestion = new Question(5, Category.SCIENCE);
        final LinkedList<Question> scienceQuestions = new LinkedList<>(Arrays.asList(new Question(4, Category.SCIENCE), scienceQuestion));

        final Game game = spy(new Game("Chet", "Pat", "Sue"));
        game.setPopQuestions(popQuestions);
        game.setRockQuestions(rockQuestions);
        game.setSportsQuestions(sportsQuestions);
        game.setScienceQuestions(scienceQuestions);
        BDDMockito.given(game.currentCategory()).willReturn(Category.SCIENCE);

        // When
        game.askQuestion();

        // Then
        assertThat(game.getPopQuestions()).containsAll(popQuestions);
        assertThat(game.getRockQuestions()).containsAll(rockQuestions);
        assertThat(game.getSportsQuestions()).containsAll(sportsQuestions);
        assertThat(game.getScienceQuestions()).containsExactly(scienceQuestion);
    }

}
