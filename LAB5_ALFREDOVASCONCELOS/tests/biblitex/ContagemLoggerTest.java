package biblitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContagemLoggerTest {
    private Logger logger;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void preparaLog() {
        logger = new ContagemLogger();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testLogMetodoETexto() {
        logger.log("transforma","CaMeLcAsEfY");
        assertEquals("", outContent.toString());
    }

    @Test
    void testLogMetodo() {
        logger.log("listarOriginais");
        assertEquals("", outContent.toString());
    }

    @Test
    void testToString() {
        logger.log("listarOriginais");
        logger.log("transforma","pudim");
        logger.log("listarOriginais");

        assertEquals("listarOriginais - 2\ntransforma - 1\n", this.logger.toString());
    }
}
