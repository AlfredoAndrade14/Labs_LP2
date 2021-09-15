package biblitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CleanSpacesTest {
    private Transformacao transformacao;

    @BeforeEach
    void peparaTransformacao() {
        transformacao = new CleanSpaces();
    }

    @Test
    void testGetNome() {
        assertEquals("cleanSpaces", this.transformacao.getNome());
    }

    @Test
    void testTransforma() {
        assertEquals("bolodecenoura", this.transformacao.transforma("bolo de cenoura"));
    }

    @Test
    void testCompareTo() {
        Transformacao transformacao2 = new InterrogaPraPontos();

        assertEquals(-6, this.transformacao.compareTo(transformacao2));
    }
}
