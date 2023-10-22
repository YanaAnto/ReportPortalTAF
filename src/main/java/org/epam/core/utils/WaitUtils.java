package org.epam.core.utils;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.awaitility.core.ConditionFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WaitUtils {

    public static final int ONE_SECOND = 1;
    public static final int THIRTY_SECONDS = 30;

    public static ConditionFactory kindlyWait(int seconds) {
        return kindlyWait(seconds, SECONDS);
    }

    public static ConditionFactory kindlyWait(int duration, TimeUnit timeUnit) {
        return await().atMost(duration, timeUnit)
            .pollInterval(Duration.ofSeconds(ONE_SECOND))
            .pollInSameThread();
    }
}
