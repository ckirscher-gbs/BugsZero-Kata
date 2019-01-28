package extension;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.ToStringBuilder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.exceptions.verification.junit.ArgumentsAreDifferent;
import org.mockito.verification.VerificationMode;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.core.Appender;

/***
 * Add "@RegisterExtension static LogVerifierExtension logVerifierExtension = new LogVerifierExtension();" in your test
 * class. <br>
 * In your test, use "logVerifierExtension.expectMessage(Level.INFO, "my message");" <br>
 * <br>
 * "@RegisterExtension" fields must not be private or null (at evaluation time) to be executed.
 * 
 * @author Céline Souchet
 */
public class LogVerifierExtension implements BeforeEachCallback, AfterTestExecutionCallback, AfterEachCallback {

    private final List<LogEvent> expectedEvents = new LinkedList<>();

    private final List<LogEvent> notExpectedEvents = new LinkedList<>();

    @Mock
    private Appender<ILoggingEvent> appender;

    private final Logger loggerToTest;

    /**
     * @param loggerToTest The logger where verify the messages
     */
    public LogVerifierExtension(final Logger loggerToTest) {
        this.loggerToTest = loggerToTest;
    }

    /**
     * @param clazz The class of the logger where verify the messages
     */
    public LogVerifierExtension(final Class<?> clazz) {
        loggerToTest = ((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger(clazz);
    }

    /**
     * To test the level of the logs
     * 
     * @param level The level to verify
     * @return {@link LogVerifierExtension} to chain the expect and notExpect methods
     */
    public LogVerifierExtension expectMessage(final Level level) {
        return expectMessage(level, "");
    }

    /**
     * To test the level of a specific log
     * 
     * @param level The level to verify
     * @param msg The message to verify
     * @return {@link LogVerifierExtension} to chain the expect and notExpect methods
     */
    public LogVerifierExtension expectMessage(final Level level, final String msg) {
        return expectMessage(level, msg, (Class<? extends Throwable>) null);
    }

    /**
     * To test the level of a specific log and an exception
     * 
     * @param level The level to verify
     * @param msg The message to verify
     * @param throwable The exception to verify
     * @return {@link LogVerifierExtension} to chain the expect and notExpect methods
     */
    public LogVerifierExtension expectMessage(final Level level, final String msg, final Throwable throwable) {
        expectedEvents.add(new LogEvent(level, msg, throwable, throwable.getClass()));
        return this;
    }

    /**
     * To test the level of a specific log and an exception
     * 
     * @param level The level to verify
     * @param msg The message to verify
     * @param throwableClass The class of the exception to verify
     * @return {@link LogVerifierExtension} to chain the expect and notExpect methods
     */
    public LogVerifierExtension expectMessage(final Level level, final String msg, final Class<? extends Throwable> throwableClass) {
        expectedEvents.add(new LogEvent(level, msg, null, throwableClass));
        return this;
    }

    /**
     * To test the level of the logs
     * 
     * @param level The level to verify
     * @return {@link LogVerifierExtension} to chain the expect and notExpect methods
     */
    public LogVerifierExtension notExpectMessage(final Level level) {
        return notExpectMessage(level, "");
    }

    /**
     * To test the level of a specific log
     * 
     * @param level The level to verify
     * @param msg The message to verify
     * @return {@link LogVerifierExtension} to chain the expect and notExpect methods
     */
    public LogVerifierExtension notExpectMessage(final Level level, final String msg) {
        return notExpectMessage(level, msg, (Class<? extends Throwable>) null);
    }

    /**
     * To test the level of a specific log and an exception
     * 
     * @param level The level to verify
     * @param msg The message to verify
     * @param throwable The exception to verify
     * @return {@link LogVerifierExtension} to chain the expect and notExpect methods
     */
    public LogVerifierExtension notExpectMessage(final Level level, final String msg, final Throwable throwable) {
        notExpectedEvents.add(new LogEvent(level, msg, throwable, throwable.getClass()));
        return this;
    }

    /**
     * To test the level of a specific log and an exception
     * 
     * @param level The level to verify
     * @param msg The message to verify
     * @param throwableClass The class of the exception to verify
     * @return {@link LogVerifierExtension} to chain the expect and notExpect methods
     */
    public LogVerifierExtension notExpectMessage(final Level level, final String msg, final Class<? extends Throwable> throwableClass) {
        notExpectedEvents.add(new LogEvent(level, msg, null, throwableClass));
        return this;
    }

    @Override
    public void beforeEach(final ExtensionContext context) throws Exception {
        validateMockitoUsage();
        initMocks(this);

        lenient().when(appender.getName()).thenReturn("MOCK");
        loggerToTest.addAppender(appender);
    }

    @Override
    public void afterTestExecution(final ExtensionContext context) throws Exception {
        verify(expectedEvents, times(1));
        verify(notExpectedEvents, never());
    }

    private void verify(final List<LogEvent> logEvents, final VerificationMode verificationMode) throws MockitoAssertionError {
        for (final LogEvent logEvent : logEvents) {
            try {
                Mockito.verify(appender, verificationMode).doAppend(argThat(argument -> logEvent.matches(argument)));
            } catch (final MockitoAssertionError e) {
                throw new MockitoAssertionError("Expected event=[" + logEvent + "] with [" + verificationMode + "] but got " + e.getMessage());
            } catch (final ArgumentsAreDifferent e) {
                final String wanted = "appender.doAppend(\n    [" + logEvent.level + "] " + logEvent.message + "\n);";
                final String actual = e.getActual();
                final ArgumentsAreDifferent exception = new ArgumentsAreDifferent(
                        "Argument(s) are different! Wanted:\n" + wanted + "\nActual invocation has different arguments:\n" + actual, wanted, actual);
                exception.setStackTrace(e.getStackTrace());
                throw exception;
            }
        }
    }

    /**
     * Callback that is invoked <em>after</em> each test has been invoked.
     *
     * @param context the current extension context; never {@code null}
     */
    @Override
    public void afterEach(final ExtensionContext context) throws Exception {
        loggerToTest.detachAppender(appender);

        expectedEvents.clear();
        notExpectedEvents.clear();
    }

    private class LogEvent {

        private final String message;
        private final Level level;
        private final Throwable throwable;
        private final Class<? extends Throwable> throwableClass;

        public LogEvent(final Level level, final String message, final Throwable throwable, final Class<? extends Throwable> throwableClass) {
            this.message = message;
            this.level = level;
            this.throwable = throwable;
            this.throwableClass = throwableClass;
        }

        boolean matches(final ILoggingEvent actual) {
            boolean match = actual.getFormattedMessage().contains(message);
            match &= actual.getLevel().equals(level);
            match &= matchThrowables(actual);
            return match;
        }

        @SuppressWarnings("unlikely-arg-type")
        private boolean matchThrowables(final ILoggingEvent actual) {
            final IThrowableProxy eventProxy = actual.getThrowableProxy();
            if (throwable == null && throwableClass == null) {
                return true;
            } else if (eventProxy != null) {
                return throwable != null && throwable.getMessage() != null && throwable.getMessage().equals(eventProxy.getMessage())
                        || throwableClass != null && throwableClass.equals(eventProxy.getClassName());
            }
            return false;
        }

        @Override
        public String toString() {
            final ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
            builder.append("message", message).append("level", level).append("throwable", throwable).append("throwableClass", throwableClass);
            return builder.toString();
        }
    }

}
