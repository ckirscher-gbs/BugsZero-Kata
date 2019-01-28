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
        final LinkedList<String> popQuestions = new LinkedList<>(Arrays.asList("1", "2"));
        final LinkedList<String> rockQuestions = new LinkedList<>(Arrays.asList("2", "3"));
        final LinkedList<String> sportsQuestions = new LinkedList<>(Arrays.asList("3", "4"));
        final LinkedList<String> scienceQuestions = new LinkedList<>(Arrays.asList("4", "5"));

        final Game game = spy(new Game("Chet", "Pat", "Sue"));
        game.setPopQuestions(popQuestions);
        game.setRockQuestions(rockQuestions);
        game.setSportsQuestions(sportsQuestions);
        game.setScienceQuestions(scienceQuestions);
        BDDMockito.given(game.currentCategory()).willReturn(Category.POP);

        // When
        game.askQuestion();

        // Then
        assertThat(game.getPopQuestions()).containsExactly("2");
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
        final LinkedList<String> popQuestions = new LinkedList<>(Arrays.asList("1", "2"));
        final LinkedList<String> rockQuestions = new LinkedList<>(Arrays.asList("2", "3"));
        final LinkedList<String> sportsQuestions = new LinkedList<>(Arrays.asList("3", "4"));
        final LinkedList<String> scienceQuestions = new LinkedList<>(Arrays.asList("4", "5"));

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
        assertThat(game.getRockQuestions()).containsExactly("3");
        assertThat(game.getSportsQuestions()).containsAll(sportsQuestions);
        assertThat(game.getScienceQuestions()).containsAll(scienceQuestions);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#askQuestion()}.
     */
    @Test
    public void askQuestion_should_remove_first_element_of_scienceQuestions_when_current_categorie_is_SPORT() {
        // Given
        final LinkedList<String> popQuestions = new LinkedList<>(Arrays.asList("1", "2"));
        final LinkedList<String> rockQuestions = new LinkedList<>(Arrays.asList("2", "3"));
        final LinkedList<String> sportsQuestions = new LinkedList<>(Arrays.asList("3", "4"));
        final LinkedList<String> scienceQuestions = new LinkedList<>(Arrays.asList("4", "5"));

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
        assertThat(game.getSportsQuestions()).containsExactly("4");
        assertThat(game.getScienceQuestions()).containsAll(scienceQuestions);
    }

    /**
     * Test method for {@link com.adaptionsoft.games.model.Game#askQuestion()}.
     */
    @Test
    public void askQuestion_should_remove_first_element_of_scienceQuestions_when_current_categorie_is_SCIENCE() {
        // Given
        final LinkedList<String> popQuestions = new LinkedList<>(Arrays.asList("1", "2"));
        final LinkedList<String> rockQuestions = new LinkedList<>(Arrays.asList("2", "3"));
        final LinkedList<String> sportsQuestions = new LinkedList<>(Arrays.asList("3", "4"));
        final LinkedList<String> scienceQuestions = new LinkedList<>(Arrays.asList("4", "5"));

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
        assertThat(game.getScienceQuestions()).containsExactly("5");
    }

}
