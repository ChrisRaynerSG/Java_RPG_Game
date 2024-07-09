package logTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import log.LogController;

public class LogControllerTest {

    @Test
    public void checkLoggerHasExpectedHandlerCount() {
        int handlerCount = LogController.getHandlerCount();

        Assertions.assertEquals(3,handlerCount);
    }
}
