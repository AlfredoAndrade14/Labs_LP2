package biblitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleLoggerTest {
    private Logger logger;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void preparaLog() {
        logger = new ConsoleLogger();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testLogMetodoETexto() {
        this.logger.log("transforma","CaMeLcAsEfY");
        assertEquals("[transforma] CaMeLcAsEfY" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testLogMetodo() {
        this.logger.log("listarOriginais");
        assertEquals("[listarOriginais]" + System.lineSeparator(), outContent.toString());
    }
}
