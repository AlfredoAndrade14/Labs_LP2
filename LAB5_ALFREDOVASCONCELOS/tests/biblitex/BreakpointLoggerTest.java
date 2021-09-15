package biblitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreakpointLoggerTest {
    private Logger logger1;
    private Logger logger2;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void preparaLog() {
        logger1 = new BreakpointLogger("transforma");
        logger2 = new BreakpointLogger("listarOriginais");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testLogMetodoETextoComOMetodoEspecifico() {
        this.logger1.log("transforma", "CaMeLcAsEfY");
        assertEquals("[INVOCADO - transforma] CaMeLcAsEfY" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testLogMetodoETextoSemOMetodoEspecifico() {
        this.logger1.log("historico", "0");
        assertEquals("", outContent.toString());
    }

    @Test
    void testLogMetodoComOMetodoEspecifico() {
        this.logger2.log("listarOriginais");
        assertEquals("[INVOCADO - listarOriginais]" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testLogMetodoSemOMetodoEspecifico() {
        this.logger2.log("listarTransformacoes");
        assertEquals("", outContent.toString());
    }
}
