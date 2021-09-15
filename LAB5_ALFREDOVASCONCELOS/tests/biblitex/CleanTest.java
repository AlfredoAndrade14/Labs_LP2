package biblitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CleanTest {
    private Transformacao transformacao;

    @BeforeEach
    void peparaTransformacao() {
        transformacao = new Clean();
    }

    @Test
    void testGetNome() {
        assertEquals("clean", this.transformacao.getNome());
    }

    @Test
    void testTransforma() {
        assertEquals("bolo de cenoura", this.transformacao.transforma("bolo, de cenoura!"));
    }

    @Test
    void testCompareTo() {
        Transformacao transformacao2 = new CleanSpaces();

        assertEquals(-6, this.transformacao.compareTo(transformacao2));
    }
}
