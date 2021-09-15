package biblitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterrogaPraPontoTest {
    private Transformacao transformacao;

    @BeforeEach
    void peparaTransformacao() {
        transformacao = new InterrogaPraPontos();
    }

    @Test
    void testGetNome() {
        assertEquals("InterrogaPraPontos", this.transformacao.getNome());
    }

    @Test
    void testTransforma() {
        assertEquals("bolo de cenoura. ou bolo de chocolate.", this.transformacao.transforma("bolo de cenoura? ou bolo de chocolate?"));
    }

    @Test
    void testCompareTo() {
        Transformacao transformacao2 = new Clean();

        assertEquals(6, this.transformacao.compareTo(transformacao2));
    }
}
