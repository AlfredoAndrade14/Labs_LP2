package biblitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpperCaseTest {

    private Transformacao transformacao;

    @BeforeEach
    void peparaTransformacao() {
        transformacao = new UpperCase();
    }

    @Test
    void testGetNome() {
        assertEquals("upperCase", this.transformacao.getNome());
    }

    @Test
    void testTransforma() {
        assertEquals("BOLO DE CENOURA", this.transformacao.transforma("bolo de cenoura"));
    }

    @Test
    void testCompareTo() {
        Transformacao transformacao2 = new Clean();

        assertEquals(18, this.transformacao.compareTo(transformacao2));
    }
}
