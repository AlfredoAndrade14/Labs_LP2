package biblitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveVogaisTest {

    private Transformacao transformacao;

    @BeforeEach
    void peparaTransformacao() {
        transformacao = new RemoveVogais();
    }

    @Test
    void testGetNome() {
        assertEquals("RemoveVogais", this.transformacao.getNome());
    }

    @Test
    void testTransforma() {
        assertEquals("bl d cnr", this.transformacao.transforma("bolo de cenoura"));
    }

    @Test
    void testCompareTo() {
        Transformacao transformacao2 = new Clean();

        assertEquals(15, this.transformacao.compareTo(transformacao2));
    }
}
