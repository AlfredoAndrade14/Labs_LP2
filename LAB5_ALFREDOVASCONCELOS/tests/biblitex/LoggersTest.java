package biblitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggersTest {
    private TransformaTexto tt;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testConsoleLoggerMetodoETexto() {
        Logger consoleLogger = new ConsoleLogger();
        tt = new TransformaTexto(consoleLogger);
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");

        assertEquals("[transforma] CaMeLcAsEfY" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testConsoleLoggerMetodo() {
        Logger consoleLogger = new ConsoleLogger();
        tt = new TransformaTexto(consoleLogger);
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");
        this.tt.listarOriginais();

        assertEquals("[transforma] CaMeLcAsEfY" + System.lineSeparator() + "[listarOriginais]" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testContagemLoggerMetodoETexto() {
        Logger consoleLogger = new ContagemLogger();
        tt = new TransformaTexto(consoleLogger);
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");
        assertEquals("", outContent.toString());
    }

    @Test
    void testContagemLoggerMetodo() {
        Logger consoleLogger = new ContagemLogger();
        tt = new TransformaTexto(consoleLogger);
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");
        this.tt.contaTransformacao();

        assertEquals("", outContent.toString());
    }

    @Test
    void testContagemLoggerToString() {
        Logger consoleLogger = new ContagemLogger();
        tt = new TransformaTexto(consoleLogger);
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");
        this.tt.contaTransformacao();
        this.tt.transforma("clean", "Olá, tudo bem?");
        this.tt.historico(0);

        assertEquals("historico - 1\ncontaTransformacao - 1\ntransforma - 2\n", consoleLogger.toString());
    }

    @Test
    void testBreakpointLoggerMetodoETextoSemOMetodoEspecifico() {
        Logger breakpointLogger = new BreakpointLogger("historico");
        tt = new TransformaTexto(breakpointLogger);
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");

        assertEquals("", outContent.toString());
    }

    @Test
    void testBreakpointLoggerMetodoETextoComOMetodoEspecifico() {
        Logger breakpointLogger = new BreakpointLogger("contaTransformacao");
        tt = new TransformaTexto(breakpointLogger);
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");
        this.tt.historico(0);

        assertEquals("", outContent.toString());
    }

    @Test
    void testBreakpointLoggerMetodoSemOMetodoEspecifico() {
        Logger breakpointLogger = new BreakpointLogger("contaTransformacao");
        tt = new TransformaTexto(breakpointLogger);
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");
        this.tt.listarOriginais();

        assertEquals("", outContent.toString());
    }

    @Test
    void testBreakpointLoggerMetodoComOMetodoEspecifico() {
        Logger breakpointLogger = new BreakpointLogger("contaTransformacao");
        tt = new TransformaTexto(breakpointLogger);
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");
        this.tt.contaTransformacao();

        assertEquals("[INVOCADO - contaTransformacao]" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testTimeConsoleLoggerMetodoETexto() {
        Logger timeConsoleLogger = new TimeConsoleLogger();
        tt = new TransformaTexto(timeConsoleLogger);
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");

        assertTrue(outContent.toString().contains("[transforma - ") && outContent.toString().contains("ms] CaMeLcAsEfY"));
    }

    @Test
    void testTimeConsoleLoggerMetodo() {
        Logger timeConsoleLogger = new TimeConsoleLogger();
        tt = new TransformaTexto(timeConsoleLogger);
        this.tt.transforma("CaMeLcAsEfY", "Olá, tudo bem?");
        this.tt.listarOriginais();

        assertTrue(outContent.toString().contains("[listarOriginais - ") && outContent.toString().contains("ms]"));
    }
}
