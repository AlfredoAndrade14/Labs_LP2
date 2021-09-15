package biblitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeConsoleLoggerTest {
    private Logger logger;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void preparaLog() {
        logger = new TimeConsoleLogger();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testLogMetodoETexto() {
        this.logger.log("transforma","CaMeLcAsEfY");
        assertTrue(outContent.toString().contains("[transforma - ") && outContent.toString().contains("ms] CaMeLcAsEfY"));
    }

    @Test
    void testLogMetodo() {
        this.logger.log("listarOriginais");
        assertTrue(outContent.toString().contains("[listarOriginais - ")&& outContent.toString().contains("ms]"));
    }
}
