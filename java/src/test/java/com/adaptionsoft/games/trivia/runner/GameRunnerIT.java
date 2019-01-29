package com.adaptionsoft.games.trivia.runner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import extension.LogVerifierExtension;
import extension.TestStatusLoggerExtension;
import lombok.Cleanup;

@ExtendWith({ TestStatusLoggerExtension.class })
public class GameRunnerIT {

    private static final Logger GAME_RUNNER_LOGGER = ((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger(GameRunner.class);

    // @RegisterExtension fields must not be private or null (at evaluation time) to be executed
    @RegisterExtension
    static final LogVerifierExtension logVerifierExtension = new LogVerifierExtension(GAME_RUNNER_LOGGER);

    @Test
    public void itsLockedDown() throws IOException, URISyntaxException {
        // Given
        final Random randomizer = new Random(123455);

        // Then
        final Path path = Paths.get(getClass().getResource("GameRunnerIT.itsLockedDown.expected.txt").toURI());
        @Cleanup
        final Stream<String> lines = Files.lines(path);
        lines.forEach(line -> logVerifierExtension.expectMessage(Level.INFO, line));

        // When
        IntStream.range(1, 15).forEach(i -> GameRunner.playGame(randomizer));
    }

}
