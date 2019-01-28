package com.adaptionsoft.games.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Pop");
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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Science");
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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Sports");
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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Rock");
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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Pop");
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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Science");
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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Sports");
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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Rock");
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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Pop");
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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Science");
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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Sports");
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
        final String result = game.currentCategory();

        // Then
        assertThat(result).isEqualTo("Rock");
    }

}
