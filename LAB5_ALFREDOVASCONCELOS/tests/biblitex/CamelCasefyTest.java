package biblitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CamelCasefyTest {
    private Transformacao transformacao;

    @BeforeEach
    void peparaTransformacao() {
        transformacao = new CamelCasefy();
    }

    @Test
    void testGetNome() {
        assertEquals("CaMeLcAsEfY", this.transformacao.getNome());
    }

    @Test
    void testTransforma() {
        assertEquals("BoLo dE CeNoUrA", this.transformacao.transforma("bolo de cenoura"));
    }

    @Test
    void testCompareTo() {
        Transformacao transformacao2 = new Clean();

        assertEquals(-11, this.transformacao.compareTo(transformacao2));
    }
}
