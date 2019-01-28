package com.adaptionsoft.games.trivia.runner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import extension.TestStatusLoggerExtension;
import lombok.Cleanup;

@ExtendWith({ TestStatusLoggerExtension.class })
public class GameRunnerIT {

    @Test
    public void itsLockedDown() throws IOException, URISyntaxException {
        // Given
        final Random randomizer = new Random(123455);
        @Cleanup
        final ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultStream));

        // When
        IntStream.range(1, 15).forEach(i -> GameRunner.playGame(randomizer));

        // Then
        final Path path = Paths.get(getClass().getResource("GameTest.itsLockedDown.expected.txt").toURI());
        @Cleanup
        final Stream<String> lines = Files.lines(path);
        final String expected = lines.collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator();
        assertEquals(expected, resultStream.toString());
    }

}
